package net.royal.erp.core.servicio.impl;

import net.royal.erp.core.dao.CorrelativosmastDao;
import net.royal.erp.core.servicio.CorrelativosmastServicio;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioCorrelativosmast")
public class CorrelativosmastServicioImpl extends GenericoServicioImpl
		implements CorrelativosmastServicio {

	private CorrelativosmastDao dao;

	private static Log LOGGER = LogFactory
			.getLog(CorrelativosmastServicioImpl.class);

	@Autowired
	public void setDao(CorrelativosmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	@Transactional
	public Integer incrementarNuevoCorrelativo(String companiacodigo,
			String tipocomprobante, String serie, UsuarioActual usuarioActual) {
		return dao.incrementarNuevoCorrelativo(companiacodigo, tipocomprobante,
				serie, usuarioActual);
	}

	@Override
	@Transactional
	public String incrementarNuevoCorrelativoCadena(String companiacodigo,
			String tipocomprobante, String serie, Integer cerosIzquierda,
			UsuarioActual usuarioActual) {
		return dao.incrementarNuevoCorrelativoCadena(companiacodigo,
				tipocomprobante, serie, cerosIzquierda, usuarioActual);
	}

}
