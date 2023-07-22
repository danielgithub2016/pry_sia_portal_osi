package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sycommon.ds_today
 */
public class DtoDsToday implements java.io.Serializable {
	private BigDecimal  registronumero;
	private Date serverdate;
	
	
	public Date getServerdate() {
		return serverdate;
	}
	public void setServerdate(Date serverdate) {
		this.serverdate = serverdate;
	}
	public BigDecimal getRegistronumero() {
		return registronumero;
	}
	public void setRegistronumero(BigDecimal registronumero) {
		this.registronumero = registronumero;
	}
	
	

}
