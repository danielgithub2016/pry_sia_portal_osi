package net.royal.erp.asistencia.asmain.dominio.dto;

import java.util.Date;


/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_autorizacion_preproceso_hextra_det
 */
public class DtoDwAsAutorizacionPreprocesoHextraDet implements
		java.io.Serializable {
	
	private Date fechadesde;
	private Date fechahasta;
	private String comentario;
	
	public DtoDwAsAutorizacionPreprocesoHextraDet(Date fechadesde,
			Date fechahasta, String comentario) {
		super();
		this.fechadesde = fechadesde;
		this.fechahasta = fechahasta;
		this.comentario = comentario;
	}
	/**
	 * @return the fechadesde
	 */
	public Date getFechadesde() {
		return fechadesde;
	}
	/**
	 * @param fechadesde the fechadesde to set
	 */
	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}
	/**
	 * @return the fechahasta
	 */
	public Date getFechahasta() {
		return fechahasta;
	}
	/**
	 * @param fechahasta the fechahasta to set
	 */
	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
