
package net.royal.alfresco.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rptaBcBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rptaBcBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cadMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="list" type="{http://ws.oefa.gob.pe/}beanFile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rptaBcBean", propOrder = {
    "cadMsg",
    "codMsg",
    "list"
})
public class RptaBcBean {

    protected String cadMsg;
    protected String codMsg;
    @XmlElement(nillable = true)
    protected List<BeanFile> list;

    /**
     * Gets the value of the cadMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadMsg() {
        return cadMsg;
    }

    /**
     * Sets the value of the cadMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadMsg(String value) {
        this.cadMsg = value;
    }

    /**
     * Gets the value of the codMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMsg() {
        return codMsg;
    }

    /**
     * Sets the value of the codMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMsg(String value) {
        this.codMsg = value;
    }

    /**
     * Gets the value of the list property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the list property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanFile }
     * 
     * 
     */
    public List<BeanFile> getList() {
        if (list == null) {
            list = new ArrayList<BeanFile>();
        }
        return this.list;
    }

}
