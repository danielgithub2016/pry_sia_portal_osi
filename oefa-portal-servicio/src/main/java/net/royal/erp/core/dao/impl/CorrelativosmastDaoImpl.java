package net.royal.erp.core.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.CorrelativosmastDao;
import net.royal.erp.core.dominio.Correlativosmast;
import net.royal.erp.core.dominio.CorrelativosmastPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.UsuarioActual;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CorrelativosmastDaoImpl extends
		GenericoDaoImpl<Correlativosmast, CorrelativosmastPk> implements
		CorrelativosmastDao {

	private static Log LOGGER = LogFactory.getLog(Correlativosmast.class);

	public CorrelativosmastDaoImpl() {
		super("correlativosmast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer incrementarNuevoCorrelativo(String companiacodigo,
			String tipocomprobante, String serie, UsuarioActual usuarioActual) {
		Integer correlativonumero = null;
		Correlativosmast corr = null;

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiacodigo", companiacodigo));
		cri.add(Restrictions.eq("pk.tipocomprobante", tipocomprobante));
		cri.add(Restrictions.eq("pk.serie", serie));
		List<Correlativosmast> result = this.listarPorCriterios(cri);
		if (result.size() == 0) {
			corr = new Correlativosmast();
			corr.getPk().setCompaniacodigo(companiacodigo);
			corr.getPk().setSerie(serie);
			corr.getPk().setTipocomprobante(tipocomprobante);
			corr.setCorrelativonumero(1);
			corr.setCorrelativodesde(0);
			corr.setCorrelativohasta(0);
			corr.setEstado("A");
			this.registrar(corr);
			correlativonumero = 1;
		} else {
			corr=result.get(0);
			correlativonumero = corr.getCorrelativonumero();
			correlativonumero++;
			corr.setCorrelativonumero(correlativonumero);
			corr.setFechaModificacion(new Date());
			this.actualizar(corr);
		}

		return correlativonumero;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder whmenu.f_sql_get_requisition_number
	 */
	@Override
	public String incrementarNuevoCorrelativoCadena(String companiacodigo,
			String tipocomprobante, String serie, Integer cerosIzquierda,
			UsuarioActual usuarioActual) {
		String retorno = null;
		
		Integer contador = this.incrementarNuevoCorrelativo(companiacodigo,
				tipocomprobante, serie, usuarioActual);
		
		retorno = "000000000000000000000000" + contador.toString();
		
		retorno = retorno.substring(retorno.length()-cerosIzquierda, retorno.length());
		
		return retorno;
	}

}
