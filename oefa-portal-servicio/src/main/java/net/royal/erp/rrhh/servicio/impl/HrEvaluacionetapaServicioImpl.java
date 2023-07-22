package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrEvaluacionetapaDao;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwRequerimientoevaletapasEdit;
import net.royal.erp.rrhh.servicio.HrEvaluacionetapaServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

/**
 * The Class HrEvaluacionetapaServicioImpl.
 */
@Service(value = "BeanServicioHrEvaluacionetapa")
public class HrEvaluacionetapaServicioImpl extends GenericoServicioImpl implements HrEvaluacionetapaServicio {
	private HrEvaluacionetapaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionetapaServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionetapaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DtoDwRequerimientoevaletapasEdit> listarEtapaPorEvaluacion(String requerimiento, String companyowner) {
		LOGGER.debug("listarEtapaPorEvaluacion ");
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, companyowner));
		return (List) dao.listarPorQuery(DtoDwRequerimientoevaletapasEdit.class,
				"hrevaluacionetapa.dwhrrequerimientoevaletapasedit", parametros);
	}
}
