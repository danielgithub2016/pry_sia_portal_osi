package net.royal.erp.core.servicio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.servicio.GenericoServicio;

public interface ParametrosmastServicio extends GenericoServicio {
	public String obtenerValorCadena(String parametroclave);
	public String obtenerValorExplicacion(ParametrosmastPk pk);
	public String obtenerValorCadena(ParametrosmastPk pk);
	public Date obtenerValorFecha(ParametrosmastPk pk);

	public Integer obtenerValorInteger(ParametrosmastPk pk);

	public BigDecimal obtenerValorDecimal(ParametrosmastPk pk);
	
	/**
	 * f_validate_ruc
	 */
	public String calcularIGVDiferencia(BigDecimal par_montoafecto,
			BigDecimal par_montoigv, BigDecimal str_global_gvigv);
	

	/**
	 * Obtener valor descripcion.
	 *
	 * @author nunezh
	 * @powerbuilder <strong> hrcommon.f_sql_read_parametrosmast_descr </strong>
	 * @param pk
	 *            the pk
	 * @return descripcion
	 */
	public String obtenerValorDescripcion(ParametrosmastPk pk);
}
