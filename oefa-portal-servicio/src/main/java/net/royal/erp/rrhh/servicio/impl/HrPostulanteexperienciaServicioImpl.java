package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrPostulanteexperienciaDao;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.erp.rrhh.servicio.HrPostulanteexperienciaServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrPostulanteexperiencia")
public class HrPostulanteexperienciaServicioImpl extends GenericoServicioImpl
		implements HrPostulanteexperienciaServicio {

	private HrPostulanteexperienciaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPostulanteexperienciaServicioImpl.class);

	@Autowired
	@Qualifier("hrPostulanteexperienciaDaoImpl")
	public void setDao(HrPostulanteexperienciaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerTiempoExperienciaPostulante(String tipo, String postulante, Integer puesto) {
		DtoDwHrRequerimientoList res;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_postulante", String.class, postulante));

		if (!tipo.equals("P")) {
			res = (DtoDwHrRequerimientoList) dao.obtenerPorQuery(DtoDwHrRequerimientoList.class,
					"hrpostulanteexperiencia.tiempoexperienciapostulanteins", parametros);
		} else {
			parametros.add(new ParametroPersistenciaGenerico("par_puesto", Integer.class, puesto));
			res = (DtoDwHrRequerimientoList) dao.obtenerPorQuery(DtoDwHrRequerimientoList.class,
					"hrpostulanteexperiencia.tiempoexperienciapostulante", parametros);
		}

		res = (UValidador.esNulo(res) ? new DtoDwHrRequerimientoList() : res);

		Integer tiempo = (UValidador.esNulo(res.getNumerosolicitado()) ? 0 : res.getNumerosolicitado().intValue());

		return String.format("%06d", tiempo);
	}

}
