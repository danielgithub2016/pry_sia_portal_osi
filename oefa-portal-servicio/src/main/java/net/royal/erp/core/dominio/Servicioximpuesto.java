package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Servicioximpuesto
*/
public class Servicioximpuesto extends DominioGenerico implements java.io.Serializable{

	private ServicioximpuestoPk pk;


	public Servicioximpuesto() {
		pk = new ServicioximpuestoPk();
	}

	public ServicioximpuestoPk getPk() {
		return pk;
	}

	public void setPk(ServicioximpuestoPk pk) {
		this.pk = pk;
	}

}
