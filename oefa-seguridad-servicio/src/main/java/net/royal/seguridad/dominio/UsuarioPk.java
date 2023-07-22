package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Usuario
*/
public class UsuarioPk implements java.io.Serializable{

	private String usuario;
	
	public UsuarioPk(){}
	public UsuarioPk(String usuario){
		this.usuario=usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
