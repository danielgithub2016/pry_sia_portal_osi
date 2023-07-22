package net.royal.erp.sistema.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.sistema.dao.SyCampocalculadoDao;
import net.royal.erp.sistema.servicio.SyCampocalculadoServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.sistema.dominio.dto.DtoDwWhImportacionSelectBl;

@Service(value = "BeanServicioSyCampocalculado")
public class SyCampocalculadoServicioImpl extends GenericoServicioImpl
		implements SyCampocalculadoServicio {

	private SyCampocalculadoDao dao;

	private static Log LOGGER = LogFactory
			.getLog(SyCampocalculadoServicioImpl.class);

	@Autowired
	public void setDao(SyCampocalculadoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	public List DwWhImportacionSelectBl(String companiasocio) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("companiasocio",
				String.class, companiasocio));
		List lista = dao.listarPorQuery(DtoDwWhImportacionSelectBl.class,
				"sycampocalculado.DwWhImportacionSelectBl", filtros);
		return lista;
	}

}
