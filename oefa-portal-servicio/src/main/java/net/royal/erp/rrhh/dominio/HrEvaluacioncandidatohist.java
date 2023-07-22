package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacioncandidatohist
*/
public class HrEvaluacioncandidatohist extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacioncandidatohistPk pk;
	private Integer valor1;
	private Integer valor2;
	private Integer valor3;
	private Integer valor4;
	private Integer valor5;
	private Integer valor6;
	private Integer valor7;
	private Integer valor8;
	private Integer valor9;
	private Integer valor10;
	private Integer empleado;
	private String area;
	private String descripcionarea;
	private String descripcionfactor;
	private Integer empleadoevaluador;
	private String nombreeval;
	private Integer ordenplantillafactor;
	private String tipo;
	private String tipocompetenciafactor;
	private Integer valorminimoesperado;
	private Integer valorrequerido;


	public HrEvaluacioncandidatohist() {
		pk = new HrEvaluacioncandidatohistPk();
	}

	public HrEvaluacioncandidatohistPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacioncandidatohistPk pk) {
		this.pk = pk;
	}
	public Integer getValor1() {
		return valor1;
	}

	public void setValor1(Integer valor1) {
		this.valor1 = valor1;
	}
	public Integer getValor2() {
		return valor2;
	}

	public void setValor2(Integer valor2) {
		this.valor2 = valor2;
	}
	public Integer getValor3() {
		return valor3;
	}

	public void setValor3(Integer valor3) {
		this.valor3 = valor3;
	}
	public Integer getValor4() {
		return valor4;
	}

	public void setValor4(Integer valor4) {
		this.valor4 = valor4;
	}
	public Integer getValor5() {
		return valor5;
	}

	public void setValor5(Integer valor5) {
		this.valor5 = valor5;
	}
	public Integer getValor6() {
		return valor6;
	}

	public void setValor6(Integer valor6) {
		this.valor6 = valor6;
	}
	public Integer getValor7() {
		return valor7;
	}

	public void setValor7(Integer valor7) {
		this.valor7 = valor7;
	}
	public Integer getValor8() {
		return valor8;
	}

	public void setValor8(Integer valor8) {
		this.valor8 = valor8;
	}
	public Integer getValor9() {
		return valor9;
	}

	public void setValor9(Integer valor9) {
		this.valor9 = valor9;
	}
	public Integer getValor10() {
		return valor10;
	}

	public void setValor10(Integer valor10) {
		this.valor10 = valor10;
	}
	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getDescripcionarea() {
		return descripcionarea;
	}

	public void setDescripcionarea(String descripcionarea) {
		this.descripcionarea = descripcionarea;
	}
	public String getDescripcionfactor() {
		return descripcionfactor;
	}

	public void setDescripcionfactor(String descripcionfactor) {
		this.descripcionfactor = descripcionfactor;
	}
	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}
	public String getNombreeval() {
		return nombreeval;
	}

	public void setNombreeval(String nombreeval) {
		this.nombreeval = nombreeval;
	}
	public Integer getOrdenplantillafactor() {
		return ordenplantillafactor;
	}

	public void setOrdenplantillafactor(Integer ordenplantillafactor) {
		this.ordenplantillafactor = ordenplantillafactor;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipocompetenciafactor() {
		return tipocompetenciafactor;
	}

	public void setTipocompetenciafactor(String tipocompetenciafactor) {
		this.tipocompetenciafactor = tipocompetenciafactor;
	}
	public Integer getValorminimoesperado() {
		return valorminimoesperado;
	}

	public void setValorminimoesperado(Integer valorminimoesperado) {
		this.valorminimoesperado = valorminimoesperado;
	}
	public Integer getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(Integer valorrequerido) {
		this.valorrequerido = valorrequerido;
	}

}
