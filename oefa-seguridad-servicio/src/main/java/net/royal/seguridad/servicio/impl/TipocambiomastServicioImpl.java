package net.royal.seguridad.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.TipocambiomastDao;
import net.royal.seguridad.dominio.Tipocambiomast;
import net.royal.seguridad.dominio.TipocambiomastPk;
import net.royal.seguridad.servicio.TipocambiomastServicio;

@Service (value = "BeanServicioTipocambiomastSeguridad")
public class TipocambiomastServicioImpl extends GenericoServicioImpl implements TipocambiomastServicio {

	private TipocambiomastDao dao;

	private static Log LOGGER = LogFactory.getLog(TipocambiomastServicioImpl.class);

	@Autowired
	@Qualifier("tipocambiomastDaoImplSeguridad")
	public void setDao(TipocambiomastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Tipocambiomast obtenerTipoCambio(Date fecha, String monedaCodigo,
			String monedaCambioCodigo) {
		return dao.obtenerTipoCambio(fecha, monedaCodigo, monedaCambioCodigo);
	}

	@Override
	public Tipocambiomast obtenerTipoCambioMaximo(Date fecha,
			String monedaCodigo, String monedaCambioCodigo) {
		return dao.obtenerTipoCambioMaximo(fecha, monedaCodigo, monedaCambioCodigo);
	}

	@Override
	public BigDecimal obtenerFactor(Date fecha, String rateType) {
		return dao.obtenerFactor(fecha, rateType);
	}

}
