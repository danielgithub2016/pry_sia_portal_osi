package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoConsultaBoletasEmpleado implements Serializable {

	private String COMPANIASOCIO;
	private String PERIODO;
	private String TIPOPLANILLA;
	private String PLANILLA;
	private String TIPOPROCESO;
	private String PROCESO;
	private BigDecimal INGRESOS;
	private BigDecimal EGRESOS;
	private BigDecimal NETO;
	private BigDecimal PATRONALES;

	//
	@SuppressWarnings("unused")
	private String COMPOSITEKEY;

	public String getCOMPANIASOCIO() {
		return COMPANIASOCIO;
	}

	public void setCOMPANIASOCIO(String cOMPANIASOCIO) {
		COMPANIASOCIO = cOMPANIASOCIO;
	}

	public String getPERIODO() {
		return PERIODO;
	}

	public void setPERIODO(String pERIODO) {
		PERIODO = pERIODO;
	}

	public String getTIPOPLANILLA() {
		return TIPOPLANILLA;
	}

	public void setTIPOPLANILLA(String tIPOPLANILLA) {
		TIPOPLANILLA = tIPOPLANILLA;
	}

	public String getTIPOPROCESO() {
		return TIPOPROCESO;
	}

	public void setTIPOPROCESO(String tIPOPROCESO) {
		TIPOPROCESO = tIPOPROCESO;
	}

	public BigDecimal getINGRESOS() {
		return INGRESOS;
	}

	public void setINGRESOS(BigDecimal iNGRESOS) {
		if (iNGRESOS != null)
			INGRESOS = iNGRESOS;
		else
			INGRESOS = new BigDecimal(0);
	}

	public BigDecimal getEGRESOS() {
		return EGRESOS;
	}

	public void setEGRESOS(BigDecimal eGRESOS) {
		if (eGRESOS != null)
			EGRESOS = eGRESOS;
		else
			EGRESOS = new BigDecimal(0);
	}

	public BigDecimal getNETO() {
		return NETO;
	}

	public void setNETO(BigDecimal nETO) {
		if (nETO != null)
			NETO = nETO;
		else
			NETO = new BigDecimal(0);
	}

	public BigDecimal getPATRONALES() {
		return PATRONALES;
	}

	public void setPATRONALES(BigDecimal pATRONALES) {
		if (pATRONALES != null)
			PATRONALES = pATRONALES;
		else
			PATRONALES = new BigDecimal(0);
	}

	public String getCOMPOSITEKEY() {
		return PERIODO + TIPOPLANILLA + TIPOPROCESO;
	}

	public void setCOMPOSITEKEY(String cOMPOSITEKEY) {
		COMPOSITEKEY = cOMPOSITEKEY;
	}

	public String getPROCESO() {
		return PROCESO;
	}

	public void setPROCESO(String pROCESO) {
		PROCESO = pROCESO;
	}

	public String getPLANILLA() {
		return PLANILLA;
	}

	public void setPLANILLA(String pLANILLA) {
		PLANILLA = pLANILLA;
	}

}
