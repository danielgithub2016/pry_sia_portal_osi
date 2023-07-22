package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrPlantillaevapotencialDao;
import net.royal.erp.rrhh.dominio.HrPlantillaevapotencial;
import net.royal.erp.rrhh.dominio.HrPlantillaevapotencialPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrPlantillaevapotencialDaoImpl extends GenericoDaoImpl<HrPlantillaevapotencial, HrPlantillaevapotencialPk> implements HrPlantillaevapotencialDao {

	private static Log LOGGER = LogFactory.getLog(HrPlantillaevapotencial.class);

	public HrPlantillaevapotencialDaoImpl() {
		super("hrplantillaevapotencial");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
	
	public List<HrPlantillaevapotencial> listarPlantillaPotencial(String par_plantilla){
		Criteria cri = this.getCriteria();
		
		cri.add(Restrictions.eq("pk.plantilla", par_plantilla));
		
		List datos = this.listarPorCriterios(cri);
		
		if(UValidador.esListaVacia(datos)){
			return null;
		}
		return datos;
	}

}
