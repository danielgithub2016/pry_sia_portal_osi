package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEmpleadocapaDocumentoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumentoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

/**
 * The Class HrEmpleadocapaDocumentoImpl.
 */
@Repository
public class HrEmpleadocapaDocumentoDaoImpl extends GenericoDaoImpl<HrEmpleadocapaDocumento, HrEmpleadocapaDocumentoPk>
		implements HrEmpleadocapaDocumentoDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HrEmpleadocapaDocumentoDaoImpl() {
		super("hrempleadocapadocumento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer generarSecuencia(String capacitacion, Integer empleado) {
		return this.incrementarInteger(this.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.capacitacion", capacitacion),
						Restrictions.eq("pk.empleado", empleado)))
				.setProjection(Projections.projectionList().add(Projections.max("pk.secuencia"))));
	}
}
