package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DtoAsAutorizacion {
	private Date fecha;
	private Integer veces;
	private Date fechahasta;
	private Integer empleado;
	private Date desde;
	private Date hasta;
	private String concepto;
	private BigDecimal horasSobretiempo;
	private BigDecimal horasSobretiempo1;
	private BigDecimal minutosSobretiempo1;
	private BigDecimal minutosSobretiempo2;
	private BigDecimal horasSobretiempo2;
	private BigDecimal horasLiceConGoc;
	private BigDecimal horas;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getVeces() {
		return veces;
	}

	public void setVeces(Integer veces) {
		this.veces = veces;
	}

	public Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public BigDecimal getHorasSobretiempo1() {
		return horasSobretiempo1;
	}

	public void setHorasSobretiempo1(BigDecimal horasSobretiempo1) {
		this.horasSobretiempo1 = horasSobretiempo1;
	}

	public BigDecimal getMinutosSobretiempo1() {
		return minutosSobretiempo1;
	}

	public void setMinutosSobretiempo1(BigDecimal minutosSobretiempo1) {
		this.minutosSobretiempo1 = minutosSobretiempo1;
	}

	public BigDecimal getHorasSobretiempo2() {
		return horasSobretiempo2;
	}

	public void setHorasSobretiempo2(BigDecimal horasSobretiempo2) {
		this.horasSobretiempo2 = horasSobretiempo2;
	}

	public BigDecimal getMinutosSobretiempo2() {
		return minutosSobretiempo2;
	}

	public void setMinutosSobretiempo2(BigDecimal minutosSobretiempo2) {
		this.minutosSobretiempo2 = minutosSobretiempo2;
	}

	public BigDecimal getHorasSobretiempo() {
		return horasSobretiempo;
	}

	public void setHorasSobretiempo(BigDecimal horasSobretiempo) {
		this.horasSobretiempo = horasSobretiempo;
	}

	public BigDecimal getHorasLiceConGoc() {
		return horasLiceConGoc;
	}

	public void setHorasLiceConGoc(BigDecimal horasLiceConGoc) {
		this.horasLiceConGoc = horasLiceConGoc;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public BigDecimal getHoras() {
		return horas;
	}

	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}
	
}
