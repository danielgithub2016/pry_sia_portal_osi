package net.royal.erp.asistencia.asmast.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder asmast.dddw_as_tempus_terminal
 */
public class DtoDddwAsTempusTerminal implements java.io.Serializable {

	private BigDecimal idterminal;
	private String nombreterminal;

	/**
	 * @return the idterminal
	 */
	public BigDecimal getIdterminal() {
		return idterminal;
	}

	/**
	 * @param idterminal
	 *            the idterminal to set
	 */
	public void setIdterminal(BigDecimal idterminal) {
		this.idterminal = idterminal;
	}

	/**
	 * @return the nombreterminal
	 */
	public String getNombreterminal() {
		return nombreterminal;
	}

	/**
	 * @param nombreterminal
	 *            the nombreterminal to set
	 */
	public void setNombreterminal(String nombreterminal) {
		this.nombreterminal = nombreterminal;
	}

}
