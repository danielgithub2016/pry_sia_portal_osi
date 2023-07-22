package net.royal.erp.asistencia.dao;

import net.royal.erp.asistencia.dominio.AsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.AsTipodiamovimientoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsTipodiamovimientoDao extends
		GenericoDao<AsTipodiamovimiento, AsTipodiamovimientoPk> {
	public AsTipodiamovimiento obtenerPorTipoDiaMinimo(String tipodia);

	public AsTipodiamovimiento obtenerPorTipoDiaMaximo(String tipodia);

	public String obtenerMaxIntervaloAccesoPorTipoDia(Integer tipoDia);
}
