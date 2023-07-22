package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Tiposervicio;
import net.royal.erp.core.dominio.TiposervicioPk;
import java.util.List;

public interface TiposervicioDao extends
		GenericoDao<Tiposervicio, TiposervicioPk> {
	
	public List<Tiposervicio>listarTipoServicio(String par_tipo);

}
