package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleado
*/
public class HrEmpleado extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadoPk pk;
	private String postulante;
	private String numerocontrato;
	private java.util.Date fechaestadocivil;
	private java.util.Date fechadefuncion;
	private String nivelgerencia;
	private String gruposanguineo;
	private java.math.BigDecimal peso;
	private java.math.BigDecimal talla;
	private String otroestadocivil;
	private String situaciondomicilio;
	private String otrasituaciondomicilio;
	private String impedimentos;
	private String flagactbeneficas;
	private String actbeneficas;
	private String flagactculturales;
	private String actculturales;
	private String flagactreligiosas;
	private String actreligiosas;
	private String flagactlaborales;
	private String actlaborales;
	private String flagactdeportivas;
	private String actdeportivas;
	private String flagactsociales;
	private String actsociales;
	private String informacionadicional;
	private String flagtrabajofuera;
	private String flagdeconfianza;
	private String flagprestamovacacional;
	private String flagbonificacion;
	private String flagprestacionsalud;
	private java.util.Date fechaacumulacion;
	private Integer gradoinstruccion;
	private Integer profesion;
	private String anexo;
	private Integer estamento;
	private String vigencia;
	private Integer gerencia;
	private Integer subgerencia;
	private String observaciones;
	private Integer posicion;
	private String provincianacimiento;
	private Integer gastoplanilla;
	private String distritonacimiento;
	private Integer registrofiscal;
	private java.util.Date licenciaconducirfecha;
	private String paisnacimiento;
	private String nombrecarnet;
	private String carnetsegurosocialna;
	private String direccionextranjera;
	private String paisextranjero;
	private String departamentoextranjero;
	private String provinciaextranjera;
	private String codigopostalextranjero;
	private String telefonoextranjero;
	private String celularextranjero;
	private String nombreemergencia;
	private String direccionemergencia;
	private String telefonoemergencia;
	private String parentescoemergencia;
	private String puntoorigen;
	private String celularemergencia;
	private String apellidocasada;
	private String apellidocarnet;
	private String puestocarnet;
	private String flaglicenciaensenanza;
	private String lugarlicenciaensenanza;
	private String codigomacschool;
	private String flagobservadoraula;
	private String flagdocencia;
	private String poseeauto;
	private String donante;
	private java.util.Date fechaingresoorganizacion;
	private String fasemadurez;
	private String carnetsegurosocialex;
	private String flagrcm;
	private java.util.Date fechasmf;
	private String flagsmf;
	private String tipovivienda;
	private String padecede;
	private String alergicoa;
	private String medicamentoemergencia;
	private String lugarexpedicioncedula;
	private String departamentonacimiento;
	private java.util.Date fechaingresovacaciones;
	private String numeroregistrocivil;
	private java.util.Date fechasolicitudagua;
	private String resolucionagua;
	private String direcciondescuentoagua;
	private String cuentabancariadescuentoagua;
	private String tiposervicio3;
	private String condicion;


	public HrEmpleado() {
		pk = new HrEmpleadoPk();
	}

	public HrEmpleadoPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadoPk pk) {
		this.pk = pk;
	}
	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}
	public String getNumerocontrato() {
		return numerocontrato;
	}

	public void setNumerocontrato(String numerocontrato) {
		this.numerocontrato = numerocontrato;
	}
	public java.util.Date getFechaestadocivil() {
		return fechaestadocivil;
	}

	public void setFechaestadocivil(java.util.Date fechaestadocivil) {
		this.fechaestadocivil = fechaestadocivil;
	}
	public java.util.Date getFechadefuncion() {
		return fechadefuncion;
	}

	public void setFechadefuncion(java.util.Date fechadefuncion) {
		this.fechadefuncion = fechadefuncion;
	}
	public String getNivelgerencia() {
		return nivelgerencia;
	}

	public void setNivelgerencia(String nivelgerencia) {
		this.nivelgerencia = nivelgerencia;
	}
	public String getGruposanguineo() {
		return gruposanguineo;
	}

	public void setGruposanguineo(String gruposanguineo) {
		this.gruposanguineo = gruposanguineo;
	}
	public java.math.BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(java.math.BigDecimal peso) {
		this.peso = peso;
	}
	public java.math.BigDecimal getTalla() {
		return talla;
	}

	public void setTalla(java.math.BigDecimal talla) {
		this.talla = talla;
	}
	public String getOtroestadocivil() {
		return otroestadocivil;
	}

	public void setOtroestadocivil(String otroestadocivil) {
		this.otroestadocivil = otroestadocivil;
	}
	public String getSituaciondomicilio() {
		return situaciondomicilio;
	}

	public void setSituaciondomicilio(String situaciondomicilio) {
		this.situaciondomicilio = situaciondomicilio;
	}
	public String getOtrasituaciondomicilio() {
		return otrasituaciondomicilio;
	}

	public void setOtrasituaciondomicilio(String otrasituaciondomicilio) {
		this.otrasituaciondomicilio = otrasituaciondomicilio;
	}
	public String getImpedimentos() {
		return impedimentos;
	}

	public void setImpedimentos(String impedimentos) {
		this.impedimentos = impedimentos;
	}
	public String getFlagactbeneficas() {
		return flagactbeneficas;
	}

	public void setFlagactbeneficas(String flagactbeneficas) {
		this.flagactbeneficas = flagactbeneficas;
	}
	public String getActbeneficas() {
		return actbeneficas;
	}

	public void setActbeneficas(String actbeneficas) {
		this.actbeneficas = actbeneficas;
	}
	public String getFlagactculturales() {
		return flagactculturales;
	}

	public void setFlagactculturales(String flagactculturales) {
		this.flagactculturales = flagactculturales;
	}
	public String getActculturales() {
		return actculturales;
	}

	public void setActculturales(String actculturales) {
		this.actculturales = actculturales;
	}
	public String getFlagactreligiosas() {
		return flagactreligiosas;
	}

	public void setFlagactreligiosas(String flagactreligiosas) {
		this.flagactreligiosas = flagactreligiosas;
	}
	public String getActreligiosas() {
		return actreligiosas;
	}

	public void setActreligiosas(String actreligiosas) {
		this.actreligiosas = actreligiosas;
	}
	public String getFlagactlaborales() {
		return flagactlaborales;
	}

	public void setFlagactlaborales(String flagactlaborales) {
		this.flagactlaborales = flagactlaborales;
	}
	public String getActlaborales() {
		return actlaborales;
	}

	public void setActlaborales(String actlaborales) {
		this.actlaborales = actlaborales;
	}
	public String getFlagactdeportivas() {
		return flagactdeportivas;
	}

	public void setFlagactdeportivas(String flagactdeportivas) {
		this.flagactdeportivas = flagactdeportivas;
	}
	public String getActdeportivas() {
		return actdeportivas;
	}

	public void setActdeportivas(String actdeportivas) {
		this.actdeportivas = actdeportivas;
	}
	public String getFlagactsociales() {
		return flagactsociales;
	}

	public void setFlagactsociales(String flagactsociales) {
		this.flagactsociales = flagactsociales;
	}
	public String getActsociales() {
		return actsociales;
	}

	public void setActsociales(String actsociales) {
		this.actsociales = actsociales;
	}
	public String getInformacionadicional() {
		return informacionadicional;
	}

	public void setInformacionadicional(String informacionadicional) {
		this.informacionadicional = informacionadicional;
	}
	public String getFlagtrabajofuera() {
		return flagtrabajofuera;
	}

	public void setFlagtrabajofuera(String flagtrabajofuera) {
		this.flagtrabajofuera = flagtrabajofuera;
	}
	public String getFlagdeconfianza() {
		return flagdeconfianza;
	}

	public void setFlagdeconfianza(String flagdeconfianza) {
		this.flagdeconfianza = flagdeconfianza;
	}
	public String getFlagprestamovacacional() {
		return flagprestamovacacional;
	}

	public void setFlagprestamovacacional(String flagprestamovacacional) {
		this.flagprestamovacacional = flagprestamovacacional;
	}
	public String getFlagbonificacion() {
		return flagbonificacion;
	}

	public void setFlagbonificacion(String flagbonificacion) {
		this.flagbonificacion = flagbonificacion;
	}
	public String getFlagprestacionsalud() {
		return flagprestacionsalud;
	}

	public void setFlagprestacionsalud(String flagprestacionsalud) {
		this.flagprestacionsalud = flagprestacionsalud;
	}
	public java.util.Date getFechaacumulacion() {
		return fechaacumulacion;
	}

	public void setFechaacumulacion(java.util.Date fechaacumulacion) {
		this.fechaacumulacion = fechaacumulacion;
	}
	public Integer getGradoinstruccion() {
		return gradoinstruccion;
	}

	public void setGradoinstruccion(Integer gradoinstruccion) {
		this.gradoinstruccion = gradoinstruccion;
	}
	public Integer getProfesion() {
		return profesion;
	}

	public void setProfesion(Integer profesion) {
		this.profesion = profesion;
	}
	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public Integer getEstamento() {
		return estamento;
	}

	public void setEstamento(Integer estamento) {
		this.estamento = estamento;
	}
	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public Integer getGerencia() {
		return gerencia;
	}

	public void setGerencia(Integer gerencia) {
		this.gerencia = gerencia;
	}
	public Integer getSubgerencia() {
		return subgerencia;
	}

	public void setSubgerencia(Integer subgerencia) {
		this.subgerencia = subgerencia;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	public String getProvincianacimiento() {
		return provincianacimiento;
	}

	public void setProvincianacimiento(String provincianacimiento) {
		this.provincianacimiento = provincianacimiento;
	}
	public Integer getGastoplanilla() {
		return gastoplanilla;
	}

	public void setGastoplanilla(Integer gastoplanilla) {
		this.gastoplanilla = gastoplanilla;
	}
	public String getDistritonacimiento() {
		return distritonacimiento;
	}

	public void setDistritonacimiento(String distritonacimiento) {
		this.distritonacimiento = distritonacimiento;
	}
	public Integer getRegistrofiscal() {
		return registrofiscal;
	}

	public void setRegistrofiscal(Integer registrofiscal) {
		this.registrofiscal = registrofiscal;
	}
	public java.util.Date getLicenciaconducirfecha() {
		return licenciaconducirfecha;
	}

	public void setLicenciaconducirfecha(java.util.Date licenciaconducirfecha) {
		this.licenciaconducirfecha = licenciaconducirfecha;
	}
	public String getPaisnacimiento() {
		return paisnacimiento;
	}

	public void setPaisnacimiento(String paisnacimiento) {
		this.paisnacimiento = paisnacimiento;
	}
	public String getNombrecarnet() {
		return nombrecarnet;
	}

	public void setNombrecarnet(String nombrecarnet) {
		this.nombrecarnet = nombrecarnet;
	}
	public String getCarnetsegurosocialna() {
		return carnetsegurosocialna;
	}

	public void setCarnetsegurosocialna(String carnetsegurosocialna) {
		this.carnetsegurosocialna = carnetsegurosocialna;
	}
	public String getDireccionextranjera() {
		return direccionextranjera;
	}

	public void setDireccionextranjera(String direccionextranjera) {
		this.direccionextranjera = direccionextranjera;
	}
	public String getPaisextranjero() {
		return paisextranjero;
	}

	public void setPaisextranjero(String paisextranjero) {
		this.paisextranjero = paisextranjero;
	}
	public String getDepartamentoextranjero() {
		return departamentoextranjero;
	}

	public void setDepartamentoextranjero(String departamentoextranjero) {
		this.departamentoextranjero = departamentoextranjero;
	}
	public String getProvinciaextranjera() {
		return provinciaextranjera;
	}

	public void setProvinciaextranjera(String provinciaextranjera) {
		this.provinciaextranjera = provinciaextranjera;
	}
	public String getCodigopostalextranjero() {
		return codigopostalextranjero;
	}

	public void setCodigopostalextranjero(String codigopostalextranjero) {
		this.codigopostalextranjero = codigopostalextranjero;
	}
	public String getTelefonoextranjero() {
		return telefonoextranjero;
	}

	public void setTelefonoextranjero(String telefonoextranjero) {
		this.telefonoextranjero = telefonoextranjero;
	}
	public String getCelularextranjero() {
		return celularextranjero;
	}

	public void setCelularextranjero(String celularextranjero) {
		this.celularextranjero = celularextranjero;
	}
	public String getNombreemergencia() {
		return nombreemergencia;
	}

	public void setNombreemergencia(String nombreemergencia) {
		this.nombreemergencia = nombreemergencia;
	}
	public String getDireccionemergencia() {
		return direccionemergencia;
	}

	public void setDireccionemergencia(String direccionemergencia) {
		this.direccionemergencia = direccionemergencia;
	}
	public String getTelefonoemergencia() {
		return telefonoemergencia;
	}

	public void setTelefonoemergencia(String telefonoemergencia) {
		this.telefonoemergencia = telefonoemergencia;
	}
	public String getParentescoemergencia() {
		return parentescoemergencia;
	}

	public void setParentescoemergencia(String parentescoemergencia) {
		this.parentescoemergencia = parentescoemergencia;
	}
	public String getPuntoorigen() {
		return puntoorigen;
	}

	public void setPuntoorigen(String puntoorigen) {
		this.puntoorigen = puntoorigen;
	}
	public String getCelularemergencia() {
		return celularemergencia;
	}

	public void setCelularemergencia(String celularemergencia) {
		this.celularemergencia = celularemergencia;
	}
	public String getApellidocasada() {
		return apellidocasada;
	}

	public void setApellidocasada(String apellidocasada) {
		this.apellidocasada = apellidocasada;
	}
	public String getApellidocarnet() {
		return apellidocarnet;
	}

	public void setApellidocarnet(String apellidocarnet) {
		this.apellidocarnet = apellidocarnet;
	}
	public String getPuestocarnet() {
		return puestocarnet;
	}

	public void setPuestocarnet(String puestocarnet) {
		this.puestocarnet = puestocarnet;
	}
	public String getFlaglicenciaensenanza() {
		return flaglicenciaensenanza;
	}

	public void setFlaglicenciaensenanza(String flaglicenciaensenanza) {
		this.flaglicenciaensenanza = flaglicenciaensenanza;
	}
	public String getLugarlicenciaensenanza() {
		return lugarlicenciaensenanza;
	}

	public void setLugarlicenciaensenanza(String lugarlicenciaensenanza) {
		this.lugarlicenciaensenanza = lugarlicenciaensenanza;
	}
	public String getCodigomacschool() {
		return codigomacschool;
	}

	public void setCodigomacschool(String codigomacschool) {
		this.codigomacschool = codigomacschool;
	}
	public String getFlagobservadoraula() {
		return flagobservadoraula;
	}

	public void setFlagobservadoraula(String flagobservadoraula) {
		this.flagobservadoraula = flagobservadoraula;
	}
	public String getFlagdocencia() {
		return flagdocencia;
	}

	public void setFlagdocencia(String flagdocencia) {
		this.flagdocencia = flagdocencia;
	}
	public String getPoseeauto() {
		return poseeauto;
	}

	public void setPoseeauto(String poseeauto) {
		this.poseeauto = poseeauto;
	}
	public String getDonante() {
		return donante;
	}

	public void setDonante(String donante) {
		this.donante = donante;
	}
	public java.util.Date getFechaingresoorganizacion() {
		return fechaingresoorganizacion;
	}

	public void setFechaingresoorganizacion(java.util.Date fechaingresoorganizacion) {
		this.fechaingresoorganizacion = fechaingresoorganizacion;
	}
	public String getFasemadurez() {
		return fasemadurez;
	}

	public void setFasemadurez(String fasemadurez) {
		this.fasemadurez = fasemadurez;
	}
	public String getCarnetsegurosocialex() {
		return carnetsegurosocialex;
	}

	public void setCarnetsegurosocialex(String carnetsegurosocialex) {
		this.carnetsegurosocialex = carnetsegurosocialex;
	}
	public String getFlagrcm() {
		return flagrcm;
	}

	public void setFlagrcm(String flagrcm) {
		this.flagrcm = flagrcm;
	}
	public java.util.Date getFechasmf() {
		return fechasmf;
	}

	public void setFechasmf(java.util.Date fechasmf) {
		this.fechasmf = fechasmf;
	}
	public String getFlagsmf() {
		return flagsmf;
	}

	public void setFlagsmf(String flagsmf) {
		this.flagsmf = flagsmf;
	}
	public String getTipovivienda() {
		return tipovivienda;
	}

	public void setTipovivienda(String tipovivienda) {
		this.tipovivienda = tipovivienda;
	}
	public String getPadecede() {
		return padecede;
	}

	public void setPadecede(String padecede) {
		this.padecede = padecede;
	}
	public String getAlergicoa() {
		return alergicoa;
	}

	public void setAlergicoa(String alergicoa) {
		this.alergicoa = alergicoa;
	}
	public String getMedicamentoemergencia() {
		return medicamentoemergencia;
	}

	public void setMedicamentoemergencia(String medicamentoemergencia) {
		this.medicamentoemergencia = medicamentoemergencia;
	}
	public String getLugarexpedicioncedula() {
		return lugarexpedicioncedula;
	}

	public void setLugarexpedicioncedula(String lugarexpedicioncedula) {
		this.lugarexpedicioncedula = lugarexpedicioncedula;
	}
	public String getDepartamentonacimiento() {
		return departamentonacimiento;
	}

	public void setDepartamentonacimiento(String departamentonacimiento) {
		this.departamentonacimiento = departamentonacimiento;
	}
	public java.util.Date getFechaingresovacaciones() {
		return fechaingresovacaciones;
	}

	public void setFechaingresovacaciones(java.util.Date fechaingresovacaciones) {
		this.fechaingresovacaciones = fechaingresovacaciones;
	}
	public String getNumeroregistrocivil() {
		return numeroregistrocivil;
	}

	public void setNumeroregistrocivil(String numeroregistrocivil) {
		this.numeroregistrocivil = numeroregistrocivil;
	}
	public java.util.Date getFechasolicitudagua() {
		return fechasolicitudagua;
	}

	public void setFechasolicitudagua(java.util.Date fechasolicitudagua) {
		this.fechasolicitudagua = fechasolicitudagua;
	}
	public String getResolucionagua() {
		return resolucionagua;
	}

	public void setResolucionagua(String resolucionagua) {
		this.resolucionagua = resolucionagua;
	}
	public String getDirecciondescuentoagua() {
		return direcciondescuentoagua;
	}

	public void setDirecciondescuentoagua(String direcciondescuentoagua) {
		this.direcciondescuentoagua = direcciondescuentoagua;
	}
	public String getCuentabancariadescuentoagua() {
		return cuentabancariadescuentoagua;
	}

	public void setCuentabancariadescuentoagua(String cuentabancariadescuentoagua) {
		this.cuentabancariadescuentoagua = cuentabancariadescuentoagua;
	}
	public String getTiposervicio3() {
		return tiposervicio3;
	}

	public void setTiposervicio3(String tiposervicio3) {
		this.tiposervicio3 = tiposervicio3;
	}
	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

}
