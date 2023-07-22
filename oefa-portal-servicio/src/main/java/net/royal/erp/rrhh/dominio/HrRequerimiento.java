package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimiento
 */
public class HrRequerimiento extends DominioGenerico implements java.io.Serializable {

	private HrRequerimientoPk pk;
	private String requerimientonumero;
	private String unidadreplicacion;
	private Integer empleadosolicitante;
	private Integer codigoposicionsolicitante;
	private Integer codigopuesto;
	private java.util.Date fechasolicitud;
	private String motivo;
	private String tipocontrato;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private String perfiladicional;
	private String unidadnegocio;
	private Integer numerosolicitado;
	private Integer numeropendiente;
	private String motivotermino;
	private String estado;
	private String afe;
	private String gradosalario;
	private String centrocosto;
	private java.util.Date fechafinrequerimiento;
	private BigDecimal remuneracionreferencialbruto;
	private BigDecimal remuneracionreferencialneto;
	private String correoelectronico;
	private String flagtarjetapersonal;
	private String grupocorreoelectronico;
	private String flagaccesointernet;
	private String tipotrabajador;
	private String tipoplanilla;
	private Integer tipohorario;
	private String deptoorganizacion;
	private Integer idsolicitud;
	private String disphorariodia;
	private String disphorariohoraflag;
	private String dispviajetipo;
	private String dispviajelugarflag;
	private String dispviajelugar;
	private String disphorariohora;
	private String tipopersonalrequerido;
	private String estudios;
	private String experiencia;
	private String conocimiento;
	private String habilidad;
	private String observacionmotivo;
	private String funciones;
	private String anioexperiencia;
	private String profesion1;
	private String profesion2;
	private String nivellectura;
	private String niveloral;
	private String nivelescritura;
	private String nivelgeneral;
	private Integer idtransaccion;
	private String tipoturno;
	private Integer empleadoreemplazado;
	private String condicioneseconomicas;
	private Integer codPlazageneral;
	private String flagpresupuestado;
	private Integer sueldobasico;
	private String numerosolicitud;
	private String horarioext;
	private String estadoweb;
	private Integer tipolabor;
	private Integer horassemanales;
	private String categoria;
	private Integer codigojefe;
	private String accesoCorreo;
	private String accesoInternet;
	private String accesoSii;
	private String accesoOtros;
	private String accesoTelefono;
	private String accesoCelular;
	private String accesoOficina;
	private String accesoPc;
	private String accesoOtrossistemas;
	private String accesoOtrossistemascomentario;
	private String observaciones;
	private String incrementocomentario;
	private String lineacarrera;
	private String accesoOtroscomentario;
	private String clasificacion;
	private Integer tiporeclutamiento;
	private Integer codigopuestosolicitante;
	private String lineacarrera2;
	private String desnuevocurso;
	private Integer codigopuestonuevo;
	private String numeroconcurso;
	private Integer nivelservicio;
	private String certificacionnumero;
	private String compromisonumero;
	private BigDecimal montoapagar;
	private String motivorechazo;
	private java.util.Date fechalimite;
	private java.util.Date fecharesultado;
	private String convocatoria;
	private Integer concurso;
	private java.util.Date fechaenvio;
	private String sucursal;
	private String flagdesierto;
	private String motivodesierto;
	private java.util.Date fechaconvocatoria;
	private String codigoproceso;
	private BigDecimal numeroproceso;
	private Integer nivelaprobacion;
	private byte[] sustento;
	private String rutasustento;
	private String ruta;
	private String flagtipocontrato;
	private String tiporequermiento;
	private String uuidalfresco;
	private String referenciafiscal01;
	private BigDecimal proceso;
	private BigDecimal mesesprueba;
	private String fuentefinanciamiento;
	private String temaevaluacionconocimiento;
	private String flagEnviado;
	private String descripcionpuestoinformativo;
	private String creacionUsuario;

	public String getCreacionUsuario() {
		return creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
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

	public HrRequerimiento() {
		pk = new HrRequerimientoPk();
	}

	public HrRequerimientoPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientoPk pk) {
		this.pk = pk;
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

	public Integer getEmpleadosolicitante() {
		return empleadosolicitante;
	}

	public void setEmpleadosolicitante(Integer empleadosolicitante) {
		this.empleadosolicitante = empleadosolicitante;
	}

	public Integer getCodigoposicionsolicitante() {
		return codigoposicionsolicitante;
	}

	public void setCodigoposicionsolicitante(Integer codigoposicionsolicitante) {
		this.codigoposicionsolicitante = codigoposicionsolicitante;
	}

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	public java.util.Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(java.util.Date fechasolicitud) {
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

	public Integer getNumerosolicitado() {
		return numerosolicitado;
	}

	public void setNumerosolicitado(Integer numerosolicitado) {
		this.numerosolicitado = numerosolicitado;
	}

	public Integer getNumeropendiente() {
		return numeropendiente;
	}

	public void setNumeropendiente(Integer numeropendiente) {
		this.numeropendiente = numeropendiente;
	}

	public String getMotivotermino() {
		return motivotermino;
	}

	public void setMotivotermino(String motivotermino) {
		this.motivotermino = motivotermino;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

	public String getGradosalario() {
		return gradosalario;
	}

	public void setGradosalario(String gradosalario) {
		this.gradosalario = gradosalario;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public java.util.Date getFechafinrequerimiento() {
		return fechafinrequerimiento;
	}

	public void setFechafinrequerimiento(java.util.Date fechafinrequerimiento) {
		this.fechafinrequerimiento = fechafinrequerimiento;
	}

	public BigDecimal getRemuneracionreferencialbruto() {
		return remuneracionreferencialbruto;
	}

	public void setRemuneracionreferencialbruto(BigDecimal remuneracionreferencialbruto) {
		this.remuneracionreferencialbruto = remuneracionreferencialbruto;
	}

	public BigDecimal getRemuneracionreferencialneto() {
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

	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public Integer getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(Integer tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getDeptoorganizacion() {
		return deptoorganizacion;
	}

	public void setDeptoorganizacion(String deptoorganizacion) {
		this.deptoorganizacion = deptoorganizacion;
	}

	public Integer getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(Integer idsolicitud) {
		this.idsolicitud = idsolicitud;
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

	public String getDisphorariohora() {
		return disphorariohora;
	}

	public void setDisphorariohora(String disphorariohora) {
		this.disphorariohora = disphorariohora;
	}

	public String getTipopersonalrequerido() {
		return tipopersonalrequerido;
	}

	public void setTipopersonalrequerido(String tipopersonalrequerido) {
		this.tipopersonalrequerido = tipopersonalrequerido;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getConocimiento() {
		return conocimiento;
	}

	public void setConocimiento(String conocimiento) {
		this.conocimiento = conocimiento;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public String getObservacionmotivo() {
		return observacionmotivo;
	}

	public void setObservacionmotivo(String observacionmotivo) {
		this.observacionmotivo = observacionmotivo;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	public String getAnioexperiencia() {
		return anioexperiencia;
	}

	public void setAnioexperiencia(String anioexperiencia) {
		this.anioexperiencia = anioexperiencia;
	}

	public String getProfesion1() {
		return profesion1;
	}

	public void setProfesion1(String profesion1) {
		this.profesion1 = profesion1;
	}

	public String getProfesion2() {
		return profesion2;
	}

	public void setProfesion2(String profesion2) {
		this.profesion2 = profesion2;
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

	public Integer getIdtransaccion() {
		return idtransaccion;
	}

	public void setIdtransaccion(Integer idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	public String getTipoturno() {
		return tipoturno;
	}

	public void setTipoturno(String tipoturno) {
		this.tipoturno = tipoturno;
	}

	public Integer getEmpleadoreemplazado() {
		return empleadoreemplazado;
	}

	public void setEmpleadoreemplazado(Integer empleadoreemplazado) {
		this.empleadoreemplazado = empleadoreemplazado;
	}

	public String getCondicioneseconomicas() {
		return condicioneseconomicas;
	}

	public void setCondicioneseconomicas(String condicioneseconomicas) {
		this.condicioneseconomicas = condicioneseconomicas;
	}

	public Integer getCodPlazageneral() {
		return codPlazageneral;
	}

	public void setCodPlazageneral(Integer codPlazageneral) {
		this.codPlazageneral = codPlazageneral;
	}

	public String getFlagpresupuestado() {
		return flagpresupuestado;
	}

	public void setFlagpresupuestado(String flagpresupuestado) {
		this.flagpresupuestado = flagpresupuestado;
	}

	public Integer getSueldobasico() {
		return sueldobasico;
	}

	public void setSueldobasico(Integer sueldobasico) {
		this.sueldobasico = sueldobasico;
	}

	public String getNumerosolicitud() {
		return numerosolicitud;
	}

	public void setNumerosolicitud(String numerosolicitud) {
		this.numerosolicitud = numerosolicitud;
	}

	public String getHorarioext() {
		return horarioext;
	}

	public void setHorarioext(String horarioext) {
		this.horarioext = horarioext;
	}

	public String getEstadoweb() {
		return estadoweb;
	}

	public void setEstadoweb(String estadoweb) {
		this.estadoweb = estadoweb;
	}

	public Integer getTipolabor() {
		return tipolabor;
	}

	public void setTipolabor(Integer tipolabor) {
		this.tipolabor = tipolabor;
	}

	public Integer getHorassemanales() {
		return horassemanales;
	}

	public void setHorassemanales(Integer horassemanales) {
		this.horassemanales = horassemanales;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCodigojefe() {
		return codigojefe;
	}

	public void setCodigojefe(Integer codigojefe) {
		this.codigojefe = codigojefe;
	}

	public String getAccesoCorreo() {
		return accesoCorreo;
	}

	public void setAccesoCorreo(String accesoCorreo) {
		this.accesoCorreo = accesoCorreo;
	}

	public String getAccesoInternet() {
		return accesoInternet;
	}

	public void setAccesoInternet(String accesoInternet) {
		this.accesoInternet = accesoInternet;
	}

	public String getAccesoSii() {
		return accesoSii;
	}

	public void setAccesoSii(String accesoSii) {
		this.accesoSii = accesoSii;
	}

	public String getAccesoOtros() {
		return accesoOtros;
	}

	public void setAccesoOtros(String accesoOtros) {
		this.accesoOtros = accesoOtros;
	}

	public String getAccesoTelefono() {
		return accesoTelefono;
	}

	public void setAccesoTelefono(String accesoTelefono) {
		this.accesoTelefono = accesoTelefono;
	}

	public String getAccesoCelular() {
		return accesoCelular;
	}

	public void setAccesoCelular(String accesoCelular) {
		this.accesoCelular = accesoCelular;
	}

	public String getAccesoOficina() {
		return accesoOficina;
	}

	public void setAccesoOficina(String accesoOficina) {
		this.accesoOficina = accesoOficina;
	}

	public String getAccesoPc() {
		return accesoPc;
	}

	public void setAccesoPc(String accesoPc) {
		this.accesoPc = accesoPc;
	}

	public String getAccesoOtrossistemas() {
		return accesoOtrossistemas;
	}

	public void setAccesoOtrossistemas(String accesoOtrossistemas) {
		this.accesoOtrossistemas = accesoOtrossistemas;
	}

	public String getAccesoOtrossistemascomentario() {
		return accesoOtrossistemascomentario;
	}

	public void setAccesoOtrossistemascomentario(String accesoOtrossistemascomentario) {
		this.accesoOtrossistemascomentario = accesoOtrossistemascomentario;
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

	public String getAccesoOtroscomentario() {
		return accesoOtroscomentario;
	}

	public void setAccesoOtroscomentario(String accesoOtroscomentario) {
		this.accesoOtroscomentario = accesoOtroscomentario;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Integer getTiporeclutamiento() {
		return tiporeclutamiento;
	}

	public void setTiporeclutamiento(Integer tiporeclutamiento) {
		this.tiporeclutamiento = tiporeclutamiento;
	}

	public Integer getCodigopuestosolicitante() {
		return codigopuestosolicitante;
	}

	public void setCodigopuestosolicitante(Integer codigopuestosolicitante) {
		this.codigopuestosolicitante = codigopuestosolicitante;
	}

	public String getLineacarrera2() {
		return lineacarrera2;
	}

	public void setLineacarrera2(String lineacarrera2) {
		this.lineacarrera2 = lineacarrera2;
	}

	public String getDesnuevocurso() {
		return desnuevocurso;
	}

	public void setDesnuevocurso(String desnuevocurso) {
		this.desnuevocurso = desnuevocurso;
	}

	public Integer getCodigopuestonuevo() {
		return codigopuestonuevo;
	}

	public void setCodigopuestonuevo(Integer codigopuestonuevo) {
		this.codigopuestonuevo = codigopuestonuevo;
	}

	public String getNumeroconcurso() {
		return numeroconcurso;
	}

	public void setNumeroconcurso(String numeroconcurso) {
		this.numeroconcurso = numeroconcurso;
	}

	public Integer getNivelservicio() {
		return nivelservicio;
	}

	public void setNivelservicio(Integer nivelservicio) {
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
		return montoapagar;
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

	public java.util.Date getFechalimite() {
		return fechalimite;
	}

	public void setFechalimite(java.util.Date fechalimite) {
		this.fechalimite = fechalimite;
	}

	public java.util.Date getFecharesultado() {
		return fecharesultado;
	}

	public void setFecharesultado(java.util.Date fecharesultado) {
		this.fecharesultado = fecharesultado;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Integer getConcurso() {
		return concurso;
	}

	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}

	public java.util.Date getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(java.util.Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getFlagdesierto() {
		return flagdesierto;
	}

	public void setFlagdesierto(String flagdesierto) {
		this.flagdesierto = flagdesierto;
	}

	public String getMotivodesierto() {
		return motivodesierto;
	}

	public void setMotivodesierto(String motivodesierto) {
		this.motivodesierto = motivodesierto;
	}

	public java.util.Date getFechaconvocatoria() {
		return fechaconvocatoria;
	}

	public void setFechaconvocatoria(java.util.Date fechaconvocatoria) {
		this.fechaconvocatoria = fechaconvocatoria;
	}

	public String getCodigoproceso() {
		return codigoproceso;
	}

	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}

	public BigDecimal getNumeroproceso() {
		return numeroproceso;
	}

	public void setNumeroproceso(BigDecimal numeroproceso) {
		this.numeroproceso = numeroproceso;
	}

	public Integer getNivelaprobacion() {
		return nivelaprobacion;
	}

	public void setNivelaprobacion(Integer nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}

	public byte[] getSustento() {
		return sustento;
	}

	public void setSustento(byte[] sustento) {
		this.sustento = sustento;
	}

	public String getRutasustento() {
		return rutasustento;
	}

	public void setRutasustento(String rutasustento) {
		this.rutasustento = rutasustento;
	}

	public String getFlagtipocontrato() {
		return flagtipocontrato;
	}

	public void setFlagtipocontrato(String flagtipocontrato) {
		this.flagtipocontrato = flagtipocontrato;
	}

	public String getTiporequermiento() {
		return tiporequermiento;
	}

	public void setTiporequermiento(String tiporequermiento) {
		this.tiporequermiento = tiporequermiento;
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

	public String getFuentefinanciamiento() {
		return fuentefinanciamiento;
	}

	public void setFuentefinanciamiento(String fuentefinanciamiento) {
		this.fuentefinanciamiento = fuentefinanciamiento;
	}

	public String getDescripcionpuestoinformativo() {
		return descripcionpuestoinformativo;
	}

	public void setDescripcionpuestoinformativo(String descripcionpuestoinformativo) {
		this.descripcionpuestoinformativo = descripcionpuestoinformativo;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
