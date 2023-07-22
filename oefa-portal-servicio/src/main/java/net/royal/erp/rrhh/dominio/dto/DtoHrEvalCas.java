package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuesta
 */
@SuppressWarnings("serial")
public class DtoHrEvalCas implements java.io.Serializable {

	private BigDecimal id_sala;
	private BigDecimal id_evaluador01;
	private BigDecimal id_evaluador02;
	private BigDecimal id_evaluador03;
	private BigDecimal id_evaluador04;
	private BigDecimal id_evaluador05;
	private String id_evalcas;
	private String requerimiento;
	private String convocatoria;
	private String nro_requerimiento;
	private String puesto;
	private String unidad;
	private String estado;
	private String n_estado;
	private String n_partotal;
	private String n_grupo;
	private String n_partgrupo;
	private String n_partgrupoini;
	private String n_partotaleval;
	private String n_postsala;
	private Date fechaFiltro;
	private String tipoencuestadesc;
	private String valor_s;
	private String valor_n;

	private BigDecimal ejecuto;
	private String codigogrupo;
	private String especialidad;
	private String ciudad;
	private String nombregrupo;
	private String nombreciudad;
	private String nombreespecialidad;
	private String nombresala;
	private String nombresupervisor01;
	private String nombrecoordinador01;
	private String nombresupervisor02;
	private String nombrecoordinador02;
	private String nombreevaluador;
	private String nombresupervisor;
	private String nombrecoordinador;
	private BigDecimal id_supervisor01;
	private BigDecimal id_supervisor02;
	private BigDecimal id_coordinador01;
	private BigDecimal id_coordinador02;
	private String fecha_evaluacion;
	private String flgtipopuesto;

	public String getId_evalcas() {
		return id_evalcas;
	}

	public void setId_evalcas(String id_evalcas) {
		this.id_evalcas = id_evalcas;
	}

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getNro_requerimiento() {
		return nro_requerimiento;
	}

	public void setNro_requerimiento(String nro_requerimiento) {
		this.nro_requerimiento = nro_requerimiento;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getN_estado() {
		return n_estado;
	}

	public void setN_estado(String n_estado) {
		this.n_estado = n_estado;
	}

	public String getN_partotal() {
		return n_partotal;
	}

	public void setN_partotal(String n_partotal) {
		this.n_partotal = n_partotal;
	}

	public String getN_grupo() {
		return n_grupo;
	}

	public void setN_grupo(String n_grupo) {
		this.n_grupo = n_grupo;
	}

	public String getN_partgrupo() {
		return n_partgrupo;
	}

	public void setN_partgrupo(String n_partgrupo) {
		this.n_partgrupo = n_partgrupo;
	}

	public String getN_partgrupoini() {
		return n_partgrupoini;
	}

	public void setN_partgrupoini(String n_partgrupoini) {
		this.n_partgrupoini = n_partgrupoini;
	}

	public String getN_partotaleval() {
		return n_partotaleval;
	}

	public void setN_partotaleval(String n_partotaleval) {
		this.n_partotaleval = n_partotaleval;
	}

	public Date getFechaFiltro() {
		return fechaFiltro;
	}

	public void setFechaFiltro(Date fechaFiltro) {
		this.fechaFiltro = fechaFiltro;
	}

	public String getTipoencuestadesc() {
		return tipoencuestadesc;
	}

	public void setTipoencuestadesc(String tipoencuestadesc) {
		this.tipoencuestadesc = tipoencuestadesc;
	}

	public BigDecimal getEjecuto() {
		return ejecuto;
	}

	public void setEjecuto(BigDecimal ejecuto) {
		this.ejecuto = ejecuto;
	}

	public String getValor_s() {
		return valor_s;
	}

	public void setValor_s(String valor_s) {
		this.valor_s = valor_s;
	}

	public String getValor_n() {
		return valor_n;
	}

	public void setValor_n(String valor_n) {
		this.valor_n = valor_n;
	}

	public String getCodigogrupo() {
		return codigogrupo;
	}

	public void setCodigogrupo(String codigogrupo) {
		this.codigogrupo = codigogrupo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombregrupo() {
		return nombregrupo;
	}

	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}

	public String getNombreciudad() {
		return nombreciudad;
	}

	public void setNombreciudad(String nombreciudad) {
		this.nombreciudad = nombreciudad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombreespecialidad() {
		return nombreespecialidad;
	}

	public void setNombreespecialidad(String nombreespecialidad) {
		this.nombreespecialidad = nombreespecialidad;
	}

	public String getFecha_evaluacion() {
		return fecha_evaluacion;
	}

	public void setFecha_evaluacion(String fecha_evaluacion) {
		this.fecha_evaluacion = fecha_evaluacion;
	}

	public String getFlgtipopuesto() {
		return flgtipopuesto;
	}

	public void setFlgtipopuesto(String flgtipopuesto) {
		this.flgtipopuesto = flgtipopuesto;
	}

	public BigDecimal getId_sala() {
		return id_sala;
	}

	public void setId_sala(BigDecimal id_sala) {
		this.id_sala = id_sala;
	}

	public BigDecimal getId_evaluador01() {
		if (UValidador.esNulo(id_evaluador01)) {
			id_evaluador01 = BigDecimal.ZERO;
		}
		return id_evaluador01;
	}

	public void setId_evaluador01(BigDecimal id_evaluador01) {
		this.id_evaluador01 = id_evaluador01;
	}

	public BigDecimal getId_evaluador02() {
		if (UValidador.esNulo(id_evaluador02)) {
			id_evaluador02 = BigDecimal.ZERO;
		}
		return id_evaluador02;
	}

	public void setId_evaluador02(BigDecimal id_evaluador02) {
		this.id_evaluador02 = id_evaluador02;
	}

	public BigDecimal getId_evaluador03() {
		if (UValidador.esNulo(id_evaluador03)) {
			id_evaluador03 = BigDecimal.ZERO;
		}
		return id_evaluador03;
	}

	public void setId_evaluador03(BigDecimal id_evaluador03) {
		this.id_evaluador03 = id_evaluador03;
	}

	public BigDecimal getId_evaluador04() {
		if (UValidador.esNulo(id_evaluador04)) {
			id_evaluador04 = BigDecimal.ZERO;
		}
		return id_evaluador04;
	}

	public void setId_evaluador04(BigDecimal id_evaluador04) {
		this.id_evaluador04 = id_evaluador04;
	}

	public BigDecimal getId_evaluador05() {
		if (UValidador.esNulo(id_evaluador05)) {
			id_evaluador05 = BigDecimal.ZERO;
		}
		return id_evaluador05;
	}

	public void setId_evaluador05(BigDecimal id_evaluador05) {
		this.id_evaluador05 = id_evaluador05;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getNombresala() {
		return nombresala;
	}

	public void setNombresala(String nombresala) {
		this.nombresala = nombresala;
	}

	public String getNombresupervisor01() {
		return nombresupervisor01;
	}

	public void setNombresupervisor01(String nombresupervisor01) {
		this.nombresupervisor01 = nombresupervisor01;
	}

	public String getNombrecoordinador01() {
		return nombrecoordinador01;
	}

	public void setNombrecoordinador01(String nombrecoordinador01) {
		this.nombrecoordinador01 = nombrecoordinador01;
	}

	public String getNombresupervisor02() {
		return nombresupervisor02;
	}

	public void setNombresupervisor02(String nombresupervisor02) {
		this.nombresupervisor02 = nombresupervisor02;
	}

	public String getNombrecoordinador02() {
		return nombrecoordinador02;
	}

	public void setNombrecoordinador02(String nombrecoordinador02) {
		this.nombrecoordinador02 = nombrecoordinador02;
	}

	public BigDecimal getId_supervisor01() {
		return id_supervisor01;
	}

	public void setId_supervisor01(BigDecimal id_supervisor01) {
		this.id_supervisor01 = id_supervisor01;
	}

	public BigDecimal getId_supervisor02() {
		return id_supervisor02;
	}

	public void setId_supervisor02(BigDecimal id_supervisor02) {
		this.id_supervisor02 = id_supervisor02;
	}

	public BigDecimal getId_coordinador01() {
		return id_coordinador01;
	}

	public void setId_coordinador01(BigDecimal id_coordinador01) {
		this.id_coordinador01 = id_coordinador01;
	}

	public BigDecimal getId_coordinador02() {
		return id_coordinador02;
	}

	public void setId_coordinador02(BigDecimal id_coordinador02) {
		this.id_coordinador02 = id_coordinador02;
	}

	public String getNombreevaluador() {
		return nombreevaluador;
	}

	public void setNombreevaluador(String nombreevaluador) {
		this.nombreevaluador = nombreevaluador;
	}

	public String getNombresupervisor() {
		return nombresupervisor;
	}

	public void setNombresupervisor(String nombresupervisor) {
		this.nombresupervisor = nombresupervisor;
	}

	public String getNombrecoordinador() {
		return nombrecoordinador;
	}

	public void setNombrecoordinador(String nombrecoordinador) {
		this.nombrecoordinador = nombrecoordinador;
	}

	public String getN_postsala() {
		return n_postsala;
	}

	public void setN_postsala(String n_postsala) {
		this.n_postsala = n_postsala;
	}

}
