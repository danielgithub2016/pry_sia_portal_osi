package net.royal.erp.planilla.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.planilla.dao.PrTipoplanillaDao;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.PrTipoplanillaPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class PrTipoplanillaDaoImpl extends GenericoDaoImpl<PrTipoplanilla, PrTipoplanillaPk>
		implements PrTipoplanillaDao {

	private static Log LOGGER = LogFactory.getLog(PrTipoplanilla.class);

	public PrTipoplanillaDaoImpl() {
		super("prtipoplanilla");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<PrTipoplanilla> ListarTipoPlanilla() {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("descripcion"));

		List<PrTipoplanilla> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
	}

	@Override
	public List<PrTipoplanilla> listaTipoPlanillaSeguridad(String todos, String... tiposplanilla) {
		Criteria cri = this.getCriteria();
		if (!UValidador.validarFlag(todos)) {
			cri.add(Restrictions.in("pk.tipoplanilla", tiposplanilla));
		}
		cri.addOrder(Order.asc("descripcion"));
		return this.listarPorCriterios(cri);
	}

}
