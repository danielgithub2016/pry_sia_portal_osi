package net.royal.erp.core.dao;

import java.util.List;

import net.royal.erp.core.dominio.Primemst;
import net.royal.erp.core.dominio.PrimemstPk;
import net.royal.framework.web.dao.GenericoDao;

public interface PrimemstDao extends GenericoDao<Primemst, PrimemstPk> {
	public Primemst obtenerPorId(String prime);
	
	public List<Primemst> listarCombo(Integer DigitsNumber);
}
