package net.royal.erp.core.dao.impl;

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
import net.royal.erp.core.dao.UltimonumeropagoDao;
import net.royal.erp.core.dominio.Ultimonumeropago;
import net.royal.erp.core.dominio.UltimonumeropagoPk;

@Repository
public class UltimonumeropagoDaoImpl extends GenericoDaoImpl<Ultimonumeropago, UltimonumeropagoPk> implements UltimonumeropagoDao {

	private static Log LOGGER = LogFactory.getLog(Ultimonumeropago.class);

	public UltimonumeropagoDaoImpl() {
		super("ultimonumeropago");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
