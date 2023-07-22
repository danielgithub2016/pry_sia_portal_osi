package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadocursos
 */
public class HrEmpleadocursos extends DominioGenerico implements
		java.io.Serializable {

	private HrEmpleadocursosPk pk;
	private Integer curso;
	private String tipocurso;
	private Integer centroestudios;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String auspicio;
	private Integer dias;
	private String grado;
	private String descripcioncurso;
	private java.math.BigDecimal horas;
	private String speaking;
	private String readingwriting;
	private String listening;
	private String flagcertificacion;
	private String flagcurso;
	private String cursodescripcion;
	private String observaciones;
	private Integer totalhoras;
	private Integer vigencia;
	private String documento;
	private Integer carrera;
	private Integer creditosotorgados;
	private String otrocentroestudios;
	private String capacitacion;
	private String lugarEvento;
	private String areatematica;
	private String rutadocumento;
	private java.math.BigDecimal calificacion;
	private byte[] ruta;

	private BigDecimal cantidadDoc;
	private BigDecimal empleado;
	private BigDecimal secuencia;
	private BigDecimal totalhorasAux;
	private String auxCentroestudios;
	private String auxCurso;
	private String auxTipocurso;
	private String auxTipoCapacitacion,auxTipoRegistro,auxTiempoPermanencia;
	private BigDecimal cursoAux, centroestudiosAux, diasAux,
			vigenciaAux, carreraAux, creditosotorgadosAux;
	private Date auxDateFechaFin;


	public String getAuxTipoCapacitacion() {
		return auxTipoCapacitacion;
	}

	public void setAuxTipoCapacitacion(String auxTipoCapacitacion) {
		this.auxTipoCapacitacion = auxTipoCapacitacion;
	}

	public HrEmpleadocursos() {
		pk = new HrEmpleadocursosPk();
	}

	public HrEmpleadocursosPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadocursosPk pk) {
		this.pk = pk;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public String getTipocurso() {
		return tipocurso;
	}

	public void setTipocurso(String tipocurso) {
		this.tipocurso = tipocurso;
	}

	public Integer getCentroestudios() {
		return centroestudios;
	}

	public void setCentroestudios(Integer centroestudios) {
		this.centroestudios = centroestudios;
	}

	public java.util.Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getAuspicio() {
		return auspicio;
	}

	public void setAuspicio(String auspicio) {
		this.auspicio = auspicio;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getDescripcioncurso() {
		return descripcioncurso;
	}

	public void setDescripcioncurso(String descripcioncurso) {
		this.descripcioncurso = descripcioncurso;
	}

	public java.math.BigDecimal getHoras() {
		return horas;
	}

	public void setHoras(java.math.BigDecimal horas) {
		this.horas = horas;
	}

	public String getSpeaking() {
		return speaking;
	}

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	public String getReadingwriting() {
		return readingwriting;
	}

	public void setReadingwriting(String readingwriting) {
		this.readingwriting = readingwriting;
	}

	public String getListening() {
		return listening;
	}

	public void setListening(String listening) {
		this.listening = listening;
	}

	public String getFlagcertificacion() {
		return flagcertificacion;
	}

	public void setFlagcertificacion(String flagcertificacion) {
		this.flagcertificacion = flagcertificacion;
	}

	public String getFlagcurso() {
		return flagcurso;
	}

	public void setFlagcurso(String flagcurso) {
		this.flagcurso = flagcurso;
	}

	public String getCursodescripcion() {
		return cursodescripcion;
	}

	public void setCursodescripcion(String cursodescripcion) {
		this.cursodescripcion = cursodescripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getTotalhoras() {
		return totalhoras;
	}

	public void setTotalhoras(Integer totalhoras) {
		this.totalhoras = totalhoras;
	}

	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getCarrera() {
		return carrera;
	}

	public void setCarrera(Integer carrera) {
		this.carrera = carrera;
	}

	public Integer getCreditosotorgados() {
		return creditosotorgados;
	}

	public void setCreditosotorgados(Integer creditosotorgados) {
		this.creditosotorgados = creditosotorgados;
	}

	public String getOtrocentroestudios() {
		return otrocentroestudios;
	}

	public void setOtrocentroestudios(String otrocentroestudios) {
		this.otrocentroestudios = otrocentroestudios;
	}

	public String getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}

	public String getLugarEvento() {
		return lugarEvento;
	}

	public void setLugarEvento(String lugarEvento) {
		this.lugarEvento = lugarEvento;
	}

	public String getAreatematica() {
		return areatematica;
	}

	public void setAreatematica(String areatematica) {
		this.areatematica = areatematica;
	}

	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}

	public java.math.BigDecimal getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(java.math.BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public byte[] getRuta() {
		return ruta;
	}

	public void setRuta(byte[] ruta) {
		this.ruta = ruta;
	}

	public String getAuxCentroestudios() {
		return auxCentroestudios;
	}

	public void setAuxCentroestudios(String auxCentroestudios) {
		this.auxCentroestudios = auxCentroestudios;
	}

	public String getAuxCurso() {
		return auxCurso;
	}

	public void setAuxCurso(String auxCurso) {
		this.auxCurso = auxCurso;
	}

	public String getAuxTipocurso() {
		return auxTipocurso;
	}

	public void setAuxTipocurso(String auxTipocurso) {
		this.auxTipocurso = auxTipocurso;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
		this.getPk().setEmpleado(empleado.intValue());
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
		this.getPk().setSecuencia(secuencia.intValue());
	}

	public BigDecimal getCursoAux() {
		return cursoAux;
	}

	public void setCursoAux(BigDecimal cursoAux) {
		this.cursoAux = cursoAux;
		this.setCurso(UValidador.esNulo(cursoAux) ? 0 : cursoAux.intValue());
	}

	public BigDecimal getCentroestudiosAux() {
		return centroestudiosAux;
	}

	public void setCentroestudiosAux(BigDecimal centroestudiosAux) {
		this.centroestudiosAux = centroestudiosAux;
		this.setCentroestudios(UValidador.esNulo(centroestudiosAux) ? 0
				: centroestudiosAux.intValue());
	}

	public BigDecimal getDiasAux() {
		return diasAux;
	}

	public void setDiasAux(BigDecimal diasAux) {
		this.diasAux = diasAux;
		this.setDias(UValidador.esNulo(diasAux) ? 0 : diasAux.intValue());
	}

	public BigDecimal getTotalhorasAux() {
		return totalhorasAux;
	}

	public void setTotalhorasAux(BigDecimal totalhorasAux) {
		this.totalhorasAux = totalhorasAux;
		this.setTotalhoras(UValidador.esNulo(totalhorasAux) ? 0 : totalhorasAux
				.intValue());
	}

	public BigDecimal getVigenciaAux() {
		return vigenciaAux;
	}

	public void setVigenciaAux(BigDecimal vigenciaAux) {
		this.vigenciaAux = vigenciaAux;
		this.setVigencia(UValidador.esNulo(vigenciaAux) ? 0 : vigenciaAux
				.intValue());
	}

	public BigDecimal getCarreraAux() {
		return carreraAux;
	}

	public void setCarreraAux(BigDecimal carreraAux) {
		this.carreraAux = carreraAux;
		this.setCarrera(UValidador.esNulo(carreraAux) ? 0 : carreraAux
				.intValue());
	}

	public BigDecimal getCreditosotorgadosAux() {
		return creditosotorgadosAux;
	}

	public void setCreditosotorgadosAux(BigDecimal creditosotorgadosAux) {
		this.creditosotorgadosAux = creditosotorgadosAux;
		this.setCreditosotorgados(UValidador.esNulo(creditosotorgadosAux) ? 0
				: creditosotorgadosAux.intValue());
	}

	public BigDecimal getCantidadDoc() {
		return cantidadDoc;
	}

	public void setCantidadDoc(BigDecimal cantidadDoc) {
		this.cantidadDoc = cantidadDoc;
	}

	public String getAuxTipoRegistro() {
		return auxTipoRegistro;
	}

	public void setAuxTipoRegistro(String auxTipoRegistro) {
		this.auxTipoRegistro = auxTipoRegistro;
	}

	public String getAuxTiempoPermanencia() {
		return auxTiempoPermanencia;
	}

	public void setAuxTiempoPermanencia(String auxTiempoPermanencia) {
		this.auxTiempoPermanencia = auxTiempoPermanencia;
	}

	public Date getAuxDateFechaFin() {
		return auxDateFechaFin;
	}

	public void setAuxDateFechaFin(Date auxDateFechaFin) {
		this.auxDateFechaFin = auxDateFechaFin;
	}

}
