package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.core.UString;
import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPostulanteexperiencia
 */
@SuppressWarnings("serial")
public class HrPostulanteexperiencia extends DominioGenerico implements
		java.io.Serializable {

	private HrPostulanteexperienciaPk pk;
	private String empresa;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private String cargoocupado;
	private String giroempresa;
	private String especialidad;
	private String funciones;
	private String trabajosrealizados;
	private Integer sueldo;
	private String motivocese;
	private String unidadnegocio;
	private String objetivosalcanzados;
	private String moneda;
	private String areaexperiencia;
	private String tipoexperiencia;
	private Integer codigopuesto;
	private Integer personasacargo;
	private String tipocontrato;
	private String nombrejefe;
	private String cargojefe;
	private String telefono;

	public HrPostulanteexperiencia() {
		pk = new HrPostulanteexperienciaPk();
	}

	public HrPostulanteexperienciaPk getPk() {
		return pk;
	}

	public void setPk(HrPostulanteexperienciaPk pk) {
		this.pk = pk;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = UString.upper(empresa);
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

	public String getCargoocupado() {
		return cargoocupado;
	}

	public void setCargoocupado(String cargoocupado) {
		this.cargoocupado = UString.upper(cargoocupado);
	}

	public String getGiroempresa() {
		return giroempresa;
	}

	public void setGiroempresa(String giroempresa) {
		this.giroempresa = UString.upper(giroempresa);
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = UString.upper(especialidad);
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = UString.upper(funciones);
	}

	public String getTrabajosrealizados() {
		return trabajosrealizados;
	}

	public void setTrabajosrealizados(String trabajosrealizados) {
		this.trabajosrealizados = UString.upper(trabajosrealizados);
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public String getMotivocese() {
		return motivocese;
	}

	public void setMotivocese(String motivocese) {
		this.motivocese = motivocese;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getObjetivosalcanzados() {
		return objetivosalcanzados;
	}

	public void setObjetivosalcanzados(String objetivosalcanzados) {
		this.objetivosalcanzados = UString.upper(objetivosalcanzados);
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getAreaexperiencia() {
		return areaexperiencia;
	}

	public void setAreaexperiencia(String areaexperiencia) {
		this.areaexperiencia = areaexperiencia;
	}

	public String getTipoexperiencia() {
		return tipoexperiencia;
	}

	public void setTipoexperiencia(String tipoexperiencia) {
		if (tipoexperiencia == null)
			tipoexperiencia = "";
		this.tipoexperiencia = tipoexperiencia;
	}

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	public Integer getPersonasacargo() {
		return personasacargo;
	}

	public void setPersonasacargo(Integer personasacargo) {
		this.personasacargo = personasacargo;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = UString.upper(tipocontrato);
	}

	public String getNombrejefe() {
		return nombrejefe;
	}

	public void setNombrejefe(String nombrejefe) {
		this.nombrejefe = nombrejefe;
	}

	public String getCargojefe() {
		return cargojefe;
	}

	public void setCargojefe(String cargojefe) {
		this.cargojefe = cargojefe;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
