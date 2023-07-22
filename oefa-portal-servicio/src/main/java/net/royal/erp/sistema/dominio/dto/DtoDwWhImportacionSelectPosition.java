package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_importacion_select_position
 */
public class DtoDwWhImportacionSelectPosition implements java.io.Serializable {

	private String comentario;
	private String monto;
	
	public String getComentario() {
		return comentario;
	}
	public String getMonto() {
		return monto;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	
}
