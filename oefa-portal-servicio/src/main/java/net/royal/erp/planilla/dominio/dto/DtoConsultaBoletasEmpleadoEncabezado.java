package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoConsultaBoletasEmpleadoEncabezado implements Serializable {

	private Date FECHAINGRESO;
	private String NOMBRECOMPLETO;
	private String PUESTO;
	private String TIPOPENSION;
	private String CODIGOAFP;
	private String NUMEROAFP;
	private String CENTROCOSTO;
	private String EXPEDIENTE;

	public String getFECHAINGRESO() {
		return new SimpleDateFormat("dd/MM/yyyy").format(FECHAINGRESO);
	}

	public void setFECHAINGRESO(Date fECHAINGRESO) {
		FECHAINGRESO = fECHAINGRESO;
	}

	public String getNOMBRECOMPLETO() {
		return NOMBRECOMPLETO;
	}

	public void setNOMBRECOMPLETO(String nOMBRECOMPLETO) {
		NOMBRECOMPLETO = nOMBRECOMPLETO;
	}

	public String getPUESTO() {
		return PUESTO;
	}

	public void setPUESTO(String pUESTO) {
		PUESTO = pUESTO;
	}

	public String getTIPOPENSION() {
		return TIPOPENSION;
	}

	public void setTIPOPENSION(String tIPOPENSION) {
		TIPOPENSION = tIPOPENSION;
	}

	public String getCODIGOAFP() {
		return CODIGOAFP;
	}

	public void setCODIGOAFP(String cODIGOAFP) {
		CODIGOAFP = cODIGOAFP;
	}

	public String getNUMEROAFP() {
		return NUMEROAFP;
	}

	public void setNUMEROAFP(String nUMEROAFP) {
		NUMEROAFP = nUMEROAFP;
	}

	public String getCENTROCOSTO() {
		return CENTROCOSTO;
	}

	public void setCENTROCOSTO(String cENTROCOSTO) {
		CENTROCOSTO = cENTROCOSTO;
	}

	public String getEXPEDIENTE() {
		return EXPEDIENTE;
	}

	public void setEXPEDIENTE(String eXPEDIENTE) {
		EXPEDIENTE = eXPEDIENTE;
	}

}
