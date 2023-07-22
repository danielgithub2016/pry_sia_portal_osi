package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadconcepto
 */
public class Seguridadconcepto extends DominioGenerico implements
		java.io.Serializable {

	private SeguridadconceptoPk pk;
	private String descripcion;
	private String visibleflag;
	private String tipodedetalle;
	private String tipodeobjeto;
	private String objeto;
	private String tipodeacceso;
	private String objetowindow;
	private String workflag;
	private String workagregarflag;
	private String workmodificarflag;
	private String workborrarflag;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;
	private String workaprobarflag;
	private String xestado;
	private String descripcioningles;
	private String webaction;
	private String webflag;
	private String webgrupo;
	private String webpage;
	private Integer webgruposecuencia;
	private String codigoCompleto;
	private String conceptopadre;
	private String conceptoRelacion;
	
	public String getConceptoRelacion() {
		return conceptoRelacion;
	}

	public void setConceptoRelacion(String conceptoRelacion) {
		this.conceptoRelacion = conceptoRelacion;
	}

	public Seguridadconcepto() {
		pk = new SeguridadconceptoPk();
	}

	public SeguridadconceptoPk getPk() {
		return pk;
	}

	public void setPk(SeguridadconceptoPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVisibleflag() {
		return visibleflag;
	}

	public void setVisibleflag(String visibleflag) {
		this.visibleflag = visibleflag;
	}

	public String getTipodedetalle() {
		return tipodedetalle;
	}

	public void setTipodedetalle(String tipodedetalle) {
		this.tipodedetalle = tipodedetalle;
	}

	public String getTipodeobjeto() {
		return tipodeobjeto;
	}

	public void setTipodeobjeto(String tipodeobjeto) {
		this.tipodeobjeto = tipodeobjeto;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getTipodeacceso() {
		return tipodeacceso;
	}

	public void setTipodeacceso(String tipodeacceso) {
		this.tipodeacceso = tipodeacceso;
	}

	public String getObjetowindow() {
		return objetowindow;
	}

	public void setObjetowindow(String objetowindow) {
		this.objetowindow = objetowindow;
	}

	public String getWorkflag() {
		return workflag;
	}

	public void setWorkflag(String workflag) {
		this.workflag = workflag;
	}

	public String getWorkagregarflag() {
		return workagregarflag;
	}

	public void setWorkagregarflag(String workagregarflag) {
		this.workagregarflag = workagregarflag;
	}

	public String getWorkmodificarflag() {
		return workmodificarflag;
	}

	public void setWorkmodificarflag(String workmodificarflag) {
		this.workmodificarflag = workmodificarflag;
	}

	public String getWorkborrarflag() {
		return workborrarflag;
	}

	public void setWorkborrarflag(String workborrarflag) {
		this.workborrarflag = workborrarflag;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public java.util.Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(java.util.Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getWorkaprobarflag() {
		return workaprobarflag;
	}

	public void setWorkaprobarflag(String workaprobarflag) {
		this.workaprobarflag = workaprobarflag;
	}

	public String getXestado() {
		return xestado;
	}

	public void setXestado(String xestado) {
		this.xestado = xestado;
	}

	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}

	public String getWebaction() {
		return webaction;
	}

	public void setWebaction(String webaction) {
		this.webaction = webaction;
	}

	public String getWebflag() {
		return webflag;
	}

	public void setWebflag(String webflag) {
		this.webflag = webflag;
	}

	public String getWebgrupo() {
		return webgrupo;
	}

	public void setWebgrupo(String webgrupo) {
		this.webgrupo = webgrupo;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public Integer getWebgruposecuencia() {
		return webgruposecuencia;
	}

	public void setWebgruposecuencia(Integer webgruposecuencia) {
		this.webgruposecuencia = webgruposecuencia;
	}

	public String getCodigoCompleto() {
		if (this.pk == null)
			return "";
		String app, gru, con;

		if (this.pk.getAplicacioncodigo() == null)
			app = "";
		else
			app = this.pk.getAplicacioncodigo();

		if (this.pk.getGrupo() == null)
			gru = "";
		else
			gru = this.pk.getGrupo();

		if (this.pk.getConcepto() == null)
			con = "";
		else
			con = this.pk.getConcepto();
		
		this.codigoCompleto = app + gru + con;
		
		return codigoCompleto;
	}

	public void setCodigoCompleto(String codigoCompleto) {
		this.codigoCompleto = codigoCompleto;
	}

	public String getConceptopadre() {
		return conceptopadre;
	}

	public void setConceptopadre(String conceptopadre) {
		this.conceptopadre = conceptopadre;
	}

}
