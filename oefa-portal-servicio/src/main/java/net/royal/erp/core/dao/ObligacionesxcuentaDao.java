package net.royal.erp.core.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.core.dominio.Obligacionesxcuenta;
import net.royal.erp.core.dominio.ObligacionesxcuentaPk;
import net.royal.framework.web.dao.GenericoDao;

public interface ObligacionesxcuentaDao extends
		GenericoDao<Obligacionesxcuenta, ObligacionesxcuentaPk> {
	
	public List<Obligacionesxcuenta> listarPorObligaciones(BigDecimal proveedor,
			String tipodocumento, String numerodocumento);

}
