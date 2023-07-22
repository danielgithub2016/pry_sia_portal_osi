package net.royal.datasource;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.royal.framework.web.seguridad.SeguridadHelper;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourcePortal extends DriverManagerDataSource {

	public DataSourcePortal() throws Exception {

		InitialContext ic = null;
		try {
			ic = new InitialContext();
		} catch (NamingException e) {

			e.printStackTrace();
		}
		Context xmlContext = null;
		try {
			xmlContext = (Context) ic.lookup("java:comp/env");
		} catch (NamingException e) {

			e.printStackTrace();
		}
		DataSource myDatasource = null;
		try {
			myDatasource = (DataSource) xmlContext.lookup("jndi/dbPortalWeb");
		} catch (NamingException e) {

			e.printStackTrace();
		}

		Method getterPassword = null;
		Method getterUsername = null;
		Method getterDriverClass = null;
		Method getterUrl = null;

		try {
			getterPassword = new PropertyDescriptor("password", myDatasource.getClass()).getReadMethod();
			getterUsername = new PropertyDescriptor("username", myDatasource.getClass()).getReadMethod();
			getterDriverClass = new PropertyDescriptor("driverClassName", myDatasource.getClass()).getReadMethod();
			getterUrl = new PropertyDescriptor("url", myDatasource.getClass()).getReadMethod();
		} catch (IntrospectionException e) {

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

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}

		String url_encript = SeguridadHelper.desencriptar(null, url);
		String user_encript = SeguridadHelper.desencriptar(null, username);
		String pass_encript = SeguridadHelper.desencriptar(null, password);

		setDriverClassName(driverclass);
		setUrl(url_encript);
		setUsername(user_encript);
		setPassword(pass_encript);
	}

}
