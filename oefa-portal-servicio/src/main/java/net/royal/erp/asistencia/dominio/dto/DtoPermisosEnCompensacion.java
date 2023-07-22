package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DtoPermisosEnCompensacion {
	private Date desde;
	private Date hasta;
	private Date desderecupera;
	private Date hastarecupera;
	private BigDecimal empleado;
	private BigDecimal horascompensadas;
	private BigDecimal diascompensa;



	public Date getDesderecupera() {
		return desderecupera;
	}

	public void setDesderecupera(Date desderecupera) {
		this.desderecupera = desderecupera;
	}

	public Date getHastarecupera() {
		return hastarecupera;
	}

	public void setHastarecupera(Date hastarecupera) {
		this.hastarecupera = hastarecupera;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getHorascompensadas() {
		if(horascompensadas==null){
			horascompensadas = BigDecimal.ZERO;
		}
		return horascompensadas;
	}

	public void setHorascompensadas(BigDecimal horascompensadas) {
		this.horascompensadas = horascompensadas;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public BigDecimal getDiascompensa() {
		return diascompensa;
	}

	public void setDiascompensa(BigDecimal diascompensa) {
		this.diascompensa = diascompensa;
	}

}
