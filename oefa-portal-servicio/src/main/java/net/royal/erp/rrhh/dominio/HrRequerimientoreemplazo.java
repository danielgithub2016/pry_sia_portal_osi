package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientoreemplazo
 */
public class HrRequerimientoreemplazo extends DominioGenerico implements
		java.io.Serializable {

	private HrRequerimientoreemplazoPk pk;
	private Integer motivocese;
	private java.util.Date fechacese;
	private Integer codigopuesto;
	private Date fechainicio;

	private String auxiliarempleado;
	private String auxiliarmotivo;
	private String auxiliarpuesto;
	private BigDecimal auxiliarsueldo;
	

	public HrRequerimientoreemplazo() {
		pk = new HrRequerimientoreemplazoPk();
	}

	public HrRequerimientoreemplazoPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientoreemplazoPk pk) {
		this.pk = pk;
	}

	public Integer getMotivocese() {
		return motivocese;
	}

	public void setMotivocese(Integer motivocese) {
		this.motivocese = motivocese;
	}

	public java.util.Date getFechacese() {
		return fechacese;
	}

	public void setFechacese(java.util.Date fechacese) {
		this.fechacese = fechacese;
	}

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	/**
	 * @return the auxiliarempleado
	 */
	public String getAuxiliarempleado() {
		return auxiliarempleado;
	}

	/**
	 * @param auxiliarempleado
	 *            the auxiliarempleado to set
	 */
	public void setAuxiliarempleado(String auxiliarempleado) {
		this.auxiliarempleado = auxiliarempleado;
	}

	/**
	 * @return the auxiliarmotivo
	 */
	public String getAuxiliarmotivo() {
		return auxiliarmotivo;
	}

	/**
	 * @param auxiliarmotivo
	 *            the auxiliarmotivo to set
	 */
	public void setAuxiliarmotivo(String auxiliarmotivo) {
		this.auxiliarmotivo = auxiliarmotivo;
	}

	/**
	 * @return the auxiliarpuesto
	 */
	public String getAuxiliarpuesto() {
		return auxiliarpuesto;
	}

	/**
	 * @param auxiliarpuesto
	 *            the auxiliarpuesto to set
	 */
	public void setAuxiliarpuesto(String auxiliarpuesto) {
		this.auxiliarpuesto = auxiliarpuesto;
	}

	/**
	 * @return the auxiliarsueldo
	 */
	public BigDecimal getAuxiliarsueldo() {
		if (UValidador.esNulo(auxiliarsueldo)) {
			auxiliarsueldo = BigDecimal.ZERO;
		}
		return auxiliarsueldo.setScale(2, RoundingMode.HALF_DOWN);
	}

	/**
	 * @param auxiliarsueldo
	 *            the auxiliarsueldo to set
	 */
	public void setAuxiliarsueldo(BigDecimal auxiliarsueldo) {
		this.auxiliarsueldo = auxiliarsueldo;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	
}
