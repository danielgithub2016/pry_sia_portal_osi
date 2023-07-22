package net.royal.seguridad.dao;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Tipocambiomast;
import net.royal.seguridad.dominio.TipocambiomastPk;

public interface TipocambiomastDao extends
		GenericoDao<Tipocambiomast, TipocambiomastPk> {
	
	public BigDecimal obtenerFactor(Date fecha, String rateType);
	
	public Tipocambiomast obtenerTipoCambio(Date fecha, String monedaCodigo,
			String monedaCambioCodigo);

	public Tipocambiomast obtenerTipoCambioMaximo(Date fecha,
			String monedaCodigo, String monedaCambioCodigo);
}
