package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.ParametrosmastDao;
import net.royal.seguridad.dominio.Parametrosmast;
import net.royal.seguridad.dominio.ParametrosmastPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("parametrosmastDaoImplSeguridad")
public class ParametrosmastDaoImpl extends GenericoDaoImpl<Parametrosmast, ParametrosmastPk>
		implements ParametrosmastDao {

	private static Log LOGGER = LogFactory.getLog(Parametrosmast.class);

	public ParametrosmastDaoImpl() {
		super("seguridad.parametrosmast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerValorCadena(String companiacodigo, String aplicacioncodigo, String parametroclave) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiacodigo", companiacodigo));
		cri.add(Restrictions.eq("pk.aplicacioncodigo", aplicacioncodigo));
		cri.add(Restrictions.eq("pk.parametroclave", parametroclave));
		cri.add(Restrictions.eq("estado", "A"));

		List<Parametrosmast> list = this.listarPorCriterios(cri);

		if (list == null)
			return null;
		if (list.size() != 1)
			return null;

		return list.get(0).getTexto();
	}

	@Override
	public String obtenerValorCadena(String parametroclave) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.parametroclave", parametroclave));
		cri.add(Restrictions.eq("estado", "A"));

		List<Parametrosmast> list = this.listarPorCriterios(cri);

		if (list == null)
			return null;
		if (list.size() != 1)
			return null;
		
		System.out.println("loginnet " + list.get(0).getTexto());

		return list.get(0).getTexto();
	}

	@Override
	public String obtenerValorExplicacion(ParametrosmastPk pk) {
		Parametrosmast obj = obtenerPorId(pk, false);
		if (!UValidador.esNulo(obj))
			return obj.getExplicacion();
		return null;
	}

}
