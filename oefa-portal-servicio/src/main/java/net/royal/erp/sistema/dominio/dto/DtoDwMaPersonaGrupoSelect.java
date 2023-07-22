package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_persona_grupo_select
 */
public class DtoDwMaPersonaGrupoSelect implements java.io.Serializable {
	private String personagrupo;
	private String descripcionlocal;
	private String descripcioningles;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String codigointerno;
	private String generarnumeracionflag;

	public String getPersonagrupo() {
		return personagrupo;
	}

	public void setPersonagrupo(String personagrupo) {
		this.personagrupo = personagrupo;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

	public String getGenerarnumeracionflag() {
		return generarnumeracionflag;
	}

	public void setGenerarnumeracionflag(String generarnumeracionflag) {
		this.generarnumeracionflag = generarnumeracionflag;
	}

}
