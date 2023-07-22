package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrPosRequerDao;
import net.royal.erp.rrhh.dominio.HrPosRequer;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientopostEdit;
import net.royal.erp.rrhh.servicio.HrPosRequerServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrPosRequer")
public class HrPosRequerServicioImpl extends GenericoServicioImpl implements HrPosRequerServicio {

	private HrPosRequerDao dao;

	@Autowired
	@Qualifier("hrPosRequerDaoImpl")
	public void setDao(HrPosRequerDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerCantidadPostulantes(String requerimiento, String compania) {
		Integer ildia = null;
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));
		cri.add(Restrictions.eq("pk.companyowner", compania));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.rowCount());

		cri.setProjection(proj);

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return 0;
		else {
			if (lista.get(0) instanceof Long) {
				ildia = ((Long) lista.get(0)).intValue();
			} else if (lista.get(0) instanceof Integer) {
				ildia = (Integer) lista.get(0);
			}
		}

		return ildia;

	}

	@Override
	public Integer obtenerRequerimiento(String requerimiento, String compania) {
		HrPosRequer bean = new HrPosRequer();

		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));
		cri.add(Restrictions.eq("pk.companyowner", compania));

		List lista = cri.list();

		if (!UValidador.esListaVacia(lista)) {
			bean = (HrPosRequer) lista.get(0);
		}

		return bean.getSecuencia();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoDwHrRequerimientopostEdit> listaPostulantesCandidatos(String companyowner, String requerimiento,
			Integer codigopuesto, String validacion1) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("par_codigopuesto", Integer.class, codigopuesto));
		parametros.add(new ParametroPersistenciaGenerico("par_validacion1", String.class, validacion1));

		return (List) dao.listarPorQuery(DtoDwHrRequerimientopostEdit.class, "hrposrequer.dwhrrequerimientopostedit",
				parametros);
	}

	@Override
	public Integer obtenerEtapaActual(String requerimiento, String commpanyowner) {
		return dao.obtenerEtapaActual(requerimiento, commpanyowner);
	}

}
