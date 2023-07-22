/**
 * ResultadoConsulta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.oefa.interoperabilidad.ws.reniec.service;

public class ResultadoConsulta  implements java.io.Serializable {
    private java.lang.String coResultado;

    private pe.gob.oefa.interoperabilidad.ws.reniec.service.DatosPersona datosPersona;

    private java.lang.String deResultado;

    public ResultadoConsulta() {
    }

    public ResultadoConsulta(
           java.lang.String coResultado,
           pe.gob.oefa.interoperabilidad.ws.reniec.service.DatosPersona datosPersona,
           java.lang.String deResultado) {
           this.coResultado = coResultado;
           this.datosPersona = datosPersona;
           this.deResultado = deResultado;
    }


    /**
     * Gets the coResultado value for this ResultadoConsulta.
     * 
     * @return coResultado
     */
    public java.lang.String getCoResultado() {
        return coResultado;
    }


    /**
     * Sets the coResultado value for this ResultadoConsulta.
     * 
     * @param coResultado
     */
    public void setCoResultado(java.lang.String coResultado) {
        this.coResultado = coResultado;
    }


    /**
     * Gets the datosPersona value for this ResultadoConsulta.
     * 
     * @return datosPersona
     */
    public pe.gob.oefa.interoperabilidad.ws.reniec.service.DatosPersona getDatosPersona() {
        return datosPersona;
    }


    /**
     * Sets the datosPersona value for this ResultadoConsulta.
     * 
     * @param datosPersona
     */
    public void setDatosPersona(pe.gob.oefa.interoperabilidad.ws.reniec.service.DatosPersona datosPersona) {
        this.datosPersona = datosPersona;
    }


    /**
     * Gets the deResultado value for this ResultadoConsulta.
     * 
     * @return deResultado
     */
    public java.lang.String getDeResultado() {
        return deResultado;
    }


    /**
     * Sets the deResultado value for this ResultadoConsulta.
     * 
     * @param deResultado
     */
    public void setDeResultado(java.lang.String deResultado) {
        this.deResultado = deResultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoConsulta)) return false;
        ResultadoConsulta other = (ResultadoConsulta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.coResultado==null && other.getCoResultado()==null) || 
             (this.coResultado!=null &&
              this.coResultado.equals(other.getCoResultado()))) &&
            ((this.datosPersona==null && other.getDatosPersona()==null) || 
             (this.datosPersona!=null &&
              this.datosPersona.equals(other.getDatosPersona()))) &&
            ((this.deResultado==null && other.getDeResultado()==null) || 
             (this.deResultado!=null &&
              this.deResultado.equals(other.getDeResultado())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCoResultado() != null) {
            _hashCode += getCoResultado().hashCode();
        }
        if (getDatosPersona() != null) {
            _hashCode += getDatosPersona().hashCode();
        }
        if (getDeResultado() != null) {
            _hashCode += getDeResultado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoConsulta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.reniec.ws.interoperabilidad.oefa.gob.pe/", "resultadoConsulta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coResultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coResultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datosPersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.reniec.ws.interoperabilidad.oefa.gob.pe/", "datosPersona"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deResultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deResultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
