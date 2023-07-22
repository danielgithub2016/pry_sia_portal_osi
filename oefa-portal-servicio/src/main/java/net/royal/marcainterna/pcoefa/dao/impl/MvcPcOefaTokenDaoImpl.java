package net.royal.marcainterna.pcoefa.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.sistema.dominio.SyCampocalculado;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.marcainterna.pcoefa.dao.MvcPcOefaTokenDao;
import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;

@Repository
public class MvcPcOefaTokenDaoImpl extends GenericoDaoImpl<MvcPcOefaToken, BigDecimal> implements MvcPcOefaTokenDao {

	private static Log LOGGER = LogFactory.getLog(SyCampocalculado.class);

	public MvcPcOefaTokenDaoImpl() {
		super("MvcPcOefaTokenDaoImpl");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public MvcPcOefaToken obtenerPorToken(String token) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("tx_token", token));
		cri.add(Restrictions.eq("activo", "1"));

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return null;

		return (MvcPcOefaToken) lista.get(0);
	}

	@Override
	public MvcPcOefaToken obtenerPorEstado(String estado) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("activo", "1"));
		cri.add(Restrictions.eq("tx_estado", estado).ignoreCase());

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return null;

		return (MvcPcOefaToken) lista.get(0);
	}

}
