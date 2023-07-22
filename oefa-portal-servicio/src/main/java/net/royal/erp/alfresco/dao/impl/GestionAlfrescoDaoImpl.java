package net.royal.erp.alfresco.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.alfresco.dao.GestionAlfrescoDao;
import net.royal.erp.alfresco.dominio.dto.DtoDocumentoAlfresco;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.MensajeUsuario.tipo_mensaje;
import oracle.jdbc.OracleTypes;

@Repository
public class GestionAlfrescoDaoImpl extends GenericoDaoImpl<Object, Serializable> implements GestionAlfrescoDao {

	private static Log LOGGER = LogFactory.getLog(GestionAlfrescoDaoImpl.class);

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<DtoDocumentoAlfresco> listar(String sesion_usuario, String proceso, String idproceso)
			throws SQLException {
		// TODO Auto-generated method stub

		Connection connection = getConnection();
		CallableStatement callable = null;
		ResultSet rs = null;
		List<DtoDocumentoAlfresco> resultado = new ArrayList<>();

		// Se prepara el Statement
		callable = connection.prepareCall("{ call SGCORESYS.PKG_GESTOR_ALFRESCO.listar(?,?,?,?)}");

		// Se registra el parametro de salida
		callable.registerOutParameter(1, oracle.jdbc.driver.OracleTypes.CURSOR);

		LOGGER.debug(">>>> PKG_GESTOR_ALFRESCO.listar");
		LOGGER.debug(sesion_usuario);
		LOGGER.debug(proceso);
		LOGGER.debug(idproceso);

		// Se pasa un parámetro en el segundo interrogante.
		callable.setString(2, sesion_usuario);
		callable.setString(3, proceso);
		callable.setString(4, idproceso);

		// Se hace la llamada a la función.
		callable.executeQuery();

		// Se recoge el resultado del primer interrogante.
		rs = (ResultSet) callable.getObject(1);

		while (rs.next()) {
			logger.debug("si hay data");
			DtoDocumentoAlfresco obj = new DtoDocumentoAlfresco();
			// obj.setCompania(rs.getString("compania"));
			// obj.setSecuencia(rs.getBigDecimal("secuencia"));
			// obj.setFecha(rs.getDate("fecha"));
			obj.setNombre(rs.getString("nombre"));
			obj.setUuidalfresco(rs.getString("uuidalfresco"));
			obj.setUltimafechamodif(rs.getDate("ultimafechamodif"));
			obj.setUltimousuario(rs.getString("ultimusuario"));
			resultado.add(obj);
		}

		return resultado;
	}

	@Override
	public List<MensajeUsuario> registrar(String sesion_usuario, String proceso, String idproceso, String nombre,
			String uiddalfresoc, String usuario) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		CallableStatement callable = null;
		List<MensajeUsuario> resultado = new ArrayList<>();

		// Se prepara el Statement
		callable = connection.prepareCall("{ call SGCORESYS.PKG_GESTOR_ALFRESCO.REGISTRAR(?,?,?,?,?,?,?)}");

		// Se registra el parametro de salida
		callable.registerOutParameter(1, OracleTypes.VARCHAR);

		LOGGER.error(">>>> PKG_GESTOR_ALFRESCO.REGISTRAR");
		LOGGER.error(sesion_usuario);
		LOGGER.error(proceso);
		LOGGER.error(idproceso);
		LOGGER.error(nombre);
		LOGGER.error(uiddalfresoc);
		LOGGER.error(usuario);

		// Se pasa un parámetro en el segundo interrogante.
		callable.setString(2, sesion_usuario);
		callable.setString(3, proceso);
		callable.setString(4, idproceso);
		callable.setString(5, nombre);
		callable.setString(6, uiddalfresoc);
		callable.setString(7, usuario);

		// Se hace la llamada a la función.
		callable.execute();

		return resultado;
	}

	@Override
	public List<MensajeUsuario> actualizar(String sesion_usuario, String proceso, String idproceso, String idregistro,
			String nombre, String uiddalfresoc, String usuario) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		CallableStatement callable = null;
		List<MensajeUsuario> resultado = new ArrayList<>();

		// Se prepara el Statement
		callable = connection.prepareCall("{ call SGCORESYS.PKG_GESTOR_ALFRESCO.ACTUALIZAR(?,?,?,?,?,?,?,?)}");

		// Se registra el parametro de salida
		callable.registerOutParameter(1, OracleTypes.VARCHAR);

		LOGGER.debug(">>>> PKG_GESTOR_ALFRESCO.ACTUALIZAR");


		// Se pasa un parámetro en el segundo interrogante.
		callable.setString(2, sesion_usuario);
		callable.setString(3, proceso);
		callable.setString(4, idproceso);
		callable.setString(5, idregistro);
		callable.setString(6, nombre);
		callable.setString(7, uiddalfresoc);
		callable.setString(8, usuario);

		// Se hace la llamada a la función.
		callable.execute();

		return resultado;
	}

	@Override
	public List<MensajeUsuario> eliminar(String sesion_usuario, String proceso, String idproceso, String idregistro,
			String uiddalfresoc, String usuario) throws SQLException {

		LOGGER.debug("eliminar dao");

		Connection connection = getConnection();
		CallableStatement callable = null;
		List<MensajeUsuario> resultado = new ArrayList<>();

		callable = connection.prepareCall("{ call SGCORESYS.PKG_GESTOR_ALFRESCO.eliminar(?,?,?,?,?,?,?)}");
		callable.registerOutParameter(1, OracleTypes.VARCHAR);

		LOGGER.debug(">>>> PKG_GESTOR_ALFRESCO.eliminar");
		LOGGER.debug(sesion_usuario);
		LOGGER.debug(proceso);
		LOGGER.debug(idproceso);
		LOGGER.debug(idregistro);
		LOGGER.debug(uiddalfresoc);
		LOGGER.debug(usuario);

		// Se pasa un parámetro en el segundo interrogante.
		callable.setString(2, sesion_usuario);
		callable.setString(3, proceso);
		callable.setString(4, idproceso);
		callable.setString(5, idregistro);
		callable.setString(6, uiddalfresoc);
		callable.setString(7, usuario);

		// Se hace la llamada a la función.
		callable.execute();

		resultado.add(new MensajeUsuario(tipo_mensaje.EXITO, "Se eliminó correctamente"));

		return resultado;
	}

}
