package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_tiposervicio_select_by_regimenfisc
 */
public class DtoDwMaTiposervicioSelectByRegimenfisc implements
		java.io.Serializable {
	
	private String tiposervicio;
	private String descripcion;
	private String regimenfiscal;
	private String clasificacionfiscal;

	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRegimenfiscal() {
		return regimenfiscal;
	}

	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}

	public String getClasificacionfiscal() {
		return clasificacionfiscal;
	}

	public void setClasificacionfiscal(String clasificacionfiscal) {
		this.clasificacionfiscal = clasificacionfiscal;
	}



}
