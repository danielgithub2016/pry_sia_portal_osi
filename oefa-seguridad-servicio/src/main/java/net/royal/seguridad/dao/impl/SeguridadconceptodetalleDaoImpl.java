package net.royal.seguridad.dao.impl;

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
import net.royal.seguridad.dao.SeguridadconceptodetalleDao;
import net.royal.seguridad.dominio.Seguridadconceptodetalle;
import net.royal.seguridad.dominio.SeguridadconceptodetallePk;

@Repository("seguridadconceptodetalleDaoImplSeguridad")
public class SeguridadconceptodetalleDaoImpl extends GenericoDaoImpl<Seguridadconceptodetalle, SeguridadconceptodetallePk> implements SeguridadconceptodetalleDao {

	private static Log LOGGER = LogFactory.getLog(Seguridadconceptodetalle.class);

	public SeguridadconceptodetalleDaoImpl() {
		super("seguridad.seguridadconceptodetalle");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
