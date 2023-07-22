package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_persona_select_by_busqueda
 */
public class DtoDwMaPersonaSelectByBusqueda implements java.io.Serializable {
	
	private BigDecimal persona;
	private String busqueda;
	private String escliente;
	private String esproveedor;
	private String esempleado;
	private String esotro;
	private String documento;
	private String personaant;
	private String documentofiscal;
	private String documentoidentidad;
	private String estado;
	private Boolean esclienteBoleano;
	private Boolean esproveedorBoleano;
	private Boolean esempleadoBoleano;
	private Boolean esotroBoleano;



	public Boolean getEsproveedorBoleano() {
		if(!UValidador.esNulo(esproveedor)){
			if(esproveedor.equals("N")){
				esproveedorBoleano = false;
			}else{
				esproveedorBoleano = true;
			}
		}
		return esproveedorBoleano;
	}

	public void setEsproveedorBoleano(Boolean esproveedorBoleano) {
		this.esproveedorBoleano = esproveedorBoleano;
	}

	public Boolean getEsempleadoBoleano() {
		if(!UValidador.esNulo(esempleado)){
			if(esempleado.equals("N")){
				esempleadoBoleano = false;
			}else{
				esempleadoBoleano = true;
			}
		}

		return esempleadoBoleano;
	}

	public void setEsempleadoBoleano(Boolean esempleadoBoleano) {
		this.esempleadoBoleano = esempleadoBoleano;
	}

	public Boolean getEsotroBoleano() {
		if(!UValidador.esNulo(esotro)){
			if(esotro.equals("N")){
				esotroBoleano = false;
			}else{
				esotroBoleano = true;
			}
		
		}
		return esotroBoleano;
	}

	public void setEsotroBoleano(Boolean esotroBoleano) {
		this.esotroBoleano = esotroBoleano;
	}

	public Boolean getEsclienteBoleano() {
		if(!UValidador.esNulo(escliente)){
			if(escliente.equals("N")){
				esclienteBoleano = false;
			}else{
				esclienteBoleano = true;
			}
			
		}
		return esclienteBoleano;
	}

	public void setEsclienteBoleano(Boolean esclienteBoleano) {
		this.esclienteBoleano = esclienteBoleano;
	}

	
	public BigDecimal getPersona() {
		return persona;
	}

	public void setPersona(BigDecimal persona) {
		this.persona = persona;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public String getEscliente() {
		return escliente;
	}

	public void setEscliente(String escliente) {
		this.escliente = escliente;
	}

	public String getEsproveedor() {
		return esproveedor;
	}

	public void setEsproveedor(String esproveedor) {
		this.esproveedor = esproveedor;
	}

	public String getEsempleado() {
		return esempleado;
	}

	public void setEsempleado(String esempleado) {
		this.esempleado = esempleado;
	}

	public String getEsotro() {
		return esotro;
	}

	public void setEsotro(String esotro) {
		this.esotro = esotro;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPersonaant() {
		return personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}

	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}

	public String getDocumentoidentidad() {
		return documentoidentidad;
	}

	public void setDocumentoidentidad(String documentoidentidad) {
		this.documentoidentidad = documentoidentidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



}
