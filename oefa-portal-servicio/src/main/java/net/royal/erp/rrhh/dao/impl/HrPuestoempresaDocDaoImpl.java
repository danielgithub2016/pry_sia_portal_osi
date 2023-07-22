package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrPuestoempresaDocDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDoc;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDocPk;

@Repository
public class HrPuestoempresaDocDaoImpl extends GenericoDaoImpl<HrPuestoempresaDoc, HrPuestoempresaDocPk> implements HrPuestoempresaDocDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoempresaDoc.class);

	public HrPuestoempresaDocDaoImpl() {
		super("hrpuestoempresadoc");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoempresaDoc> listarTabFormatosEvaluacion(
			Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoempresaDoc> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
	}

}
