package net.royal.framework.web.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
public class UsuarioActual extends DominioGenerico implements Serializable {

	/**
	 * codigo de usuario establecido en la tabla de Persona o Empleado
	 * dependiendo del negocio
	 */
	private String codigoUsuario;

	/**
	 * informacion del correo interno o principal con al cual se puede trabajar
	 * en todo el sistema
	 */
	private String correoInterno;

	/**
	 * listado de todos los componente a los que tiene acceso el usuario actual
	 */
	private List opcionesSistema;

	/**
	 * login o usuario con el que ingreso al sistema esto viene de la tabla
	 * Usuario
	 */
	private String loginUsuario;

	/**
	 * login o usuario de base de datos que se uso para entrar al sistema
	 * Usuario
	 */
	private String loginBaseDatos;

	/**
	 * tipo de documento del usuario logeado
	 */
	private String tipoDocumento;

	/**
	 * nro del documento de identificacion del usuario actual
	 */
	private String nroDocumento;

	/**
	 * codigo de estado del usuario
	 */
	private String estadoUsuario;

	/**
	 * indica cual es el nombre de la pc desde la cual se ha ingresado a la
	 * aplicacion
	 */
	private String hostNameLogin;

	/**
	 * indica cual es la direcion ip desde la cual se ha ingresado a la
	 * aplicacion
	 */
	private String ipAddressLogin;

	/**
	 * identificador unico de la entidad principal tipo persona
	 */
	private Integer idPersona;

	/**
	 * Nombre completo del usuario incluye nombres y apellidos
	 */
	private String nombreCompleto;

	/**
	 * nombre o nombres del usuario
	 */
	private String nombres;

	/**
	 * apellidos del usuario logeado paterno y materno
	 */
	private String apellidos;

	/**
	 * apellido Paterno del usuario logeado
	 */
	private String apellidoPaterno;

	/**
	 * apellido Materno del usuario logeado
	 */
	private String apellidoMaterno;

	/**
	 * apellido Materno del usuario logeado
	 */
	private String sexo;

	/**
	 * identificador unico del usuario, puede ser un valor distinto al
	 * <b>loginUsuario</b> en caso el usuario no tenga un identificador unico
	 * como entidad se almacena el mismo valor que <b>loginUsuario</b>
	 */
	private String idUsuario;

	private String idResponsableEmpleado;

	private String idResponsableJefe;

	private String periodoContableActual;
	private Boolean tieneTipoCambioDelDia;
	private BigDecimal tipoCambioDelDia;

	/**
	 * AS_Area.area = Empleado.dptoareaoperativa
	 * 
	 */
	private String areaCodigo;
	private String areaNombre;

	private String companiaSocioCodigo;
	private String companiaSocioNombre;

	private Integer clienteCodigo;
	private String clienteNombre;

	private String unidadNegocioCodigo;
	private String unidadNegocioNombre;

	private String sucursalCodigo;
	private String sucursalNombre;

	private String cargoCodigo;
	private String cargoNombre;

	private String unidadReplicacionCodigo;
	private String unidadReplicacionNombre;

	private String centroCostosCodigo;
	private String centroCostosNombre;

	private String paisCodigo;
	private String paisNombre;

	private String aplicacionCodigo;
	private String aplicacionNombre;

	private String nombreImagenLogoParaReporte;
	private String nombreImagenLogoParaCabecera;

	private String almacenCodigo;
	private String almacenNombre;

	/**
	 * identificador u constante para asignar un tipo especifico de usuario,
	 * este valor lo definie cada aplicativo en base a sus requerimientos
	 * ejemplo: tipoUsuario <br>
	 * EMP</br>
	 * son todos los empleados de la empresa tipoUsuario <br>
	 * PRO</br>
	 * son los proveedores que se le da acceso al sistema tipoUsuario <br>
	 * PAC</br>
	 * son los pacientes que tienen acceso a algunas opciones
	 */
	private String tipoUsuario;

	/**
	 * este valor viene de Spring se asigna en la tabla de parametrosmast
	 * "SY","999999","SECURITY" ejemplo: tipoSeguridad <br>
	 * P</br>
	 * Seguridad Propia <br>
	 * W</br>
	 * Seguridad por ventanas <br>
	 * M</br>
	 * Seguridad por menus
	 */
	private String tipoSeguridad;

	private String preferenciasDataBase;

	private String preferenciasEmpresa;

	private BigDecimal importePorcentajeIgv;

	/**
	 * S:Estatal M:Mixta N:No
	 */
	private String esFiscal;

	private String cierreDiario;

	private String seguridadPorUnidadNegocio;

	private String companiaProtegida;

	private String contabilidadPorDefecto;

	private String planContable;

	private String uniqueIdString;

	private Integer uniqueIdInteger;

	private Boolean isAdmin;
	private Boolean isaprobador;

	private String rutaFirmaDigital1;
	private String rutaFirmaDigital2;
	private String rutabasefirma;
	private String correoRoyal;

	private BigDecimal usuarioAprobacion;

	private String mensaje;

	private String tipoPlanilla;

	private List<String> lstCodigosAutorizados;

	/*
	 * private String TipoTrabajador; private Integer idAgente; private Integer
	 * idEstablecimiento; private String unidadOrganizacional;
	 */

	/**
	 * empleadomast.codigocargo = HR_PUESTOEMPRESA.codigopuesto
	 * 
	 * @return
	 */

	private String postulanteClave;

	public String getCargoCodigo() {
		return cargoCodigo;
	}

	/**
	 * empleadomast.codigocargo = HR_PUESTOEMPRESA.codigopuesto
	 * 
	 * @return
	 */
	public void setCargoCodigo(String cargoCodigo) {
		this.cargoCodigo = cargoCodigo;
	}

	/**
	 * empleadomast.codigocargo = HR_PUESTOEMPRESA.codigopuesto
	 * 
	 * @return
	 */
	public String getCargoNombre() {
		return cargoNombre;
	}

	/**
	 * empleadomast.codigocargo = HR_PUESTOEMPRESA.codigopuesto
	 * 
	 * @return
	 */
	public void setCargoNombre(String cargoNombre) {
		this.cargoNombre = cargoNombre;
	}

	public String getPeriodoContableActual() {
		return periodoContableActual;
	}

	public void setPeriodoContableActual(String periodoContableActual) {
		this.periodoContableActual = periodoContableActual;
	}

	public String getNombreImagenLogoParaCabecera() {
		return nombreImagenLogoParaCabecera;
	}

	public void setNombreImagenLogoParaCabecera(String nombreImagenLogoParaCabecera) {
		this.nombreImagenLogoParaCabecera = nombreImagenLogoParaCabecera;
	}

	public Integer getClienteCodigo() {
		return clienteCodigo;
	}

	public void setClienteCodigo(Integer clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public String getSucursalCodigo() {
		return sucursalCodigo;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public void setSucursalCodigo(String sucursalCodigo) {
		this.sucursalCodigo = sucursalCodigo;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public String getSucursalNombre() {
		return sucursalNombre;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public void setSucursalNombre(String sucursalNombre) {
		this.sucursalNombre = sucursalNombre;
	}

	/**
	 * identificador unico de la entidad principal tipo persona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}

	/**
	 * identificador unico de la entidad principal tipo persona
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * apellidos del usuario logeado
	 */
	public String getApellidos() {
		String apes = "";

		if (!(this.apellidoPaterno == null))
			apes = apellidoPaterno;

		if (!(this.apellidoMaterno == null))
			apes = apes + " " + apellidoMaterno;

		return apes;
	}

	/**
	 * apellidos del usuario logeado
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * nombre o nombres del usuario
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * nombre o nombres del usuario
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * identificador unico del usuario, puede ser un valor distinto al
	 * <b>loginUsuario</b> en caso el usuario no tenga un identificador unico
	 * como entidad se almacena el mismo valor que <b>loginUsuario</b>
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * identificador unico del usuario, puede ser un valor distinto al
	 * <b>loginUsuario</b> en caso el usuario no tenga un identificador unico
	 * como entidad se almacena el mismo valor que <b>loginUsuario</b>
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Nombre completo del usuario
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * Nombre completo del usuario
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * tipo de documento del usuario logeado
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * tipo de documento del usuario logeado
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * nro del documento de identificacion del usuario actual
	 */
	public String getNroDocumento() {
		return nroDocumento;
	}

	/**
	 * nro del documento de identificacion del usuario actual
	 */
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	/**
	 * codigo de estado del usuario
	 */
	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	/**
	 * codigo de estado del usuario
	 */
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	/**
	 * indica cual es el nombre de la pc desde la cual se ha ingresado a la
	 * aplicacion
	 */
	public String getHostNameLogin() {
		return hostNameLogin;
	}

	/**
	 * indica cual es el nombre de la pc desde la cual se ha ingresado a la
	 * aplicacion
	 */
	public void setHostNameLogin(String hostNameLogin) {
		this.hostNameLogin = hostNameLogin;
	}

	/**
	 * indica cual es la direcion ip desde la cual se ha ingresado a la
	 * aplicacion
	 */
	public String getIpAddressLogin() {
		return ipAddressLogin;
	}

	/**
	 * indica cual es la direcion ip desde la cual se ha ingresado a la
	 * aplicacion
	 */
	public void setIpAddressLogin(String ipAddressLogin) {
		this.ipAddressLogin = ipAddressLogin;
	}

	/**
	 * login o usuario con el que ingreso al sistema esto viene de la tabla
	 * Usuario
	 */
	public String getLoginUsuario() {
		return loginUsuario;
	}

	/**
	 * login o usuario con el que ingreso al sistema esto viene de la tabla
	 * Usuario
	 */
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * listado de todos los componente a los que tiene acceso el usuario actual
	 */
	public List getOpcionesSistema() {
		return opcionesSistema;
	}

	/**
	 * listado de todos los componente a los que tiene acceso el usuario actual
	 */
	public void setOpcionesSistema(List opcionesSistema) {
		this.opcionesSistema = opcionesSistema;
	}

	/**
	 * codigo de usuario establecido en la tabla de Persona o Empleado
	 * dependiendo del negocio
	 */
	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * codigo de usuario establecido en la tabla de Persona o Empleado
	 * dependiendo del negocio
	 */
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	/**
	 * informacion del correo interno o principal con al cual se puede trabajar
	 * en todo el sistema
	 */
	public String getCorreoInterno() {
		return correoInterno;
	}

	/**
	 * informacion del correo interno o principal con al cual se puede trabajar
	 * en todo el sistema
	 */
	public void setCorreoInterno(String correoInterno) {
		this.correoInterno = correoInterno;
	}

	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public String getCompaniaSocioCodigo() {
		return companiaSocioCodigo;
	}

	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public void setCompaniaSocioCodigo(String companiaSocioCodigo) {
		this.companiaSocioCodigo = companiaSocioCodigo;
	}

	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public String getCompaniaSocioNombre() {
		return companiaSocioNombre;
	}

	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public void setCompaniaSocioNombre(String companiaSocioNombre) {
		this.companiaSocioNombre = companiaSocioNombre;
	}

	/**
	 * empleadomast.unidadnegocioasignada = MA_UnidadNegocio.UnidadNegocio
	 * 
	 * @return
	 */
	public String getUnidadNegocioCodigo() {
		return unidadNegocioCodigo;
	}

	/**
	 * empleadomast.unidadnegocioasignada = MA_UnidadNegocio.UnidadNegocio
	 * 
	 * @return
	 */
	public void setUnidadNegocioCodigo(String unidadNegocioCodigo) {
		this.unidadNegocioCodigo = unidadNegocioCodigo;
	}

	/**
	 * empleadomast.unidadnegocioasignada = MA_UnidadNegocio.UnidadNegocio
	 * 
	 * @return
	 */
	public String getUnidadNegocioNombre() {
		return unidadNegocioNombre;
	}

	/**
	 * empleadomast.unidadnegocioasignada = MA_UnidadNegocio.UnidadNegocio
	 * 
	 * @return
	 */
	public void setUnidadNegocioNombre(String unidadNegocioNombre) {
		this.unidadNegocioNombre = unidadNegocioNombre;
	}

	public String getNombreImagenLogoParaReporte() {
		return nombreImagenLogoParaReporte;
	}

	public void setNombreImagenLogoParaReporte(String nombreImagenLogoParaReporte) {
		this.nombreImagenLogoParaReporte = nombreImagenLogoParaReporte;
	}

	public Boolean getTieneTipoCambioDelDia() {
		return tieneTipoCambioDelDia;
	}

	public void setTieneTipoCambioDelDia(Boolean tieneTipoCamioDelDia) {
		this.tieneTipoCambioDelDia = tieneTipoCamioDelDia;
	}

	public BigDecimal getTipoCambioDelDia() {
		return tipoCambioDelDia;
	}

	public void setTipoCambioDelDia(BigDecimal tipoCamioDelDia) {
		this.tipoCambioDelDia = tipoCamioDelDia;
	}

	public String getUnidadReplicacionCodigo() {
		return unidadReplicacionCodigo;
	}

	public void setUnidadReplicacionCodigo(String unidadReplicacionCodigo) {
		this.unidadReplicacionCodigo = unidadReplicacionCodigo;
	}

	public String getUnidadReplicacionNombre() {
		return unidadReplicacionNombre;
	}

	public void setUnidadReplicacionNombre(String unidadReplicacionNombre) {
		this.unidadReplicacionNombre = unidadReplicacionNombre;
	}

	/*
	 * public String getTipoTrabajador() { return TipoTrabajador; }
	 * 
	 * public void setTipoTrabajador(String tipoTrabajador) { TipoTrabajador =
	 * tipoTrabajador; }
	 * 
	 * public Integer getIdAgente() { return idAgente; }
	 * 
	 * public void setIdAgente(Integer idAgente) { this.idAgente = idAgente; }
	 * 
	 * public Integer getIdEstablecimiento() { return idEstablecimiento; }
	 * 
	 * public void setIdEstablecimiento(Integer idEstablecimiento) {
	 * this.idEstablecimiento = idEstablecimiento; }
	 * 
	 * public String getUnidadOrganizacional() { return unidadOrganizacional; }
	 * 
	 * public void setUnidadOrganizacional(String unidadOrganizacional) {
	 * this.unidadOrganizacional = unidadOrganizacional; }
	 */

	public String getLoginBaseDatos() {
		return loginBaseDatos;
	}

	public void setLoginBaseDatos(String loginBaseDatos) {
		this.loginBaseDatos = loginBaseDatos;
	}

	public String getAplicacionCodigo() {
		return aplicacionCodigo;
	}

	public void setAplicacionCodigo(String aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}

	public String getAplicacionNombre() {
		return aplicacionNombre;
	}

	public void setAplicacionNombre(String aplicacionNombre) {
		this.aplicacionNombre = aplicacionNombre;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public String getCentroCostosCodigo() {
		return centroCostosCodigo;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public void setCentroCostosCodigo(String centroCostosCodigo) {
		this.centroCostosCodigo = centroCostosCodigo;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public String getCentroCostosNombre() {
		return centroCostosNombre;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public void setCentroCostosNombre(String centroCostosNombre) {
		this.centroCostosNombre = centroCostosNombre;
	}

	public String getPaisCodigo() {
		return paisCodigo;
	}

	public void setPaisCodigo(String paisCodigo) {
		this.paisCodigo = paisCodigo;
	}

	public String getPaisNombre() {
		return paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}

	/**
	 * Empleado.dptoareaoperativa = AS_Area.area *
	 */
	public String getAreaCodigo() {
		return areaCodigo;
	}

	/**
	 * Empleado.dptoareaoperativa = AS_Area.area *
	 */
	public void setAreaCodigo(String areaCodigo) {
		this.areaCodigo = areaCodigo;
	}

	/**
	 * Empleado.dptoareaoperativa = AS_Area.area *
	 */
	public String getAreaNombre() {
		return areaNombre;
	}

	/**
	 * Empleado.dptoareaoperativa = AS_Area.area *
	 */
	public void setAreaNombre(String areaNombre) {
		this.areaNombre = areaNombre;
	}

	public String getAlmacenCodigo() {
		return almacenCodigo;
	}

	public void setAlmacenCodigo(String almacenCodigo) {
		this.almacenCodigo = almacenCodigo;
	}

	public String getAlmacenNombre() {
		return almacenNombre;
	}

	public void setAlmacenNombre(String almacenNombre) {
		this.almacenNombre = almacenNombre;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoSeguridad() {
		return tipoSeguridad;
	}

	public void setTipoSeguridad(String tipoSeguridad) {
		this.tipoSeguridad = tipoSeguridad;
	}

	public String getPreferenciasDataBase() {
		return preferenciasDataBase;
	}

	public void setPreferenciasDataBase(String preferenciasDataBase) {
		this.preferenciasDataBase = preferenciasDataBase;
	}

	public String getPreferenciasEmpresa() {
		return preferenciasEmpresa;
	}

	public void setPreferenciasEmpresa(String preferenciasEmpresa) {
		this.preferenciasEmpresa = preferenciasEmpresa;
	}

	public String getEsFiscal() {
		return esFiscal;
	}

	public void setEsFiscal(String esFiscal) {
		this.esFiscal = esFiscal;
	}

	public String getCierreDiario() {
		return cierreDiario;
	}

	public void setCierreDiario(String cierreDiario) {
		this.cierreDiario = cierreDiario;
	}

	public String getSeguridadPorUnidadNegocio() {
		return seguridadPorUnidadNegocio;
	}

	public void setSeguridadPorUnidadNegocio(String seguridadPorUnidadNegocio) {
		this.seguridadPorUnidadNegocio = seguridadPorUnidadNegocio;
	}

	public BigDecimal getImportePorcentajeIgv() {
		return importePorcentajeIgv;
	}

	public void setImportePorcentajeIgv(BigDecimal importePorcentajeIgv) {
		this.importePorcentajeIgv = importePorcentajeIgv;
	}

	public String getCompaniaProtegida() {
		return companiaProtegida;
	}

	public void setCompaniaProtegida(String companiaProtegida) {
		this.companiaProtegida = companiaProtegida;
	}

	public String getContabilidadPorDefecto() {
		return contabilidadPorDefecto;
	}

	public void setContabilidadPorDefecto(String contabilidadPorDefecto) {
		this.contabilidadPorDefecto = contabilidadPorDefecto;
	}

	public String getPlanContable() {
		return planContable;
	}

	public void setPlanContable(String planContable) {
		this.planContable = planContable;
	}

	public String getUniqueIdString() {
		return uniqueIdString;
	}

	public void setUniqueIdString(String uniqueIdString) {
		this.uniqueIdString = uniqueIdString;
	}

	public Integer getUniqueIdInteger() {
		return uniqueIdInteger;
	}

	public void setUniqueIdInteger(Integer uniqueIdInteger) {
		this.uniqueIdInteger = uniqueIdInteger;
	}

	public String getIdResponsableEmpleado() {
		return idResponsableEmpleado;
	}

	public void setIdResponsableEmpleado(String idResponsableEmpleado) {
		this.idResponsableEmpleado = idResponsableEmpleado;
	}

	public String getIdResponsableJefe() {
		return idResponsableJefe;
	}

	public void setIdResponsableJefe(String idResponsableJefe) {
		this.idResponsableJefe = idResponsableJefe;
	}

	/**
	 * @return the isAdmin
	 */
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the rutaFirmaDigital1
	 */
	public String getRutaFirmaDigital1() {
		return rutaFirmaDigital1;
	}

	/**
	 * @param rutaFirmaDigital1
	 *            the rutaFirmaDigital1 to set
	 */
	public void setRutaFirmaDigital1(String rutaFirmaDigital1) {
		this.rutaFirmaDigital1 = rutaFirmaDigital1;
	}

	/**
	 * @return the rutaFirmaDigital2
	 */
	public String getRutaFirmaDigital2() {
		return rutaFirmaDigital2;
	}

	/**
	 * @param rutaFirmaDigital2
	 *            the rutaFirmaDigital2 to set
	 */
	public void setRutaFirmaDigital2(String rutaFirmaDigital2) {
		this.rutaFirmaDigital2 = rutaFirmaDigital2;
	}

	/**
	 * @return the correoRoyal
	 */
	public String getCorreoRoyal() {
		return correoRoyal;
	}

	/**
	 * @param correoRoyal
	 *            the correoRoyal to set
	 */
	public void setCorreoRoyal(String correoRoyal) {
		this.correoRoyal = correoRoyal;
	}

	/**
	 * @return the rutabasefirma
	 */
	public String getRutabasefirma() {
		return rutabasefirma;
	}

	/**
	 * @param rutabasefirma
	 *            the rutabasefirma to set
	 */
	public void setRutabasefirma(String rutabasefirma) {
		this.rutabasefirma = rutabasefirma;
	}

	public Boolean getIsaprobador() {
		return isaprobador;
	}

	public void setIsaprobador(Boolean isaprobador) {
		this.isaprobador = isaprobador;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<String> getLstCodigosAutorizados() {
		return lstCodigosAutorizados;
	}

	public void setLstCodigosAutorizados(List<String> lstCodigosAutorizados) {
		this.lstCodigosAutorizados = lstCodigosAutorizados;
	}

	public String getTipoPlanilla() {
		return tipoPlanilla;
	}

	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	public String getPostulanteClave() {
		return postulanteClave;
	}

	public void setPostulanteClave(String postulanteClave) {
		this.postulanteClave = postulanteClave;
	}

	public BigDecimal getUsuarioAprobacion() {
		return usuarioAprobacion;
	}

	public void setUsuarioAprobacion(BigDecimal usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
