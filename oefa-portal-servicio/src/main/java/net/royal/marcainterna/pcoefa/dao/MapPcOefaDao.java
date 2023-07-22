package net.royal.marcainterna.pcoefa.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.marcainterna.pcoefa.dominio.MapPcOefa;

public interface MapPcOefaDao extends GenericoDao<MapPcOefa, BigDecimal> {

	public List<MapPcOefa> listarPorCriterios(MapPcOefa mapPcOefa);

}
