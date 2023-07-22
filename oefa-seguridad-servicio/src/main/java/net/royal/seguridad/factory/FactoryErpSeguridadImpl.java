package net.royal.seguridad.factory;

import java.io.Serializable;

import net.royal.seguridad.correo.servicio.CorreoServicio;
import net.royal.seguridad.servicio.AplicacionesmastServicio;
import net.royal.seguridad.servicio.ClientemastServicio;
import net.royal.seguridad.servicio.CompaniamastServicio;
import net.royal.seguridad.servicio.CompanyownerServicio;
import net.royal.seguridad.servicio.EmpleadomastServicio;
import net.royal.seguridad.servicio.HrPuestoempresaServicio;
import net.royal.seguridad.servicio.ParametrosmastServicio;
import net.royal.seguridad.servicio.PersonamastServicio;
import net.royal.seguridad.servicio.SeguridadautorizacionesServicio;
import net.royal.seguridad.servicio.SeguridadconceptoServicio;
import net.royal.seguridad.servicio.SeguridadgrupoServicio;
import net.royal.seguridad.servicio.SeguridadperfilusuarioServicio;
import net.royal.seguridad.servicio.UsuarioServicio;

public class FactoryErpSeguridadImpl implements FactoryErpSeguridad,Serializable {

	private AplicacionesmastServicio aplicacionesmastServicio;
	private SeguridadautorizacionesServicio seguridadautorizacionesServicio;
	private SeguridadconceptoServicio seguridadconceptoServicio;
	private SeguridadgrupoServicio seguridadgrupoServicio;
	private SeguridadperfilusuarioServicio seguridadperfilusuarioServicio;
	private UsuarioServicio usuarioServicio;
	private ClientemastServicio clientemastServicio;
	private CompaniamastServicio companiamastServicio;
	private CompanyownerServicio companyownerServicio;
	private EmpleadomastServicio empleadomastServicio;
	private PersonamastServicio personamastServicio;
	private HrPuestoempresaServicio hrPuestoempresaServicio;
	private CorreoServicio correoServicio;

	@Override
	public ClientemastServicio getClientemastServicio() {
		return clientemastServicio;
	}

	@Override
	public void setClientemastServicio(ClientemastServicio clientemastServicio) {
		this.clientemastServicio = clientemastServicio;
	}

	@Override
	public CompaniamastServicio getCompaniamastServicio() {
		return companiamastServicio;
	}

	@Override
	public void setCompaniamastServicio(
			CompaniamastServicio companiamastServicio) {
		this.companiamastServicio = companiamastServicio;
	}

	@Override
	public CompanyownerServicio getCompanyownerServicio() {
		return companyownerServicio;
	}

	@Override
	public void setCompanyownerServicio(
			CompanyownerServicio companyownerServicio) {
		this.companyownerServicio = companyownerServicio;
	}

	@Override
	public PersonamastServicio getPersonamastServicio() {
		return personamastServicio;
	}

	@Override
	public void setPersonamastServicio(PersonamastServicio personamastServicio) {
		this.personamastServicio = personamastServicio;
	}

	@Override
	public EmpleadomastServicio getEmpleadomastServicio() {
		return empleadomastServicio;
	}

	@Override
	public void setEmpleadomastServicio(
			EmpleadomastServicio empleadomastServicio) {
		this.empleadomastServicio = empleadomastServicio;
	}

	@Override
	public UsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}

	@Override
	public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

	@Override
	public SeguridadautorizacionesServicio getSeguridadautorizacionesServicio() {
		return seguridadautorizacionesServicio;
	}

	@Override
	public void setSeguridadautorizacionesServicio(
			SeguridadautorizacionesServicio seguridadautorizacionesServicio) {
		this.seguridadautorizacionesServicio = seguridadautorizacionesServicio;
	}

	@Override
	public SeguridadperfilusuarioServicio getSeguridadperfilusuarioServicio() {
		return seguridadperfilusuarioServicio;
	}

	@Override
	public void setSeguridadperfilusuarioServicio(
			SeguridadperfilusuarioServicio seguridadperfilusuarioServicio) {
		this.seguridadperfilusuarioServicio = seguridadperfilusuarioServicio;
	}

	@Override
	public AplicacionesmastServicio getAplicacionesmastServicio() {
		return aplicacionesmastServicio;
	}

	@Override
	public void setAplicacionesmastServicio(
			AplicacionesmastServicio aplicacionesmastServicio) {
		this.aplicacionesmastServicio = aplicacionesmastServicio;
	}

	@Override
	public SeguridadconceptoServicio getSeguridadconceptoServicio() {
		return seguridadconceptoServicio;
	}

	@Override
	public void setSeguridadconceptoServicio(
			SeguridadconceptoServicio seguridadconceptoServicio) {
		this.seguridadconceptoServicio = seguridadconceptoServicio;
	}

	@Override
	public SeguridadgrupoServicio getSeguridadgrupoServicio() {
		return seguridadgrupoServicio;
	}

	@Override
	public void setSeguridadgrupoServicio(
			SeguridadgrupoServicio seguridadgrupoServicio) {
		this.seguridadgrupoServicio = seguridadgrupoServicio;
	}

	@Override
	public HrPuestoempresaServicio getHrPuestoempresaServicio() {
		return hrPuestoempresaServicio;
	}

	@Override
	public void setHrPuestoempresaServicio(
			HrPuestoempresaServicio hrPuestoempresaServicio) {
		this.hrPuestoempresaServicio=hrPuestoempresaServicio;
	}
	
	@Override
	public CorreoServicio getCorreoServicio() {
		return correoServicio;
	}
	
	@Override
	public void setCorreoServicio(CorreoServicio correoServicio) {
		this.correoServicio = correoServicio;
	}

	private ParametrosmastServicio parametrosmastServicio;
	@Override
	public ParametrosmastServicio getParametrosmastServicio() {
		return parametrosmastServicio;
	}

	@Override
	public void setParametrosmastServicio(
			ParametrosmastServicio parametrosmastServicio) {
		this.parametrosmastServicio=parametrosmastServicio;
	}

}
