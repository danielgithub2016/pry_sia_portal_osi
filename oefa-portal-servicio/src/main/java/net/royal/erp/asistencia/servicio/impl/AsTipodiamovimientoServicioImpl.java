package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.dao.AsTipodiamovimientoDao;
import net.royal.erp.asistencia.dominio.dto.DtoAsTipodiamovimiento;
import net.royal.erp.asistencia.servicio.AsTipodiamovimientoServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsTipodiamovimiento")
public class AsTipodiamovimientoServicioImpl extends GenericoServicioImpl implements AsTipodiamovimientoServicio {

	private AsTipodiamovimientoDao dao;

	private static Log LOGGER = LogFactory.getLog(AsTipodiamovimientoServicioImpl.class);

	@Autowired
	public void setDao(AsTipodiamovimientoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List obtenerMaxHoraInicioMaxHoraFin(Integer tipodia) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));
		return dao.listarPorQuery(DtoAsTipodiamovimiento.class, "astipodiamovimiento.obtenerMaxHoraInicioMaxHoraFin",
				filtros);
	}

	@Override
	public List obtenerHoraInicioFlagDiaAnterior(Integer tipodia) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));
		return dao.listarPorQuery(DtoAsTipodiamovimiento.class, "astipodiamovimiento.obtenerHoraInicioFlagDiaAnterior",
				filtros);
	}

	@Override
	public List obtenerHoraFin(Integer tipodia) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));
		return dao.listarPorQuery(DtoAsTipodiamovimiento.class, "astipodiamovimiento.obtenerHoraFin", filtros);
	}

	@Override
	public List obtenerMaxIntervaloAcceso(Integer tipodia) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));
		return dao.listarPorQuery(DtoAsTipodiamovimiento.class, "astipodiamovimiento.obtenerMaxIntervaloAcceso",
				filtros);
	}

	@Override
	public List obtenerIntervaloRefrigerio(Integer tipodia) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));
		return dao.listarPorQuery(DtoAsTipodiamovimiento.class, "astipodiamovimiento.obtenerIntervaloRefrigerio",
				filtros);
	}

	@Override
	public List listar(Integer tipodia) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_tipodia", Integer.class, tipodia));
		return dao.listarPorQuery(DtoAsTipodiamovimiento.class, "astipodiamovimiento.listar", filtros);
	}
}
