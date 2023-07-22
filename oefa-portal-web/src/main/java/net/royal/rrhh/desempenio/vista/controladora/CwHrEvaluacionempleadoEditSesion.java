package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
import net.royal.framework.web.core.UFaces;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CwHrEvaluacionempleadoEditSesion extends CBaseBean {

	private DtoDwHrEmpleadoevaluacionEdit dw_evaluacion;

	private List<DtoHrDetalleEvaluacion> dw1;
	private List<DtoDwHrIncidentecriticoList> dw3;
	private List<HrEmpleadometas> dw6;
	private List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7;
	private List<HrEmpleadometas> dw8;
	private List<DtoDwHrEmpleadoevaluacionDetailP> dw9;
	private List<HrEmpleadoconsiderapotencial> dw10;
	private List<HrEmpleadofuncion> dw11;
	private List<DtoDDesempenocomparativoP> dw15p;
	private List<HrDetalleevaluacionmejora> dwcompromisomejora;
	private List<HrEmpleadorevision> dwrevision;
	private List<HrDetalleevaluacion> dwcampo;
	private List<HrEmpleadocomentarios> dwcomentario;
	private List<HrEmpleadodesempeno> dw5;

	private BigDecimal dw6totalcalificacion;
	private BigDecimal dw11totalcalificacion;
	private BigDecimal dw9totalpuntospotencial;
	private List<DtoDwMaMiscelaneosdetalleSelect> dwcampo_child;
	private boolean bloqueofechacierre;

	public static CwHrEvaluacionempleadoEditSesion getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrEvaluacionempleadoEditSesion}",
				CwHrEvaluacionempleadoEditSesion.class);
	}

	public List<DtoHrDetalleEvaluacion> getDw1() {
		return dw1;
	}

	public void setDw1(List<DtoHrDetalleEvaluacion> dw1) {
		this.dw1 = dw1;
	}

	public List<HrEmpleadometas> getDw6() {
		return dw6;
	}

	public void setDw6(List<HrEmpleadometas> dw6) {
		this.dw6 = dw6;
	}

	public List<DtoDwHrEmpleadonecesidadcapacitaEdit> getDw7() {
		return dw7;
	}

	public void setDw7(List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7) {
		this.dw7 = dw7;
	}

	public List<HrEmpleadometas> getDw8() {
		return dw8;
	}

	public void setDw8(List<HrEmpleadometas> dw8) {
		this.dw8 = dw8;
	}

	public List<HrEmpleadofuncion> getDw11() {
		return dw11;
	}

	public void setDw11(List<HrEmpleadofuncion> dw11) {
		this.dw11 = dw11;
	}

	public List<HrDetalleevaluacionmejora> getDwcompromisomejora() {
		return dwcompromisomejora;
	}

	public void setDwcompromisomejora(List<HrDetalleevaluacionmejora> dwcompromisomejora) {
		this.dwcompromisomejora = dwcompromisomejora;
	}

	public DtoDwHrEmpleadoevaluacionEdit getDw_evaluacion() {
		return dw_evaluacion;
	}

	public void setDw_evaluacion(DtoDwHrEmpleadoevaluacionEdit dw_evaluacion) {
		this.dw_evaluacion = dw_evaluacion;
	}

	public List<HrEmpleadorevision> getDwrevision() {
		return dwrevision;
	}

	public void setDwrevision(List<HrEmpleadorevision> dwrevision) {
		this.dwrevision = dwrevision;
	}

	public List<HrEmpleadoconsiderapotencial> getDw10() {
		return dw10;
	}

	public void setDw10(List<HrEmpleadoconsiderapotencial> dw10) {
		this.dw10 = dw10;
	}

	public BigDecimal getDw6totalcalificacion() {
		return dw6totalcalificacion;
	}

	public void setDw6totalcalificacion(BigDecimal dw6totalcalificacion) {
		this.dw6totalcalificacion = dw6totalcalificacion;
	}

	public BigDecimal getDw11totalcalificacion() {
		return dw11totalcalificacion;
	}

	public void setDw11totalcalificacion(BigDecimal dw11totalcalificacion) {
		this.dw11totalcalificacion = dw11totalcalificacion;
	}

	public List<DtoDwHrEmpleadoevaluacionDetailP> getDw9() {
		return dw9;
	}

	public void setDw9(List<DtoDwHrEmpleadoevaluacionDetailP> dw9) {
		this.dw9 = dw9;
	}

	public List<DtoDDesempenocomparativoP> getDw15p() {
		return dw15p;
	}

	public void setDw15p(List<DtoDDesempenocomparativoP> dw15p) {
		this.dw15p = dw15p;
	}

	public List<HrDetalleevaluacion> getDwcampo() {
		return dwcampo;
	}

	public void setDwcampo(List<HrDetalleevaluacion> dwcampo) {
		this.dwcampo = dwcampo;
	}

	public List<HrEmpleadocomentarios> getDwcomentario() {
		return dwcomentario;
	}

	public void setDwcomentario(List<HrEmpleadocomentarios> dwcomentario) {
		this.dwcomentario = dwcomentario;
	}

	public BigDecimal getDw9totalpuntospotencial() {
		return dw9totalpuntospotencial;
	}

	public void setDw9totalpuntospotencial(BigDecimal dw9totalpuntospotencial) {
		this.dw9totalpuntospotencial = dw9totalpuntospotencial;
	}

	public List<HrEmpleadodesempeno> getDw5() {
		return dw5;
	}

	public void setDw5(List<HrEmpleadodesempeno> dw5) {
		this.dw5 = dw5;
	}

	public List<DtoDwHrIncidentecriticoList> getDw3() {
		return dw3;
	}

	public void setDw3(List<DtoDwHrIncidentecriticoList> dw3) {
		this.dw3 = dw3;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getDwcampo_child() {
		return dwcampo_child;
	}

	public void setDwcampo_child(List<DtoDwMaMiscelaneosdetalleSelect> dwcampo_child) {
		this.dwcampo_child = dwcampo_child;
	}

	public Integer obtenerSecuenciaActual(List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7) {
		Integer secuencia = 0;
		List<DtoDwHrEmpleadonecesidadcapacitaEdit> lstdw7 = new ArrayList<DtoDwHrEmpleadonecesidadcapacitaEdit>();
		for (DtoDwHrEmpleadonecesidadcapacitaEdit objt : dw7) {
			if (objt.getEliminado().equals(ConstanteRrhh.TIPO_NO)) {
				lstdw7.add(objt);
			}
		}

		return lstdw7.size();
	}

	public boolean isBloqueofechacierre() {
		return bloqueofechacierre;
	}

	public void setBloqueofechacierre(boolean bloqueofechacierre) {
		this.bloqueofechacierre = bloqueofechacierre;
	}

	public void inicializarListas() {
		dw_evaluacion = null;
		dw1 = null;
		dw3 = null;
		dw6 = null;
		dw7 = null;
		dw8 = null;
		dw9 = null;
		dw10 = null;
		dw11 = null;
		dw15p = null;
		dwcompromisomejora = null;
		dwrevision = null;
		dwcampo = null;
		dwcomentario = null;
		dw5 = null;
		dw6totalcalificacion = null;
		dw11totalcalificacion = null;
		dw9totalpuntospotencial = null;

	}

}
