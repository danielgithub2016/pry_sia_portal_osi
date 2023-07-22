package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrTipotrabajador
*/
public class DtoHrTipotrabajador implements java.io.Serializable{

	private String tipotrabajador;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String tratamientocontableauxiliar;
	private String estado;
	private String codigoseguro;
	private String categoriartps;
	private String tipotrabajadorrtps;

	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
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
