package net.royal.erp.rrhh.dao.impl;

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
import net.royal.erp.rrhh.dao.HrBsLineadeaccionDao;
import net.royal.erp.rrhh.dominio.HrBsLineadeaccion;
import net.royal.erp.rrhh.dominio.HrBsLineadeaccionPk;

@Repository
public class HrBsLineadeaccionDaoImpl extends GenericoDaoImpl<HrBsLineadeaccion, HrBsLineadeaccionPk> implements HrBsLineadeaccionDao {

	private static Log LOGGER = LogFactory.getLog(HrBsLineadeaccion.class);

	public HrBsLineadeaccionDaoImpl() {
		super("hrbslineadeaccion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
