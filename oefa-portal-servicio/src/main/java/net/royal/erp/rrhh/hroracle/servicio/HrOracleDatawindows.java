package net.royal.erp.rrhh.hroracle.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoDwOrganigramaOcupados;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacionGrafico;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrOracleDatawindows")
public class HrOracleDatawindows {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/*
	 * metodo que sirve para llenar la lista dw_1 de la controladora
	 * CwHrDetalleEvaluacion
	 */

	public List obtenerDetalleEvaluacion(String par_CompanyOwner,
			BigDecimal par_secuencia, BigDecimal par_empleado,
			BigDecimal par_evaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_CompanyOwner",
				String.class, par_CompanyOwner));
		parametros.add(new ParametroPersistenciaGenerico("par_secuencia",
				BigDecimal.class, par_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado",
				BigDecimal.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluador",
				BigDecimal.class, par_evaluador));

		List datos = dao.listarPorQuery(DtoHrDetalleEvaluacion.class,
				"hrdetalleevaluacion.obtenerDetalleEvaluacion", parametros);

		return datos;
	}

	/*
	 * para realizar la consulta antes de mostrar el reporte de cedula
	 */
	
	public Integer obtenerCantReporteCedula(String par_CompanyOwner,
			BigDecimal par_secuencia, BigDecimal par_empleado,
			BigDecimal par_evaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_company",
				String.class, par_CompanyOwner));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluacion",
				BigDecimal.class, par_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado",
				BigDecimal.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluador",
				BigDecimal.class, par_evaluador));

		return dao.contar("hrdetalleevaluacion.obtenerCantEvaluacionCedula", parametros);
	}
	
	
	public BigDecimal obtenerCantEvaluacion(String par_CompanyOwner,
			BigDecimal par_secuencia, BigDecimal par_empleado,
			BigDecimal par_evaluador) {

		BigDecimal cant = new BigDecimal(0);

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_CompanyOwner",
				String.class, par_CompanyOwner));
		parametros.add(new ParametroPersistenciaGenerico("par_secuencia",
				BigDecimal.class, par_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado",
				BigDecimal.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluador",
				BigDecimal.class, par_evaluador));

		Integer cantidad = dao.contar(
				"hrdetalleevaluacion.obtenerCantEvaluacion", parametros);

		return new BigDecimal(cantidad);
	}

	public List obtenerCantEvaluacionGrafico(String par_companyowner,
			BigDecimal par_secuencia, BigDecimal par_empleado,
			BigDecimal par_evaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner",
				String.class, par_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_secuencia",
				BigDecimal.class, par_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado",
				BigDecimal.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluador",
				BigDecimal.class, par_evaluador));

		List datos = dao.listarPorQuery(DtoHrDetalleEvaluacionGrafico.class,
				"hrdetalleevaluacion.obtenerDetalleEvaluacionGrafico",
				parametros);
		return datos;
	}

	public List obtenerEvaluacionGraficoCabezera(String par_companyowner,
			BigDecimal par_secuencia, BigDecimal par_empleado,
			BigDecimal par_evaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner",
				String.class, par_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_secuencia",
				BigDecimal.class, par_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("par_empleado",
				BigDecimal.class, par_empleado));
		parametros.add(new ParametroPersistenciaGenerico("par_evaluador",
				BigDecimal.class, par_evaluador));

		List datos = dao.listarPorQuery(DtoHrDetalleEvaluacionGrafico.class,
				"hrdetalleevaluacion.obtenerEvaluacionGraficoCabezera",
				parametros);
		return datos;
	}

	/**
	 * @powerbuilder dw_factores_competencia_historial
	 */
	public List listarDw1(String par_compania, Integer par_empleado,
			Integer par_factor, Integer par_secuencia) {
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_compania",
				String.class, par_compania));
		filtro.add(new ParametroPersistenciaGenerico("par_empleado",
				Integer.class, par_empleado));
		filtro.add(new ParametroPersistenciaGenerico("par_factor",
				Integer.class, par_factor));
		filtro.add(new ParametroPersistenciaGenerico("par_secuencia",
				Integer.class, par_secuencia));

		return null;
	}

	public List DwOrganigramaOcupados(String companyowner, Integer anio,
			String codigopuesto) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_compania",
				String.class, companyowner));
		filtros.add(new ParametroPersistenciaGenerico("p_anio", Integer.class,
				anio));
		filtros.add(new ParametroPersistenciaGenerico("p_puesto",
				String.class, codigopuesto));

		return dao.listarPorQuery(DtoDwOrganigramaOcupados.class,
				"hroracle.DwOrganigramaOcupados", filtros);

	}

}
