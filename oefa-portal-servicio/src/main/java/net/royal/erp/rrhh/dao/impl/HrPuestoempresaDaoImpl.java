package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HrPuestoempresaDaoImpl extends
		GenericoDaoImpl<HrPuestoempresa, HrPuestoempresaPk> implements
		HrPuestoempresaDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoempresa.class);
	private MaMiscelaneosdetalleDao daoMa;

	public HrPuestoempresaDaoImpl() {
		super("hrpuestoempresa");
	}

	@Autowired
	public void setDaoMa(MaMiscelaneosdetalleDao daoMa) {
		this.daoMa = daoMa;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoempresa> listarPuestoEmpresa() {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("descripcion"));

		List<HrPuestoempresa> lista = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(lista))
			return null;
		return lista;
	}

	@Override
	public List<HrPuestoempresa> listarPuestoEmpresaporFiltros(
			String codigopuesto, String flagpuestopracticante) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));

		cri.add(Restrictions
				.sqlRestriction(" nvl(flagpuestopracticante,'T') LIKE '"
						+ flagpuestopracticante + "%' "));

		LOGGER.debug("codigopuesto " + codigopuesto);

		if (!UValidador.estaVacio(codigopuesto)) {
			cri.add(Restrictions.sqlRestriction(" UPPER(descripcion) LIKE '"
					+ codigopuesto.toUpperCase().trim() + "%' "));
		} else {
			cri.add(Restrictions.sqlRestriction(" descripcion LIKE '%' "));
		}
		
		cri.addOrder(Order.asc("descripcion"));

		List<HrPuestoempresa> lista = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(lista))
			return null;
		return lista;
	}

	public List<HrPuestoempresa> listarComboPuestos() {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("pk.codigopuesto"));

		List datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;
	}

	@Override
	public HrPuestoempresa obtenerPuestoEmpresaporCodigo(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoempresa> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos))
			return null;

		return datos.get(0);
	}
}
