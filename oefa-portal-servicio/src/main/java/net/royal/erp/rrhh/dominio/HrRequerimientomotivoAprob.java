package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientomotivoAprob
*/
public class HrRequerimientomotivoAprob extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientomotivoAprobPk pk;
	private String nivelesaprobacion;
	private Integer nroniveles;
	private String posicionesresp;
	private Integer ordenflujo;
	private String correoccInicio;
	private String correoccFin;
	private Integer estadocorreo;


	public HrRequerimientomotivoAprob() {
		pk = new HrRequerimientomotivoAprobPk();
	}

	public HrRequerimientomotivoAprobPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientomotivoAprobPk pk) {
		this.pk = pk;
	}
	public String getNivelesaprobacion() {
		return nivelesaprobacion;
	}

	public void setNivelesaprobacion(String nivelesaprobacion) {
		this.nivelesaprobacion = nivelesaprobacion;
	}
	public Integer getNroniveles() {
		return nroniveles;
	}

	public void setNroniveles(Integer nroniveles) {
		this.nroniveles = nroniveles;
	}
	public String getPosicionesresp() {
		return posicionesresp;
	}

	public void setPosicionesresp(String posicionesresp) {
		this.posicionesresp = posicionesresp;
	}
	public Integer getOrdenflujo() {
		return ordenflujo;
	}

	public void setOrdenflujo(Integer ordenflujo) {
		this.ordenflujo = ordenflujo;
	}
	public String getCorreoccInicio() {
		return correoccInicio;
	}

	public void setCorreoccInicio(String correoccInicio) {
		this.correoccInicio = correoccInicio;
	}
	public String getCorreoccFin() {
		return correoccFin;
	}

	public void setCorreoccFin(String correoccFin) {
		this.correoccFin = correoccFin;
	}
	public Integer getEstadocorreo() {
		return estadocorreo;
	}

	public void setEstadocorreo(Integer estadocorreo) {
		this.estadocorreo = estadocorreo;
	}

}
