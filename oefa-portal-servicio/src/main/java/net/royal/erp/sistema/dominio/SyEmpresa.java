package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyEmpresa
*/
public class SyEmpresa extends DominioGenerico implements java.io.Serializable{

	private SyEmpresaPk pk;
	private String descripcion;
	private String pais;
	private String estado;


	public SyEmpresa() {
		pk = new SyEmpresaPk();
	}

	public SyEmpresaPk getPk() {
		return pk;
	}

	public void setPk(SyEmpresaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
