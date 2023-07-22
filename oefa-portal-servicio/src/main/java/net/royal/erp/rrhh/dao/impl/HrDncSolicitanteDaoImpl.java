package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrDncSolicitanteDao;
import net.royal.erp.rrhh.dominio.HrDncSolicitante;
import net.royal.erp.rrhh.dominio.HrDncSolicitantePk;
import net.royal.erp.rrhh.dominio.dto.DtoPuestoCapacitacion;

@Repository
public class HrDncSolicitanteDaoImpl extends GenericoDaoImpl<HrDncSolicitante, HrDncSolicitantePk>
		implements HrDncSolicitanteDao {

	private static Log LOGGER = LogFactory.getLog(HrDncSolicitante.class);

	public HrDncSolicitanteDaoImpl() {
		super("hrdncsolicitante");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer cantHrDncSolicitantePuesto(String wsbuscar1, String wsbuscar2, String wsbuscar3, String wsbuscar4) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("wsbuscar1", String.class, wsbuscar1));
		parametros.add(new ParametroPersistenciaGenerico("wsbuscar2", String.class, wsbuscar2));
		parametros.add(new ParametroPersistenciaGenerico("wsbuscar3", String.class, wsbuscar3));
		parametros.add(new ParametroPersistenciaGenerico("wsbuscar4", String.class, wsbuscar4));

		return this.contar("hrdncsolicitante.cantHrDncSolicitantePuesto", parametros);
	}

	@Override
	public Integer cantHrDncSolicitanteArea(String wsbuscar1, String wsbuscar2, String wsbuscar3, String wsbuscar4) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("wsbuscar1", String.class, wsbuscar1));
		parametros.add(new ParametroPersistenciaGenerico("wsbuscar2", String.class, wsbuscar2));
		parametros.add(new ParametroPersistenciaGenerico("wsbuscar3", String.class, wsbuscar3));
		parametros.add(new ParametroPersistenciaGenerico("wsbuscar4", String.class, wsbuscar4));

		return this.contar("hrdncsolicitante.cantHrDncSolicitanteArea", parametros);

	}

	@Override
	public Integer obtenerMaximoSolicitante(String iv_compania) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", iv_compania));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));

		cri.setProjection(proj);
		List lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return 0;

		return (Integer) lista.get(0);

	}

	@Override
	public Integer obtenerSecuencia(String iv_compania, String estado, Integer wiCurso) {

		Integer wiSecuencia = 0;
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", iv_compania));
		cri.add(Restrictions.eq("curso", wiCurso));
		cri.add(Restrictions.eq("estado", estado));

		List<HrDncSolicitante> lista = this.listarPorCriterios(cri);

		if (!UValidador.esListaVacia(lista)) {
			wiSecuencia = lista.get(0).getPk().getSecuencia();
		}

		return wiSecuencia;

	}

	@Override
	@Transactional
	public void grabarDncSolicitanteArea(String wsflagpuesto, String wsPuesto, String wsflagarea, String wsArea,
			String iv_compania, Integer wiSecuencia) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("wsflagpuesto", String.class, wsflagpuesto));
		parametros.add(new ParametroPersistenciaGenerico("wsPuesto", String.class, wsPuesto));
		parametros.add(new ParametroPersistenciaGenerico("wsflagarea", String.class, wsflagarea));
		parametros.add(new ParametroPersistenciaGenerico("wsArea", String.class, wsArea));
		parametros.add(new ParametroPersistenciaGenerico("iv_compania", String.class, iv_compania));
		parametros.add(new ParametroPersistenciaGenerico("wiSecuencia", Integer.class, wiSecuencia));

		this.ejecutarPorQuery("hrdncsolicitante.grabarDncSolicitanteArea", parametros);

	}

	@Override
	public void insertarDncSolicitante(HrDncSolicitante solicitante) {

		this.registrar(solicitante);

	}

	@Override
	@Transactional
	public void insertarHrPuestoNecesidadCapacita(String compania, Integer secuencia, Integer puesto) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("compania", String.class, compania));
		parametros.add(new ParametroPersistenciaGenerico("secuencia", Integer.class, secuencia));
		parametros.add(new ParametroPersistenciaGenerico("puesto", Integer.class, puesto));

		this.ejecutarPorQuery("hrdncsolicitante.insertarPuestoCapacita", parametros);
	}

	@Override
	public List<DtoPuestoCapacitacion> obtenerPuestoCapacitacion(String compania, Integer secuencia) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("compania", String.class, compania));
		parametros.add(new ParametroPersistenciaGenerico("secuencia", Integer.class, secuencia));

		List datos = this.listarPorQuery(DtoPuestoCapacitacion.class, "hrdncsolicitante.obtenerPuestoCapacita",
				parametros);

		return datos;

	}

}
