package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrCentroestudiosDao;
import net.royal.erp.rrhh.dominio.HrCentroestudios;
import net.royal.erp.rrhh.dominio.HrCentroestudiosPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrCentroEstudios;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrCentroestudiosDaoImpl extends
		GenericoDaoImpl<HrCentroestudios, HrCentroestudiosPk> implements
		HrCentroestudiosDao {

	private static Log LOGGER = LogFactory.getLog(HrCentroestudios.class);

	public HrCentroestudiosDaoImpl() {
		super("hrcentroestudios");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<DtoHrCentroEstudios> listarCentroEstudios(String s, String criterio) {
		StringBuilder query = new StringBuilder();
		if(!UValidador.esNulo(s)){
			query.append(this
					.obtenerSentenciaSqlPorQuery("hrcentroestudios.listarCentroEstudios"));
		}
		query.append(s);
		List datos = this.listarPorSentenciaSQL(DtoHrCentroEstudios.class, query,
				null);
		return datos;
	}
}
