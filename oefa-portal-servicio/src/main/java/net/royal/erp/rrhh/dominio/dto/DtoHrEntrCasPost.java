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
public class DtoHrEntrCasPost implements java.io.Serializable {

	private String requerimiento;
	private String postulante;
	private String idpostulante;
	private String estado;
	private String n_estado;
	private String puntaje;
	private String orden;
	private String asistencia;
	private String especialidad;
	private String nombreespecialidad;
	private String documento;
	private String fotoPostulante;
	private String fechanacimiento;
	private String celularlocal;
	private String fechainicioexamen;
	private String fechafinexamen;
	private BigDecimal cantsalidaexamen;
	private BigDecimal cantsession;
	private BigDecimal minadicionalesexamen;
	private String tipodocumento;
	private BigDecimal pregRespondidas;
	private Date inicio_examen;
	private Date fin_examen;
	private String inicio_sala;
	private String fin_sala;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getIdpostulante() {
		return idpostulante;
	}

	public void setIdpostulante(String idpostulante) {
		this.idpostulante = idpostulante;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
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

	public String getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombreespecialidad() {
		return nombreespecialidad;
	}

	public void setNombreespecialidad(String nombreespecialidad) {
		this.nombreespecialidad = nombreespecialidad;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFotoPostulante() {
		return fotoPostulante;
	}

	public void setFotoPostulante(String fotoPostulante) {
		this.fotoPostulante = fotoPostulante;
	}

	public String getFechafinexamen() {
		return fechafinexamen;
	}

	public void setFechafinexamen(String fechafinexamen) {
		this.fechafinexamen = fechafinexamen;
	}

	public String getFechainicioexamen() {
		return fechainicioexamen;
	}

	public void setFechainicioexamen(String fechainicioexamen) {
		this.fechainicioexamen = fechainicioexamen;
	}

	public BigDecimal getCantsalidaexamen() {
		return cantsalidaexamen;
	}

	public void setCantsalidaexamen(BigDecimal cantsalidaexamen) {
		this.cantsalidaexamen = cantsalidaexamen;
	}

	public BigDecimal getCantsession() {
		if (UValidador.esNulo(cantsession)) {
			cantsession = BigDecimal.ZERO;
		}
		return cantsession;
	}

	public void setCantsession(BigDecimal cantsession) {
		this.cantsession = cantsession;
	}

	public BigDecimal getMinadicionalesexamen() {
		if (UValidador.esNulo(minadicionalesexamen)) {
			minadicionalesexamen = BigDecimal.ZERO;
		}
		return minadicionalesexamen;
	}

	public void setMinadicionalesexamen(BigDecimal minadicionalesexamen) {
		this.minadicionalesexamen = minadicionalesexamen;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public BigDecimal getPregRespondidas() {
		return pregRespondidas;
	}

	public void setPregRespondidas(BigDecimal pregRespondidas) {
		this.pregRespondidas = pregRespondidas;
	}

	public Date getInicio_examen() {
		return inicio_examen;
	}

	public void setInicio_examen(Date inicio_examen) {
		this.inicio_examen = inicio_examen;
	}

	public Date getFin_examen() {
		return fin_examen;
	}

	public void setFin_examen(Date fin_examen) {
		this.fin_examen = fin_examen;
	}

	public String getInicio_sala() {
		return inicio_sala;
	}

	public void setInicio_sala(String inicio_sala) {
		this.inicio_sala = inicio_sala;
	}

	public String getFin_sala() {
		return fin_sala;
	}

	public void setFin_sala(String fin_sala) {
		this.fin_sala = fin_sala;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getCelularlocal() {
		return celularlocal;
	}

	public void setCelularlocal(String celularlocal) {
		this.celularlocal = celularlocal;
	}

}
