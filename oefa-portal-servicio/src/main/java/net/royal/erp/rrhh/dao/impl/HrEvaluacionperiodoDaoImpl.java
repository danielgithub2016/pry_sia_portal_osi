package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodoDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrEvaluacionperiodoDaoImpl extends
		GenericoDaoImpl<HrEvaluacionperiodo, HrEvaluacionperiodoPk> implements
		HrEvaluacionperiodoDao {

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionperiodo.class);

	public HrEvaluacionperiodoDaoImpl() {
		super("hrevaluacionperiodo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public StrPass FEvaluacionPeriodoCabecera(StrPass strpass) {
		HrEvaluacionperiodoPk pk = new HrEvaluacionperiodoPk();
		pk.setCompanyowner(strpass.getS()[1]);
		pk.setSecuenciaeval(strpass.getD()[1]);
		HrEvaluacionperiodo obj = this.obtenerPorId(pk,false);

		if (!UValidador.esNulo(obj)) {
			strpass.getS()[2] = obj.getPeriodo();
			strpass.getS()[3] = obj.getDescripcion();
			strpass.getS()[4] = obj.getEstadoproceso();
			strpass.getS()[5] = obj.getTipocodigo();
			strpass.getDt()[1] = obj.getFechainicio();
			strpass.getDt()[2] = obj.getFechafin();
			strpass.getDt()[3] = obj.getFechaevalinicio();
			strpass.getDt()[4] = obj.getFechaevalfin();
			strpass.getDt()[5] = obj.getFecharealinicio();
			strpass.getDt()[6] = obj.getFecharealfin();
		}

		return strpass;
	}

	@Override
	public HrEvaluacionperiodo ObtenerxSecuenciaeval(Integer secuenciaeval) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));

		List<HrEvaluacionperiodo> lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);
	}

	@Override
	public HrEvaluacionperiodo obtenerXSecuenciaEvalCompania(
			Integer secuenciaeval, String compania) {
		compania = UValidador.esNulo(compania)?null:compania.substring(0, 6);
		List<HrEvaluacionperiodo> lista = this.listarPorCriterios(this
				.getCriteria().add(
						Restrictions.and(Restrictions.eq("pk.secuenciaeval",
								secuenciaeval), Restrictions
								.sqlRestriction("substr( companyowner ,0,6) = "
										+ compania))));

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);
	}

	public List<HrEvaluacionperiodo> listarEvalPeriodoxCompania(
			String companiasocio) {
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiasocio", companiasocio));

		List<HrEvaluacionperiodo> lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		return lista;
	}
}
