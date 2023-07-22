package net.royal.erp.core.servicio.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.servicio.ParametrosmastServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioParametrosmast")
public class ParametrosmastServicioImpl extends GenericoServicioImpl implements ParametrosmastServicio {

	private ParametrosmastDao dao;

	private static Log LOGGER = LogFactory.getLog(ParametrosmastServicioImpl.class);

	@Autowired
	public void setDao(ParametrosmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerValorCadena(ParametrosmastPk pk) {
		return dao.obtenerValorCadena(pk);
	}

	@Override
	public Integer obtenerValorInteger(ParametrosmastPk pk) {
		return dao.obtenerValorInteger(pk);
	}

	@Override
	public BigDecimal obtenerValorDecimal(ParametrosmastPk pk) {
		return dao.obtenerValorDecimal(pk);
	}

	@Override
	public String obtenerValorDescripcion(ParametrosmastPk pk) {
		return dao.obtenerValorDescripcion(pk);
	}

	/**
	 * f_validate_ruc
	 */

	@Override
	public String calcularIGVDiferencia(BigDecimal par_montoafecto, BigDecimal par_montoigv,
			BigDecimal str_global_gvigv) {
		return dao.calcularIGVDiferencia(par_montoafecto, par_montoigv, str_global_gvigv);
	}

	@Override
	public String obtenerValorCadena(String parametroclave) {
		return dao.obtenerValorCadena(parametroclave);
	}

	@Override
	public String obtenerValorExplicacion(ParametrosmastPk pk) {
		Parametrosmast obj = dao.obtenerPorId(pk, false);
		if (!UValidador.esNulo(obj))
			return obj.getExplicacion();
		return null;
	}

	@Override
	public Date obtenerValorFecha(ParametrosmastPk pk) {
		// TODO Auto-generated method stub
		Parametrosmast obj = dao.obtenerPorId(pk, false);
		if (!UValidador.esNulo(obj))
			return obj.getFecha();
		return null;
	}

}
