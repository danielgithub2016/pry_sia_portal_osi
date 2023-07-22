package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuComponentemeta
*/
public class BuComponentemeta extends DominioGenerico implements java.io.Serializable{

	private BuComponentemetaPk pk;
	private Integer importemeta;
	private String unidadmedida;
	private Integer finalidad;
	private String ubigeo;
	private Integer mes01;
	private Integer mes02;
	private Integer mes03;
	private Integer mes04;
	private Integer mes05;
	private Integer mes06;
	private Integer mes07;
	private Integer mes08;
	private Integer mes09;
	private Integer mes10;
	private Integer mes11;
	private Integer mes12;
	private String estado;
	private String descripcion;


	public BuComponentemeta() {
		pk = new BuComponentemetaPk();
	}

	public BuComponentemetaPk getPk() {
		return pk;
	}

	public void setPk(BuComponentemetaPk pk) {
		this.pk = pk;
	}
	public Integer getImportemeta() {
		return importemeta;
	}

	public void setImportemeta(Integer importemeta) {
		this.importemeta = importemeta;
	}
	public String getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}
	public Integer getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(Integer finalidad) {
		this.finalidad = finalidad;
	}
	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public Integer getMes01() {
		return mes01;
	}

	public void setMes01(Integer mes01) {
		this.mes01 = mes01;
	}
	public Integer getMes02() {
		return mes02;
	}

	public void setMes02(Integer mes02) {
		this.mes02 = mes02;
	}
	public Integer getMes03() {
		return mes03;
	}

	public void setMes03(Integer mes03) {
		this.mes03 = mes03;
	}
	public Integer getMes04() {
		return mes04;
	}

	public void setMes04(Integer mes04) {
		this.mes04 = mes04;
	}
	public Integer getMes05() {
		return mes05;
	}

	public void setMes05(Integer mes05) {
		this.mes05 = mes05;
	}
	public Integer getMes06() {
		return mes06;
	}

	public void setMes06(Integer mes06) {
		this.mes06 = mes06;
	}
	public Integer getMes07() {
		return mes07;
	}

	public void setMes07(Integer mes07) {
		this.mes07 = mes07;
	}
	public Integer getMes08() {
		return mes08;
	}

	public void setMes08(Integer mes08) {
		this.mes08 = mes08;
	}
	public Integer getMes09() {
		return mes09;
	}

	public void setMes09(Integer mes09) {
		this.mes09 = mes09;
	}
	public Integer getMes10() {
		return mes10;
	}

	public void setMes10(Integer mes10) {
		this.mes10 = mes10;
	}
	public Integer getMes11() {
		return mes11;
	}

	public void setMes11(Integer mes11) {
		this.mes11 = mes11;
	}
	public Integer getMes12() {
		return mes12;
	}

	public void setMes12(Integer mes12) {
		this.mes12 = mes12;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
