/**
 * PeticionActualizarCredencial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.oefa.interoperabilidad.ws.reniec.service;

public class PeticionActualizarCredencial  implements java.io.Serializable {
    private java.lang.String credencialAnterior;

    private java.lang.String credencialNueva;

    private java.lang.String nuDni;

    private java.lang.String nuRuc;

    public PeticionActualizarCredencial() {
    }

    public PeticionActualizarCredencial(
           java.lang.String credencialAnterior,
           java.lang.String credencialNueva,
           java.lang.String nuDni,
           java.lang.String nuRuc) {
           this.credencialAnterior = credencialAnterior;
           this.credencialNueva = credencialNueva;
           this.nuDni = nuDni;
           this.nuRuc = nuRuc;
    }


    /**
     * Gets the credencialAnterior value for this PeticionActualizarCredencial.
     * 
     * @return credencialAnterior
     */
    public java.lang.String getCredencialAnterior() {
        return credencialAnterior;
    }


    /**
     * Sets the credencialAnterior value for this PeticionActualizarCredencial.
     * 
     * @param credencialAnterior
     */
    public void setCredencialAnterior(java.lang.String credencialAnterior) {
        this.credencialAnterior = credencialAnterior;
    }


    /**
     * Gets the credencialNueva value for this PeticionActualizarCredencial.
     * 
     * @return credencialNueva
     */
    public java.lang.String getCredencialNueva() {
        return credencialNueva;
    }


    /**
     * Sets the credencialNueva value for this PeticionActualizarCredencial.
     * 
     * @param credencialNueva
     */
    public void setCredencialNueva(java.lang.String credencialNueva) {
        this.credencialNueva = credencialNueva;
    }


    /**
     * Gets the nuDni value for this PeticionActualizarCredencial.
     * 
     * @return nuDni
     */
    public java.lang.String getNuDni() {
        return nuDni;
    }


    /**
     * Sets the nuDni value for this PeticionActualizarCredencial.
     * 
     * @param nuDni
     */
    public void setNuDni(java.lang.String nuDni) {
        this.nuDni = nuDni;
    }


    /**
     * Gets the nuRuc value for this PeticionActualizarCredencial.
     * 
     * @return nuRuc
     */
    public java.lang.String getNuRuc() {
        return nuRuc;
    }


    /**
     * Sets the nuRuc value for this PeticionActualizarCredencial.
     * 
     * @param nuRuc
     */
    public void setNuRuc(java.lang.String nuRuc) {
        this.nuRuc = nuRuc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeticionActualizarCredencial)) return false;
        PeticionActualizarCredencial other = (PeticionActualizarCredencial) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.credencialAnterior==null && other.getCredencialAnterior()==null) || 
             (this.credencialAnterior!=null &&
              this.credencialAnterior.equals(other.getCredencialAnterior()))) &&
            ((this.credencialNueva==null && other.getCredencialNueva()==null) || 
             (this.credencialNueva!=null &&
              this.credencialNueva.equals(other.getCredencialNueva()))) &&
            ((this.nuDni==null && other.getNuDni()==null) || 
             (this.nuDni!=null &&
              this.nuDni.equals(other.getNuDni()))) &&
            ((this.nuRuc==null && other.getNuRuc()==null) || 
             (this.nuRuc!=null &&
              this.nuRuc.equals(other.getNuRuc())));
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
        if (getCredencialAnterior() != null) {
            _hashCode += getCredencialAnterior().hashCode();
        }
        if (getCredencialNueva() != null) {
            _hashCode += getCredencialNueva().hashCode();
        }
        if (getNuDni() != null) {
            _hashCode += getNuDni().hashCode();
        }
        if (getNuRuc() != null) {
            _hashCode += getNuRuc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeticionActualizarCredencial.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.reniec.ws.interoperabilidad.oefa.gob.pe/", "peticionActualizarCredencial"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credencialAnterior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "credencialAnterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credencialNueva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "credencialNueva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nuDni");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nuDni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nuRuc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nuRuc"));
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
