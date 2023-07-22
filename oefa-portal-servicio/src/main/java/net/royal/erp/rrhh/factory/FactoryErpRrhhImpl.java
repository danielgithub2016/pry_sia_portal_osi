package net.royal.erp.rrhh.factory;

import net.royal.erp.rrhh.servicio.*;

public class FactoryErpRrhhImpl implements FactoryErpRrhh {

	private FactoryErpHR factoryErpHR;

	@Override
	public FactoryErpHR getHr() {
		return factoryErpHR;
	}

	@Override
	public void setHr(FactoryErpHR factoryErpHR) {
		this.factoryErpHR = factoryErpHR;
	}

	private HrEncuestasujetoServicio hrEncuestasujetoServicio;

	@Override
	public HrEncuestasujetoServicio getHrEncuestasujetoServicio() {
		return hrEncuestasujetoServicio;
	}

	@Override
	public void setHrEncuestasujetoServicio(HrEncuestasujetoServicio hrEncuestasujetoServicio) {
		this.hrEncuestasujetoServicio = hrEncuestasujetoServicio;
	}

	private HrEncuestapreguntavaloresServicio hrEncuestapreguntavaloresServicio;

	@Override
	public HrEncuestapreguntavaloresServicio getHrEncuestapreguntavaloresServicio() {
		return hrEncuestapreguntavaloresServicio;
	}

	@Override
	public void setHrEncuestapreguntavaloresServicio(
			HrEncuestapreguntavaloresServicio hrEncuestapreguntavaloresServicio) {
		this.hrEncuestapreguntavaloresServicio = hrEncuestapreguntavaloresServicio;
	}

	private HrEncuestapreguntaServicio hrEncuestapreguntaServicio;

	@Override
	public HrEncuestapreguntaServicio getHrEncuestapreguntaServicio() {
		return hrEncuestapreguntaServicio;
	}

	@Override
	public void setHrEncuestapreguntaServicio(HrEncuestapreguntaServicio hrEncuestapreguntaServicio) {
		this.hrEncuestapreguntaServicio = hrEncuestapreguntaServicio;
	}

	private HrEncuestaplantilladetalleServicio hrEncuestaplantilladetalleServicio;

	@Override
	public HrEncuestaplantilladetalleServicio getHrEncuestaplantilladetalleServicio() {
		return hrEncuestaplantilladetalleServicio;
	}

	@Override
	public void setHrEncuestaplantilladetalleServicio(
			HrEncuestaplantilladetalleServicio hrEncuestaplantilladetalleServicio) {
		this.hrEncuestaplantilladetalleServicio = hrEncuestaplantilladetalleServicio;
	}

	private HrEncuestaplantillaServicio hrEncuestaplantillaServicio;

	@Override
	public HrEncuestaplantillaServicio getHrEncuestaplantillaServicio() {
		return hrEncuestaplantillaServicio;
	}

	@Override
	public void setHrEncuestaplantillaServicio(HrEncuestaplantillaServicio hrEncuestaplantillaServicio) {
		this.hrEncuestaplantillaServicio = hrEncuestaplantillaServicio;
	}

	private HrEncuestadetalleServicio hrEncuestadetalleServicio;

	@Override
	public HrEncuestadetalleServicio getHrEncuestadetalleServicio() {
		return hrEncuestadetalleServicio;
	}

	@Override
	public void setHrEncuestadetalleServicio(HrEncuestadetalleServicio hrEncuestadetalleServicio) {
		this.hrEncuestadetalleServicio = hrEncuestadetalleServicio;
	}

	private HrEncuestaServicio hrEncuestaServicio;

	@Override
	public HrEncuestaServicio getHrEncuestaServicio() {
		return hrEncuestaServicio;
	}

	@Override
	public void setHrEncuestaServicio(HrEncuestaServicio hrEncuestaServicio) {
		this.hrEncuestaServicio = hrEncuestaServicio;
	}

	private HrActividadparticipanteServicio hrActividadparticipanteServicio;

	@Override
	public HrActividadparticipanteServicio getHrActividadparticipanteServicio() {
		return hrActividadparticipanteServicio;
	}

	@Override
	public void setHrActividadparticipanteServicio(HrActividadparticipanteServicio hrActividadparticipanteServicio) {
		this.hrActividadparticipanteServicio = hrActividadparticipanteServicio;
	}

	private HrActividadServicio hrActividadServicio;

	@Override
	public HrActividadServicio getHrActividadServicio() {
		return hrActividadServicio;
	}

	@Override
	public void setHrActividadServicio(HrActividadServicio hrActividadServicio) {
		this.hrActividadServicio = hrActividadServicio;
	}

	private HrTipoevaluadorServicio hrTipoevaluadorServicio;

	@Override
	public HrTipoevaluadorServicio getHrTipoevaluadorServicio() {
		return hrTipoevaluadorServicio;
	}

	@Override
	public void setHrTipoevaluadorServicio(HrTipoevaluadorServicio hrTipoevaluadorServicio) {
		this.hrTipoevaluadorServicio = hrTipoevaluadorServicio;
	}

	private HrTipocontratoServicio hrTipocontratoServicio;

	@Override
	public HrTipocontratoServicio getHrTipocontratoServicio() {
		return hrTipocontratoServicio;
	}

	@Override
	public void setHrTipocontratoServicio(HrTipocontratoServicio hrTipocontratoServicio) {
		this.hrTipocontratoServicio = hrTipocontratoServicio;
	}

	private HrSueldosServicio hrSueldosServicio;

	@Override
	public HrSueldosServicio getHrSueldosServicio() {
		return hrSueldosServicio;
	}

	@Override
	public void setHrSueldosServicio(HrSueldosServicio hrSueldosServicio) {
		this.hrSueldosServicio = hrSueldosServicio;
	}

	private HrSeguridadServicio hrSeguridadServicio;

	@Override
	public HrSeguridadServicio getHrSeguridadServicio() {
		return hrSeguridadServicio;
	}

	@Override
	public void setHrSeguridadServicio(HrSeguridadServicio hrSeguridadServicio) {
		this.hrSeguridadServicio = hrSeguridadServicio;
	}

	private HrPuestoempresaServicio hrPuestoempresaServicio;

	@Override
	public HrPuestoempresaServicio getHrPuestoempresaServicio() {
		return hrPuestoempresaServicio;
	}

	@Override
	public void setHrPuestoempresaServicio(HrPuestoempresaServicio hrPuestoempresaServicio) {
		this.hrPuestoempresaServicio = hrPuestoempresaServicio;
	}

	private HrPlantillafactorevaluacionServicio hrPlantillafactorevaluacionServicio;

	@Override
	public HrPlantillafactorevaluacionServicio getHrPlantillafactorevaluacionServicio() {
		return hrPlantillafactorevaluacionServicio;
	}

	@Override
	public void setHrPlantillafactorevaluacionServicio(
			HrPlantillafactorevaluacionServicio hrPlantillafactorevaluacionServicio) {
		this.hrPlantillafactorevaluacionServicio = hrPlantillafactorevaluacionServicio;
	}

	private HrMeritosfaltasServicio hrMeritosfaltasServicio;

	@Override
	public HrMeritosfaltasServicio getHrMeritosfaltasServicio() {
		return hrMeritosfaltasServicio;
	}

	@Override
	public void setHrMeritosfaltasServicio(HrMeritosfaltasServicio hrMeritosfaltasServicio) {
		this.hrMeritosfaltasServicio = hrMeritosfaltasServicio;
	}

	private HrFactorvalorServicio hrFactorvalorServicio;

	@Override
	public HrFactorvalorServicio getHrFactorvalorServicio() {
		return hrFactorvalorServicio;
	}

	@Override
	public void setHrFactorvalorServicio(HrFactorvalorServicio hrFactorvalorServicio) {
		this.hrFactorvalorServicio = hrFactorvalorServicio;
	}

	private HrFactoresevaluacionplantillaServicio hrFactoresevaluacionplantillaServicio;

	@Override
	public HrFactoresevaluacionplantillaServicio getHrFactoresevaluacionplantillaServicio() {
		return hrFactoresevaluacionplantillaServicio;
	}

	@Override
	public void setHrFactoresevaluacionplantillaServicio(
			HrFactoresevaluacionplantillaServicio hrFactoresevaluacionplantillaServicio) {
		this.hrFactoresevaluacionplantillaServicio = hrFactoresevaluacionplantillaServicio;
	}

	private HrFactoresevaluacionServicio hrFactoresevaluacionServicio;

	@Override
	public HrFactoresevaluacionServicio getHrFactoresevaluacionServicio() {
		return hrFactoresevaluacionServicio;
	}

	@Override
	public void setHrFactoresevaluacionServicio(HrFactoresevaluacionServicio hrFactoresevaluacionServicio) {
		this.hrFactoresevaluacionServicio = hrFactoresevaluacionServicio;
	}

	private HrEvaluaciontipoevaluadorServicio hrEvaluaciontipoevaluadorServicio;

	@Override
	public HrEvaluaciontipoevaluadorServicio getHrEvaluaciontipoevaluadorServicio() {
		return hrEvaluaciontipoevaluadorServicio;
	}

	@Override
	public void setHrEvaluaciontipoevaluadorServicio(
			HrEvaluaciontipoevaluadorServicio hrEvaluaciontipoevaluadorServicio) {
		this.hrEvaluaciontipoevaluadorServicio = hrEvaluaciontipoevaluadorServicio;
	}

	private HrEvaluacionperiodovalorServicio hrEvaluacionperiodovalorServicio;

	@Override
	public HrEvaluacionperiodovalorServicio getHrEvaluacionperiodovalorServicio() {
		return hrEvaluacionperiodovalorServicio;
	}

	@Override
	public void setHrEvaluacionperiodovalorServicio(HrEvaluacionperiodovalorServicio hrEvaluacionperiodovalorServicio) {
		this.hrEvaluacionperiodovalorServicio = hrEvaluacionperiodovalorServicio;
	}

	private HrEvaluacionperiodocriterioServicio hrEvaluacionperiodocriterioServicio;

	@Override
	public HrEvaluacionperiodocriterioServicio getHrEvaluacionperiodocriterioServicio() {
		return hrEvaluacionperiodocriterioServicio;
	}

	@Override
	public void setHrEvaluacionperiodocriterioServicio(
			HrEvaluacionperiodocriterioServicio hrEvaluacionperiodocriterioServicio) {
		this.hrEvaluacionperiodocriterioServicio = hrEvaluacionperiodocriterioServicio;
	}

	private HrEvaluacionperiodoServicio hrEvaluacionperiodoServicio;

	@Override
	public HrEvaluacionperiodoServicio getHrEvaluacionperiodoServicio() {
		return hrEvaluacionperiodoServicio;
	}

	@Override
	public void setHrEvaluacionperiodoServicio(HrEvaluacionperiodoServicio hrEvaluacionperiodoServicio) {
		this.hrEvaluacionperiodoServicio = hrEvaluacionperiodoServicio;
	}

	private HrEvaluacionesrangoServicio hrEvaluacionesrangoServicio;

	@Override
	public HrEvaluacionesrangoServicio getHrEvaluacionesrangoServicio() {
		return hrEvaluacionesrangoServicio;
	}

	@Override
	public void setHrEvaluacionesrangoServicio(HrEvaluacionesrangoServicio hrEvaluacionesrangoServicio) {
		this.hrEvaluacionesrangoServicio = hrEvaluacionesrangoServicio;
	}

	private HrEvaluacionempleadoServicio hrEvaluacionempleadoServicio;

	@Override
	public HrEvaluacionempleadoServicio getHrEvaluacionempleadoServicio() {
		return hrEvaluacionempleadoServicio;
	}

	@Override
	public void setHrEvaluacionempleadoServicio(HrEvaluacionempleadoServicio hrEvaluacionempleadoServicio) {
		this.hrEvaluacionempleadoServicio = hrEvaluacionempleadoServicio;
	}

	private HrEvaluacionareaServicio hrEvaluacionareaServicio;

	@Override
	public HrEvaluacionareaServicio getHrEvaluacionareaServicio() {
		return hrEvaluacionareaServicio;
	}

	@Override
	public void setHrEvaluacionareaServicio(HrEvaluacionareaServicio hrEvaluacionareaServicio) {
		this.hrEvaluacionareaServicio = hrEvaluacionareaServicio;
	}

	private HrEmpleadorevisionServicio hrEmpleadorevisionServicio;

	@Override
	public HrEmpleadorevisionServicio getHrEmpleadorevisionServicio() {
		return hrEmpleadorevisionServicio;
	}

	@Override
	public void setHrEmpleadorevisionServicio(HrEmpleadorevisionServicio hrEmpleadorevisionServicio) {
		this.hrEmpleadorevisionServicio = hrEmpleadorevisionServicio;
	}

	private HrEmpleadonecesidadcapacitaServicio hrEmpleadonecesidadcapacitaServicio;

	@Override
	public HrEmpleadonecesidadcapacitaServicio getHrEmpleadonecesidadcapacitaServicio() {
		return hrEmpleadonecesidadcapacitaServicio;
	}

	@Override
	public void setHrEmpleadonecesidadcapacitaServicio(
			HrEmpleadonecesidadcapacitaServicio hrEmpleadonecesidadcapacitaServicio) {
		this.hrEmpleadonecesidadcapacitaServicio = hrEmpleadonecesidadcapacitaServicio;
	}

	private HrEmpleadometasServicio hrEmpleadometasServicio;

	@Override
	public HrEmpleadometasServicio getHrEmpleadometasServicio() {
		return hrEmpleadometasServicio;
	}

	@Override
	public void setHrEmpleadometasServicio(HrEmpleadometasServicio hrEmpleadometasServicio) {
		this.hrEmpleadometasServicio = hrEmpleadometasServicio;
	}

	private HrEmpleadofuncionServicio hrEmpleadofuncionServicio;

	@Override
	public HrEmpleadofuncionServicio getHrEmpleadofuncionServicio() {
		return hrEmpleadofuncionServicio;
	}

	@Override
	public void setHrEmpleadofuncionServicio(HrEmpleadofuncionServicio hrEmpleadofuncionServicio) {
		this.hrEmpleadofuncionServicio = hrEmpleadofuncionServicio;
	}

	private HrEmpleadodesempenoServicio hrEmpleadodesempenoServicio;

	@Override
	public HrEmpleadodesempenoServicio getHrEmpleadodesempenoServicio() {
		return hrEmpleadodesempenoServicio;
	}

	@Override
	public void setHrEmpleadodesempenoServicio(HrEmpleadodesempenoServicio hrEmpleadodesempenoServicio) {
		this.hrEmpleadodesempenoServicio = hrEmpleadodesempenoServicio;
	}

	private HrEmpleadoconsiderapotencialServicio hrEmpleadoconsiderapotencialServicio;

	@Override
	public HrEmpleadoconsiderapotencialServicio getHrEmpleadoconsiderapotencialServicio() {
		return hrEmpleadoconsiderapotencialServicio;
	}

	@Override
	public void setHrEmpleadoconsiderapotencialServicio(
			HrEmpleadoconsiderapotencialServicio hrEmpleadoconsiderapotencialServicio) {
		this.hrEmpleadoconsiderapotencialServicio = hrEmpleadoconsiderapotencialServicio;
	}

	private HrEmpleadocomentariosServicio hrEmpleadocomentariosServicio;

	@Override
	public HrEmpleadocomentariosServicio getHrEmpleadocomentariosServicio() {
		return hrEmpleadocomentariosServicio;
	}

	@Override
	public void setHrEmpleadocomentariosServicio(HrEmpleadocomentariosServicio hrEmpleadocomentariosServicio) {
		this.hrEmpleadocomentariosServicio = hrEmpleadocomentariosServicio;
	}

	private HrEmpleadoServicio hrEmpleadoServicio;

	@Override
	public HrEmpleadoServicio getHrEmpleadoServicio() {
		return hrEmpleadoServicio;
	}

	@Override
	public void setHrEmpleadoServicio(HrEmpleadoServicio hrEmpleadoServicio) {
		this.hrEmpleadoServicio = hrEmpleadoServicio;
	}

	private HrDetalleevaluacionmejoraServicio hrDetalleevaluacionmejoraServicio;

	@Override
	public HrDetalleevaluacionmejoraServicio getHrDetalleevaluacionmejoraServicio() {
		return hrDetalleevaluacionmejoraServicio;
	}

	@Override
	public void setHrDetalleevaluacionmejoraServicio(
			HrDetalleevaluacionmejoraServicio hrDetalleevaluacionmejoraServicio) {
		this.hrDetalleevaluacionmejoraServicio = hrDetalleevaluacionmejoraServicio;
	}

	private HrDetalleevaluacionServicio hrDetalleevaluacionServicio;

	@Override
	public HrDetalleevaluacionServicio getHrDetalleevaluacionServicio() {
		return hrDetalleevaluacionServicio;
	}

	@Override
	public void setHrDetalleevaluacionServicio(HrDetalleevaluacionServicio hrDetalleevaluacionServicio) {
		this.hrDetalleevaluacionServicio = hrDetalleevaluacionServicio;
	}

	private HrDepartamentoServicio hrDepartamentoServicio;

	@Override
	public HrDepartamentoServicio getHrDepartamentoServicio() {
		return hrDepartamentoServicio;
	}

	@Override
	public void setHrDepartamentoServicio(HrDepartamentoServicio hrDepartamentoServicio) {
		this.hrDepartamentoServicio = hrDepartamentoServicio;
	}

	private HrContratosServicio hrContratosServicio;

	@Override
	public HrContratosServicio getHrContratosServicio() {
		return hrContratosServicio;
	}

	@Override
	public void setHrContratosServicio(HrContratosServicio hrContratosServicio) {
		this.hrContratosServicio = hrContratosServicio;
	}

	private HrCargosmastServicio hrCargosmastServicio;

	@Override
	public HrCargosmastServicio getHrCargosmastServicio() {
		return hrCargosmastServicio;
	}

	@Override
	public void setHrCargosmastServicio(HrCargosmastServicio hrCargosmastServicio) {
		this.hrCargosmastServicio = hrCargosmastServicio;
	}

	private HrBsMetaServicio hrBsMetaServicio;

	@Override
	public HrBsMetaServicio getHrBsMetaServicio() {
		return hrBsMetaServicio;
	}

	@Override
	public void setHrBsMetaServicio(HrBsMetaServicio hrBsMetaServicio) {
		this.hrBsMetaServicio = hrBsMetaServicio;
	}

	private HrBsLineadeaccionServicio hrBsLineadeaccionServicio;

	@Override
	public HrBsLineadeaccionServicio getHrBsLineadeaccionServicio() {
		return hrBsLineadeaccionServicio;
	}

	@Override
	public void setHrBsLineadeaccionServicio(HrBsLineadeaccionServicio hrBsLineadeaccionServicio) {
		this.hrBsLineadeaccionServicio = hrBsLineadeaccionServicio;
	}

	private HrAfpServicio hrAfpServicio;

	@Override
	public HrAfpServicio getHrAfpServicio() {
		return hrAfpServicio;
	}

	@Override
	public void setHrAfpServicio(HrAfpServicio hrAfpServicio) {
		this.hrAfpServicio = hrAfpServicio;
	}

	private HrActividadRutasServicio hrActividadRutasServicio;

	@Override
	public HrActividadRutasServicio getHrActividadRutasServicio() {
		return hrActividadRutasServicio;
	}

	@Override
	public void setHrActividadRutasServicio(HrActividadRutasServicio hrActividadRutasServicio) {
		this.hrActividadRutasServicio = hrActividadRutasServicio;
	}

	private HrActividadChecklistServicio hrActividadChecklistServicio;

	@Override
	public HrActividadChecklistServicio getHrActividadChecklistServicio() {
		return hrActividadChecklistServicio;
	}

	@Override
	public void setHrActividadChecklistServicio(HrActividadChecklistServicio hrActividadChecklistServicio) {
		this.hrActividadChecklistServicio = hrActividadChecklistServicio;
	}

	private HrActividadprogramacionServicio hrActividadprogramacionServicio;

	@Override
	public HrActividadprogramacionServicio getHrActividadprogramacionServicio() {
		return hrActividadprogramacionServicio;
	}

	@Override
	public void setHrActividadprogramacionServicio(HrActividadprogramacionServicio hrActividadprogramacionServicio) {
		this.hrActividadprogramacionServicio = hrActividadprogramacionServicio;
	}

	private HrActividadbeneficiarioServicio hrActividadbeneficiarioServicio;

	@Override
	public HrActividadbeneficiarioServicio getHrActividadbeneficiarioServicio() {
		return hrActividadbeneficiarioServicio;
	}

	@Override
	public void setHrActividadbeneficiarioServicio(HrActividadbeneficiarioServicio hrActividadbeneficiarioServicio) {
		this.hrActividadbeneficiarioServicio = hrActividadbeneficiarioServicio;
	}

	private HrPlantillaevapotencialServicio hrPlantillaevapotencialServicio;

	@Override
	public HrPlantillaevapotencialServicio getHrPlantillaevapotencialServicio() {
		return hrPlantillaevapotencialServicio;
	}

	@Override
	public void setHrPlantillaevapotencialServicio(HrPlantillaevapotencialServicio hrPlantillaevapotencialServicio) {
		this.hrPlantillaevapotencialServicio = hrPlantillaevapotencialServicio;
	}

	private HrEvaluacioncandidatohistServicio hrEvaluacioncandidatohistServicio;

	@Override
	public HrEvaluacioncandidatohistServicio getHrEvaluacioncandidatohistServicio() {
		return hrEvaluacioncandidatohistServicio;
	}

	@Override
	public void setHrEvaluacioncandidatohistServicio(
			HrEvaluacioncandidatohistServicio hrEvaluacioncandidatohistServicio) {
		this.hrEvaluacioncandidatohistServicio = hrEvaluacioncandidatohistServicio;
	}

	private HrCapacitacionServicio hrCapacitacionServicio;

	@Override
	public HrCapacitacionServicio getHrCapacitacionServicio() {
		return hrCapacitacionServicio;
	}

	@Override
	public void setHrCapacitacionServicio(HrCapacitacionServicio hrCapacitacionServicio) {
		this.hrCapacitacionServicio = hrCapacitacionServicio;
	}

	private HrCursodescripcionServicio hrCursodescripcionServicio;

	@Override
	public HrCursodescripcionServicio getHrCursodescripcionServicio() {
		return hrCursodescripcionServicio;
	}

	@Override
	public void setHrCursodescripcionServicio(HrCursodescripcionServicio hrCursodescripcionServicio) {
		this.hrCursodescripcionServicio = hrCursodescripcionServicio;
	}

	private HrFactorvalorcapacServicio hrFactorvalorcapacServicio;

	@Override
	public HrFactorvalorcapacServicio getHrFactorvalorcapacServicio() {
		return hrFactorvalorcapacServicio;
	}

	@Override
	public void setHrFactorvalorcapacServicio(HrFactorvalorcapacServicio hrFactorvalorcapacServicio) {
		this.hrFactorvalorcapacServicio = hrFactorvalorcapacServicio;
	}

	private HrEvaluacioncapacvalorServicio hrEvaluacioncapacvalorServicio;

	@Override
	public HrEvaluacioncapacvalorServicio getHrEvaluacioncapacvalorServicio() {
		return hrEvaluacioncapacvalorServicio;
	}

	@Override
	public void setHrEvaluacioncapacvalorServicio(HrEvaluacioncapacvalorServicio hrEvaluacioncapacvalorServicio) {
		this.hrEvaluacioncapacvalorServicio = hrEvaluacioncapacvalorServicio;
	}

	private HrEmpleadoasistenciasServicio hrEmpleadoasistenciasServicio;

	@Override
	public HrEmpleadoasistenciasServicio getHrEmpleadoasistenciasServicio() {
		return hrEmpleadoasistenciasServicio;
	}

	@Override
	public void setHrEmpleadoasistenciasServicio(HrEmpleadoasistenciasServicio hrEmpleadoasistenciasServicio) {
		this.hrEmpleadoasistenciasServicio = hrEmpleadoasistenciasServicio;
	}

	private HrCursocomprobantesServicio hrCursocomprobantesServicio;

	@Override
	public HrCursocomprobantesServicio getHrCursocomprobantesServicio() {
		return hrCursocomprobantesServicio;
	}

	@Override
	public void setHrCursocomprobantesServicio(HrCursocomprobantesServicio hrCursocomprobantesServicio) {
		this.hrCursocomprobantesServicio = hrCursocomprobantesServicio;
	}

	private HrCapacitacionevalServicio hrCapacitacionevalServicio;

	@Override
	public HrCapacitacionevalServicio getHrCapacitacionevalServicio() {
		return hrCapacitacionevalServicio;
	}

	@Override
	public void setHrCapacitacionevalServicio(HrCapacitacionevalServicio hrCapacitacionevalServicio) {
		this.hrCapacitacionevalServicio = hrCapacitacionevalServicio;
	}

	private HrProfesionServicio hrProfesionServicio;

	@Override
	public HrProfesionServicio getHrProfesionServicio() {
		return hrProfesionServicio;
	}

	@Override
	public void setHrProfesionServicio(HrProfesionServicio hrProfesionServicio) {
		this.hrProfesionServicio = hrProfesionServicio;
	}

	private HrGradosalariomastServicio hrGradosalariomastServicio;

	@Override
	public HrGradosalariomastServicio getHrGradosalariomastServicio() {
		return hrGradosalariomastServicio;
	}

	@Override
	public void setHrGradosalariomastServicio(HrGradosalariomastServicio hrGradosalariomastServicio) {
		this.hrGradosalariomastServicio = hrGradosalariomastServicio;
	}

	private HrRequerimientoreemplazoServicio hrRequerimientoreemplazoServicio;

	@Override
	public HrRequerimientoreemplazoServicio getHrRequerimientoreemplazoServicio() {
		return hrRequerimientoreemplazoServicio;
	}

	@Override
	public void setHrRequerimientoreemplazoServicio(HrRequerimientoreemplazoServicio hrRequerimientoreemplazoServicio) {
		this.hrRequerimientoreemplazoServicio = hrRequerimientoreemplazoServicio;
	}

	private HrRequerimientopuestoobjServicio hrRequerimientopuestoobjServicio;

	@Override
	public HrRequerimientopuestoobjServicio getHrRequerimientopuestoobjServicio() {
		return hrRequerimientopuestoobjServicio;
	}

	@Override
	public void setHrRequerimientopuestoobjServicio(HrRequerimientopuestoobjServicio hrRequerimientopuestoobjServicio) {
		this.hrRequerimientopuestoobjServicio = hrRequerimientopuestoobjServicio;
	}

	private HrRequerimientopuestoidiServicio hrRequerimientopuestoidiServicio;

	@Override
	public HrRequerimientopuestoidiServicio getHrRequerimientopuestoidiServicio() {
		return hrRequerimientopuestoidiServicio;
	}

	@Override
	public void setHrRequerimientopuestoidiServicio(HrRequerimientopuestoidiServicio hrRequerimientopuestoidiServicio) {
		this.hrRequerimientopuestoidiServicio = hrRequerimientopuestoidiServicio;
	}

	private HrRequerimientopuestofunServicio hrRequerimientopuestofunServicio;

	@Override
	public HrRequerimientopuestofunServicio getHrRequerimientopuestofunServicio() {
		return hrRequerimientopuestofunServicio;
	}

	@Override
	public void setHrRequerimientopuestofunServicio(HrRequerimientopuestofunServicio hrRequerimientopuestofunServicio) {
		this.hrRequerimientopuestofunServicio = hrRequerimientopuestofunServicio;
	}

	private HrRequerimientopuestoforServicio hrRequerimientopuestoforServicio;

	@Override
	public HrRequerimientopuestoforServicio getHrRequerimientopuestoforServicio() {
		return hrRequerimientopuestoforServicio;
	}

	@Override
	public void setHrRequerimientopuestoforServicio(HrRequerimientopuestoforServicio hrRequerimientopuestoforServicio) {
		this.hrRequerimientopuestoforServicio = hrRequerimientopuestoforServicio;
	}

	private HrRequerimientopuestoexpServicio hrRequerimientopuestoexpServicio;

	@Override
	public HrRequerimientopuestoexpServicio getHrRequerimientopuestoexpServicio() {
		return hrRequerimientopuestoexpServicio;
	}

	@Override
	public void setHrRequerimientopuestoexpServicio(HrRequerimientopuestoexpServicio hrRequerimientopuestoexpServicio) {
		this.hrRequerimientopuestoexpServicio = hrRequerimientopuestoexpServicio;
	}

	private HrRequerimientopuestoestServicio hrRequerimientopuestoestServicio;

	@Override
	public HrRequerimientopuestoestServicio getHrRequerimientopuestoestServicio() {
		return hrRequerimientopuestoestServicio;
	}

	@Override
	public void setHrRequerimientopuestoestServicio(HrRequerimientopuestoestServicio hrRequerimientopuestoestServicio) {
		this.hrRequerimientopuestoestServicio = hrRequerimientopuestoestServicio;
	}

	private HrRequerimientopuestocompServicio hrRequerimientopuestocompServicio;

	@Override
	public HrRequerimientopuestocompServicio getHrRequerimientopuestocompServicio() {
		return hrRequerimientopuestocompServicio;
	}

	@Override
	public void setHrRequerimientopuestocompServicio(
			HrRequerimientopuestocompServicio hrRequerimientopuestocompServicio) {
		this.hrRequerimientopuestocompServicio = hrRequerimientopuestocompServicio;
	}

	private HrRequerimientopuestoServicio hrRequerimientopuestoServicio;

	@Override
	public HrRequerimientopuestoServicio getHrRequerimientopuestoServicio() {
		return hrRequerimientopuestoServicio;
	}

	@Override
	public void setHrRequerimientopuestoServicio(HrRequerimientopuestoServicio hrRequerimientopuestoServicio) {
		this.hrRequerimientopuestoServicio = hrRequerimientopuestoServicio;
	}

	private HrRequerimientoobservacionServicio hrRequerimientoobservacionServicio;

	@Override
	public HrRequerimientoobservacionServicio getHrRequerimientoobservacionServicio() {
		return hrRequerimientoobservacionServicio;
	}

	@Override
	public void setHrRequerimientoobservacionServicio(
			HrRequerimientoobservacionServicio hrRequerimientoobservacionServicio) {
		this.hrRequerimientoobservacionServicio = hrRequerimientoobservacionServicio;
	}

	private HrRequerimientomotivoAprobServicio hrRequerimientomotivoAprobServicio;

	@Override
	public HrRequerimientomotivoAprobServicio getHrRequerimientomotivoAprobServicio() {
		return hrRequerimientomotivoAprobServicio;
	}

	@Override
	public void setHrRequerimientomotivoAprobServicio(
			HrRequerimientomotivoAprobServicio hrRequerimientomotivoAprobServicio) {
		this.hrRequerimientomotivoAprobServicio = hrRequerimientomotivoAprobServicio;
	}

	private HrRequerimientofunpracServicio hrRequerimientofunpracServicio;

	@Override
	public HrRequerimientofunpracServicio getHrRequerimientofunpracServicio() {
		return hrRequerimientofunpracServicio;
	}

	@Override
	public void setHrRequerimientofunpracServicio(HrRequerimientofunpracServicio hrRequerimientofunpracServicio) {
		this.hrRequerimientofunpracServicio = hrRequerimientofunpracServicio;
	}

	private HrRequerimientofuncasdetServicio hrRequerimientofuncasdetServicio;

	@Override
	public HrRequerimientofuncasdetServicio getHrRequerimientofuncasdetServicio() {
		return hrRequerimientofuncasdetServicio;
	}

	@Override
	public void setHrRequerimientofuncasdetServicio(HrRequerimientofuncasdetServicio hrRequerimientofuncasdetServicio) {
		this.hrRequerimientofuncasdetServicio = hrRequerimientofuncasdetServicio;
	}

	private HrRequerimientofuncasServicio hrRequerimientofuncasServicio;

	@Override
	public HrRequerimientofuncasServicio getHrRequerimientofuncasServicio() {
		return hrRequerimientofuncasServicio;
	}

	@Override
	public void setHrRequerimientofuncasServicio(HrRequerimientofuncasServicio hrRequerimientofuncasServicio) {
		this.hrRequerimientofuncasServicio = hrRequerimientofuncasServicio;
	}

	private HrRequerimientodocaprobacionServicio hrRequerimientodocaprobacionServicio;

	@Override
	public HrRequerimientodocaprobacionServicio getHrRequerimientodocaprobacionServicio() {
		return hrRequerimientodocaprobacionServicio;
	}

	@Override
	public void setHrRequerimientodocaprobacionServicio(
			HrRequerimientodocaprobacionServicio hrRequerimientodocaprobacionServicio) {
		this.hrRequerimientodocaprobacionServicio = hrRequerimientodocaprobacionServicio;
	}

	private HrRequerimientoServicio hrRequerimientoServicio;

	@Override
	public HrRequerimientoServicio getHrRequerimientoServicio() {
		return hrRequerimientoServicio;
	}

	@Override
	public void setHrRequerimientoServicio(HrRequerimientoServicio hrRequerimientoServicio) {
		this.hrRequerimientoServicio = hrRequerimientoServicio;
	}

	private HrCentroestudiosServicio hrCentroestudiosServicio;

	@Override
	public HrCentroestudiosServicio getHrCentroestudiosServicio() {
		return hrCentroestudiosServicio;
	}

	@Override
	public void setHrCentroestudiosServicio(HrCentroestudiosServicio hrCentroestudiosServicio) {
		this.hrCentroestudiosServicio = hrCentroestudiosServicio;
	}

	private HrEmpleadocapacitacionServicio hrEmpleadocapacitacionServicio;

	@Override
	public HrEmpleadocapacitacionServicio getHrEmpleadocapacitacionServicio() {
		return hrEmpleadocapacitacionServicio;
	}

	@Override
	public void setHrEmpleadocapacitacionServicio(HrEmpleadocapacitacionServicio hrEmpleadocapacitacionServicio) {
		this.hrEmpleadocapacitacionServicio = hrEmpleadocapacitacionServicio;
	}

	private HrDncSolicitanteServicio hrDncSolicitanteServicio;

	@Override
	public HrDncSolicitanteServicio getHrDncSolicitanteServicio() {
		return hrDncSolicitanteServicio;
	}

	@Override
	public void setHrDncSolicitanteServicio(HrDncSolicitanteServicio hrDncSolicitanteServicio) {
		this.hrDncSolicitanteServicio = hrDncSolicitanteServicio;
	}

	private HrTipotrabajadorServicio hrTipotrabajadorServicio;

	@Override
	public HrTipotrabajadorServicio getHrTipotrabajadorServicio() {
		return hrTipotrabajadorServicio;
	}

	@Override
	public void setHrTipotrabajadorServicio(HrTipotrabajadorServicio hrTipotrabajadorServicio) {
		this.hrTipotrabajadorServicio = hrTipotrabajadorServicio;
	}

	private HrPuestosubordinadoServicio hrPuestosubordinadoServicio;

	@Override
	public HrPuestosubordinadoServicio getHrPuestosubordinadoServicio() {
		return hrPuestosubordinadoServicio;
	}

	@Override
	public void setHrPuestosubordinadoServicio(HrPuestosubordinadoServicio hrPuestosubordinadoServicio) {
		this.hrPuestosubordinadoServicio = hrPuestosubordinadoServicio;
	}

	private HrPuestosimilarServicio hrPuestosimilarServicio;

	@Override
	public HrPuestosimilarServicio getHrPuestosimilarServicio() {
		return hrPuestosimilarServicio;
	}

	@Override
	public void setHrPuestosimilarServicio(HrPuestosimilarServicio hrPuestosimilarServicio) {
		this.hrPuestosimilarServicio = hrPuestosimilarServicio;
	}

	private HrPuestoriesgotrabajoServicio hrPuestoriesgotrabajoServicio;

	@Override
	public HrPuestoriesgotrabajoServicio getHrPuestoriesgotrabajoServicio() {
		return hrPuestoriesgotrabajoServicio;
	}

	@Override
	public void setHrPuestoriesgotrabajoServicio(HrPuestoriesgotrabajoServicio hrPuestoriesgotrabajoServicio) {
		this.hrPuestoriesgotrabajoServicio = hrPuestoriesgotrabajoServicio;
	}

	private HrPuestoresponsabilidadesServicio hrPuestoresponsabilidadesServicio;

	@Override
	public HrPuestoresponsabilidadesServicio getHrPuestoresponsabilidadesServicio() {
		return hrPuestoresponsabilidadesServicio;
	}

	@Override
	public void setHrPuestoresponsabilidadesServicio(
			HrPuestoresponsabilidadesServicio hrPuestoresponsabilidadesServicio) {
		this.hrPuestoresponsabilidadesServicio = hrPuestoresponsabilidadesServicio;
	}

	private HrPuestoreportaServicio hrPuestoreportaServicio;

	@Override
	public HrPuestoreportaServicio getHrPuestoreportaServicio() {
		return hrPuestoreportaServicio;
	}

	@Override
	public void setHrPuestoreportaServicio(HrPuestoreportaServicio hrPuestoreportaServicio) {
		this.hrPuestoreportaServicio = hrPuestoreportaServicio;
	}

	private HrPuestorelacionesServicio hrPuestorelacionesServicio;

	@Override
	public HrPuestorelacionesServicio getHrPuestorelacionesServicio() {
		return hrPuestorelacionesServicio;
	}

	@Override
	public void setHrPuestorelacionesServicio(HrPuestorelacionesServicio hrPuestorelacionesServicio) {
		this.hrPuestorelacionesServicio = hrPuestorelacionesServicio;
	}

	private HrPuestopersonaacargoServicio hrPuestopersonaacargoServicio;

	@Override
	public HrPuestopersonaacargoServicio getHrPuestopersonaacargoServicio() {
		return hrPuestopersonaacargoServicio;
	}

	@Override
	public void setHrPuestopersonaacargoServicio(HrPuestopersonaacargoServicio hrPuestopersonaacargoServicio) {
		this.hrPuestopersonaacargoServicio = hrPuestopersonaacargoServicio;
	}

	private HrPuestoinformaticaServicio hrPuestoinformaticaServicio;

	@Override
	public HrPuestoinformaticaServicio getHrPuestoinformaticaServicio() {
		return hrPuestoinformaticaServicio;
	}

	@Override
	public void setHrPuestoinformaticaServicio(HrPuestoinformaticaServicio hrPuestoinformaticaServicio) {
		this.hrPuestoinformaticaServicio = hrPuestoinformaticaServicio;
	}

	private HrPuestoidiomasServicio hrPuestoidiomasServicio;

	@Override
	public HrPuestoidiomasServicio getHrPuestoidiomasServicio() {
		return hrPuestoidiomasServicio;
	}

	@Override
	public void setHrPuestoidiomasServicio(HrPuestoidiomasServicio hrPuestoidiomasServicio) {
		this.hrPuestoidiomasServicio = hrPuestoidiomasServicio;
	}

	private HrPuestofuncionesServicio hrPuestofuncionesServicio;

	@Override
	public HrPuestofuncionesServicio getHrPuestofuncionesServicio() {
		return hrPuestofuncionesServicio;
	}

	@Override
	public void setHrPuestofuncionesServicio(HrPuestofuncionesServicio hrPuestofuncionesServicio) {
		this.hrPuestofuncionesServicio = hrPuestofuncionesServicio;
	}

	private HrPuestoformacionServicio hrPuestoformacionServicio;

	@Override
	public HrPuestoformacionServicio getHrPuestoformacionServicio() {
		return hrPuestoformacionServicio;
	}

	@Override
	public void setHrPuestoformacionServicio(HrPuestoformacionServicio hrPuestoformacionServicio) {
		this.hrPuestoformacionServicio = hrPuestoformacionServicio;
	}

	private HrPuestoexperienciaServicio hrPuestoexperienciaServicio;

	@Override
	public HrPuestoexperienciaServicio getHrPuestoexperienciaServicio() {
		return hrPuestoexperienciaServicio;
	}

	@Override
	public void setHrPuestoexperienciaServicio(HrPuestoexperienciaServicio hrPuestoexperienciaServicio) {
		this.hrPuestoexperienciaServicio = hrPuestoexperienciaServicio;
	}

	private HrPuestoevaluacionServicio hrPuestoevaluacionServicio;

	@Override
	public HrPuestoevaluacionServicio getHrPuestoevaluacionServicio() {
		return hrPuestoevaluacionServicio;
	}

	@Override
	public void setHrPuestoevaluacionServicio(HrPuestoevaluacionServicio hrPuestoevaluacionServicio) {
		this.hrPuestoevaluacionServicio = hrPuestoevaluacionServicio;
	}

	private HrPuestoempresaDocServicio hrPuestoempresaDocServicio;

	@Override
	public HrPuestoempresaDocServicio getHrPuestoempresaDocServicio() {
		return hrPuestoempresaDocServicio;
	}

	@Override
	public void setHrPuestoempresaDocServicio(HrPuestoempresaDocServicio hrPuestoempresaDocServicio) {
		this.hrPuestoempresaDocServicio = hrPuestoempresaDocServicio;
	}

	private HrPuestocursosServicio hrPuestocursosServicio;

	@Override
	public HrPuestocursosServicio getHrPuestocursosServicio() {
		return hrPuestocursosServicio;
	}

	@Override
	public void setHrPuestocursosServicio(HrPuestocursosServicio hrPuestocursosServicio) {
		this.hrPuestocursosServicio = hrPuestocursosServicio;
	}

	private HrPuestoconfianzaServicio hrPuestoconfianzaServicio;

	@Override
	public HrPuestoconfianzaServicio getHrPuestoconfianzaServicio() {
		return hrPuestoconfianzaServicio;
	}

	@Override
	public void setHrPuestoconfianzaServicio(HrPuestoconfianzaServicio hrPuestoconfianzaServicio) {
		this.hrPuestoconfianzaServicio = hrPuestoconfianzaServicio;
	}

	private HrPuestocondicionestrabajoServicio hrPuestocondicionestrabajoServicio;

	@Override
	public HrPuestocondicionestrabajoServicio getHrPuestocondicionestrabajoServicio() {
		return hrPuestocondicionestrabajoServicio;
	}

	@Override
	public void setHrPuestocondicionestrabajoServicio(
			HrPuestocondicionestrabajoServicio hrPuestocondicionestrabajoServicio) {
		this.hrPuestocondicionestrabajoServicio = hrPuestocondicionestrabajoServicio;
	}

	private HrPuestoclaveServicio hrPuestoclaveServicio;

	@Override
	public HrPuestoclaveServicio getHrPuestoclaveServicio() {
		return hrPuestoclaveServicio;
	}

	@Override
	public void setHrPuestoclaveServicio(HrPuestoclaveServicio hrPuestoclaveServicio) {
		this.hrPuestoclaveServicio = hrPuestoclaveServicio;
	}

	private HrMetaspuestoServicio hrMetaspuestoServicio;

	@Override
	public HrMetaspuestoServicio getHrMetaspuestoServicio() {
		return hrMetaspuestoServicio;
	}

	@Override
	public void setHrMetaspuestoServicio(HrMetaspuestoServicio hrMetaspuestoServicio) {
		this.hrMetaspuestoServicio = hrMetaspuestoServicio;
	}

	private HrIdiomasmastServicio hrIdiomasmastServicio;

	@Override
	public HrIdiomasmastServicio getHrIdiomasmastServicio() {
		return hrIdiomasmastServicio;
	}

	@Override
	public void setHrIdiomasmastServicio(HrIdiomasmastServicio hrIdiomasmastServicio) {
		this.hrIdiomasmastServicio = hrIdiomasmastServicio;
	}

	private HrPosicionempresaServicio hrPosicionempresaServicio;

	@Override
	public HrPosicionempresaServicio getHrPosicionempresaServicio() {
		return hrPosicionempresaServicio;
	}

	@Override
	public void setHrPosicionempresaServicio(HrPosicionempresaServicio hrPosicionempresaServicio) {
		this.hrPosicionempresaServicio = hrPosicionempresaServicio;
	}

	private HrOrganigramaServicio hrOrganigramaServicio;

	@Override
	public HrOrganigramaServicio getHrOrganigramaServicio() {
		return hrOrganigramaServicio;
	}

	@Override
	public void setHrOrganigramaServicio(HrOrganigramaServicio hrOrganigramaServicio) {
		this.hrOrganigramaServicio = hrOrganigramaServicio;
	}

	private HrGradoinstruccionServicio hrGradoinstruccionServicio;

	@Override
	public HrGradoinstruccionServicio getHrGradoinstruccionServicio() {
		return hrGradoinstruccionServicio;
	}

	@Override
	public void setHrGradoinstruccionServicio(HrGradoinstruccionServicio hrGradoinstruccionServicio) {
		this.hrGradoinstruccionServicio = hrGradoinstruccionServicio;
	}

	private HrCorreoflujoServicio hrCorreoflujoServicio;

	@Override
	public HrCorreoflujoServicio getHrCorreoflujoServicio() {
		return hrCorreoflujoServicio;
	}

	@Override
	public void setHrCorreoflujoServicio(HrCorreoflujoServicio hrCorreoflujoServicio) {
		this.hrCorreoflujoServicio = hrCorreoflujoServicio;
	}

	private HrCtrlentregasplantillaServicio hrCtrlentregasplantillaServicio;

	@Override
	public HrCtrlentregasplantillaServicio getHrCtrlentregasplantillaServicio() {
		return hrCtrlentregasplantillaServicio;
	}

	@Override
	public void setHrCtrlentregasplantillaServicio(HrCtrlentregasplantillaServicio hrCtrlentregasplantillaServicio) {
		this.hrCtrlentregasplantillaServicio = hrCtrlentregasplantillaServicio;
	}

	private HrClasificadorcargoServicio hrClasificadorcargoServicio;

	@Override
	public HrClasificadorcargoServicio getHrClasificadorcargoServicio() {
		return hrClasificadorcargoServicio;
	}

	@Override
	public void setHrClasificadorcargoServicio(HrClasificadorcargoServicio hrClasificadorcargoServicio) {
		this.hrClasificadorcargoServicio = hrClasificadorcargoServicio;
	}

	private HrMotivoceseServicio hrMotivoceseServicio;

	@Override
	public HrMotivoceseServicio getHrMotivoceseServicio() {
		return hrMotivoceseServicio;
	}

	@Override
	public void setHrMotivoceseServicio(HrMotivoceseServicio hrMotivoceseServicio) {
		this.hrMotivoceseServicio = hrMotivoceseServicio;
	}

	private HrEmpleadocursosServicio hrEmpleadocursosServicio;

	@Override
	public HrEmpleadocursosServicio getHrEmpleadocursosServicio() {
		return hrEmpleadocursosServicio;
	}

	@Override
	public void setHrEmpleadocursosServicio(HrEmpleadocursosServicio hrEmpleadocursosServicio) {
		this.hrEmpleadocursosServicio = hrEmpleadocursosServicio;
	}

	private HrEmpleadocursosdocumentoServicio hrEmpleadocursosdocumentoServicio;

	@Override
	public HrEmpleadocursosdocumentoServicio getHrEmpleadocursosdocumentoServicio() {
		return hrEmpleadocursosdocumentoServicio;
	}

	@Override
	public void setHrEmpleadocursosdocumentoServicio(
			HrEmpleadocursosdocumentoServicio hrEmpleadocursosdocumentoServicio) {
		this.hrEmpleadocursosdocumentoServicio = hrEmpleadocursosdocumentoServicio;
	}

	private HrPosRequerServicio hrPosRequerServicio;

	@Override
	public HrPosRequerServicio getHrPosRequerServicio() {
		return hrPosRequerServicio;
	}

	@Override
	public void setHrPosRequerServicio(HrPosRequerServicio hrPosRequerServicio) {
		this.hrPosRequerServicio = hrPosRequerServicio;
	}

	private HrEvaluacionetapaServicio hrEvaluacionetapaServicio;

	@Override
	public HrEvaluacionetapaServicio getHrEvaluacionetapaServicio() {
		return hrEvaluacionetapaServicio;
	}

	@Override
	public void setHrEvaluacionetapaServicio(HrEvaluacionetapaServicio hrEvaluacionetapaServicio) {
		this.hrEvaluacionetapaServicio = hrEvaluacionetapaServicio;
	}

	private HrEvaluacionpostulanteServicio hrEvaluacionpostulanteServicio;

	@Override
	public HrEvaluacionpostulanteServicio getHrEvaluacionpostulanteServicio() {
		return hrEvaluacionpostulanteServicio;
	}

	@Override
	public void setHrEvaluacionpostulanteServicio(HrEvaluacionpostulanteServicio hrEvaluacionpostulanteServicio) {
		this.hrEvaluacionpostulanteServicio = hrEvaluacionpostulanteServicio;
	}

	private HrPostulantesServicio hrPostulantesServicio;

	@Override
	public HrPostulantesServicio getHrPostulantesServicio() {
		return hrPostulantesServicio;
	}

	@Override
	public void setHrPostulantesServicio(HrPostulantesServicio hrPostulantesServicio) {
		this.hrPostulantesServicio = hrPostulantesServicio;
	}

	private HrEvaluacionServicio hrEvaluacionServicio;

	@Override
	public HrEvaluacionServicio getHrEvaluacionServicio() {
		return hrEvaluacionServicio;
	}

	@Override
	public void setHrEvaluacionServicio(HrEvaluacionServicio hrEvaluacionServicio) {
		this.hrEvaluacionServicio = hrEvaluacionServicio;
	}

	private HrEvaluacionRequerimientoServicio hrEvaluacionRequerimientoServicio;

	@Override
	public HrEvaluacionRequerimientoServicio getHrEvaluacionRequerimientoServicio() {
		return hrEvaluacionRequerimientoServicio;
	}

	@Override
	public void setHrEvaluacionRequerimientoServicio(
			HrEvaluacionRequerimientoServicio hrEvaluacionRequerimientoServicio) {
		this.hrEvaluacionRequerimientoServicio = hrEvaluacionRequerimientoServicio;
	}

	private HrPostulanteexperienciaServicio hrPostulanteexperienciaServicio;

	@Override
	public HrPostulanteexperienciaServicio getHrPostulanteexperienciaServicio() {
		return hrPostulanteexperienciaServicio;
	}

	@Override
	public void setHrPostulanteexperienciaServicio(HrPostulanteexperienciaServicio hrPostulanteexperienciaServicio) {
		this.hrPostulanteexperienciaServicio = hrPostulanteexperienciaServicio;
	}

	/** The hr empleadocapa documento servicio. */
	private HrEmpleadocapaDocumentoServicio hrEmpleadocapaDocumentoServicio;

	@Override
	public HrEmpleadocapaDocumentoServicio getHrEmpleadocapaDocumentoServicio() {
		return hrEmpleadocapaDocumentoServicio;
	}

	@Override
	public void setHrEmpleadocapaDocumentoServicio(HrEmpleadocapaDocumentoServicio hrEmpleadocapaDocumentoServicio) {
		this.hrEmpleadocapaDocumentoServicio = hrEmpleadocapaDocumentoServicio;
	}

	/** The hr evalrequerimiento servicio. */
	private HrEvalrequerimientoServicio hrEvalrequerimientoServicio;

	@Override
	public HrEvalrequerimientoServicio getHrEvalrequerimientoServicio() {
		return hrEvalrequerimientoServicio;
	}

	@Override
	public void setHrEvalrequerimientoServicio(HrEvalrequerimientoServicio hrEvalrequerimientoServicio) {
		this.hrEvalrequerimientoServicio = hrEvalrequerimientoServicio;
	}

	private HrRequerimientoAdjuntoServicio hrRequerimientoAdjuntoServicio;

	@Override
	public HrRequerimientoAdjuntoServicio getHrRequerimientoAdjuntoServicio() {
		return hrRequerimientoAdjuntoServicio;
	}

	public void setHrRequerimientoAdjuntoServicio(HrRequerimientoAdjuntoServicio hrRequerimientoAdjuntoServicio) {
		this.hrRequerimientoAdjuntoServicio = hrRequerimientoAdjuntoServicio;
	}

}
