package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Companyowner;
import net.royal.seguridad.dominio.CompanyownerPk;

public interface CompanyownerServicio extends GenericoServicio {

	public Companyowner obtenerPorCodigoCompanyOwner(String codigoCompanyOwner);
	
public Integer buscarOwnerIgual(String companyowner);
	
	public ParametroPaginacion listarPaginacion(
			ParametroPaginacion paginacion) ;
}
