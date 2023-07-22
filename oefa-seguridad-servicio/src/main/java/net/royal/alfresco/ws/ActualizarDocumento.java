
package net.royal.alfresco.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actualizarDocumento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actualizarDocumento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anteriorUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarDocumento", propOrder = {
    "key",
    "anteriorUUID",
    "nomFile",
    "ruta",
    "file"
})
public class ActualizarDocumento {

    protected String key;
    protected String anteriorUUID;
    protected String nomFile;
    protected String ruta;
    @XmlElementRef(name = "file", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> file;

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
     * Gets the value of the anteriorUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnteriorUUID() {
        return anteriorUUID;
    }

    /**
     * Sets the value of the anteriorUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnteriorUUID(String value) {
        this.anteriorUUID = value;
    }

    /**
     * Gets the value of the nomFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomFile() {
        return nomFile;
    }

    /**
     * Sets the value of the nomFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomFile(String value) {
        this.nomFile = value;
    }

    /**
     * Gets the value of the ruta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Sets the value of the ruta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuta(String value) {
        this.ruta = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setFile(JAXBElement<byte[]> value) {
        this.file = value;
    }

}
