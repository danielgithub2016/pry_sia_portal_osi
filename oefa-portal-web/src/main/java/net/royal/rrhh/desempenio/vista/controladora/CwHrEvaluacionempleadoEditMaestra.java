package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.dto.DtoDDesempenocomparativoP;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;

@SuppressWarnings("serial")
public class CwHrEvaluacionempleadoEditMaestra extends CBaseBean {
	
	public List<DtoHrDetalleEvaluacion> getDw1() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw1();
	}

	public void setDw1(List<DtoHrDetalleEvaluacion> dw1) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw1(dw1);
	}

	public List<HrEmpleadometas> getDw6() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw6();
	}

	public void setDw6(List<HrEmpleadometas> dw6) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw6(dw6);
	}

	public List<DtoDwHrEmpleadonecesidadcapacitaEdit> getDw7() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw7();
	}

	public void setDw7(List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw7(dw7);
	}

	public List<HrEmpleadometas> getDw8() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw8();
	}

	public void setDw8(List<HrEmpleadometas> dw8) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw8(dw8);
	}

	public List<HrEmpleadofuncion> getDw11() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw11();
	}

	public void setDw11(List<HrEmpleadofuncion> dw11) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw11(dw11);		
	}

	public List<HrDetalleevaluacionmejora> getDwcompromisomejora() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDwcompromisomejora();
	}

	public void setDwcompromisomejora(
			List<HrDetalleevaluacionmejora> dwcompromisomejora) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDwcompromisomejora(dwcompromisomejora);
	}

	public DtoDwHrEmpleadoevaluacionEdit getDw_evaluacion() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw_evaluacion();
	}

	public void setDw_evaluacion(DtoDwHrEmpleadoevaluacionEdit dw_evaluacion) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw_evaluacion(dw_evaluacion);
	}

	public List<HrEmpleadorevision> getDwrevision() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDwrevision();
	}

	public void setDwrevision(List<HrEmpleadorevision> dwrevision) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDwrevision(dwrevision);
	}

	public List<HrEmpleadoconsiderapotencial> getDw10() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw10();
	}

	public void setDw10(List<HrEmpleadoconsiderapotencial> dw10) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw10(dw10);
	}

	public BigDecimal getDw6totalcalificacion() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw6totalcalificacion();
	}

	public void setDw6totalcalificacion(BigDecimal dw6totalcalificacion) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw6totalcalificacion(dw6totalcalificacion);
	}

	public BigDecimal getDw11totalcalificacion() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw11totalcalificacion();
	}

	public void setDw11totalcalificacion(BigDecimal dw11totalcalificacion) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw11totalcalificacion(dw11totalcalificacion);
	}

	public List<DtoDwHrEmpleadoevaluacionDetailP> getDw9() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw9();
	}

	public void setDw9(List<DtoDwHrEmpleadoevaluacionDetailP> dw9) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw9(dw9);
	}

	public List<DtoDDesempenocomparativoP> getDw15p() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw15p();
	}

	public void setDw15p(List<DtoDDesempenocomparativoP> dw15p) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw15p(dw15p);
	}

	public List<HrDetalleevaluacion> getDwcampo() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDwcampo();
	}

	public void setDwcampo(List<HrDetalleevaluacion> dwcampo) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDwcampo(dwcampo);
	}

	public List<HrEmpleadocomentarios> getDwcomentario() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDwcomentario();
	}

	public void setDwcomentario(List<HrEmpleadocomentarios> dwcomentario) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDwcomentario(dwcomentario);
	}

	public BigDecimal getDw9totalpuntospotencial() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw9totalpuntospotencial();
	}

	public void setDw9totalpuntospotencial(BigDecimal dw9totalpuntospotencial) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw9totalpuntospotencial(dw9totalpuntospotencial);
	}

	public  List<HrEmpleadodesempeno> getDw5() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw5();
	}

	public  void setDw5(List<HrEmpleadodesempeno> dw5) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw5(dw5);
	}

	public List<DtoDwHrIncidentecriticoList> getDw3() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDw3();
	}

	public void setDw3(List<DtoDwHrIncidentecriticoList> dw3) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDw3(dw3);
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwcampo_child() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().getDwcampo_child();
	}

	public void setDwcampo_child(
			List<DtoDwMaMiscelaneosdetalleSelect> dwcampo_child) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setDwcampo_child(dwcampo_child);
	}
	
	
	
	public Integer obtenerSecuenciaActual(List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7){
		return CwHrEvaluacionempleadoEditSesion.getInstance().obtenerSecuenciaActual(dw7);
	}

	public boolean isBloqueofechacierre() {
		return CwHrEvaluacionempleadoEditSesion.getInstance().isBloqueofechacierre();
	}

	public void setBloqueofechacierre(boolean bloqueofechacierre) {
		CwHrEvaluacionempleadoEditSesion.getInstance().setBloqueofechacierre(bloqueofechacierre);
	}


}
