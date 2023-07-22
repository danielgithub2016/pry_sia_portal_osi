package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoDetalleBoleta implements Serializable {

	private String CONCEPTO;
	private String TIPOCONCEPTO;
	private BigDecimal CANTIDAD;
	private BigDecimal MONTO;

	public String getCONCEPTO() {
		return CONCEPTO;
	}

	public void setCONCEPTO(String cONCEPTO) {
		CONCEPTO = cONCEPTO;
	}

	public String getTIPOCONCEPTO() {
		return TIPOCONCEPTO;
	}

	public void setTIPOCONCEPTO(String tIPOCONCEPTO) {
		TIPOCONCEPTO = tIPOCONCEPTO;
	}

	public BigDecimal getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(BigDecimal cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	public BigDecimal getMONTO() {
		return MONTO;
	}

	public void setMONTO(BigDecimal mONTO) {
		MONTO = mONTO;
	}

}
