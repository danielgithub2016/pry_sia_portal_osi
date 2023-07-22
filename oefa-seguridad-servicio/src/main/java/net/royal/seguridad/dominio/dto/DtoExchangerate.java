package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Exchangerate
*/
public class DtoExchangerate implements java.io.Serializable{

	private String period;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal monthcloserate;
	private java.math.BigDecimal monthbuyrate;
	private java.math.BigDecimal monthsalerate;
	private java.math.BigDecimal gainandlossrate;
	private java.math.BigDecimal inflationfactor;
	private java.math.BigDecimal inflationfactoracumulated;
	private Integer sbsrate;
	private String lastuser;
	private java.util.Date lastdate;
	private String status;

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}
	public java.math.BigDecimal getMonthcloserate() {
		return monthcloserate;
	}

	public void setMonthcloserate(java.math.BigDecimal monthcloserate) {
		this.monthcloserate = monthcloserate;
	}
	public java.math.BigDecimal getMonthbuyrate() {
		return monthbuyrate;
	}

	public void setMonthbuyrate(java.math.BigDecimal monthbuyrate) {
		this.monthbuyrate = monthbuyrate;
	}
	public java.math.BigDecimal getMonthsalerate() {
		return monthsalerate;
	}

	public void setMonthsalerate(java.math.BigDecimal monthsalerate) {
		this.monthsalerate = monthsalerate;
	}
	public java.math.BigDecimal getGainandlossrate() {
		return gainandlossrate;
	}

	public void setGainandlossrate(java.math.BigDecimal gainandlossrate) {
		this.gainandlossrate = gainandlossrate;
	}
	public java.math.BigDecimal getInflationfactor() {
		return inflationfactor;
	}

	public void setInflationfactor(java.math.BigDecimal inflationfactor) {
		this.inflationfactor = inflationfactor;
	}
	public java.math.BigDecimal getInflationfactoracumulated() {
		return inflationfactoracumulated;
	}

	public void setInflationfactoracumulated(java.math.BigDecimal inflationfactoracumulated) {
		this.inflationfactoracumulated = inflationfactoracumulated;
	}
	public Integer getSbsrate() {
		return sbsrate;
	}

	public void setSbsrate(Integer sbsrate) {
		this.sbsrate = sbsrate;
	}
	public String getLastuser() {
		return lastuser;
	}

	public void setLastuser(String lastuser) {
		this.lastuser = lastuser;
	}
	public java.util.Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(java.util.Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
