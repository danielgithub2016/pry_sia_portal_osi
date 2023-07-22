package net.royal.erp.mantenimiento.dao.impl;

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
import net.royal.erp.mantenimiento.dao.MeTipomantenimientogrupoDao;
import net.royal.erp.mantenimiento.dominio.MeTipomantenimientogrupo;
import net.royal.erp.mantenimiento.dominio.MeTipomantenimientogrupoPk;

@Repository
public class MeTipomantenimientogrupoDaoImpl extends GenericoDaoImpl<MeTipomantenimientogrupo, MeTipomantenimientogrupoPk> implements MeTipomantenimientogrupoDao {

	private static Log LOGGER = LogFactory.getLog(MeTipomantenimientogrupo.class);

	public MeTipomantenimientogrupoDaoImpl() {
		super("metipomantenimientogrupo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
