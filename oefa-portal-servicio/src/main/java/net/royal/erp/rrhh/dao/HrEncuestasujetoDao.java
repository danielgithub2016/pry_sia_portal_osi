package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEncuestasujeto;
import net.royal.erp.rrhh.dominio.HrEncuestasujetoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEncuestasujetoDao extends GenericoDao<HrEncuestasujeto, HrEncuestasujetoPk> {
	public Integer obtenerNuevoSujeto(Integer secuencia);

	public void registrarSujeto(DtoHrEncuesta encuesta, List<HrEncuestasujeto> sujeto);
}
