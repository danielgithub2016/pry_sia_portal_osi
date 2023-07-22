package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsArea
 */
public class AsAreaPk implements java.io.Serializable {

	private Integer area;
	
	public AsAreaPk(){}
	public AsAreaPk(Integer area){
		this.area=area;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

}
