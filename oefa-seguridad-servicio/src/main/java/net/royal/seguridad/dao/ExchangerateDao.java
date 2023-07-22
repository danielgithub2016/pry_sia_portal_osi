package net.royal.seguridad.dao;

import java.util.Date;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Exchangerate;
import net.royal.seguridad.dominio.ExchangeratePk;

public interface ExchangerateDao extends
		GenericoDao<Exchangerate, ExchangeratePk> {

	public Exchangerate obtenerPorPeriodo(Date fecha);
}
