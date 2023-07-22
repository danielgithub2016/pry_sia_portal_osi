package net.royal.erp.asistencia.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

@SuppressWarnings("serial")
public class Terminal extends DominioGenerico implements Serializable {

	private TerminalPk pk;
	private BigDecimal idperfilterminal;
	private String descripcion;
	private BigDecimal ubicacion;
	private String estado;

	public Terminal() {
		pk = new TerminalPk();
	}

	public TerminalPk getPk() {
		return pk;
	}

	public void setPk(TerminalPk pk) {
		this.pk = pk;
	}

	public BigDecimal getIdperfilterminal() {
		return idperfilterminal;
	}

	public void setIdperfilterminal(BigDecimal idperfilterminal) {
		this.idperfilterminal = idperfilterminal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(BigDecimal ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
