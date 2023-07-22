package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.MaCts;
import net.royal.erp.core.dominio.MaCtsPk;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.planilla.dominio.dto.DtoPeriodos;

import java.util.List;

public interface MaCtsDao extends GenericoDao<MaCts, MaCtsPk> {

	public List<MaCts> obtenerCombo();
	public List<DtoPeriodos> obtenerPeriodos();
}
