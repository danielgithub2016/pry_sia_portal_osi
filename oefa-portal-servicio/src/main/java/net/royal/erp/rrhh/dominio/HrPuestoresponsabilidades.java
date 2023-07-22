package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoresponsabilidades
*/
public class HrPuestoresponsabilidades extends DominioGenerico implements java.io.Serializable{

	private HrPuestoresponsabilidadesPk pk;
	private String comentario;
	private String estado;


	public HrPuestoresponsabilidades() {
		pk = new HrPuestoresponsabilidadesPk();
	}

	public HrPuestoresponsabilidadesPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoresponsabilidadesPk pk) {
		this.pk = pk;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
