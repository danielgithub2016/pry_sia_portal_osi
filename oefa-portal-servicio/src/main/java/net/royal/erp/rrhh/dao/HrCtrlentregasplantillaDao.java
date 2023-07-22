package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantilla;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantillaPk;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;

import java.util.List;

public interface HrCtrlentregasplantillaDao extends GenericoDao<HrCtrlentregasplantilla, HrCtrlentregasplantillaPk> {

	public HrCtrlentregasplantilla obtenerplantillaparam(String plantilla);
}
