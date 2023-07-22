package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadocursosDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocursos;
import net.royal.erp.rrhh.servicio.HrEmpleadocursosServicio;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEmpleadocursos")
public class HrEmpleadocursosServicioImpl extends GenericoServicioImpl implements HrEmpleadocursosServicio {

	private HrEmpleadocursosDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEmpleadocursosServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadocursosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<MensajeUsuario> validar(accion_solicitada accionPantalla, HrEmpleadocursos bean) {
		return null;
	}
	
	@Override
	public List<HrEmpleadocursos> listarPorEmpleado(Integer empleado,String curso,String capacitaciones) {
		return dao.listarPorEmpleado(empleado, curso, capacitaciones);
	}

	@Override
	public List<HrEmpleadocursos> listarPorEmpleadoMateriales(String curso) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("curso", String.class, curso));
		List lista = dao.listarPorQuery(HrEmpleadocursos.class, "hrempleadocursos.listarMateriales",parametros);
		return lista;
	}

}
