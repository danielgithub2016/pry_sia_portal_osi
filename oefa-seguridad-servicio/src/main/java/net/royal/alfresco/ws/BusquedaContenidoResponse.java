
package net.royal.alfresco.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for busquedaContenidoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="busquedaContenidoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.oefa.gob.pe/}rptaBcBean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busquedaContenidoResponse", propOrder = {
    "_return"
})
public class BusquedaContenidoResponse {

    @XmlElement(name = "return")
    protected RptaBcBean _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link RptaBcBean }
     *     
     */
    public RptaBcBean getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link RptaBcBean }
     *     
     */
    public void setReturn(RptaBcBean value) {
        this._return = value;
    }

}
