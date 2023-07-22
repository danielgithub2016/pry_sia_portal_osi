package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrOrganigramaDao;
import net.royal.erp.rrhh.dominio.HrOrganigrama;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDWHrPosicionesHijosAllSelect;
import net.royal.erp.rrhh.servicio.HrOrganigramaServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrOrganigrama")
public class HrOrganigramaServicioImpl extends GenericoServicioImpl implements
		HrOrganigramaServicio {

	private HrOrganigramaDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrOrganigramaServicioImpl.class);

	@Autowired
	public void setDao(HrOrganigramaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List sp_hr_posicionempresa_hijosall(BigDecimal codigoposicion,
			String tipoplanilla) throws SQLException {
		return dao.sp_hr_posicionempresa_hijosall(codigoposicion, tipoplanilla);
	}

	@Override
	public List<HrOrganigrama> listarOrganigrama(String compania, Integer anio,
			Integer codigopuesto) {
		return dao.listarOrganigrama(compania, anio, codigopuesto);
	}

}
