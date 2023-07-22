package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.AccountmstDao;
import net.royal.erp.core.dao.ObligacionesDao;
import net.royal.erp.core.dao.TipodocumentocxpDao;
import net.royal.erp.core.dominio.Obligaciones;
import net.royal.erp.core.dominio.ObligacionesPk;
import net.royal.erp.core.dominio.Tipodocumentocxp;
import net.royal.erp.core.dominio.TipodocumentocxpPk;

@Repository
public class ObligacionesDaoImpl extends GenericoDaoImpl<Obligaciones, ObligacionesPk> implements ObligacionesDao {

	private static Log LOGGER = LogFactory.getLog(Obligaciones.class);
	private TipodocumentocxpDao dapTipodocumentocxp;
	
	public ObligacionesDaoImpl() {
		super("obligaciones");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Obligaciones obtenerPorId(BigDecimal proveedor, String tipodocumento,
			String numerodocumento) {
		
		Obligaciones obj = this.obtenerPorId(new ObligacionesPk(proveedor,tipodocumento,numerodocumento));
		if (obj!=null)
		{
			Tipodocumentocxp tipodocumentocxp = null;;			
			tipodocumentocxp = dapTipodocumentocxp.obtenerPorId(new TipodocumentocxpPk(tipodocumento));
			obj.setTipodocumentocxp(tipodocumentocxp);
		}
		return obj;
	}

}
