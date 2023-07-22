package net.royal.erp.sistema.dominio.dto;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_sucursal_select_position
 */
public class DtoDwMaAcSucursalSelectPosition implements java.io.Serializable {

	private String descripcion;
	private String codigodescripcionflag;
	private String sucursal;

	private Integer estCodigo = 1;
	private Integer estDes = 1;

	private boolean boolCodigo = true;
	private boolean boolDes;
	
	private String tipo;

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

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getEstCodigo() {
		return estCodigo;
	}

	public void setEstCodigo(Integer estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Integer getEstDes() {
		return estDes;
	}

	public void setEstDes(Integer estDes) {
		this.estDes = estDes;
	}

	public boolean isBoolCodigo() {

		return boolCodigo;
	}

	public void setBoolCodigo(boolean boolCodigo) {
		if(boolCodigo){
			setBoolDes(!boolCodigo);
		}
		this.boolCodigo = boolCodigo;
	}

	public boolean isBoolDes() {
		return boolDes;
	}

	public void setBoolDes(boolean boolDes) {
		if(boolDes){
			setBoolCodigo(!boolDes);
		}
		this.boolDes = boolDes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
