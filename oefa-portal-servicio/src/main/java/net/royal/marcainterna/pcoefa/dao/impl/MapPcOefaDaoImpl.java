package net.royal.marcainterna.pcoefa.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.sistema.dominio.SyCampocalculado;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.marcainterna.pcoefa.dao.MapPcOefaDao;
import net.royal.marcainterna.pcoefa.dominio.MapPcOefa;

@Repository
public class MapPcOefaDaoImpl extends GenericoDaoImpl<MapPcOefa, BigDecimal> implements MapPcOefaDao {

	private static Log LOGGER = LogFactory.getLog(SyCampocalculado.class);

	public MapPcOefaDaoImpl() {
		super("MapPcOefaDaoImpl");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<MapPcOefa> listarPorCriterios(MapPcOefa mapPcOefa) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();

		if (!UValidador.estaVacio(mapPcOefa.getTx_nombre())) {
			cri.add(Restrictions.eq("tx_nombre", mapPcOefa.getTx_nombre()).ignoreCase());
		}

		if (!UValidador.estaVacio(mapPcOefa.getFlg_prestamo())) {
			cri.add(Restrictions.eq("flg_prestamo", mapPcOefa.getFlg_prestamo()).ignoreCase());
		}

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return null;

		return lista;
	}

}
