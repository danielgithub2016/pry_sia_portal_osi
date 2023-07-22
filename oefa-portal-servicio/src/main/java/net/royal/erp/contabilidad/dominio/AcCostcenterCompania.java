package net.royal.erp.contabilidad.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

public class AcCostcenterCompania extends DominioGenerico implements
		Serializable {
	private AcCostcenterCompaniaPk pk;
	private String descripcion;
	private String estado;
	private String flgingsrv;
	private String flgingbie;
	private String flgingsum;
	private String flgingpas;
	private String flgingvia;
	private String flgingcaj;
	private String flggenns;
	private String flgconsrv;
	private String flgconbie;
	private String flgconsum;
	private String flgconpas;
	private String flgconvia;
	private String flgconcaj;
	private String flgconplp;
	private String flgconrh;
	private String mandato;
	private String mision;
	private String vision;
	private BigDecimal montoautorizado;
	private Date fechainicio;
	private Date fechafin;
	private Date fechainicio2;
	private Date fechafin2;
	private Integer facilitador;
	private String periodoingresopoa;
	private Date fecini01;
	private Date fecfin01;
	private Date fecini02;
	private Date fecfin02;
	private Date fecini03;
	private Date fecfin03;
	private Date fecini04;
	private Date fecfin04;
	private Date fecinifor;
	private Date fecfinfor;
	private Date fecinirefor;
	private Date fecfinrefor;
	private String flgreqfilepoa01;
	private String flgcumevapoa01;
	private String flgreqfilepoa02;
	private String flgcumevapoa02;
	private String flgreqfilepoa03;
	private String flgcumevapoa03;
	private String flgreqfilepoa04;
	private String flgcumevapoa04;
	public AcCostcenterCompaniaPk getPk() {
		return pk;
	}
	public void setPk(AcCostcenterCompaniaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlgingsrv() {
		return flgingsrv;
	}
	public void setFlgingsrv(String flgingsrv) {
		this.flgingsrv = flgingsrv;
	}
	public String getFlgingbie() {
		return flgingbie;
	}
	public void setFlgingbie(String flgingbie) {
		this.flgingbie = flgingbie;
	}
	public String getFlgingsum() {
		return flgingsum;
	}
	public void setFlgingsum(String flgingsum) {
		this.flgingsum = flgingsum;
	}
	public String getFlgingpas() {
		return flgingpas;
	}
	public void setFlgingpas(String flgingpas) {
		this.flgingpas = flgingpas;
	}
	public String getFlgingvia() {
		return flgingvia;
	}
	public void setFlgingvia(String flgingvia) {
		this.flgingvia = flgingvia;
	}
	public String getFlgingcaj() {
		return flgingcaj;
	}
	public void setFlgingcaj(String flgingcaj) {
		this.flgingcaj = flgingcaj;
	}
	public String getFlggenns() {
		return flggenns;
	}
	public void setFlggenns(String flggenns) {
		this.flggenns = flggenns;
	}
	public String getFlgconsrv() {
		return flgconsrv;
	}
	public void setFlgconsrv(String flgconsrv) {
		this.flgconsrv = flgconsrv;
	}
	public String getFlgconbie() {
		return flgconbie;
	}
	public void setFlgconbie(String flgconbie) {
		this.flgconbie = flgconbie;
	}
	public String getFlgconsum() {
		return flgconsum;
	}
	public void setFlgconsum(String flgconsum) {
		this.flgconsum = flgconsum;
	}
	public String getFlgconpas() {
		return flgconpas;
	}
	public void setFlgconpas(String flgconpas) {
		this.flgconpas = flgconpas;
	}
	public String getFlgconvia() {
		return flgconvia;
	}
	public void setFlgconvia(String flgconvia) {
		this.flgconvia = flgconvia;
	}
	public String getFlgconcaj() {
		return flgconcaj;
	}
	public void setFlgconcaj(String flgconcaj) {
		this.flgconcaj = flgconcaj;
	}
	public String getFlgconplp() {
		return flgconplp;
	}
	public void setFlgconplp(String flgconplp) {
		this.flgconplp = flgconplp;
	}
	public String getFlgconrh() {
		return flgconrh;
	}
	public void setFlgconrh(String flgconrh) {
		this.flgconrh = flgconrh;
	}
	public String getMandato() {
		return mandato;
	}
	public void setMandato(String mandato) {
		this.mandato = mandato;
	}
	public String getMision() {
		return mision;
	}
	public void setMision(String mision) {
		this.mision = mision;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public BigDecimal getMontoautorizado() {
		return montoautorizado;
	}
	public void setMontoautorizado(BigDecimal montoautorizado) {
		this.montoautorizado = montoautorizado;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public Date getFechainicio2() {
		return fechainicio2;
	}
	public void setFechainicio2(Date fechainicio2) {
		this.fechainicio2 = fechainicio2;
	}
	public Date getFechafin2() {
		return fechafin2;
	}
	public void setFechafin2(Date fechafin2) {
		this.fechafin2 = fechafin2;
	}
	public Integer getFacilitador() {
		return facilitador;
	}
	public void setFacilitador(Integer facilitador) {
		this.facilitador = facilitador;
	}
	public String getPeriodoingresopoa() {
		return periodoingresopoa;
	}
	public void setPeriodoingresopoa(String periodoingresopoa) {
		this.periodoingresopoa = periodoingresopoa;
	}
	public Date getFecini01() {
		return fecini01;
	}
	public void setFecini01(Date fecini01) {
		this.fecini01 = fecini01;
	}
	public Date getFecfin01() {
		return fecfin01;
	}
	public void setFecfin01(Date fecfin01) {
		this.fecfin01 = fecfin01;
	}
	public Date getFecini02() {
		return fecini02;
	}
	public void setFecini02(Date fecini02) {
		this.fecini02 = fecini02;
	}
	public Date getFecfin02() {
		return fecfin02;
	}
	public void setFecfin02(Date fecfin02) {
		this.fecfin02 = fecfin02;
	}
	public Date getFecini03() {
		return fecini03;
	}
	public void setFecini03(Date fecini03) {
		this.fecini03 = fecini03;
	}
	public Date getFecfin03() {
		return fecfin03;
	}
	public void setFecfin03(Date fecfin03) {
		this.fecfin03 = fecfin03;
	}
	public Date getFecini04() {
		return fecini04;
	}
	public void setFecini04(Date fecini04) {
		this.fecini04 = fecini04;
	}
	public Date getFecfin04() {
		return fecfin04;
	}
	public void setFecfin04(Date fecfin04) {
		this.fecfin04 = fecfin04;
	}
	public Date getFecinifor() {
		return fecinifor;
	}
	public void setFecinifor(Date fecinifor) {
		this.fecinifor = fecinifor;
	}
	public Date getFecfinfor() {
		return fecfinfor;
	}
	public void setFecfinfor(Date fecfinfor) {
		this.fecfinfor = fecfinfor;
	}
	public Date getFecinirefor() {
		return fecinirefor;
	}
	public void setFecinirefor(Date fecinirefor) {
		this.fecinirefor = fecinirefor;
	}
	public Date getFecfinrefor() {
		return fecfinrefor;
	}
	public void setFecfinrefor(Date fecfinrefor) {
		this.fecfinrefor = fecfinrefor;
	}
	public String getFlgreqfilepoa01() {
		return flgreqfilepoa01;
	}
	public void setFlgreqfilepoa01(String flgreqfilepoa01) {
		this.flgreqfilepoa01 = flgreqfilepoa01;
	}
	public String getFlgcumevapoa01() {
		return flgcumevapoa01;
	}
	public void setFlgcumevapoa01(String flgcumevapoa01) {
		this.flgcumevapoa01 = flgcumevapoa01;
	}
	public String getFlgreqfilepoa02() {
		return flgreqfilepoa02;
	}
	public void setFlgreqfilepoa02(String flgreqfilepoa02) {
		this.flgreqfilepoa02 = flgreqfilepoa02;
	}
	public String getFlgcumevapoa02() {
		return flgcumevapoa02;
	}
	public void setFlgcumevapoa02(String flgcumevapoa02) {
		this.flgcumevapoa02 = flgcumevapoa02;
	}
	public String getFlgreqfilepoa03() {
		return flgreqfilepoa03;
	}
	public void setFlgreqfilepoa03(String flgreqfilepoa03) {
		this.flgreqfilepoa03 = flgreqfilepoa03;
	}
	public String getFlgcumevapoa03() {
		return flgcumevapoa03;
	}
	public void setFlgcumevapoa03(String flgcumevapoa03) {
		this.flgcumevapoa03 = flgcumevapoa03;
	}
	public String getFlgreqfilepoa04() {
		return flgreqfilepoa04;
	}
	public void setFlgreqfilepoa04(String flgreqfilepoa04) {
		this.flgreqfilepoa04 = flgreqfilepoa04;
	}
	public String getFlgcumevapoa04() {
		return flgcumevapoa04;
	}
	public void setFlgcumevapoa04(String flgcumevapoa04) {
		this.flgcumevapoa04 = flgcumevapoa04;
	}
	
	
}
