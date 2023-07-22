package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEmpleadocomentariosDao;
import net.royal.erp.rrhh.servicio.HrEmpleadocomentariosServicio;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentariosPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;

@Service (value = "BeanServicioHrEmpleadocomentarios")
public class HrEmpleadocomentariosServicioImpl extends GenericoServicioImpl implements HrEmpleadocomentariosServicio {

	private HrEmpleadocomentariosDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEmpleadocomentariosServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadocomentariosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrEmpleadocomentarios> obtenerListaComentarios(String companyowner, Integer empleado, Integer secuenciaeval, Integer empleadoevaluador){
		return dao.obtenerListaComentarios(companyowner, empleado, secuenciaeval, empleadoevaluador);
	}

	@Override
	@Transactional
	public void grabardwComentario(List<HrEmpleadocomentarios> dwComentario) {
	dao.grabardwComentario(dwComentario);
	}
	
	
}
