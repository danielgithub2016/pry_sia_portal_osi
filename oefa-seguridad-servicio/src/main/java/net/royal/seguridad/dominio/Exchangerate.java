package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Exchangerate
*/
public class Exchangerate extends DominioGenerico implements java.io.Serializable{

	private ExchangeratePk pk;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal monthcloserate;
	private java.math.BigDecimal monthbuyrate;
	private java.math.BigDecimal monthsalerate;
	private java.math.BigDecimal gainandlossrate;
	private java.math.BigDecimal inflationfactor;
	private java.math.BigDecimal inflationfactoracumulated;
	private java.math.BigDecimal sbsrate;
	private String lastuser;
	private java.util.Date lastdate;
	private String status;


	public Exchangerate() {
		pk = new ExchangeratePk();
	}

	public ExchangeratePk getPk() {
		return pk;
	}

	public void setPk(ExchangeratePk pk) {
		this.pk = pk;
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
	public java.math.BigDecimal getSbsrate() {
		return sbsrate;
	}

	public void setSbsrate(java.math.BigDecimal sbsrate) {
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
