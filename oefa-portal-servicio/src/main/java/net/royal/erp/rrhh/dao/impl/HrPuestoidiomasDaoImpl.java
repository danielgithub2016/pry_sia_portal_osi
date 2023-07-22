package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.dao.HrIdiomasmastDao;
import net.royal.erp.rrhh.dao.HrPuestoidiomasDao;
import net.royal.erp.rrhh.dominio.HrIdiomasmast;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;
import net.royal.erp.rrhh.dominio.HrPuestoidiomasPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HrPuestoidiomasDaoImpl extends
		GenericoDaoImpl<HrPuestoidiomas, HrPuestoidiomasPk> implements
		HrPuestoidiomasDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoidiomas.class);
	private MaMiscelaneosdetalleDao daoMa;
	private HrIdiomasmastDao daoIdioma;

	@Autowired
	public void setDaoMa(MaMiscelaneosdetalleDao daoMa,HrIdiomasmastDao daoIdioma) {
		this.daoMa = daoMa;
		this.daoIdioma = daoIdioma;
	}

	public HrPuestoidiomasDaoImpl() {
		super("hrpuestoidiomas");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoidiomas> listarPuestoidiomas(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoidiomas> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		Criteria cr = daoMa.getCriteria();
		cr.add(Restrictions.eq("pk.codigotabla", "NIVELIDIOM"));
		cr.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		cr.add(Restrictions.eq("pk.compania", "999999"));

		List<MaMiscelaneosdetalle> lis = daoMa.listarPorCriterios(cr);

		List<HrIdiomasmast> idioma = daoIdioma.listarTodos();
		for (HrPuestoidiomas x : datos) {
			if (!UValidador.esNulo(x.getPk())) {
				for (MaMiscelaneosdetalle a : lis) {
					if (x.getNivellectura().equals(
							a.getPk().getCodigoelemento())) {
						x.setNivellectura(a.getDescripcionlocal());
					}
					if (x.getNiveloral().equals(a.getPk().getCodigoelemento())) {
						x.setNiveloral(a.getDescripcionlocal());
					}
					if (x.getNivelescritura().equals(
							a.getPk().getCodigoelemento())) {
						x.setNivelescritura(a.getDescripcionlocal());
					}
					if (x.getNivelgeneral().equals(
							a.getPk().getCodigoelemento())) {
						x.setNivelgeneral(a.getDescripcionlocal());
					}
				}
				for (HrIdiomasmast i : idioma) {
					if(x.getPk().getIdioma().equals(i.getPk().getIdioma())){
						x.setAuxIdioma(i.getDescripcionlocal());
					}
				}
			}
		}
		return datos;
	}

}
