package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.rrhh.dominio.dto.DtoDWHrTipoContratoSelect;
import net.royal.erp.rrhh.dominio.dto.DtoDwHrTiporeclutamientoSel;
import net.royal.erp.rrhh.prmast.dominio.dto.DtoDwMaPrTipoplantillaSelect;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;

/**
 * @author nunezh
 * @powerbuilder hrproc.dw_hr_requerimiento_edit
 */
@SuppressWarnings("serial")
public class DtoDwHrRequerimientoEdit implements Serializable {
	private String requerimiento;
	private String companyowner;
	private BigDecimal empleadosolicitante;
	private BigDecimal codigoposicionsolicitante;
	private BigDecimal codigopuesto;
	private Date fechasolicitud;
	private String motivo;
	private String tipocontrato;
	private Date fechadesde;
	private Date fechahasta;
	private String perfiladicional;
	private String unidadnegocio;
	private BigDecimal numerosolicitado;
	private BigDecimal numeropendiente;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String requerimientonumero;
	private String unidadreplicacion;
	private String clasificacion;
	private String tiporequerimiento;
	private String centrocosto;
	private String centrocostonombre;
	private Date fechafinrequerimiento;
	private String afe;
	private BigDecimal remuneracionreferencialbruto;
	private BigDecimal remuneracionreferencialneto;
	private String correoelectronico;
	private String flagtarjetapersonal;
	private String grupocorreoelectronico;
	private String flagaccesointernet;
	private String disphorariodia;
	private String disphorariohoraflag;
	private String disphorariohora;
	private String dispviajetipo;
	private String dispviajelugarflag;
	private String dispviajelugar;
	private String tipotrabajador;
	private String tipotrabajadornombre;
	private String tipoplanilla;
	private BigDecimal tipohorario;
	private String deptoorganizacion;
	private String categoria;
	private Boolean isaccesocorreo;
	private Boolean isaccesointernet;
	private Boolean isaccesosii;
	private Boolean isaccesootros;
	private Boolean isaccesotelefono;
	private Boolean isaccesocelular;
	private Boolean isaccesooficina;
	private Boolean isaccesopc;
	private Boolean isaccesootrossistemas;
	private Boolean isaccesomobiliario;
	private Boolean isaccesopuntoelectrico;
	private String acceso_otrossistemascomentario;
	private String observaciones;
	private String incrementocomentario;
	private String lineacarrera;
	private String acceso_otroscomentario;
	private BigDecimal codigopuestosolicitante;
	private BigDecimal codigojefe;
	private BigDecimal tiporeclutamiento;
	private String lineacarrera_2;
	private String desnuevocurso;
	private BigDecimal codigopuestonuevo;
	private String numeroconcurso;
	private BigDecimal nivelservicio;
	private String certificacionnumero;
	private String compromisonumero;
	private BigDecimal montoapagar;
	private String motivorechazo;
	private String convocatoria;
	private BigDecimal concurso;
	private Date fechaenvio;
	private String sucursal;
	private Date fechaconvocatoria;
	private String fuentefinanciamiento;

	private DtoDwMaCompanyownerSelect companyownerDto;
	private DtoDWHrTipoContratoSelect tipocontratoDto;
	private DtoDwMaMiscelaneosdetalleSelect motivoDto;
	private DtoDwMaPrTipoplantillaSelect tipoplanillaDto;
	private DtoDwHrTiporeclutamientoSel tiporeclutamientoDto;

	private String personanombrecompleto;
	private String personanombrecompletojefe;
	private String nombrepuestocomntario;
	private String tiempotranscurrido;
	private String nombrenivelservicio;
	private BigDecimal pagomaximo;
	private BigDecimal pagominimo;

	private BigDecimal empleadoresponsable;
	private String ubicacion;
	private String rutasustento;
	private byte[] documento;

	private String flagtipocontrato;
	private String numerosolicitud;
	private BigDecimal nivelaprobacion;
	private String codigoproceso;
	private BigDecimal numeroproceso;
	private BigDecimal proceso;

	// PARA TRAER LA CONSULTA
	private String accesocorreo;
	private String accesointernet;
	private String accesosii;
	private String accesootros;
	private String accesotelefono;
	private String accesocelular;
	private String accesooficina;
	private String accesopc;
	private String accesootrossistemas;
	private String accesomobiliario;
	private String accesopuntoelectronico;
	private String uuidalfresco;

	private String referenciafiscal01;
	private BigDecimal mesesprueba;

	private String descripcionposicion;
	private String temaevaluacionconocimiento;

	private String flagEnviado;
	private String descripcionpuestoinformativo;

	private Date fechaEnvio;
	private String xdigitalperpuestohrlsc;
	private String xdescperpuestohrlsc;
	private String ruta;

	public String getDescripcionpuestoinformativo() {
		return descripcionpuestoinformativo;
	}

	public void setDescripcionpuestoinformativo(String descripcionpuestoinformativo) {
		this.descripcionpuestoinformativo = descripcionpuestoinformativo;
	}

	public String getFlagEnviado() {
		return flagEnviado;
	}

	public void setFlagEnviado(String flagEnviado) {
		this.flagEnviado = flagEnviado;
	}

	public String getTemaevaluacionconocimiento() {
		return temaevaluacionconocimiento;
	}

	public void setTemaevaluacionconocimiento(String temaevaluacionconocimiento) {
		this.temaevaluacionconocimiento = temaevaluacionconocimiento;
	}

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public BigDecimal getEmpleadosolicitante() {
		return empleadosolicitante;
	}

	public void setEmpleadosolicitante(BigDecimal empleadosolicitante) {
		this.empleadosolicitante = empleadosolicitante;
	}

	public BigDecimal getCodigoposicionsolicitante() {
		return codigoposicionsolicitante;
	}

	public void setCodigoposicionsolicitante(BigDecimal codigoposicionsolicitante) {
		this.codigoposicionsolicitante = codigoposicionsolicitante;
	}

	public BigDecimal getCodigopuesto() {
		if (UValidador.esNulo(codigopuesto)) {
			codigopuesto = BigDecimal.ZERO;
		}
		return codigopuesto;
	}

	public void setCodigopuesto(BigDecimal codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getPerfiladicional() {
		return perfiladicional;
	}

	public void setPerfiladicional(String perfiladicional) {
		this.perfiladicional = perfiladicional;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public BigDecimal getNumerosolicitado() {
		if (UValidador.esNulo(numerosolicitado)) {
			numerosolicitado = BigDecimal.ZERO;
		}
		return numerosolicitado;
	}

	public void setNumerosolicitado(BigDecimal numerosolicitado) {
		this.numerosolicitado = numerosolicitado;
	}

	public BigDecimal getNumeropendiente() {
		if (UValidador.esNulo(numeropendiente)) {
			numeropendiente = BigDecimal.ZERO;
		}
		return numeropendiente;
	}

	public void setNumeropendiente(BigDecimal numeropendiente) {
		this.numeropendiente = numeropendiente;
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

	public String getRequerimientonumero() {
		return requerimientonumero;
	}

	public void setRequerimientonumero(String requerimientonumero) {
		this.requerimientonumero = requerimientonumero;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public Date getFechafinrequerimiento() {
		return fechafinrequerimiento;
	}

	public void setFechafinrequerimiento(Date fechafinrequerimiento) {
		this.fechafinrequerimiento = fechafinrequerimiento;
	}

	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

	public BigDecimal getRemuneracionreferencialbruto() {
		if (UValidador.esNulo(remuneracionreferencialbruto)) {
			remuneracionreferencialbruto = BigDecimal.ZERO;
		}

		return remuneracionreferencialbruto;
	}

	public void setRemuneracionreferencialbruto(BigDecimal remuneracionreferencialbruto) {
		this.remuneracionreferencialbruto = remuneracionreferencialbruto;
	}

	public BigDecimal getRemuneracionreferencialneto() {
		if (UValidador.esNulo(remuneracionreferencialneto)) {
			remuneracionreferencialneto = BigDecimal.ZERO;
		}
		return remuneracionreferencialneto;
	}

	public void setRemuneracionreferencialneto(BigDecimal remuneracionreferencialneto) {
		this.remuneracionreferencialneto = remuneracionreferencialneto;
	}

	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	public String getFlagtarjetapersonal() {
		return flagtarjetapersonal;
	}

	public void setFlagtarjetapersonal(String flagtarjetapersonal) {
		this.flagtarjetapersonal = flagtarjetapersonal;
	}

	public String getGrupocorreoelectronico() {
		return grupocorreoelectronico;
	}

	public void setGrupocorreoelectronico(String grupocorreoelectronico) {
		this.grupocorreoelectronico = grupocorreoelectronico;
	}

	public String getFlagaccesointernet() {
		return flagaccesointernet;
	}

	public void setFlagaccesointernet(String flagaccesointernet) {
		this.flagaccesointernet = flagaccesointernet;
	}

	public String getDisphorariodia() {
		return disphorariodia;
	}

	public void setDisphorariodia(String disphorariodia) {
		this.disphorariodia = disphorariodia;
	}

	public String getDisphorariohoraflag() {
		return disphorariohoraflag;
	}

	public void setDisphorariohoraflag(String disphorariohoraflag) {
		this.disphorariohoraflag = disphorariohoraflag;
	}

	public String getDisphorariohora() {
		return disphorariohora;
	}

	public void setDisphorariohora(String disphorariohora) {
		this.disphorariohora = disphorariohora;
	}

	public String getDispviajetipo() {
		return dispviajetipo;
	}

	public void setDispviajetipo(String dispviajetipo) {
		this.dispviajetipo = dispviajetipo;
	}

	public String getDispviajelugarflag() {
		return dispviajelugarflag;
	}

	public void setDispviajelugarflag(String dispviajelugarflag) {
		this.dispviajelugarflag = dispviajelugarflag;
	}

	public String getDispviajelugar() {
		return dispviajelugar;
	}

	public void setDispviajelugar(String dispviajelugar) {
		this.dispviajelugar = dispviajelugar;
	}

	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
	}

	public String getTipoplanilla() {
		if (UValidador.esNulo(tipoplanilla)) {
			tipoplanilla = "";
		}
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public BigDecimal getTipohorario() {
		if (UValidador.esNulo(tipohorario)) {
			tipohorario = BigDecimal.ZERO;
		}
		return tipohorario;
	}

	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getDeptoorganizacion() {
		return deptoorganizacion;
	}

	public void setDeptoorganizacion(String deptoorganizacion) {
		this.deptoorganizacion = deptoorganizacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the isaccesocorreo
	 */
	public Boolean getIsaccesocorreo() {
		return isaccesocorreo;
	}

	/**
	 * @param isaccesocorreo
	 *            the isaccesocorreo to set
	 */
	public void setIsaccesocorreo(Boolean isaccesocorreo) {
		this.isaccesocorreo = isaccesocorreo;
	}

	/**
	 * @return the isaccesointernet
	 */
	public Boolean getIsaccesointernet() {
		return isaccesointernet;
	}

	/**
	 * @param isaccesointernet
	 *            the isaccesointernet to set
	 */
	public void setIsaccesointernet(Boolean isaccesointernet) {
		this.isaccesointernet = isaccesointernet;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getIncrementocomentario() {
		return incrementocomentario;
	}

	public void setIncrementocomentario(String incrementocomentario) {
		this.incrementocomentario = incrementocomentario;
	}

	public String getLineacarrera() {
		return lineacarrera;
	}

	public void setLineacarrera(String lineacarrera) {
		this.lineacarrera = lineacarrera;
	}

	public String getAcceso_otroscomentario() {
		return acceso_otroscomentario;
	}

	public void setAcceso_otroscomentario(String acceso_otroscomentario) {
		this.acceso_otroscomentario = acceso_otroscomentario;
	}

	public BigDecimal getCodigopuestosolicitante() {
		if (UValidador.esNulo(codigopuestosolicitante)) {
			codigopuestosolicitante = BigDecimal.ZERO;
		}
		return codigopuestosolicitante;
	}

	public void setCodigopuestosolicitante(BigDecimal codigopuestosolicitante) {
		this.codigopuestosolicitante = codigopuestosolicitante;
	}

	public BigDecimal getCodigojefe() {
		if (UValidador.esNulo(codigojefe)) {
			codigojefe = BigDecimal.ZERO;
		}
		return codigojefe;
	}

	public void setCodigojefe(BigDecimal codigojefe) {
		this.codigojefe = codigojefe;
	}

	public BigDecimal getTiporeclutamiento() {
		return tiporeclutamiento;
	}

	public void setTiporeclutamiento(BigDecimal tiporeclutamiento) {
		this.tiporeclutamiento = tiporeclutamiento;
	}

	public String getLineacarrera_2() {
		return lineacarrera_2;
	}

	public void setLineacarrera_2(String lineacarrera_2) {
		this.lineacarrera_2 = lineacarrera_2;
	}

	public String getDesnuevocurso() {
		return desnuevocurso;
	}

	public void setDesnuevocurso(String desnuevocurso) {
		this.desnuevocurso = desnuevocurso;
	}

	public BigDecimal getCodigopuestonuevo() {
		if (UValidador.esNulo(codigopuestonuevo)) {
			codigopuestonuevo = BigDecimal.ZERO;
		}
		return codigopuestonuevo;
	}

	public void setCodigopuestonuevo(BigDecimal codigopuestonuevo) {
		this.codigopuestonuevo = codigopuestonuevo;
	}

	public String getNumeroconcurso() {
		return numeroconcurso;
	}

	public void setNumeroconcurso(String numeroconcurso) {
		this.numeroconcurso = numeroconcurso;
	}

	public BigDecimal getNivelservicio() {
		if (UValidador.esNulo(nivelservicio)) {
			nivelservicio = BigDecimal.ZERO;
		}
		return nivelservicio;
	}

	public void setNivelservicio(BigDecimal nivelservicio) {
		this.nivelservicio = nivelservicio;
	}

	public String getCertificacionnumero() {
		return certificacionnumero;
	}

	public void setCertificacionnumero(String certificacionnumero) {
		this.certificacionnumero = certificacionnumero;
	}

	public String getCompromisonumero() {
		return compromisonumero;
	}

	public void setCompromisonumero(String compromisonumero) {
		this.compromisonumero = compromisonumero;
	}

	public BigDecimal getMontoapagar() {
		if (UValidador.esNulo(montoapagar)) {
			montoapagar = BigDecimal.valueOf(0.00);
		}
		return montoapagar.setScale(2);
	}

	public void setMontoapagar(BigDecimal montoapagar) {
		this.montoapagar = montoapagar;
	}

	public String getMotivorechazo() {
		return motivorechazo;
	}

	public void setMotivorechazo(String motivorechazo) {
		this.motivorechazo = motivorechazo;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public BigDecimal getConcurso() {
		if (UValidador.esNulo(concurso)) {
			concurso = BigDecimal.ZERO;
		}
		return concurso;
	}

	public void setConcurso(BigDecimal concurso) {
		this.concurso = concurso;
	}

	public Date getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Date getFechaconvocatoria() {
		return fechaconvocatoria;
	}

	public void setFechaconvocatoria(Date fechaconvocatoria) {
		this.fechaconvocatoria = fechaconvocatoria;
	}

	public DtoDwMaCompanyownerSelect getCompanyownerDto() {
		return companyownerDto;
	}

	public void setCompanyownerDto(DtoDwMaCompanyownerSelect companyownerDto) {
		this.companyownerDto = companyownerDto;
	}

	public DtoDWHrTipoContratoSelect getTipocontratoDto() {
		return tipocontratoDto;
	}

	public void setTipocontratoDto(DtoDWHrTipoContratoSelect tipocontratoDto) {
		this.tipocontratoDto = tipocontratoDto;
	}

	public DtoDwMaMiscelaneosdetalleSelect getMotivoDto() {
		return motivoDto;
	}

	public void setMotivoDto(DtoDwMaMiscelaneosdetalleSelect motivoDto) {
		this.motivoDto = motivoDto;
	}

	public DtoDwMaPrTipoplantillaSelect getTipoplanillaDto() {
		return tipoplanillaDto;
	}

	public void setTipoplanillaDto(DtoDwMaPrTipoplantillaSelect tipoplanillaDto) {
		this.tipoplanillaDto = tipoplanillaDto;
	}

	public String getPersonanombrecompleto() {
		return personanombrecompleto;
	}

	public void setPersonanombrecompleto(String personanombrecompleto) {
		this.personanombrecompleto = personanombrecompleto;
	}

	public String getNombrepuestocomntario() {
		return nombrepuestocomntario;
	}

	public void setNombrepuestocomntario(String nombrepuestocomntario) {
		this.nombrepuestocomntario = nombrepuestocomntario;
	}

	public String getPersonanombrecompletojefe() {
		return personanombrecompletojefe;
	}

	public void setPersonanombrecompletojefe(String personanombrecompletojefe) {
		this.personanombrecompletojefe = personanombrecompletojefe;
	}

	public String getTiempotranscurrido() {
		Integer e = UFechaHora.obtenerDiasTranscurridos(
				UValidador.esNulo(fechafinrequerimiento) ? new Date() : fechafinrequerimiento, fechasolicitud);
		e = UValidador.esNulo(e) ? 0 : e;
		tiempotranscurrido = e + (e == 1 ? "  día" : "  días");
		return tiempotranscurrido;
	}

	public void setTiempotranscurrido(String tiempotranscurrido) {
		this.tiempotranscurrido = tiempotranscurrido;
	}

	public String getNombrenivelservicio() {
		return nombrenivelservicio;
	}

	public void setNombrenivelservicio(String nombrenivelservicio) {
		this.nombrenivelservicio = nombrenivelservicio;
	}

	public BigDecimal getPagomaximo() {
		if (UValidador.esNulo(pagomaximo)) {
			pagomaximo = BigDecimal.valueOf(0.00);
		}
		return pagomaximo.setScale(2);
	}

	public void setPagomaximo(BigDecimal pagomaximo) {
		this.pagomaximo = pagomaximo;
	}

	public BigDecimal getPagominimo() {
		if (UValidador.esNulo(pagominimo)) {
			pagominimo = BigDecimal.valueOf(0.00);
		}
		return pagominimo.setScale(2);
	}

	public void setPagominimo(BigDecimal pagominimo) {
		this.pagominimo = pagominimo;
	}

	public DtoDwHrTiporeclutamientoSel getTiporeclutamientoDto() {
		return tiporeclutamientoDto;
	}

	public void setTiporeclutamientoDto(DtoDwHrTiporeclutamientoSel tiporeclutamientoDto) {
		this.tiporeclutamientoDto = tiporeclutamientoDto;
	}

	/**
	 * @return the isaccesosii
	 */
	public Boolean getIsaccesosii() {
		return isaccesosii;
	}

	/**
	 * @param isaccesosii
	 *            the isaccesosii to set
	 */
	public void setIsaccesosii(Boolean isaccesosii) {
		this.isaccesosii = isaccesosii;
	}

	/**
	 * @return the isaccesootros
	 */
	public Boolean getIsaccesootros() {
		return isaccesootros;
	}

	/**
	 * @param isaccesootros
	 *            the isaccesootros to set
	 */
	public void setIsaccesootros(Boolean isaccesootros) {
		this.isaccesootros = isaccesootros;
	}

	/**
	 * @return the isaccesotelefono
	 */
	public Boolean getIsaccesotelefono() {
		return isaccesotelefono;
	}

	/**
	 * @param isaccesotelefono
	 *            the isaccesotelefono to set
	 */
	public void setIsaccesotelefono(Boolean isaccesotelefono) {
		this.isaccesotelefono = isaccesotelefono;
	}

	/**
	 * @return the isaccesocelular
	 */
	public Boolean getIsaccesocelular() {
		return isaccesocelular;
	}

	/**
	 * @param isaccesocelular
	 *            the isaccesocelular to set
	 */
	public void setIsaccesocelular(Boolean isaccesocelular) {
		this.isaccesocelular = isaccesocelular;
	}

	/**
	 * @return the isaccesooficina
	 */
	public Boolean getIsaccesooficina() {
		return isaccesooficina;
	}

	/**
	 * @param isaccesooficina
	 *            the isaccesooficina to set
	 */
	public void setIsaccesooficina(Boolean isaccesooficina) {
		this.isaccesooficina = isaccesooficina;
	}

	/**
	 * @return the isaccesopc
	 */
	public Boolean getIsaccesopc() {
		return isaccesopc;
	}

	/**
	 * @param isaccesopc
	 *            the isaccesopc to set
	 */
	public void setIsaccesopc(Boolean isaccesopc) {
		this.isaccesopc = isaccesopc;
	}

	/**
	 * @return the isaccesootrossistemas
	 */
	public Boolean getIsaccesootrossistemas() {
		return isaccesootrossistemas;
	}

	/**
	 * @param isaccesootrossistemas
	 *            the isaccesootrossistemas to set
	 */
	public void setIsaccesootrossistemas(Boolean isaccesootrossistemas) {
		this.isaccesootrossistemas = isaccesootrossistemas;
	}

	/**
	 * @return the acceso_otrossistemascomentario
	 */
	public String getAcceso_otrossistemascomentario() {
		return acceso_otrossistemascomentario;
	}

	/**
	 * @param acceso_otrossistemascomentario
	 *            the acceso_otrossistemascomentario to set
	 */
	public void setAcceso_otrossistemascomentario(String acceso_otrossistemascomentario) {
		this.acceso_otrossistemascomentario = acceso_otrossistemascomentario;
	}

	/**
	 * @return the empleadoresponsable
	 */
	public BigDecimal getEmpleadoresponsable() {
		return empleadoresponsable;
	}

	/**
	 * @param empleadoresponsable
	 *            the empleadoresponsable to set
	 */
	public void setEmpleadoresponsable(BigDecimal empleadoresponsable) {
		this.empleadoresponsable = empleadoresponsable;
	}

	/**
	 * @return the isaccesomobiliario
	 */
	public Boolean getIsaccesomobiliario() {
		return isaccesomobiliario;
	}

	/**
	 * @param isaccesomobiliario
	 *            the isaccesomobiliario to set
	 */
	public void setIsaccesomobiliario(Boolean isaccesomobiliario) {
		this.isaccesomobiliario = isaccesomobiliario;
	}

	/**
	 * @return the isaccesopuntoelectrico
	 */
	public Boolean getIsaccesopuntoelectrico() {
		return isaccesopuntoelectrico;
	}

	/**
	 * @param isaccesopuntoelectrico
	 *            the isaccesopuntoelectrico to set
	 */
	public void setIsaccesopuntoelectrico(Boolean isaccesopuntoelectrico) {
		this.isaccesopuntoelectrico = isaccesopuntoelectrico;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the rutasustento
	 */
	public String getRutasustento() {
		return rutasustento;
	}

	/**
	 * @param rutasustento
	 *            the rutasustento to set
	 */
	public void setRutasustento(String rutasustento) {
		this.rutasustento = rutasustento;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	/**
	 * @return the flagtipocontrato
	 */
	public String getFlagtipocontrato() {
		return flagtipocontrato;
	}

	/**
	 * @param flagtipocontrato
	 *            the flagtipocontrato to set
	 */
	public void setFlagtipocontrato(String flagtipocontrato) {
		this.flagtipocontrato = flagtipocontrato;
	}

	/**
	 * @return the tipotrabajadornombre
	 */
	public String getTipotrabajadornombre() {
		return tipotrabajadornombre;
	}

	/**
	 * @param tipotrabajadornombre
	 *            the tipotrabajadornombre to set
	 */
	public void setTipotrabajadornombre(String tipotrabajadornombre) {
		this.tipotrabajadornombre = tipotrabajadornombre;
	}

	/**
	 * @return the centrocostonombre
	 */
	public String getCentrocostonombre() {
		return centrocostonombre;
	}

	/**
	 * @param centrocostonombre
	 *            the centrocostonombre to set
	 */
	public void setCentrocostonombre(String centrocostonombre) {
		this.centrocostonombre = centrocostonombre;
	}

	/**
	 * @return the numerosolicitud
	 */
	public String getNumerosolicitud() {
		return numerosolicitud;
	}

	/**
	 * @param numerosolicitud
	 *            the numerosolicitud to set
	 */
	public void setNumerosolicitud(String numerosolicitud) {
		this.numerosolicitud = numerosolicitud;
	}

	/**
	 * @return the nivelaprobacion
	 */
	public BigDecimal getNivelaprobacion() {
		return nivelaprobacion;
	}

	/**
	 * @param nivelaprobacion
	 *            the nivelaprobacion to set
	 */
	public void setNivelaprobacion(BigDecimal nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}

	/**
	 * @return the codigoproceso
	 */
	public String getCodigoproceso() {
		return codigoproceso;
	}

	/**
	 * @param codigoproceso
	 *            the codigoproceso to set
	 */
	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}

	/**
	 * @return the numeroproceso
	 */
	public BigDecimal getNumeroproceso() {
		return numeroproceso;
	}

	/**
	 * @param numeroproceso
	 *            the numeroproceso to set
	 */
	public void setNumeroproceso(BigDecimal numeroproceso) {
		this.numeroproceso = numeroproceso;
	}

	/**
	 * @return the accesocorreo
	 */
	public String getAccesocorreo() {
		return accesocorreo;
	}

	/**
	 * @param accesocorreo
	 *            the accesocorreo to set
	 */
	public void setAccesocorreo(String accesocorreo) {
		setIsaccesocorreo(obtenerBoolean(accesocorreo));
		this.accesocorreo = accesocorreo;
	}

	/**
	 * @return the accesointernet
	 */
	public String getAccesointernet() {
		return accesointernet;
	}

	/**
	 * @param accesointernet
	 *            the accesointernet to set
	 */
	public void setAccesointernet(String accesointernet) {
		setIsaccesointernet(obtenerBoolean(accesointernet));
		this.accesointernet = accesointernet;
	}

	/**
	 * @return the accesosii
	 */
	public String getAccesosii() {
		return accesosii;
	}

	/**
	 * @param accesosii
	 *            the accesosii to set
	 */
	public void setAccesosii(String accesosii) {
		setIsaccesosii(obtenerBoolean(accesosii));
		this.accesosii = accesosii;
	}

	/**
	 * @return the accesootros
	 */
	public String getAccesootros() {
		return accesootros;
	}

	/**
	 * @param accesootros
	 *            the accesootros to set
	 */
	public void setAccesootros(String accesootros) {
		setIsaccesootros(obtenerBoolean(accesootros));
		this.accesootros = accesootros;
	}

	/**
	 * @return the accesotelefono
	 */
	public String getAccesotelefono() {
		return accesotelefono;
	}

	/**
	 * @param accesotelefono
	 *            the accesotelefono to set
	 */
	public void setAccesotelefono(String accesotelefono) {
		setIsaccesotelefono(obtenerBoolean(accesotelefono));
		this.accesotelefono = accesotelefono;
	}

	/**
	 * @return the accesocelular
	 */
	public String getAccesocelular() {
		return accesocelular;
	}

	/**
	 * @param accesocelular
	 *            the accesocelular to set
	 */
	public void setAccesocelular(String accesocelular) {
		setIsaccesocelular(obtenerBoolean(accesocelular));
		this.accesocelular = accesocelular;
	}

	/**
	 * @return the accesooficina
	 */
	public String getAccesooficina() {
		return accesooficina;
	}

	/**
	 * @param accesooficina
	 *            the accesooficina to set
	 */
	public void setAccesooficina(String accesooficina) {
		setIsaccesooficina(obtenerBoolean(accesooficina));
		this.accesooficina = accesooficina;
	}

	/**
	 * @return the accesopc
	 */
	public String getAccesopc() {
		return accesopc;
	}

	/**
	 * @param accesopc
	 *            the accesopc to set
	 */
	public void setAccesopc(String accesopc) {
		setIsaccesopc(obtenerBoolean(accesopc));
		this.accesopc = accesopc;
	}

	/**
	 * @return the accesootrossistemas
	 */
	public String getAccesootrossistemas() {
		return accesootrossistemas;
	}

	/**
	 * @param accesootrossistemas
	 *            the accesootrossistemas to set
	 */
	public void setAccesootrossistemas(String accesootrossistemas) {
		setIsaccesootrossistemas(obtenerBoolean(accesootrossistemas));
		this.accesootrossistemas = accesootrossistemas;
	}

	/**
	 * @return the accesomobiliario
	 */
	public String getAccesomobiliario() {
		return accesomobiliario;
	}

	/**
	 * @param accesomobiliario
	 *            the accesomobiliario to set
	 */
	public void setAccesomobiliario(String accesomobiliario) {
		this.accesomobiliario = accesomobiliario;
	}

	/**
	 * @return the accesopuntoelectronico
	 */
	public String getAccesopuntoelectronico() {
		return accesopuntoelectronico;
	}

	/**
	 * @param accesopuntoelectronico
	 *            the accesopuntoelectronico to set
	 */
	public void setAccesopuntoelectronico(String accesopuntoelectronico) {
		this.accesopuntoelectronico = accesopuntoelectronico;
	}

	private Boolean obtenerBoolean(String flag) {
		if (UValidador.esNulo(flag)) {
			return false;
		}

		if (flag.equals("N")) {
			return false;
		}

		return true;
	}

	public String getTiporequerimiento() {
		return tiporequerimiento;
	}

	public void setTiporequerimiento(String tiporequerimiento) {
		this.tiporequerimiento = tiporequerimiento;
	}

	public String getUuidalfresco() {
		return uuidalfresco;
	}

	public void setUuidalfresco(String uuidalfresco) {
		this.uuidalfresco = uuidalfresco;
	}

	public String getReferenciafiscal01() {
		return referenciafiscal01;
	}

	public void setReferenciafiscal01(String referenciafiscal01) {
		this.referenciafiscal01 = referenciafiscal01;
	}

	public BigDecimal getProceso() {
		return proceso;
	}

	public void setProceso(BigDecimal proceso) {
		this.proceso = proceso;
	}

	public BigDecimal getMesesprueba() {
		return mesesprueba;
	}

	public void setMesesprueba(BigDecimal mesesprueba) {
		this.mesesprueba = mesesprueba;
	}

	public String getDescripcionposicion() {
		return descripcionposicion;
	}

	public void setDescripcionposicion(String descripcionposicion) {
		this.descripcionposicion = descripcionposicion;
	}

	public String getFuentefinanciamiento() {
		return fuentefinanciamiento;
	}

	public void setFuentefinanciamiento(String fuentefinanciamiento) {
		this.fuentefinanciamiento = fuentefinanciamiento;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getXdigitalperpuestohrlsc() {
		return xdigitalperpuestohrlsc;
	}

	public void setXdigitalperpuestohrlsc(String xdigitalperpuestohrlsc) {
		this.xdigitalperpuestohrlsc = xdigitalperpuestohrlsc;
	}

	public String getXdescperpuestohrlsc() {
		return xdescperpuestohrlsc;
	}

	public void setXdescperpuestohrlsc(String xdescperpuestohrlsc) {
		this.xdescperpuestohrlsc = xdescperpuestohrlsc;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
