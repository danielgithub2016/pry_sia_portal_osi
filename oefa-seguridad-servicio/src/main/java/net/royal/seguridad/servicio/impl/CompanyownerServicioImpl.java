package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.CompanyownerDao;
import net.royal.seguridad.dominio.Companyowner;
import net.royal.seguridad.dominio.CompanyownerPk;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.servicio.CompanyownerServicio;

@Service (value = "BeanServicioCompanyownerSeguridad")
public class CompanyownerServicioImpl extends GenericoServicioImpl implements CompanyownerServicio {

	private CompanyownerDao dao;

	private static Log LOGGER = LogFactory.getLog(CompanyownerServicioImpl.class);

	@Autowired
	@Qualifier("companyownerDaoImplSeguridad")
	public void setDao(CompanyownerDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Companyowner obtenerPorCodigoCompanyOwner(String codigoCompanyOwner) {
		List<Companyowner> lista=null;
		
		Criteria criteria = dao.getCriteria();
		criteria.add(Restrictions.eq("pk.companyowner", codigoCompanyOwner));
		lista = dao.listarPorCriterios(criteria);
		
		if (lista == null) {
			LOGGER.debug("listCompanyowner es null");
			return null;
		}

		if (lista.size() == 0) {
			LOGGER.debug("listCompanyowner size = 0");
			return null;
		}

		if (lista.size() > 1) {
			LOGGER.debug("listCompanyowner size > 1");
			return null;
		}
		
		return lista.get(0);
	}
	

	@Override
	public Integer buscarOwnerIgual(String companyowner) {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("pk.companyowner", companyowner));
		List igual = dao.listarPorCriterios(c);

		return igual != null ? igual.size() : 0;
	}

	@Override
	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion) {
		Integer registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contar(
				"seguridad.companyowner.contarsocios",
				paginacion.getParametros());
		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), paginacion.getParametros(),
				"seguridad.companyowner.listarsocios", paginacion.getClazz());

		paginacion.setRegistroEncontrados(registrosEncontrados);
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

}
