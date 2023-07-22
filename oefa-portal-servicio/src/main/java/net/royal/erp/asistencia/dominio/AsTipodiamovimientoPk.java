package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsTipodiamovimiento
 */
public class AsTipodiamovimientoPk implements java.io.Serializable {

	private Integer tipodia;
	private String intervaloacceso;
	private Integer secuencia;

	public Integer getTipodia() {
		return tipodia;
	}

	public void setTipodia(Integer tipodia) {
		this.tipodia = tipodia;
	}

	public String getIntervaloacceso() {
		return intervaloacceso;
	}

	public void setIntervaloacceso(String intervaloacceso) {
		this.intervaloacceso = intervaloacceso;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
