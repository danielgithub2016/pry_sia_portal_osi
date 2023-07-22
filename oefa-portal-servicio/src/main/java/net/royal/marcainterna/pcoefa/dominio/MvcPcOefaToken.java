package net.royal.marcainterna.pcoefa.dominio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadrango
 */
public class MvcPcOefaToken extends DominioGenerico implements java.io.Serializable {

	private BigDecimal secuencia;
	private String tx_token;
	private String tx_pc;
	private Date fe_fecha_hora_token;
	private String activo;
	private String tx_estado;
	private String tx_codigo_usuario_creacion;
	private Date fe_fecha_creacion;
	private String tx_codigo_usuario_modificacion;
	private Date fe_fecha_modificacion;

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getTx_token() {
		return tx_token;
	}

	public void setTx_token(String tx_token) {
		this.tx_token = tx_token;
	}

	public Date getFe_fecha_hora_token() {
		return fe_fecha_hora_token;
	}

	public void setFe_fecha_hora_token(Date fe_fecha_hora_token) {
		this.fe_fecha_hora_token = fe_fecha_hora_token;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getTx_codigo_usuario_creacion() {
		return tx_codigo_usuario_creacion;
	}

	public void setTx_codigo_usuario_creacion(String tx_codigo_usuario_creacion) {
		this.tx_codigo_usuario_creacion = tx_codigo_usuario_creacion;
	}

	public Date getFe_fecha_creacion() {
		return fe_fecha_creacion;
	}

	public void setFe_fecha_creacion(Date fe_fecha_creacion) {
		this.fe_fecha_creacion = fe_fecha_creacion;
	}

	public String getTx_codigo_usuario_modificacion() {
		return tx_codigo_usuario_modificacion;
	}

	public void setTx_codigo_usuario_modificacion(String tx_codigo_usuario_modificacion) {
		this.tx_codigo_usuario_modificacion = tx_codigo_usuario_modificacion;
	}

	public Date getFe_fecha_modificacion() {
		return fe_fecha_modificacion;
	}

	public void setFe_fecha_modificacion(Date fe_fecha_modificacion) {
		this.fe_fecha_modificacion = fe_fecha_modificacion;
	}

	public String getTx_pc() {
		return tx_pc;
	}

	public void setTx_pc(String tx_pc) {
		this.tx_pc = tx_pc;
	}

	public String getTx_estado() {
		return tx_estado;
	}

	public void setTx_estado(String tx_estado) {
		this.tx_estado = tx_estado;
	}

	
}
