package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuNivelserviciomst
*/
public class BuNivelserviciomst extends DominioGenerico implements java.io.Serializable{

	private BuNivelserviciomstPk pk;
	private String tipobasedatos;
	private String descripcion;
	private String estado;
	private String terminal;
	private String tiposervicio;


	public BuNivelserviciomst() {
		pk = new BuNivelserviciomstPk();
	}

	public BuNivelserviciomstPk getPk() {
		return pk;
	}

	public void setPk(BuNivelserviciomstPk pk) {
		this.pk = pk;
	}
	public String getTipobasedatos() {
		return tipobasedatos;
	}

	public void setTipobasedatos(String tipobasedatos) {
		this.tipobasedatos = tipobasedatos;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

}
