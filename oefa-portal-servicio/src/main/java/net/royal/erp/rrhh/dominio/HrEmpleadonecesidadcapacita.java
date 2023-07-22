package net.royal.erp.rrhh.dominio;

import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadonecesidadcapacita
*/
public class HrEmpleadonecesidadcapacita extends DominioGenerico implements java.io.Serializable,Comparable<HrEmpleadonecesidadcapacita>{

	private HrEmpleadonecesidadcapacitaPk pk;
	private Integer prioridad;
	private Integer curso;
	private String objetivo;
	private String necesidad;
	private String capacitacion;


	public HrEmpleadonecesidadcapacita() {
		pk = new HrEmpleadonecesidadcapacitaPk();
	}

	public HrEmpleadonecesidadcapacitaPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadonecesidadcapacitaPk pk) {
		this.pk = pk;
	}
	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getNecesidad() {
		return necesidad;
	}

	public void setNecesidad(String necesidad) {
		this.necesidad = necesidad;
	}
	public String getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}

	@Override
	public int compareTo(HrEmpleadonecesidadcapacita o) {
		if(prioridad<o.getPrioridad()){
			 return -1;
		}
		
		if(prioridad>o.getPrioridad()){
			 return 1;
		}
		
		return 0;
	}


}
