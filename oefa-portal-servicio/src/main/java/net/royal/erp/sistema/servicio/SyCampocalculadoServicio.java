package net.royal.erp.sistema.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.sistema.dominio.SyCampocalculado;
import net.royal.erp.sistema.dominio.SyCampocalculadoPk;

public interface SyCampocalculadoServicio extends GenericoServicio {

	public List DwWhImportacionSelectBl(String companiasocio);
	
}
