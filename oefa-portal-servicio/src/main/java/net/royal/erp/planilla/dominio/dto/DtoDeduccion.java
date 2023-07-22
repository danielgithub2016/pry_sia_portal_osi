package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoDeduccion implements Serializable {

	private BigDecimal DEDUCCION;

	public BigDecimal getDEDUCCION() {
		return DEDUCCION;
	}

	public void setDEDUCCION(BigDecimal dEDUCCION) {
		DEDUCCION = dEDUCCION;
	}

}
