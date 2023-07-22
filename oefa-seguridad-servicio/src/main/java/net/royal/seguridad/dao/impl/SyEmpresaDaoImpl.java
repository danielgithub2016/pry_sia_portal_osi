package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.SyEmpresaDao;
import net.royal.seguridad.dominio.SyEmpresa;
import net.royal.seguridad.dominio.SyEmpresaPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("syEmpresaDaoImplSeguridad")
public class SyEmpresaDaoImpl extends GenericoDaoImpl<SyEmpresa, SyEmpresaPk>
		implements SyEmpresaDao {

	private static Log LOGGER = LogFactory.getLog(SyEmpresa.class);

	public SyEmpresaDaoImpl() {
		super("seguridad.syempresa");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerPais(String empresa) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empresa", empresa));
		cri.add(Restrictions.eq("estado", "A"));
		List<SyEmpresa> lista = this.listarPorCriterios(cri);

		if (lista == null)
			return "PER";

		if (lista.size() != 1)
			return "PER";

		return lista.get(0).getPais();
	}

}
