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
import net.royal.seguridad.dao.CompaniamastDao;
import net.royal.seguridad.dominio.Companiamast;
import net.royal.seguridad.dominio.CompaniamastPk;
import net.royal.seguridad.dominio.dto.DtoCompaniamast;
import net.royal.seguridad.servicio.CompaniamastServicio;

@Service (value = "BeanServicioCompaniamastSeguridad")
public class CompaniamastServicioImpl extends GenericoServicioImpl implements CompaniamastServicio {

	private CompaniamastDao dao;

	private static Log LOGGER = LogFactory.getLog(CompaniamastServicioImpl.class);

	@Autowired
	@Qualifier("companiamastDaoImplSeguridad")
	public void setDao(CompaniamastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	

	@Override
	public List<DtoCompaniamast> listarSelector() {
		List lista = dao.listarPorQuery(DtoCompaniamast.class,
				"seguridad.companiamast.listarSelector");
		return lista;
	}

	@Override
	public Integer buscarCompaniaIgual(String companiaCodigo) {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("pk.companiacodigo", companiaCodigo));
		List igual = dao.listarPorCriterios(c);
		return igual != null ? igual.size() : 0;
	}

	@Override
	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion) {
		Integer registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contar("seguridad.companiamast.contar",
				paginacion.getParametros());
		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), paginacion.getParametros(),
				"seguridad.companiamast.listar", paginacion.getClazz());

		paginacion.setRegistroEncontrados(registrosEncontrados);
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

}
