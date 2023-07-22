package net.royal.erp.asistencia.asmain.dominio.dto;

import java.util.Date;


/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_autorizacion_preproceso_ordenes
 */
public class DtoDwAsAutorizacionPreprocesoOrdenes implements
		java.io.Serializable {
	
	private String ordenNumero;
	private Integer empleado;
	private String conceptoacceso;
	private Date fecha;
	private Date desde;
	
	/**
	 * @return the ordenNumero
	 */
	public String getOrdenNumero() {
		return ordenNumero;
	}

	/**
	 * @param ordenNumero the ordenNumero to set
	 */
	public void setOrdenNumero(String ordenNumero) {
		this.ordenNumero = ordenNumero;
	}

	/**
	 * @return the empleado
	 */
	public Integer getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the conceptoacceso
	 */
	public String getConceptoacceso() {
		return conceptoacceso;
	}

	/**
	 * @param conceptoacceso the conceptoacceso to set
	 */
	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the desde
	 */
	public Date getDesde() {
		return desde;
	}

	/**
	 * @param desde the desde to set
	 */
	public void setDesde(Date desde) {
		this.desde = desde;
	}

}
