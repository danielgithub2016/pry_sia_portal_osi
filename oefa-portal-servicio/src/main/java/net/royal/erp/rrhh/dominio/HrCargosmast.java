package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCargosmast
*/
public class HrCargosmast extends DominioGenerico implements java.io.Serializable{

	private HrCargosmastPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String estado;
	private Integer orden;
	private String ocupacionrtps;
	private String flagmarcaasistencia;


	public HrCargosmast() {
		pk = new HrCargosmastPk();
	}

	public HrCargosmastPk getPk() {
		return pk;
	}

	public void setPk(HrCargosmastPk pk) {
		this.pk = pk;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getOcupacionrtps() {
		return ocupacionrtps;
	}

	public void setOcupacionrtps(String ocupacionrtps) {
		this.ocupacionrtps = ocupacionrtps;
	}
	public String getFlagmarcaasistencia() {
		return flagmarcaasistencia;
	}

	public void setFlagmarcaasistencia(String flagmarcaasistencia) {
		this.flagmarcaasistencia = flagmarcaasistencia;
	}

}
