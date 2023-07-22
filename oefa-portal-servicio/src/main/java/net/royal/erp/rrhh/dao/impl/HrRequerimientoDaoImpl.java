package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrRequerimientoDao;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.HrRequerimientoPk;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrRequerimientoDaoImpl extends GenericoDaoImpl<HrRequerimiento, HrRequerimientoPk>
		implements HrRequerimientoDao {

	private static Log LOGGER = LogFactory.getLog(HrRequerimiento.class);

	public HrRequerimientoDaoImpl() {
		super("hrrequerimiento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer obtenerMaximoRequerimiento(String companyowner, String unidadreplicacion) {
		// TODO Auto-generated method stub
		String maxreq = "0";
		Criteria cri = this.getCriteria();

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.requerimiento"));
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("unidadreplicacion", unidadreplicacion));

		cri.setProjection(proj);

		List results = cri.list();

		if (!UValidador.esListaVacia(results)) {
			if (!UValidador.esNulo(results.get(0))) {
				maxreq = (String) results.get(0);
				maxreq = maxreq.substring(unidadreplicacion.length(), maxreq.length());
				LOGGER.debug("maxreq " + maxreq);
			}
		}

		return Integer.parseInt(maxreq);
	}

	@Override
	public List<DtoDwHrRequerimientoList> listarRequerimientos(Integer par_codigopuesto, Integer p_codigoPuesto,
			String p_convocatoria, String p_tiporequerimiento, String p_compania, BigDecimal p_concurso,
			String p_tipoplanilla, Integer p_empleadoresponsable, BigDecimal p_codigoPosicionSolicitante,
			String p_fechas, String p_estado, String p_desierto, String p_numero, Date p_fini, Date p_ffin,
			Integer par_empleado, String par_validacion1, String par_validacion2) {

		List<DtoDwHrRequerimientoList> resultado;
		String query = obtenerSentenciaSqlPorQuery("hrrequerimiento.requerimientoListado");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_codigopuesto", Integer.class, par_codigopuesto));
		parametros.add(new ParametroPersistenciaGenerico("p_convocatoria", String.class, p_convocatoria));
		parametros.add(new ParametroPersistenciaGenerico("p_tiporequerimiento", String.class, p_tiporequerimiento));
		parametros.add(new ParametroPersistenciaGenerico("p_compania", String.class, p_compania));
		parametros.add(new ParametroPersistenciaGenerico("p_concurso", BigDecimal.class, p_concurso));
		parametros.add(new ParametroPersistenciaGenerico("p_numero", String.class, p_numero));
		parametros.add(new ParametroPersistenciaGenerico("p_tipoplanilla", String.class, p_tipoplanilla));
		parametros.add(new ParametroPersistenciaGenerico("p_codigoPuesto", Integer.class, p_codigoPuesto));
		parametros
				.add(new ParametroPersistenciaGenerico("p_empleadoresponsable", Integer.class, p_empleadoresponsable));
		parametros.add(new ParametroPersistenciaGenerico("p_codigoPosicionSolicitante", BigDecimal.class,
				p_codigoPosicionSolicitante));

		parametros.add(new ParametroPersistenciaGenerico("par_validacion1", String.class, par_validacion1));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_validacion2", String.class, par_validacion2));

		if (!UValidador.estaVacio(p_estado)) {
			if (p_estado.equals("AE")) {
				query = query.replace("[FILTROESTADO]", " and  HR_Requerimiento.Estado in('AP', 'EV')");
			} else if (p_estado.equals("RP")) {
				query = query.replace("[FILTROESTADO]", " and  HR_Requerimiento.Estado in('PR', 'RE')");
			} else if (p_estado.equals("EV")) {
				query = query.replace("[FILTROESTADO]", " and  HR_Requerimiento.Estado in('OA', 'EV')");
			} else {
				query = query.replace("[FILTROESTADO]", " and HR_Requerimiento.Estado = '" + p_estado + "'");
			}

		} else {
			query = query.replace("[FILTROESTADO]", "");
		}

		if (!UValidador.estaVacio(p_fechas)) {
			parametros.add(new ParametroPersistenciaGenerico("p_fini", Date.class, p_fini));
			parametros.add(new ParametroPersistenciaGenerico("p_ffin", Date.class, p_ffin));

			query = query.replace("[FILTROFECHAS]", p_fechas);
		} else {
			query = query.replace("[FILTROFECHAS]", "");
		}

		if (!UValidador.estaVacio(p_desierto)) {
			if (p_desierto.equals("N")) {
				query = query.replace("[FILTRODESIERTO]",
						" and HR_Requerimiento.flagdesierto is null or HR_Requerimiento.flagdesierto = 'N'");
			} else {
				query = query.replace("[FILTRODESIERTO]", " and HR_Requerimiento.flagdesierto = 'S'");
			}
		} else {
			query = query.replace("[FILTRODESIERTO]", "");
		}
		List data = listarPorSentenciaSQL(DtoDwHrRequerimientoList.class, new StringBuilder(query), parametros);

		return data;
	}

}
