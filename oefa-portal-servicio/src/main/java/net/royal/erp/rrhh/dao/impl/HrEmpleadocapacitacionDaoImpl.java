package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEmpleadocapacitacionDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacionPk;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDwHrEvaluacionCapacitacionDetail;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository
public class HrEmpleadocapacitacionDaoImpl extends
		GenericoDaoImpl<HrEmpleadocapacitacion, HrEmpleadocapacitacionPk>
		implements HrEmpleadocapacitacionDao {

	public HrEmpleadocapacitacionDaoImpl() {
		super("hrempleadocapacitacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoDwHrEvaluacionCapacitacionDetail> dwHrEvaluacionCapacitacionDetail(
			Integer par_anioplan) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_anioplan",
				Integer.class, par_anioplan));
		return (List) this.listarPorQuery(
				DtoDwHrEvaluacionCapacitacionDetail.class,
				"hrempleadocapacitacion.dwhrevaluacioncapacitaciondetail", parametros);
	}
	
	@Override
	public List<HrEmpleadocapacitacion> obtenerPorCapacitacion(String capacitacion) {
		
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("pk.capacitacion", capacitacion));
		
		List<HrEmpleadocapacitacion> lista = this.listarPorCriterios(criteria);
		
		return lista;
	}
}
