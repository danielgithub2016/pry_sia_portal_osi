package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuPresupuesto
*/
public class BuPresupuesto extends DominioGenerico implements java.io.Serializable{

	private BuPresupuestoPk pk;
	private Integer monto01;
	private Integer monto02;
	private Integer monto03;
	private Integer monto04;
	private Integer monto05;
	private Integer monto06;
	private Integer monto07;
	private Integer monto08;
	private Integer monto09;
	private Integer monto10;
	private Integer monto11;
	private Integer monto12;
	private String estado;
	private String origen;
	private Integer montoreferencial;
	private Integer montoanual01;
	private Integer montoanual02;
	private Integer montoanual03;
	private Integer montoanual04;
	private Integer montoanual05;
	private String referenciafiscal01;
	private String referenciafiscal03;
	private String ampliacionnumero;
	private Integer periodopoa;
	private Integer identificadorpoa;
	private String referencia;


	public BuPresupuesto() {
		pk = new BuPresupuestoPk();
	}

	public BuPresupuestoPk getPk() {
		return pk;
	}

	public void setPk(BuPresupuestoPk pk) {
		this.pk = pk;
	}
	public Integer getMonto01() {
		return monto01;
	}

	public void setMonto01(Integer monto01) {
		this.monto01 = monto01;
	}
	public Integer getMonto02() {
		return monto02;
	}

	public void setMonto02(Integer monto02) {
		this.monto02 = monto02;
	}
	public Integer getMonto03() {
		return monto03;
	}

	public void setMonto03(Integer monto03) {
		this.monto03 = monto03;
	}
	public Integer getMonto04() {
		return monto04;
	}

	public void setMonto04(Integer monto04) {
		this.monto04 = monto04;
	}
	public Integer getMonto05() {
		return monto05;
	}

	public void setMonto05(Integer monto05) {
		this.monto05 = monto05;
	}
	public Integer getMonto06() {
		return monto06;
	}

	public void setMonto06(Integer monto06) {
		this.monto06 = monto06;
	}
	public Integer getMonto07() {
		return monto07;
	}

	public void setMonto07(Integer monto07) {
		this.monto07 = monto07;
	}
	public Integer getMonto08() {
		return monto08;
	}

	public void setMonto08(Integer monto08) {
		this.monto08 = monto08;
	}
	public Integer getMonto09() {
		return monto09;
	}

	public void setMonto09(Integer monto09) {
		this.monto09 = monto09;
	}
	public Integer getMonto10() {
		return monto10;
	}

	public void setMonto10(Integer monto10) {
		this.monto10 = monto10;
	}
	public Integer getMonto11() {
		return monto11;
	}

	public void setMonto11(Integer monto11) {
		this.monto11 = monto11;
	}
	public Integer getMonto12() {
		return monto12;
	}

	public void setMonto12(Integer monto12) {
		this.monto12 = monto12;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Integer getMontoreferencial() {
		return montoreferencial;
	}

	public void setMontoreferencial(Integer montoreferencial) {
		this.montoreferencial = montoreferencial;
	}
	public Integer getMontoanual01() {
		return montoanual01;
	}

	public void setMontoanual01(Integer montoanual01) {
		this.montoanual01 = montoanual01;
	}
	public Integer getMontoanual02() {
		return montoanual02;
	}

	public void setMontoanual02(Integer montoanual02) {
		this.montoanual02 = montoanual02;
	}
	public Integer getMontoanual03() {
		return montoanual03;
	}

	public void setMontoanual03(Integer montoanual03) {
		this.montoanual03 = montoanual03;
	}
	public Integer getMontoanual04() {
		return montoanual04;
	}

	public void setMontoanual04(Integer montoanual04) {
		this.montoanual04 = montoanual04;
	}
	public Integer getMontoanual05() {
		return montoanual05;
	}

	public void setMontoanual05(Integer montoanual05) {
		this.montoanual05 = montoanual05;
	}
	public String getReferenciafiscal01() {
		return referenciafiscal01;
	}

	public void setReferenciafiscal01(String referenciafiscal01) {
		this.referenciafiscal01 = referenciafiscal01;
	}
	public String getReferenciafiscal03() {
		return referenciafiscal03;
	}

	public void setReferenciafiscal03(String referenciafiscal03) {
		this.referenciafiscal03 = referenciafiscal03;
	}
	public String getAmpliacionnumero() {
		return ampliacionnumero;
	}

	public void setAmpliacionnumero(String ampliacionnumero) {
		this.ampliacionnumero = ampliacionnumero;
	}
	public Integer getPeriodopoa() {
		return periodopoa;
	}

	public void setPeriodopoa(Integer periodopoa) {
		this.periodopoa = periodopoa;
	}
	public Integer getIdentificadorpoa() {
		return identificadorpoa;
	}

	public void setIdentificadorpoa(Integer identificadorpoa) {
		this.identificadorpoa = identificadorpoa;
	}
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
