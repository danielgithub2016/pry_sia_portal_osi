package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCorreoflujo
*/
public class HrCorreoflujo extends DominioGenerico implements java.io.Serializable{

	private HrCorreoflujoPk pk;
	private String motivo;
	private String destino;
	private String copia;
	private String flagusuario;
	private String flagjefe;


	public HrCorreoflujo() {
		pk = new HrCorreoflujoPk();
	}

	public HrCorreoflujoPk getPk() {
		return pk;
	}

	public void setPk(HrCorreoflujoPk pk) {
		this.pk = pk;
	}
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getCopia() {
		return copia;
	}

	public void setCopia(String copia) {
		this.copia = copia;
	}
	public String getFlagusuario() {
		return flagusuario;
	}

	public void setFlagusuario(String flagusuario) {
		this.flagusuario = flagusuario;
	}
	public String getFlagjefe() {
		return flagjefe;
	}

	public void setFlagjefe(String flagjefe) {
		this.flagjefe = flagjefe;
	}

}
