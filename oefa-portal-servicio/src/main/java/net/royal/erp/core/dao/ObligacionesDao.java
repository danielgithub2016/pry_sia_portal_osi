package net.royal.erp.core.dao;

import java.math.BigDecimal;

import net.royal.erp.core.dominio.Obligaciones;
import net.royal.erp.core.dominio.ObligacionesPk;
import net.royal.framework.web.dao.GenericoDao;

public interface ObligacionesDao extends
		GenericoDao<Obligaciones, ObligacionesPk> {

	public Obligaciones obtenerPorId(BigDecimal proveedor, String tipodocumento,
			String numerodocumento);

}
