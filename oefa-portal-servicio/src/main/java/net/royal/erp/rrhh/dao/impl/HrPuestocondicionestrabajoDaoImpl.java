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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.dao.HrPuestocondicionestrabajoDao;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajo;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajoPk;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;

@Repository
public class HrPuestocondicionestrabajoDaoImpl
		extends
		GenericoDaoImpl<HrPuestocondicionestrabajo, HrPuestocondicionestrabajoPk>
		implements HrPuestocondicionestrabajoDao {

	private static Log LOGGER = LogFactory
			.getLog(HrPuestocondicionestrabajo.class);

	private MaMiscelaneosdetalleDao daoMa;

	@Autowired
	public void setDaoMa(MaMiscelaneosdetalleDao daoMa) {
		this.daoMa = daoMa;
	}

	public HrPuestocondicionestrabajoDaoImpl() {
		super("hrpuestocondicionestrabajo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestocondicionestrabajo> listarCondicionesTrabajo(
			Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestocondicionestrabajo> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		Criteria cr = daoMa.getCriteria();
		cr.add(Restrictions.eq("pk.codigotabla", "TIPOCOND"));
		cr.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		cr.add(Restrictions.eq("pk.compania", "999999"));

		List<MaMiscelaneosdetalle> lis = daoMa.listarPorCriterios(cr);

		if (UValidador.esListaVacia(lis)) {
			return null;
		}

		for (HrPuestocondicionestrabajo x : datos) {
			if (!UValidador.esNulo(x.getTipocondicion())) {
				for (MaMiscelaneosdetalle a : lis) {
					if (x.getTipocondicion().equals(a.getPk().getCodigoelemento())) {
						x.setAuxDescripcionlocal(a.getDescripcionlocal());
					}
				}
			}
		}

		return datos;

	}

}
