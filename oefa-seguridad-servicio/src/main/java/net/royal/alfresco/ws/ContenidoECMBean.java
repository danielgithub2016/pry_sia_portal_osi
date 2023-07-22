
package net.royal.alfresco.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contenidoECMBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contenidoECMBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cadMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contenidoFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="encoding" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreArchivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tamanio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoContenido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contenidoECMBean", propOrder = {
    "cadMsg",
    "codMsg",
    "contenidoFile",
    "encoding",
    "nombreArchivo",
    "ruta",
    "tamanio",
    "tipoContenido"
})
public class ContenidoECMBean {

    protected String cadMsg;
    protected String codMsg;
    protected byte[] contenidoFile;
    protected String encoding;
    protected String nombreArchivo;
    protected String ruta;
    protected String tamanio;
    protected String tipoContenido;

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
     * Gets the value of the contenidoFile property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getContenidoFile() {
        return contenidoFile;
    }

    /**
     * Sets the value of the contenidoFile property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setContenidoFile(byte[] value) {
        this.contenidoFile = value;
    }

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }

    /**
     * Gets the value of the nombreArchivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Sets the value of the nombreArchivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArchivo(String value) {
        this.nombreArchivo = value;
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
     * Gets the value of the tamanio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * Sets the value of the tamanio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTamanio(String value) {
        this.tamanio = value;
    }

    /**
     * Gets the value of the tipoContenido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoContenido() {
        return tipoContenido;
    }

    /**
     * Sets the value of the tipoContenido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoContenido(String value) {
        this.tipoContenido = value;
    }

}
