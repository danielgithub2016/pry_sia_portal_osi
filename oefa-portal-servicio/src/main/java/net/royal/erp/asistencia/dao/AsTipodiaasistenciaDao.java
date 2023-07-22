package net.royal.erp.asistencia.dao;

import java.util.List;

import net.royal.erp.asistencia.dominio.AsTipodiaasistencia;
import net.royal.erp.asistencia.dominio.AsTipodiaasistenciaPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsTipodiaasistenciaDao extends
		GenericoDao<AsTipodiaasistencia, AsTipodiaasistenciaPk> {
	
	/**
	 * @powerbuilder dddw_as_tipodiaasistencia_select
	 * @return lista
	 */
	public List<AsTipodiaasistencia> listarTipoDiaAsistencia();

}
