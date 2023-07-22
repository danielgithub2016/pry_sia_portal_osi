package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.erp.planilla.dominio.dto.DtoMetaPresupuestal;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.dto.DtoHrRequerimientoSeguimiento;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoEdit;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrRequerimientoServicio extends GenericoServicio {

	public Integer obtenerMaximoRequerimiento(String companyowner, String unidadreplicacion);

	public Integer secuenciaNextEval();

	public List<DtoDwHrRequerimientoList> listarRequerimientos(Integer par_codigopuesto, Integer p_codigoPuesto,
			String p_convocatoria, String p_tiporequerimiento, String p_compania, BigDecimal p_concurso,
			String p_tipoplanilla, Integer p_empleadoresponsable, BigDecimal p_codigoPosicionSolicitante,
			String p_fechas, String p_estado, String p_desierto, String p_numero, Date p_fini, Date p_ffin,
			Integer par_empleado, String par_validacion1, String par_validacion2);

	public List<DtoTipoPlanilla> listarTipoPlanilla(String tiposdePlanilla);

	public HrRequerimiento obtenerRequerimiento(String requerimeinto, String compania);

	public Date obtenerfechahoraServidor();

	public String obtenerFlgPublicado(String p_requerimiento, String p_companyowner, Integer p_secuencia);

	public Integer obtenerEvaluacion(String p_requerimiento, String p_companyowner, Integer p_secuencia,
			String p_fecha);

	public Integer obtenercantidadPost(Integer p_evaluador, String p_requerimiento, String p_companyowner);

	public List<DtoMetaPresupuestal> obtenermetapresupuestal(String compania, String ano);

	public void registrarDocAprobacion(String usuario, DtoDwHrRequerimientoEdit requerimiento);

	public List<UsuarioActual> obtenerUsuariosEnvio();

	public List<DtoHrRequerimientoSeguimiento> listarSeguimiento(String requerimiento);
	
	public List<DtoHrRequerimientoSeguimiento> listarFlagTipoSecuencia(String requerimiento, Integer evaluacion);
	
	
	

}
