package net.royal.erp.planilla.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.planilla.dominio.PrCts;
import net.royal.erp.planilla.dominio.PrCtsPk;
import net.royal.erp.planilla.dominio.PrTipoplanilla;
import net.royal.erp.planilla.dominio.PrTipoplanillaPk;
import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsList;

import java.math.BigDecimal;
import java.util.List;

public interface PrCtsDao extends GenericoDao<PrCts, PrCtsPk> {

	public List<DtoDwPrCtsList> listarCtsEmpleado(String compania,BigDecimal cts, BigDecimal ctsfinal,
			String moneda, String estadoempleado);
	
}
