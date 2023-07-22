package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoinformatica
*/
public class HrPuestoinformatica extends DominioGenerico implements java.io.Serializable{

	private HrPuestoinformaticaPk pk;
	private String nivel;
	private String gradocuantitativo;
	private Integer puntosgrado;
	private Integer porcentajegrado;

	private String auxInformatica;
	private String auxNivel;
	
	public HrPuestoinformatica() {
		pk = new HrPuestoinformaticaPk();
	}

	public HrPuestoinformaticaPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoinformaticaPk pk) {
		this.pk = pk;
	}
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getGradocuantitativo() {
		return gradocuantitativo;
	}

	public void setGradocuantitativo(String gradocuantitativo) {
		this.gradocuantitativo = gradocuantitativo;
	}
	public Integer getPuntosgrado() {
		return puntosgrado;
	}

	public void setPuntosgrado(Integer puntosgrado) {
		this.puntosgrado = puntosgrado;
	}
	public Integer getPorcentajegrado() {
		return porcentajegrado;
	}

	public void setPorcentajegrado(Integer porcentajegrado) {
		this.porcentajegrado = porcentajegrado;
	}

	public String getAuxInformatica() {
		return auxInformatica;
	}

	public void setAuxInformatica(String auxInformatica) {
		this.auxInformatica = auxInformatica;
	}

	public String getAuxNivel() {
		return auxNivel;
	}

	public void setAuxNivel(String auxNivel) {
		this.auxNivel = auxNivel;
	}

}
