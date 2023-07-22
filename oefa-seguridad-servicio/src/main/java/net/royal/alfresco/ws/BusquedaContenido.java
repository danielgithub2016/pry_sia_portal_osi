
package net.royal.alfresco.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for busquedaContenido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="busquedaContenido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rutaSubCarpeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parametro1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parametro2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parametro3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parametro4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busquedaContenido", propOrder = {
    "key",
    "rutaSubCarpeta",
    "parametro1",
    "parametro2",
    "parametro3",
    "parametro4"
})
public class BusquedaContenido {

    protected String key;
    protected String rutaSubCarpeta;
    protected String parametro1;
    protected String parametro2;
    protected String parametro3;
    protected String parametro4;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the rutaSubCarpeta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaSubCarpeta() {
        return rutaSubCarpeta;
    }

    /**
     * Sets the value of the rutaSubCarpeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaSubCarpeta(String value) {
        this.rutaSubCarpeta = value;
    }

    /**
     * Gets the value of the parametro1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro1() {
        return parametro1;
    }

    /**
     * Sets the value of the parametro1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro1(String value) {
        this.parametro1 = value;
    }

    /**
     * Gets the value of the parametro2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro2() {
        return parametro2;
    }

    /**
     * Sets the value of the parametro2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro2(String value) {
        this.parametro2 = value;
    }

    /**
     * Gets the value of the parametro3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro3() {
        return parametro3;
    }

    /**
     * Sets the value of the parametro3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro3(String value) {
        this.parametro3 = value;
    }

    /**
     * Gets the value of the parametro4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro4() {
        return parametro4;
    }

    /**
     * Sets the value of the parametro4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro4(String value) {
        this.parametro4 = value;
    }

}
