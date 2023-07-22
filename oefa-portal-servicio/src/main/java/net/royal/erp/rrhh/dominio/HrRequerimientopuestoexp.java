package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestoexp
*/
public class HrRequerimientopuestoexp extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestoexpPk pk;
	private Integer secuencia;
	private String descripcion1;
	private String descripcion2;
	private String descripcion3;
	private Integer descripcion4;


	public HrRequerimientopuestoexp() {
		pk = new HrRequerimientopuestoexpPk();
	}

	public HrRequerimientopuestoexpPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestoexpPk pk) {
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
	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}
	public String getDescripcion3() {
		return descripcion3;
	}

	public void setDescripcion3(String descripcion3) {
		this.descripcion3 = descripcion3;
	}
	public Integer getDescripcion4() {
		return descripcion4;
	}

	public void setDescripcion4(Integer descripcion4) {
		this.descripcion4 = descripcion4;
	}

}
