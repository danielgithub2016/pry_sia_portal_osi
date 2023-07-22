package net.royal.seguridad.servicio.impl;

//import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.ParametrosmastDao;
import net.royal.seguridad.dominio.Parametrosmast;
import net.royal.seguridad.dominio.ParametrosmastPk;
import net.royal.seguridad.servicio.ParametrosmastServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioParametrosmastSeguridad")
public class ParametrosmastServicioImpl extends GenericoServicioImpl implements
		ParametrosmastServicio {

	private ParametrosmastDao dao;

	private static Log LOGGER = LogFactory
			.getLog(ParametrosmastServicioImpl.class);

	@Autowired
	@Qualifier("parametrosmastDaoImplSeguridad")
	public void setDao(ParametrosmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerValorCadena(String companiacodigo,
			String aplicacioncodigo, String parametroclave) {
		return dao.obtenerValorCadena(companiacodigo, aplicacioncodigo,
				parametroclave);
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

	


}
