package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrCapacitacionDao;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrCapacitacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrCapacitacion;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

@Repository
public class HrCapacitacionDaoImpl extends
		GenericoDaoImpl<HrCapacitacion, HrCapacitacionPk> implements
		HrCapacitacionDao {

	private static Log LOGGER = LogFactory.getLog(HrCapacitacion.class);

	public HrCapacitacionDaoImpl() {
		super("hrcapacitacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public HrCapacitacion obtenerCapacitacionxparam(Integer curso, Integer anioplan) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("curso", curso));
		cri.add(Restrictions.eq("anioplan", anioplan));
		cri.add(Restrictions.eq("estado", "P"));

		List<HrCapacitacion> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos.get(0);
	}

	public HrCapacitacion obtenerAnioPlanxParam(String w_capacitacion) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.capacitacion", w_capacitacion));

		List<HrCapacitacion> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos.get(0);
	}

	@Override
	public List<HrCapacitacion> listarPorAnioPlan(Integer anioPlan) {
		return this.listarPorCriterios(this.getCriteria().add(
				Restrictions.and(Restrictions.eq("estado", "P"),
						Restrictions.eq("anioplan", anioPlan))));
	}

	@Override
	public List<DtoHrCapacitacion> listarCapacitacionPublicadas(String tipoRegistro, String nombreCurso) {
		String query = obtenerSentenciaSqlPorQuery("hrcapacitacion.listaCapacitacionPublicas");
		
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		List lista;
		parametros.add(new ParametroPersistenciaGenerico("curso", String.class, nombreCurso));
		
		if (!UValidador.esNulo(tipoRegistro)) {
			query = query.replace("[FILTROTIPOCAPA]", " AND CAPA.TIPO_REG IN ("+ tipoRegistro +")");
			
			LOGGER.debug("query::" + query);
		}else{
			query = query.replace("[FILTROTIPOCAPA]", "");
		}
			
		List data = listarPorSentenciaSQL(DtoHrCapacitacion.class, new StringBuilder(query), parametros);
		
		return data;
	}
}
