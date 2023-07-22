package net.royal.erp.rrhh.dao;

import net.royal.erp.rrhh.dominio.HrRequerimientoAdjunto;
import net.royal.erp.rrhh.dominio.HrRequerimientoAdjuntoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrRequerimientoAdjuntoDao extends
GenericoDao<HrRequerimientoAdjunto, HrRequerimientoAdjuntoPk>{
	public Integer obtenerMaxmimo(String requerimiento,String compania);
}
