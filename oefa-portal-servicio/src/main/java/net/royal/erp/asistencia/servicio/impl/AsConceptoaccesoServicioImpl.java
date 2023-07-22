package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.erp.asistencia.dao.AsConceptoaccesoDao;
import net.royal.erp.asistencia.dominio.dto.DtoAsConceptoacceso;
import net.royal.erp.asistencia.servicio.AsConceptoaccesoServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsConceptoacceso")
public class AsConceptoaccesoServicioImpl extends GenericoServicioImpl
		implements AsConceptoaccesoServicio {

	private AsConceptoaccesoDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsConceptoaccesoServicioImpl.class);

	@Autowired
	public void setDao(AsConceptoaccesoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List obtenerExpresadoen(String conceptoacceso) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_conceptoacceso",
				String.class, conceptoacceso));

		return dao.listarPorQuery(DtoAsConceptoacceso.class,
				"asconceptoacceso.obtenerExpresadoen", filtros);
	}

	@Override
	public List obtenerConceptosAccesos(String usuario, String isadmin) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_usuario",
				String.class, usuario));
		filtros.add(new ParametroPersistenciaGenerico("p_isadmin",
				String.class, isadmin));

		return dao.listarPorQuery(DtoDddwAsConceptoaccesoSelectPre.class,
				"asconceptoacceso.obtenerConceptosAccesos", filtros);
	}

	@Override
	public List obtenerConceptosAccesosSIGED(String usuario, String isadmin) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_usuario",
				String.class, usuario));
		filtros.add(new ParametroPersistenciaGenerico("p_isadmin",
				String.class, isadmin));

		return dao.listarPorQuery(DtoDddwAsConceptoaccesoSelectPre.class,
				"asconceptoacceso.obtenerConceptosAccesosSIGED", null);
	}
}
