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
import net.royal.erp.rrhh.dao.HrIdiomasmastDao;
import net.royal.erp.rrhh.dao.HrPuestoinformaticaDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoinformatica;
import net.royal.erp.rrhh.dominio.HrPuestoinformaticaPk;

@Repository
public class HrPuestoinformaticaDaoImpl extends
		GenericoDaoImpl<HrPuestoinformatica, HrPuestoinformaticaPk> implements
		HrPuestoinformaticaDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoinformatica.class);
	private MaMiscelaneosdetalleDao daoMa;

	@Autowired
	public void setDaoMa(MaMiscelaneosdetalleDao daoMa,
			HrIdiomasmastDao daoIdioma) {
		this.daoMa = daoMa;
	}

	public HrPuestoinformaticaDaoImpl() {
		super("hrpuestoinformatica");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoinformatica> listarPuestosInformaticas(
			Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoinformatica> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		Criteria cr = daoMa.getCriteria();
		cr.add(Restrictions.eq("pk.codigotabla", "NIVELIDIOM"));
		cr.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		cr.add(Restrictions.eq("pk.compania", "999999"));

		List<MaMiscelaneosdetalle> list = daoMa.listarPorCriterios(cr);

		Criteria ct = daoMa.getCriteria();
		ct.add(Restrictions.eq("pk.codigotabla", "INFORMAT"));
		ct.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		ct.add(Restrictions.eq("pk.compania", "999999"));

		List<MaMiscelaneosdetalle> lost = daoMa.listarPorCriterios(ct);

		for (HrPuestoinformatica x : datos) {
			if (!UValidador.esNulo(x.getPk())) {
				for (MaMiscelaneosdetalle a : list) {

					if (x.getNivel().equals(a.getPk().getCodigoelemento())) {
						x.setAuxNivel(a.getDescripcionlocal());
					}
				}
				for (MaMiscelaneosdetalle q : lost) {
					if (x.getPk().getInformatica()
							.equals(q.getPk().getCodigoelemento())) {
						x.setAuxInformatica(q.getDescripcionlocal());
					}
				}

			}
		}
		return datos;
	}

}
