package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dao.PersonamastDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.erp.rrhh.dao.HrPostulantesDao;
import net.royal.erp.rrhh.dominio.HrPostulantes;
import net.royal.erp.rrhh.servicio.HrPostulantesServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import pe.gob.oefa.interoperabilidad.ws.reniec.service.Reniec;
import pe.gob.oefa.interoperabilidad.ws.reniec.service.ReniecImplServiceLocator;
import pe.gob.oefa.interoperabilidad.ws.reniec.service.ResultadoConsulta;

@Service(value = "BeanServicioHrPostulantes")
public class HrPostulantesServicioImpl extends GenericoServicioImpl implements HrPostulantesServicio {

	private HrPostulantesDao dao;
	private PersonamastDao daoPersona;
	private MaMiscelaneosdetalleDao daoMiscelaneos;

	private static Log LOGGER = LogFactory.getLog(HrPostulantesServicioImpl.class);

	ReniecImplServiceLocator serviceLocator = null;
	Reniec port = null;
	ResultadoConsulta resultadoConsulta = null;
	pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionConsulta peticionConsulta = null;

	@Autowired
	@Qualifier("hrPostulantesDaoImpl")
	public void setDao(HrPostulantesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setMaMiscelaneosdetalleDao(MaMiscelaneosdetalleDao daoMiscelaneos) {
		this.daoMiscelaneos = daoMiscelaneos;
	}

	@Autowired
	public void setDaoPersona(PersonamastDao daoPersona) {
		this.daoPersona = daoPersona;
	}

	@Override
	public String obtenerNombrePostulante(String postulante) {
		String retorno = null;
		if (postulante.substring(0, 4).equals("INTE")) {
			String emp = postulante.substring(4, 6);
			if (NumberUtils.isNumber(emp.trim())) {
				PersonamastPk pk = new PersonamastPk(Integer.parseInt(emp.trim()));
				Personamast p = daoPersona.obtenerPorId(pk, false);
				retorno = p.getNombrecompleto();
			}
		} else {
			List<HrPostulantes> posts = dao
					.listarPorCriterios(dao.getCriteria().add(Restrictions.eq("pk.postulante", postulante)));
			if (!UValidador.esListaVacia(posts)) {
				HrPostulantes pos = posts.get(0);
				retorno = pos.getApellidopaterno() + " " + pos.getApellidomaterno() + " " + pos.getNombres();
			}
		}
		return retorno;
	}

	@Override
	public HrPostulantes obtenerInformacionReniec(HrPostulantes hrPostulantes) {
		// TODO Auto-generated method stub
		ReniecImplServiceLocator serviceLocator = null;
		Reniec port = null;
		ResultadoConsulta resultadoConsulta = null;
		pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionConsulta peticionConsulta = null;
		// DtoUbigeoEmpleado departamento;
		// DtoUbigeoEmpleado provincia = null;
		// DtoUbigeoEmpleado distrito;

		Criteria c = daoMiscelaneos.getCriteria();
		c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));

		List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

		if (!UValidador.esListaVacia(detalle)) {

			for (MaMiscelaneosdetalle documento : detalle) {
				try {
					serviceLocator = new ReniecImplServiceLocator();
					port = serviceLocator.getReniecImplPort();
					peticionConsulta = new pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionConsulta(
							hrPostulantes.getDocumento(), documento.getValorcodigo1(), null, null);
					resultadoConsulta = port.consultar(peticionConsulta, null, null, null);

					if (!UValidador.esNulo(resultadoConsulta)) {
						if (!UValidador.estaVacio(resultadoConsulta.getCoResultado())) {
							if ("1003".equals(resultadoConsulta.getCoResultado())) {
								continue;
							}
							if ("1002".equals(resultadoConsulta.getCoResultado())) {
								continue;
							}
							if ("0000".equals(resultadoConsulta.getCoResultado())) {
								hrPostulantes.setAuxerrorreniec(false);
								break;
							}
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
					hrPostulantes.setAuxerrorreniec(true);
					continue;
					// hrPostulantes.setAuxerrorreniec(true);
					// e.printStackTrace();
				}
			}
		}

		if (!UValidador.esNulo(resultadoConsulta)) {
			if (!UValidador.esNulo(resultadoConsulta.getDatosPersona())) {
				hrPostulantes.setApellidopaterno(resultadoConsulta.getDatosPersona().getApPrimer());
				hrPostulantes.setApellidomaterno(resultadoConsulta.getDatosPersona().getApSegundo());
				hrPostulantes.setNombres(resultadoConsulta.getDatosPersona().getPrenombres());
				hrPostulantes.setDireccion(resultadoConsulta.getDatosPersona().getDireccion());
				if (!UValidador.estaVacio(resultadoConsulta.getDatosPersona().getEstadoCivil())) {
					hrPostulantes.setEstadocivil(resultadoConsulta.getDatosPersona().getEstadoCivil().substring(0, 1));
				}
				hrPostulantes.setFoto(resultadoConsulta.getDatosPersona().getFoto());

				// // Obtenemos Departamento
				// departamento = departamentoDao.obtenerCodigoPorDescripcion(
				// UString.split(resultadoConsulta.getDatosPersona().getUbigeo(),
				// "/", 0));
				// if (!UValidador.esNulo(departamento)) {
				// hrPostulantes.setDepartamento(departamento.getIdDepartamento());
				// }
				//
				// // Obtenemos Provincia
				// if (!UValidador.esNulo(departamento)) {
				// provincia =
				// provinciaDao.obtenerCodigoPorDescripcion(departamento.getIdDepartamento(),
				// UString.split(resultadoConsulta.getDatosPersona().getUbigeo(),
				// "/", 1));
				// if (!UValidador.esNulo(provincia)) {
				// hrPostulantes.setProvincia(provincia.getIdProvincia());
				// }
				// }
				//
				// // Obtenemos Distrito
				// if (!UValidador.esNulo(departamento) &&
				// !UValidador.esNulo(provincia)) {
				// distrito =
				// zonapostalDao.obtenerCodigoPorDescripcion(departamento.getIdDepartamento(),
				// provincia.getIdProvincia(),
				// UString.split(resultadoConsulta.getDatosPersona().getUbigeo(),
				// "/", 2));
				// if (!UValidador.esNulo(distrito)) {
				// hrPostulantes.setDistrito(distrito.getIdDistrito());
				// }
				// }

			}
		}

		return hrPostulantes;
	}

	@Override
	public HrPostulantes obtenerFotoReniec(String dniConsulta, String dniUsuario) {
		// TODO Auto-generated method stub
		HrPostulantes hrPostulantes = new HrPostulantes();

		try {
			if (UValidador.esNulo(serviceLocator)) {
				serviceLocator = new ReniecImplServiceLocator();
				port = serviceLocator.getReniecImplPort();
				peticionConsulta = new pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionConsulta();
			}

			peticionConsulta.setNuDniUsuario(dniUsuario);
			peticionConsulta.setNuDniConsulta(dniConsulta);

			resultadoConsulta = port.consultar(peticionConsulta, null, null, null);

			if (!UValidador.esNulo(resultadoConsulta)) {
				if (!UValidador.estaVacio(resultadoConsulta.getCoResultado())) {
					if ("1003".equals(resultadoConsulta.getCoResultado())) {
						hrPostulantes.setAuxerrorreniec(true);
					}
					if ("1002".equals(resultadoConsulta.getCoResultado())) {
						hrPostulantes.setAuxerrorreniec(true);
					}
					if ("0000".equals(resultadoConsulta.getCoResultado())) {
						hrPostulantes.setFoto(resultadoConsulta.getDatosPersona().getFoto());
						hrPostulantes.setAuxerrorreniec(false);
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			hrPostulantes.setAuxerrorreniec(true);
		}
		return hrPostulantes;
	}

	@Override
	public List<HrPostulantes> listar(HrPostulantes hrPostulantes) {
		// TODO Auto-generated method stub
		Criteria c = dao.getCriteria();
		if (!UValidador.estaVacio(hrPostulantes.getDocumento())) {
			c.add(Restrictions.eq("documento", hrPostulantes.getDocumento()));
		}
		if (!UValidador.estaVacio(hrPostulantes.getNombrecompleto())) {
			c.add(Restrictions.or(Restrictions.like("nombres", hrPostulantes.getNombrecompleto(), MatchMode.ANYWHERE),
					Restrictions.like("apellidopaterno", hrPostulantes.getNombrecompleto(), MatchMode.ANYWHERE),
					Restrictions.like("apellidomaterno", hrPostulantes.getNombrecompleto(), MatchMode.ANYWHERE)));
		}

		return dao.listarPorCriterios(c);
	}

	@Override
	public ParametroPaginacion listarPaginacion(ParametroPaginacion paginacion) {
		// TODO Auto-generated method stub

		StringBuilder query = new StringBuilder();
		StringBuilder queryContar = new StringBuilder();

		queryContar.append(dao.obtenerSentenciaSqlPorQuery("postulante.hrpostulantes.contarPaginacion"));

		if (!UValidador.estaVacio(paginacion.getParametro("p_documento").getValue().toString())) {
			query.append(" and DOCUMENTO = '" + paginacion.getParametro("p_documento").getValue() + "'");
			queryContar.append(" and DOCUMENTO = '" + paginacion.getParametro("p_documento").getValue() + "'");
		}
		if (!UValidador.estaVacio(paginacion.getParametro("p_nombre").getValue().toString())) {
			query.append(
					" and UPPER(nvl(NOMBRES,'') || ' ' || nvl(APELLIDOPATERNO,'') || ' ' || nvl(APELLIDOMATERNO,'')) like UPPER('%"
							+ paginacion.getParametro("p_nombre").getValue() + "%')");
			queryContar
					.append(" and UPPER(nvl(NOMBRES,'') || ' ' || nvl(APELLIDOPATERNO,'') || ' ' || nvl(APELLIDOMATERNO,'')) like UPPER('%"
							+ paginacion.getParametro("p_nombre").getValue() + "%')");
		}
		query.append(" order by postulante ");

		BigDecimal registrosEncontrados;
		List lstResultado;

		registrosEncontrados = dao.contarPorSentenciaSQL(queryContar);
		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), null,
				"postulante.hrpostulantes.listarPaginacion", paginacion.getClazz(), query.toString());

		paginacion.setRegistroEncontrados(registrosEncontrados.intValue());
		paginacion.setListaResultado(lstResultado);

		return paginacion;

	}

}
