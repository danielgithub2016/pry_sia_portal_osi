package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrContratos
*/
public class HrContratos extends DominioGenerico implements java.io.Serializable{

	private HrContratosPk pk;
	private String estado;
	private String tipocontrato;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private java.util.Date fechatermino;
	private Integer responsable;
	private String comentarios;
	private Integer sueldo;
	private Integer codigopuesto;
	private String compania;
	private Integer cliente;
	private String formato;
	private String sueldotexto;
	private Integer resolucion;
	private java.util.Date fecharesolucion;
	private java.util.Date fechacontrato;
	private Integer porcentajesueldo;
	private Integer sueldototal;
	private String documentointerno;
	private String cargo;
	private Integer universidad;
	private String facultad;
	private java.util.Date fechacomunicacion;
	private String periodolegislativo;
	private String flagfirma;
	private String flagnuevocontrato;
	private java.util.Date fechafirma;
	private String gradosalarial;
	private String tipoorgano;
	private String resoluciontext;
	private String flagsolicitudnorenovacion;
	private String ubicacion;
	private Integer motivocese;
	private String razoncese;
	private String formato2;
	private String prestacionalimentaria;
	private Integer funcionario;
	private Integer codigoproveedor;
	private String centrocostos;
	private String nivel;
	private java.util.Date fechainicioprueba;
	private java.util.Date fechafinprueba;
	private String crazonnvocontrato;
	private String practCentroformacion;
	private String practDomicilio;
	private String practEspecialidad;
	private String practHorario;
	private String practRepresentante;
	private String practRepresentantedni;
	private String practRuc;
	private String practSituacion;
	private String situacion;
	private String semestre;
	private String area;
	private String comentarios1;
	private String departamentooperacional;
	private String sustento;
	private Integer empleadosuplencia;
	private Integer cargosuplencia;
	private String locacionpagosuplencia;
	private String motivosuplencia;
	private String resolucionsuplencia;
	private java.util.Date fechasuplencia;
	private java.util.Date fecharesoluciontex;
	private String resoluciondesig;
	private java.util.Date fechadesig;
	private String periodo;
	private String numeromemo;
	private java.util.Date fechamemo;
	private Integer jefeofiadm;
	private String centrocostojefe;
	private java.util.Date fechacontratoant;
	private java.util.Date fechaproveido;
	private String centrocostoanterior;
	private String resolucionjefat;
	private java.util.Date fechafacultado;
	private java.util.Date fechacartapresent;
	private Integer reprelegalRleg;
	private String resoluciondesigRleg;
	private java.util.Date fechadesigRleg;
	private String resolucionjefatRleg;
	private java.util.Date fechafacultadoRleg;
	private Integer mesesadicionales;
	private String practRepresentantecargo;
	private String practDiaspractica;
	private String cargoant;
	private java.util.Date fechainicioadicional;
	private String periodoadicional;
	private Integer numerosecuencia;
	private Integer numerosecuenciaaddemdum;
	private String codigoproceso;
	private Integer numeroproceso;


	public HrContratos() {
		pk = new HrContratosPk();
	}

	public HrContratosPk getPk() {
		return pk;
	}

	public void setPk(HrContratosPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
	public java.util.Date getFechatermino() {
		return fechatermino;
	}

	public void setFechatermino(java.util.Date fechatermino) {
		this.fechatermino = fechatermino;
	}
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getSueldotexto() {
		return sueldotexto;
	}

	public void setSueldotexto(String sueldotexto) {
		this.sueldotexto = sueldotexto;
	}
	public Integer getResolucion() {
		return resolucion;
	}

	public void setResolucion(Integer resolucion) {
		this.resolucion = resolucion;
	}
	public java.util.Date getFecharesolucion() {
		return fecharesolucion;
	}

	public void setFecharesolucion(java.util.Date fecharesolucion) {
		this.fecharesolucion = fecharesolucion;
	}
	public java.util.Date getFechacontrato() {
		return fechacontrato;
	}

	public void setFechacontrato(java.util.Date fechacontrato) {
		this.fechacontrato = fechacontrato;
	}
	public Integer getPorcentajesueldo() {
		return porcentajesueldo;
	}

	public void setPorcentajesueldo(Integer porcentajesueldo) {
		this.porcentajesueldo = porcentajesueldo;
	}
	public Integer getSueldototal() {
		return sueldototal;
	}

	public void setSueldototal(Integer sueldototal) {
		this.sueldototal = sueldototal;
	}
	public String getDocumentointerno() {
		return documentointerno;
	}

	public void setDocumentointerno(String documentointerno) {
		this.documentointerno = documentointerno;
	}
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Integer universidad) {
		this.universidad = universidad;
	}
	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public java.util.Date getFechacomunicacion() {
		return fechacomunicacion;
	}

	public void setFechacomunicacion(java.util.Date fechacomunicacion) {
		this.fechacomunicacion = fechacomunicacion;
	}
	public String getPeriodolegislativo() {
		return periodolegislativo;
	}

	public void setPeriodolegislativo(String periodolegislativo) {
		this.periodolegislativo = periodolegislativo;
	}
	public String getFlagfirma() {
		return flagfirma;
	}

	public void setFlagfirma(String flagfirma) {
		this.flagfirma = flagfirma;
	}
	public String getFlagnuevocontrato() {
		return flagnuevocontrato;
	}

	public void setFlagnuevocontrato(String flagnuevocontrato) {
		this.flagnuevocontrato = flagnuevocontrato;
	}
	public java.util.Date getFechafirma() {
		return fechafirma;
	}

	public void setFechafirma(java.util.Date fechafirma) {
		this.fechafirma = fechafirma;
	}
	public String getGradosalarial() {
		return gradosalarial;
	}

	public void setGradosalarial(String gradosalarial) {
		this.gradosalarial = gradosalarial;
	}
	public String getTipoorgano() {
		return tipoorgano;
	}

	public void setTipoorgano(String tipoorgano) {
		this.tipoorgano = tipoorgano;
	}
	public String getResoluciontext() {
		return resoluciontext;
	}

	public void setResoluciontext(String resoluciontext) {
		this.resoluciontext = resoluciontext;
	}
	public String getFlagsolicitudnorenovacion() {
		return flagsolicitudnorenovacion;
	}

	public void setFlagsolicitudnorenovacion(String flagsolicitudnorenovacion) {
		this.flagsolicitudnorenovacion = flagsolicitudnorenovacion;
	}
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Integer getMotivocese() {
		return motivocese;
	}

	public void setMotivocese(Integer motivocese) {
		this.motivocese = motivocese;
	}
	public String getRazoncese() {
		return razoncese;
	}

	public void setRazoncese(String razoncese) {
		this.razoncese = razoncese;
	}
	public String getFormato2() {
		return formato2;
	}

	public void setFormato2(String formato2) {
		this.formato2 = formato2;
	}
	public String getPrestacionalimentaria() {
		return prestacionalimentaria;
	}

	public void setPrestacionalimentaria(String prestacionalimentaria) {
		this.prestacionalimentaria = prestacionalimentaria;
	}
	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}
	public Integer getCodigoproveedor() {
		return codigoproveedor;
	}

	public void setCodigoproveedor(Integer codigoproveedor) {
		this.codigoproveedor = codigoproveedor;
	}
	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public java.util.Date getFechainicioprueba() {
		return fechainicioprueba;
	}

	public void setFechainicioprueba(java.util.Date fechainicioprueba) {
		this.fechainicioprueba = fechainicioprueba;
	}
	public java.util.Date getFechafinprueba() {
		return fechafinprueba;
	}

	public void setFechafinprueba(java.util.Date fechafinprueba) {
		this.fechafinprueba = fechafinprueba;
	}
	public String getCrazonnvocontrato() {
		return crazonnvocontrato;
	}

	public void setCrazonnvocontrato(String crazonnvocontrato) {
		this.crazonnvocontrato = crazonnvocontrato;
	}
	public String getPractCentroformacion() {
		return practCentroformacion;
	}

	public void setPractCentroformacion(String practCentroformacion) {
		this.practCentroformacion = practCentroformacion;
	}
	public String getPractDomicilio() {
		return practDomicilio;
	}

	public void setPractDomicilio(String practDomicilio) {
		this.practDomicilio = practDomicilio;
	}
	public String getPractEspecialidad() {
		return practEspecialidad;
	}

	public void setPractEspecialidad(String practEspecialidad) {
		this.practEspecialidad = practEspecialidad;
	}
	public String getPractHorario() {
		return practHorario;
	}

	public void setPractHorario(String practHorario) {
		this.practHorario = practHorario;
	}
	public String getPractRepresentante() {
		return practRepresentante;
	}

	public void setPractRepresentante(String practRepresentante) {
		this.practRepresentante = practRepresentante;
	}
	public String getPractRepresentantedni() {
		return practRepresentantedni;
	}

	public void setPractRepresentantedni(String practRepresentantedni) {
		this.practRepresentantedni = practRepresentantedni;
	}
	public String getPractRuc() {
		return practRuc;
	}

	public void setPractRuc(String practRuc) {
		this.practRuc = practRuc;
	}
	public String getPractSituacion() {
		return practSituacion;
	}

	public void setPractSituacion(String practSituacion) {
		this.practSituacion = practSituacion;
	}
	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getComentarios1() {
		return comentarios1;
	}

	public void setComentarios1(String comentarios1) {
		this.comentarios1 = comentarios1;
	}
	public String getDepartamentooperacional() {
		return departamentooperacional;
	}

	public void setDepartamentooperacional(String departamentooperacional) {
		this.departamentooperacional = departamentooperacional;
	}
	public String getSustento() {
		return sustento;
	}

	public void setSustento(String sustento) {
		this.sustento = sustento;
	}
	public Integer getEmpleadosuplencia() {
		return empleadosuplencia;
	}

	public void setEmpleadosuplencia(Integer empleadosuplencia) {
		this.empleadosuplencia = empleadosuplencia;
	}
	public Integer getCargosuplencia() {
		return cargosuplencia;
	}

	public void setCargosuplencia(Integer cargosuplencia) {
		this.cargosuplencia = cargosuplencia;
	}
	public String getLocacionpagosuplencia() {
		return locacionpagosuplencia;
	}

	public void setLocacionpagosuplencia(String locacionpagosuplencia) {
		this.locacionpagosuplencia = locacionpagosuplencia;
	}
	public String getMotivosuplencia() {
		return motivosuplencia;
	}

	public void setMotivosuplencia(String motivosuplencia) {
		this.motivosuplencia = motivosuplencia;
	}
	public String getResolucionsuplencia() {
		return resolucionsuplencia;
	}

	public void setResolucionsuplencia(String resolucionsuplencia) {
		this.resolucionsuplencia = resolucionsuplencia;
	}
	public java.util.Date getFechasuplencia() {
		return fechasuplencia;
	}

	public void setFechasuplencia(java.util.Date fechasuplencia) {
		this.fechasuplencia = fechasuplencia;
	}
	public java.util.Date getFecharesoluciontex() {
		return fecharesoluciontex;
	}

	public void setFecharesoluciontex(java.util.Date fecharesoluciontex) {
		this.fecharesoluciontex = fecharesoluciontex;
	}
	public String getResoluciondesig() {
		return resoluciondesig;
	}

	public void setResoluciondesig(String resoluciondesig) {
		this.resoluciondesig = resoluciondesig;
	}
	public java.util.Date getFechadesig() {
		return fechadesig;
	}

	public void setFechadesig(java.util.Date fechadesig) {
		this.fechadesig = fechadesig;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getNumeromemo() {
		return numeromemo;
	}

	public void setNumeromemo(String numeromemo) {
		this.numeromemo = numeromemo;
	}
	public java.util.Date getFechamemo() {
		return fechamemo;
	}

	public void setFechamemo(java.util.Date fechamemo) {
		this.fechamemo = fechamemo;
	}
	public Integer getJefeofiadm() {
		return jefeofiadm;
	}

	public void setJefeofiadm(Integer jefeofiadm) {
		this.jefeofiadm = jefeofiadm;
	}
	public String getCentrocostojefe() {
		return centrocostojefe;
	}

	public void setCentrocostojefe(String centrocostojefe) {
		this.centrocostojefe = centrocostojefe;
	}
	public java.util.Date getFechacontratoant() {
		return fechacontratoant;
	}

	public void setFechacontratoant(java.util.Date fechacontratoant) {
		this.fechacontratoant = fechacontratoant;
	}
	public java.util.Date getFechaproveido() {
		return fechaproveido;
	}

	public void setFechaproveido(java.util.Date fechaproveido) {
		this.fechaproveido = fechaproveido;
	}
	public String getCentrocostoanterior() {
		return centrocostoanterior;
	}

	public void setCentrocostoanterior(String centrocostoanterior) {
		this.centrocostoanterior = centrocostoanterior;
	}
	public String getResolucionjefat() {
		return resolucionjefat;
	}

	public void setResolucionjefat(String resolucionjefat) {
		this.resolucionjefat = resolucionjefat;
	}
	public java.util.Date getFechafacultado() {
		return fechafacultado;
	}

	public void setFechafacultado(java.util.Date fechafacultado) {
		this.fechafacultado = fechafacultado;
	}
	public java.util.Date getFechacartapresent() {
		return fechacartapresent;
	}

	public void setFechacartapresent(java.util.Date fechacartapresent) {
		this.fechacartapresent = fechacartapresent;
	}
	public Integer getReprelegalRleg() {
		return reprelegalRleg;
	}

	public void setReprelegalRleg(Integer reprelegalRleg) {
		this.reprelegalRleg = reprelegalRleg;
	}
	public String getResoluciondesigRleg() {
		return resoluciondesigRleg;
	}

	public void setResoluciondesigRleg(String resoluciondesigRleg) {
		this.resoluciondesigRleg = resoluciondesigRleg;
	}
	public java.util.Date getFechadesigRleg() {
		return fechadesigRleg;
	}

	public void setFechadesigRleg(java.util.Date fechadesigRleg) {
		this.fechadesigRleg = fechadesigRleg;
	}
	public String getResolucionjefatRleg() {
		return resolucionjefatRleg;
	}

	public void setResolucionjefatRleg(String resolucionjefatRleg) {
		this.resolucionjefatRleg = resolucionjefatRleg;
	}
	public java.util.Date getFechafacultadoRleg() {
		return fechafacultadoRleg;
	}

	public void setFechafacultadoRleg(java.util.Date fechafacultadoRleg) {
		this.fechafacultadoRleg = fechafacultadoRleg;
	}
	public Integer getMesesadicionales() {
		return mesesadicionales;
	}

	public void setMesesadicionales(Integer mesesadicionales) {
		this.mesesadicionales = mesesadicionales;
	}
	public String getPractRepresentantecargo() {
		return practRepresentantecargo;
	}

	public void setPractRepresentantecargo(String practRepresentantecargo) {
		this.practRepresentantecargo = practRepresentantecargo;
	}
	public String getPractDiaspractica() {
		return practDiaspractica;
	}

	public void setPractDiaspractica(String practDiaspractica) {
		this.practDiaspractica = practDiaspractica;
	}
	public String getCargoant() {
		return cargoant;
	}

	public void setCargoant(String cargoant) {
		this.cargoant = cargoant;
	}
	public java.util.Date getFechainicioadicional() {
		return fechainicioadicional;
	}

	public void setFechainicioadicional(java.util.Date fechainicioadicional) {
		this.fechainicioadicional = fechainicioadicional;
	}
	public String getPeriodoadicional() {
		return periodoadicional;
	}

	public void setPeriodoadicional(String periodoadicional) {
		this.periodoadicional = periodoadicional;
	}
	public Integer getNumerosecuencia() {
		return numerosecuencia;
	}

	public void setNumerosecuencia(Integer numerosecuencia) {
		this.numerosecuencia = numerosecuencia;
	}
	public Integer getNumerosecuenciaaddemdum() {
		return numerosecuenciaaddemdum;
	}

	public void setNumerosecuenciaaddemdum(Integer numerosecuenciaaddemdum) {
		this.numerosecuenciaaddemdum = numerosecuenciaaddemdum;
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

}
