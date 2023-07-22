package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dao.impl.MaMiscelaneosdetalleDaoImpl;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.dao.HrPuestoriesgotrabajoDao;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajoPk;
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
public class HrPuestoriesgotrabajoDaoImpl extends GenericoDaoImpl<HrPuestoriesgotrabajo, HrPuestoriesgotrabajoPk> implements HrPuestoriesgotrabajoDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoriesgotrabajo.class);

	private MaMiscelaneosdetalleDao daoMa;
	
	@Autowired
	public void setDaoMa(MaMiscelaneosdetalleDao daoMa) {
		this.daoMa = daoMa;
	}

	
	public HrPuestoriesgotrabajoDaoImpl() {
		super("hrpuestoriesgotrabajo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoriesgotrabajo> listarRiesgosTrabajo(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoriesgotrabajo> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		MaMiscelaneosdetalle obj = new MaMiscelaneosdetalle();
		
		Criteria cr = daoMa.getCriteria();
		cr.add(Restrictions.eq("pk.codigotabla", "TIPORIESGO"));
		cr.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		cr.add(Restrictions.eq("pk.compania", "999999"));
		
		List<MaMiscelaneosdetalle> lis = daoMa.listarPorCriterios(cr);
		
		if(UValidador.esListaVacia(lis)){
			return null;
		}
		
		
		for (HrPuestoriesgotrabajo x : datos) {
			for (MaMiscelaneosdetalle a : lis) {
				if(!UValidador.esNulo(x.getTiporiesgo())){
					if(x.getTiporiesgo().equals(a.getPk().getCodigoelemento())){
						x.setAuxDescripcionlocal(a.getDescripcionlocal());
					}
				}
			}			
		}
		
		return datos;
	}

}
