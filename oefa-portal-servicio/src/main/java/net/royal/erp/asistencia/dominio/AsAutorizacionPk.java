package net.royal.erp.asistencia.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class AsAutorizacionPk implements Serializable {

	private BigDecimal empleado;
	private Date fecha;
	private String conceptoacceso;
	private Date desde;

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConceptoacceso() {
		return conceptoacceso;
	}

	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

}
