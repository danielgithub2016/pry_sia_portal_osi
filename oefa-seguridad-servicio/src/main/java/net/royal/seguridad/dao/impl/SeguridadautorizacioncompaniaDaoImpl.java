package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.SeguridadautorizacioncompaniaDao;
import net.royal.seguridad.dominio.Seguridadautorizacioncompania;
import net.royal.seguridad.dominio.SeguridadautorizacioncompaniaPk;

@Repository("seguridadautorizacioncompaniaDaoImplSeguridad")
public class SeguridadautorizacioncompaniaDaoImpl
		extends GenericoDaoImpl<Seguridadautorizacioncompania, SeguridadautorizacioncompaniaPk>
		implements SeguridadautorizacioncompaniaDao {

	private static Log LOGGER = LogFactory.getLog(Seguridadautorizacioncompania.class);

	public SeguridadautorizacioncompaniaDaoImpl() {
		super("seguridad.seguridadautorizacioncompania");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerCompania(String codigousuario) {
		// TODO Auto-generated method stub
		Criteria cri = getCriteria();
		cri.add(Restrictions.eq("pk.usuario", codigousuario));

		List<Seguridadautorizacioncompania> resultado = listarPorCriterios(cri);

		if (!UValidador.esListaVacia(resultado)) {
			return resultado.get(0).getPk().getCompanyowner();
		}

		return null;
	}

}
