package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuEjercicio
*/
public class BuEjercicioPk implements java.io.Serializable{

	private String ano;
	private String ejercicio;
	private String tipopresupuesto;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getTipopresupuesto() {
		return tipopresupuesto;
	}

	public void setTipopresupuesto(String tipopresupuesto) {
		this.tipopresupuesto = tipopresupuesto;
	}

}
