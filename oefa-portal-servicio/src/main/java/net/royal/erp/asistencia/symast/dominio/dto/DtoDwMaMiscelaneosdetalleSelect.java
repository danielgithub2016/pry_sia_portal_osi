package net.royal.erp.asistencia.symast.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder symast.dw_ma_miscelaneosdetalle_select
 */
@SuppressWarnings("serial")
public class DtoDwMaMiscelaneosdetalleSelect implements java.io.Serializable {
	private String codigoelemento;
	private String descripcionlocal;
	private String valorcodigo5;
	private String descripcionlocalheader;
	private BigDecimal valornumerico;
	private String valorcodigo1;

	public String getCodigoelemento() {
		return codigoelemento;
	}

	public void setCodigoelemento(String codigoelemento) {
		this.codigoelemento = codigoelemento;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getValorcodigo5() {
		return valorcodigo5;
	}

	public void setValorcodigo5(String valorcodigo5) {
		this.valorcodigo5 = valorcodigo5;
	}

	public String getDescripcionlocalheader() {
		return descripcionlocalheader;
	}

	public void setDescripcionlocalheader(String descripcionlocalheader) {
		this.descripcionlocalheader = descripcionlocalheader;
	}

	public BigDecimal getValornumerico() {
		if (UValidador.esNulo(valornumerico)) {
			valornumerico = BigDecimal.valueOf(0.0);
		}
		return valornumerico;
	}

	public void setValornumerico(BigDecimal valornumerico) {
		this.valornumerico = valornumerico;
	}

	public String getValorcodigo1() {
		return valorcodigo1;
	}

	public void setValorcodigo1(String valorcodigo1) {
		this.valorcodigo1 = valorcodigo1;
	}
}
