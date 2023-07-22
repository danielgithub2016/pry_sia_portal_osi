package net.royal.seguridad.vista.controladora;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedProperty;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import net.royal.framework.web.controladora.UBaseController;
import net.royal.framework.web.controladora.UILoginController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UArchivoPropiedades;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.seguridad.SeguridadHelper;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dominio.Companyowner;
import net.royal.seguridad.dominio.CompanyownerPk;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;
import net.royal.seguridad.dominio.dto.DtoMenu;
import net.royal.seguridad.factory.FactoryErpSeguridad;
import net.royal.seguridad.util.ADAuthenticator;

public class ULoginGenericoControladora extends UBaseController implements UILoginController {

	private static final long serialVersionUID = 2943128311432377678L;
	private static final Log LOGGER = LogFactory.getLog(ULoginGenericoControladora.class);

	private String companiaSocioActual;
	private List<Companyowner> lstCompaniaSocio;
	private String imagenLoginPrincipal;
	private String imagenLoginFondo;
	private String imagenLoginBanda1;
	/**
	 * indica cual es el tipo de validacion del login que se hara al momento de
	 * validar la existencia del usuario tomar la constante
	 * UConstante.CONSTANTE_VALIDACIONLOGIN_XXXXXXXXX
	 *
	 * el valor por defecto es por Codigo de Usuario
	 */
	private String tipoValidacionlogin;

	/**
	 * informacion referente al empleado o persona que esta ingresando puede
	 * contener informacion del centro de costo area u otra relacionada con la
	 * empresa
	 */
	private String informacionUsuario;
	/**
	 * se muestra la fecha actual del sistema en un formato legible para el
	 * usuario
	 */
	private String fechaActualMostrar;

	private String loginUsuario;
	private String loginContrasenia;

	private String ipAddressLogin;
	private String hostNameLogin;

	private UsuarioActual usuarioActual;

	/**
	 * Para identificar desde que region se establece el idioma de la aplicacion
	 */
	private Locale regionLocal = new Locale("es", "PE");

	/**
	 * idioma en la que se esta iniciando la aplicacion
	 */
	private String idiomaLocal = regionLocal.toString();

	@ManagedProperty(value = "#{BeanFactorySeguridad}")
	protected FactoryErpSeguridad facSeguridad;
	
	public ULoginGenericoControladora() {
		try {

			imagenLoginFondo = UAplicacion.getServletContext().getInitParameter("APLICACION.IMAGEN_LOGIN_FONDO");

			imagenLoginBanda1 = UAplicacion.getServletContext().getInitParameter("APLICACION.IMAGEN_LOGIN_BANDA1");

			imagenLoginPrincipal = UAplicacion.getServletContext()
					.getInitParameter("APLICACION.IMAGEN_LOGIN_PRINCIPAL");

			String codigoAplicacion = UAplicacion.getServletContext()
					.getInitParameter(ConstanteSeguridad.APLICACION_CODIGO_APLICACION);

			this.setSessionValue(UConstante.SESION_TIPOAPLICACION, UConstante.CONSTANTE_TIPOAPLICACION_WEB);
			this.setSessionValue(UConstante.SESION_CODIGOAPLICACION, codigoAplicacion);

			UArchivoPropiedades.cargarArchivoPropiedades();

			fechaActualMostrar = UFechaHora.fechaActualFormatoLargo();
			InetAddress local = InetAddress.getLocalHost();
			InetAddress ip = InetAddress.getByName("" + local.getHostAddress());
			String[] partesIpHost = ip.getLocalHost().toString().split("/");
			ipAddressLogin = partesIpHost[1];
			hostNameLogin = partesIpHost[0];
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.error(ex);
		}
	}

	private void cargarCompaniaOwner() {
		lstCompaniaSocio = (List<Companyowner>) facSeguridad.getCompanyownerServicio().listarTodos();
	}

	@Override
	public String ingresar() throws Exception {
		return this.ingresar((String) UAplicacion.getSessionValue(UConstante.SESION_CODIGOAPLICACION));
	}

	public String ingresar(String codigoAplicacion) throws Exception {
		LOGGER.debug("Login Generico : ingresando al sistema");
		try {
			fechaActualMostrar = UFechaHora.fechaActualFormatoLargo();
			InetAddress local = InetAddress.getLocalHost();
			InetAddress ip = InetAddress.getByName("" + local.getHostAddress());
			String[] partesIpHost = ip.getLocalHost().toString().split("/");
			ipAddressLogin = partesIpHost[1];
			hostNameLogin = partesIpHost[0];
		} catch (Exception ex) {
			LOGGER.error(ex);
		}

		return this.ingresar(false, codigoAplicacion);
	}

	public String ingresar(boolean propertiesEncriptado, String codigoAplicacion) throws Exception {
		String navigationCase;
		navigationCase = accederSistema(codigoAplicacion, false);
		return navigationCase;
	}

	public String accederSistema(String codigoSistema, boolean propertiesEncriptado) throws Exception {

		boolean flgLoginValido = false;
		String msgMensajeValidacion = null;
		String claveUsuario = null;
		String modoAutentificacion;
		String loginNet;
		List<DtoMenu> listaOpciones = null;
		Usuario busquedaUsuario = null;

		LOGGER.debug("empezando la autentificacion de usuarios en el sistema. v1.3");
		loginNet = facSeguridad.getParametrosmastServicio().obtenerValorCadena("LOGINNET");
		// 1.- colocar N

		LOGGER.debug("LOGINNET");
		LOGGER.debug(loginNet);
		if (loginNet == null)
			loginNet = "N";
		if (UValidador.estaVacio(loginNet))
			loginNet = "N";
		LOGGER.debug(loginNet);
		if (loginNet.equals("N"))
			modoAutentificacion = UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_USERDATABASE;
		else
			modoAutentificacion = UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_ACTIVEDIRECTORY;
		LOGGER.debug("modoAutentificacion " + modoAutentificacion);

		if (modoAutentificacion == null)
			modoAutentificacion = UArchivoPropiedades.getProperty(UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO);

		LOGGER.debug("modoAutentificacion " + modoAutentificacion);

		if (modoAutentificacion == null)
			modoAutentificacion = UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_USERDATABASE;

		if (!validarLogin())
			return UConstante.NAVIGATIONCASE_LOGIN;

		LOGGER.debug("antes de validar");
		if (modoAutentificacion.equals(UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_USERDATABASE)) {
			LOGGER.debug("validando por base de datos");

			busquedaUsuario = (Usuario) facSeguridad.getUsuarioServicio()
					.obtenerPorId(new UsuarioPk(this.loginUsuario.toUpperCase()));

			if (busquedaUsuario == null) {
				LOGGER.error("usuario no encontrado " + loginNet);
				this.setMessageError(getMessageProperty("login_usuario_noencontrado"));
				return UConstante.NAVIGATIONCASE_LOGIN;
			}

			if (busquedaUsuario.getClave() == null) {
				claveUsuario = "";
			} else {
				if (busquedaUsuario.getClave().trim().length() == 0)
					claveUsuario = "";
				else
					claveUsuario = SeguridadHelper.desencriptar(busquedaUsuario.getClave().trim());
			}

			// 2.- comentar
			if (!this.loginContrasenia.equals(claveUsuario)) {
				this.setMessageError(getMessageProperty("login_password_incorrecto"));
				return UConstante.NAVIGATIONCASE_LOGIN;
			}

			flgLoginValido = true;
		}

		if (modoAutentificacion.equals(UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_MODO_ACTIVEDIRECTORY)) {
			LOGGER.debug("autentificacion por Active Directory v1.1");
			String adDomain = null;
			String adHost = null;
			String adDataBase = null;
			String adMasterUser = null;
			String adMasterPassword = null;
			adDomain = facSeguridad.getParametrosmastServicio().obtenerValorCadena("ADDOMAIN");
			adHost = facSeguridad.getParametrosmastServicio().obtenerValorCadena("ADHOST");
			adDataBase = facSeguridad.getParametrosmastServicio().obtenerValorCadena("ADDATABASE");
			adMasterUser = facSeguridad.getParametrosmastServicio().obtenerValorCadena("ADMASTERUSER");
			adMasterPassword = facSeguridad.getParametrosmastServicio().obtenerValorCadena("ADMASTERPASSWORD");
			LOGGER.debug(adDomain);
			LOGGER.debug(adHost);
			LOGGER.debug(adDataBase);
			LOGGER.debug(adMasterUser);
			LOGGER.debug(adMasterPassword);
			HashMap activeDirectoryConfiguration = null;

			if (UValidador.estaVacio(adDomain)) {
				activeDirectoryConfiguration = ADAuthenticator.configurarAD(this.loginUsuario.toUpperCase(),
						this.loginContrasenia);
			} else {
				activeDirectoryConfiguration = ADAuthenticator.configurarAD(this.loginUsuario.toUpperCase(),
						this.loginContrasenia, adDomain, adHost, adDataBase, adMasterUser, adMasterPassword);
			}

			if (activeDirectoryConfiguration == null) {
				setMessageError("No existe configuracion para conectarse al servidor de Active Directory");
				return null;
			}
			HashMap retorno = ADAuthenticator.validarUsuarioActiveDirectory(activeDirectoryConfiguration, true);
			flgLoginValido = (Boolean) retorno.get(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_LOGINVALIDO);
			msgMensajeValidacion = (String) retorno.get(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_MSJ);
			if (!flgLoginValido) {
				setMessageError(msgMensajeValidacion);
				LOGGER.error("Error en el Active Directory : " + msgMensajeValidacion);
				return "Error en el Active Directory : " + msgMensajeValidacion;
			}
		}

		if (flgLoginValido == false) {
			return UConstante.NAVIGATIONCASE_LOGIN;
		}

		if (tipoValidacionlogin == null)
			tipoValidacionlogin = UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_TIPOVALIDACION_CODIGOUSUARIO;

		if (tipoValidacionlogin == UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_TIPOVALIDACION_CODIGOUSUARIO) {
			usuarioActual = facSeguridad.getUsuarioServicio().traerDatosEmpleadoLogin(this.loginUsuario.toUpperCase());

			if (UValidador.esNulo(usuarioActual)) {
				usuarioActual = facSeguridad.getUsuarioServicio().traerDatosOtroLogin(this.loginUsuario.toUpperCase());
			}
		}
		if (tipoValidacionlogin == UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_TIPOVALIDACION_DOCUMENTOPERSONA) {
			usuarioActual = facSeguridad.getUsuarioServicio()
					.traerDatosEmpleadoDocumentoPersona(this.loginUsuario.toUpperCase());
		}

		if (usuarioActual == null) {
			this.setMessageError(getMessageProperty("login_usuario_noexistebd"));
			return UConstante.NAVIGATIONCASE_LOGIN;
		}

		if (!UValidador.estaVacio(usuarioActual.getMensaje())) {
			this.setMessageError(usuarioActual.getMensaje());
			return UConstante.NAVIGATIONCASE_LOGIN;

		}

		if (usuarioActual.getIdPersona().equals("0")) {
			this.setMessageError(getMessageProperty("login_usuario_sinpersona"));
			return UConstante.NAVIGATIONCASE_LOGIN;

		}

		Boolean isadmin = getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(codigoSistema,
				this.loginUsuario.toUpperCase());
		if (isadmin) {
			DtoMenu obj = new DtoMenu();
			obj.setAplicacionCodigo(codigoSistema);
			obj.setGrupo("SYSTEM");
			obj.setConcepto("SYSADM");
			obj.setDescripcion("ADMINISTRADOR");
			obj.setEstilo(UConstante.CONSTANTE_ESTADO_ACTIVO);
			listaOpciones = new ArrayList<DtoMenu>();
			listaOpciones.add(obj);
		} else {
			listaOpciones = facSeguridad.getUsuarioServicio().listarMenuPorUsuario(codigoSistema,
					this.loginUsuario.toUpperCase());
		}

		usuarioActual.setIsAdmin(isadmin);
		LOGGER.debug("==== OPCIONES INICIALES");
		listaOpciones = facSeguridad.getUsuarioServicio().listarMenuPorUsuarioRoyal(codigoSistema, listaOpciones,
				this.loginUsuario.toUpperCase());
		LOGGER.debug(listaOpciones.size());

		if (listaOpciones == null)
			listaOpciones = new ArrayList<DtoMenu>();
		if (listaOpciones.size() == 0) {
			this.setMessageError(getMessageProperty("login_usuario_sinautorizacion"));
			return UConstante.NAVIGATIONCASE_LOGIN;
		}
		LOGGER.debug("==== OPCIONES DESPUES DE MATCH");
		LOGGER.debug(listaOpciones.size());

		MenuModel menuPorUsuario = crearMenuPorUsuario(listaOpciones);

		cargarCompaniaOwner();

		LOGGER.debug("AUDITORIA - marcando el inicio del login");
		LOGGER.debug(hostNameLogin);
		LOGGER.debug(ipAddressLogin);

		usuarioActual = seleccionarCompanyownerPorDefecto(usuarioActual);
		usuarioActual.setIpAddressLogin(ipAddressLogin);
		usuarioActual.setHostNameLogin(hostNameLogin);
		usuarioActual.setOpcionesSistema(listaOpciones);
		usuarioActual.setLoginUsuario(this.loginUsuario);

		LOGGER.debug("guardando en session fin");
		UAplicacion.setSessionValue(UConstante.SESION_MENU_NAVEGACION, null);
		UAplicacion.setSessionValue(UConstante.SESION_MENU_MODELO_POR_USUARIO, menuPorUsuario);
		UAplicacion.setSessionValue(UConstante.SESION_MENU_PANTALLA_TITULO_ACCION, null);

		LOGGER.debug("guardando en session");
		UAplicacion.setSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO, usuarioActual);

		return UConstante.NAVIGATIONCASE_BIENVENIDA;
	}

	public MenuModel crearMenuPorUsuario(List<DtoMenu> lstMenu) {
		MenuModel modeloMenu;
		modeloMenu = new DefaultMenuModel();

		for (DtoMenu m : lstMenu) {
			if (!UValidador.esListaVacia(m.getHijos())) {
				DefaultSubMenu sub = new DefaultSubMenu(m.getDescripcion());
				crearMenuHijos(m, sub);
				modeloMenu.addElement(sub);
			} else {
				DefaultMenuItem item = new DefaultMenuItem(m.getDescripcion());
				((DefaultMenuItem) item)
						.setCommand(UValidador.esNulo(m.getObjeto()) ? m.getObjeto() : m.getObjeto().trim());
				modeloMenu.addElement(item);
			}
		}
		return modeloMenu;
	}

	private void crearMenuHijos(DtoMenu menu, MenuElement element) {
		MenuElement e;
		for (DtoMenu men : menu.getHijos()) {
			if (!UValidador.esListaVacia(men.getHijos())) {
				e = new DefaultSubMenu(men.getDescripcion());
				crearMenuHijos(men, e);
				((DefaultSubMenu) element).addElement(e);
			} else {
				e = new DefaultMenuItem(men.getDescripcion());

				String codigoConcepto;
				String navigationCase;
				navigationCase = UValidador.esNulo(men.getObjeto()) ? men.getObjeto() : men.getObjeto().trim();
				codigoConcepto = men.getAplicacionCodigo().trim() + men.getGrupo().trim() + men.getConcepto().trim();
				((DefaultMenuItem) e)
						.setCommand("#{cLogin.ejecutarMenu('" + codigoConcepto + "','" + navigationCase + "')}");

				if (men.getImagen() != null)
					((DefaultMenuItem) e).setIcon(men.getImagen());

				((DefaultSubMenu) element).addElement(e);
			}
		}
	}

	/**
	 * limpia la informacion de usuario contrase�a y otros datos de seleccion
	 */
	public String limpiar() {
		this.loginContrasenia = "";
		this.loginUsuario = "";
		return null;
	}

	/**
	 * Valida que los campos <b>usuario</b> y <b>contrasenia</b> no esten vacios
	 */
	public boolean validarLogin() {

		boolean flgExito = true;
		String validarClaveBlanco = null;

		validarClaveBlanco = UArchivoPropiedades
				.getProperty(UConstante.ARCHIVOPROPIEDADES_AUTENTIFICACION_VALIDARCLAVEBLANCO);

		if (validarClaveBlanco == null)
			validarClaveBlanco = UConstante.CONSTANTE_OPCION_NO;

		if (UValidador.estaVacio(this.loginUsuario)) {
			setMessageError(getMessageProperty("login_usuario_requerido"));
			flgExito = false;
		} else {

			if (validarClaveBlanco.equals(UConstante.CONSTANTE_OPCION_SI)) {
				if (UValidador.estaVacio(this.loginContrasenia)) {
					setMessageError(getMessageProperty("login_password_requerido"));
					flgExito = false;
				}
			}

		}
		LOGGER.debug("Paso validacion? = " + flgExito);
		return flgExito;
	}

	/**
	 * regresa a la pantalla de logeo de la aplicacion borra la informacion del
	 * usuario actual
	 */
	public String salir() {
		LOGGER.debug("salir()");
		this.limpiar();
		UAplicacion.removeSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO);
		UAplicacion.removeSessionValue(UConstante.SESION_MENU_NAVEGACION);
		UAplicacion.removeSessionValue(UConstante.SESION_MENU_MODELO_POR_USUARIO);
		UAplicacion.removeSessionValue(UConstante.SESION_MENU_PANTALLA_TITULO_ACCION);
		UAplicacion.removeSessionValue(ConstanteSeguridad.PROCESO_MARCACION_FROM_OEFA);

		LOGGER.debug("UConstante.NAVIGATIONCASE_LOGIN:" + UConstante.NAVIGATIONCASE_LOGIN);

		this.informacionUsuario = "";
		this.usuarioActual = null;
		this.companiaSocioActual = null;

		return UConstante.NAVIGATIONCASE_LOGIN;
	}

	public String autorizacionConceptoStyleDisplay(String codigoComponente) {
		boolean resp = this.autorizacionConcepto(codigoComponente);

		if (resp)
			return "";

		return "display:none";
	}

	public boolean autorizacionConcepto(String codigoComponente) {

		boolean bOpcion = false;
		List<DtoMenu> lstOption = null;
		UsuarioActual ua = null;
		ua = (UsuarioActual) this.getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO);
		lstOption = ua.getOpcionesSistema();

		if (!UValidador.esListaVacia(lstOption)) {
			if (ua.getIsAdmin()) {
				return true;
			}
		}

		DtoMenu seguridadConcepto = null;
		for (int i = 0; i < lstOption.size(); i++) {
			seguridadConcepto = lstOption.get(i);
			if (seguridadConcepto.getHijos() == null)
				seguridadConcepto.setHijos(new ArrayList<DtoMenu>());
			if (seguridadConcepto.getCodigoCompleto() == null)
				seguridadConcepto.setCodigoCompleto("");

			if (seguridadConcepto.getHijos().size() == 0) {
				LOGGER.debug("====autorizacionConcepto");
				LOGGER.debug(seguridadConcepto.getCodigoCompleto());
				LOGGER.debug(codigoComponente);
				if (seguridadConcepto.getCodigoCompleto().equals(codigoComponente)) {
					return true;
				}
			} else {
				boolean retorno = this.autorizacionConceptoAnidado(codigoComponente, seguridadConcepto.getHijos());
				if (retorno)
					return true;
			}
		}
		return bOpcion;
	}

	private boolean autorizacionConceptoAnidado(String codigoComponente, List<DtoMenu> lstOption) {
		DtoMenu seguridadConcepto = null;
		for (int i = 0; i < lstOption.size(); i++) {
			seguridadConcepto = lstOption.get(i);
			if (seguridadConcepto.getHijos() == null)
				seguridadConcepto.setHijos(new ArrayList<DtoMenu>());
			if (seguridadConcepto.getCodigoCompleto() == null)
				seguridadConcepto.setCodigoCompleto("");

			if (seguridadConcepto.getHijos().size() == 0) {
				LOGGER.debug("====autorizacionConceptoAnidado");
				LOGGER.debug(seguridadConcepto.getCodigoCompleto());
				LOGGER.debug(codigoComponente);
				if (seguridadConcepto.getCodigoCompleto().equals(codigoComponente)) {
					return true;
				}
			} else {
				boolean retorno = this.autorizacionConceptoAnidado(codigoComponente, seguridadConcepto.getHijos());
				if (retorno)
					return true;
			}
		}
		return false;
	}

	private UsuarioActual seleccionarCompanyownerPorDefecto(UsuarioActual usuario) {
		String companiaSocioCodigo, companiaSocioNombre;

		if (lstCompaniaSocio == null)
			return usuario;

		if (lstCompaniaSocio.size() == 0)
			return usuario;

		companiaSocioCodigo = lstCompaniaSocio.get(0).getPk().getCompanyowner();
		companiaSocioNombre = lstCompaniaSocio.get(0).getDescription();

		companiaSocioActual = companiaSocioCodigo;

		usuario = cambiarCompanyownerSessionGeneral(usuario, companiaSocioCodigo);

		return usuario;
	}

	public String cambiarCompanyownerSession() {
		UsuarioActual usuario = ((UsuarioActual) getSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO));
		usuario = cambiarCompanyownerSessionGeneral(usuario, companiaSocioActual);
		setSessionValue(UConstante.SESION_USUARIOACTUALDOMINIO, usuario);
		return UConstante.NAVIGATIONCASE_BIENVENIDA;
	}

	public UsuarioActual cambiarCompanyownerSessionGeneral(UsuarioActual usuario, String companyownerLocal) {

		if (companyownerLocal == null)
			companyownerLocal = "";

		String pathPrincipal, nombreImagenLogo;

		pathPrincipal = UAplicacion.getRealPath();

		nombreImagenLogo = UFile.getSeparador() + "comun" + UFile.getSeparador() + "recursos" + UFile.getSeparador()
				+ "imagenes" + UFile.getSeparador() + "compania" + UFile.getSeparador() + "logo_compania_impresion_"
				+ companyownerLocal + ".jpg";

		String sFichero = pathPrincipal + nombreImagenLogo;
		File fichero = new File(sFichero);

		if (!fichero.exists()) {

			nombreImagenLogo = "/" + "comun" + "/" + "recursos" + "/" + "imagenes" + "/" + "compania" + "/"
					+ "logo_compania_impresion_sin_imagen" + ".jpg";

		}
		usuario.setNombreImagenLogoParaReporte(nombreImagenLogo);

		nombreImagenLogo = "/" + "comun" + "/" + "recursos" + "/" + "imagenes" + "/" + "compania" + "/"
				+ "logo_compania_cabecera_" + companyownerLocal + ".jpg";

		if (!fichero.exists()) {

			nombreImagenLogo = "/" + "comun" + "/" + "recursos" + "/" + "imagenes" + "/" + "compania" + "/"
					+ "logo_compania_cabecera_sin_imagen" + ".jpg";
		}

		usuario.setNombreImagenLogoParaCabecera(nombreImagenLogo);

		Companyowner companyowner;

		companyowner = (Companyowner) facSeguridad.getCompanyownerServicio()
				.obtenerPorId(new CompanyownerPk(companyownerLocal));

		if (companyowner == null) {
			companyowner = facSeguridad.getCompanyownerServicio().obtenerPorCodigoCompanyOwner(companyownerLocal);
		}

		usuario.setCompaniaSocioCodigo(companyownerLocal);
		usuario.setCompaniaSocioNombre(companyowner.getDescription());

		LOGGER.debug("companyownerLocal");
		LOGGER.debug(usuario.getCompaniaSocioCodigo());
		LOGGER.debug(usuario.getCompaniaSocioNombre());

		LOGGER.debug(usuario.getNombreImagenLogoParaReporte());
		LOGGER.debug(usuario.getNombreImagenLogoParaCabecera());

		this.getWebControlContext().actualizar("idImagenCompania");
		this.getWebControlContext().actualizar("frmCabezara");

		return usuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public FactoryErpSeguridad getFacSeguridad() {
		return facSeguridad;
	}

	public void setFacSeguridad(FactoryErpSeguridad facSeguridad) {
		this.facSeguridad = facSeguridad;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getLoginContrasenia() {
		return loginContrasenia;
	}

	public void setLoginContrasenia(String loginContrasenia) {
		this.loginContrasenia = loginContrasenia;
	}

	/**
	 * informacion referente al empleado o persona que esta ingresando puede
	 * contener informacion del centro de costo area u otra relacionada con la
	 * empresa
	 */
	public String getInformacionUsuario() {
		return informacionUsuario;
	}

	/**
	 * informacion referente al empleado o persona que esta ingresando puede
	 * contener informacion del centro de costo area u otra relacionada con la
	 * empresa
	 */
	public void setInformacionUsuario(String informacionUsuario) {
		this.informacionUsuario = informacionUsuario;
	}

	/**
	 * se muestra la fecha actual del sistema en un formato legible para el
	 * usuario
	 */
	public String getFechaActualMostrar() {
		return fechaActualMostrar;
	}

	/**
	 * se muestra la fecha actual del sistema en un formato legible para el
	 * usuario
	 */
	public void setFechaActualMostrar(String fechaActualMostrar) {
		this.fechaActualMostrar = fechaActualMostrar;
	}

	/**
	 * indica cual es el tipo de validacion del login que se hara al momento de
	 * validar la existencia del usuario tomar la constante
	 * UConstante.CONSTANTE_VALIDACIONLOGIN_XXXXXXXXX
	 *
	 * el valor por defecto es por Codigo de Usuario
	 */
	public String getTipoValidacionlogin() {
		return tipoValidacionlogin;
	}

	/**
	 * indica cual es el tipo de validacion del login que se hara al momento de
	 * validar la existencia del usuario tomar la constante
	 * UConstante.CONSTANTE_VALIDACIONLOGIN_XXXXXXXXX
	 *
	 * el valor por defecto es por Codigo de Usuario
	 */
	public void setTipoValidacionlogin(String tipoValidacionlogin) {
		this.tipoValidacionlogin = tipoValidacionlogin;
	}

	public UsuarioActual getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(UsuarioActual usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	/**
	 * Para identificar desde que region se establece el idioma de la aplicacion
	 */
	public Locale getRegionLocal() {
		return regionLocal;
	}

	/**
	 * Para identificar desde que region se establece el idioma de la aplicacion
	 */
	public void setRegionLocal(Locale regionLocal) {
		this.regionLocal = regionLocal;
	}

	/**
	 * idioma en la que se esta iniciando la aplicacion
	 */
	public String getIdiomaLocal() {
		return idiomaLocal;
	}

	/**
	 * idioma en la que se esta iniciando la aplicacion
	 */
	public void setIdiomaLocal(String idiomaLocal) {
		this.idiomaLocal = idiomaLocal;
	}

	public String getCompaniaSocioActual() {
		return companiaSocioActual;
	}

	public void setCompaniaSocioActual(String companyownerActual) {
		this.companiaSocioActual = companyownerActual;
	}

	public List<Companyowner> getLstCompaniaSocio() {
		return lstCompaniaSocio;
	}

	public void setLstCompaniaSocio(List<Companyowner> lstCompaniaSocio) {
		this.lstCompaniaSocio = lstCompaniaSocio;
	}

	public String ejecutarMenu(String codigoConcepto, String navigationCase) throws Exception {

		UIBindingController binding = null;

		binding = UFaces.getControladora(UConstante.SESION_BEAN_BINDINGCONTROLLER, UIBindingController.class);

		if (codigoConcepto == null)
			codigoConcepto = "";
		if (navigationCase == null)
			navigationCase = "";

		binding.setAccionPantalla(accion_solicitada.LISTAR);

		return navigationCase;
	}

	public String getImagenLoginBanda1() {
		return imagenLoginBanda1;
	}

	public void setImagenLoginBanda1(String imagenLoginBanda1) {
		this.imagenLoginBanda1 = imagenLoginBanda1;
	}

	public String getImagenLoginPrincipal() {
		return imagenLoginPrincipal;
	}

	public void setImagenLoginPrincipal(String imagenLoginPrincipal) {
		this.imagenLoginPrincipal = imagenLoginPrincipal;
	}

	public String getImagenLoginFondo() {
		return imagenLoginFondo;
	}

	public void setImagenLoginFondo(String imagenLoginFondo) {
		this.imagenLoginFondo = imagenLoginFondo;
	}

	@Override
	public String reiniciar() {
		return null;
	}
}
