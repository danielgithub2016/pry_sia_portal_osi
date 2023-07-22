package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.core.dominio.Correlativosmast;
import net.royal.erp.core.dominio.CorrelativosmastPk;

public interface CorrelativosmastServicio extends GenericoServicio {

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
