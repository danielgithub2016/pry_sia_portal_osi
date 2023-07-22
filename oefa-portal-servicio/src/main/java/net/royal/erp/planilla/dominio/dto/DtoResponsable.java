package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoResponsable implements Serializable {

	private String NOMBRES;
	private String APELLIDOPATERNO;
	private String APELLIDOMATERNO;
	private String TIPODOCUMENTO;
	private String DOCUMENTO;
	private String PUESTO;

	public String getNOMBRES() {
		return NOMBRES;
	}

	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}

	public String getAPELLIDOPATERNO() {
		return APELLIDOPATERNO;
	}

	public void setAPELLIDOPATERNO(String aPELLIDOPATERNO) {
		APELLIDOPATERNO = aPELLIDOPATERNO;
	}

	public String getAPELLIDOMATERNO() {
		return APELLIDOMATERNO;
	}

	public void setAPELLIDOMATERNO(String aPELLIDOMATERNO) {
		APELLIDOMATERNO = aPELLIDOMATERNO;
	}

	public String getTIPODOCUMENTO() {
		return TIPODOCUMENTO;
	}

	public void setTIPODOCUMENTO(String tIPODOCUMENTO) {
		TIPODOCUMENTO = tIPODOCUMENTO;
	}

	public String getDOCUMENTO() {
		return DOCUMENTO;
	}

	public void setDOCUMENTO(String dOCUMENTO) {
		DOCUMENTO = dOCUMENTO;
	}

	public String getPUESTO() {
		return PUESTO;
	}

	public void setPUESTO(String pUESTO) {
		PUESTO = pUESTO;
	}

	public String getNOMBRESCOMPLETOS() {
		return NOMBRES + " " + APELLIDOPATERNO + " " + APELLIDOMATERNO;
	}

}
