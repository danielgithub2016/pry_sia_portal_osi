package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrOrganigramaDao;
import net.royal.erp.rrhh.dominio.HrOrganigrama;
import net.royal.erp.rrhh.dominio.HrOrganigramaPk;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDWHrPosicionesHijosAllSelect;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import oracle.jdbc.OracleTypes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrOrganigramaDaoImpl extends
		GenericoDaoImpl<HrOrganigrama, HrOrganigramaPk> implements
		HrOrganigramaDao {

	private static Log LOGGER = LogFactory.getLog(HrOrganigrama.class);

	public HrOrganigramaDaoImpl() {
		super("hrorganigrama");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrOrganigrama> listarOrganigrama(String compania, Integer anio,
			Integer codigopuesto) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", compania));
		cri.add(Restrictions.eq("pk.ano", anio));
		cri.add(Restrictions.eq("codigopuesto", codigopuesto));

		return cri.list();
	}

	@Override
	public List sp_hr_posicionempresa_hijosall(BigDecimal codigoposicion,
			String tipoplanilla) throws SQLException {
		Connection connection = getConnection();
		CallableStatement callable = null;
		DtoDWHrPosicionesHijosAllSelect dto;
		List<DtoDWHrPosicionesHijosAllSelect> lista = null;
		callable = connection
				.prepareCall("{ CALL SGCORESYS.sp_hr_posicionempresa_hijosall (?,?, ? ) }");

		callable.setBigDecimal(1, codigoposicion);
		callable.setString(2, tipoplanilla);

		callable.registerOutParameter(3, OracleTypes.CURSOR);
		callable.executeQuery();
		ResultSet rs = (ResultSet) callable.getObject(3);
		lista = new ArrayList<DtoDWHrPosicionesHijosAllSelect>();
		while (rs.next()) {
			dto = new DtoDWHrPosicionesHijosAllSelect();

			dto.setCodigoposicion(rs.getBigDecimal("CODIGOPOSICION").intValue());
			dto.setDescripcion(rs.getString("DESCRIPCION"));
			dto.setCentrocostos(rs.getString("COSTCENTER"));

			dto.setLocalname(rs.getString("LOCALNAME"));

			lista.add(dto);
		}
		return lista;

	}

}
