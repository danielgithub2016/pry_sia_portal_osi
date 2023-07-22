package net.royal.erp.sistema.dominio.dto;

import net.royal.erp.core.dominio.Primemst;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_account_select_list
 */
public class DtoDwMaAccountSelectList implements java.io.Serializable {

	private String account;
	private String codigodescripcionflag;
	private String prime_all;
	private String elemento_all;
	private String multicompanyflag;
	private String localname;
	private String companyowner;
	private String element;
	private String element_1;
	private String prime1;
	private String prime_1;
	private String localname_1;
	private String flag;
	private Integer total;
	public String estilo;

	private DtoDwMaElementSelect elemento;
	private Primemst prime;

	private boolean boolCuentaMayor;
	private boolean boolElemento;

	public DtoDwMaAccountSelectList() {
		prime = new Primemst();
		elemento = new DtoDwMaElementSelect();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCodigodescripcionflag() {
		return codigodescripcionflag;
	}

	public void setCodigodescripcionflag(String codigodescripcionflag) {
		this.codigodescripcionflag = codigodescripcionflag;
	}

	public String getPrime_all() {
		return prime_all;
	}

	public void setPrime_all(String prime_all) {
		this.prime_all = prime_all;
	}

	public String getElemento_all() {
		return elemento_all;
	}

	public void setElemento_all(String elemento_all) {
		this.elemento_all = elemento_all;
	}

	public String getMulticompanyflag() {
		return multicompanyflag;
	}

	public void setMulticompanyflag(String multicompanyflag) {
		this.multicompanyflag = multicompanyflag;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Primemst getPrime() {
		return prime;
	}

	public void setPrime(Primemst prime) {
		this.prime = prime;
	}

	public String getElement_1() {
		return element_1;
	}

	public void setElement_1(String element_1) {
		this.element_1 = element_1;
	}

	public DtoDwMaElementSelect getElemento() {
		return elemento;
	}

	public void setElemento(DtoDwMaElementSelect elemento) {
		this.elemento = elemento;
	}

	public boolean isBoolCuentaMayor() {
		return boolCuentaMayor;
	}

	public void setBoolCuentaMayor(boolean boolCuentaMayor) {
		prime = new Primemst();
		this.boolCuentaMayor = boolCuentaMayor;
	}

	public boolean isBoolElemento() {
		return boolElemento;
	}

	public void setBoolElemento(boolean boolElemento) {
		elemento = new DtoDwMaElementSelect();
		this.boolElemento = boolElemento;
	}

	public String getLocalname_1() {
		return localname_1;
	}

	public void setLocalname_1(String localname_1) {
		this.localname_1 = localname_1;
	}

	public String getPrime_1() {
		return prime_1;
	}

	public void setPrime_1(String prime_1) {
		this.prime_1 = prime_1;
	}

	public String getPrime1() {
		return prime1;
	}

	public void setPrime1(String prime1) {
		this.prime1 = prime1;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
}
