package net.royal.erp.rrhh.hrothers.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwFuncionesXEmpleado;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCompetenciasList;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCompetenciasList2;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacion2Detail;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwMetasEmpleado;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrothersDatawindow")
public class HrothersDatawindow {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DtoDwHrEmpleadoevaluacionEdit dwHrEmpleadoevaluacionEdit(Integer par_empleado, Integer par_secuencia,
			Integer par_EmpleadoEvaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_secuencia", Integer.class, par_secuencia));
		parametros
				.add(new ParametroPersistenciaGenerico("par_EmpleadoEvaluador", Integer.class, par_EmpleadoEvaluador));

		List<DtoDwHrEmpleadoevaluacionEdit> lista = (List) dao.listarPorQuery(DtoDwHrEmpleadoevaluacionEdit.class,
				"hrothers.dwHrEmpleadoevaluacionEdit", parametros);

		if (!UValidador.esListaVacia(lista))
			return lista.get(0);

		return null;
	}

	/**
	 * dwHrEmpleadoevaluacion2Detail.
	 *
	 * @powerbuilder hrothers.dw_hr_empleadoevaluacion_2_detail
	 * @author nunezh
	 * @param par_companyowner
	 *            companyowner
	 * @param par_empleado
	 *            empleado
	 * @param par_secuenciaeval
	 *            secuenciaeval
	 * @param par_evaluador
	 *            evaluador
	 * @return Lista del tipo <strong>DtoDwHrEmpleadoevaluacion2Detail</strong>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwHrEmpleadoevaluacion2Detail> dwHrEmpleadoevaluacion2Detail(String par_companyowner,
			Integer par_empleado, Integer par_secuenciaeval, Integer par_evaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, par_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_secuenciaeval", Integer.class, par_secuenciaeval));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluador", Integer.class, par_evaluador));

		return (List) dao.listarPorQuery(DtoDwHrEmpleadoevaluacion2Detail.class,
				"hrothers.dwHrEmpleadoevaluacion2Detail", parametros);
	}

	/**
	 * @powerbuilder hrothers.dw_hr_curso_selector
	 * @author zegarrac
	 * @param par_companyowner
	 *            companyowner
	 * @param par_empleado
	 *            empleado
	 * @param par_secuenciaeval
	 *            secuenciaeval
	 * @param par_evaluador
	 *            evaluador
	 * @return Lista del tipo <strong>DtoDwHrCursoSelector</strong>
	 */
	public List DwHrCursoSelector(String par_descripcion, String par_curso, String par_area) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_descripcion", String.class, par_descripcion));
		parametros.add(new ParametroPersistenciaGenerico("p_curso", String.class, par_curso));
		parametros.add(new ParametroPersistenciaGenerico("p_area", String.class, par_area));

		return dao.listarPorQuery(DtoDwHrCursoSelector.class, "hrothers.DwHrCursoSelector", parametros);

	}

	public List DwHrCursoSelectorCabezera(String par_descripcion, String par_curso, String par_area) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_descripcion", String.class, par_descripcion));
		parametros.add(new ParametroPersistenciaGenerico("p_curso", String.class, par_curso));
		parametros.add(new ParametroPersistenciaGenerico("p_area", String.class, par_area));

		return dao.listarPorQuery(DtoDwHrCursoSelector.class, "hrothers.DwHrCursoSelectorCabezera", parametros);

	}

	/**
	 * D w metas empleado.
	 *
	 * @author nunezh
	 * @powerbuilder <strong>hrothers.dw_metas_empleado</strong>
	 * @param parm_empleado
	 *            the parm_empleado
	 * @param parm_SecuenciaEval
	 *            the parm_ secuencia eval
	 * @return the list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwMetasEmpleado> dWMetasEmpleado(Integer parm_empleado) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("parm_empleado", Integer.class, parm_empleado));
		return (List) dao.listarPorQuery(DtoDwMetasEmpleado.class, "hrothers.dwmetasempleado", parametros);
	}

	/**
	 * D w funciones x empleado.
	 * 
	 * @author nunezh
	 * @powerbuilder <strong>hrothers.dw_funciones_x_empleado</strong>
	 * @param parm_empleado
	 *            the parm_empleado
	 * @return the list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<DtoDwFuncionesXEmpleado> dWFuncionesXEmpleado(Integer parm_empleado) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("parm_empleado", Integer.class, parm_empleado));
		return (List) dao.listarPorQuery(DtoDwFuncionesXEmpleado.class, "hrothers.dwfuncionesxempleado", parametros);
	}

	/**
	 * dw_hr_competencias_list_2
	 * 
	 * @author zegarrac
	 * @powerbuilder <strong>hrothers.dw_hr_competencias_list_2</strong>
	 * @param parm_empleado
	 * @return the list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<DtoDwHrCompetenciasList2> DwHrCompetenciasList2(String par_compania, BigDecimal par_empleado,
			BigDecimal par_secuencia, String par_fecha) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_compania", String.class, par_compania));
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", BigDecimal.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("p_secuencia", BigDecimal.class, par_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("p_fecha", String.class, par_fecha));

		List datos = dao.listarPorQuery(DtoDwHrCompetenciasList2.class, "hrothers.DwHrCompetenciasList2", parametros);
		return datos;
	}

	/**
	 * Dw hr incidentecritico list.
	 *
	 * @author nunezh
	 * @powerbuilder hrothers.dw_hr_incidentecritico_list
	 * @param companyowner
	 *            the companyowner
	 * @param empleado
	 *            the empleado
	 * @param secuenciaeval
	 *            the secuenciaeval
	 * @return the list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwHrIncidentecriticoList> dwHrIncidentecriticoList(String companyowner, Integer empleado,
			Integer secuenciaeval, Date fechafin) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_secuenciaeval", Integer.class, secuenciaeval));
		parametros.add(new ParametroPersistenciaGenerico("p_fechafin", Date.class, fechafin));

		return (List) dao.listarPorQuery(DtoDwHrIncidentecriticoList.class, "hrothers.dwhrincidentecriticolist",
				parametros);
	}

	/**
	 *
	 * @author zegarrac
	 * @powerbuilder hrothers.dw_hr_competencias_list
	 * @param companyowner
	 * @param empleado
	 * @return the list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwHrCompetenciasList> DwHrCompetenciasList(String companyowner, BigDecimal empleado) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_compania", String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("p_empleado", BigDecimal.class, empleado));

		return (List) dao.listarPorQuery(DtoDwHrCompetenciasList.class, "hrothers.DwHrCompetenciasList", parametros);
	}
}
