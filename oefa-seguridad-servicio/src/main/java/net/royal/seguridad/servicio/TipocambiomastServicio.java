package net.royal.seguridad.servicio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Tipocambiomast;

public interface TipocambiomastServicio extends GenericoServicio {
	
	public BigDecimal obtenerFactor(Date fecha, String rateType);

	public Tipocambiomast obtenerTipoCambio(Date fecha, String monedaCodigo,
			String monedaCambioCodigo);

	public Tipocambiomast obtenerTipoCambioMaximo(Date fecha,
			String monedaCodigo, String monedaCambioCodigo);
}
