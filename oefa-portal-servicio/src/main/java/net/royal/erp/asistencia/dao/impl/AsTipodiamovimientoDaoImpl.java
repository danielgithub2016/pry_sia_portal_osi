package net.royal.erp.asistencia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsTipodiamovimientoDao;
import net.royal.erp.asistencia.dominio.AsTipodiamovimiento;
import net.royal.erp.asistencia.dominio.AsTipodiamovimientoPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AsTipodiamovimientoDaoImpl extends
		GenericoDaoImpl<AsTipodiamovimiento, AsTipodiamovimientoPk> implements
		AsTipodiamovimientoDao {

	private static Log LOGGER = LogFactory.getLog(AsTipodiamovimiento.class);

	public AsTipodiamovimientoDaoImpl() {
		super("astipodiamovimiento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public AsTipodiamovimiento obtenerPorTipoDiaMinimo(String tipodia) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.tipodia", tipodia));
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.min("pk.secuencia"));
		cri.setProjection(proj);
		Integer secuencia = this.incrementarInteger(cri);

		Criteria cri2 = this.getCriteria();
		cri2.add(Restrictions.eq("pk.tipodia", tipodia));
		cri2.add(Restrictions.eq("pk.secuencia", secuencia));
		List result = cri2.list();

		if (result.size() != 1)
			return null;

		return (AsTipodiamovimiento) result.get(0);
	}

	@Override
	public AsTipodiamovimiento obtenerPorTipoDiaMaximo(String tipodia) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.tipodia", tipodia));
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));
		cri.setProjection(proj);
		Integer secuencia = this.incrementarInteger(cri);

		Criteria cri2 = this.getCriteria();
		cri2.add(Restrictions.eq("pk.tipodia", tipodia));
		cri2.add(Restrictions.eq("pk.secuencia", secuencia));
		List result = cri2.list();

		if (result.size() != 1)
			return null;

		return (AsTipodiamovimiento) result.get(0);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String obtenerMaxIntervaloAccesoPorTipoDia(Integer tipoDia) {
		List lista = this
				.getCriteria()
				.add(Restrictions.eq("pk.tipodia", tipoDia))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("pk.intervaloacceso"))).list();
		if(UValidador.esListaVacia(lista))
			return null;
		
		return (String) lista.get(0);
	}
}
