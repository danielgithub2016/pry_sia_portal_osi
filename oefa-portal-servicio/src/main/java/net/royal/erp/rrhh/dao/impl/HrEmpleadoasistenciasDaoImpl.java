package net.royal.erp.rrhh.dao.impl;

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
import net.royal.erp.rrhh.dao.HrEmpleadoasistenciasDao;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrEmpleadoasistencias;
import net.royal.erp.rrhh.dominio.HrEmpleadoasistenciasPk;

@Repository
public class HrEmpleadoasistenciasDaoImpl extends GenericoDaoImpl<HrEmpleadoasistencias, HrEmpleadoasistenciasPk> implements HrEmpleadoasistenciasDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadoasistencias.class);

	public HrEmpleadoasistenciasDaoImpl() {
		super("hrempleadoasistencias");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadoasistencias> ListarEmpleadosAsistencias(
			String capacitacion) {
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.capacitacion", capacitacion));
		
		List<HrEmpleadoasistencias> datos = this.listarPorCriterios(cri);
		if(UValidador.esListaVacia(datos))
			return null;
		
		return datos;
	}

}
