package net.royal.erp.asistencia.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import net.royal.erp.asistencia.dao.AsAutorizacionDao;
import net.royal.erp.asistencia.dominio.AsAutorizacion;
import net.royal.erp.asistencia.dominio.AsAutorizacionPk;
import net.royal.erp.asistencia.dominio.dto.DtoAsAutorizacion;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class AsAutorizacionDaoImpl extends GenericoDaoImpl<AsAutorizacion, AsAutorizacionPk>
		implements AsAutorizacionDao {

	private static Log LOGGER = LogFactory.getLog(AsAutorizacionDaoImpl.class);

	public AsAutorizacionDaoImpl() {
		super("asautorizacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Date obtenerMaxFecha(Integer empleado, Integer anio, Date fecha) {
		List lista = this.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("pk.conceptoacceso", "25"), Restrictions.ne("pk.fecha", fecha),
						Restrictions.sqlRestriction("to_char( FECHA , 'yyyy' ) = ?", anio.toString(),
								StandardBasicTypes.STRING)))
				.setProjection(Projections.projectionList().add(Projections.max("pk.fecha"))).list();

		if (UValidador.esListaVacia(lista))
			return null;

		return (Date) lista.get(0);
	}

	@Override
	public Integer obtenerVeces(Integer empleado, Integer anio, Date fecha) {
		List lista = this.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("pk.conceptoacceso", "25"), Restrictions.ne("pk.fecha", fecha),
						Restrictions.sqlRestriction("to_char( FECHA , 'yyyy' ) = ?", anio.toString(),
								StandardBasicTypes.STRING)))
				.setProjection(Projections.projectionList().add(Projections.rowCount())).list();

		if (UValidador.esListaVacia(lista))
			return 0;

		return (Integer) lista.get(0);
	}

	@Override
	public List<DtoAsAutorizacion> generarAsistenciaOnomastico() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		CallableStatement callable = null;
		ResultSet rs = null;
		List<DtoAsAutorizacion> resultado = new ArrayList<>();

		// Se prepara el Statement
		callable = connection.prepareCall("{call SGCORESYS.SNp_Permiso_Onomastico (?)}");

		// Se registra el parametro de salida
		callable.registerOutParameter(1, oracle.jdbc.driver.OracleTypes.CURSOR);

		LOGGER.debug(">>>> SNp_Permiso_Onomastico.listar");

		// Se hace la llamada a la función.
		callable.executeQuery();

		// Se recoge el resultado del primer interrogante.
		rs = (ResultSet) callable.getObject(1);

		while (rs.next()) {
			logger.debug("si hay data");
			DtoAsAutorizacion obj = new DtoAsAutorizacion();
			obj.setEmpleado(rs.getInt("empleado"));
			obj.setDesde(rs.getDate("fecha"));
			obj.setConcepto(rs.getString("concepto"));
			obj.setFecha(rs.getDate("fecha"));
			obj.setFechahasta(rs.getDate("fecha"));
			resultado.add(obj);
		}

		return resultado;
	}


}