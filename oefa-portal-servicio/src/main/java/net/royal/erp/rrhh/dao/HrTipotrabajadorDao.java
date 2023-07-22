package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrTipotrabajador;
import net.royal.erp.rrhh.dominio.HrTipotrabajadorPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrTipotrabajadorDao extends GenericoDao<HrTipotrabajador, HrTipotrabajadorPk> {

	public List<HrTipotrabajador> listarTipoTrabajadorActivo();
}
