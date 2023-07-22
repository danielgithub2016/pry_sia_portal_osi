package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoAcumuladoRet implements Serializable {

	private BigDecimal ACUMULADORETENCION;

	public BigDecimal getACUMULADORETENCION() {
		return ACUMULADORETENCION;
	}

	public void setACUMULADORETENCION(BigDecimal aCUMULADORETENCION) {
		ACUMULADORETENCION = aCUMULADORETENCION;
	}


}
