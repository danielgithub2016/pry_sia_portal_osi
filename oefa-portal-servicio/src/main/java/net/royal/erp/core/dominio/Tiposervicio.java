package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Tiposervicio
*/
public class Tiposervicio extends DominioGenerico implements java.io.Serializable{

	private TiposervicioPk pk;
	private String descripcion;
	private String regimenfiscal;
	private String clasificacionfiscal;
	private String estado;
	private String descripcioningles;


	public Tiposervicio() {
		pk = new TiposervicioPk();
	}

	public TiposervicioPk getPk() {
		return pk;
	}

	public void setPk(TiposervicioPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRegimenfiscal() {
		return regimenfiscal;
	}

	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}
	public String getClasificacionfiscal() {
		return clasificacionfiscal;
	}

	public void setClasificacionfiscal(String clasificacionfiscal) {
		this.clasificacionfiscal = clasificacionfiscal;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}

}
