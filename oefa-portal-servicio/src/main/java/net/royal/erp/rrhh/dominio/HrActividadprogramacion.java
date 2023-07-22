package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadprogramacion
*/
public class HrActividadprogramacion extends DominioGenerico implements java.io.Serializable{

	private HrActividadprogramacionPk pk;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;


	public HrActividadprogramacion() {
		pk = new HrActividadprogramacionPk();
	}

	public HrActividadprogramacionPk getPk() {
		return pk;
	}

	public void setPk(HrActividadprogramacionPk pk) {
		this.pk = pk;
	}
	public java.util.Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(java.util.Date fechadesde) {
		this.fechadesde = fechadesde;
	}
	public java.util.Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(java.util.Date fechahasta) {
		this.fechahasta = fechahasta;
	}

}
