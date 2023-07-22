package net.royal.seguridad.factory;

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

public interface FactoryErpSeguridad {
	public CorreoServicio getCorreoServicio();
	public void setCorreoServicio(CorreoServicio correoServicio);
	
	public UsuarioServicio getUsuarioServicio();

	public void setUsuarioServicio(UsuarioServicio usuarioServicio);

	public SeguridadautorizacionesServicio getSeguridadautorizacionesServicio();

	public void setSeguridadautorizacionesServicio(
			SeguridadautorizacionesServicio seguridadAutorizacionesServicio);

	public SeguridadperfilusuarioServicio getSeguridadperfilusuarioServicio();

	public void setSeguridadperfilusuarioServicio(
			SeguridadperfilusuarioServicio seguridadPerfilUsuarioServicio);

	public AplicacionesmastServicio getAplicacionesmastServicio();

	public void setAplicacionesmastServicio(
			AplicacionesmastServicio aplicacionesMastServicio);

	public SeguridadconceptoServicio getSeguridadconceptoServicio();

	public void setSeguridadconceptoServicio(
			SeguridadconceptoServicio seguridadConceptoServicio);

	public SeguridadgrupoServicio getSeguridadgrupoServicio();

	public void setSeguridadgrupoServicio(
			SeguridadgrupoServicio seguridadGrupoServicio);

	public PersonamastServicio getPersonamastServicio();

	public void setPersonamastServicio(PersonamastServicio personamastServicio);

	public EmpleadomastServicio getEmpleadomastServicio();

	public void setEmpleadomastServicio(
			EmpleadomastServicio empleadomastServicio);

	public ClientemastServicio getClientemastServicio();

	public void setClientemastServicio(ClientemastServicio clientemastServicio);

	public CompaniamastServicio getCompaniamastServicio();

	public void setCompaniamastServicio(
			CompaniamastServicio companiamastServicio);

	public CompanyownerServicio getCompanyownerServicio();

	public void setCompanyownerServicio(
			CompanyownerServicio companyownerServicio);
	
	public HrPuestoempresaServicio getHrPuestoempresaServicio();
	
	public void setHrPuestoempresaServicio(
			HrPuestoempresaServicio hrPuestoempresaServicio);
	
	public ParametrosmastServicio getParametrosmastServicio();
	public void setParametrosmastServicio(ParametrosmastServicio parametrosmastServicio);
}
