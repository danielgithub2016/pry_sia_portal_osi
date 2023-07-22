package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.ServicioximpuestoDao;
import net.royal.erp.core.dominio.Servicioximpuesto;
import net.royal.erp.core.dominio.ServicioximpuestoPk;
import net.royal.erp.sistema.dominio.dto.DtoDwCpTiposervicioFactor;

@Repository
public class ServicioximpuestoDaoImpl extends GenericoDaoImpl<Servicioximpuesto, ServicioximpuestoPk> implements ServicioximpuestoDao {

	private static Log LOGGER = LogFactory.getLog(Servicioximpuesto.class);

	public ServicioximpuestoDaoImpl() {
		super("servicioximpuesto");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Servicioximpuesto> listarPorTipoServicio(String tiposervicio) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.tiposervicio", tiposervicio));
		cri.addOrder(Order.asc("pk.impuesto"));
		cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		List<Servicioximpuesto> result = this.listarPorCriterios(cri);
		
		if(UValidador.estaVacio(result))
			return null;
		
		return result;
	}
	
	@Override
	public List DwCpTiposervicioFactor(String tiposervicio) {
		LOGGER.debug("test de syfinan.dw_cp_tiposervicio_factor");
		LOGGER.debug(" usar el siguiente dto :  DtoDwCpTiposervicioFactor");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwCpTiposervicioFactor");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("tiposervicio",
				String.class, tiposervicio));

		List datos = this.listarPorQuery(DtoDwCpTiposervicioFactor.class,
				"apcajachica.DwCpTiposervicioFactor", parametros);

		return datos;
	}

}
