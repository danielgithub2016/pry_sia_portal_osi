package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrEmpleadocursosDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocursos;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosPk;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;

@Repository
public class HrEmpleadocursosDaoImpl extends GenericoDaoImpl<HrEmpleadocursos, HrEmpleadocursosPk> implements HrEmpleadocursosDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadocursos.class);

	public HrEmpleadocursosDaoImpl() {
		super("hrempleadocursos");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadocursos> listarPorEmpleado(Integer empleado, String curso, String capacitaciones) {
		
		List<DtoDwHrRequerimientoList> resultado;
		String query = obtenerSentenciaSqlPorQuery("hrempleadocursos.listarPorEmpleado");
		
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		List lista;
		parametros.add(new ParametroPersistenciaGenerico("empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("curso", String.class, curso));
		
		
		if (!UValidador.esNulo(capacitaciones)) {
			query = query.replace("[FILTROCAPACITACIONES]", "  AND  CAP.CAPACITACION IN("+ capacitaciones +")");
			
			LOGGER.debug("query::" + query);
		}else{
			query = query.replace("[FILTROCAPACITACIONES]", "");
		}
			
		List data = listarPorSentenciaSQL(HrEmpleadocursos.class, new StringBuilder(query), parametros);

		return data;
		

		
	}

}
