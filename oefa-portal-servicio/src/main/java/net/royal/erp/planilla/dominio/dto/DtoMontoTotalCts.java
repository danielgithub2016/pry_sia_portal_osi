package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoMontoTotalCts implements Serializable {

	private BigDecimal MONTOTOTAL;

	public BigDecimal getMONTOTOTAL() {
		return MONTOTOTAL;
	}

	public void setMONTOTOTAL(BigDecimal mONTOTOTAL) {
		MONTOTOTAL = mONTOTOTAL;
	}




}
