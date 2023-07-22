package net.royal.firmadigital.vista.controladora;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.documento.dominio.dto.DtoFirmaContenedor;
import net.royal.erp.documento.dominio.dto.DtoFirmaElemento;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * @author valenzuelad
 *
 */
@ManagedBean
@ViewScoped
public class CDocumentoFirmaDigital extends CBaseBean implements UIMantenimientoController {

	// Objeto que representa el contenedor de objetos para la firma digital.
	private DtoFirmaContenedor contenedor;

	// Objeto que representa el documento firmado y seleccionado actualmente.
	private DtoFirmaElemento documento;

	// Cadena que representa los documentos a firmar concatenados
	private String documentosSinFirmar;

	@Override
	public String iniciarControladora() throws Exception {

		this.setAccionPantalla(accion_solicitada.LISTAR);

//		contenedor.setUrlAplicacion(UAplicacion.getRealUrl("/"));
//		contenedor.setUrlArchivo("temporal" + File.separator + "firmadigital" + File.separator);
//		contenedor
//				.setRutaArchivo(UAplicacion.getRealPath("temporal" + File.separator + "firmadigital" + File.separator));

		inicializarFiltrosListado();

		buscar();

		documentosSinFirmar = "";
		// concatenamos los documentos a firmar
		if (!UValidador.esListaVacia(contenedor.getListaElementosFirmar())) {
			for (DtoFirmaElemento obj : contenedor.getListaElementosFirmar()) {
				documentosSinFirmar = documentosSinFirmar + obj.getIdUnicoDocumento() + "|";
			}
		}

		// Ejecutamos directamente el applet sin necesidad de pantallas previas
		String docs = documentosSinFirmar;

		getWebControlContext().ejecutar("javascript:ejecutarapplet('" + docs + "')");

		return null;
	}

	public static CDocumentoFirmaDigital getInstance() {
		FacesContext context = FacesContext.getCurrentInstance();
		CDocumentoFirmaDigital cDocumentoFirmaDigital = (CDocumentoFirmaDigital) context.getApplication()
				.evaluateExpressionGet(context, "#{cDocumentoFirmaDigital}", CDocumentoFirmaDigital.class);
		return cDocumentoFirmaDigital;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ver() throws Exception {
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
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
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
		return null;
	}

	// public String descargarFirmado() throws IOException {
	// FacesContext facesContext = FacesContext.getCurrentInstance();
	// HttpServletResponse response = (HttpServletResponse)
	// facesContext.getExternalContext().getResponse();
	// response.setHeader("Content-Disposition", "attachment;filename=" +
	// documento.getNombreArchivoFirmado());
	// FileInputStream input = null;
	//
	// String pathPrincipaldescarga = getUsuarioActual().getRutabasefirma();
	// String rutaArchivoFirmado = pathPrincipaldescarga +
	// documento.getNombreArchivoFirmado();
	// File archivo = new File(rutaArchivoFirmado);
	//
	// try {
	// int i = 0;
	// input = new FileInputStream(archivo);
	// byte[] buffer = new byte[1024];
	// while ((i = input.read(buffer)) != -1) {
	// response.getOutputStream().write(buffer, 0, i);
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// input.close();
	// response.getOutputStream().close();
	//
	// return null;
	// }

	/**
	 * @return the documentosSinFirmar
	 */
	public String getDocumentosSinFirmar() {
		return documentosSinFirmar;
	}

	/**
	 * @param documentosSinFirmar
	 *            the documentosSinFirmar to set
	 */
	public void setDocumentosSinFirmar(String documentosSinFirmar) {
		this.documentosSinFirmar = documentosSinFirmar;
	}

	/**
	 * @return the contenedor
	 */
	public DtoFirmaContenedor getContenedor() {
		return contenedor;
	}

	/**
	 * @param contenedor
	 *            the contenedor to set
	 */
	public void setContenedor(DtoFirmaContenedor contenedor) {
		this.contenedor = contenedor;
	}

	/**
	 * @return the documento
	 */
	public DtoFirmaElemento getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(DtoFirmaElemento documento) {
		this.documento = documento;
	}

}