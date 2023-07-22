package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.SeguridadconceptoDao;
import net.royal.seguridad.dao.SeguridadgrupoDao;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.dominio.SeguridadconceptoPk;
import net.royal.seguridad.dominio.Seguridadconceptodetalle;
import net.royal.seguridad.dominio.Seguridadgrupo;
import net.royal.seguridad.dominio.SeguridadgrupoPk;
import net.royal.seguridad.dominio.dto.DtoMenuNavegacion;
import net.royal.seguridad.dominio.dto.DtoSeguridadconcepto;
import net.royal.seguridad.dominio.dto.DtoSeguridadconceptodetalle;
import net.royal.seguridad.servicio.SeguridadconceptoServicio;

@Service(value = "BeanServicioSeguridadconceptoSeguridad")
public class SeguridadconceptoServicioImpl extends GenericoServicioImpl implements SeguridadconceptoServicio {

	private SeguridadconceptoDao dao;
	private SeguridadgrupoDao seguridadgrupoDao;
	private SeguridadconceptoDao seguridadconceptoDao;

	private static Log LOGGER = LogFactory.getLog(SeguridadconceptoServicioImpl.class);

	@Autowired
	@Qualifier("seguridadconceptoDaoImplSeguridad")
	public void setDao(SeguridadconceptoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	@Qualifier("seguridadgrupoDaoImplSeguridad")
	public void setSeguridadgrupoDao(SeguridadgrupoDao seguridadgrupoDao) {
		this.seguridadgrupoDao = seguridadgrupoDao;
	}

	@Autowired
	@Qualifier("seguridadconceptoDaoImplSeguridad")
	public void setSeguridadconceptoDao(SeguridadconceptoDao seguridadconceptoDao) {
		this.seguridadconceptoDao = seguridadconceptoDao;
	}

	public Seguridadconcepto buscarPorNombreObjeto(String nombreObjeto) {
		List<Seguridadconcepto> lstSeguridadConcepto = null;
		Seguridadconcepto retorno = null;

		Criteria criteria = dao.getCriteria();
		criteria.add(Restrictions.eq("objeto", nombreObjeto));
		lstSeguridadConcepto = (List<Seguridadconcepto>) dao.listarPorCriterios(criteria);

		if (lstSeguridadConcepto == null)
			return null;

		if (lstSeguridadConcepto.size() == 0)
			return null;

		if (lstSeguridadConcepto.size() > 1)
			return null;

		retorno = lstSeguridadConcepto.get(0);

		return retorno;
	}

	public Seguridadconcepto buscarPorNombreObjeto(String codigoAplicacion, String nombreObjeto) {
		List<Seguridadconcepto> lstSeguridadConcepto = null;
		Seguridadconcepto retorno = null;

		Criteria criteria = dao.getCriteria();
		criteria.add(Restrictions.eq("pk.aplicacioncodigo", codigoAplicacion));
		criteria.add(Restrictions.eq("objeto", nombreObjeto));
		lstSeguridadConcepto = (List<Seguridadconcepto>) dao.listarPorCriterios(criteria);

		if (lstSeguridadConcepto == null)
			lstSeguridadConcepto = new ArrayList<Seguridadconcepto>();

		// si encuentra el objeto en la primera busqueda lo devuelve
		if (lstSeguridadConcepto.size() == 1)
			return lstSeguridadConcepto.get(0);

		Criteria criteria2 = dao.getCriteria();
		criteria2.add(Restrictions.eq("pk.aplicacioncodigo", codigoAplicacion));
		criteria2.add(Restrictions.eq("objetowindow", nombreObjeto));
		lstSeguridadConcepto = (List<Seguridadconcepto>) dao.listarPorCriterios(criteria2);

		if (lstSeguridadConcepto == null)
			lstSeguridadConcepto = new ArrayList<Seguridadconcepto>();

		// si encuentra el objeto en la primera busqueda lo devuelve
		if (lstSeguridadConcepto.size() == 1)
			return lstSeguridadConcepto.get(0);

		return null;
	}

	@Override
	public List listarConceptoNavegacion(Class clazz, List<ParametroPersistenciaGenerico> parametros) {

		String aplicacion = null, grupo = null, concepto = null;
		LOGGER.debug("listarConceptoNavegacion");
		LOGGER.debug(parametros.get(0).getValue());
		LOGGER.debug(parametros.get(1).getValue());
		LOGGER.debug(parametros.get(2).getValue());

		if (!UValidador.estaVacio(parametros.get(0).getValue()))
			aplicacion = parametros.get(0).getValue().toString();

		if (!UValidador.estaVacio(parametros.get(1).getValue()))
			grupo = parametros.get(1).getValue().toString();

		if (!UValidador.estaVacio(parametros.get(2).getValue()))
			concepto = parametros.get(2).getValue().toString();

		Seguridadgrupo seguridadGrupo = null;
		Seguridadconcepto seguridadConcepto = null;
		List<DtoMenuNavegacion> data = new ArrayList<DtoMenuNavegacion>();

		seguridadGrupo = seguridadgrupoDao.obtenerPorId(new SeguridadgrupoPk(aplicacion, grupo));
		seguridadConcepto = seguridadconceptoDao.obtenerPorId(new SeguridadconceptoPk(aplicacion, grupo, concepto));

		LOGGER.debug(seguridadGrupo);
		LOGGER.debug(seguridadConcepto);

		if (seguridadGrupo != null)
			data.add(new DtoMenuNavegacion("GR", seguridadGrupo.getDescripcion()));

		if (seguridadConcepto != null)
			data.add(new DtoMenuNavegacion("CO", seguridadConcepto.getDescripcion()));

		return data;
	}

	@Override
	public List<Seguridadconcepto> ListarentreConceptos(String aplicacioncodigo, String grupo, String concepto_desde,
			String concepto_hasta) {

		return dao.ListarentreConceptos(aplicacioncodigo, grupo, concepto_desde, concepto_hasta);
	}

	public Date obtenerfechahora() {
		List data;
		Date fecha = null;
		data = dao.listarPorQuery(DtoSeguridadconcepto.class, "seguridad.seguridadconcepto.obtenerfechaservidor");
		if (!UValidador.esListaVacia(data)) {
			fecha = ((List<DtoSeguridadconcepto>) data).get(0).getUltimafechamodif();
		}

		return fecha;

	}
}
