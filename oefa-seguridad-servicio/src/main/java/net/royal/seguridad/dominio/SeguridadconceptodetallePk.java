package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadconceptodetalle
*/
public class SeguridadconceptodetallePk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	private String conceptocodigo;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getConceptocodigo() {
		return conceptocodigo;
	}

	public void setConceptocodigo(String conceptocodigo) {
		this.conceptocodigo = conceptocodigo;
	}

}
