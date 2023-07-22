package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadoasistencias
*/
public class HrEmpleadoasistencias extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadoasistenciasPk pk;
	private String periodo;
	private Integer totaldias;
	private Integer totalhoras;
	private String unidadnegocio;
	private String companyowner;


	public HrEmpleadoasistencias() {
		pk = new HrEmpleadoasistenciasPk();
	}

	public HrEmpleadoasistenciasPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadoasistenciasPk pk) {
		this.pk = pk;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

}
