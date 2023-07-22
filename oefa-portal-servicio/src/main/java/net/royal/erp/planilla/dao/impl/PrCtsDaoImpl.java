package net.royal.erp.planilla.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.planilla.dao.PrCtsDao;
import net.royal.erp.planilla.dominio.PrCts;
import net.royal.erp.planilla.dominio.PrCtsPk;
import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsList;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

@Repository
public class PrCtsDaoImpl extends GenericoDaoImpl<PrCts, PrCtsPk> implements PrCtsDao {

	private static Log LOGGER = LogFactory.getLog(PrCts.class);

	public PrCtsDaoImpl() {
		super("prcts");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<DtoDwPrCtsList> listarCtsEmpleado(String compania,BigDecimal cts, BigDecimal ctsfinal, String moneda,
			String estadoempleado) {
		
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_compania", String.class,compania));
		parametros.add(new ParametroPersistenciaGenerico("p_cts", BigDecimal.class,cts));
		parametros.add(new ParametroPersistenciaGenerico("p_ctsfinal", BigDecimal.class, ctsfinal));
		parametros.add(new ParametroPersistenciaGenerico("p_moneda", String.class, moneda));
		parametros.add(new ParametroPersistenciaGenerico("p_estadoempleado", String.class, estadoempleado));
		
		List data = listarPorQuery(DtoDwPrCtsList.class, "prcts.listactsempleado",parametros);

		return data;
	}
	
}
