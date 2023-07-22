package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodoDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionperiodo;
import net.royal.erp.rrhh.servicio.HrEvaluacionperiodoServicio;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEvaluacionperiodo")
public class HrEvaluacionperiodoServicioImpl extends GenericoServicioImpl
		implements HrEvaluacionperiodoServicio {

	private HrEvaluacionperiodoDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacionperiodoServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionperiodoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public StrPass FEvaluacionPeriodoCabecera(StrPass strpass) {
		return dao.FEvaluacionPeriodoCabecera(strpass);
	}

	@Override
	public HrEvaluacionperiodo ObtenerxSecuenciaeval(Integer secuenciaeval) {
		return dao.ObtenerxSecuenciaeval(secuenciaeval);
	}

	@Override
	public List obtenerListadeEvauluaciones() {
		return dao.listarPorQuery(DtoHrEvaluacionperiodo.class,
				"hrevaluacionperiodo.obtenerListaEvaluaciones");
	}

	@Override
	public Integer obtenerCantHistorial(String iv_compania,
			Integer iv_empleado, Integer il_factor, Integer iv_secuencia) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("iv_compania",
				String.class, iv_compania));
		parametros.add(new ParametroPersistenciaGenerico("iv_empleado",
				Integer.class, iv_empleado));
		parametros.add(new ParametroPersistenciaGenerico("il_factor",
				Integer.class, il_factor));
		parametros.add(new ParametroPersistenciaGenerico("iv_secuencia",
				Integer.class, iv_secuencia));

		return dao.contar("hrevaluacionperiodo.obtenerCantHistorial",
				parametros);
	}

	@Override
	public HrEvaluacionperiodo obtenerXSecuenciaEvalCompania(
			Integer secuenciaeval, String compania) {
		return dao.obtenerXSecuenciaEvalCompania(secuenciaeval, compania);
	}

	@Override
	public List<HrEvaluacionperiodo> listarEvalPeriodoxCompania(
			String companiasocio) {
		return dao.listarEvalPeriodoxCompania(companiasocio);
	}

}
