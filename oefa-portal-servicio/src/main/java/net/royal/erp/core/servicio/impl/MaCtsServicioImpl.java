package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.core.dao.MaCtsDao;
import net.royal.erp.core.dominio.MaCts;
import net.royal.erp.core.servicio.MaCtsServicio;
import net.royal.erp.planilla.dominio.dto.DtoPeriodos;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service (value = "BeanServicioMaCts")
public class MaCtsServicioImpl extends GenericoServicioImpl implements MaCtsServicio {

	private MaCtsDao dao;

	private static Log LOGGER = LogFactory.getLog(MaCtsServicioImpl.class);

	@Autowired
	public void setDao(MaCtsDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<MaCts> obtenerCombo() {
		return dao.obtenerCombo();
	}

	@Override
	public List<DtoPeriodos> obtenerPeriodos() {

		List datos = dao.listarPorQuery(DtoPeriodos.class, "macts.listaperiodos");
		return datos;
	}

}
