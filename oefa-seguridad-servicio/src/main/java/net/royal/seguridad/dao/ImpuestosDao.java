package net.royal.seguridad.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Impuestos;
import net.royal.seguridad.dominio.ImpuestosPk;

public interface ImpuestosDao extends GenericoDao<Impuestos, ImpuestosPk> {
	public BigDecimal obtenerFactorPorcentaje(String impuesto);

}
