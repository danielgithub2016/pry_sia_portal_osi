package net.royal.seguridad.dominio;

/**
 *
 * @author desarrollo
 * @powerbuilder contabilidad.AcCostcentermst
 */
public class AcCostcentermstPk implements java.io.Serializable {

	private String costcenter;

	public AcCostcentermstPk() {
	}

	public AcCostcentermstPk(String costcenter) {
		super();
		this.costcenter = costcenter;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

}
