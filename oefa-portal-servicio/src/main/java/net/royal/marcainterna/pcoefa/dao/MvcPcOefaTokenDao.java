package net.royal.marcainterna.pcoefa.dao;

import java.math.BigDecimal;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;

public interface MvcPcOefaTokenDao extends GenericoDao<MvcPcOefaToken, BigDecimal> {

	public MvcPcOefaToken obtenerPorToken(String token);

	public MvcPcOefaToken obtenerPorEstado(String estado);
}
