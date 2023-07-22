package net.royal.erp.asistencia.dao;

import java.util.List;

import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.asistencia.dominio.AsConceptoaccesoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsConceptoaccesoDao extends
		GenericoDao<AsConceptoacceso, AsConceptoaccesoPk> {
	
	/**
	 * Listar activos.
	 *@powerbuilder dddw_as_conceptoacceso_select
	 * @return the list
	 */
	public List<AsConceptoacceso> listarActivos();
}
