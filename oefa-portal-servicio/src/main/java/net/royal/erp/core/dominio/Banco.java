package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Banco
*/
public class Banco extends DominioGenerico implements java.io.Serializable{

	private BancoPk pk;
	private String descripcioncorta;
	private String descripcionlarga;
	private Integer banconumero;
	private String personacontacto;
	private String conciliacionautomaticaflag;
	private String formatopropioflag;
	private String formatodatawindow;
	private String estado;
	private String conciliacionformatoflag;
	private String codigointerfaseafp;
	private String disponibleedflag;
	private String codigofiscal;
	private Integer tasaefectivaanual;
	private String cuentamatriz;
	private String codigosiaf;
	private String custodiaflag;
	private String codigobancomcpp;
	private String codigointerno;


	public Banco() {
		pk = new BancoPk();
	}

	public BancoPk getPk() {
		return pk;
	}

	public void setPk(BancoPk pk) {
		this.pk = pk;
	}
	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}
	public String getDescripcionlarga() {
		return descripcionlarga;
	}

	public void setDescripcionlarga(String descripcionlarga) {
		this.descripcionlarga = descripcionlarga;
	}
	public Integer getBanconumero() {
		return banconumero;
	}

	public void setBanconumero(Integer banconumero) {
		this.banconumero = banconumero;
	}
	public String getPersonacontacto() {
		return personacontacto;
	}

	public void setPersonacontacto(String personacontacto) {
		this.personacontacto = personacontacto;
	}
	public String getConciliacionautomaticaflag() {
		return conciliacionautomaticaflag;
	}

	public void setConciliacionautomaticaflag(String conciliacionautomaticaflag) {
		this.conciliacionautomaticaflag = conciliacionautomaticaflag;
	}
	public String getFormatopropioflag() {
		return formatopropioflag;
	}

	public void setFormatopropioflag(String formatopropioflag) {
		this.formatopropioflag = formatopropioflag;
	}
	public String getFormatodatawindow() {
		return formatodatawindow;
	}

	public void setFormatodatawindow(String formatodatawindow) {
		this.formatodatawindow = formatodatawindow;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getConciliacionformatoflag() {
		return conciliacionformatoflag;
	}

	public void setConciliacionformatoflag(String conciliacionformatoflag) {
		this.conciliacionformatoflag = conciliacionformatoflag;
	}
	public String getCodigointerfaseafp() {
		return codigointerfaseafp;
	}

	public void setCodigointerfaseafp(String codigointerfaseafp) {
		this.codigointerfaseafp = codigointerfaseafp;
	}
	public String getDisponibleedflag() {
		return disponibleedflag;
	}

	public void setDisponibleedflag(String disponibleedflag) {
		this.disponibleedflag = disponibleedflag;
	}
	public String getCodigofiscal() {
		return codigofiscal;
	}

	public void setCodigofiscal(String codigofiscal) {
		this.codigofiscal = codigofiscal;
	}
	public Integer getTasaefectivaanual() {
		return tasaefectivaanual;
	}

	public void setTasaefectivaanual(Integer tasaefectivaanual) {
		this.tasaefectivaanual = tasaefectivaanual;
	}
	public String getCuentamatriz() {
		return cuentamatriz;
	}

	public void setCuentamatriz(String cuentamatriz) {
		this.cuentamatriz = cuentamatriz;
	}
	public String getCodigosiaf() {
		return codigosiaf;
	}

	public void setCodigosiaf(String codigosiaf) {
		this.codigosiaf = codigosiaf;
	}
	public String getCustodiaflag() {
		return custodiaflag;
	}

	public void setCustodiaflag(String custodiaflag) {
		this.custodiaflag = custodiaflag;
	}
	public String getCodigobancomcpp() {
		return codigobancomcpp;
	}

	public void setCodigobancomcpp(String codigobancomcpp) {
		this.codigobancomcpp = codigobancomcpp;
	}
	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

}
