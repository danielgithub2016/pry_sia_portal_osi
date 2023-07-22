package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dao.TipocambiomastDao;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.Tipocambiomast;
import net.royal.erp.core.dominio.TipocambiomastPk;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.MensajeUsuario.tipo_mensaje;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TipocambiomastDaoImpl extends
		GenericoDaoImpl<Tipocambiomast, TipocambiomastPk> implements
		TipocambiomastDao {

	private static Log LOGGER = LogFactory.getLog(Tipocambiomast.class);

	private ParametrosmastDao daoParametrosmast;
	private ComunDao daoComun;

	public TipocambiomastDaoImpl() {
		super("tipocambiomast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Autowired
	public void setDaoParametrosmast(ParametrosmastDao daoParametrosmast) {
		this.daoParametrosmast = daoParametrosmast;
	}

	@Autowired
	public void setDaoComun(ComunDao daoComun) {
		this.daoComun = daoComun;
	}

}
