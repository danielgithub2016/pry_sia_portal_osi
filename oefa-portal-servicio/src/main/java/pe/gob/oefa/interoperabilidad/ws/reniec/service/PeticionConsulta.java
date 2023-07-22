/**
 * PeticionConsulta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.oefa.interoperabilidad.ws.reniec.service;

public class PeticionConsulta  implements java.io.Serializable {
    private java.lang.String nuDniConsulta;

    private java.lang.String nuDniUsuario;

    private java.lang.String nuRucUsuario;

    private java.lang.String password;

    public PeticionConsulta() {
    }

    public PeticionConsulta(
           java.lang.String nuDniConsulta,
           java.lang.String nuDniUsuario,
           java.lang.String nuRucUsuario,
           java.lang.String password) {
           this.nuDniConsulta = nuDniConsulta;
           this.nuDniUsuario = nuDniUsuario;
           this.nuRucUsuario = nuRucUsuario;
           this.password = password;
    }


    /**
     * Gets the nuDniConsulta value for this PeticionConsulta.
     * 
     * @return nuDniConsulta
     */
    public java.lang.String getNuDniConsulta() {
        return nuDniConsulta;
    }


    /**
     * Sets the nuDniConsulta value for this PeticionConsulta.
     * 
     * @param nuDniConsulta
     */
    public void setNuDniConsulta(java.lang.String nuDniConsulta) {
        this.nuDniConsulta = nuDniConsulta;
    }


    /**
     * Gets the nuDniUsuario value for this PeticionConsulta.
     * 
     * @return nuDniUsuario
     */
    public java.lang.String getNuDniUsuario() {
        return nuDniUsuario;
    }


    /**
     * Sets the nuDniUsuario value for this PeticionConsulta.
     * 
     * @param nuDniUsuario
     */
    public void setNuDniUsuario(java.lang.String nuDniUsuario) {
        this.nuDniUsuario = nuDniUsuario;
    }


    /**
     * Gets the nuRucUsuario value for this PeticionConsulta.
     * 
     * @return nuRucUsuario
     */
    public java.lang.String getNuRucUsuario() {
        return nuRucUsuario;
    }


    /**
     * Sets the nuRucUsuario value for this PeticionConsulta.
     * 
     * @param nuRucUsuario
     */
    public void setNuRucUsuario(java.lang.String nuRucUsuario) {
        this.nuRucUsuario = nuRucUsuario;
    }


    /**
     * Gets the password value for this PeticionConsulta.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this PeticionConsulta.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeticionConsulta)) return false;
        PeticionConsulta other = (PeticionConsulta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nuDniConsulta==null && other.getNuDniConsulta()==null) || 
             (this.nuDniConsulta!=null &&
              this.nuDniConsulta.equals(other.getNuDniConsulta()))) &&
            ((this.nuDniUsuario==null && other.getNuDniUsuario()==null) || 
             (this.nuDniUsuario!=null &&
              this.nuDniUsuario.equals(other.getNuDniUsuario()))) &&
            ((this.nuRucUsuario==null && other.getNuRucUsuario()==null) || 
             (this.nuRucUsuario!=null &&
              this.nuRucUsuario.equals(other.getNuRucUsuario()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword())));
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
        if (getNuDniConsulta() != null) {
            _hashCode += getNuDniConsulta().hashCode();
        }
        if (getNuDniUsuario() != null) {
            _hashCode += getNuDniUsuario().hashCode();
        }
        if (getNuRucUsuario() != null) {
            _hashCode += getNuRucUsuario().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeticionConsulta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.reniec.ws.interoperabilidad.oefa.gob.pe/", "peticionConsulta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nuDniConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nuDniConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nuDniUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nuDniUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nuRucUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nuRucUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
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
