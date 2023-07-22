package net.royal.erp.presupuesto.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

@SuppressWarnings("serial")
public class BuPca extends DominioGenerico implements Serializable {
	private BuPcaPk pk;
	private String fuentefinanciamiento;
	private String categoriagasto;
	private String clasificador;
	private BigDecimal montoinicial;
	private String estado;

	public BuPca() {
		pk = new BuPcaPk();
	}

	public BuPcaPk getPk() {
		return pk;
	}

	public void setPk(BuPcaPk pk) {
		this.pk = pk;
	}

	public String getFuentefinanciamiento() {
		return fuentefinanciamiento;
	}

	public void setFuentefinanciamiento(String fuentefinanciamiento) {
		this.fuentefinanciamiento = fuentefinanciamiento;
	}

	public String getCategoriagasto() {
		return categoriagasto;
	}

	public void setCategoriagasto(String categoriagasto) {
		this.categoriagasto = categoriagasto;
	}

	public String getClasificador() {
		return clasificador;
	}

	public void setClasificador(String clasificador) {
		this.clasificador = clasificador;
	}

	public BigDecimal getMontoinicial() {
		return montoinicial;
	}

	public void setMontoinicial(BigDecimal montoinicial) {
		this.montoinicial = montoinicial;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
