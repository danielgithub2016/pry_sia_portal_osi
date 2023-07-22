package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Personamast
*/
public class Personamast extends DominioGenerico implements java.io.Serializable{

	private PersonamastPk pk;
	private String origen;
	private String apellidopaterno;
	private String apellidomaterno;
	private String nombres;
	private String nombrecompleto;
	private String busqueda;
	private String tipodocumento;
	private String documento;
	private String codigobarras;
	private String tipopersonausuario;
	private String escliente;
	private String esproveedor;
	private String esempleado;
	private String esotro;
	private String tipopersona;
	private java.util.Date fechanacimiento;
	private String ciudadnacimiento;
	private String sexo;
	private String nacionalidad;
	private String estadocivil;
	private String nivelinstruccion;
	private String direccion;
	private String codigopostal;
	private String departamento;
	private String telefono;
	private String fax;
	private String documentofiscal;
	private String documentoidentidad;
	private String carnetextranjeria;
	private String documentomilitarfa;
	private String tipobrevete;
	private String brevete;
	private String pasaporte;
	private String nombreemergencia;
	private String direccionemergencia;
	private String telefonoemergencia;
	private String bancomonedalocal;
	private String tipocuentalocal;
	private String cuentamonedalocal;
	private String bancomonedaextranjera;
	private String tipocuentaextranjera;
	private String cuentamonedaextranjera;
	private String personaant;
	private String correoelectronico;
	private String clasepersonacodigo;
	private String estado;
	private String cuentamonedalocalTmp;
	private String cuentamonedaextranjeraTmp;
	private String enfermedadgraveflag;
	private String provincia;
	private String tarjetadecredito;
	private String flagactualizacion;
	private java.util.Date ingresofecharegistro;
	private String ingresoaplicacioncodigo;
	private String ingresousuario;
	private String pymeflag;
	private String grupoempresarial;
	private String celular;
	private String celularemergencia;
	private String lugarnacimiento;
	private String parentescoemergencia;
	private String personaclasificacion;
	private String direccionreferencia;
	private String flagrepetido;
	private String coddiscamec;
	private java.util.Date fecinidiscamec;
	private java.util.Date fecfindiscamec;
	private String codlicarma;
	private String marcaarma;
	private String seriearma;
	private java.util.Date inicioarma;
	private java.util.Date vencimientoarma;
	private String segurodiscamec;
	private String correlativosctr;
	private String sunatzona;
	private String sunatubigeo;
	private String sunatnacionalidad;
	private String sunatvia;
	private String sunatdomiciliado;
	private java.util.Date breveteFecvcto;
	private java.util.Date carnetextranjeriaFecvcto;
	private String pasaporteFecvcto;
	private String personanew;
	private String personaOld;
	private String documentoidentidadFecvcto;
	private Integer tempPersona;
	private String cadenabusqueda;
	private String cuentaccilocal;
	private String cuentacciextranjera;
	private String paisemisor;
	private String codigoldn;
	private String codigousuario;
	private String esusuario;
	private String flagsolicitausuariosiga;
	private Integer secuenciacuentabancaria;
	private String extencionfirma;
	private byte[] firma;


	public Personamast() {
		pk = new PersonamastPk();
	}

	public PersonamastPk getPk() {
		return pk;
	}

	public void setPk(PersonamastPk pk) {
		this.pk = pk;
	}
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
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
	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
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
	public String getCodigobarras() {
		return codigobarras;
	}

	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}
	public String getTipopersonausuario() {
		return tipopersonausuario;
	}

	public void setTipopersonausuario(String tipopersonausuario) {
		this.tipopersonausuario = tipopersonausuario;
	}
	public String getEscliente() {
		return escliente;
	}

	public void setEscliente(String escliente) {
		this.escliente = escliente;
	}
	public String getEsproveedor() {
		return esproveedor;
	}

	public void setEsproveedor(String esproveedor) {
		this.esproveedor = esproveedor;
	}
	public String getEsempleado() {
		return esempleado;
	}

	public void setEsempleado(String esempleado) {
		this.esempleado = esempleado;
	}
	public String getEsotro() {
		return esotro;
	}

	public void setEsotro(String esotro) {
		this.esotro = esotro;
	}
	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public java.util.Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(java.util.Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getCiudadnacimiento() {
		return ciudadnacimiento;
	}

	public void setCiudadnacimiento(String ciudadnacimiento) {
		this.ciudadnacimiento = ciudadnacimiento;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}
	public String getNivelinstruccion() {
		return nivelinstruccion;
	}

	public void setNivelinstruccion(String nivelinstruccion) {
		this.nivelinstruccion = nivelinstruccion;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}
	public String getDocumentoidentidad() {
		return documentoidentidad;
	}

	public void setDocumentoidentidad(String documentoidentidad) {
		this.documentoidentidad = documentoidentidad;
	}
	public String getCarnetextranjeria() {
		return carnetextranjeria;
	}

	public void setCarnetextranjeria(String carnetextranjeria) {
		this.carnetextranjeria = carnetextranjeria;
	}
	public String getDocumentomilitarfa() {
		return documentomilitarfa;
	}

	public void setDocumentomilitarfa(String documentomilitarfa) {
		this.documentomilitarfa = documentomilitarfa;
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
	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
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
	public String getBancomonedalocal() {
		return bancomonedalocal;
	}

	public void setBancomonedalocal(String bancomonedalocal) {
		this.bancomonedalocal = bancomonedalocal;
	}
	public String getTipocuentalocal() {
		return tipocuentalocal;
	}

	public void setTipocuentalocal(String tipocuentalocal) {
		this.tipocuentalocal = tipocuentalocal;
	}
	public String getCuentamonedalocal() {
		return cuentamonedalocal;
	}

	public void setCuentamonedalocal(String cuentamonedalocal) {
		this.cuentamonedalocal = cuentamonedalocal;
	}
	public String getBancomonedaextranjera() {
		return bancomonedaextranjera;
	}

	public void setBancomonedaextranjera(String bancomonedaextranjera) {
		this.bancomonedaextranjera = bancomonedaextranjera;
	}
	public String getTipocuentaextranjera() {
		return tipocuentaextranjera;
	}

	public void setTipocuentaextranjera(String tipocuentaextranjera) {
		this.tipocuentaextranjera = tipocuentaextranjera;
	}
	public String getCuentamonedaextranjera() {
		return cuentamonedaextranjera;
	}

	public void setCuentamonedaextranjera(String cuentamonedaextranjera) {
		this.cuentamonedaextranjera = cuentamonedaextranjera;
	}
	public String getPersonaant() {
		return personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}
	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
	public String getClasepersonacodigo() {
		return clasepersonacodigo;
	}

	public void setClasepersonacodigo(String clasepersonacodigo) {
		this.clasepersonacodigo = clasepersonacodigo;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCuentamonedalocalTmp() {
		return cuentamonedalocalTmp;
	}

	public void setCuentamonedalocalTmp(String cuentamonedalocalTmp) {
		this.cuentamonedalocalTmp = cuentamonedalocalTmp;
	}
	public String getCuentamonedaextranjeraTmp() {
		return cuentamonedaextranjeraTmp;
	}

	public void setCuentamonedaextranjeraTmp(String cuentamonedaextranjeraTmp) {
		this.cuentamonedaextranjeraTmp = cuentamonedaextranjeraTmp;
	}
	public String getEnfermedadgraveflag() {
		return enfermedadgraveflag;
	}

	public void setEnfermedadgraveflag(String enfermedadgraveflag) {
		this.enfermedadgraveflag = enfermedadgraveflag;
	}
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTarjetadecredito() {
		return tarjetadecredito;
	}

	public void setTarjetadecredito(String tarjetadecredito) {
		this.tarjetadecredito = tarjetadecredito;
	}
	public String getFlagactualizacion() {
		return flagactualizacion;
	}

	public void setFlagactualizacion(String flagactualizacion) {
		this.flagactualizacion = flagactualizacion;
	}
	public java.util.Date getIngresofecharegistro() {
		return ingresofecharegistro;
	}

	public void setIngresofecharegistro(java.util.Date ingresofecharegistro) {
		this.ingresofecharegistro = ingresofecharegistro;
	}
	public String getIngresoaplicacioncodigo() {
		return ingresoaplicacioncodigo;
	}

	public void setIngresoaplicacioncodigo(String ingresoaplicacioncodigo) {
		this.ingresoaplicacioncodigo = ingresoaplicacioncodigo;
	}
	public String getIngresousuario() {
		return ingresousuario;
	}

	public void setIngresousuario(String ingresousuario) {
		this.ingresousuario = ingresousuario;
	}
	public String getPymeflag() {
		return pymeflag;
	}

	public void setPymeflag(String pymeflag) {
		this.pymeflag = pymeflag;
	}
	public String getGrupoempresarial() {
		return grupoempresarial;
	}

	public void setGrupoempresarial(String grupoempresarial) {
		this.grupoempresarial = grupoempresarial;
	}
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelularemergencia() {
		return celularemergencia;
	}

	public void setCelularemergencia(String celularemergencia) {
		this.celularemergencia = celularemergencia;
	}
	public String getLugarnacimiento() {
		return lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}
	public String getParentescoemergencia() {
		return parentescoemergencia;
	}

	public void setParentescoemergencia(String parentescoemergencia) {
		this.parentescoemergencia = parentescoemergencia;
	}
	public String getPersonaclasificacion() {
		return personaclasificacion;
	}

	public void setPersonaclasificacion(String personaclasificacion) {
		this.personaclasificacion = personaclasificacion;
	}
	public String getDireccionreferencia() {
		return direccionreferencia;
	}

	public void setDireccionreferencia(String direccionreferencia) {
		this.direccionreferencia = direccionreferencia;
	}
	public String getFlagrepetido() {
		return flagrepetido;
	}

	public void setFlagrepetido(String flagrepetido) {
		this.flagrepetido = flagrepetido;
	}
	public String getCoddiscamec() {
		return coddiscamec;
	}

	public void setCoddiscamec(String coddiscamec) {
		this.coddiscamec = coddiscamec;
	}
	public java.util.Date getFecinidiscamec() {
		return fecinidiscamec;
	}

	public void setFecinidiscamec(java.util.Date fecinidiscamec) {
		this.fecinidiscamec = fecinidiscamec;
	}
	public java.util.Date getFecfindiscamec() {
		return fecfindiscamec;
	}

	public void setFecfindiscamec(java.util.Date fecfindiscamec) {
		this.fecfindiscamec = fecfindiscamec;
	}
	public String getCodlicarma() {
		return codlicarma;
	}

	public void setCodlicarma(String codlicarma) {
		this.codlicarma = codlicarma;
	}
	public String getMarcaarma() {
		return marcaarma;
	}

	public void setMarcaarma(String marcaarma) {
		this.marcaarma = marcaarma;
	}
	public String getSeriearma() {
		return seriearma;
	}

	public void setSeriearma(String seriearma) {
		this.seriearma = seriearma;
	}
	public java.util.Date getInicioarma() {
		return inicioarma;
	}

	public void setInicioarma(java.util.Date inicioarma) {
		this.inicioarma = inicioarma;
	}
	public java.util.Date getVencimientoarma() {
		return vencimientoarma;
	}

	public void setVencimientoarma(java.util.Date vencimientoarma) {
		this.vencimientoarma = vencimientoarma;
	}
	public String getSegurodiscamec() {
		return segurodiscamec;
	}

	public void setSegurodiscamec(String segurodiscamec) {
		this.segurodiscamec = segurodiscamec;
	}
	public String getCorrelativosctr() {
		return correlativosctr;
	}

	public void setCorrelativosctr(String correlativosctr) {
		this.correlativosctr = correlativosctr;
	}
	public String getSunatzona() {
		return sunatzona;
	}

	public void setSunatzona(String sunatzona) {
		this.sunatzona = sunatzona;
	}
	public String getSunatubigeo() {
		return sunatubigeo;
	}

	public void setSunatubigeo(String sunatubigeo) {
		this.sunatubigeo = sunatubigeo;
	}
	public String getSunatnacionalidad() {
		return sunatnacionalidad;
	}

	public void setSunatnacionalidad(String sunatnacionalidad) {
		this.sunatnacionalidad = sunatnacionalidad;
	}
	public String getSunatvia() {
		return sunatvia;
	}

	public void setSunatvia(String sunatvia) {
		this.sunatvia = sunatvia;
	}
	public String getSunatdomiciliado() {
		return sunatdomiciliado;
	}

	public void setSunatdomiciliado(String sunatdomiciliado) {
		this.sunatdomiciliado = sunatdomiciliado;
	}
	public java.util.Date getBreveteFecvcto() {
		return breveteFecvcto;
	}

	public void setBreveteFecvcto(java.util.Date breveteFecvcto) {
		this.breveteFecvcto = breveteFecvcto;
	}
	public java.util.Date getCarnetextranjeriaFecvcto() {
		return carnetextranjeriaFecvcto;
	}

	public void setCarnetextranjeriaFecvcto(java.util.Date carnetextranjeriaFecvcto) {
		this.carnetextranjeriaFecvcto = carnetextranjeriaFecvcto;
	}
	public String getPasaporteFecvcto() {
		return pasaporteFecvcto;
	}

	public void setPasaporteFecvcto(String pasaporteFecvcto) {
		this.pasaporteFecvcto = pasaporteFecvcto;
	}
	public String getPersonanew() {
		return personanew;
	}

	public void setPersonanew(String personanew) {
		this.personanew = personanew;
	}
	public String getPersonaOld() {
		return personaOld;
	}

	public void setPersonaOld(String personaOld) {
		this.personaOld = personaOld;
	}
	public String getDocumentoidentidadFecvcto() {
		return documentoidentidadFecvcto;
	}

	public void setDocumentoidentidadFecvcto(String documentoidentidadFecvcto) {
		this.documentoidentidadFecvcto = documentoidentidadFecvcto;
	}
	public Integer getTempPersona() {
		return tempPersona;
	}

	public void setTempPersona(Integer tempPersona) {
		this.tempPersona = tempPersona;
	}
	public String getCadenabusqueda() {
		return cadenabusqueda;
	}

	public void setCadenabusqueda(String cadenabusqueda) {
		this.cadenabusqueda = cadenabusqueda;
	}
	public String getCuentaccilocal() {
		return cuentaccilocal;
	}

	public void setCuentaccilocal(String cuentaccilocal) {
		this.cuentaccilocal = cuentaccilocal;
	}
	public String getCuentacciextranjera() {
		return cuentacciextranjera;
	}

	public void setCuentacciextranjera(String cuentacciextranjera) {
		this.cuentacciextranjera = cuentacciextranjera;
	}
	public String getPaisemisor() {
		return paisemisor;
	}

	public void setPaisemisor(String paisemisor) {
		this.paisemisor = paisemisor;
	}
	public String getCodigoldn() {
		return codigoldn;
	}

	public void setCodigoldn(String codigoldn) {
		this.codigoldn = codigoldn;
	}
	public String getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(String codigousuario) {
		this.codigousuario = codigousuario;
	}
	public String getEsusuario() {
		return esusuario;
	}

	public void setEsusuario(String esusuario) {
		this.esusuario = esusuario;
	}
	public String getFlagsolicitausuariosiga() {
		return flagsolicitausuariosiga;
	}

	public void setFlagsolicitausuariosiga(String flagsolicitausuariosiga) {
		this.flagsolicitausuariosiga = flagsolicitausuariosiga;
	}
	public Integer getSecuenciacuentabancaria() {
		return secuenciacuentabancaria;
	}

	public void setSecuenciacuentabancaria(Integer secuenciacuentabancaria) {
		this.secuenciacuentabancaria = secuenciacuentabancaria;
	}
	public String getExtencionfirma() {
		return extencionfirma;
	}

	public void setExtencionfirma(String extencionfirma) {
		this.extencionfirma = extencionfirma;
	}
	public byte[] getFirma() {
		return firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}

}
