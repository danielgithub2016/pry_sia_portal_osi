package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrOrganigrama;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrOrganigramaServicio extends GenericoServicio {

	public List sp_hr_posicionempresa_hijosall(BigDecimal codigoposicion,
			String tipoplanilla) throws SQLException;

	public List<HrOrganigrama> listarOrganigrama(String compania, Integer anio,
			Integer codigopuesto);
}
