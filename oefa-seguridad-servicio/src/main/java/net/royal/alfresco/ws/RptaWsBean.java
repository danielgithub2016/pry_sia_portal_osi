
package net.royal.alfresco.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for rptaWsBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="rptaWsBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cadMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rptaWsBean", propOrder = { "cadMsg", "codMsg", "uuid" })
public class RptaWsBean {

	protected String cadMsg;
	protected String codMsg;
	protected String uuid;

	/**
	 * Gets the value of the cadMsg property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCadMsg() {
		return cadMsg;
	}

	/**
	 * Sets the value of the cadMsg property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCadMsg(String value) {
		this.cadMsg = value;
	}

	/**
	 * Gets the value of the codMsg property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodMsg() {
		return codMsg;
	}

	/**
	 * Sets the value of the codMsg property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodMsg(String value) {
		this.codMsg = value;
	}

	/**
	 * Gets the value of the uuid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the value of the uuid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUuid(String value) {
		this.uuid = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RptaWsBean [");
		if (cadMsg != null) {
			builder.append("cadMsg=");
			builder.append(cadMsg);
			builder.append(", ");
		}
		if (codMsg != null) {
			builder.append("codMsg=");
			builder.append(codMsg);
			builder.append(", ");
		}
		if (uuid != null) {
			builder.append("uuid=");
			builder.append(uuid);
		}
		builder.append("]");
		return builder.toString();
	}

}
