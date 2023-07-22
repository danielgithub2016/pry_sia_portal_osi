package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Correlativosmast
*/
public class CorrelativosmastPk implements java.io.Serializable{

	private String companiacodigo;
	private String tipocomprobante;
	private String serie;
	
	public CorrelativosmastPk(){}
	
	public CorrelativosmastPk(String companiacodigo,String tipocomprobante, String serie){
		this.companiacodigo=companiacodigo;
		this.tipocomprobante=tipocomprobante;
		this.serie=serie;
	}

	public String getCompaniacodigo() {
		return companiacodigo;
	}

	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}
	public String getTipocomprobante() {
		return tipocomprobante;
	}

	public void setTipocomprobante(String tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

}
