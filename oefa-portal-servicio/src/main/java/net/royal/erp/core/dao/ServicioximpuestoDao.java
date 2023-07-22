package net.royal.erp.core.dao;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dominio.Servicioximpuesto;
import net.royal.erp.core.dominio.ServicioximpuestoPk;
import net.royal.erp.sistema.dominio.dto.DtoDwCpTiposervicioFactor;
import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

public interface ServicioximpuestoDao extends
		GenericoDao<Servicioximpuesto, ServicioximpuestoPk> {
	public List<Servicioximpuesto> listarPorTipoServicio(String tiposervicio);
	public List DwCpTiposervicioFactor(String tiposervicio);
	
	
}
