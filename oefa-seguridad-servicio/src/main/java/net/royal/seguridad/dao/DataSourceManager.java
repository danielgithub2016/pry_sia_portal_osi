package net.royal.seguridad.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.seguridad.SeguridadHelper;

public class DataSourceManager extends DriverManagerDataSource {

	private String flgEncriptado = "N";
	private String jndi = null;

	private static final String jndiSinEncriptar = "jndi/dbPortalWeb";
	private static final String jndiEncriptado = "jndi/dbPortalWebEncriptado";
	private Boolean flgDataSourceConfigurado = Boolean.FALSE;

	public DataSourceManager() throws Exception {
	}

	private void ConfigurarDataSourceManager() throws Exception {
		if (flgDataSourceConfigurado)
			return;
		InitialContext ic = null;
		try {
			ic = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Context xmlContext = null;
		try {
			xmlContext = (Context) ic.lookup("java:comp/env");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataSource myDatasource = null;
		try {
			String jndiLocal = null;

			if (UValidador.estaVacio(jndi)) {
				System.out
						.println("jndi es nulo : se validara las constantes genericas");
				if (UValidador.validarFlag(flgEncriptado))
					jndiLocal = jndiEncriptado;
				else
					jndiLocal = jndiSinEncriptar;
			} else {
				jndiLocal = jndi;
			}

			myDatasource = (DataSource) xmlContext.lookup(jndiLocal);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Method getterPassword = null;
		Method getterUsername = null;
		Method getterDriverClass = null;
		Method getterUrl = null;

		try {
			getterPassword = new PropertyDescriptor("password",
					myDatasource.getClass()).getReadMethod();
			getterUsername = new PropertyDescriptor("username",
					myDatasource.getClass()).getReadMethod();
			getterDriverClass = new PropertyDescriptor("driverClassName",
					myDatasource.getClass()).getReadMethod();
			getterUrl = new PropertyDescriptor("url", myDatasource.getClass())
					.getReadMethod();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password = null;
		String username = null;
		String url = null;
		String driverclass = null;

		try {
			password = (String) getterPassword.invoke(myDatasource);
			username = (String) getterUsername.invoke(myDatasource);
			url = (String) getterUrl.invoke(myDatasource);
			driverclass = (String) getterDriverClass.invoke(myDatasource);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (UValidador.validarFlag(flgEncriptado)) {
			setDriverClassName(driverclass);
			setUrl(SeguridadHelper.desencriptar(null, url));
			setUsername(SeguridadHelper.desencriptar(null, username));
			setPassword(SeguridadHelper.desencriptar(null, password));


		} else {
			setDriverClassName(driverclass);
			setUrl(url);
			setUsername(username);
			setPassword(password);
		}
		flgDataSourceConfigurado = Boolean.TRUE;
	}

	public String getFlgEncriptado() {
		return flgEncriptado;
	}

	public void setFlgEncriptado(String flgEncriptado) throws Exception {
		this.flgEncriptado = flgEncriptado;
		ConfigurarDataSourceManager();
	}

	public String getJndi() {
		return jndi;
	}

	public void setJndi(String jndi) {
		this.jndi = jndi;
	}

}
