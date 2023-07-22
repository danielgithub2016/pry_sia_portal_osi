package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.dominio.HrGradosalariomastPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrGradosalariomastDao extends
		GenericoDao<HrGradosalariomast, HrGradosalariomastPk> {

	public HrGradosalariomast obtenerGradoSalarioxParam(String gradosalario);

	public HrGradosalariomast obtenerGradoSalarioxCargo(String cargo);
	
	public List listarGradoSalario(String ls_familia);
}
