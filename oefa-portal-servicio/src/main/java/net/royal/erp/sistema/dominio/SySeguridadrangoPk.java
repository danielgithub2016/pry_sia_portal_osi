package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadrango
*/
public class SySeguridadrangoPk implements java.io.Serializable{

	private String modulo;
	private String ano;
	private String tiporegistro;

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTiporegistro() {
		return tiporegistro;
	}

	public void setTiporegistro(String tiporegistro) {
		this.tiporegistro = tiporegistro;
	}

}
