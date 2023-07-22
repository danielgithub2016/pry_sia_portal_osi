package net.royal.erp.presupuesto.servicio.impl;

import java.util.List;

import net.royal.erp.presupuesto.dao.BuNivelserviciomstDao;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.erp.presupuesto.servicio.BuNivelserviciomstServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioBuNivelserviciomst")
public class BuNivelserviciomstServicioImpl extends GenericoServicioImpl
		implements BuNivelserviciomstServicio {

	private BuNivelserviciomstDao dao;

	private static Log LOGGER = LogFactory
			.getLog(BuNivelserviciomstServicioImpl.class);

	@Autowired
	public void setDao(BuNivelserviciomstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public String obtenerDescripcion(String par_compania, Integer par_nivel) {
		return dao.obtenerDescripcion(par_compania, par_nivel);
	}

	@Override
	public List<BuNivelserviciomst> listarNivelServiciomst(String companiasocio) {
		return dao.listarNivelServiciomst(companiasocio);

	}

	@Override
	public List<BuNivelserviciomst> listarNivelporFiltos(String companiasocio,
			Integer[] object) {

		return dao.listarNivelporFiltos(companiasocio, object);
	}

	@Override
	public BuNivelserviciomst obtenerporRequerimiento(String compania,
			String req) {
		// TODO Auto-generated method stub
		BuNivelserviciomst retorno = null;
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.companiasocio", compania));
		cri.add(Restrictions.like("descripcion", req, MatchMode.ANYWHERE));

		List<BuNivelserviciomst> resultado = dao.listarPorCriterios(cri);

		if (!UValidador.esListaVacia(resultado)) {
			retorno = (BuNivelserviciomst) cri.list().get(0);
		}

		return retorno;
	}

	@Override
	public Integer obtenerSecuencia() {
		// TODO Auto-generated method stub
		Criteria cri = dao.getCriteria();

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.nivelservicio"));

		cri.setProjection(proj);

		return dao.incrementarInteger(cri);
	}

}
