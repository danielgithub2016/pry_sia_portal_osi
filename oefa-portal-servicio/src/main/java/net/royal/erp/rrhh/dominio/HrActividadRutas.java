package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadRutas
*/
public class HrActividadRutas extends DominioGenerico implements java.io.Serializable{

	private HrActividadRutasPk pk;
	private Integer secuencia;
	private String rutadocumento;
	private byte[] ruta;
	private String estado;


	public HrActividadRutas() {
		pk = new HrActividadRutasPk();
	}

	public HrActividadRutasPk getPk() {
		return pk;
	}

	public void setPk(HrActividadRutasPk pk) {
		this.pk = pk;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}
	public byte[] getRuta() {
		return ruta;
	}

	public void setRuta(byte[] ruta) {
		this.ruta = ruta;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
