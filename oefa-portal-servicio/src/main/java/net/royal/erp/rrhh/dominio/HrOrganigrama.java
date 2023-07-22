package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrOrganigrama
*/
public class HrOrganigrama extends DominioGenerico implements java.io.Serializable{

	private HrOrganigramaPk pk;
	private String codigorama;
	private Integer codigopuesto;
	private Integer codigoposicion;
	private Integer posicionfinal;
	private String flagpuesto;
	private String flagjefe;
	private Integer orden;
	private String unidadreplicacion;
	private Integer numeroestandar;
	private Integer ordenpuesto;
	private String prevista;


	public HrOrganigrama() {
		pk = new HrOrganigramaPk();
	}

	public HrOrganigramaPk getPk() {
		return pk;
	}

	public void setPk(HrOrganigramaPk pk) {
		this.pk = pk;
	}
	public String getCodigorama() {
		return codigorama;
	}

	public void setCodigorama(String codigorama) {
		this.codigorama = codigorama;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getCodigoposicion() {
		return codigoposicion;
	}

	public void setCodigoposicion(Integer codigoposicion) {
		this.codigoposicion = codigoposicion;
	}
	public Integer getPosicionfinal() {
		return posicionfinal;
	}

	public void setPosicionfinal(Integer posicionfinal) {
		this.posicionfinal = posicionfinal;
	}
	public String getFlagpuesto() {
		return flagpuesto;
	}

	public void setFlagpuesto(String flagpuesto) {
		this.flagpuesto = flagpuesto;
	}
	public String getFlagjefe() {
		return flagjefe;
	}

	public void setFlagjefe(String flagjefe) {
		this.flagjefe = flagjefe;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public Integer getNumeroestandar() {
		return numeroestandar;
	}

	public void setNumeroestandar(Integer numeroestandar) {
		this.numeroestandar = numeroestandar;
	}
	public Integer getOrdenpuesto() {
		return ordenpuesto;
	}

	public void setOrdenpuesto(Integer ordenpuesto) {
		this.ordenpuesto = ordenpuesto;
	}
	public String getPrevista() {
		return prevista;
	}

	public void setPrevista(String prevista) {
		this.prevista = prevista;
	}

}
