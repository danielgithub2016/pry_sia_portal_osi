package net.royal.erp.asistencia.ascommon.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder ascommon.dw_as_evento_userid_activo
 */
public class DtoDwAsEventoUseridActivo implements java.io.Serializable {

	private BigDecimal idevento;
	private BigDecimal orden;
	private String estado;
	private String nombrelargo;
	private Boolean isseleccionado;
	private String conceptoacceso;
	private Integer indice;

	public DtoDwAsEventoUseridActivo() {
	}

	public DtoDwAsEventoUseridActivo(BigDecimal idevento, String estado,
			String nombrelargo, Boolean isseleccionado) {
		super();
		this.idevento = idevento;
		this.estado = estado;
		this.nombrelargo = nombrelargo;
		this.isseleccionado = isseleccionado;
	}

	/**
	 * @return the idevento
	 */
	public BigDecimal getIdevento() {
		return idevento;
	}

	/**
	 * @param idevento
	 *            the idevento to set
	 */
	public void setIdevento(BigDecimal idevento) {
		this.idevento = idevento;
	}

	/**
	 * @return the orden
	 */
	public BigDecimal getOrden() {
		return orden;
	}

	/**
	 * @param orden
	 *            the orden to set
	 */
	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the nombrelargo
	 */
	public String getNombrelargo() {
		return nombrelargo;
	}

	/**
	 * @param nombrelargo
	 *            the nombrelargo to set
	 */
	public void setNombrelargo(String nombrelargo) {
		this.nombrelargo = nombrelargo;
	}

	/**
	 * @return the isseleccionado
	 */
	public Boolean getIsseleccionado() {
		isseleccionado = obtenerBooleano(estado);
		return isseleccionado;
	}

	/**
	 * @param isseleccionado
	 *            the isseleccionado to set
	 */
	public void setIsseleccionado(Boolean isseleccionado) {
		this.isseleccionado = isseleccionado;
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
	 * @return the indice
	 */
	public Integer getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	private Boolean obtenerBooleano(String objeto) {
		if (UValidador.estaVacio(objeto)) {
			return false;
		}

		if (objeto.equals("S")) {
			return true;
		} else {
			return false;
		}
	}
}
