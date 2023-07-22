package net.royal.asistencia.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.sistema.dominio.dto.DtoDwWhDocumentoarchivoList;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@ManagedBean
@ViewScoped
public class CwWhDocumentoArchivoList extends CBaseBean implements UIMantenimientoController {

	private static final long serialVersionUID = 1L;
	private Integer iv_linea;
	private String iv_companiasocio, iv_tipodocumento, iv_numerodocumento;

	private List<DtoDwWhDocumentoarchivoList> dw_1;
	private List<DtoDwWhDocumentoarchivoList> dw_1filtrado;
	private DtoDwWhDocumentoarchivoList documento;

	private UploadedFile fileUpload;
	private StreamedContent fileDownload;

	private HashMap<String, Object> param;

	private Boolean islistado;
	private Boolean ismodificable;
	private Boolean isrequierecomentario = true;
	private Boolean isIformeFinal = true;
	private String tamanioArchivo = "";
	private Integer tamanioBytes;

	public static CwWhDocumentoArchivoList getInstance() {
		;
		return UFaces.evaluateExpressionGet("#{cwWhDocumentoArchivoList}", CwWhDocumentoArchivoList.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();

		documento = new DtoDwWhDocumentoarchivoList();

		isrequierecomentario = true;
		isIformeFinal = true;

		if (UValidador.esListaVacia(dw_1)) {
			dw_1 = new ArrayList<>();
		}

		dw_1filtrado = new ArrayList<DtoDwWhDocumentoarchivoList>();
		dw_1filtrado.addAll(dw_1);

		iv_linea = (Integer) param.get("w_str_passlo");
		if (UValidador.esNulo(iv_linea)) {
			iv_linea = 0;
		}

		if (!UValidador.esListaVacia(dw_1)) {
			iv_companiasocio = dw_1.get(0).getCompaniasocio();
			iv_tipodocumento = dw_1.get(0).getTipodocumento();
			iv_numerodocumento = dw_1.get(0).getNumerodocumento();
		}

		dw_1filtrado.clear();
		for (DtoDwWhDocumentoarchivoList obj : dw_1) {
			if (((Integer) obj.getLinea().intValue()).equals(iv_linea)) {
				dw_1filtrado.add(obj);
			}
		}

		getWebControlContext().actualizar("dgSelectorArchivo");
		getWebControlContext().ejecutar("PF('popSelectorArchivo').show()");

		return null;
	}

	@Override
	public String buscar() throws Exception {
		return null;
	}

	@Override
	public String nuevo() throws Exception {

		inicializarFiltrosListado();
		documento = new DtoDwWhDocumentoarchivoList();
		fileUpload = null;

		getWebControlContext().actualizar("dgDocumento");
		getWebControlContext().ejecutar("PF('popDocumento').show()");

		return null;
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
		LOGGER.debug("eliminar()");
		dw_1filtrado.remove(documento);
		dw_1.remove(documento);

		getWebControlContext().actualizar("wwhdocumentoarchivolist:tblDocumentosRequisicion");
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
		Map<String, Object> param = new HashMap<String, Object>();
		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, this.getNombreTipoBusqueda());
		param.put("documentos", dw_1);

		mensajeGenerico.setParametros(param);

		LOGGER.debug("controller : " + getiMantenimientoReferencia());
		LOGGER.debug("nombrebusqueda : " + getNombreTipoBusqueda());

		this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

		getWebControlContext().ejecutar("PF('popSelectorArchivo').hide();");

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

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public String insertarArchivoExterno() throws Exception {
		LOGGER.debug("insertarArchivoExterno()");
		if (UValidador.esNulo(fileUpload)) {
			setMessageError("No se encuentra el archivo");
			return null;
		}

		String extension = FilenameUtils.getExtension(fileUpload.getFileName());

		File file = new File(UAplicacion.getRealPath() + File.separator + "temporaloefa" + File.separator
				+ fileUpload.getFileName());
		FileUtils.writeByteArrayToFile(file, fileUpload.getContents());

		documento.setExtension(extension);
		// String ruta= new
		// UFile().cargarArchivoXByteTemporal(fileUpload.getContents(),
		// fileUpload.getFileName(),"temporaloefa");
		documento.setRuta(file.getAbsolutePath());
		//documento.setArchivodata(fileUpload.getContents());

		Map<String, Object> param = new HashMap<String, Object>();
		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, this.getNombreTipoBusqueda());
		param.put("documento", documento);

		mensajeGenerico.setParametros(param);

		LOGGER.debug("controller : " + getiMantenimientoReferencia());
		LOGGER.debug("nombrebusqueda : " + getNombreTipoBusqueda());

		this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

		getWebControlContext().ejecutar("PF('popDocumento').hide();");
		getWebControlContext().actualizar(this.getNombreContenedorRefrescar());
		return null;

	}

	public String insertarArchivo() {

		LOGGER.debug("insertarArchivo()");

		if (UValidador.esNulo(fileUpload)) {
			setMessageError("No se encuentra el archivo");
			return null;
		}

		String extension = fileUpload.getFileName().substring(fileUpload.getFileName().lastIndexOf(".") + 1,
				fileUpload.getFileName().length());

		// GRABA EL ARCHIVO FISICO
		documento.setCompaniasocio(iv_companiasocio);
		documento.setLinea(BigDecimal.valueOf(iv_linea));
		documento.setNumerodocumento(iv_numerodocumento);
		documento.setSecuencia(BigDecimal.valueOf(dw_1filtrado.size() + 1));
		documento.setTipodocumento(iv_tipodocumento);
		documento.setExtension(extension);

		dw_1.add(documento);
		dw_1filtrado.add(documento);

		// registra el docuento y genera la estructura en el repositorio

		getWebControlContext().ejecutar("PF('popDocumento').hide();");
		getWebControlContext().actualizar(this.getNombreContenedorRefrescar());

		return null;
	}

	public void handleFileUpload(FileUploadEvent event) {
		LOGGER.debug("handle documento : " + event.getFile());
		fileUpload = event.getFile();
		documento.setArchivo(fileUpload.getFileName());
		getWebControlContext().actualizar("frmDocumentoSelectorEmergente");
	}

	public String descargar() {
		InputStream stream;

		byte[] bytes = new byte[1024];

		// bytes = documento.getArchivodata();

		stream = new ByteArrayInputStream(bytes);

		fileDownload = new DefaultStreamedContent(stream, "image/jpg", documento.getArchivo());

		getWebControlContext().ejecutar("document.getElementById('wwhdocumentoarchivolist:btnDownload').click();");

		LOGGER.debug("fileDownload " + fileDownload);

		return null;
	}

	/**
	 * @return the param
	 */
	public HashMap<String, Object> getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(HashMap<String, Object> param) {
		this.param = param;
	}

	/**
	 * @return the dw_1
	 */
	public List<DtoDwWhDocumentoarchivoList> getDw_1() {
		return dw_1;
	}

	/**
	 * @param dw_1
	 *            the dw_1 to set
	 */
	public void setDw_1(List<DtoDwWhDocumentoarchivoList> dw_1) {
		this.dw_1 = dw_1;
	}

	/**
	 * @return the dw_1filtrado
	 */
	public List<DtoDwWhDocumentoarchivoList> getDw_1filtrado() {
		return dw_1filtrado;
	}

	/**
	 * @param dw_1filtrado
	 *            the dw_1filtrado to set
	 */
	public void setDw_1filtrado(List<DtoDwWhDocumentoarchivoList> dw_1filtrado) {
		this.dw_1filtrado = dw_1filtrado;
	}

	/**
	 * @return the documento
	 */
	public DtoDwWhDocumentoarchivoList getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(DtoDwWhDocumentoarchivoList documento) {
		this.documento = documento;
	}

	/**
	 * @return the fileUpload
	 */
	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	/**
	 * @param fileUpload
	 *            the fileUpload to set
	 */
	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	/**
	 * @return the fileDownload
	 */
	public StreamedContent getFileDownload() {
		return fileDownload;
	}

	/**
	 * @param fileDownload
	 *            the fileDownload to set
	 */
	public void setFileDownload(StreamedContent fileDownload) {
		this.fileDownload = fileDownload;
	}

	/**
	 * @return the islistado
	 */
	public Boolean getIslistado() {
		return islistado;
	}

	/**
	 * @param islistado
	 *            the islistado to set
	 */
	public void setIslistado(Boolean islistado) {
		this.islistado = islistado;
	}

	/**
	 * @return the isrequierecomentario
	 */
	public Boolean getIsrequierecomentario() {
		return isrequierecomentario;
	}

	/**
	 * @param isrequierecomentario
	 *            the isrequierecomentario to set
	 */
	public void setIsrequierecomentario(Boolean isrequierecomentario) {
		this.isrequierecomentario = isrequierecomentario;
	}

	/**
	 * @return the ismodificable
	 */
	public Boolean getIsmodificable() {
		return ismodificable;
	}

	/**
	 * @param ismodificable
	 *            the ismodificable to set
	 */
	public void setIsmodificable(Boolean ismodificable) {
		this.ismodificable = ismodificable;
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

	public Boolean getIsIformeFinal() {
		return isIformeFinal;
	}

	public void setIsIformeFinal(Boolean isIformeFinal) {
		this.isIformeFinal = isIformeFinal;
	}

}
