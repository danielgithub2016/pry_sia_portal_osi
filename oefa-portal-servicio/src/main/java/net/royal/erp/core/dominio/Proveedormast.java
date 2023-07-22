package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Proveedormast
*/
public class Proveedormast extends DominioGenerico implements java.io.Serializable{

	private ProveedormastPk pk;
	private String tiposervicio;
	private String tipoproveedor;
	private String pagaranombre;
	private String pagarendireccion;
	private String tipopago;
	private String monedapago;
	private String formadepago;
	private String representantelegal;
	private String responsible;
	private String cuentacontablegasto;
	private String chequenonegociableflag;
	private String suspensionrentaflag;
	private String suspensionfonaviflag;
	private String exoneradodeclaracion;
	private java.util.Date exoneradofechainicio;
	private java.util.Date exoneradofechafinal;
	private Integer numerodiaspago;
	private Integer numerodiasentrega;
	private String tipodocumentodefault;
	private String cobradortipodocumento;
	private String cobradornumerodocumento;
	private String cobradornombre;
	private String comentarioservicio;
	private java.util.Date comentariofecha;
	private String comentariousuario;
	private String clasificacionfiscal;
	private String intervencionfiscalflag;
	private String intervencionfiscaldocumento;
	private String registropublico;
	private String licenciamunicipal;
	private java.util.Date fechaconstitucion;
	private String personacontacto;
	private String experienciatiempo;
	private Integer proveedorrelacionado;
	private String exoneradofonavideclaracion;
	private java.util.Date exoneradofonavifechainicio;
	private java.util.Date exoneradofonavifechafinal;
	private String detraccioncodigo;
	private String detraccioncodigoflag;
	private String detraccioncuentabancaria;
	private String retenerpagosflag;
	private String representantelegal2;
	private java.util.Date fechaautorizacionfiscal;
	private String intervencionfiscalcomentario;
	private java.util.Date intervencionfiscalfecha;
	private String exoneradomediopresentacion;
	private String regimentributario;
	private String afpretencionflag;
	private String afpcodigo;
	private String afpcuspp;
	private String afptipocomision;


	public Proveedormast() {
		pk = new ProveedormastPk();
	}

	public ProveedormastPk getPk() {
		return pk;
	}

	public void setPk(ProveedormastPk pk) {
		this.pk = pk;
	}
	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}
	public String getTipoproveedor() {
		return tipoproveedor;
	}

	public void setTipoproveedor(String tipoproveedor) {
		this.tipoproveedor = tipoproveedor;
	}
	public String getPagaranombre() {
		return pagaranombre;
	}

	public void setPagaranombre(String pagaranombre) {
		this.pagaranombre = pagaranombre;
	}
	public String getPagarendireccion() {
		return pagarendireccion;
	}

	public void setPagarendireccion(String pagarendireccion) {
		this.pagarendireccion = pagarendireccion;
	}
	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public String getMonedapago() {
		return monedapago;
	}

	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
	}
	public String getFormadepago() {
		return formadepago;
	}

	public void setFormadepago(String formadepago) {
		this.formadepago = formadepago;
	}
	public String getRepresentantelegal() {
		return representantelegal;
	}

	public void setRepresentantelegal(String representantelegal) {
		this.representantelegal = representantelegal;
	}
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getCuentacontablegasto() {
		return cuentacontablegasto;
	}

	public void setCuentacontablegasto(String cuentacontablegasto) {
		this.cuentacontablegasto = cuentacontablegasto;
	}
	public String getChequenonegociableflag() {
		return chequenonegociableflag;
	}

	public void setChequenonegociableflag(String chequenonegociableflag) {
		this.chequenonegociableflag = chequenonegociableflag;
	}
	public String getSuspensionrentaflag() {
		return suspensionrentaflag;
	}

	public void setSuspensionrentaflag(String suspensionrentaflag) {
		this.suspensionrentaflag = suspensionrentaflag;
	}
	public String getSuspensionfonaviflag() {
		return suspensionfonaviflag;
	}

	public void setSuspensionfonaviflag(String suspensionfonaviflag) {
		this.suspensionfonaviflag = suspensionfonaviflag;
	}
	public String getExoneradodeclaracion() {
		return exoneradodeclaracion;
	}

	public void setExoneradodeclaracion(String exoneradodeclaracion) {
		this.exoneradodeclaracion = exoneradodeclaracion;
	}
	public java.util.Date getExoneradofechainicio() {
		return exoneradofechainicio;
	}

	public void setExoneradofechainicio(java.util.Date exoneradofechainicio) {
		this.exoneradofechainicio = exoneradofechainicio;
	}
	public java.util.Date getExoneradofechafinal() {
		return exoneradofechafinal;
	}

	public void setExoneradofechafinal(java.util.Date exoneradofechafinal) {
		this.exoneradofechafinal = exoneradofechafinal;
	}
	public Integer getNumerodiaspago() {
		return numerodiaspago;
	}

	public void setNumerodiaspago(Integer numerodiaspago) {
		this.numerodiaspago = numerodiaspago;
	}
	public Integer getNumerodiasentrega() {
		return numerodiasentrega;
	}

	public void setNumerodiasentrega(Integer numerodiasentrega) {
		this.numerodiasentrega = numerodiasentrega;
	}
	public String getTipodocumentodefault() {
		return tipodocumentodefault;
	}

	public void setTipodocumentodefault(String tipodocumentodefault) {
		this.tipodocumentodefault = tipodocumentodefault;
	}
	public String getCobradortipodocumento() {
		return cobradortipodocumento;
	}

	public void setCobradortipodocumento(String cobradortipodocumento) {
		this.cobradortipodocumento = cobradortipodocumento;
	}
	public String getCobradornumerodocumento() {
		return cobradornumerodocumento;
	}

	public void setCobradornumerodocumento(String cobradornumerodocumento) {
		this.cobradornumerodocumento = cobradornumerodocumento;
	}
	public String getCobradornombre() {
		return cobradornombre;
	}

	public void setCobradornombre(String cobradornombre) {
		this.cobradornombre = cobradornombre;
	}
	public String getComentarioservicio() {
		return comentarioservicio;
	}

	public void setComentarioservicio(String comentarioservicio) {
		this.comentarioservicio = comentarioservicio;
	}
	public java.util.Date getComentariofecha() {
		return comentariofecha;
	}

	public void setComentariofecha(java.util.Date comentariofecha) {
		this.comentariofecha = comentariofecha;
	}
	public String getComentariousuario() {
		return comentariousuario;
	}

	public void setComentariousuario(String comentariousuario) {
		this.comentariousuario = comentariousuario;
	}
	public String getClasificacionfiscal() {
		return clasificacionfiscal;
	}

	public void setClasificacionfiscal(String clasificacionfiscal) {
		this.clasificacionfiscal = clasificacionfiscal;
	}
	public String getIntervencionfiscalflag() {
		return intervencionfiscalflag;
	}

	public void setIntervencionfiscalflag(String intervencionfiscalflag) {
		this.intervencionfiscalflag = intervencionfiscalflag;
	}
	public String getIntervencionfiscaldocumento() {
		return intervencionfiscaldocumento;
	}

	public void setIntervencionfiscaldocumento(String intervencionfiscaldocumento) {
		this.intervencionfiscaldocumento = intervencionfiscaldocumento;
	}
	public String getRegistropublico() {
		return registropublico;
	}

	public void setRegistropublico(String registropublico) {
		this.registropublico = registropublico;
	}
	public String getLicenciamunicipal() {
		return licenciamunicipal;
	}

	public void setLicenciamunicipal(String licenciamunicipal) {
		this.licenciamunicipal = licenciamunicipal;
	}
	public java.util.Date getFechaconstitucion() {
		return fechaconstitucion;
	}

	public void setFechaconstitucion(java.util.Date fechaconstitucion) {
		this.fechaconstitucion = fechaconstitucion;
	}
	public String getPersonacontacto() {
		return personacontacto;
	}

	public void setPersonacontacto(String personacontacto) {
		this.personacontacto = personacontacto;
	}
	public String getExperienciatiempo() {
		return experienciatiempo;
	}

	public void setExperienciatiempo(String experienciatiempo) {
		this.experienciatiempo = experienciatiempo;
	}
	public Integer getProveedorrelacionado() {
		return proveedorrelacionado;
	}

	public void setProveedorrelacionado(Integer proveedorrelacionado) {
		this.proveedorrelacionado = proveedorrelacionado;
	}
	public String getExoneradofonavideclaracion() {
		return exoneradofonavideclaracion;
	}

	public void setExoneradofonavideclaracion(String exoneradofonavideclaracion) {
		this.exoneradofonavideclaracion = exoneradofonavideclaracion;
	}
	public java.util.Date getExoneradofonavifechainicio() {
		return exoneradofonavifechainicio;
	}

	public void setExoneradofonavifechainicio(java.util.Date exoneradofonavifechainicio) {
		this.exoneradofonavifechainicio = exoneradofonavifechainicio;
	}
	public java.util.Date getExoneradofonavifechafinal() {
		return exoneradofonavifechafinal;
	}

	public void setExoneradofonavifechafinal(java.util.Date exoneradofonavifechafinal) {
		this.exoneradofonavifechafinal = exoneradofonavifechafinal;
	}
	public String getDetraccioncodigo() {
		return detraccioncodigo;
	}

	public void setDetraccioncodigo(String detraccioncodigo) {
		this.detraccioncodigo = detraccioncodigo;
	}
	public String getDetraccioncodigoflag() {
		return detraccioncodigoflag;
	}

	public void setDetraccioncodigoflag(String detraccioncodigoflag) {
		this.detraccioncodigoflag = detraccioncodigoflag;
	}
	public String getDetraccioncuentabancaria() {
		return detraccioncuentabancaria;
	}

	public void setDetraccioncuentabancaria(String detraccioncuentabancaria) {
		this.detraccioncuentabancaria = detraccioncuentabancaria;
	}
	public String getRetenerpagosflag() {
		return retenerpagosflag;
	}

	public void setRetenerpagosflag(String retenerpagosflag) {
		this.retenerpagosflag = retenerpagosflag;
	}
	public String getRepresentantelegal2() {
		return representantelegal2;
	}

	public void setRepresentantelegal2(String representantelegal2) {
		this.representantelegal2 = representantelegal2;
	}
	public java.util.Date getFechaautorizacionfiscal() {
		return fechaautorizacionfiscal;
	}

	public void setFechaautorizacionfiscal(java.util.Date fechaautorizacionfiscal) {
		this.fechaautorizacionfiscal = fechaautorizacionfiscal;
	}
	public String getIntervencionfiscalcomentario() {
		return intervencionfiscalcomentario;
	}

	public void setIntervencionfiscalcomentario(String intervencionfiscalcomentario) {
		this.intervencionfiscalcomentario = intervencionfiscalcomentario;
	}
	public java.util.Date getIntervencionfiscalfecha() {
		return intervencionfiscalfecha;
	}

	public void setIntervencionfiscalfecha(java.util.Date intervencionfiscalfecha) {
		this.intervencionfiscalfecha = intervencionfiscalfecha;
	}
	public String getExoneradomediopresentacion() {
		return exoneradomediopresentacion;
	}

	public void setExoneradomediopresentacion(String exoneradomediopresentacion) {
		this.exoneradomediopresentacion = exoneradomediopresentacion;
	}
	public String getRegimentributario() {
		return regimentributario;
	}

	public void setRegimentributario(String regimentributario) {
		this.regimentributario = regimentributario;
	}
	public String getAfpretencionflag() {
		return afpretencionflag;
	}

	public void setAfpretencionflag(String afpretencionflag) {
		this.afpretencionflag = afpretencionflag;
	}
	public String getAfpcodigo() {
		return afpcodigo;
	}

	public void setAfpcodigo(String afpcodigo) {
		this.afpcodigo = afpcodigo;
	}
	public String getAfpcuspp() {
		return afpcuspp;
	}

	public void setAfpcuspp(String afpcuspp) {
		this.afpcuspp = afpcuspp;
	}
	public String getAfptipocomision() {
		return afptipocomision;
	}

	public void setAfptipocomision(String afptipocomision) {
		this.afptipocomision = afptipocomision;
	}

}
