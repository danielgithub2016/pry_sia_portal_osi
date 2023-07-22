package net.royal.firmadigital.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.documento.dominio.dto.DtoElementoArbol;
import net.royal.erp.documento.dominio.dto.DtoFirmaContenedor;
import net.royal.erp.documento.dominio.dto.DtoFirmaElemento;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * @author valenzuelad
 *
 */
@ManagedBean
@ViewScoped
public class CDocumentoMantenimiento extends CBaseBean implements UIMantenimientoController {

	// Icono por defecto cuando no se le ha asignado un icono al repositorio.
	private static final String RUTA_TEMPORAL = UAplicacion.getServletContext().getRealPath("/")
			+ java.io.File.separator + "temporal" + java.io.File.separator;

	// Objeto que representa los datos del archivo (bytes,nombre,tamanio,etc)
	private UploadedFile fileUpload;

	// Identificador el tamaño máximo de archivo en texto
	private String tamanioArchivo = "";

	// Identificador el tamaño máximo de archivo por repositorio
	private Integer tamanioBytes;

	// Nombre de archivo para la vista previa
	private String nombreArchivo;

	// Fag para mostrar el documento como vista previa.
	private Boolean isVistaPrevia;

	private DtoFirmaContenedor contenedorFirma;

	private String rutabase;

	private String urlWeb;

	private String nombreArchivoFirmado;

	@PostConstruct
	public void init() {
		LOGGER.debug("====INIT FIRMA DIGITAL");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map params = externalContext.getRequestParameterMap();
		try {
			nuevo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String iniciarControladora() throws Exception {

		return null;
	}

	public static CDocumentoMantenimiento getInstance() {
		FacesContext context = FacesContext.getCurrentInstance();
		CDocumentoMantenimiento cDocumentoMantenimiento = (CDocumentoMantenimiento) context.getApplication()
				.evaluateExpressionGet(context, "#{cDocumentoMantenimiento}", CDocumentoMantenimiento.class);
		return cDocumentoMantenimiento;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("nuevo()");

		urlWeb = getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SY", "999999", "URLWEBFD"));

		nombreArchivo = null;

		rutabase = RUTA_TEMPORAL;

		setAccionPantalla(accion_solicitada.NUEVO);
		setPantallaTituloAccion(getAccionPantalla().toString());

		inicializarDatosMantenimiento();

		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub

		getWebControlContext().ejecutar("PF('popDocumentoFirma').show()");
		getWebControlContext().actualizar("dgDocumentoFirma");

		return null;
	}

	@Override
	public String ver() throws Exception {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

		try {
			byte[] archivo = UFile.obtenerArregloByte(RUTA_TEMPORAL + File.separator + nombreArchivoFirmado);

			if (!UValidador.esNulo(archivo)) {
				UFile.verArchivo(archivo, nombreArchivoFirmado, response);
			} else {
				setMessageError("No se pudo obtener el documento");
			}

			facesContext.responseComplete();

		} catch (Exception e) {
			setMessageError("Ocurrió un error al Previsualizar el archivo");
			return null;
		}

		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		if (net.royal.framework.web.core.UValidador.esNulo(fileUpload)) {
			setMessageError("No se encuentra el archivo");
			return null;
		}

		getWebControlContext().ejecutar("PF('popDocumentoFirma').hide();");

		return null;
	}

	@Override
	public String salir() throws Exception {
		return null;

	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		BigDecimal tamArchivo = new BigDecimal(2);

		tamArchivo = tamArchivo.multiply(new BigDecimal(1024));

		tamanioBytes = tamArchivo.intValue();
		return null;
	}

	public String guardarFirmar() throws Exception {

		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			if (net.royal.framework.web.core.UValidador.esNulo(fileUpload)) {
				setMessageError("Debe seleccionar un archivo.");
				return null;
			}
		}

		iniciarFirmaDigital("OEFA");

		return null;
	}

	public String iniciarFirmaDigital(String uuid) throws Exception {

		// Creamos un objeto DtoElementoArbol, para la firma digital
		DtoElementoArbol objfirma = new DtoElementoArbol();
		objfirma.setUuid(uuid);
		objfirma.setNombre(fileUpload.getFileName());
		List<DtoElementoArbol> lstElementosFirma = new ArrayList<>();
		lstElementosFirma.add(objfirma);

		contenedorFirma = new DtoFirmaContenedor();

		if (!UValidador.esListaVacia(lstElementosFirma)) {

			for (DtoElementoArbol obj : lstElementosFirma) {
				if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
					if (!UValidador.esNulo(fileUpload.getContents())) {
						UFile.crearArchivoPorRutaTemporal(RUTA_TEMPORAL, obj.getIdUnicoDocumento(),
								fileUpload.getContents());
					}
				}

			}

			contenedorFirma.setListaElementosFirmar(obtenerDocumentosFirma(lstElementosFirma));
			CDocumentoFirmaDigital.getInstance().setContenedor(contenedorFirma);
			CDocumentoFirmaDigital.getInstance().iniciarControladora();

		}

		return null;
	}

	// Este método genera una lista de documentos firmados en base a los
	// documentos selecionados desde el explorador.
	// La estructura DtoElementoFirma es compatible con el gestor de firma
	// digital.
	private List<DtoFirmaElemento> obtenerDocumentosFirma(List<DtoElementoArbol> lstElementosSeleccionados) {
		// TODO Auto-generated method stub
		List<DtoFirmaElemento> resultado = new ArrayList<>();

		if (!UValidador.esListaVacia(lstElementosSeleccionados)) {
			for (DtoElementoArbol obj : lstElementosSeleccionados) {
				DtoFirmaElemento objfir = new DtoFirmaElemento();
				// para generar el nombre para la firma solo trbajaremos con la
				// uuid
				objfir.setIdDocumento(obj.getUuid());
				objfir.setFlgFirmoElemento(UConstante.CONSTANTE_OPCION_NO);
				objfir.setNombreArchivo(obj.getNombre());
				resultado.add(objfir);
			}
		}

		return resultado;
	}

	public void handleFileUpload(FileUploadEvent event) throws Exception {
		LOGGER.debug("handle documento : " + event.getFile());

		fileUpload = event.getFile();
		nombreArchivo = fileUpload.getFileName();

		nombreArchivoFirmado = UFile.archivoUnico() + "_" + nombreArchivo.replace(".pdf", "") + "_firmado.pdf";
		iniciarFirmaDigital(UFile.archivoUnico());

	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getTamanioArchivo() {
		return tamanioArchivo;
	}

	public void setTamanioArchivo(String tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

	public Integer getTamanioBytes() {
		return tamanioBytes;
	}

	public void setTamanioBytes(Integer tamanioBytes) {
		this.tamanioBytes = tamanioBytes;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Boolean getIsVistaPrevia() {
		return isVistaPrevia;
	}

	public void setIsVistaPrevia(Boolean isVistaPrevia) {
		this.isVistaPrevia = isVistaPrevia;
	}

	public DtoFirmaContenedor getContenedorFirma() {
		return contenedorFirma;
	}

	public void setContenedorFirma(DtoFirmaContenedor contenedorFirma) {
		this.contenedorFirma = contenedorFirma;
	}

	public String getRutabase() {
		return rutabase;
	}

	public void setRutabase(String rutabase) {
		this.rutabase = rutabase;
	}

	public String getUrlWeb() {
		return urlWeb;
	}

	public void setUrlWeb(String urlWeb) {
		this.urlWeb = urlWeb;
	}
	

}