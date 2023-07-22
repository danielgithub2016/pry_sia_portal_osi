package net.royal.seguridad.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.seguridad.dao.SeguridadconceptoDao;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.dominio.SeguridadconceptoPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("seguridadconceptoDaoImplSeguridad")
public class SeguridadconceptoDaoImpl extends
		GenericoDaoImpl<Seguridadconcepto, SeguridadconceptoPk> implements
		SeguridadconceptoDao {

	private static Log LOGGER = LogFactory.getLog(Seguridadconcepto.class);

	public SeguridadconceptoDaoImpl() {
		super("seguridad.seguridadconcepto");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	// LISTADO
	@Override
	public List<Seguridadconcepto> ListarentreConceptos(
			String aplicacioncodigo, String grupo, String concepto_desde,
			String concepto_hasta) {

		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.aplicacioncodigo", aplicacioncodigo));
		cri.add(Restrictions.eq("pk.grupo", grupo));
		cri.add(Restrictions.ge("pk.concepto", concepto_desde));
		cri.add(Restrictions.lt("pk.concepto", concepto_hasta));

		List result = this.listarPorCriterios(cri);

		return result;
	}

	@Override
	public List<Seguridadconcepto> listarConceptosPermitidosPorUsuario(
			String usuario) {
		List<ParametroPersistenciaGenerico> parameters = new ArrayList<ParametroPersistenciaGenerico>();
		List<Seguridadconcepto> listaConceptos = new ArrayList<Seguridadconcepto>();
		parameters.add(new ParametroPersistenciaGenerico("p_usuario",
				String.class, usuario));

		List result = this
				.listarPorQuery(
						SeguridadconceptoPk.class,
						"seguridad.seguridadconcepto.listarConceptosPermitidosPorUsuario",
						parameters);
		for (Object object : result) {
			Seguridadconcepto con;
			con = this.obtenerPorId((SeguridadconceptoPk) object, false);
			listaConceptos.add(con);
		}
		return listaConceptos;
	}

}
