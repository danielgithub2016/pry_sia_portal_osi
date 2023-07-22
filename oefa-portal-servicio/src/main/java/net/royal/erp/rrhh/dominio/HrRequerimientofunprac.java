package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientofunprac
 */
public class HrRequerimientofunprac extends DominioGenerico implements
		java.io.Serializable {

	private HrRequerimientofunpracPk pk;
	private String flagformacion;
	private String flagnivelacademico;
	private Integer ciclo;
	private String profesion;
	private String conocimientos;
	private String flagword;
	private String flagnivelword;
	private String flagexcel;
	private String flagnivelexcel;
	private String flagpowerpoint;
	private String flagnivelpowerpoint;
	private String flagotro;
	private String otroinformatica;
	private String flagnivelotroinformatica;
	private String flagindispensableidioma;
	private String flagnivelindispensableidioma;
	private String flagingles;
	private String flagnivelingles;
	private String flagotroidioma;
	private String otroidioma;
	private String flagnivelotroidioma;
	private String flagexperiencia;
	private String tiempoexperiencia;
	private String detalle;

	private Boolean auxiliarisflagword;
	private Boolean auxiliarisflagexcel;
	private Boolean auxiliarisflagpowerpoint;
	private Boolean auxiliarisflagotro;
	private Boolean auxiliarisflagindispensableidioma;
	private Boolean auxiliarisflagingles;
	private Boolean auxiliarisflagotroidioma;
	private Boolean auxiliarisflagexperiencia;

	public HrRequerimientofunprac() {
		pk = new HrRequerimientofunpracPk();
	}

	public HrRequerimientofunpracPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientofunpracPk pk) {
		this.pk = pk;
	}

	/**
	 * @return the flagformacion
	 */
	public String getFlagformacion() {
		return flagformacion;
	}

	/**
	 * @param flagformacion
	 *            the flagformacion to set
	 */
	public void setFlagformacion(String flagformacion) {
		this.flagformacion = flagformacion;
	}

	/**
	 * @return the flagnivelacademico
	 */
	public String getFlagnivelacademico() {
		return flagnivelacademico;
	}

	/**
	 * @param flagnivelacademico
	 *            the flagnivelacademico to set
	 */
	public void setFlagnivelacademico(String flagnivelacademico) {
		this.flagnivelacademico = flagnivelacademico;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo
	 *            the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the profesion
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion
	 *            the profesion to set
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	/**
	 * @return the conocimientos
	 */
	public String getConocimientos() {
		return conocimientos;
	}

	/**
	 * @param conocimientos
	 *            the conocimientos to set
	 */
	public void setConocimientos(String conocimientos) {
		this.conocimientos = conocimientos;
	}

	/**
	 * @return the flagword
	 */
	public String getFlagword() {
		if (UValidador.estaVacio(flagword)) {
			flagword = "N";
		}
		return flagword;
	}

	/**
	 * @param flagword
	 *            the flagword to set
	 */
	public void setFlagword(String flagword) {
		this.flagword = flagword;
	}

	/**
	 * @return the flagnivelword
	 */
	public String getFlagnivelword() {
		return flagnivelword;
	}

	/**
	 * @param flagnivelword
	 *            the flagnivelword to set
	 */
	public void setFlagnivelword(String flagnivelword) {
		this.flagnivelword = flagnivelword;
	}

	/**
	 * @return the flagexcel
	 */
	public String getFlagexcel() {
		if (UValidador.estaVacio(flagexcel)) {
			flagexcel = "N";
		}
		return flagexcel;
	}

	/**
	 * @param flagexcel
	 *            the flagexcel to set
	 */
	public void setFlagexcel(String flagexcel) {
		this.flagexcel = flagexcel;
	}

	/**
	 * @return the flagnivelexcel
	 */
	public String getFlagnivelexcel() {
		return flagnivelexcel;
	}

	/**
	 * @param flagnivelexcel
	 *            the flagnivelexcel to set
	 */
	public void setFlagnivelexcel(String flagnivelexcel) {
		this.flagnivelexcel = flagnivelexcel;
	}

	/**
	 * @return the flagpowerpoint
	 */
	public String getFlagpowerpoint() {
		if (UValidador.estaVacio(flagpowerpoint)) {
			flagpowerpoint = "N";
		}
		return flagpowerpoint;
	}

	/**
	 * @param flagpowerpoint
	 *            the flagpowerpoint to set
	 */
	public void setFlagpowerpoint(String flagpowerpoint) {
		this.flagpowerpoint = flagpowerpoint;
	}

	/**
	 * @return the flagnivelpowerpoint
	 */
	public String getFlagnivelpowerpoint() {
		return flagnivelpowerpoint;
	}

	/**
	 * @param flagnivelpowerpoint
	 *            the flagnivelpowerpoint to set
	 */
	public void setFlagnivelpowerpoint(String flagnivelpowerpoint) {
		this.flagnivelpowerpoint = flagnivelpowerpoint;
	}

	/**
	 * @return the flagotro
	 */
	public String getFlagotro() {
		if (UValidador.estaVacio(flagotro)) {
			flagotro = "N";
		}
		return flagotro;
	}

	/**
	 * @param flagotro
	 *            the flagotro to set
	 */
	public void setFlagotro(String flagotro) {
		this.flagotro = flagotro;
	}

	/**
	 * @return the otroinformatica
	 */
	public String getOtroinformatica() {
		return otroinformatica;
	}

	/**
	 * @param otroinformatica
	 *            the otroinformatica to set
	 */
	public void setOtroinformatica(String otroinformatica) {
		this.otroinformatica = otroinformatica;
	}

	/**
	 * @return the flagnivelotroinformatica
	 */
	public String getFlagnivelotroinformatica() {
		return flagnivelotroinformatica;
	}

	/**
	 * @param flagnivelotroinformatica
	 *            the flagnivelotroinformatica to set
	 */
	public void setFlagnivelotroinformatica(String flagnivelotroinformatica) {
		this.flagnivelotroinformatica = flagnivelotroinformatica;
	}

	/**
	 * @return the flagindispensableidioma
	 */
	public String getFlagindispensableidioma() {
		if (UValidador.estaVacio(flagindispensableidioma)) {
			flagindispensableidioma = "N";
		}
		return flagindispensableidioma;
	}

	/**
	 * @param flagindispensableidioma
	 *            the flagindispensableidioma to set
	 */
	public void setFlagindispensableidioma(String flagindispensableidioma) {
		this.flagindispensableidioma = flagindispensableidioma;
	}

	/**
	 * @return the flagnivelindispensableidioma
	 */
	public String getFlagnivelindispensableidioma() {
		return flagnivelindispensableidioma;
	}

	/**
	 * @param flagnivelindispensableidioma
	 *            the flagnivelindispensableidioma to set
	 */
	public void setFlagnivelindispensableidioma(
			String flagnivelindispensableidioma) {
		this.flagnivelindispensableidioma = flagnivelindispensableidioma;
	}

	/**
	 * @return the flagingles
	 */
	public String getFlagingles() {
		if (UValidador.esNulo(flagingles)) {
			flagingles = "N";
		}
		return flagingles;
	}

	/**
	 * @param flagingles
	 *            the flagingles to set
	 */
	public void setFlagingles(String flagingles) {
		this.flagingles = flagingles;
	}

	/**
	 * @return the flagnivelingles
	 */
	public String getFlagnivelingles() {
		return flagnivelingles;
	}

	/**
	 * @param flagnivelingles
	 *            the flagnivelingles to set
	 */
	public void setFlagnivelingles(String flagnivelingles) {
		this.flagnivelingles = flagnivelingles;
	}

	/**
	 * @return the flagotroidioma
	 */
	public String getFlagotroidioma() {
		if (UValidador.estaVacio(flagotroidioma)) {
			flagotroidioma = "N";
		}
		return flagotroidioma;
	}

	/**
	 * @param flagotroidioma
	 *            the flagotroidioma to set
	 */
	public void setFlagotroidioma(String flagotroidioma) {
		this.flagotroidioma = flagotroidioma;
	}

	/**
	 * @return the otroidioma
	 */
	public String getOtroidioma() {
		return otroidioma;
	}

	/**
	 * @param otroidioma
	 *            the otroidioma to set
	 */
	public void setOtroidioma(String otroidioma) {
		this.otroidioma = otroidioma;
	}

	/**
	 * @return the flagnivelotroidioma
	 */
	public String getFlagnivelotroidioma() {
		return flagnivelotroidioma;
	}

	/**
	 * @param flagnivelotroidioma
	 *            the flagnivelotroidioma to set
	 */
	public void setFlagnivelotroidioma(String flagnivelotroidioma) {
		this.flagnivelotroidioma = flagnivelotroidioma;
	}

	/**
	 * @return the flagexperiencia
	 */
	public String getFlagexperiencia() {
		if (UValidador.esNulo(flagexperiencia)) {
			flagexperiencia = "N";
		}
		return flagexperiencia;
	}

	/**
	 * @param flagexperiencia
	 *            the flagexperiencia to set
	 */
	public void setFlagexperiencia(String flagexperiencia) {
		this.flagexperiencia = flagexperiencia;
	}

	/**
	 * @return the tiempoexperiencia
	 */
	public String getTiempoexperiencia() {
		return tiempoexperiencia;
	}

	/**
	 * @param tiempoexperiencia
	 *            the tiempoexperiencia to set
	 */
	public void setTiempoexperiencia(String tiempoexperiencia) {
		this.tiempoexperiencia = tiempoexperiencia;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the auxiliarisflagword
	 */
	public Boolean getAuxiliarisflagword() {
		if (UValidador.estaVacio(auxiliarisflagword)) {
			auxiliarisflagword = false;
		}
		return auxiliarisflagword;
	}

	/**
	 * @param auxiliarisflagword
	 *            the auxiliarisflagword to set
	 */
	public void setAuxiliarisflagword(Boolean auxiliarisflagword) {
		this.auxiliarisflagword = auxiliarisflagword;
	}

	/**
	 * @return the auxiliarisflagexcel
	 */
	public Boolean getAuxiliarisflagexcel() {
		if (UValidador.estaVacio(auxiliarisflagexcel)) {
			auxiliarisflagexcel = false;
		}
		return auxiliarisflagexcel;
	}

	/**
	 * @param auxiliarisflagexcel
	 *            the auxiliarisflagexcel to set
	 */
	public void setAuxiliarisflagexcel(Boolean auxiliarisflagexcel) {
		this.auxiliarisflagexcel = auxiliarisflagexcel;
	}

	/**
	 * @return the auxiliarisflagpowerpoint
	 */
	public Boolean getAuxiliarisflagpowerpoint() {
		if (UValidador.estaVacio(auxiliarisflagpowerpoint)) {
			auxiliarisflagpowerpoint = false;
		}
		return auxiliarisflagpowerpoint;
	}

	/**
	 * @param auxiliarisflagpowerpoint
	 *            the auxiliarisflagpowerpoint to set
	 */
	public void setAuxiliarisflagpowerpoint(Boolean auxiliarisflagpowerpoint) {
		this.auxiliarisflagpowerpoint = auxiliarisflagpowerpoint;
	}

	/**
	 * @return the auxiliarisflagotro
	 */
	public Boolean getAuxiliarisflagotro() {
		if (UValidador.estaVacio(auxiliarisflagotro)) {
			auxiliarisflagotro = false;
		}
		return auxiliarisflagotro;
	}

	/**
	 * @param auxiliarisflagotro
	 *            the auxiliarisflagotro to set
	 */
	public void setAuxiliarisflagotro(Boolean auxiliarisflagotro) {
		this.auxiliarisflagotro = auxiliarisflagotro;
	}

	/**
	 * @return the auxiliarisflagindispensableidioma
	 */
	public Boolean getAuxiliarisflagindispensableidioma() {
		if (UValidador.estaVacio(auxiliarisflagindispensableidioma)) {
			auxiliarisflagindispensableidioma = false;
		}
		return auxiliarisflagindispensableidioma;
	}

	/**
	 * @param auxiliarisflagindispensableidioma
	 *            the auxiliarisflagindispensableidioma to set
	 */
	public void setAuxiliarisflagindispensableidioma(
			Boolean auxiliarisflagindispensableidioma) {
		this.auxiliarisflagindispensableidioma = auxiliarisflagindispensableidioma;
	}

	/**
	 * @return the auxiliarisflagingles
	 */
	public Boolean getAuxiliarisflagingles() {
		if (UValidador.estaVacio(auxiliarisflagingles)) {
			auxiliarisflagingles = false;
		}
		return auxiliarisflagingles;
	}

	/**
	 * @param auxiliarisflagingles
	 *            the auxiliarisflagingles to set
	 */
	public void setAuxiliarisflagingles(Boolean auxiliarisflagingles) {
		this.auxiliarisflagingles = auxiliarisflagingles;
	}

	/**
	 * @return the auxiliarisflagotroidioma
	 */
	public Boolean getAuxiliarisflagotroidioma() {
		if (UValidador.estaVacio(auxiliarisflagotroidioma)) {
			auxiliarisflagotroidioma = false;
		}
		return auxiliarisflagotroidioma;
	}

	/**
	 * @param auxiliarisflagotroidioma
	 *            the auxiliarisflagotroidioma to set
	 */
	public void setAuxiliarisflagotroidioma(Boolean auxiliarisflagotroidioma) {
		this.auxiliarisflagotroidioma = auxiliarisflagotroidioma;
	}

	/**
	 * @return the auxiliarisflagexperiencia
	 */
	public Boolean getAuxiliarisflagexperiencia() {
		if (UValidador.estaVacio(auxiliarisflagexperiencia)) {
			auxiliarisflagexperiencia = false;
		}
		return auxiliarisflagexperiencia;
	}

	/**
	 * @param auxiliarisflagexperiencia
	 *            the auxiliarisflagexperiencia to set
	 */
	public void setAuxiliarisflagexperiencia(Boolean auxiliarisflagexperiencia) {
		this.auxiliarisflagexperiencia = auxiliarisflagexperiencia;
	}

}
