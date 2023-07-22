package net.royal.erp.sistema.dominio.dto;


/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_position
 */
public class DtoDwPosition implements java.io.Serializable {
	private String order;
	private String position;
	private Boolean wildCharacter;
	private Boolean inactivoFlag;
	private String pyme;
	private String unidadNegocio;
	
	public String getPyme() {
		return pyme;
	}

	public void setPyme(String pyme) {
		this.pyme = pyme;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getWildCharacter() {
		return wildCharacter;
	}

	public void setWildCharacter(Boolean wildCharacter) {
		this.wildCharacter = wildCharacter;
	}

	public Boolean getInactivoFlag() {
		return inactivoFlag;
	}

	public void setInactivoFlag(Boolean inactivoFlag) {
		this.inactivoFlag = inactivoFlag;
	}

	public String getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	
}
