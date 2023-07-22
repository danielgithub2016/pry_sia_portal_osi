package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionesrango
*/
public class HrEvaluacionesrango extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacionesrangoPk pk;
	private String descripcion;
	private BigDecimal valor;
	private BigDecimal desde;
	private BigDecimal hasta;


	public HrEvaluacionesrango() {
		pk = new HrEvaluacionesrangoPk();
	}

	public HrEvaluacionesrangoPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionesrangoPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getDesde() {
		return desde;
	}

	public BigDecimal getHasta() {
		return hasta;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDesde(BigDecimal desde) {
		this.desde = desde;
	}

	public void setHasta(BigDecimal hasta) {
		this.hasta = hasta;
	}
}






