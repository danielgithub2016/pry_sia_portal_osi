package net.royal.erp.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.MaUnidadnegocioDao;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.core.dominio.MaUnidadnegocioPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class MaUnidadnegocioDaoImpl extends
		GenericoDaoImpl<MaUnidadnegocio, MaUnidadnegocioPk> implements
		MaUnidadnegocioDao {

	private static Log LOGGER = LogFactory.getLog(MaUnidadnegocio.class);

	public MaUnidadnegocioDaoImpl() {
		super("maunidadnegocio");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<MaUnidadnegocio> obtenerCombo() {
		LOGGER.debug("Antes del combo");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("pk.unidadnegocio"));

		List<MaUnidadnegocio> result = this.listarPorCriterios(cri);

		return result;

	}

	public List<MaUnidadnegocio> listarUnidadNegocio(String par_unidad) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		if (!UValidador.esNulo(par_unidad)) {
			cri.add(Restrictions.eq("pk.unidadnegocio", par_unidad));
		}
		cri.addOrder(Order.asc("pk.unidadnegocio"));

		List<MaUnidadnegocio> result = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(result)) {
			return null;
		}
		return result;
	}

	/**
	 * f_sql_read_unidadnegocio_name
	 */
	@Override
	public String obtenerNombreUnidadNegocio(String par_unidad) {
		LOGGER.debug("test de sycommon.f_sql_read_unidadnegocio_name");

		String unidad = par_unidad;

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		if (!UValidador.esNulo(par_unidad)) {
			cri.add(Restrictions.eq("pk.unidadnegocio", par_unidad));
		}
		cri.addOrder(Order.asc("pk.unidadnegocio"));

		List<MaUnidadnegocio> result = this.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(result)) {
			return result.get(0).getDescripcionlocal();
		}
		return par_unidad;
	}

}
