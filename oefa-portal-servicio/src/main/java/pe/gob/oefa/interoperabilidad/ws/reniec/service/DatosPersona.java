/**
 * DatosPersona.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.oefa.interoperabilidad.ws.reniec.service;

public class DatosPersona  implements java.io.Serializable {
    private java.lang.String apPrimer;

    private java.lang.String apSegundo;

    private java.lang.String direccion;

    private java.lang.String estadoCivil;

    private byte[] foto;

    private java.lang.String prenombres;

    private java.lang.String restriccion;

    private java.lang.String ubigeo;

    public DatosPersona() {
    }

    public DatosPersona(
           java.lang.String apPrimer,
           java.lang.String apSegundo,
           java.lang.String direccion,
           java.lang.String estadoCivil,
           byte[] foto,
           java.lang.String prenombres,
           java.lang.String restriccion,
           java.lang.String ubigeo) {
           this.apPrimer = apPrimer;
           this.apSegundo = apSegundo;
           this.direccion = direccion;
           this.estadoCivil = estadoCivil;
           this.foto = foto;
           this.prenombres = prenombres;
           this.restriccion = restriccion;
           this.ubigeo = ubigeo;
    }


    /**
     * Gets the apPrimer value for this DatosPersona.
     * 
     * @return apPrimer
     */
    public java.lang.String getApPrimer() {
        return apPrimer;
    }


    /**
     * Sets the apPrimer value for this DatosPersona.
     * 
     * @param apPrimer
     */
    public void setApPrimer(java.lang.String apPrimer) {
        this.apPrimer = apPrimer;
    }


    /**
     * Gets the apSegundo value for this DatosPersona.
     * 
     * @return apSegundo
     */
    public java.lang.String getApSegundo() {
        return apSegundo;
    }


    /**
     * Sets the apSegundo value for this DatosPersona.
     * 
     * @param apSegundo
     */
    public void setApSegundo(java.lang.String apSegundo) {
        this.apSegundo = apSegundo;
    }


    /**
     * Gets the direccion value for this DatosPersona.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this DatosPersona.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the estadoCivil value for this DatosPersona.
     * 
     * @return estadoCivil
     */
    public java.lang.String getEstadoCivil() {
        return estadoCivil;
    }


    /**
     * Sets the estadoCivil value for this DatosPersona.
     * 
     * @param estadoCivil
     */
    public void setEstadoCivil(java.lang.String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    /**
     * Gets the foto value for this DatosPersona.
     * 
     * @return foto
     */
    public byte[] getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this DatosPersona.
     * 
     * @param foto
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


    /**
     * Gets the prenombres value for this DatosPersona.
     * 
     * @return prenombres
     */
    public java.lang.String getPrenombres() {
        return prenombres;
    }


    /**
     * Sets the prenombres value for this DatosPersona.
     * 
     * @param prenombres
     */
    public void setPrenombres(java.lang.String prenombres) {
        this.prenombres = prenombres;
    }


    /**
     * Gets the restriccion value for this DatosPersona.
     * 
     * @return restriccion
     */
    public java.lang.String getRestriccion() {
        return restriccion;
    }


    /**
     * Sets the restriccion value for this DatosPersona.
     * 
     * @param restriccion
     */
    public void setRestriccion(java.lang.String restriccion) {
        this.restriccion = restriccion;
    }


    /**
     * Gets the ubigeo value for this DatosPersona.
     * 
     * @return ubigeo
     */
    public java.lang.String getUbigeo() {
        return ubigeo;
    }


    /**
     * Sets the ubigeo value for this DatosPersona.
     * 
     * @param ubigeo
     */
    public void setUbigeo(java.lang.String ubigeo) {
        this.ubigeo = ubigeo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosPersona)) return false;
        DatosPersona other = (DatosPersona) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apPrimer==null && other.getApPrimer()==null) || 
             (this.apPrimer!=null &&
              this.apPrimer.equals(other.getApPrimer()))) &&
            ((this.apSegundo==null && other.getApSegundo()==null) || 
             (this.apSegundo!=null &&
              this.apSegundo.equals(other.getApSegundo()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.estadoCivil==null && other.getEstadoCivil()==null) || 
             (this.estadoCivil!=null &&
              this.estadoCivil.equals(other.getEstadoCivil()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              java.util.Arrays.equals(this.foto, other.getFoto()))) &&
            ((this.prenombres==null && other.getPrenombres()==null) || 
             (this.prenombres!=null &&
              this.prenombres.equals(other.getPrenombres()))) &&
            ((this.restriccion==null && other.getRestriccion()==null) || 
             (this.restriccion!=null &&
              this.restriccion.equals(other.getRestriccion()))) &&
            ((this.ubigeo==null && other.getUbigeo()==null) || 
             (this.ubigeo!=null &&
              this.ubigeo.equals(other.getUbigeo())));
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
        if (getApPrimer() != null) {
            _hashCode += getApPrimer().hashCode();
        }
        if (getApSegundo() != null) {
            _hashCode += getApSegundo().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getEstadoCivil() != null) {
            _hashCode += getEstadoCivil().hashCode();
        }
        if (getFoto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFoto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFoto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrenombres() != null) {
            _hashCode += getPrenombres().hashCode();
        }
        if (getRestriccion() != null) {
            _hashCode += getRestriccion().hashCode();
        }
        if (getUbigeo() != null) {
            _hashCode += getUbigeo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosPersona.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.reniec.ws.interoperabilidad.oefa.gob.pe/", "datosPersona"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apPrimer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apPrimer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apSegundo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apSegundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoCivil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estadoCivil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prenombres");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prenombres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restriccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "restriccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubigeo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ubigeo"));
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
