package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuControlpresupuestalDistrib
*/
public class BuControlpresupuestalDistrib extends DominioGenerico implements java.io.Serializable{

	private BuControlpresupuestalDistribPk pk;
	private String centrocosto;
	private String centrocostodestino;
	private String cuentacontable;
	private String partidapresupuestal;
	private String proyecto;
	private String camporeferencia;
	private BigDecimal monto;
	private String sucursal;
	private String referenciafiscal01;
	private String referenciafiscal02;
	private String referenciafiscal03;
	private Integer montodolares;


	public BuControlpresupuestalDistrib() {
		pk = new BuControlpresupuestalDistribPk();
	}

	public BuControlpresupuestalDistribPk getPk() {
		return pk;
	}

	public void setPk(BuControlpresupuestalDistribPk pk) {
		this.pk = pk;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getCentrocostodestino() {
		return centrocostodestino;
	}

	public void setCentrocostodestino(String centrocostodestino) {
		this.centrocostodestino = centrocostodestino;
	}
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public String getPartidapresupuestal() {
		return partidapresupuestal;
	}

	public void setPartidapresupuestal(String partidapresupuestal) {
		this.partidapresupuestal = partidapresupuestal;
	}
	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getCamporeferencia() {
		return camporeferencia;
	}

	public void setCamporeferencia(String camporeferencia) {
		this.camporeferencia = camporeferencia;
	}
	
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getReferenciafiscal01() {
		return referenciafiscal01;
	}

	public void setReferenciafiscal01(String referenciafiscal01) {
		this.referenciafiscal01 = referenciafiscal01;
	}
	public String getReferenciafiscal02() {
		return referenciafiscal02;
	}

	public void setReferenciafiscal02(String referenciafiscal02) {
		this.referenciafiscal02 = referenciafiscal02;
	}
	public String getReferenciafiscal03() {
		return referenciafiscal03;
	}

	public void setReferenciafiscal03(String referenciafiscal03) {
		this.referenciafiscal03 = referenciafiscal03;
	}
	public Integer getMontodolares() {
		return montodolares;
	}

	public void setMontodolares(Integer montodolares) {
		this.montodolares = montodolares;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

}
