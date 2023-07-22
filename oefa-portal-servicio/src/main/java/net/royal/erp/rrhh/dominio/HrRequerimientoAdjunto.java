package net.royal.erp.rrhh.dominio;

import java.util.Date;

public class HrRequerimientoAdjunto {
	
    private  HrRequerimientoAdjuntoPk pk;                
	private Date fecha;                        
	private String ruta;              
	private String ultimousuario;                
	private Date ultimafechamodif;
	private String eliminado;
	private String uuidalfresco;
	
	private String rutaArchivo;
	
	public HrRequerimientoAdjunto(){
		pk= new HrRequerimientoAdjuntoPk();
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getUltimousuario() {
		return ultimousuario;
	}
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public HrRequerimientoAdjuntoPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientoAdjuntoPk pk) {
		this.pk = pk;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

	public String getUuidalfresco() {
		return uuidalfresco;
	}

	public void setUuidalfresco(String uuidalfresco) {
		this.uuidalfresco = uuidalfresco;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	
	
	

}
