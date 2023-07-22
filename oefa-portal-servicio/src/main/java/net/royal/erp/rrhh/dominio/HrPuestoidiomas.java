package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoidiomas
 */
public class HrPuestoidiomas extends DominioGenerico implements
		java.io.Serializable {

	private HrPuestoidiomasPk pk;
	private String nivellectura;
	private String niveloral;
	private String nivelescritura;
	private String nivelgeneral;
	private String estado;

	private String auxIdioma;

	public HrPuestoidiomas() {
		pk = new HrPuestoidiomasPk();
	}

	public HrPuestoidiomasPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoidiomasPk pk) {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAuxIdioma() {
		return auxIdioma;
	}

	public void setAuxIdioma(String auxIdioma) {
		this.auxIdioma = auxIdioma;
	}

}
