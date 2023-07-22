package net.royal.erp.asistencia.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

@SuppressWarnings("serial")
public class AsDetallesiged extends DominioGenerico implements Serializable {

	private AsDetallesigedPk pk;
	private BigDecimal idpersona;
	private BigDecimal idpersona2;
	private BigDecimal idpersona3;
	private BigDecimal idarea;
	private BigDecimal idcargo;
	private BigDecimal idperfil;
	private BigDecimal idempleadosia;
	private BigDecimal idempleadosia2;
	private BigDecimal idcargonuevo;
	private BigDecimal idcargonuevo2;
	private String estado;
	private String flgestadosiged;
	private String flgjefe;
	private String flgasistente;
	private String flgasistentepermanente;
	private String ultimoUsuario;
	private Date ultimaFechaModif;
	private String ultimoUsuarioSiged;
	private Date ultimaFechaModifSiged;

	public AsDetallesiged() {
		pk = new AsDetallesigedPk();
	}

	public AsDetallesigedPk getPk() {
		return pk;
	}

	public void setPk(AsDetallesigedPk pk) {
		this.pk = pk;
	}

	public BigDecimal getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(BigDecimal idpersona) {
		this.idpersona = idpersona;
	}

	public BigDecimal getIdarea() {
		return idarea;
	}

	public void setIdarea(BigDecimal idarea) {
		this.idarea = idarea;
	}

	public BigDecimal getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(BigDecimal idperfil) {
		this.idperfil = idperfil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimoUsuario() {
		return ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	public Date getUltimaFechaModif() {
		return ultimaFechaModif;
	}

	public void setUltimaFechaModif(Date ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}

	public BigDecimal getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(BigDecimal idcargo) {
		this.idcargo = idcargo;
	}

	public BigDecimal getIdempleadosia() {
		return idempleadosia;
	}

	public void setIdempleadosia(BigDecimal idempleadosia) {
		this.idempleadosia = idempleadosia;
	}

	public String getFlgjefe() {
		if (UValidador.estaVacio(flgjefe)) {
			flgjefe = "";
		}
		return flgjefe;
	}

	public void setFlgjefe(String flgjefe) {
		this.flgjefe = flgjefe;
	}

	public String getFlgasistente() {
		return flgasistente;
	}

	public void setFlgasistente(String flgasistente) {
		this.flgasistente = flgasistente;
	}

	public String getFlgestadosiged() {
		return flgestadosiged;
	}

	public void setFlgestadosiged(String flgestadosiged) {
		this.flgestadosiged = flgestadosiged;
	}

	public String getUltimoUsuarioSiged() {
		return ultimoUsuarioSiged;
	}

	public void setUltimoUsuarioSiged(String ultimoUsuarioSiged) {
		this.ultimoUsuarioSiged = ultimoUsuarioSiged;
	}

	public Date getUltimaFechaModifSiged() {
		return ultimaFechaModifSiged;
	}

	public void setUltimaFechaModifSiged(Date ultimaFechaModifSiged) {
		this.ultimaFechaModifSiged = ultimaFechaModifSiged;
	}

	public BigDecimal getIdpersona2() {
		return idpersona2;
	}

	public void setIdpersona2(BigDecimal idpersona2) {
		this.idpersona2 = idpersona2;
	}

	public String getFlgasistentepermanente() {
		return flgasistentepermanente;
	}

	public void setFlgasistentepermanente(String flgasistentepermanente) {
		this.flgasistentepermanente = flgasistentepermanente;
	}

	public BigDecimal getIdempleadosia2() {
		return idempleadosia2;
	}

	public void setIdempleadosia2(BigDecimal idempleadosia2) {
		this.idempleadosia2 = idempleadosia2;
	}

	public BigDecimal getIdpersona3() {
		return idpersona3;
	}

	public void setIdpersona3(BigDecimal idpersona3) {
		this.idpersona3 = idpersona3;
	}

	public BigDecimal getIdcargonuevo() {
		return idcargonuevo;
	}

	public void setIdcargonuevo(BigDecimal idcargonuevo) {
		this.idcargonuevo = idcargonuevo;
	}

	public BigDecimal getIdcargonuevo2() {
		return idcargonuevo2;
	}

	public void setIdcargonuevo2(BigDecimal idcargonuevo2) {
		this.idcargonuevo2 = idcargonuevo2;
	}

}
