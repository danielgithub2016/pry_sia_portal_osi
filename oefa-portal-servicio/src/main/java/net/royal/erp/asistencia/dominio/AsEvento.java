package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEvento
 */
public class AsEvento extends DominioGenerico implements java.io.Serializable {

	private AsEventoPk pk;
	private String nombreCorto;
	private String nombreLargo;
	private String conceptoacceso;
	private String estado;
	private Integer orden;

	public AsEvento() {
		pk = new AsEventoPk();
	}

	public AsEventoPk getPk() {
		return pk;
	}

	public void setPk(AsEventoPk pk) {
		this.pk = pk;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getConceptoacceso() {
		return conceptoacceso;
	}

	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}
}
