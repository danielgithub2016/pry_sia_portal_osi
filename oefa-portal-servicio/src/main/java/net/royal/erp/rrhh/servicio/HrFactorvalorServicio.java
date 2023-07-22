package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrFactorvalorServicio extends GenericoServicio {

	public List<HrFactorvalor> obtenerLista(Integer factor);
	public Integer obtenerMax(Integer factor);
	public Integer obtenerMim(Integer factor);
	public List<DtoDwHrFactorvalorSelCore> listarDw1(Integer par_factor);
	
}
