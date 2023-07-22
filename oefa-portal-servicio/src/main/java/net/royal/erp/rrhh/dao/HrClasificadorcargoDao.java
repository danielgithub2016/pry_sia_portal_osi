package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrClasificadorcargo;
import net.royal.erp.rrhh.dominio.HrClasificadorcargoPk;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantilla;

import java.util.List;

public interface HrClasificadorcargoDao extends GenericoDao<HrClasificadorcargo, HrClasificadorcargoPk> {

	public HrClasificadorcargo obtenerClasificadorCargoparam(String clasificadorcargo);
}
