package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dao.HrPuestoexperienciaDao;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoexperiencia;
import net.royal.erp.rrhh.dominio.HrPuestoexperienciaPk;

@Repository
public class HrPuestoexperienciaDaoImpl extends GenericoDaoImpl<HrPuestoexperiencia, HrPuestoexperienciaPk> implements HrPuestoexperienciaDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoexperiencia.class);
	private MaMiscelaneosdetalleDao dao1;
		
	@Autowired
	public void setDao1(MaMiscelaneosdetalleDao dao1) {
		this.dao1 = dao1;
	}

	public HrPuestoexperienciaDaoImpl() {
		super("hrpuestoexperiencia");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoexperiencia> listarPuestoExperienciaporCodigo(
			Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoexperiencia> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;
		Integer i=0;
		String[] areas = new String[100];
		
	
		for (HrPuestoexperiencia x : datos) {
			
			StringTokenizer st2 = new StringTokenizer(x.getPk().getAreaexperiencia(), ",");
			while (st2.hasMoreElements()) {
				i = i + 1;
				String token = st2.nextToken();
				Integer Max = token.length();
				areas[i] = token.substring(1, Max - 1);
			}
			
			x.setAuxFuncion(dao1.obtenerNombreMiscelaneo("HR", "999999", "AREAEXPER", areas));
		}
		return datos;
	}

}
