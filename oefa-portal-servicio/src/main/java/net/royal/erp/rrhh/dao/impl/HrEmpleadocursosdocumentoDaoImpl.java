package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEmpleadocursosdocumentoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumentoPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrEmpleadocursosdocumentoDaoImpl
		extends GenericoDaoImpl<HrEmpleadocursosdocumento, HrEmpleadocursosdocumentoPk>
		implements HrEmpleadocursosdocumentoDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadocursosdocumento.class);

	public HrEmpleadocursosdocumentoDaoImpl() {
		super("hrempleadocursosdocumento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadocursosdocumento> listarPorEmpleadoSecuencia(Integer empleado, String capacitacion, String flgMaterial) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.capacitacion", capacitacion));

		if (!UValidador.esNulo(empleado))
			cri.add(Restrictions.eq("pk.empleado", empleado));

		if (!UValidador.esNulo(flgMaterial))
			cri.add(Restrictions.eq("flagcompartirmaterial", flgMaterial));

		return this.listarPorCriterios(cri);
	}

	@Override
	public Integer incrementarDocumento(Integer empleado, Integer secuencia,String capacitacion) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.capacitacion", capacitacion));
		
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.documento"));
		cri.setProjection(proj);
		Integer documento = this.incrementarInteger(cri);
		
		return documento;
	}
	
	@Override
	public Integer incrementarDocumenoSecuencia(Integer empleado, String capacitacion) {
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.capacitacion", capacitacion));
		
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));
		cri.setProjection(proj);
		Integer secuencia = this.incrementarInteger(cri);
		
		return secuencia;
		
		
	}

	@Override
	public Integer contarNombreIgual(Integer empleado, String nombre,String capacitacion) {
		List lista = this.getCriteria().add(Restrictions.and(Restrictions.eq("nombrearchivo", nombre),
				Restrictions.eq("pk.empleado", empleado), Restrictions.eq("pk.capacitacion", capacitacion))).list();
		return UValidador.esListaVacia(lista) ? 0 : lista.size();
	}

}
