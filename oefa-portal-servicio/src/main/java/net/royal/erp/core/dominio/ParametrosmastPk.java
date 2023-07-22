package net.royal.erp.core.dominio;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Parametrosmast
 */
public class ParametrosmastPk implements java.io.Serializable {

	private String companiacodigo;
	private String aplicacioncodigo;
	private String parametroclave;

	public ParametrosmastPk() {
	}

	public ParametrosmastPk(String aplicacioncodigo,String companiacodigo,
			String parametroclave) {
		this.aplicacioncodigo=aplicacioncodigo;
		this.companiacodigo=companiacodigo;
		this.parametroclave=parametroclave;
	}

	public String getCompaniacodigo() {
		return companiacodigo;
	}

	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}

	public String getParametroclave() {
		return parametroclave;
	}

	public void setParametroclave(String parametroclave) {
		this.parametroclave = parametroclave;
	}

}
