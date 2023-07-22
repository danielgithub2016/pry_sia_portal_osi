package net.royal.erp.core.dao;

import net.royal.erp.core.dominio.Correlativosmast;
import net.royal.erp.core.dominio.CorrelativosmastPk;
import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.dominio.UsuarioActual;

public interface CorrelativosmastDao extends
		GenericoDao<Correlativosmast, CorrelativosmastPk> {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycomm.f_sql_update_lastnumber
	 */
	public Integer incrementarNuevoCorrelativo(String companiacodigo,
			String tipocomprobante, String serie,UsuarioActual usuarioActual);
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder whmenu.f_sql_get_requisition_number
	 */
	public String incrementarNuevoCorrelativoCadena(String companiacodigo,
			String tipocomprobante, String serie,Integer cerosIzquierda,UsuarioActual usuarioActual);

}
