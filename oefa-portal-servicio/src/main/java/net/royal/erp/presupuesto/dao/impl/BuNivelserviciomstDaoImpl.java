package net.royal.erp.presupuesto.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.presupuesto.dao.BuNivelserviciomstDao;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomstPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.presupuesto.dao.BuNivelserviciomstDao;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomstPk;

@Repository
public class BuNivelserviciomstDaoImpl extends
		GenericoDaoImpl<BuNivelserviciomst, BuNivelserviciomstPk> implements
		BuNivelserviciomstDao {

	private static Log LOGGER = LogFactory.getLog(BuNivelserviciomst.class);

	public BuNivelserviciomstDaoImpl() {
		super("bunivelserviciomst");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<BuNivelserviciomst> listarNivelServiciomst(String companiasocio) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiasocio", companiasocio));
		cri.add(Restrictions.eq("tiposervicio", "RH"));

		List<BuNivelserviciomst> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
	}

	@Override
	public String readReferenciaFiscalNS(String par_ano, String par_tipo,
			String par_valor, String par_nivel, String gv_version,
			String gv_companyowner) {
		Integer w_data;
		String w_work;

		w_data = Integer.parseInt(par_valor);

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiasocio", gv_companyowner));
		cri.add(Restrictions.eq("pk.nivelservicio", w_data));

		List<BuNivelserviciomst> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		w_work = datos.get(0).getDescripcion();

		return w_work;
	}

	public String obtenerDescripcion(String par_compania, Integer par_nivel) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiasocio", par_compania));
		cri.add(Restrictions.eq("tiposervicio", "RH"));
		cri.add(Restrictions.eq("pk.nivelservicio", par_nivel));

		List<BuNivelserviciomst> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos.get(0).getDescripcion();
	}

	@Override
	public List<BuNivelserviciomst> listarNivelporFiltos(String companiasocio,
			Integer[] object) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiasocio", companiasocio));
		cri.add(Restrictions.eq("tiposervicio", "RH"));
		cri.add(Restrictions.in("pk.nivelservicio", object));
		cri.addOrder(Order.asc("descripcion"));
		
		List<BuNivelserviciomst> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
		
	
	}

}
