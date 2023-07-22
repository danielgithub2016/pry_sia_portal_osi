package net.royal.seguridad.dao.impl;

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

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.seguridad.dao.SyPreferencesDao;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.dominio.SyPreferences;
import net.royal.seguridad.dominio.SyPreferencesPk;

@Repository("syPreferencesDaoImplSeguridad")
public class SyPreferencesDaoImpl extends GenericoDaoImpl<SyPreferences, SyPreferencesPk> implements SyPreferencesDao {

	private static Log LOGGER = LogFactory.getLog(SyPreferences.class);

	public SyPreferencesDaoImpl() {
		super("seguridad.sypreferences");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerValorString(String usuario, String preference) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.usuario", usuario));
		cri.add(Restrictions.eq("pk.preference", preference));
		List<SyPreferences> list = this
				.listarPorCriterios(cri);
		if (list==null)
			return null;
		if (list.size() !=1)
			return null;
		return list.get(0).getValorstring();
	}

}
