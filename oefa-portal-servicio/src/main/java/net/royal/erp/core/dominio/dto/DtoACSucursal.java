package net.royal.erp.core.dominio.dto;

import java.util.Date;

public class DtoACSucursal {
	private String sucursal;
	private String descripcionlocal;
	private String descripcioningles;
	private String sucursalgrupo;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String cuentacontabledefecto;
	

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}

	public String getSucursalgrupo() {
		return sucursalgrupo;
	}

	public void setSucursalgrupo(String sucursalgrupo) {
		this.sucursalgrupo = sucursalgrupo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getCuentacontabledefecto() {
		return cuentacontabledefecto;
	}

	public void setCuentacontabledefecto(String cuentacontabledefecto) {
		this.cuentacontabledefecto = cuentacontabledefecto;
	}

}
