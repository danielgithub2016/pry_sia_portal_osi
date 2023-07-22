package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadocursosdocumentoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumento;
import net.royal.erp.rrhh.servicio.HrEmpleadocursosdocumentoServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEmpleadocursosdocumento")
public class HrEmpleadocursosdocumentoServicioImpl extends GenericoServicioImpl
		implements HrEmpleadocursosdocumentoServicio {

	private HrEmpleadocursosdocumentoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEmpleadocursosdocumentoServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadocursosdocumentoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrEmpleadocursosdocumento> listarPorEmpleadoSecuencia(Integer empleado, String capacitacion, String flgMaterial) {
		return dao.listarPorEmpleadoSecuencia(empleado, capacitacion, flgMaterial);
	}

	@Override
	public Integer incrementarDocumento(Integer empleado, Integer secuencia,String capacitacion) {
		return dao.incrementarDocumento(empleado, secuencia, capacitacion);
	}
	
	

	@Override
	public Integer contarNombreIgual(Integer empleado, String nombre,String capacitacion) {
		return dao.contarNombreIgual(empleado,nombre, capacitacion);
	}

	@Override
	public Integer obtenerCantDocumentos(Integer empleado, String capacitacion, String informeFinal) {
		Integer ildia = 0;
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.capacitacion", capacitacion));
		cri.add(Restrictions.eq("pk.empleado", empleado));

		if (!UValidador.esNulo(informeFinal)) {
			cri.add(Restrictions.eq("flgAdjuntoInformFinal", informeFinal));
		}

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.rowCount());

		cri.setProjection(proj);

		List lista = dao.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista)) {
			return 0;
		} else {
			if (lista.get(0) instanceof Long) {
				ildia = ((Long) lista.get(0)).intValue();
			} else if (lista.get(0) instanceof Integer) {
				ildia = (Integer) lista.get(0);
			}
		}

		

		return ildia;
	}

	@Override
	public Integer incrementarDocumenoSecuencia(Integer empleado, String capacitacion) {
		return dao.incrementarDocumenoSecuencia(empleado, capacitacion);
	}

}
