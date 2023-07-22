package net.royal.erp.rrhh.factory;

import net.royal.erp.rrhh.servicio.*;

public interface FactoryErpRrhh {

	public FactoryErpHR getHr();

	public void setHr(FactoryErpHR factoryErpHR);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuestasujeto
	 */
	public HrEncuestasujetoServicio getHrEncuestasujetoServicio();

	public void setHrEncuestasujetoServicio(HrEncuestasujetoServicio hrEncuestasujetoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuestapreguntavalores
	 */
	public HrEncuestapreguntavaloresServicio getHrEncuestapreguntavaloresServicio();

	public void setHrEncuestapreguntavaloresServicio(
			HrEncuestapreguntavaloresServicio hrEncuestapreguntavaloresServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuestapregunta
	 */
	public HrEncuestapreguntaServicio getHrEncuestapreguntaServicio();

	public void setHrEncuestapreguntaServicio(HrEncuestapreguntaServicio hrEncuestapreguntaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuestaplantilladetalle
	 */
	public HrEncuestaplantilladetalleServicio getHrEncuestaplantilladetalleServicio();

	public void setHrEncuestaplantilladetalleServicio(
			HrEncuestaplantilladetalleServicio hrEncuestaplantilladetalleServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuestaplantilla
	 */
	public HrEncuestaplantillaServicio getHrEncuestaplantillaServicio();

	public void setHrEncuestaplantillaServicio(HrEncuestaplantillaServicio hrEncuestaplantillaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuestadetalle
	 */
	public HrEncuestadetalleServicio getHrEncuestadetalleServicio();

	public void setHrEncuestadetalleServicio(HrEncuestadetalleServicio hrEncuestadetalleServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEncuesta
	 */
	public HrEncuestaServicio getHrEncuestaServicio();

	public void setHrEncuestaServicio(HrEncuestaServicio hrEncuestaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrActividadparticipante
	 */
	public HrActividadparticipanteServicio getHrActividadparticipanteServicio();

	public void setHrActividadparticipanteServicio(HrActividadparticipanteServicio hrActividadparticipanteServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrActividad
	 */
	public HrActividadServicio getHrActividadServicio();

	public void setHrActividadServicio(HrActividadServicio hrActividadServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrTipoevaluador
	 */
	public HrTipoevaluadorServicio getHrTipoevaluadorServicio();

	public void setHrTipoevaluadorServicio(HrTipoevaluadorServicio hrTipoevaluadorServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrTipocontrato
	 */
	public HrTipocontratoServicio getHrTipocontratoServicio();

	public void setHrTipocontratoServicio(HrTipocontratoServicio hrTipocontratoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrSueldos
	 */
	public HrSueldosServicio getHrSueldosServicio();

	public void setHrSueldosServicio(HrSueldosServicio hrSueldosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrSeguridad
	 */
	public HrSeguridadServicio getHrSeguridadServicio();

	public void setHrSeguridadServicio(HrSeguridadServicio hrSeguridadServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoempresa
	 */
	public HrPuestoempresaServicio getHrPuestoempresaServicio();

	public void setHrPuestoempresaServicio(HrPuestoempresaServicio hrPuestoempresaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPlantillafactorevaluacion
	 */
	public HrPlantillafactorevaluacionServicio getHrPlantillafactorevaluacionServicio();

	public void setHrPlantillafactorevaluacionServicio(
			HrPlantillafactorevaluacionServicio hrPlantillafactorevaluacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrMeritosfaltas
	 */
	public HrMeritosfaltasServicio getHrMeritosfaltasServicio();

	public void setHrMeritosfaltasServicio(HrMeritosfaltasServicio hrMeritosfaltasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrFactorvalor
	 */
	public HrFactorvalorServicio getHrFactorvalorServicio();

	public void setHrFactorvalorServicio(HrFactorvalorServicio hrFactorvalorServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrFactoresevaluacionplantilla
	 */
	public HrFactoresevaluacionplantillaServicio getHrFactoresevaluacionplantillaServicio();

	public void setHrFactoresevaluacionplantillaServicio(
			HrFactoresevaluacionplantillaServicio hrFactoresevaluacionplantillaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrFactoresevaluacion
	 */
	public HrFactoresevaluacionServicio getHrFactoresevaluacionServicio();

	public void setHrFactoresevaluacionServicio(HrFactoresevaluacionServicio hrFactoresevaluacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluaciontipoevaluador
	 */
	public HrEvaluaciontipoevaluadorServicio getHrEvaluaciontipoevaluadorServicio();

	public void setHrEvaluaciontipoevaluadorServicio(
			HrEvaluaciontipoevaluadorServicio hrEvaluaciontipoevaluadorServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacionperiodovalor
	 */
	public HrEvaluacionperiodovalorServicio getHrEvaluacionperiodovalorServicio();

	public void setHrEvaluacionperiodovalorServicio(HrEvaluacionperiodovalorServicio hrEvaluacionperiodovalorServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacionperiodocriterio
	 */
	public HrEvaluacionperiodocriterioServicio getHrEvaluacionperiodocriterioServicio();

	public void setHrEvaluacionperiodocriterioServicio(
			HrEvaluacionperiodocriterioServicio hrEvaluacionperiodocriterioServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacionperiodo
	 */
	public HrEvaluacionperiodoServicio getHrEvaluacionperiodoServicio();

	public void setHrEvaluacionperiodoServicio(HrEvaluacionperiodoServicio hrEvaluacionperiodoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacionesrango
	 */
	public HrEvaluacionesrangoServicio getHrEvaluacionesrangoServicio();

	public void setHrEvaluacionesrangoServicio(HrEvaluacionesrangoServicio hrEvaluacionesrangoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacionempleado
	 */
	public HrEvaluacionempleadoServicio getHrEvaluacionempleadoServicio();

	public void setHrEvaluacionempleadoServicio(HrEvaluacionempleadoServicio hrEvaluacionempleadoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacionarea
	 */
	public HrEvaluacionareaServicio getHrEvaluacionareaServicio();

	public void setHrEvaluacionareaServicio(HrEvaluacionareaServicio hrEvaluacionareaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadorevision
	 */
	public HrEmpleadorevisionServicio getHrEmpleadorevisionServicio();

	public void setHrEmpleadorevisionServicio(HrEmpleadorevisionServicio hrEmpleadorevisionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadonecesidadcapacita
	 */
	public HrEmpleadonecesidadcapacitaServicio getHrEmpleadonecesidadcapacitaServicio();

	public void setHrEmpleadonecesidadcapacitaServicio(
			HrEmpleadonecesidadcapacitaServicio hrEmpleadonecesidadcapacitaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadometas
	 */
	public HrEmpleadometasServicio getHrEmpleadometasServicio();

	public void setHrEmpleadometasServicio(HrEmpleadometasServicio hrEmpleadometasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadofuncion
	 */
	public HrEmpleadofuncionServicio getHrEmpleadofuncionServicio();

	public void setHrEmpleadofuncionServicio(HrEmpleadofuncionServicio hrEmpleadofuncionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadodesempeno
	 */
	public HrEmpleadodesempenoServicio getHrEmpleadodesempenoServicio();

	public void setHrEmpleadodesempenoServicio(HrEmpleadodesempenoServicio hrEmpleadodesempenoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadoconsiderapotencial
	 */
	public HrEmpleadoconsiderapotencialServicio getHrEmpleadoconsiderapotencialServicio();

	public void setHrEmpleadoconsiderapotencialServicio(
			HrEmpleadoconsiderapotencialServicio hrEmpleadoconsiderapotencialServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadocomentarios
	 */
	public HrEmpleadocomentariosServicio getHrEmpleadocomentariosServicio();

	public void setHrEmpleadocomentariosServicio(HrEmpleadocomentariosServicio hrEmpleadocomentariosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleado
	 */
	public HrEmpleadoServicio getHrEmpleadoServicio();

	public void setHrEmpleadoServicio(HrEmpleadoServicio hrEmpleadoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrDetalleevaluacionmejora
	 */
	public HrDetalleevaluacionmejoraServicio getHrDetalleevaluacionmejoraServicio();

	public void setHrDetalleevaluacionmejoraServicio(
			HrDetalleevaluacionmejoraServicio hrDetalleevaluacionmejoraServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrDetalleevaluacion
	 */
	public HrDetalleevaluacionServicio getHrDetalleevaluacionServicio();

	public void setHrDetalleevaluacionServicio(HrDetalleevaluacionServicio hrDetalleevaluacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrDepartamento
	 */
	public HrDepartamentoServicio getHrDepartamentoServicio();

	public void setHrDepartamentoServicio(HrDepartamentoServicio hrDepartamentoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrContratos
	 */
	public HrContratosServicio getHrContratosServicio();

	public void setHrContratosServicio(HrContratosServicio hrContratosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCargosmast
	 */
	public HrCargosmastServicio getHrCargosmastServicio();

	public void setHrCargosmastServicio(HrCargosmastServicio hrCargosmastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrBsMeta
	 */
	public HrBsMetaServicio getHrBsMetaServicio();

	public void setHrBsMetaServicio(HrBsMetaServicio hrBsMetaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrBsLineadeaccion
	 */
	public HrBsLineadeaccionServicio getHrBsLineadeaccionServicio();

	public void setHrBsLineadeaccionServicio(HrBsLineadeaccionServicio hrBsLineadeaccionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrAfp
	 */
	public HrAfpServicio getHrAfpServicio();

	public void setHrAfpServicio(HrAfpServicio hrAfpServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrActividadRutas
	 */
	public HrActividadRutasServicio getHrActividadRutasServicio();

	public void setHrActividadRutasServicio(HrActividadRutasServicio hrActividadRutasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrActividadChecklist
	 */
	public HrActividadChecklistServicio getHrActividadChecklistServicio();

	public void setHrActividadChecklistServicio(HrActividadChecklistServicio hrActividadChecklistServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrActividadprogramacion
	 */
	public HrActividadprogramacionServicio getHrActividadprogramacionServicio();

	public void setHrActividadprogramacionServicio(HrActividadprogramacionServicio hrActividadprogramacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrActividadbeneficiario
	 */
	public HrActividadbeneficiarioServicio getHrActividadbeneficiarioServicio();

	public void setHrActividadbeneficiarioServicio(HrActividadbeneficiarioServicio hrActividadbeneficiarioServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPlantillaevapotencial
	 */
	public HrPlantillaevapotencialServicio getHrPlantillaevapotencialServicio();

	public void setHrPlantillaevapotencialServicio(HrPlantillaevapotencialServicio hrPlantillaevapotencialServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacioncandidatohist
	 */
	public HrEvaluacioncandidatohistServicio getHrEvaluacioncandidatohistServicio();

	public void setHrEvaluacioncandidatohistServicio(
			HrEvaluacioncandidatohistServicio hrEvaluacioncandidatohistServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCapacitacion
	 */
	public HrCapacitacionServicio getHrCapacitacionServicio();

	public void setHrCapacitacionServicio(HrCapacitacionServicio hrCapacitacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCursodescripcion
	 */
	public HrCursodescripcionServicio getHrCursodescripcionServicio();

	public void setHrCursodescripcionServicio(HrCursodescripcionServicio hrCursodescripcionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrFactorvalorcapac
	 */
	public HrFactorvalorcapacServicio getHrFactorvalorcapacServicio();

	public void setHrFactorvalorcapacServicio(HrFactorvalorcapacServicio hrFactorvalorcapacServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacioncapacvalor
	 */
	public HrEvaluacioncapacvalorServicio getHrEvaluacioncapacvalorServicio();

	public void setHrEvaluacioncapacvalorServicio(HrEvaluacioncapacvalorServicio hrEvaluacioncapacvalorServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacion
	 */
	public HrEvaluacionServicio getHrEvaluacionServicio();

	public void setHrEvaluacionServicio(HrEvaluacionServicio hrEvaluacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEvaluacion
	 */
	public HrEvaluacionRequerimientoServicio getHrEvaluacionRequerimientoServicio();

	public void setHrEvaluacionRequerimientoServicio(
			HrEvaluacionRequerimientoServicio hrEvaluacionRequerimientoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadoasistencias
	 */
	public HrEmpleadoasistenciasServicio getHrEmpleadoasistenciasServicio();

	public void setHrEmpleadoasistenciasServicio(HrEmpleadoasistenciasServicio hrEmpleadoasistenciasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCursocomprobantes
	 */
	public HrCursocomprobantesServicio getHrCursocomprobantesServicio();

	public void setHrCursocomprobantesServicio(HrCursocomprobantesServicio hrCursocomprobantesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCapacitacioneval
	 */
	public HrCapacitacionevalServicio getHrCapacitacionevalServicio();

	public void setHrCapacitacionevalServicio(HrCapacitacionevalServicio hrCapacitacionevalServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrProfesion
	 */
	public HrProfesionServicio getHrProfesionServicio();

	public void setHrProfesionServicio(HrProfesionServicio hrProfesionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrGradosalariomast
	 */
	public HrGradosalariomastServicio getHrGradosalariomastServicio();

	public void setHrGradosalariomastServicio(HrGradosalariomastServicio hrGradosalariomastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientoreemplazo
	 */
	public HrRequerimientoreemplazoServicio getHrRequerimientoreemplazoServicio();

	public void setHrRequerimientoreemplazoServicio(HrRequerimientoreemplazoServicio hrRequerimientoreemplazoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestoobj
	 */
	public HrRequerimientopuestoobjServicio getHrRequerimientopuestoobjServicio();

	public void setHrRequerimientopuestoobjServicio(HrRequerimientopuestoobjServicio hrRequerimientopuestoobjServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestoidi
	 */
	public HrRequerimientopuestoidiServicio getHrRequerimientopuestoidiServicio();

	public void setHrRequerimientopuestoidiServicio(HrRequerimientopuestoidiServicio hrRequerimientopuestoidiServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestofun
	 */
	public HrRequerimientopuestofunServicio getHrRequerimientopuestofunServicio();

	public void setHrRequerimientopuestofunServicio(HrRequerimientopuestofunServicio hrRequerimientopuestofunServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestofor
	 */
	public HrRequerimientopuestoforServicio getHrRequerimientopuestoforServicio();

	public void setHrRequerimientopuestoforServicio(HrRequerimientopuestoforServicio hrRequerimientopuestoforServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestoexp
	 */
	public HrRequerimientopuestoexpServicio getHrRequerimientopuestoexpServicio();

	public void setHrRequerimientopuestoexpServicio(HrRequerimientopuestoexpServicio hrRequerimientopuestoexpServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestoest
	 */
	public HrRequerimientopuestoestServicio getHrRequerimientopuestoestServicio();

	public void setHrRequerimientopuestoestServicio(HrRequerimientopuestoestServicio hrRequerimientopuestoestServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuestocomp
	 */
	public HrRequerimientopuestocompServicio getHrRequerimientopuestocompServicio();

	public void setHrRequerimientopuestocompServicio(
			HrRequerimientopuestocompServicio hrRequerimientopuestocompServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientopuesto
	 */
	public HrRequerimientopuestoServicio getHrRequerimientopuestoServicio();

	public void setHrRequerimientopuestoServicio(HrRequerimientopuestoServicio hrRequerimientopuestoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientoobservacion
	 */
	public HrRequerimientoobservacionServicio getHrRequerimientoobservacionServicio();

	public void setHrRequerimientoobservacionServicio(
			HrRequerimientoobservacionServicio hrRequerimientoobservacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientomotivoAprob
	 */
	public HrRequerimientomotivoAprobServicio getHrRequerimientomotivoAprobServicio();

	public void setHrRequerimientomotivoAprobServicio(
			HrRequerimientomotivoAprobServicio hrRequerimientomotivoAprobServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientofunprac
	 */
	public HrRequerimientofunpracServicio getHrRequerimientofunpracServicio();

	public void setHrRequerimientofunpracServicio(HrRequerimientofunpracServicio hrRequerimientofunpracServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientofuncasdet
	 */
	public HrRequerimientofuncasdetServicio getHrRequerimientofuncasdetServicio();

	public void setHrRequerimientofuncasdetServicio(HrRequerimientofuncasdetServicio hrRequerimientofuncasdetServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientofuncas
	 */
	public HrRequerimientofuncasServicio getHrRequerimientofuncasServicio();

	public void setHrRequerimientofuncasServicio(HrRequerimientofuncasServicio hrRequerimientofuncasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimientodocaprobacion
	 */
	public HrRequerimientodocaprobacionServicio getHrRequerimientodocaprobacionServicio();

	public void setHrRequerimientodocaprobacionServicio(
			HrRequerimientodocaprobacionServicio hrRequerimientodocaprobacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrRequerimiento
	 */
	public HrRequerimientoServicio getHrRequerimientoServicio();

	public void setHrRequerimientoServicio(HrRequerimientoServicio hrRequerimientoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCentroestudios
	 */
	public HrCentroestudiosServicio getHrCentroestudiosServicio();

	public void setHrCentroestudiosServicio(HrCentroestudiosServicio hrCentroestudiosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadocapacitacion
	 */
	public HrEmpleadocapacitacionServicio getHrEmpleadocapacitacionServicio();

	public void setHrEmpleadocapacitacionServicio(HrEmpleadocapacitacionServicio hrEmpleadocapacitacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrDncSolicitante
	 */
	public HrDncSolicitanteServicio getHrDncSolicitanteServicio();

	public void setHrDncSolicitanteServicio(HrDncSolicitanteServicio hrDncSolicitanteServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrTipotrabajador
	 */
	public HrTipotrabajadorServicio getHrTipotrabajadorServicio();

	public void setHrTipotrabajadorServicio(HrTipotrabajadorServicio hrTipotrabajadorServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestosubordinado
	 */
	public HrPuestosubordinadoServicio getHrPuestosubordinadoServicio();

	public void setHrPuestosubordinadoServicio(HrPuestosubordinadoServicio hrPuestosubordinadoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestosimilar
	 */
	public HrPuestosimilarServicio getHrPuestosimilarServicio();

	public void setHrPuestosimilarServicio(HrPuestosimilarServicio hrPuestosimilarServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoriesgotrabajo
	 */
	public HrPuestoriesgotrabajoServicio getHrPuestoriesgotrabajoServicio();

	public void setHrPuestoriesgotrabajoServicio(HrPuestoriesgotrabajoServicio hrPuestoriesgotrabajoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoresponsabilidades
	 */
	public HrPuestoresponsabilidadesServicio getHrPuestoresponsabilidadesServicio();

	public void setHrPuestoresponsabilidadesServicio(
			HrPuestoresponsabilidadesServicio hrPuestoresponsabilidadesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoreporta
	 */
	public HrPuestoreportaServicio getHrPuestoreportaServicio();

	public void setHrPuestoreportaServicio(HrPuestoreportaServicio hrPuestoreportaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestorelaciones
	 */
	public HrPuestorelacionesServicio getHrPuestorelacionesServicio();

	public void setHrPuestorelacionesServicio(HrPuestorelacionesServicio hrPuestorelacionesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestopersonaacargo
	 */
	public HrPuestopersonaacargoServicio getHrPuestopersonaacargoServicio();

	public void setHrPuestopersonaacargoServicio(HrPuestopersonaacargoServicio hrPuestopersonaacargoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoinformatica
	 */
	public HrPuestoinformaticaServicio getHrPuestoinformaticaServicio();

	public void setHrPuestoinformaticaServicio(HrPuestoinformaticaServicio hrPuestoinformaticaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoidiomas
	 */
	public HrPuestoidiomasServicio getHrPuestoidiomasServicio();

	public void setHrPuestoidiomasServicio(HrPuestoidiomasServicio hrPuestoidiomasServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestofunciones
	 */
	public HrPuestofuncionesServicio getHrPuestofuncionesServicio();

	public void setHrPuestofuncionesServicio(HrPuestofuncionesServicio hrPuestofuncionesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoformacion
	 */
	public HrPuestoformacionServicio getHrPuestoformacionServicio();

	public void setHrPuestoformacionServicio(HrPuestoformacionServicio hrPuestoformacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoexperiencia
	 */
	public HrPuestoexperienciaServicio getHrPuestoexperienciaServicio();

	public void setHrPuestoexperienciaServicio(HrPuestoexperienciaServicio hrPuestoexperienciaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoevaluacion
	 */
	public HrPuestoevaluacionServicio getHrPuestoevaluacionServicio();

	public void setHrPuestoevaluacionServicio(HrPuestoevaluacionServicio hrPuestoevaluacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoempresaDoc
	 */
	public HrPuestoempresaDocServicio getHrPuestoempresaDocServicio();

	public void setHrPuestoempresaDocServicio(HrPuestoempresaDocServicio hrPuestoempresaDocServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestocursos
	 */
	public HrPuestocursosServicio getHrPuestocursosServicio();

	public void setHrPuestocursosServicio(HrPuestocursosServicio hrPuestocursosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoconfianza
	 */
	public HrPuestoconfianzaServicio getHrPuestoconfianzaServicio();

	public void setHrPuestoconfianzaServicio(HrPuestoconfianzaServicio hrPuestoconfianzaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestocondicionestrabajo
	 */
	public HrPuestocondicionestrabajoServicio getHrPuestocondicionestrabajoServicio();

	public void setHrPuestocondicionestrabajoServicio(
			HrPuestocondicionestrabajoServicio hrPuestocondicionestrabajoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPuestoclave
	 */
	public HrPuestoclaveServicio getHrPuestoclaveServicio();

	public void setHrPuestoclaveServicio(HrPuestoclaveServicio hrPuestoclaveServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrMetaspuesto
	 */
	public HrMetaspuestoServicio getHrMetaspuestoServicio();

	public void setHrMetaspuestoServicio(HrMetaspuestoServicio hrMetaspuestoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrIdiomasmast
	 */
	public HrIdiomasmastServicio getHrIdiomasmastServicio();

	public void setHrIdiomasmastServicio(HrIdiomasmastServicio hrIdiomasmastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrPosicionempresa
	 */
	public HrPosicionempresaServicio getHrPosicionempresaServicio();

	public void setHrPosicionempresaServicio(HrPosicionempresaServicio hrPosicionempresaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrOrganigrama
	 */
	public HrOrganigramaServicio getHrOrganigramaServicio();

	public void setHrOrganigramaServicio(HrOrganigramaServicio hrOrganigramaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrGradoinstruccion
	 */
	public HrGradoinstruccionServicio getHrGradoinstruccionServicio();

	public void setHrGradoinstruccionServicio(HrGradoinstruccionServicio hrGradoinstruccionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCorreoflujo
	 */
	public HrCorreoflujoServicio getHrCorreoflujoServicio();

	public void setHrCorreoflujoServicio(HrCorreoflujoServicio hrCorreoflujoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrCtrlentregasplantilla
	 */
	public HrCtrlentregasplantillaServicio getHrCtrlentregasplantillaServicio();

	public void setHrCtrlentregasplantillaServicio(HrCtrlentregasplantillaServicio hrCtrlentregasplantillaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrClasificadorcargo
	 */
	public HrClasificadorcargoServicio getHrClasificadorcargoServicio();

	public void setHrClasificadorcargoServicio(HrClasificadorcargoServicio hrClasificadorcargoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrMotivocese
	 */
	public HrMotivoceseServicio getHrMotivoceseServicio();

	public void setHrMotivoceseServicio(HrMotivoceseServicio hrMotivoceseServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadocursos
	 */
	public HrEmpleadocursosServicio getHrEmpleadocursosServicio();

	public void setHrEmpleadocursosServicio(HrEmpleadocursosServicio hrEmpleadocursosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder rrhh.HrEmpleadocursosdocumento
	 */
	public HrEmpleadocursosdocumentoServicio getHrEmpleadocursosdocumentoServicio();

	public void setHrEmpleadocursosdocumentoServicio(
			HrEmpleadocursosdocumentoServicio hrEmpleadocursosdocumentoServicio);

	public HrPosRequerServicio getHrPosRequerServicio();

	public void setHrPosRequerServicio(HrPosRequerServicio hrPosRequerServicio);

	public HrEvaluacionetapaServicio getHrEvaluacionetapaServicio();

	public void setHrEvaluacionetapaServicio(HrEvaluacionetapaServicio hrEvaluacionetapaServicio);

	public HrEvaluacionpostulanteServicio getHrEvaluacionpostulanteServicio();

	public void setHrEvaluacionpostulanteServicio(HrEvaluacionpostulanteServicio hrEvaluacionpostulanteServicio);

	public HrPostulantesServicio getHrPostulantesServicio();

	public void setHrPostulantesServicio(HrPostulantesServicio hrPostulantesServicio);

	public HrPostulanteexperienciaServicio getHrPostulanteexperienciaServicio();

	public void setHrPostulanteexperienciaServicio(HrPostulanteexperienciaServicio hrPostulanteexperienciaServicio);

	/**
	 * Gets the hr empleadocapa documento servicio.
	 *
	 * @return the hr empleadocapa documento servicio
	 */
	public HrEmpleadocapaDocumentoServicio getHrEmpleadocapaDocumentoServicio();

	/**
	 * Sets the hr empleadocapa documento servicio.
	 *
	 * @param hrEmpleadocapaDocumentoServicio
	 *            the new hr empleadocapa documento servicio
	 */
	public void setHrEmpleadocapaDocumentoServicio(HrEmpleadocapaDocumentoServicio hrEmpleadocapaDocumentoServicio);

	/**
	 * Gets the hr evalrequerimiento servicio.
	 *
	 * @return the hr evalrequerimiento servicio
	 */
	public HrEvalrequerimientoServicio getHrEvalrequerimientoServicio();

	/**
	 * Sets the hr evalrequerimiento servicio.
	 *
	 * @param hrEvalrequerimientoServicio the new hr evalrequerimiento servicio
	 */
	public void setHrEvalrequerimientoServicio(HrEvalrequerimientoServicio hrEvalrequerimientoServicio);
	
	public HrRequerimientoAdjuntoServicio getHrRequerimientoAdjuntoServicio();
	
	public void setHrRequerimientoAdjuntoServicio(HrRequerimientoAdjuntoServicio hrRequerimientoAdjuntoServicio);
}
