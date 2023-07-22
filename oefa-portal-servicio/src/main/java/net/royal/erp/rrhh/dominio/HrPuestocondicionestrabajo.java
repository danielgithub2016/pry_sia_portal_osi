package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestocondicionestrabajo
*/
public class HrPuestocondicionestrabajo extends DominioGenerico implements java.io.Serializable{

	private HrPuestocondicionestrabajoPk pk;
	private String tipocondicion;
	private Integer porcentaje;
	private String estado;
	private String auxDescripcionlocal;


	public HrPuestocondicionestrabajo() {
		pk = new HrPuestocondicionestrabajoPk();
	}

	public HrPuestocondicionestrabajoPk getPk() {
		return pk;
	}

	public void setPk(HrPuestocondicionestrabajoPk pk) {
		this.pk = pk;
	}
	public String getTipocondicion() {
		return tipocondicion;
	}

	public void setTipocondicion(String tipocondicion) {
		this.tipocondicion = tipocondicion;
	}
	public Integer getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAuxDescripcionlocal() {
		return auxDescripcionlocal;
	}

	public void setAuxDescripcionlocal(String auxDescripcionlocal) {
		this.auxDescripcionlocal = auxDescripcionlocal;
	}

}
