package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface HrFactorvalorcapacServicio extends GenericoServicio {

	public List listarFactor(Integer p_factor);

	public String f_sql_factorvalorcapac_rango(Integer p_factor,
			BigDecimal p_respuesta);
}

