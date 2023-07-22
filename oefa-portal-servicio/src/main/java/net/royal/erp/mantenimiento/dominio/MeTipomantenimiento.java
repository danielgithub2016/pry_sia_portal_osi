package net.royal.erp.mantenimiento.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder mantenimiento.MeTipomantenimiento
*/
public class MeTipomantenimiento extends DominioGenerico implements java.io.Serializable{

	private MeTipomantenimientoPk pk;
	private String descripcionlocal;
	private String descripcioningles;
	private String estado;
	private Integer horakilometraje;
	private String maquinacodigo;


	public MeTipomantenimiento() {
		pk = new MeTipomantenimientoPk();
	}

	public MeTipomantenimientoPk getPk() {
		return pk;
	}

	public void setPk(MeTipomantenimientoPk pk) {
		this.pk = pk;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getHorakilometraje() {
		return horakilometraje;
	}

	public void setHorakilometraje(Integer horakilometraje) {
		this.horakilometraje = horakilometraje;
	}
	public String getMaquinacodigo() {
		return maquinacodigo;
	}

	public void setMaquinacodigo(String maquinacodigo) {
		this.maquinacodigo = maquinacodigo;
	}

}
