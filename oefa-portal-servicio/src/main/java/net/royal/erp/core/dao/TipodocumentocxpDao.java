package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Tipodocumentocxp;
import net.royal.erp.core.dominio.TipodocumentocxpPk;
import java.util.List;

public interface TipodocumentocxpDao extends
		GenericoDao<Tipodocumentocxp, TipodocumentocxpPk> {

	/**
	 * DwMaTipodocumentocxpSelect
	 * @return
	 */
	public List listarDocCxp();
	/**
	 * f_sql_read_tipodoccxp_mascara
	 */
	public String obtenertipomascara(String par_tipodocumento);
	public Tipodocumentocxp obtenerTipoDocumento(String par_tipodocumento);
	
	
}
