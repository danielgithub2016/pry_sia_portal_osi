package net.royal.erp.core.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.core.dominio.Impuestos;
import net.royal.erp.core.dominio.ImpuestosPk;
import net.royal.framework.web.dao.GenericoDao;

public interface ImpuestosDao extends GenericoDao<Impuestos, ImpuestosPk> {

	public List<Impuestos> listarPorTipoServicio(String tiposervicio);
}
