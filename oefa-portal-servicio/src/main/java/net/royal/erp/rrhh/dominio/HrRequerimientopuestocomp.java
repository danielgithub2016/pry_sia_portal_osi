package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestocomp
*/
public class HrRequerimientopuestocomp extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestocompPk pk;
	private Integer secuencia;
	private String descripcion1;
	private java.math.BigDecimal descripcion2;
	private java.math.BigDecimal descripcion3;
	private String tipocompetencia;


	public HrRequerimientopuestocomp() {
		pk = new HrRequerimientopuestocompPk();
	}

	public HrRequerimientopuestocompPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestocompPk pk) {
		this.pk = pk;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getDescripcion1() {
		return descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}
	public java.math.BigDecimal getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(java.math.BigDecimal descripcion2) {
		this.descripcion2 = descripcion2;
	}
	public java.math.BigDecimal getDescripcion3() {
		return descripcion3;
	}

	public void setDescripcion3(java.math.BigDecimal descripcion3) {
		this.descripcion3 = descripcion3;
	}
	public String getTipocompetencia() {
		return tipocompetencia;
	}

	public void setTipocompetencia(String tipocompetencia) {
		this.tipocompetencia = tipocompetencia;
	}

}
