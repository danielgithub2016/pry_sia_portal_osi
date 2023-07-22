package net.royal.erp.asistencia.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsTipohorario
 */
public class AsTipohorarioPk implements java.io.Serializable {

	private Integer tipohorario;

	public AsTipohorarioPk(){}
	
	public AsTipohorarioPk(Integer tipohorario){
		this.tipohorario=tipohorario;
	}
	
	public Integer getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(Integer tipohorario) {
		this.tipohorario = tipohorario;
	}

}
