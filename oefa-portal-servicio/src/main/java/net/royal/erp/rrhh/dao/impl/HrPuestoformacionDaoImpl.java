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
import net.royal.erp.rrhh.dao.HrGradoinstruccionDao;
import net.royal.erp.rrhh.dao.HrProfesionDao;
import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dao.HrPuestoformacionDao;
import net.royal.erp.rrhh.dominio.HrGradoinstruccion;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPuestoformacion;
import net.royal.erp.rrhh.dominio.HrPuestoformacionPk;

@Repository
public class HrPuestoformacionDaoImpl extends
		GenericoDaoImpl<HrPuestoformacion, HrPuestoformacionPk> implements
		HrPuestoformacionDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoformacion.class);
	private HrGradoinstruccionDao dao;
	private HrProfesionDao dao2;

	@Autowired
	public void setDaoPuestoEmpresa(HrGradoinstruccionDao dao,
			HrProfesionDao dao2) {
		this.dao = dao;
		this.dao2 = dao2;
	}

	public HrPuestoformacionDaoImpl() {
		super("hrpuestoformacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoformacion> listarPuestoFormacion(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoformacion> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		List<HrGradoinstruccion> list = dao.listarTodos();

		for (HrPuestoformacion x : datos) {
			for (HrGradoinstruccion a : list) {
				if (x.getNivelacademico().equals(
						a.getPk().getGradoinstruccion())) {
					x.setAuxNivelAcademico(a.getDescripcion());
				}
				if (!UValidador.estaVacio(x.getProfesion())) {
					LOGGER.debug("profesion :: " + x.getProfesion().trim());
					x.setAuxFuncion(dao2.obtenerProfesion(x.getProfesion().trim()).getDescripcion());
				}
			}

		}
		return datos;
	}

}
