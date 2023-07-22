package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrOrganigrama;
import net.royal.erp.rrhh.dominio.HrOrganigramaPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrOrganigramaDao extends
		GenericoDao<HrOrganigrama, HrOrganigramaPk> {

	public List sp_hr_posicionempresa_hijosall(BigDecimal codigoposicion,
			String tipoplanilla) throws SQLException;

	public List<HrOrganigrama> listarOrganigrama(String compania, Integer anio,
			Integer codigopuesto);
}
