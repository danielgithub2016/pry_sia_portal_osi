package net.royal.seguridad.vista.controladora;

import java.io.File;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.royal.framework.web.controladora.UBaseComunSession;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.ParametroPersistenciaLista;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.seguridad.dominio.Companyowner;
import net.royal.seguridad.dominio.dto.DtoClientemast;
import net.royal.seguridad.factory.FactoryErpSeguridad;

import org.apache.log4j.Logger;
import org.primefaces.model.menu.MenuModel;

public class UComunSession extends UBaseComunSession implements UIComunSession {

	private static final long serialVersionUID = -3648763244435312687L;

	protected static Logger LOGGER = Logger.getLogger(UComunSession.class);

	@ManagedProperty(value = "#{BeanFactorySeguridad}")
	protected FactoryErpSeguridad facSeguridad;

	/*
	@ManagedProperty(value = "#{BeanFactoryCoreSeguridad}")
	protected FactoryCoreSeguridad coreFactory;*/
	
	private String rutaLogoClienteCabezera;
	private String periodoActual;
	private Integer idClienteActual;
	private String companyownerActual;
	private List<Companyowner> lstCompanyowner;
	private List<DtoClientemast> lstClienteMast;
	private Integer timeoutSesion;
	private MenuModel modeloMenu;
	
	public void cargarListasSession(){
		
		if (facSeguridad!=null)
		{
			if (facSeguridad.getClientemastServicio()!=null)
			{
				lstClienteMast = facSeguridad.getClientemastServicio().listarClientesPorUsuarioActual(null);
				
				if (lstClienteMast.size()>0)
				{
					idClienteActual = lstClienteMast.get(0).getCliente();
					cambiarClienteSessionGeneral(idClienteActual);
				}
			}
			else
			{
				LOGGER.error("baseFactory.getClienteMastServicio() esta en nulo");
			}
			
			
			lstCompanyowner = (List<Companyowner>) facSeguridad.getCompanyownerServicio().listarTodos();
			if (lstCompanyowner.size()>0)
			{
				companyownerActual = lstCompanyowner.get(0).getPk().getCompanyowner();
				cambiarCompaniaSessionGeneral(companyownerActual);
			}
		}
		else
		{
			LOGGER.error("baseFactory esta en nulo");
		}
		
		
	}
	
	public UComunSession() {
		this.setMensaje(new MensajeControllerGenerico());		
	}

	public Integer getTimeoutSesion() {
		if (UValidador.esNulo(timeoutSesion)) {
			HttpSession sesion = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			timeoutSesion = sesion.getMaxInactiveInterval() * 1000;
		}
		LOGGER.debug("timeoutSesion " + timeoutSesion);
		return timeoutSesion;
	}

	public void setTimeoutSesion(Integer timeoutSesion) {
		this.timeoutSesion = timeoutSesion;
	}

	public static String parametroObtenerString(String parametro) {
		UIComunSession comunSession = UFaces.getControladora(
				UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				UIComunSession.class);
		return comunSession.getMensaje().getParametros()
				.parametroObtenerString(parametro);
	}

	public static accion_solicitada parametroObtenerAccionSolicitada(
			String parametro) {
		UIComunSession comunSession = UFaces.getControladora(
				UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				UIComunSession.class);
		return comunSession.getMensaje().getParametros()
				.parametroObtenerAccionSolicitada(parametro);
	}

	public static Object parametroObtenerObject(String parametro) {
		UIComunSession comunSession = UFaces.getControladora(
				UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				UIComunSession.class);
		return comunSession.getMensaje().getParametros()
				.parametroObtenerObject(parametro);
	}

	public void parametroAgregar(String pfield, Object pvalue) {
		UIComunSession comunSession = UFaces.getControladora(
				UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				UIComunSession.class);
		comunSession.getMensaje().getParametros()
				.parametroAgregar(pfield, null, pvalue);
	}

	public static ParametroPersistenciaLista getParametros() {
		UIComunSession comunSession = UFaces.getControladora(
				UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				UIComunSession.class);
		return comunSession.getMensaje().getParametros();
	}

	public MenuModel getModeloMenu() {
		return modeloMenu;
	}

	public void setModeloMenu(MenuModel modeloMenu) {
		this.modeloMenu = modeloMenu;
	}
	
	public String cambiarClienteSession() {
		LOGGER.debug("ENTRO A MEOTODO CAMBIARCIENTE SESSION");
		LOGGER.debug("codigocliente::" + idClienteActual);
		String navegacion = cambiarClienteSessionGeneral(idClienteActual);
		LOGGER.debug("CLAROO::" + navegacion);
		return navegacion;
	}
	
	public String cambiarCompaniaSession() {		
		String navegacion = cambiarCompaniaSessionGeneral(companyownerActual);
		return navegacion;
	}
	
	public String cambiarCompaniaSessionGeneral(String companyowner) {		
		
		UIBindingController binding = null;
		binding = UFaces.getControladora(UConstante.SESION_BEAN_BINDINGCONTROLLER, UIBindingController.class);
		UsuarioActual usuario = ((UsuarioActual) UAplicacion.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO));

		if (companyowner == null)
			companyowner = "";
		companyowner=companyowner.trim();
		
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		String nombreImagenLogo = pathPrincipal + File.separator + "comun"
				+ File.separator + "recursos" + File.separator + "imagenes"
				+ File.separator + "compania" + File.separator
				+ "logo_compania_impresion_" + companyowner + ".jpg";

		usuario.setNombreImagenLogoParaReporte(nombreImagenLogo);

		nombreImagenLogo = pathPrincipal + File.separator + "comun"
				+ File.separator + "recursos" + File.separator + "imagenes"
				+ File.separator + "compania" + File.separator
				+ "logo_compania_cabecera_" + companyowner + ".jpg";

		usuario.setNombreImagenLogoParaCabecera(nombreImagenLogo);
		usuario.setCompaniaSocioCodigo(companyowner);


		rutaLogoClienteCabezera = ".." + File.separator + ".." + File.separator + "comun"
				+ File.separator + "recursos" + File.separator + "imagenes"
				+ File.separator + "compania" + File.separator
				+ "logo_compania_cabecera_" + companyowner + ".jpg";		
		
		UAplicacion.setSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO, usuario);
				
		binding.iniciarHeaderNavegacion();
		this.getWebControlContext().actualizar("idImagenCompania");
		this.getWebControlContext().actualizar("frmCabezara");

		return UConstante.NAVIGATIONCASE_BIENVENIDA;
	}
	
	public String cambiarClienteSessionGeneral(Integer idCliente) {		
		
		UIBindingController binding = null;
		binding = UFaces.getControladora(UConstante.SESION_BEAN_BINDINGCONTROLLER, UIBindingController.class);
		UsuarioActual usuario = ((UsuarioActual) UAplicacion.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO));

		if (idCliente == null)
			idCliente = 0;

		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext()).getRealPath("/");
		String nombreImagenLogo = pathPrincipal + File.separator + "comun"
				+ File.separator + "recursos" + File.separator + "imagenes"
				+ File.separator + "cliente" + File.separator
				+ "logo_cliente_impresion_" + idCliente.toString() + ".jpg";

		usuario.setNombreImagenLogoParaReporte(nombreImagenLogo);

		nombreImagenLogo = pathPrincipal + File.separator + "comun"
				+ File.separator + "recursos" + File.separator + "imagenes"
				+ File.separator + "cliente" + File.separator
				+ "logo_cliente_cabecera_" + idCliente.toString() + ".jpg";

		usuario.setNombreImagenLogoParaCabecera(nombreImagenLogo);
		usuario.setClienteCodigo(idCliente);
		usuario.setPeriodoContableActual(periodoActual);

		rutaLogoClienteCabezera = ".." + File.separator + ".." + File.separator + "comun"
				+ File.separator + "recursos" + File.separator + "imagenes"
				+ File.separator + "cliente" + File.separator
				+ "logo_cliente_cabecera_" + idCliente.toString() + ".jpg";
		
		
		LOGGER.debug("logo compania :: " + nombreImagenLogo);
		LOGGER.debug("periodo :: " + periodoActual);

		UAplicacion.setSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO, usuario);
				
		binding.iniciarHeaderNavegacion();
		this.getWebControlContext().actualizar("idImagenCompania");
		this.getWebControlContext().actualizar("frmCabezara");

		return UConstante.NAVIGATIONCASE_BIENVENIDA;
	}

	public String getRutaLogoClienteCabezera() {
		return rutaLogoClienteCabezera;
	}

	public void setRutaLogoClienteCabezera(String rutaLogoClienteCabezera) {
		this.rutaLogoClienteCabezera = rutaLogoClienteCabezera;
	}

	public String getPeriodoActual() {
		return periodoActual;
	}

	public void setPeriodoActual(String periodoActual) {
		this.periodoActual = periodoActual;
	}

	public Integer getIdClienteActual() {
		return idClienteActual;
	}

	public void setIdClienteActual(Integer idClienteActual) {
		this.idClienteActual = idClienteActual;
	}

	public String getCompanyownerActual() {
		return companyownerActual;
	}

	public void setCompanyownerActual(String companyownerActual) {
		this.companyownerActual = companyownerActual;
	}

	public List<Companyowner> getLstCompanyowner() {
		return lstCompanyowner;
	}

	public void setLstCompanyowner(List<Companyowner> lstCompanyowner) {
		this.lstCompanyowner = lstCompanyowner;
	}

	public List<DtoClientemast> getLstClienteMast() {
		return lstClienteMast;
	}

	public void setLstClienteMast(List<DtoClientemast> lstClienteMast) {
		this.lstClienteMast = lstClienteMast;
	}
	
	public FactoryErpSeguridad getFacSeguridad() {
		return facSeguridad;
	}

	public void setFacSeguridad(FactoryErpSeguridad facSeguridad) {
		this.facSeguridad = facSeguridad;
	}
	
	/*public FactoryCoreSeguridad getCoreFactory() {
		return coreFactory;
	}
	public void setCoreFactory(FactoryCoreSeguridad coreFactory) {
		this.coreFactory = coreFactory;
	}*/
}
