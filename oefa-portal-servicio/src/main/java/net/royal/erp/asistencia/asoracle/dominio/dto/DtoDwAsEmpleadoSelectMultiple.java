package net.royal.erp.asistencia.asoracle.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asoracle.dw_as_empleado_select_multiple
 */
public class DtoDwAsEmpleadoSelectMultiple implements java.io.Serializable {
	// variables para el dtopòsition
	private String codigodescripcionflag;
	private String codigodescripciontext;

	private BigDecimal persona;
	private String nombrecompleto;
	private String tipocontrato;
	private String seleccionado;
	private String companiasocio;
	private String codigocarnet;
	private BigDecimal tipohorario;
	private String personaant;
	private String estado;
	private String estadoempleado;
	private BigDecimal area;
	private String nombrearea;
	private BigDecimal cf_flagcarnet;
	private String departamentooperacional;
	private String centrocosto;

	// las variables selec y sinasist se usaran en la creacion del checkbox, no
	// estan en el query
	private Boolean selec;
	private Boolean sinasist;

	private Integer sid;
	private String usuario;
	private BigDecimal empleado;
	private String codigoUsuarioEmpleado;
	private String codigoUsuarioPersona;

	private Boolean isseleccionado;
	private String estilo;

	private Boolean nogeneraasistencia;
	private Integer indiceModificado;
	private Boolean asignarTodos;

	private Boolean blasistentesiged;
	private Boolean blasistentepermsiged;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getPersona() {
		return persona;
	}

	public void setPersona(BigDecimal persona) {
		this.persona = persona;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public String getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(String seleccionado) {
		this.seleccionado = seleccionado;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getCodigocarnet() {
		return codigocarnet;
	}

	public void setCodigocarnet(String codigocarnet) {
		this.codigocarnet = codigocarnet;
	}

	public BigDecimal getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getPersonaant() {
		return personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoempleado() {
		return estadoempleado;
	}

	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getNombrearea() {
		return nombrearea;
	}

	public void setNombrearea(String nombrearea) {
		this.nombrearea = nombrearea;
	}

	public BigDecimal getCf_flagcarnet() {
		return cf_flagcarnet;
	}

	public void setCf_flagcarnet(BigDecimal cf_flagcarnet) {
		this.cf_flagcarnet = cf_flagcarnet;
	}

	public String getDepartamentooperacional() {
		return departamentooperacional;
	}

	public void setDepartamentooperacional(String departamentooperacional) {
		this.departamentooperacional = departamentooperacional;
	}

	public Boolean getSelec() {
		return selec;
	}

	public void setSelec(Boolean selec) {
		this.selec = selec;
	}

	public Boolean getSinasist() {
		return sinasist;
	}

	public void setSinasist(Boolean sinasist) {
		this.sinasist = sinasist;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getCodigodescripcionflag() {
		return codigodescripcionflag;
	}

	public String getCodigodescripciontext() {
		if (UValidador.estaVacio(codigodescripciontext)) {
			codigodescripciontext = "";
		}
		return codigodescripciontext;
	}

	public void setCodigodescripcionflag(String codigodescripcionflag) {
		this.codigodescripcionflag = codigodescripcionflag;
	}

	public void setCodigodescripciontext(String codigodescripciontext) {
		this.codigodescripciontext = codigodescripciontext;
	}

	/**
	 * @return the isseleccionado
	 */
	public Boolean getIsseleccionado() {
		if (UValidador.esNulo(isseleccionado)) {
			isseleccionado = false;
		}
		return isseleccionado;
	}

	/**
	 * @param isseleccionado
	 *            the isseleccionado to set
	 */
	public void setIsseleccionado(Boolean isseleccionado) {
		this.isseleccionado = isseleccionado;
	}

	/**
	 * @return the nogeneraasistencia
	 */
	public Boolean getNogeneraasistencia() {
		nogeneraasistencia = false;
		if (UValidador.esCero(getCf_flagcarnet().intValue())) {
			nogeneraasistencia = true;
		}
		return nogeneraasistencia;
	}

	/**
	 * @param nogeneraasistencia
	 *            the nogeneraasistencia to set
	 */
	public void setNogeneraasistencia(Boolean nogeneraasistencia) {
		this.nogeneraasistencia = nogeneraasistencia;
	}

	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		if (!UValidador.estaVacio(getEstado())) {
			if (!getEstado().equals("A")) {
				estilo = "color:red";
			}
		}
		return estilo;
	}

	/**
	 * @param estilo
	 *            the estilo to set
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public String getCodigoUsuarioEmpleado() {
		return codigoUsuarioEmpleado;
	}

	public void setCodigoUsuarioEmpleado(String codigoUsuarioEmpleado) {
		this.codigoUsuarioEmpleado = codigoUsuarioEmpleado;
	}

	public String getCodigoUsuarioPersona() {
		return codigoUsuarioPersona;
	}

	public void setCodigoUsuarioPersona(String codigoUsuarioPersona) {
		this.codigoUsuarioPersona = codigoUsuarioPersona;
	}

	public Integer getIndiceModificado() {
		return indiceModificado;
	}

	public void setIndiceModificado(Integer indiceModificado) {
		this.indiceModificado = indiceModificado;
	}

	public Boolean getAsignarTodos() {
		return asignarTodos;
	}

	public void setAsignarTodos(Boolean asignarTodos) {
		this.asignarTodos = asignarTodos;
	}

	public Boolean getBlasistentesiged() {
		if (UValidador.esNulo(blasistentesiged)) {
			blasistentesiged = false;
		}
		return blasistentesiged;
	}

	public void setBlasistentesiged(Boolean blasistentesiged) {
		this.blasistentesiged = blasistentesiged;
	}

	public Boolean getBlasistentepermsiged() {
		if (UValidador.esNulo(blasistentepermsiged)) {
			blasistentepermsiged = false;
		}
		return blasistentepermsiged;
	}

	public void setBlasistentepermsiged(Boolean blasistentepermsiged) {
		this.blasistentepermsiged = blasistentepermsiged;
	}

}
