package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuesta
 */
@SuppressWarnings("serial")
public class DtoHrPostulantes extends DominioGenerico implements java.io.Serializable {

	private String requerimiento;
	private String postulante;
	private BigDecimal postulantenumero;
	private String unidadreplicacion;
	private Integer service;
	private String apellidopaterno;
	private String apellidomaterno;
	private String nombres;
	private String departamento;
	private String provincia;
	private String pais;
	private java.util.Date fechanacimiento;
	private String sexo;
	private String direccion;
	private String distrito;
	private String telefono;
	private String tipodocumento;
	private String documento;
	private String libretaelectoral;
	private String libretamilitar;
	private String documentofiscal;
	private String tipobrevete;
	private String brevete;
	private String carnetasistenciasocial;
	private String carnetextranjeria;
	private BigDecimal peso;
	private BigDecimal talla;
	private String gruposanguineo;
	private String estadocivil;
	private java.util.Date fechaestadocivil;
	private String otroestadocivil;
	private String situaciondomicilio;
	private String otrosituaciondomicilio;
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
	private java.util.Date fecharegistroinicial;
	private String fuentereclutamiento;
	private String codigoauxiliar;
	private String direccionelectronica;
	private String estado;
	private String unidadnegocio;
	private Integer tipocalle;
	private String nombrecalle;
	private String numero;
	private String numdep;
	private String manzana;
	private String lote;
	private String interior;
	private String sector;
	private String urbanizacion;
	private String provinciadomicilio;
	private String objetivogeneral;
	private String departamentonacimiento;
	private String provincianacimiento;
	private String distritonacimiento;
	private String apellidocasada;
	private String lugarnacimiento;
	private String celularlocal;
	private String direccionextranjera;
	private String paisextranjero;
	private String departamentoextranjero;
	private String provinciaextranjera;
	private String codigopostalextranjero;
	private String telefonoextranjero;
	private String celularextranjero;
	private String nombreemergencia1;
	private String direccionemergencia1;
	private String telefonoemergencia1;
	private String celularemergencia1;
	private String parentescoemergencia1;
	private String nombreemergencia2;
	private String direccionemergencia2;
	private String telefonoemergencia2;
	private String celularemergencia2;
	private String parentescoemergencia2;
	private String companyowner;
	private String referencia;
	private String clave;
	private String raza;
	private String religion;
	private java.util.Date licenciaconducirfecha;
	private String poseeauto;
	private BigDecimal montobruto;
	private String numeroconcurso;
	private byte[] foto;
	private String tipozona;
	private String zona;
	private String flagfuerzasarmadas;
	private String flagdiscapacidad;
	private String flagcondenado;
	private String flagdestituido;
	private String flagsancionado;
	private String flagincopatibilidad;
	private String flagdependiente;
	private String nombredependiente;
	private String parentescodependiente;
	private String oficinadependiente;
	private Integer idpregunta01;
	private Integer idpregunta02;
	private Integer idpregunta03;
	private String respuesta01;
	private String respuesta02;
	private String respuesta03;
	private String uuidalfrescofoto;

	private String nombrecompleto;
	private String imagenBase64;
	private String nombreImagen;
	private Boolean auxerrorreniec;
	private BigDecimal ROWNUM_;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public BigDecimal getPostulantenumero() {
		return postulantenumero;
	}

	public void setPostulantenumero(BigDecimal postulantenumero) {
		this.postulantenumero = postulantenumero;
	}

	public Integer getService() {
		return service;
	}

	public void setService(Integer service) {
		this.service = service;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public java.util.Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(java.util.Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getLibretaelectoral() {
		return libretaelectoral;
	}

	public void setLibretaelectoral(String libretaelectoral) {
		this.libretaelectoral = libretaelectoral;
	}

	public String getLibretamilitar() {
		return libretamilitar;
	}

	public void setLibretamilitar(String libretamilitar) {
		this.libretamilitar = libretamilitar;
	}

	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}

	public String getTipobrevete() {
		return tipobrevete;
	}

	public void setTipobrevete(String tipobrevete) {
		this.tipobrevete = tipobrevete;
	}

	public String getBrevete() {
		return brevete;
	}

	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}

	public String getCarnetasistenciasocial() {
		return carnetasistenciasocial;
	}

	public void setCarnetasistenciasocial(String carnetasistenciasocial) {
		this.carnetasistenciasocial = carnetasistenciasocial;
	}

	public String getCarnetextranjeria() {
		return carnetextranjeria;
	}

	public void setCarnetextranjeria(String carnetextranjeria) {
		this.carnetextranjeria = carnetextranjeria;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getTalla() {
		return talla;
	}

	public void setTalla(BigDecimal talla) {
		this.talla = talla;
	}

	public String getGruposanguineo() {
		return gruposanguineo;
	}

	public void setGruposanguineo(String gruposanguineo) {
		this.gruposanguineo = gruposanguineo;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public java.util.Date getFechaestadocivil() {
		return fechaestadocivil;
	}

	public void setFechaestadocivil(java.util.Date fechaestadocivil) {
		this.fechaestadocivil = fechaestadocivil;
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

	public String getOtrosituaciondomicilio() {
		return otrosituaciondomicilio;
	}

	public void setOtrosituaciondomicilio(String otrosituaciondomicilio) {
		this.otrosituaciondomicilio = otrosituaciondomicilio;
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

	public java.util.Date getFecharegistroinicial() {
		return fecharegistroinicial;
	}

	public void setFecharegistroinicial(java.util.Date fecharegistroinicial) {
		this.fecharegistroinicial = fecharegistroinicial;
	}

	public String getFuentereclutamiento() {
		return fuentereclutamiento;
	}

	public void setFuentereclutamiento(String fuentereclutamiento) {
		this.fuentereclutamiento = fuentereclutamiento;
	}

	public String getCodigoauxiliar() {
		return codigoauxiliar;
	}

	public void setCodigoauxiliar(String codigoauxiliar) {
		this.codigoauxiliar = codigoauxiliar;
	}

	public String getDireccionelectronica() {
		return direccionelectronica;
	}

	public void setDireccionelectronica(String direccionelectronica) {
		this.direccionelectronica = direccionelectronica;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public Integer getTipocalle() {
		return tipocalle;
	}

	public void setTipocalle(Integer tipocalle) {
		this.tipocalle = tipocalle;
	}

	public String getNombrecalle() {
		return nombrecalle;
	}

	public void setNombrecalle(String nombrecalle) {
		this.nombrecalle = nombrecalle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumdep() {
		return numdep;
	}

	public void setNumdep(String numdep) {
		this.numdep = numdep;
	}

	public String getManzana() {
		return manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public String getProvinciadomicilio() {
		return provinciadomicilio;
	}

	public void setProvinciadomicilio(String provinciadomicilio) {
		this.provinciadomicilio = provinciadomicilio;
	}

	public String getObjetivogeneral() {
		return objetivogeneral;
	}

	public void setObjetivogeneral(String objetivogeneral) {
		this.objetivogeneral = objetivogeneral;
	}

	public String getDepartamentonacimiento() {
		return departamentonacimiento;
	}

	public void setDepartamentonacimiento(String departamentonacimiento) {
		this.departamentonacimiento = departamentonacimiento;
	}

	public String getProvincianacimiento() {
		return provincianacimiento;
	}

	public void setProvincianacimiento(String provincianacimiento) {
		this.provincianacimiento = provincianacimiento;
	}

	public String getDistritonacimiento() {
		return distritonacimiento;
	}

	public void setDistritonacimiento(String distritonacimiento) {
		this.distritonacimiento = distritonacimiento;
	}

	public String getApellidocasada() {
		return apellidocasada;
	}

	public void setApellidocasada(String apellidocasada) {
		this.apellidocasada = apellidocasada;
	}

	public String getLugarnacimiento() {
		return lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}

	public String getCelularlocal() {
		return celularlocal;
	}

	public void setCelularlocal(String celularlocal) {
		this.celularlocal = celularlocal;
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

	public String getNombreemergencia1() {
		return nombreemergencia1;
	}

	public void setNombreemergencia1(String nombreemergencia1) {
		this.nombreemergencia1 = nombreemergencia1;
	}

	public String getDireccionemergencia1() {
		return direccionemergencia1;
	}

	public void setDireccionemergencia1(String direccionemergencia1) {
		this.direccionemergencia1 = direccionemergencia1;
	}

	public String getTelefonoemergencia1() {
		return telefonoemergencia1;
	}

	public void setTelefonoemergencia1(String telefonoemergencia1) {
		this.telefonoemergencia1 = telefonoemergencia1;
	}

	public String getCelularemergencia1() {
		return celularemergencia1;
	}

	public void setCelularemergencia1(String celularemergencia1) {
		this.celularemergencia1 = celularemergencia1;
	}

	public String getParentescoemergencia1() {
		return parentescoemergencia1;
	}

	public void setParentescoemergencia1(String parentescoemergencia1) {
		this.parentescoemergencia1 = parentescoemergencia1;
	}

	public String getNombreemergencia2() {
		return nombreemergencia2;
	}

	public void setNombreemergencia2(String nombreemergencia2) {
		this.nombreemergencia2 = nombreemergencia2;
	}

	public String getDireccionemergencia2() {
		return direccionemergencia2;
	}

	public void setDireccionemergencia2(String direccionemergencia2) {
		this.direccionemergencia2 = direccionemergencia2;
	}

	public String getTelefonoemergencia2() {
		return telefonoemergencia2;
	}

	public void setTelefonoemergencia2(String telefonoemergencia2) {
		this.telefonoemergencia2 = telefonoemergencia2;
	}

	public String getCelularemergencia2() {
		return celularemergencia2;
	}

	public void setCelularemergencia2(String celularemergencia2) {
		this.celularemergencia2 = celularemergencia2;
	}

	public String getParentescoemergencia2() {
		return parentescoemergencia2;
	}

	public void setParentescoemergencia2(String parentescoemergencia2) {
		this.parentescoemergencia2 = parentescoemergencia2;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public java.util.Date getLicenciaconducirfecha() {
		return licenciaconducirfecha;
	}

	public void setLicenciaconducirfecha(java.util.Date licenciaconducirfecha) {
		this.licenciaconducirfecha = licenciaconducirfecha;
	}

	public String getPoseeauto() {
		return poseeauto;
	}

	public void setPoseeauto(String poseeauto) {
		this.poseeauto = poseeauto;
	}

	public BigDecimal getMontobruto() {
		return montobruto;
	}

	public void setMontobruto(BigDecimal montobruto) {
		this.montobruto = montobruto;
	}

	public String getNumeroconcurso() {
		return numeroconcurso;
	}

	public void setNumeroconcurso(String numeroconcurso) {
		this.numeroconcurso = numeroconcurso;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getTipozona() {
		return tipozona;
	}

	public void setTipozona(String tipozona) {
		this.tipozona = tipozona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getFlagfuerzasarmadas() {
		return flagfuerzasarmadas;
	}

	public void setFlagfuerzasarmadas(String flagfuerzasarmadas) {
		this.flagfuerzasarmadas = flagfuerzasarmadas;
	}

	public String getFlagdiscapacidad() {
		return flagdiscapacidad;
	}

	public void setFlagdiscapacidad(String flagdiscapacidad) {
		this.flagdiscapacidad = flagdiscapacidad;
	}

	public String getFlagcondenado() {
		return flagcondenado;
	}

	public void setFlagcondenado(String flagcondenado) {
		this.flagcondenado = flagcondenado;
	}

	public String getFlagdestituido() {
		return flagdestituido;
	}

	public void setFlagdestituido(String flagdestituido) {
		this.flagdestituido = flagdestituido;
	}

	public String getFlagsancionado() {
		return flagsancionado;
	}

	public void setFlagsancionado(String flagsancionado) {
		this.flagsancionado = flagsancionado;
	}

	public String getFlagincopatibilidad() {
		return flagincopatibilidad;
	}

	public void setFlagincopatibilidad(String flagincopatibilidad) {
		this.flagincopatibilidad = flagincopatibilidad;
	}

	public String getFlagdependiente() {
		return flagdependiente;
	}

	public void setFlagdependiente(String flagdependiente) {
		this.flagdependiente = flagdependiente;
	}

	public String getNombredependiente() {
		return nombredependiente;
	}

	public void setNombredependiente(String nombredependiente) {
		this.nombredependiente = nombredependiente;
	}

	public String getParentescodependiente() {
		return parentescodependiente;
	}

	public void setParentescodependiente(String parentescodependiente) {
		this.parentescodependiente = parentescodependiente;
	}

	public String getOficinadependiente() {
		return oficinadependiente;
	}

	public void setOficinadependiente(String oficinadependiente) {
		this.oficinadependiente = oficinadependiente;
	}

	public Integer getIdpregunta01() {
		return idpregunta01;
	}

	public void setIdpregunta01(Integer idpregunta01) {
		this.idpregunta01 = idpregunta01;
	}

	public Integer getIdpregunta02() {
		return idpregunta02;
	}

	public void setIdpregunta02(Integer idpregunta02) {
		this.idpregunta02 = idpregunta02;
	}

	public Integer getIdpregunta03() {
		return idpregunta03;
	}

	public void setIdpregunta03(Integer idpregunta03) {
		this.idpregunta03 = idpregunta03;
	}

	public String getRespuesta01() {
		return respuesta01;
	}

	public void setRespuesta01(String respuesta01) {
		this.respuesta01 = respuesta01;
	}

	public String getRespuesta02() {
		return respuesta02;
	}

	public void setRespuesta02(String respuesta02) {
		this.respuesta02 = respuesta02;
	}

	public String getRespuesta03() {
		return respuesta03;
	}

	public void setRespuesta03(String respuesta03) {
		this.respuesta03 = respuesta03;
	}

	public String getUuidalfrescofoto() {
		return uuidalfrescofoto;
	}

	public void setUuidalfrescofoto(String uuidalfrescofoto) {
		this.uuidalfrescofoto = uuidalfrescofoto;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getImagenBase64() {
		return imagenBase64;
	}

	public void setImagenBase64(String imagenBase64) {
		this.imagenBase64 = imagenBase64;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public Boolean getAuxerrorreniec() {
		return auxerrorreniec;
	}

	public void setAuxerrorreniec(Boolean auxerrorreniec) {
		this.auxerrorreniec = auxerrorreniec;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}

	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}

}
