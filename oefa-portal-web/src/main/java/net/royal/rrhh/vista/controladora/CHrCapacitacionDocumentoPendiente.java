package net.royal.rrhh.vista.controladora;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;

import net.royal.alfresco.ws.RptaWsBean;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@SessionScoped
@ManagedBean
public class CHrCapacitacionDocumentoPendiente extends CBaseBean implements UIMantenimientoController {

	private static final long serialVersionUID = 1L;

	private LazyDataModel<HrCapacitacion> lstDatos;
	private HrCapacitacion registroSeleccionado;

	private HrEmpleadocapaDocumento bean;

	private int tipodocumento;
	private String tamanioArchivo = "";
	private Integer tamanioBytes;

	private String key;

	private String ws;
	private Integer cantDias;

	public static CHrCapacitacionDocumentoPendiente getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrCapacitacionDocumentoPendiente}",
				CHrCapacitacionDocumentoPendiente.class);
	}

	public CHrCapacitacionDocumentoPendiente() {
		this.PANTALLA_LISTADO = "cursosempleado";
		this.PANTALLA_MANTENIMIENTO = "";
	}

	public String iniciar(int tipodoc) throws Exception {
		tipodocumento = tipodoc;
		return this.iniciarControladora();
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		return null;
	}

	public Integer retornaNotificaciones1() throws Exception {
		return 0;
	}

	public Integer retornaNotificaciones2() throws Exception {
		LOGGER.debug("Buscando notificaciones de informe en capacitaciones");
		tipodocumento = 2;
		this.inicializarFiltrosListado();

		Integer res;

		List<HrEmpleadocapacitacion> cantidadSinInforme = this.getFacRrhh().getHrEmpleadocapacitacionServicio()
				.contarCapacitacionDocumentoPendiente(this.getUsuarioActual().getIdPersona(), cantDias);
		res = 0;
		for (HrEmpleadocapacitacion obj : cantidadSinInforme) {
			if (UValidador.esNulo(obj.getFlgadjuntoinformfinal())) {
				res++;
			} else {
				Integer cantDocumentos = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio()
						.obtenerCantDocumentos(obj.getEmpleado().intValue(), obj.getCapacitacion(), null);

				if (cantDocumentos < 2) {
					res++;
				}
			}

		}

		return res;
	}

	@Override
	public String nuevo() throws Exception {
		LOGGER.debug("NUEVO!");
		bean = new HrEmpleadocapaDocumento();
		this.getBindingController().setAuditoriaNuevo();

		return null;
	}

	public void handleFileUpload(FileUploadEvent event) throws Exception {
		LOGGER.debug("handle file upload");
		LOGGER.debug(bean);
		bean.setNombrearchivo(FilenameUtils.getBaseName(event.getFile().getFileName()));
		String extension = FilenameUtils.getExtension(event.getFile().getFileName());
		bean.setExtension(extension);
		// bean.setArchivo(event.getFile().getContents());

		String ruta = new UFile().cargarArchivoXByteTemporal(event.getFile().getContents(),
				event.getFile().getFileName(), "temporaloefa");
		bean.setRutaArchivo(ruta);
		this.getWebControlContext().actualizar("frmDocumentoEdicion:itNombreArch");
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

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public String ver() throws Exception {
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		return null;
	}

	@Override
	public String guardar() throws Exception {

		switch (obtenerParametroModoArchivo()) {
		case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

			if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
				this.setMessageError("No se encontraron los parametros key o ws");
				return null;
			}
			try {
				LOGGER.debug("Archivo a guardar " + bean.getNombrearchivo() + "." + bean.getExtension());
				RptaWsBean respuestaws = UOefaAlfresco.registrarDocumento(
						bean.getNombrearchivo() + "." + bean.getExtension(), UOefaAlfresco.RUTA_DOCUMENTO_CAPACITACION
								+ bean.getPk().getEmpleado() + "/" + bean.getPk().getCapacitacion(),
						UFile.obtenerArregloByte(bean.getRutaArchivo()), key);
				LOGGER.debug(respuestaws);
				System.gc();
				if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
					bean.setUuidalfresco(respuestaws.getUuid());
					UFile.borrarArchivoTemporal(bean.getRutaArchivo());
				} else {
					this.setMessageError(respuestaws.getCadMsg());
					return null;
				}
			} catch (Exception e) {
				this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
				return null;
			}

		}

		List<MensajeUsuario> mensajes = this.getFacRrhh().getHrEmpleadocapacitacionServicio()
				.ingresarDocumentoPendiente(registroSeleccionado, this.getUsuarioActual(), tipodocumento, bean);

		if (!UValidador.esListaVacia(mensajes)) {
			this.setListaMensajeUsuario(mensajes);
			this.mostrarMensajesUsuario();
		} else {
			this.setMessageSuccess("Se adjuntó correctamente");
		}
		buscar();

		this.getWebControlContext().ejecutar("PF('popDocumentosEdicion').hide();");
		this.getWebControlContext().actualizar("frmCapacitacionDocPen:dtCapacitacionDocPen");

		return null;
	}

	@Override
	public String salir() throws Exception {
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		BigDecimal tamArchivo = new BigDecimal(2);

		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "TAMAARCH");
		Integer tamanioMB = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(pk);

		if (UValidador.esNulo(tamanioMB)) {
			tamanioMB = 2;
		}

		tamArchivo = new BigDecimal(tamanioMB).multiply(new BigDecimal(1024));
		tamArchivo = tamArchivo.multiply(new BigDecimal(1024));

		tamanioBytes = tamArchivo.intValue();
		tamanioArchivo = tamanioMB.toString() + " MB";

		cantDias = this.getFacCore().getParametrosmastServicio()
				.obtenerValorInteger(new ParametrosmastPk("HR", "999999", "CANTDIAS"));

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public LazyDataModel<HrCapacitacion> getLstDatos() {
		return lstDatos;
	}

	public void setLstDatos(LazyDataModel<HrCapacitacion> lstDatos) {
		this.lstDatos = lstDatos;
	}

	public HrCapacitacion getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrCapacitacion registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public int getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(int tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public HrEmpleadocapaDocumento getBean() {
		return bean;
	}

	public void setBean(HrEmpleadocapaDocumento bean) {
		this.bean = bean;
	}

	/**
	 * @return the tamanioArchivo
	 */
	public String getTamanioArchivo() {
		return tamanioArchivo;
	}

	/**
	 * @param tamanioArchivo
	 *            the tamanioArchivo to set
	 */
	public void setTamanioArchivo(String tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

	/**
	 * @return the tamanioBytes
	 */
	public Integer getTamanioBytes() {
		return tamanioBytes;
	}

	/**
	 * @param tamanioBytes
	 *            the tamanioBytes to set
	 */
	public void setTamanioBytes(Integer tamanioBytes) {
		this.tamanioBytes = tamanioBytes;
	}

}
