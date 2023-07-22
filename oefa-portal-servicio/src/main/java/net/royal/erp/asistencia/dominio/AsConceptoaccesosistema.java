package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsConceptoaccesosistema
 */
public class AsConceptoaccesosistema extends DominioGenerico implements
		java.io.Serializable {

	private AsConceptoaccesosistemaPk pk;
	private String descripcion;
	private String conceptoaccesodefault;
	private String requierejustificacion;
	private String estado;
	private String autojustificable;

	public AsConceptoaccesosistema() {
		pk = new AsConceptoaccesosistemaPk();
	}

	public AsConceptoaccesosistemaPk getPk() {
		return pk;
	}

	public void setPk(AsConceptoaccesosistemaPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getConceptoaccesodefault() {
		return conceptoaccesodefault;
	}

	public void setConceptoaccesodefault(String conceptoaccesodefault) {
		this.conceptoaccesodefault = conceptoaccesodefault;
	}

	public String getRequierejustificacion() {
		return requierejustificacion;
	}

	public void setRequierejustificacion(String requierejustificacion) {
		this.requierejustificacion = requierejustificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAutojustificable() {
		return autojustificable;
	}

	public void setAutojustificable(String autojustificable) {
		this.autojustificable = autojustificable;
	}

}
