package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestoidi
*/
public class HrRequerimientopuestoidi extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestoidiPk pk;
	private String nivellectura;
	private String niveloral;
	private String nivelescritura;
	private String nivelgeneral;


	public HrRequerimientopuestoidi() {
		pk = new HrRequerimientopuestoidiPk();
	}

	public HrRequerimientopuestoidiPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestoidiPk pk) {
		this.pk = pk;
	}
	public String getNivellectura() {
		return nivellectura;
	}

	public void setNivellectura(String nivellectura) {
		this.nivellectura = nivellectura;
	}
	public String getNiveloral() {
		return niveloral;
	}

	public void setNiveloral(String niveloral) {
		this.niveloral = niveloral;
	}
	public String getNivelescritura() {
		return nivelescritura;
	}

	public void setNivelescritura(String nivelescritura) {
		this.nivelescritura = nivelescritura;
	}
	public String getNivelgeneral() {
		return nivelgeneral;
	}

	public void setNivelgeneral(String nivelgeneral) {
		this.nivelgeneral = nivelgeneral;
	}

}
