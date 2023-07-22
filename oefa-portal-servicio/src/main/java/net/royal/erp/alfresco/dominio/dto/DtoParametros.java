package net.royal.erp.alfresco.dominio.dto;

import net.royal.framework.web.core.UValidador;

public class DtoParametros {

	private String session_usuario;
	private String proceso;
	private String idproceso;
	private String usuario;
	private String accion;
	private String carpeta;
	private boolean isMantener;

	// en caso de descarga externa de doumentos
	private String uuid;

	public String getSession_usuario() {
		return session_usuario;
	}

	public void setSession_usuario(String session_usuario) {
		this.session_usuario = session_usuario;
	}

	public String getProceso() {
		if (UValidador.estaVacio(proceso)) {
			proceso = "";
		}
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getIdproceso() {
		return idproceso;
	}

	public void setIdproceso(String idproceso) {
		this.idproceso = idproceso;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public boolean isMantener() {
		return isMantener;
	}

	public void setMantener(boolean isMantener) {
		this.isMantener = isMantener;
	}
	
}
