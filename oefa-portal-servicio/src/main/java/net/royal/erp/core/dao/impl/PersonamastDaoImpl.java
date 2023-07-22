package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dominio.dto.DtoDwMaCpEmpleadoautorizadoSelect;
import net.royal.erp.core.dao.PersonamastDao;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PersonamastDaoImpl extends
		GenericoDaoImpl<Personamast, PersonamastPk> implements PersonamastDao {

	private static Log LOGGER = LogFactory.getLog(Personamast.class);

	public PersonamastDaoImpl() {
		super("personamast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Personamast obtenerporPersona(Integer persona) {

		List<Personamast> lista = this.listarPorCriterios(this.getCriteria()
				.add(Restrictions.eq("pk.persona", persona)));

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);

	}

	public Personamast obtenerporPersonaAnt(String personaAnt) {
		List<Personamast> lista = this.listarPorCriterios(this.getCriteria()
				.add(Restrictions.eq("personaant", personaAnt)));

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);
	}

	@Override
	public String obtenerNombrePersona(BigDecimal codigoPersona) {
		Integer intPersona = 0;
		String strpersona = "";
		if (!UValidador.esNulo(codigoPersona)) {
			intPersona = codigoPersona.intValue();

			Personamast persona = obtenerporPersona(intPersona);

			if (!UValidador.esNulo(persona)) {
				if (!UValidador.estaVacio(persona.getBusqueda())) {
					strpersona = persona.getBusqueda();
				} else {
					strpersona = persona.getNombrecompleto();
				}
			}
		}
		return strpersona;
	}

	@Override
	public Integer obtenerPersonaxRUC(String  par_documentoFiscal) {
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.or(
				Restrictions.eq("documentofiscal", par_documentoFiscal),
				Restrictions.eq("documento", par_documentoFiscal)))
				.setProjection(
				Projections.projectionList().add(
					Projections.max("pk.persona")));
		
		List lista=this.listarPorCriterios(cri);
		
      if(!UValidador.esListaVacia(lista))
    	  return (Integer) lista.get(0);
    			  
	return null;
	}

	@Override
	public List obtenerEmpleadosAutorizados() {
		List datos = this.listarPorQuery(
				DtoDwMaCpEmpleadoautorizadoSelect.class,
				"personamast.empleadoAutorizados");
		
		return datos;
	}

	@Override
	public Personamast obtenerPersonaxUnidadNegocio() {
		
		return null;
	}
}