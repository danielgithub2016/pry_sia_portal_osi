package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadunidadnegocio
*/
public class DtoSySeguridadunidadnegocio implements java.io.Serializable{

	private String tipomst;
	private String codigo;
	private String unidadnegocio;
	private String codigo01;
	private String codigo02;
	private String codigo03;

	public String getTipomst() {
		return tipomst;
	}

	public void setTipomst(String tipomst) {
		this.tipomst = tipomst;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getCodigo01() {
		return codigo01;
	}

	public void setCodigo01(String codigo01) {
		this.codigo01 = codigo01;
	}
	public String getCodigo02() {
		return codigo02;
	}

	public void setCodigo02(String codigo02) {
		this.codigo02 = codigo02;
	}
	public String getCodigo03() {
		return codigo03;
	}

	public void setCodigo03(String codigo03) {
		this.codigo03 = codigo03;
	}

}
