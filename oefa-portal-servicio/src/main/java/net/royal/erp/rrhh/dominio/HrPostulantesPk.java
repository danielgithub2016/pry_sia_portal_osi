package net.royal.erp.rrhh.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPostulantes
*/
@SuppressWarnings("serial")
public class HrPostulantesPk implements java.io.Serializable{

	private String postulante;
	private String unidadreplicacion;

	public HrPostulantesPk(){}
	public HrPostulantesPk(String unidadreplicacion, String postulante){
		this.unidadreplicacion=unidadreplicacion;
		this.postulante=postulante;
	}
	
	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

}
