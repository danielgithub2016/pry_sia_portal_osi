package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoRemuneracionCts implements Serializable {

	private BigDecimal REMUNERACION;

	public BigDecimal getREMUNERACION() {
		return REMUNERACION;
	}

	public void setREMUNERACION(BigDecimal rEMUNERACION) {
		REMUNERACION = rEMUNERACION;
	}


}
