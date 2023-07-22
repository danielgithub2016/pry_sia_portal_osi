package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrCentroestudios;
import net.royal.erp.rrhh.dominio.HrCentroestudiosPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrCentroEstudios;
import net.royal.framework.web.dao.GenericoDao;

public interface HrCentroestudiosDao extends GenericoDao<HrCentroestudios, HrCentroestudiosPk> {

	public List<DtoHrCentroEstudios> listarCentroEstudios(String s, String criterio);
	
}
