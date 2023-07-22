package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.dominio.SeguridadconceptoPk;

import java.util.List;

public interface SeguridadconceptoDao extends
		GenericoDao<Seguridadconcepto, SeguridadconceptoPk> {

	/**
	 * hrmain.dw_ma_seguridad_concepto_opciones
	 * 
	 * @param codigoUsuario
	 * @return
	 **/

	public List<Seguridadconcepto> ListarentreConceptos(
			String aplicacioncodigo, String grupo, String concepto_desde,
			String concepto_hasta);

	public List<Seguridadconcepto> listarConceptosPermitidosPorUsuario(
			String usuario);

}
