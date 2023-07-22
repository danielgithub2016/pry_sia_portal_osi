package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoreporta;
import net.royal.erp.rrhh.dominio.HrPuestoreportaPk;

public interface HrPuestoreportaServicio extends GenericoServicio {

	public List<HrPuestoreporta> listarTabRelaciones(Integer codigopuesto);
	
	public List<HrPuestoreporta> listarPuestoreporta();
}
