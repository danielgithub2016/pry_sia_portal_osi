package net.royal.marcainterna.pcoefa.dominio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadrango
 */
public class MapPcOefa extends DominioGenerico implements java.io.Serializable {

	private BigDecimal secuencia;
	private String tx_nombre;
	private String tx_sistema_operativo;
	private String activo;
	private String flg_prestamo;

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

	public String getTx_nombre() {
		return tx_nombre;
	}

	public void setTx_nombre(String tx_nombre) {
		this.tx_nombre = tx_nombre;
	}

	public String getTx_sistema_operativo() {
		return tx_sistema_operativo;
	}

	public void setTx_sistema_operativo(String tx_sistema_operativo) {
		this.tx_sistema_operativo = tx_sistema_operativo;
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

	public String getFlg_prestamo() {
		return flg_prestamo;
	}

	public void setFlg_prestamo(String flg_prestamo) {
		this.flg_prestamo = flg_prestamo;
	}

}
