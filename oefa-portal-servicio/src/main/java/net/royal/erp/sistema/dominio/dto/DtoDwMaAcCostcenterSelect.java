package net.royal.erp.sistema.dominio.dto;


/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_costcenter_select
 */
public class DtoDwMaAcCostcenterSelect implements java.io.Serializable {
	
	private String costcenter;
	private String localname;
	private String englishname;
	
	/**
	 * @return the costcenter
	 */
	public String getCostcenter() {
		return costcenter;
	}
	/**
	 * @param costcenter the costcenter to set
	 */
	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}
	/**
	 * @return the localname
	 */
	public String getLocalname() {
		return localname;
	}
	/**
	 * @param localname the localname to set
	 */
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	/**
	 * @return the englishname
	 */
	public String getEnglishname() {
		return englishname;
	}
	/**
	 * @param englishname the englishname to set
	 */
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	
}
