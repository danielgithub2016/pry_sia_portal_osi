package net.royal.erp.sistema.dominio.dto;


/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_costcenter_select_position
 */
public class DtoDwMaAcCostcenterSelectPosition implements java.io.Serializable {

	private String costcenter;
	private String descripcion;
	private String codigodescripcionflag;

	// Variables que no estan en el query pero seran usadas para ser
	// reemplazados por checkbox
	private Boolean buscarflagBoolean;

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
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
		this.codigodescripcionflag = codigodescripcionflag;
	}

	public Boolean getBuscarflagBoolean() {
		return buscarflagBoolean;
	}

	public void setBuscarflagBoolean(Boolean buscarflagBoolean) {
		this.buscarflagBoolean = buscarflagBoolean;
	}

}
