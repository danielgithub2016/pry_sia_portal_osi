package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEvaluacionDao;
import net.royal.erp.rrhh.dominio.HrEvaluacion;
import net.royal.erp.rrhh.dominio.HrEvaluacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacion;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrEvaluacionDaoImpl extends GenericoDaoImpl<HrEvaluacion, HrEvaluacionPk> implements HrEvaluacionDao {

	private static Log LOGGER = LogFactory.getLog(HrEvaluacion.class);

	public HrEvaluacionDaoImpl() {
		super("hrevaluacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<DtoHrEvaluacion> listarDescripcion() {
		List datos = this.listarPorQuery(DtoHrEvaluacion.class,
				"hrevaluacion.listaEvaluacion");
	
		return datos;
	}

}
