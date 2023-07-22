package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.math.BigDecimal;

/**
*
* @author zegarrac
* @powerbuilder hrothers.dw_hr_documentossolicitados_position_fot
*/
public class DtoDwHrDocumentosSolicitadosPositionFot implements java.io.Serializable{
	private String empleado;
	private String empleadootro;
	private String compania;
	private String puesto;
	private String centrocostos;
	private String foto;
	

	public String getCompania() {
		return compania;
	}
	public String getCentrocostos() {
		return centrocostos;
	}
	public String getFoto() {
		return foto;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getEmpleadootro() {
		return empleadootro;
	}
	public void setEmpleadootro(String empleadootro) {
		this.empleadootro = empleadootro;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	
}
