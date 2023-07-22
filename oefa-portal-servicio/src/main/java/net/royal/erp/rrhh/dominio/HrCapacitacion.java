package net.royal.erp.rrhh.dominio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.util.Date;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCapacitacion
 */
public class HrCapacitacion extends DominioGenerico implements java.io.Serializable {

	private HrCapacitacionPk pk;
	private Integer numerovacantes;
	private Integer curso;
	private String nombregrupo;
	private String flaghorarioindividual;
	private String descripcion;
	private java.math.BigDecimal costosubtotal;
	private java.math.BigDecimal costototal;
	private java.math.BigDecimal costototalext;
	private java.math.BigDecimal costosubtotalext;
	private java.math.BigDecimal costoimpuestosext;
	private java.math.BigDecimal costoimpuestos;
	private String estado;
	private String proyecto;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private java.util.Date horadesde;
	private java.util.Date horahasta;
	private String periodoinicial;
	private String periodofinal;
	private String unidadnegocio;
	private Integer centrocapacitacion;
	private Integer numeroparticipantes;
	private Integer totaldias;
	private Integer totalhoras;
	private String logisticatipocompromiso;
	private String logisticanumerocompromiso;
	private String flaglogistica;
	private String tipocurso;
	private String aula;
	private String expositor;
	private Integer plancapacitacion;
	private String lugarcapacitacion;
	private Integer solicitante;
	private String cursodescripcion;
	private String fundamentacion1;
	private String fundamentacion2;
	private String fundamentacion3;
	private java.math.BigDecimal costototalestimadolocal;
	private java.math.BigDecimal costototalestimadoextranjero;
	private java.math.BigDecimal costounitariolocal;
	private java.math.BigDecimal costounitarioextranjero;
	private String fundamentacion4;
	private String fundamentacion5;
	private String fundamentacion6;
	private String fundamentacion7;
	private String fundamentacion8;
	private String fundamentacion9;
	private String fundamentacion10;
	private String telefonocontacto;
	private Integer empleado;
	private java.math.BigDecimal montomaxasumido;
	private java.math.BigDecimal montoasumido;
	private String modalidad;
	private String grupoocupacional;
	private String ano;
	private Integer capacitador;
	private String tipo;
	private String financiamiento;
	private String becas;
	private java.math.BigDecimal beneftotlocal;
	private java.math.BigDecimal beneftotextranjero;
	private Integer anioplan;
	private java.util.Date fechasolicitud;
	private String nombrecapacitador;
	private String centrocosto;
	private String afe;
	private Integer prioridad;
	private String moneda;
	private java.math.BigDecimal porcentajeempresa;
	private java.math.BigDecimal porcentajeempleado;
	private String indsustento1;
	private String indsustento2;
	private Integer dia;
	private Integer idtransaccion;
	private String departamento;
	private Integer empleadosolicitante;
	private String flagevaluacion;
	private String flagprogramado;
	private Integer codigounidad;
	private Integer jefeunidad;
	private Integer tipocambio;
	private Integer codigounidadsolicitante;
	private String requisicionnumero;
	private String motivoRechazo;
	private Integer presupuesto;
	private String areatematica;
	private String documento;
	private String tipoexpositor;
	private String esplan;
	private String estadologistica;
	private String referencia;
	private String demanda;
	private java.math.BigDecimal porcentajeempresacap;
	private java.util.Date fechafincapacitacion;
	private Integer secuenciaDnc;
	private String flagcursonuevo;
	private String cursonuevo;
	private String codigoproceso;
	private Integer numeroproceso;
	private Integer nivelaprobacion;
	private String flaginscripcionpublica;
	private Date fechadesdeinscripcion;
	private Date fechahastainscripcion;

	// aux's
	private String auxpkcapacitacion;
	private String auxpkcompanyowner;
	private String auxcentrocapacitacion;
	private byte[] archivo;
	private String nombrearchivo;
	private String extension;
	private String auxTipoCapacitacion;
	private String auxTipoRegistro;
	private String auxTiempoPermanencia;
	private String totalhorasAux;
	private String auxAreaTematica;
	
	private BigDecimal ROWNUM_;
	
	
	
	private StreamedContent descarga;
	
	public StreamedContent getDescarga() {
		if (!UValidador.esNulo(archivo))
			try {
				descarga = new DefaultStreamedContent(
						new ByteArrayInputStream(archivo),
						URLConnection
								.guessContentTypeFromStream(new ByteArrayInputStream(
										archivo)), nombrearchivo + "."
								+ extension);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		return descarga;
	}

	public HrCapacitacion() {
		pk = new HrCapacitacionPk();
	}

	public HrCapacitacionPk getPk() {
		return pk;
	}

	public void setPk(HrCapacitacionPk pk) {
		this.pk = pk;
	}

	public Integer getNumerovacantes() {
		return numerovacantes;
	}

	public void setNumerovacantes(Object numerovacantes) {
		if (!UValidador.esNulo(numerovacantes)) {
			if (numerovacantes instanceof Integer) {
				this.numerovacantes = Integer.parseInt(numerovacantes.toString());
			} else if (numerovacantes instanceof BigDecimal) {
				this.numerovacantes = new BigDecimal(numerovacantes.toString()).intValue();
			}
		} else {
			this.numerovacantes = null;
		}

	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public String getNombregrupo() {
		return nombregrupo;
	}

	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}

	public String getFlaghorarioindividual() {
		return flaghorarioindividual;
	}

	public void setFlaghorarioindividual(String flaghorarioindividual) {
		this.flaghorarioindividual = flaghorarioindividual;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public java.math.BigDecimal getCostosubtotal() {
		return costosubtotal;
	}

	public void setCostosubtotal(java.math.BigDecimal costosubtotal) {
		this.costosubtotal = costosubtotal;
	}

	public java.math.BigDecimal getCostototal() {
		return costototal;
	}

	public void setCostototal(java.math.BigDecimal costototal) {
		this.costototal = costototal;
	}

	public java.math.BigDecimal getCostototalext() {
		return costototalext;
	}

	public void setCostototalext(java.math.BigDecimal costototalext) {
		this.costototalext = costototalext;
	}

	public java.math.BigDecimal getCostosubtotalext() {
		return costosubtotalext;
	}

	public void setCostosubtotalext(java.math.BigDecimal costosubtotalext) {
		this.costosubtotalext = costosubtotalext;
	}

	public java.math.BigDecimal getCostoimpuestosext() {
		return costoimpuestosext;
	}

	public void setCostoimpuestosext(java.math.BigDecimal costoimpuestosext) {
		this.costoimpuestosext = costoimpuestosext;
	}

	public java.math.BigDecimal getCostoimpuestos() {
		return costoimpuestos;
	}

	public void setCostoimpuestos(java.math.BigDecimal costoimpuestos) {
		this.costoimpuestos = costoimpuestos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public java.util.Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(java.util.Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public java.util.Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(java.util.Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public java.util.Date getHoradesde() {
		return horadesde;
	}

	public void setHoradesde(java.util.Date horadesde) {
		this.horadesde = horadesde;
	}

	public java.util.Date getHorahasta() {
		return horahasta;
	}

	public void setHorahasta(java.util.Date horahasta) {
		this.horahasta = horahasta;
	}

	public String getPeriodoinicial() {
		return periodoinicial;
	}

	public void setPeriodoinicial(String periodoinicial) {
		this.periodoinicial = periodoinicial;
	}

	public String getPeriodofinal() {
		return periodofinal;
	}

	public void setPeriodofinal(String periodofinal) {
		this.periodofinal = periodofinal;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public Integer getCentrocapacitacion() {
		return centrocapacitacion;
	}

	public void setCentrocapacitacion(Integer centrocapacitacion) {
		this.centrocapacitacion = centrocapacitacion;
	}

	public Integer getNumeroparticipantes() {
		return numeroparticipantes;
	}

	public void setNumeroparticipantes(Integer numeroparticipantes) {
		this.numeroparticipantes = numeroparticipantes;
	}

	public Integer getTotaldias() {
		return totaldias;
	}

	public void setTotaldias(Integer totaldias) {
		this.totaldias = totaldias;
	}

	public Integer getTotalhoras() {
		return totalhoras;
	}

	public void setTotalhoras(Integer totalhoras) {
		this.totalhoras = totalhoras;
	}

	public String getLogisticatipocompromiso() {
		return logisticatipocompromiso;
	}

	public void setLogisticatipocompromiso(String logisticatipocompromiso) {
		this.logisticatipocompromiso = logisticatipocompromiso;
	}

	public String getLogisticanumerocompromiso() {
		return logisticanumerocompromiso;
	}

	public void setLogisticanumerocompromiso(String logisticanumerocompromiso) {
		this.logisticanumerocompromiso = logisticanumerocompromiso;
	}

	public String getFlaglogistica() {
		return flaglogistica;
	}

	public void setFlaglogistica(String flaglogistica) {
		this.flaglogistica = flaglogistica;
	}

	public String getTipocurso() {
		return tipocurso;
	}

	public void setTipocurso(String tipocurso) {
		this.tipocurso = tipocurso;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getExpositor() {
		return expositor;
	}

	public void setExpositor(String expositor) {
		this.expositor = expositor;
	}

	public Integer getPlancapacitacion() {
		return plancapacitacion;
	}

	public void setPlancapacitacion(Integer plancapacitacion) {
		this.plancapacitacion = plancapacitacion;
	}

	public String getLugarcapacitacion() {
		return lugarcapacitacion;
	}

	public void setLugarcapacitacion(String lugarcapacitacion) {
		this.lugarcapacitacion = lugarcapacitacion;
	}

	public Integer getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Integer solicitante) {
		this.solicitante = solicitante;
	}

	public String getCursodescripcion() {
		return cursodescripcion;
	}

	public void setCursodescripcion(String cursodescripcion) {
		this.cursodescripcion = cursodescripcion;
	}

	public String getFundamentacion1() {
		return fundamentacion1;
	}

	public void setFundamentacion1(String fundamentacion1) {
		this.fundamentacion1 = fundamentacion1;
	}

	public String getFundamentacion2() {
		return fundamentacion2;
	}

	public void setFundamentacion2(String fundamentacion2) {
		this.fundamentacion2 = fundamentacion2;
	}

	public String getFundamentacion3() {
		return fundamentacion3;
	}

	public void setFundamentacion3(String fundamentacion3) {
		this.fundamentacion3 = fundamentacion3;
	}

	public java.math.BigDecimal getCostototalestimadolocal() {
		return costototalestimadolocal;
	}

	public void setCostototalestimadolocal(java.math.BigDecimal costototalestimadolocal) {
		this.costototalestimadolocal = costototalestimadolocal;
	}

	public java.math.BigDecimal getCostototalestimadoextranjero() {
		return costototalestimadoextranjero;
	}

	public void setCostototalestimadoextranjero(java.math.BigDecimal costototalestimadoextranjero) {
		this.costototalestimadoextranjero = costototalestimadoextranjero;
	}

	public java.math.BigDecimal getCostounitariolocal() {
		return costounitariolocal;
	}

	public void setCostounitariolocal(java.math.BigDecimal costounitariolocal) {
		this.costounitariolocal = costounitariolocal;
	}

	public java.math.BigDecimal getCostounitarioextranjero() {
		return costounitarioextranjero;
	}

	public void setCostounitarioextranjero(java.math.BigDecimal costounitarioextranjero) {
		this.costounitarioextranjero = costounitarioextranjero;
	}

	public String getFundamentacion4() {
		return fundamentacion4;
	}

	public void setFundamentacion4(String fundamentacion4) {
		this.fundamentacion4 = fundamentacion4;
	}

	public String getFundamentacion5() {
		return fundamentacion5;
	}

	public void setFundamentacion5(String fundamentacion5) {
		this.fundamentacion5 = fundamentacion5;
	}

	public String getFundamentacion6() {
		return fundamentacion6;
	}

	public void setFundamentacion6(String fundamentacion6) {
		this.fundamentacion6 = fundamentacion6;
	}

	public String getFundamentacion7() {
		return fundamentacion7;
	}

	public void setFundamentacion7(String fundamentacion7) {
		this.fundamentacion7 = fundamentacion7;
	}

	public String getFundamentacion8() {
		return fundamentacion8;
	}

	public void setFundamentacion8(String fundamentacion8) {
		this.fundamentacion8 = fundamentacion8;
	}

	public String getFundamentacion9() {
		return fundamentacion9;
	}

	public void setFundamentacion9(String fundamentacion9) {
		this.fundamentacion9 = fundamentacion9;
	}

	public String getFundamentacion10() {
		return fundamentacion10;
	}

	public void setFundamentacion10(String fundamentacion10) {
		this.fundamentacion10 = fundamentacion10;
	}

	public String getTelefonocontacto() {
		return telefonocontacto;
	}

	public void setTelefonocontacto(String telefonocontacto) {
		this.telefonocontacto = telefonocontacto;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public java.math.BigDecimal getMontomaxasumido() {
		return montomaxasumido;
	}

	public void setMontomaxasumido(java.math.BigDecimal montomaxasumido) {
		this.montomaxasumido = montomaxasumido;
	}

	public java.math.BigDecimal getMontoasumido() {
		return montoasumido;
	}

	public void setMontoasumido(java.math.BigDecimal montoasumido) {
		this.montoasumido = montoasumido;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getGrupoocupacional() {
		return grupoocupacional;
	}

	public void setGrupoocupacional(String grupoocupacional) {
		this.grupoocupacional = grupoocupacional;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getCapacitador() {
		return capacitador;
	}

	public void setCapacitador(Integer capacitador) {
		this.capacitador = capacitador;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFinanciamiento() {
		return financiamiento;
	}

	public void setFinanciamiento(String financiamiento) {
		this.financiamiento = financiamiento;
	}

	public String getBecas() {
		return becas;
	}

	public void setBecas(String becas) {
		this.becas = becas;
	}

	public java.math.BigDecimal getBeneftotlocal() {
		return beneftotlocal;
	}

	public void setBeneftotlocal(java.math.BigDecimal beneftotlocal) {
		this.beneftotlocal = beneftotlocal;
	}

	public java.math.BigDecimal getBeneftotextranjero() {
		return beneftotextranjero;
	}

	public void setBeneftotextranjero(java.math.BigDecimal beneftotextranjero) {
		this.beneftotextranjero = beneftotextranjero;
	}

	public Integer getAnioplan() {
		return anioplan;
	}

	public void setAnioplan(Integer anioplan) {
		this.anioplan = anioplan;
	}

	public java.util.Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(java.util.Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public String getNombrecapacitador() {
		return nombrecapacitador;
	}

	public void setNombrecapacitador(String nombrecapacitador) {
		this.nombrecapacitador = nombrecapacitador;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public java.math.BigDecimal getPorcentajeempresa() {
		return porcentajeempresa;
	}

	public void setPorcentajeempresa(java.math.BigDecimal porcentajeempresa) {
		this.porcentajeempresa = porcentajeempresa;
	}

	public java.math.BigDecimal getPorcentajeempleado() {
		return porcentajeempleado;
	}

	public void setPorcentajeempleado(java.math.BigDecimal porcentajeempleado) {
		this.porcentajeempleado = porcentajeempleado;
	}

	public String getIndsustento1() {
		return indsustento1;
	}

	public void setIndsustento1(String indsustento1) {
		this.indsustento1 = indsustento1;
	}

	public String getIndsustento2() {
		return indsustento2;
	}

	public void setIndsustento2(String indsustento2) {
		this.indsustento2 = indsustento2;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getIdtransaccion() {
		return idtransaccion;
	}

	public void setIdtransaccion(Integer idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Integer getEmpleadosolicitante() {
		return empleadosolicitante;
	}

	public void setEmpleadosolicitante(Integer empleadosolicitante) {
		this.empleadosolicitante = empleadosolicitante;
	}

	public String getFlagevaluacion() {
		return flagevaluacion;
	}

	public void setFlagevaluacion(String flagevaluacion) {
		this.flagevaluacion = flagevaluacion;
	}

	public String getFlagprogramado() {
		return flagprogramado;
	}

	public void setFlagprogramado(String flagprogramado) {
		this.flagprogramado = flagprogramado;
	}

	public Integer getCodigounidad() {
		return codigounidad;
	}

	public void setCodigounidad(Integer codigounidad) {
		this.codigounidad = codigounidad;
	}

	public Integer getJefeunidad() {
		return jefeunidad;
	}

	public void setJefeunidad(Integer jefeunidad) {
		this.jefeunidad = jefeunidad;
	}

	public Integer getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(Integer tipocambio) {
		this.tipocambio = tipocambio;
	}

	public Integer getCodigounidadsolicitante() {
		return codigounidadsolicitante;
	}

	public void setCodigounidadsolicitante(Integer codigounidadsolicitante) {
		this.codigounidadsolicitante = codigounidadsolicitante;
	}

	public String getRequisicionnumero() {
		return requisicionnumero;
	}

	public void setRequisicionnumero(String requisicionnumero) {
		this.requisicionnumero = requisicionnumero;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getAreatematica() {
		return areatematica;
	}

	public void setAreatematica(String areatematica) {
		this.areatematica = areatematica;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoexpositor() {
		return tipoexpositor;
	}

	public void setTipoexpositor(String tipoexpositor) {
		this.tipoexpositor = tipoexpositor;
	}

	public String getEsplan() {
		return esplan;
	}

	public void setEsplan(String esplan) {
		this.esplan = esplan;
	}

	public String getEstadologistica() {
		return estadologistica;
	}

	public void setEstadologistica(String estadologistica) {
		this.estadologistica = estadologistica;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDemanda() {
		return demanda;
	}

	public void setDemanda(String demanda) {
		this.demanda = demanda;
	}

	public java.math.BigDecimal getPorcentajeempresacap() {
		return porcentajeempresacap;
	}

	public void setPorcentajeempresacap(java.math.BigDecimal porcentajeempresacap) {
		this.porcentajeempresacap = porcentajeempresacap;
	}

	public java.util.Date getFechafincapacitacion() {
		return fechafincapacitacion;
	}

	public void setFechafincapacitacion(java.util.Date fechafincapacitacion) {
		this.fechafincapacitacion = fechafincapacitacion;
	}

	public Integer getSecuenciaDnc() {
		return secuenciaDnc;
	}

	public void setSecuenciaDnc(Integer secuenciaDnc) {
		this.secuenciaDnc = secuenciaDnc;
	}

	public String getFlagcursonuevo() {
		return flagcursonuevo;
	}

	public void setFlagcursonuevo(String flagcursonuevo) {
		this.flagcursonuevo = flagcursonuevo;
	}

	public String getCursonuevo() {
		return cursonuevo;
	}

	public void setCursonuevo(String cursonuevo) {
		this.cursonuevo = cursonuevo;
	}

	public String getCodigoproceso() {
		return codigoproceso;
	}

	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}

	public Integer getNumeroproceso() {
		return numeroproceso;
	}

	public void setNumeroproceso(Integer numeroproceso) {
		this.numeroproceso = numeroproceso;
	}

	public Integer getNivelaprobacion() {
		return nivelaprobacion;
	}

	public void setNivelaprobacion(Integer nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}

	public String getFlaginscripcionpublica() {
		return flaginscripcionpublica;
	}

	public void setFlaginscripcionpublica(String flaginscripcionpublica) {
		this.flaginscripcionpublica = flaginscripcionpublica;
	}

	public Date getFechadesdeinscripcion() {
		return fechadesdeinscripcion;
	}

	public void setFechadesdeinscripcion(Date fechadesdeinscripcion) {
		this.fechadesdeinscripcion = fechadesdeinscripcion;
	}

	public Date getFechahastainscripcion() {
		return fechahastainscripcion;
	}

	public void setFechahastainscripcion(Date fechahastainscripcion) {
		this.fechahastainscripcion = fechahastainscripcion;
	}

	public String getAuxpkcapacitacion() {
		return auxpkcapacitacion;
	}

	public void setAuxpkcapacitacion(String auxpkcapacitacion) {
		if (UValidador.esNulo(pk))
			pk = new HrCapacitacionPk();
		pk.setCapacitacion(auxpkcapacitacion);
		this.auxpkcapacitacion = auxpkcapacitacion;
	}

	public String getAuxpkcompanyowner() {
		return auxpkcompanyowner;
	}

	public void setAuxpkcompanyowner(String auxpkcompanyowner) {
		if (UValidador.esNulo(pk))
			pk = new HrCapacitacionPk();
		pk.setCompanyowner(auxpkcompanyowner);
		this.auxpkcompanyowner = auxpkcompanyowner;
	}

	public String getAuxcentrocapacitacion() {
		return auxcentrocapacitacion;
	}

	public void setAuxcentrocapacitacion(String auxcentrocapacitacion) {
		this.auxcentrocapacitacion = auxcentrocapacitacion;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public void setDescarga(StreamedContent descarga) {
		this.descarga = descarga;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}

	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}

	public String getAuxTipoCapacitacion() {
		return auxTipoCapacitacion;
	}

	public void setAuxTipoCapacitacion(String auxTipoCapacitacion) {
		this.auxTipoCapacitacion = auxTipoCapacitacion;
	}

	public String getAuxTipoRegistro() {
		return auxTipoRegistro;
	}

	public void setAuxTipoRegistro(String auxTipoRegistro) {
		this.auxTipoRegistro = auxTipoRegistro;
	}

	public String getAuxTiempoPermanencia() {
		return auxTiempoPermanencia;
	}

	public void setAuxTiempoPermanencia(String auxTiempoPermanencia) {
		this.auxTiempoPermanencia = auxTiempoPermanencia;
	}

	public String getTotalhorasAux() {
		return totalhorasAux;
	}

	public void setTotalhorasAux(String totalhorasAux) {
		this.totalhorasAux = totalhorasAux;
	}

	public String getAuxAreaTematica() {
		return auxAreaTematica;
	}

	public void setAuxAreaTematica(String auxAreaTematica) {
		this.auxAreaTematica = auxAreaTematica;
	}

	public void setNumerovacantes(Integer numerovacantes) {
		this.numerovacantes = numerovacantes;
	}

}
