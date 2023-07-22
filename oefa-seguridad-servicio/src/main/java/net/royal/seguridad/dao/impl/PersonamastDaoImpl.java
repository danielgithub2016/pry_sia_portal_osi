package net.royal.seguridad.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.seguridad.dao.PersonamastDao;
import net.royal.seguridad.dominio.Personamast;
import net.royal.seguridad.dominio.PersonamastPk;

@Repository("personamastDaoImplSeguridad")
public class PersonamastDaoImpl extends GenericoDaoImpl<Personamast, PersonamastPk> implements PersonamastDao {

	private static Log LOGGER = LogFactory.getLog(Personamast.class);

	public PersonamastDaoImpl() {
		super("seguridad.personamast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Personamast obtenerPorUsuario(String usuario) {
		// TODO Auto-generated method stub
		Criteria cri = getCriteria();
		cri.add(Restrictions.eq("codigousuario", usuario).ignoreCase());

		List<Personamast> resultado = listarPorCriterios(cri);

		if (!UValidador.esListaVacia(resultado)) {
			return resultado.get(0);
		}

		return null;
	}

}
