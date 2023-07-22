package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEvaluacionDao;
import net.royal.erp.rrhh.dao.HrEvaluacionRequerimientoDao;
import net.royal.erp.rrhh.dominio.HrEvaluacion;
import net.royal.erp.rrhh.dominio.HrEvaluacionPk;
import net.royal.erp.rrhh.dominio.HrEvaluacionRequerimiento;
import net.royal.erp.rrhh.dominio.HrEvaluacionRequerimientoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionRequirimiento;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrEvaluacionRequerimientoDaoImpl extends GenericoDaoImpl<HrEvaluacionRequerimiento, HrEvaluacionRequerimientoPk> 
	implements HrEvaluacionRequerimientoDao {

	private static Log LOGGER = LogFactory.getLog(HrEvaluacion.class);

	public HrEvaluacionRequerimientoDaoImpl() {
		super("hrevaluacionrequerimiento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<DtoHrEvaluacionRequirimiento> listarDescripcion() {
		
		List datos = this.listarPorQuery(DtoHrEvaluacionRequirimiento.class,
				"hrevaluacionrequerimiento.listaRequerimiento");
	
		return datos;
	}

}
