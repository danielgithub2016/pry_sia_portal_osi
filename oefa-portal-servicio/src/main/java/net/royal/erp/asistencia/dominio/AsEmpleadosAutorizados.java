package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadosAutorizados
 */
public class AsEmpleadosAutorizados extends DominioGenerico implements
		java.io.Serializable {

	private AsEmpleadosAutorizadosPk pk;

	public AsEmpleadosAutorizados() {
		pk = new AsEmpleadosAutorizadosPk();
	}

	public AsEmpleadosAutorizadosPk getPk() {
		return pk;
	}

	public void setPk(AsEmpleadosAutorizadosPk pk) {
		this.pk = pk;
	}

}
