package net.royal.erp.asistencia.dominio;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsConceptoacceso
 */
public class AsConceptoaccesoPk implements java.io.Serializable {

	private String conceptoacceso;

	public AsConceptoaccesoPk() {
	}

	public AsConceptoaccesoPk(String conceptoacceso) {
		super();
		this.conceptoacceso = conceptoacceso;
	}

	public String getConceptoacceso() {
		return conceptoacceso;
	}

	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

}
