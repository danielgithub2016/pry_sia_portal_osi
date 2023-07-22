package net.royal.erp.rrhh.hrmast.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoDSeleccionEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoDwHrEvaluacionperiodoListEvaluar;
import net.royal.erp.rrhh.dominio.dto.DtoDwHrPuestoFuncionesList;
import net.royal.erp.rrhh.dominio.dto.DtoHrEmpleadoReclutamientoSelect;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHRHrmastDatawindow")
public class HrmastDatawindow {
	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 * dwHrEvaluacionperiodoListEvaluar.
	 * 
	 * @powerbuilder dw_hr_evaluacionperiodo_list_evaluar
	 * @return the list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwHrEvaluacionperiodoListEvaluar> dwHrEvaluacionperiodoListEvaluar(
			String companyowner, BigDecimal secuenciaeval, BigDecimal evaluador) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("companyowner",
				String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("secuenciaeval",
				BigDecimal.class, secuenciaeval));
		parametros.add(new ParametroPersistenciaGenerico("evaluador",
				BigDecimal.class, evaluador));

		return (List) dao.listarPorQuery(
				DtoDwHrEvaluacionperiodoListEvaluar.class,
				"hrmast.dwHrEvaluacionperiodoListEvaluar", parametros);
	}

	public List dwHrEmpleadoReclutamientoSelect() {
		return dao.listarPorQuery(DtoHrEmpleadoReclutamientoSelect.class,
				"hrmast.dwHrEmpleadoReclutamientoSelect");
	}

	/**
	 * dSeleccionEvaluacion.
	 * 
	 * @powerbuilder d_Seleccion_Evaluacion
	 * @return the list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDSeleccionEvaluacion> dSeleccionEvaluacion(String par_tipo,
			BigDecimal par_puesto) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_tipo",
				String.class, par_tipo));
		parametros.add(new ParametroPersistenciaGenerico("p_puesto",
				BigDecimal.class, par_puesto));

		return (List) dao.listarPorQuery(DtoDSeleccionEvaluacion.class,
				"hrmast.dSeleccionEvaluacion", parametros);
	}

	/**
	 * dSeleccionEvaluacion.
	 * 
	 * @powerbuilder dw_hr_puestoFunciones_list
	 * @return the list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwHrPuestoFuncionesList> DwHrPuestoFuncionesList(
			BigDecimal par_codigopuesto) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_codigopuesto",
				BigDecimal.class, par_codigopuesto));

		return (List) dao.listarPorQuery(DtoDwHrPuestoFuncionesList.class,
				"hrmast.dwHrPuestoFuncionesList", parametros);
	}
}
