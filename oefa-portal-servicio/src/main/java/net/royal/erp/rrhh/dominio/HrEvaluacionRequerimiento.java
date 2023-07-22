package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionperiodo
*/
public class HrEvaluacionRequerimiento extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacionRequerimientoPk pk;
	private String flagelemento;
	private String descripcion;
	private String otro;
	
	public HrEvaluacionRequerimiento() {
		pk = new HrEvaluacionRequerimientoPk();
	}

	public HrEvaluacionRequerimientoPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionRequerimientoPk pk) {
		this.pk = pk;
	}

	public String getFlagelemento() {
		return flagelemento;
	}

	public void setFlagelemento(String flagelemento) {
		this.flagelemento = flagelemento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}


}
