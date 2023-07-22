package net.royal.erp.planilla.dao.impl;


import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.planilla.dao.PrTipoProcesoDao;
import net.royal.erp.planilla.dominio.PrTipoProceso;
import net.royal.erp.planilla.dominio.PrTipoProcesoPk;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings("serial")
@Repository
public class PrTipoProcesoDaoImpl extends GenericoDaoImpl<PrTipoProceso, PrTipoProcesoPk>
		implements PrTipoProcesoDao {

	private static Log LOGGER = LogFactory.getLog(PrTipoProceso.class);

	public PrTipoProcesoDaoImpl() {
		super("prtipoproceso");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}


}
