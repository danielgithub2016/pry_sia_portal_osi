package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dao.HrClasificadorcargoDao;
import net.royal.erp.rrhh.dominio.HrClasificadorcargo;
import net.royal.erp.rrhh.dominio.HrClasificadorcargoPk;

public interface HrClasificadorcargoServicio extends GenericoServicio {

	public HrClasificadorcargo obtenerClasificadorCargoparam(String clasificadorcargo);
}
