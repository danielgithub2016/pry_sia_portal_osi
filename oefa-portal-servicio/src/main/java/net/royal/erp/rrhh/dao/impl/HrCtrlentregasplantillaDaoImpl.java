package net.royal.erp.rrhh.dao.impl;

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
import net.royal.erp.rrhh.dao.HrCtrlentregasplantillaDao;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantilla;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantillaPk;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;

@Repository
public class HrCtrlentregasplantillaDaoImpl extends
		GenericoDaoImpl<HrCtrlentregasplantilla, HrCtrlentregasplantillaPk>
		implements HrCtrlentregasplantillaDao {

	private static Log LOGGER = LogFactory
			.getLog(HrCtrlentregasplantilla.class);

	public HrCtrlentregasplantillaDaoImpl() {
		super("hrctrlentregasplantilla");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public HrCtrlentregasplantilla obtenerplantillaparam(String plantilla) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.plantilla", plantilla));

		List<HrCtrlentregasplantilla> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos))
			return null;

		return datos.get(0);
	}

}
