package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoFechaPago implements Serializable {

	private Date fechaPago;

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

}
