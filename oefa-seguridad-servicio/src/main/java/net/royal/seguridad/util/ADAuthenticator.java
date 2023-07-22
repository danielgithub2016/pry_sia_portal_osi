package net.royal.seguridad.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.apache.log4j.Logger;

import net.royal.framework.web.core.PropertiesUtil;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UArchivoPropiedades;
import net.royal.seguridad.constante.ConstanteSeguridad;

public class ADAuthenticator {

	private static final Logger LOGGER = Logger.getLogger(ADAuthenticator.class);

	/** Dominio donde validara */
	private String domain;

	/** Host donde validara */
	private String ldapHost;

	/** Base de datos del sistema operativo para busqueda del usuario */
	private String searchBase;

	public ADAuthenticator(String domain, String host, String dn) {

		this.domain = domain;
		this.ldapHost = host;
		this.searchBase = dn;
	}

	/**
	 * Autentica el usuario en el directorio de usuarios del Sistema Operativo.
	 * 
	 * @param user
	 *            usuario del sistema, tipo String
	 * @param password
	 *            password del usuario del sistema, tipo String
	 * @return map con resultados, tipo Map
	 */
	public Map authenticate(String user, String password) {
		String returnedAtts[] = { "sn", "givenName", "mail" };
		String searchFilter = "(&(objectClass=user)(sAMAccountName=" + user + "))";

		// Create the search controls
		SearchControls searchCtls = new SearchControls();
		searchCtls.setReturningAttributes(returnedAtts);

		// Specify the search scope
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, this.ldapHost);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env.put(Context.SECURITY_CREDENTIALS, password);

		LdapContext ctxGC = null;
		boolean ldapUser = false;

		try {
			ctxGC = new InitialLdapContext(env, null);

			// Search objects in GC using filters
			NamingEnumeration answer = ctxGC.search(searchBase, searchFilter, searchCtls);

			while (answer.hasMoreElements()) {

				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				Map amap = null;

				if (attrs != null) {

					amap = new HashMap();
					NamingEnumeration ne = attrs.getAll();
					while (ne.hasMore()) {
						Attribute attr = (Attribute) ne.next();
						amap.put(attr.getID(), attr.get());
						ldapUser = true;

					}
					ne.close();

				}
				return amap;

			}
		} catch (NamingException ex) {
			LOGGER.error("NamingException ex");
			LOGGER.error("ERROR searchBase: " + searchBase);
			LOGGER.error("ERROR ldapHost: " + ldapHost);
			LOGGER.error("ERROR domain: " + domain);
			LOGGER.error("ERROR: " + ex.getMessage());
			for (int i = 0; i < ex.getStackTrace().length; i++) {
				LOGGER.error(ex.getStackTrace()[i]);
			}
			return null;
		}
		return null;
	}

	/**
	 * Retorna un map diferente a null si es que el usuario existe en el
	 * directorio
	 * 
	 * @param user
	 *            usuario administrador con el cual se validara que el usuario
	 *            enviado como tercer parametro exista en el directorio, tipo
	 *            String
	 * @param password
	 *            password del usuario administrador, tipo String
	 * @param userSearch
	 *            usuario al cual se le validara la existencia, tipo String
	 * @return map de resultados, tipo Map
	 */
	public Map existsUser(String user, String password, String userSearch) {
		String returnedAtts[] = { "sn", "givenName", "mail" };
		String searchFilter = "(&(objectClass=user)(sAMAccountName=" + userSearch + "))";

		// Create the search controls
		SearchControls searchCtls = new SearchControls();
		searchCtls.setReturningAttributes(returnedAtts);

		// Specify the search scope
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, this.ldapHost);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env.put(Context.SECURITY_CREDENTIALS, password);

		LdapContext ctxGC = null;
		boolean ldapUser = false;

		try {
			ctxGC = new InitialLdapContext(env, null);
			// Search objects in GC using filters
			NamingEnumeration answer = ctxGC.search(searchBase, searchFilter, searchCtls);
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				Map amap = null;
				if (attrs != null) {
					amap = new HashMap();
					NamingEnumeration ne = attrs.getAll();
					while (ne.hasMore()) {
						Attribute attr = (Attribute) ne.next();
						amap.put(attr.getID(), attr.get());
						ldapUser = true;

					}
					ne.close();
				}
				return amap;
			}
		} catch (NamingException ex) {
			LOGGER.error("NamingException ex");
			LOGGER.error("ERROR searchBase: " + searchBase);
			LOGGER.error("ERROR ldapHost: " + ldapHost);
			LOGGER.error("ERROR domain: " + domain);
			LOGGER.error("ERROR: " + ex.getMessage());
			for (int i = 0; i < ex.getStackTrace().length; i++) {
				LOGGER.error(ex.getStackTrace()[i]);
			}
			return null;
		}
		return null;
	}

	public static HashMap configurarAD(String usuario, String password, String adDomain, String adHost,
			String adDataBase, String adMasterUser, String adMasterPassword) throws Exception {
		// Antes de iniciar con el proceso de autenticacion, se setean las
		// propiedades genericas en el RemoteFactory de SeguridadModel.
		HashMap activeDirectoryConfiguration = new HashMap<String, String>();

		String domain = adDomain;
		String host = adHost;
		String database = adDataBase;
		String usuarioMaster = adMasterUser;
		String passwordMaster = adMasterPassword;

		if (activeDirectoryConfiguration == null)
			activeDirectoryConfiguration = new HashMap();

		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_DOMAIN, domain);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_HOST, host);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_DATABASE, database);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERUSER, usuarioMaster);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERPASSWORD, passwordMaster);

		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_USER, usuario);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_PASSWORD, password);

		return activeDirectoryConfiguration;
	}

	@SuppressWarnings("unchecked")
	public static HashMap configurarAD(String usuario, String password) throws Exception {
		// Antes de iniciar con el proceso de autenticacion, se setean las
		// propiedades genericas en el RemoteFactory de SeguridadModel.
		HashMap activeDirectoryConfiguration = new HashMap<String, String>();

		String domain = UArchivoPropiedades.getProperty(ConstanteSeguridad.ACTIVE_DIRECTORY_DOMAIN);
		String host = UArchivoPropiedades.getProperty(ConstanteSeguridad.ACTIVE_DIRECTORY_HOST);
		String database = UArchivoPropiedades.getProperty(ConstanteSeguridad.ACTIVE_DIRECTORY_DATABASE);
//		String domain = PropertiesUtil.getProp(ConstanteSeguridad.ACTIVE_DIRECTORY_DOMAIN);
//		String host = PropertiesUtil.getProp(ConstanteSeguridad.ACTIVE_DIRECTORY_HOST);
//		String database = PropertiesUtil.getProp(ConstanteSeguridad.ACTIVE_DIRECTORY_DATABASE);
		//String usuarioMaster = UArchivoPropiedades.getProperty(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERUSER);
		//String passwordMaster = UArchivoPropiedades.getProperty(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERPASSWORD);

		if (activeDirectoryConfiguration == null)
			activeDirectoryConfiguration = new HashMap();

		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_DOMAIN, domain);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_HOST, host);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_DATABASE, database);
		/*
		 * activeDirectoryConfiguration.put(
		 * ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERUSER, usuarioMaster);
		 * activeDirectoryConfiguration.put(
		 * ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERPASSWORD, passwordMaster);
		 */
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERUSER, usuario);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERPASSWORD, password);

		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_USER, usuario);
		activeDirectoryConfiguration.put(ConstanteSeguridad.ACTIVE_DIRECTORY_PASSWORD, password);

		return activeDirectoryConfiguration;
	}

	public static HashMap validarUsuarioActiveDirectory(HashMap map, boolean validarPasswordUsuario) throws Exception {

		// Esta variable se retorna vacia cuando se concreta la autenticacion
		// con exito. Caso contrario, se retorna un cadena de texto con el
		// mensaje que se mostrara al usuario en pantalla.
		String mensaje = null;

		String domain = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_DOMAIN);
		String host = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_HOST);
		String searchBase = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_DATABASE);

		// Valores del usuario master
		String usuarioMaster = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERUSER);
		String passwordMaster = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_MASTERPASSWORD);

		// Valores del usuario que se autentifica en el sistema
		String usuario = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_USER);
		String password = (String) map.get(ConstanteSeguridad.ACTIVE_DIRECTORY_PASSWORD);

		ADAuthenticator ad = new ADAuthenticator(domain, host, searchBase);

		// boolean flgUsuarioMasterEncontrado = false;
		// boolean flgUsuarioLoginEncontrado = false;
		Map mapResults;

		mapResults = ad.authenticate(usuarioMaster, passwordMaster);
		if (mapResults == null) {
			// mensaje = "El usuario administrador para validar la conexión al "
			// + "Active Directory no es válido";
			mensaje = "El nombre de usuario o contraseña ingresada no son válidos. "
					+ UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_CONTACTO_SIA);
			LOGGER.debug("> Usuario LDAP Master no fue encontrado");
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_MSJ, mensaje);
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_LOGINVALIDO, false);
			return map;
		}

		// Se usa el usuario master para validar la existencia del usuario
		mapResults = ad.existsUser(usuarioMaster, passwordMaster, usuario);
		if (mapResults == null) {
			mensaje = "El usuario ingresado es inválido";
			LOGGER.error("> Usuario " + usuario + " es invalido. No es un usuario de Active Directory");
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_MSJ, mensaje);
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_LOGINVALIDO, false);
			return map;
		}

		mapResults = ad.authenticate(usuario, password);

		if (validarPasswordUsuario == false) {
			LOGGER.debug("> validarPasswordUsuario es false ");
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_MSJ, null);
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_LOGINVALIDO, true);
			return map;
		}

		if (mapResults == null) {
			mensaje = "La contraseña ingresada es inválida";
			LOGGER.error("> El password es invalido");
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_MSJ, mensaje);
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_LOGINVALIDO, false);
			return map;

		} else {
			LOGGER.debug("> El password es valido!");
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_MSJ, null);
			map.put(ConstanteSeguridad.ACTIVE_DIRECTORY_MSJ_LOGINVALIDO, true);
			return map;
		}
	}
}
