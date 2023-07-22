package net.royal.erp.sistema.dominio.dto;


/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ac_afe_select_position
 */
public class DtoDwAcAfeSelectPosition implements java.io.Serializable {
	
	private String afe;
	private String afetype;
	private String numerointerno;
	private String descripcion;
	private String codigodescripcionflag; 
	private String AfeType_all;
	private String numerointerno_all;



	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

	public String getAfetype() {
		return afetype;
	}

	public void setAfetype(String afetype) {
		this.afetype = afetype;
	}

	public String getNumerointerno() {
		return numerointerno;
	}

	public void setNumerointerno(String numerointerno) {
		this.numerointerno = numerointerno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigodescripcionflag() {
		return codigodescripcionflag;
	}

	public void setCodigodescripcionflag(String codigodescripcionflag) {
		if(codigodescripcionflag.equals("C")){
			descripcion="";
		}else{
			afe="";
		}
		this.codigodescripcionflag = codigodescripcionflag;
	}

	public String getAfeType_all() {
		return AfeType_all;
	}

	public void setAfeType_all(String afeType_all) {
		AfeType_all = afeType_all;
	}

	public String getNumerointerno_all() {
		return numerointerno_all;
	}

	public void setNumerointerno_all(String numerointerno_all) {
		this.numerointerno_all = numerointerno_all;
	}




}
