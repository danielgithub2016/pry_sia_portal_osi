package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrPuestocursosDao;
import net.royal.erp.rrhh.dominio.HrPuestocursos;
import net.royal.erp.rrhh.dominio.HrPuestocursosPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrPuestocursosDaoImpl extends
		GenericoDaoImpl<HrPuestocursos, HrPuestocursosPk> implements
		HrPuestocursosDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestocursos.class);

	public HrPuestocursosDaoImpl() {
		super("hrpuestocursos");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestocursos> listarTabOtrosEstudios(Integer codigopuesto) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestocursos> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		for (HrPuestocursos x : datos) {

			if (UValidador.esNulo(x))
				return null;
			
			
			if (UValidador.esNulo(x.getGradocuantitativo()))
				return null;
	

				switch (x.getGradocuantitativo()) {

				case "01":
					x.setDescripciongradocuantitativo("Grado I");
					break;

				case "02":
					x.setDescripciongradocuantitativo("Grado II");
					break;

				case "03":
					x.setDescripciongradocuantitativo("Grado III");
					break;

				case "04":
					x.setDescripciongradocuantitativo("Grado IV");
					break;

				case "05":
					x.setDescripciongradocuantitativo("Grado V");
					break;
				default:
					break;
				
			}
			
		}

		return datos;
	}

}
