package net.royal.comun.vista.controladora;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@ViewScoped
@ManagedBean
public class CVideos extends CBaseBean {

	private DtoVideos videos, videos1, videos2;
	private DtoVideos archivoSeleccionado;
	private List<DtoVideos> lstVideos;
	private String key;
	private String ws;
	private UploadedFile fileUpload;

	public void iniciarControladora() {
		videos = new DtoVideos();
		lstVideos = new ArrayList<DtoVideos>();
		videos.setId(1);
		videos.setKey("312a5762-a2d5-4443-bfa1-e4af881c299b");
		videos.setNombre("Consultas Planillas Web.mp4");
		lstVideos.add(videos);

		videos1 = new DtoVideos();
		videos1.setId(2);
		videos1.setKey("56196d65-366b-43b1-b399-303cbd3c0af6");
		videos1.setNombre("Control de Asistencia.mp4");
		lstVideos.add(videos1);

		videos2 = new DtoVideos();
		videos2.setId(3);
		videos2.setKey("efe50d59-13ac-4d53-9642-9bca1db1c23a");
		videos2.setNombre("RRHH Web.mp4");
		lstVideos.add(videos2);

		getWebControlContext().ejecutar("PF('popdgVideos').show();");
	}

	private String obtenerParametroModoArchivo() {
		String modo = ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD;
		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "MODOARCHIV");
		String param = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(pk);
		if (!UValidador.estaVacio(param)) {
			modo = param;
		} else {
			this.setMessageInfo("No se encontró el parámetro MODOARCHIV. Se tomó valor por defecto");
		}

		key = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "KEYALFRESC"));
		ws = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "WSALFRESCO"));
		return modo;
	}

	public String verDocumento() throws Exception {
		String archivo = archivoSeleccionado.getNombre();

		if (!UValidador.esNulo(archivoSeleccionado.getKey())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = UOefaAlfresco.obtenerDocumento(archivoSeleccionado.getKey(),
							key);
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						new UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(), archivo, "temporaloefa");
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}

				break;
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD:
				this.setMessageError("Te encuentras en modo base de datos");
				return null;
			}
		} else {
			setMessageError("No ha seleccionado ningún archivo");
			return null;
		}

		setSessionValue("nombrearchivo", archivo);

		return "documentos";
	}

	public List<DtoVideos> getLstVideos() {
		return lstVideos;
	}

	public void setLstVideos(List<DtoVideos> lstVideos) {
		this.lstVideos = lstVideos;
	}

	public DtoVideos getArchivoSeleccionado() {
		return archivoSeleccionado;
	}

	public void setArchivoSeleccionado(DtoVideos archivoSeleccionado) {
		this.archivoSeleccionado = archivoSeleccionado;
	}

	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}

}
