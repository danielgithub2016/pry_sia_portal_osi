package net.royal.erp.asistencia.asmain.dominio.dto;

/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_ma_pr_calendarioferiados_proceso_sarg
 */
public class DtoDwMaPrCalendarioferiadosProcesoSarg implements
		java.io.Serializable {

	private String fechamesdia;
	private String feriadocompletoflag;
	private String estado;
	private String descripcion;
	
	/**
	 * @return the fechamesdia
	 */
	public String getFechamesdia() {
		return fechamesdia;
	}
	/**
	 * @param fechamesdia the fechamesdia to set
	 */
	public void setFechamesdia(String fechamesdia) {
		this.fechamesdia = fechamesdia;
	}
	/**
	 * @return the feriadocompletoflag
	 */
	public String getFeriadocompletoflag() {
		return feriadocompletoflag;
	}
	/**
	 * @param feriadocompletoflag the feriadocompletoflag to set
	 */
	public void setFeriadocompletoflag(String feriadocompletoflag) {
		this.feriadocompletoflag = feriadocompletoflag;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
