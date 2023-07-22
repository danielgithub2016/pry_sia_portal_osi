package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPuestofunciones;
import net.royal.erp.rrhh.dominio.HrPuestofuncionesPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrPuestofuncionesDao extends GenericoDao<HrPuestofunciones, HrPuestofuncionesPk> {

	public List<HrPuestofunciones> listarFunciones(Integer par_codigopuesto);
}
