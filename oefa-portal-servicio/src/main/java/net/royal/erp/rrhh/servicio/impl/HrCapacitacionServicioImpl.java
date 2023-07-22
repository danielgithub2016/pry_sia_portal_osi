package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dao.HrCapacitacionDao;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrCapacitacion;
import net.royal.erp.rrhh.servicio.HrCapacitacionServicio;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrCapacitacion")
public class HrCapacitacionServicioImpl extends GenericoServicioImpl implements HrCapacitacionServicio {

	private HrCapacitacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrCapacitacionServicioImpl.class);

	@Autowired
	public void setDao(HrCapacitacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public HrCapacitacion obtenerCapacitacionxparam(Integer curso, Integer anioplan) {
		return dao.obtenerCapacitacionxparam(curso, anioplan);
	}

	public HrCapacitacion obtenerAnioPlanxParam(String w_capacitacion) {
		return dao.obtenerAnioPlanxParam(w_capacitacion);
	}

	@Override
	public List<HrCapacitacion> listarPorAnioPlan(Integer anioPlan) {
		return dao.listarPorAnioPlan(anioPlan);
	}

	@Override
	public ParametroPaginacion listarCapacitacionPublicada(ParametroPaginacion paginacion) {
		Integer registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contar("hrcapacitacion.contarCapacitacionPublicadas", paginacion.getParametros());
		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), paginacion.getParametros(),
				"hrcapacitacion.listaCapacitacionPublicadas", paginacion.getClazz());

		paginacion.setRegistroEncontrados(registrosEncontrados);
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

	@Override
	public ParametroPaginacion listarCapacitacionDocumentoPendiente(ParametroPaginacion paginacion) {
		Integer registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contar("hrcapacitacion.contarCapacitacionDocumentoPendiente",
				paginacion.getParametros());
		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), paginacion.getParametros(),
				"hrcapacitacion.listarCapacitacionDocumentoPendiente", paginacion.getClazz());

		paginacion.setRegistroEncontrados(registrosEncontrados);
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

	@Override
	public List<DtoHrCapacitacion> listarCapacitacionPublicadas(String tipoRegistro, String nombreCurso) {
		return dao.listarCapacitacionPublicadas(tipoRegistro, nombreCurso);
	}

}
