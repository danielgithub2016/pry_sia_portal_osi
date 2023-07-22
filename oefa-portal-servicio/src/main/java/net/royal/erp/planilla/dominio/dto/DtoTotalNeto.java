package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoTotalNeto implements Serializable {

	private BigDecimal TOTALNETO;

	public BigDecimal getTOTALNETO() {
		return TOTALNETO;
	}

	public void setTOTALNETO(BigDecimal tOTALNETO) {
		TOTALNETO = tOTALNETO;
	}

}
