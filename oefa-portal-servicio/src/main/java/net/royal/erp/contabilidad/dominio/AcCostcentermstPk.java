package net.royal.erp.contabilidad.dominio;

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
		this.costcenter = costcenter;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

}
