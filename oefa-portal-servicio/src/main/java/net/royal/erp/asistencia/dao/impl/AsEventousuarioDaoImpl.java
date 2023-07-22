package net.royal.erp.asistencia.dao.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsEventousuarioDao;
import net.royal.erp.asistencia.dominio.AsEventousuario;
import net.royal.erp.asistencia.dominio.AsEventousuarioPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository
public class AsEventousuarioDaoImpl extends
		GenericoDaoImpl<AsEventousuario, AsEventousuarioPk> implements
		AsEventousuarioDao {

	private static Log LOGGER = LogFactory.getLog(AsEventousuario.class);

	public AsEventousuarioDaoImpl() {
		super("aseventousuario");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public BigDecimal incrementarEventoUsuario(String userId) {
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.eq("pk.userid", userId))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("pk.idevento")));

		return this.incrementarBigDecimal(cri);
	}

}
