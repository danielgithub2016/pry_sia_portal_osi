package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrTipotrabajador
*/
public class HrTipotrabajador extends DominioGenerico implements java.io.Serializable{

	private HrTipotrabajadorPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String tratamientocontableauxiliar;
	private String estado;
	private String codigoseguro;
	private String categoriartps;
	private String tipotrabajadorrtps;


	public HrTipotrabajador() {
		pk = new HrTipotrabajadorPk();
	}

	public HrTipotrabajadorPk getPk() {
		return pk;
	}

	public void setPk(HrTipotrabajadorPk pk) {
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
	public String getTratamientocontableauxiliar() {
		return tratamientocontableauxiliar;
	}

	public void setTratamientocontableauxiliar(String tratamientocontableauxiliar) {
		this.tratamientocontableauxiliar = tratamientocontableauxiliar;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoseguro() {
		return codigoseguro;
	}

	public void setCodigoseguro(String codigoseguro) {
		this.codigoseguro = codigoseguro;
	}
	public String getCategoriartps() {
		return categoriartps;
	}

	public void setCategoriartps(String categoriartps) {
		this.categoriartps = categoriartps;
	}
	public String getTipotrabajadorrtps() {
		return tipotrabajadorrtps;
	}

	public void setTipotrabajadorrtps(String tipotrabajadorrtps) {
		this.tipotrabajadorrtps = tipotrabajadorrtps;
	}

}
