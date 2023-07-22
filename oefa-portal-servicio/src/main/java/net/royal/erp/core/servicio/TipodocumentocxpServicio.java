package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.core.dominio.Tipodocumentocxp;
import net.royal.erp.core.dominio.TipodocumentocxpPk;

public interface TipodocumentocxpServicio extends GenericoServicio {

	public List listarDocCxp();
	/**
	 * f_sql_read_tipodoccxp_mascara
	 */
	public String obtenertipomascara(String par_tipodocumento);
	public Tipodocumentocxp obtenerTipoDocumento(String par_tipodocumento);
}
