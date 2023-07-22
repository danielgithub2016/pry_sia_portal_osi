package net.royal.seguridad.dominio;

import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

public class AcSucursal extends DominioGenerico implements java.io.Serializable {

	private AcSucursalPk pk;
	private String descripcionlocal;
	private String descripcioningles;
	private String sucursalgrupo;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String cuentacontabledefecto;
	private String departamento;
	
	public AcSucursal(){
		pk = new AcSucursalPk();
	}
	
	public AcSucursalPk getPk() {
		return pk;
	}
	public void setPk(AcSucursalPk pk) {
		this.pk = pk;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}