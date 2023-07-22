package net.royal.seguridad.dominio;

import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsArea
 */
public class AsArea extends DominioGenerico implements java.io.Serializable {

	private AsAreaPk pk;
	private String nombre;
	private Integer areapadre;
	private Integer diarotacion;
	private java.util.Date ultimarotacion;
	private Integer horario;
	private Integer empleadoresponsable;
	private Integer empleadoresponsable2;
	private Integer empleadoresponsable3;
	private Integer empleadoresponsable4;
	private String estado;
	private Integer empleadovisador;

	private String flagcorreoresponsable1;
	private String flagcorreoresponsable2;
	private String flagcorreoresponsable3;
	private String flagcorreoresponsable4;

	private Integer empleadoaprobador;
	private Integer empleadoaprobador2;
	private Integer empleadoaprobador3;
	private Integer empleadoaprobador4;
	private String flagcorreoaprobador1;
	private String flagcorreoaprobador2;
	private String flagcorreoaprobador3;
	private String flagcorreoaprobador4;

	private String flagexondirectiva;
	private Integer nNroHoras;

	public AsArea() {
		pk = new AsAreaPk();
	}

	public AsAreaPk getPk() {
		return pk;
	}

	public void setPk(AsAreaPk pk) {
		this.pk = pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAreapadre() {
		return areapadre;
	}

	public void setAreapadre(Integer areapadre) {
		this.areapadre = areapadre;
	}

	public Integer getDiarotacion() {
		return diarotacion;
	}

	public void setDiarotacion(Integer diarotacion) {
		this.diarotacion = diarotacion;
	}

	public java.util.Date getUltimarotacion() {
		return ultimarotacion;
	}

	public void setUltimarotacion(java.util.Date ultimarotacion) {
		this.ultimarotacion = ultimarotacion;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public Integer getEmpleadoresponsable() {
		return empleadoresponsable;
	}

	public void setEmpleadoresponsable(Integer empleadoresponsable) {
		this.empleadoresponsable = empleadoresponsable;
	}

	public Integer getEmpleadoresponsable2() {
		return empleadoresponsable2;
	}

	public void setEmpleadoresponsable2(Integer empleadoresponsable2) {
		this.empleadoresponsable2 = empleadoresponsable2;
	}

	public Integer getEmpleadoresponsable3() {
		return empleadoresponsable3;
	}

	public void setEmpleadoresponsable3(Integer empleadoresponsable3) {
		this.empleadoresponsable3 = empleadoresponsable3;
	}

	public Integer getEmpleadoresponsable4() {
		return empleadoresponsable4;
	}

	public void setEmpleadoresponsable4(Integer empleadoresponsable4) {
		this.empleadoresponsable4 = empleadoresponsable4;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getEmpleadovisador() {
		return empleadovisador;
	}

	public void setEmpleadovisador(Integer empleadovisador) {
		this.empleadovisador = empleadovisador;
	}

	public String getFlagcorreoresponsable1() {
		return flagcorreoresponsable1;
	}

	public void setFlagcorreoresponsable1(String flagcorreoresponsable1) {
		this.flagcorreoresponsable1 = flagcorreoresponsable1;
	}

	public String getFlagcorreoresponsable2() {
		return flagcorreoresponsable2;
	}

	public void setFlagcorreoresponsable2(String flagcorreoresponsable2) {
		this.flagcorreoresponsable2 = flagcorreoresponsable2;
	}

	public String getFlagcorreoresponsable3() {
		return flagcorreoresponsable3;
	}

	public void setFlagcorreoresponsable3(String flagcorreoresponsable3) {
		this.flagcorreoresponsable3 = flagcorreoresponsable3;
	}

	public String getFlagcorreoresponsable4() {
		return flagcorreoresponsable4;
	}

	public void setFlagcorreoresponsable4(String flagcorreoresponsable4) {
		this.flagcorreoresponsable4 = flagcorreoresponsable4;
	}

	public Integer getEmpleadoaprobador() {
		return empleadoaprobador;
	}

	public void setEmpleadoaprobador(Integer empleadoaprobador) {
		this.empleadoaprobador = empleadoaprobador;
	}

	public Integer getEmpleadoaprobador2() {
		return empleadoaprobador2;
	}

	public void setEmpleadoaprobador2(Integer empleadoaprobador2) {
		this.empleadoaprobador2 = empleadoaprobador2;
	}

	public Integer getEmpleadoaprobador3() {
		return empleadoaprobador3;
	}

	public void setEmpleadoaprobador3(Integer empleadoaprobador3) {
		this.empleadoaprobador3 = empleadoaprobador3;
	}

	public Integer getEmpleadoaprobador4() {
		return empleadoaprobador4;
	}

	public void setEmpleadoaprobador4(Integer empleadoaprobador4) {
		this.empleadoaprobador4 = empleadoaprobador4;
	}

	public String getFlagcorreoaprobador1() {
		return flagcorreoaprobador1;
	}

	public void setFlagcorreoaprobador1(String flagcorreoaprobador1) {
		this.flagcorreoaprobador1 = flagcorreoaprobador1;
	}

	public String getFlagcorreoaprobador2() {
		return flagcorreoaprobador2;
	}

	public void setFlagcorreoaprobador2(String flagcorreoaprobador2) {
		this.flagcorreoaprobador2 = flagcorreoaprobador2;
	}

	public String getFlagcorreoaprobador3() {
		return flagcorreoaprobador3;
	}

	public void setFlagcorreoaprobador3(String flagcorreoaprobador3) {
		this.flagcorreoaprobador3 = flagcorreoaprobador3;
	}

	public String getFlagcorreoaprobador4() {
		return flagcorreoaprobador4;
	}

	public void setFlagcorreoaprobador4(String flagcorreoaprobador4) {
		this.flagcorreoaprobador4 = flagcorreoaprobador4;
	}

	public String getFlagexondirectiva() {
		return flagexondirectiva;
	}

	public void setFlagexondirectiva(String flagexondirectiva) {
		this.flagexondirectiva = flagexondirectiva;
	}

	public Integer getnNroHoras() {
		return nNroHoras;
	}

	public void setnNroHoras(Integer nNroHoras) {
		this.nNroHoras = nNroHoras;
	}

	
	
}
