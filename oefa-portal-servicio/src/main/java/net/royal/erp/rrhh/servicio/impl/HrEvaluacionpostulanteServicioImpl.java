package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrEvaluacionpostulanteDao;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoevalentrevistaEditB;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoevalpostEdit2;
import net.royal.erp.rrhh.servicio.HrEvaluacionpostulanteServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

/**
 * The Class HrEvaluacionpostulanteServicioImpl.
 */
@Service(value = "BeanServicioHrEvaluacionpostulante")
public class HrEvaluacionpostulanteServicioImpl extends GenericoServicioImpl implements HrEvaluacionpostulanteServicio {
	private static Log LOGGER = LogFactory.getLog(HrEvaluacionpostulanteServicioImpl.class);
	private HrEvaluacionpostulanteDao dao;

	@Autowired
	public void setDao(HrEvaluacionpostulanteDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoDwHrRequerimientoevalentrevistaEditB> listaEtapasPorEvaluacion(String companyowner,
			String requerimiento) {
		LOGGER.debug("listaEtapasPorEvaluacion");
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorQuery(DtoDwHrRequerimientoevalentrevistaEditB.class,
				"hrevaluacionpostulante.dwhrrequerimientoevalentrevistaeditb", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoDwHrRequerimientoevalpostEdit2> listaResumenEtapaPorEvaluacion(String companyowner,
			String requerimiento) {
		LOGGER.debug("listaResumenEtapaPorEvaluacion");
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorQuery(DtoDwHrRequerimientoevalpostEdit2.class,
				"hrevaluacionpostulante.dwhrrequerimientoevalpostedit2", parametros);
	}
}
