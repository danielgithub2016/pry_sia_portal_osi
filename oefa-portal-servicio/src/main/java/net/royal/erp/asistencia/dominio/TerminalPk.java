package net.royal.erp.asistencia.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class TerminalPk implements Serializable {
	private BigDecimal idterminal;

	public BigDecimal getIdterminal() {
		return idterminal;
	}

	public void setIdterminal(BigDecimal idterminal) {
		this.idterminal = idterminal;
	}

}
