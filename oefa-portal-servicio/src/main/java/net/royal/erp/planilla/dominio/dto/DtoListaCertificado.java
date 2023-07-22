package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoListaCertificado implements Serializable {

	private String COMPANIASOCIO;
	private BigDecimal EMPLEADO;
	private String NOMBRECOMPLETO;
	private String ESTADOEMPLEADO;
	private Date FECHACESE;

	public String getCOMPANIASOCIO() {
		return COMPANIASOCIO;
	}

	public void setCOMPANIASOCIO(String cOMPANIASOCIO) {
		COMPANIASOCIO = cOMPANIASOCIO;
	}

	public BigDecimal getEMPLEADO() {
		return EMPLEADO;
	}

	public void setEMPLEADO(BigDecimal eMPLEADO) {
		EMPLEADO = eMPLEADO;
	}

	public String getNOMBRECOMPLETO() {
		return NOMBRECOMPLETO;
	}

	public void setNOMBRECOMPLETO(String nOMBRECOMPLETO) {
		NOMBRECOMPLETO = nOMBRECOMPLETO;
	}

	public String getESTADOEMPLEADO() {
		return ESTADOEMPLEADO;
	}

	public void setESTADOEMPLEADO(String eSTADOEMPLEADO) {
		ESTADOEMPLEADO = eSTADOEMPLEADO;
	}

	public Date getFECHACESE() {
		return FECHACESE;
	}

	public void setFECHACESE(Date fECHACESE) {
		FECHACESE = fECHACESE;
	}

}
