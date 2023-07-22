package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.dao.HrEncuestaDao;
import net.royal.erp.rrhh.dominio.HrPostulantes;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCas;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPost;
import net.royal.erp.rrhh.dominio.dto.DtoHrEntrCasPostEval;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvalCas;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.rrhh.servicio.HrEncuestaServicio;
import net.royal.erp.rrhh.servicio.HrPostulantesServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrEncuesta")
public class HrEncuestaServicioImpl extends GenericoServicioImpl implements HrEncuestaServicio {

	private HrEncuestaDao dao;

	@Autowired
	private HrPostulantesServicio hrpostulanteServicio;

	@Autowired
	private MaMiscelaneosdetalleDao daoMiscelaneos;

	@Autowired
	public void setDao(HrEncuestaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DtoHrEncuesta> listarHrEncuesta(String estado, Date fecha, Integer sujeto) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEncuesta").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("estado", String.class, estado));
		parametros.add(new ParametroPersistenciaGenerico("sujeto", Integer.class, sujeto));

		if (!UValidador.esNulo(fecha)) {
			query.append(" AND SYSDATE  BETWEEN H.FECHAINICIO+0/24 AND H.FECHAFIN +23/24 ");

		}

		return (List) dao.listarPorSentenciaSQL(DtoHrEncuesta.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoTipoPlanilla> listaTipoPlanilla() {
		return (List) dao.listarPorQuery(DtoTipoPlanilla.class, "hrencuesta.listarTipoPlanilla");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> listarHrEvalCas() {
		return (List) dao.listarPorQuery(DtoHrEvalCas.class, "hrencuesta.listarHrEvalCas");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> listarHrEvalCas2(String convocatoria, String despuesto) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEvalCas2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_convocatoria", String.class, convocatoria));
		parametros.add(new ParametroPersistenciaGenerico("pid_puesto", String.class, despuesto));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> valCierreHrEvalCas(String evalcas) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.valCierreHrEvalCas").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> valInicioHrEvalCas(String evalcas) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.valInicioHrEvalCas").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void editarHrEvalCas(String requerimiento, String evalcas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		dao.ejecutarPorQuery("hrencuesta.editarHrEvalCas", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void finalizarHrEvalCas(String requerimiento, String evalcas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		dao.ejecutarPorQuery("hrencuesta.finalizarHrEvalCas", parametros);
	}

	@Override
	public DtoHrEntrCasPost datosPostulanteExamen(String id_evalcas, String postulante) {

		DtoHrEntrCasPost retorno = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.datosPostulanteExamen").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, id_evalcas));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		List lista = dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (!UValidador.esListaVacia(lista)) {
			retorno = (DtoHrEntrCasPost) lista.get(0);
		}

		return retorno;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPost> verPostulantesHrEvalCas(String id_evalcas, Boolean incluirFoto, Integer cantidad) {

		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteHrEvalCas").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, id_evalcas));
		List lista = dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (incluirFoto) {

			if (UValidador.esNulo(cantidad)) {
				cantidad = lista.size();
			}

			HrPostulantes hrPostulantes = new HrPostulantes();

			Criteria c = daoMiscelaneos.getCriteria();
			c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
			List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

			if (!UValidador.esListaVacia(lista)) {
				int cont = 1;
				for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
					if (!UValidador.esListaVacia(detalle)) {
						if (cont <= cantidad) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									cont = cont + 1;
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}

						} else {
							break;
						}
					}
				}
			}
		}
		return lista;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPost> verPostulantesHrEvalCas2(String id_evalcas, Boolean incluirFoto, Integer cantidad) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteHrEvalCas2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, id_evalcas));
		List lista = dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (incluirFoto) {

			if (UValidador.esNulo(cantidad)) {
				cantidad = lista.size();
			}

			HrPostulantes hrPostulantes = new HrPostulantes();

			Criteria c = daoMiscelaneos.getCriteria();
			c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
			List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

			if (!UValidador.esListaVacia(lista)) {
				int cont = 1;
				for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
					if (!UValidador.esListaVacia(detalle)) {
						if (cont <= cantidad) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									cont = cont + 1;
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}

						} else {
							break;
						}
					}
				}
			}
		}
		return lista;
	}

	@Override
	public List<DtoHrEntrCasPost> obtenerFotosPostulantes(List<DtoHrEntrCasPost> lista, Integer inicio, Integer fin) {

		HrPostulantes hrPostulantes = new HrPostulantes();

		Criteria c = daoMiscelaneos.getCriteria();
		c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
		List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

		if (!UValidador.esListaVacia(lista)) {
			int contador = 1;
			for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
				if (contador >= inicio && contador <= fin) {
					if (!UValidador.esListaVacia(detalle)) {
						if (UValidador.estaVacio(obj.getFotoPostulante())) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}
						}
					}
				} else {
					if (contador > fin) {
						break;
					}
				}
				contador++;
			}
		}
		return lista;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> datosProceso(String requerimiento) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.datosProceso").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCas> listarHrEntrCas(Integer sujeto) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEntrCas").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, sujeto));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPost> ingresarHrEntrCas(String requerimiento, String usuario) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.ingresarHrEntrCas").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> listarAsistencia() {
		return (List) dao.listarPorQuery(DtoHrEvalCas.class, "hrencuesta.listarAsistencia");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> listarPuntaje(String flagtipopuesto, String requerimiento) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_tipo_puesto", String.class, flagtipopuesto));
		return (List) dao.listarPorQuery(DtoHrEntrCasPostEval.class, "hrencuesta.listarPuntaje", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> listarPuntajeEscala(String flagtipopuesto, String requerimiento) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_tipo_puesto", String.class, flagtipopuesto));
		return (List) dao.listarPorQuery(DtoHrEntrCasPostEval.class, "hrencuesta.listarPuntajeEscala", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> listarAptitud(String requerimiento, String usuario, String postulante,
			String flagtipopuesto) {

		List<DtoHrEntrCasPostEval> lstAptitud = null;

		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarAptitud").getQueryString()
						+ System.lineSeparator());
		StringBuilder query2 = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarConducta").getQueryString()
						+ System.lineSeparator());

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_tipo_puesto", String.class, flagtipopuesto));
		lstAptitud = (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);

		if (!UValidador.esListaVacia(lstAptitud)) {
			for (DtoHrEntrCasPostEval obj : lstAptitud) {
				List<ParametroPersistenciaGenerico> parametros2 = new ArrayList<ParametroPersistenciaGenerico>();
				parametros2.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
				parametros2.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
				parametros2.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
				parametros2.add(new ParametroPersistenciaGenerico("pid_aptitud", String.class, obj.getIdaptitud()));
				obj.setLstConductas((List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query2, parametros2));
			}
		}

		return lstAptitud;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> validaPuntos(String requerimiento, String usuario) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.validaPuntos").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCas> validaCierreProceso(String requerimiento) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.validaCierre").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> validarIngreso(String requerimiento) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.validarIngreso").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void cerrarHrEntrCas(String requerimiento) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		dao.ejecutarPorQuery("hrencuesta.cerrarHrEntrCas", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void enviarPuntaje(String requerimiento, String usuario) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		dao.ejecutarPorQuery("hrencuesta.enviarPuntaje", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void nspHrEntrCasPost(String requerimiento, String postulante) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		dao.ejecutarPorQuery("hrencuesta.nspHrEntrCasPost", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void nspHrEntrCasPost2(String requerimiento, String postulante) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		dao.ejecutarPorQuery("hrencuesta.nspHrEntrCasPost2", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verBotones(String requerimiento, String usuario, String postulante) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verBotones").getQueryString() + System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verDatosReportePost(String requerimiento, String postulante) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verDatosReportePost").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verPuntosReportePost(String requerimiento, String postulante, String tipopuesto) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPuntosReportePost").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_tipopuesto", String.class, tipopuesto));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verSumPuntosReportePost(String requerimiento, String postulante) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verSumPuntosReportePost").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verDatosReporteProc(String requerimiento) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verDatosReporteProc").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verPuntosReporteProc(String requerimiento) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPuntosReporteProc").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> verEntrevistadores(String requerimiento, Integer secuencia) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verEntrevistadores").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_secuencia", Integer.class, secuencia));

		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registrarPunto(String requerimiento, String usuario, String postulante, String aptitud, String punto) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_aptitud", String.class, aptitud));
		parametros.add(new ParametroPersistenciaGenerico("pid_punto", String.class, punto));
		dao.ejecutarPorQuery("hrencuesta.registrarPunto", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registrarPuntoConducta(String requerimiento, String usuario, String postulante, String aptitud,
			String conducta, String punto) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_usuario", String.class, usuario));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_aptitud", String.class, aptitud));
		parametros.add(new ParametroPersistenciaGenerico("pid_conducta", String.class, conducta));
		parametros.add(new ParametroPersistenciaGenerico("pid_punto", String.class, punto));
		dao.ejecutarPorQuery("hrencuesta.registrarPuntoConducta", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registrarAsistencia(String requerimiento, String postulante, String asistencia) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_asistencia", String.class, asistencia));
		dao.ejecutarPorQuery("hrencuesta.registrarAsistencia", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registrarAsistencia2(String requerimiento, String idevalcas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, idevalcas));
		dao.ejecutarPorQuery("hrencuesta.registrarAsistencia2", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCas> validarClose(String requerimiento) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.validarClose").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> listarHrEvalCeu(Integer empleado) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, empleado));
		return (List) dao.listarPorQuery(DtoHrEvalCas.class, "hrencuesta.listarHrEvalCeu", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> listarHrEvalCeu2(String convocatoria, String despuesto, Integer empleado) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEvalCeu2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_convocatoria", String.class, convocatoria));
		parametros.add(new ParametroPersistenciaGenerico("pid_puesto", String.class, despuesto));
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, empleado));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@Override
	public List<DtoHrEvalCas> listarHrEvalFIFA(Integer empleado) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, empleado));
		return (List) dao.listarPorQuery(DtoHrEvalCas.class, "hrencuesta.listarHrEvalFIFA", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> listarHrEvalFIFA2(String convocatoria, String despuesto, Integer empleado) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEvalFIFA2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_convocatoria", String.class, convocatoria));
		parametros.add(new ParametroPersistenciaGenerico("pid_puesto", String.class, despuesto));
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, empleado));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> valInicioHrEvalCeu(DtoHrEvalCas dtoHrEvalCas) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.valInicioHrEvalCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@Override
	public List<DtoHrEvalCas> valInicioHrEvalFIFA(DtoHrEvalCas dtoHrEvalCas) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.valInicioHrEvalFIFA").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEvalCas> valCierreHrEvalCeu(String evalcas) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.valCierreHrEvalCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@Override
	public void editarHrEvalCeu(DtoHrEvalCas dtoHrEvalCas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(
				new ParametroPersistenciaGenerico("pid_requerimiento", String.class, dtoHrEvalCas.getRequerimiento()));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, dtoHrEvalCas.getCodigogrupo()));
		parametros.add(
				new ParametroPersistenciaGenerico("pid_especialidad", String.class, dtoHrEvalCas.getEspecialidad()));
		dao.ejecutarPorQuery("hrencuesta.editarHrEvalCeu", parametros);
	}

	@Override
	public void editarHrEvalFIFA(DtoHrEvalCas dtoHrEvalCas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(
				new ParametroPersistenciaGenerico("pid_requerimiento", String.class, dtoHrEvalCas.getRequerimiento()));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, dtoHrEvalCas.getCodigogrupo()));
		parametros.add(
				new ParametroPersistenciaGenerico("pid_especialidad", String.class, dtoHrEvalCas.getEspecialidad()));
		dao.ejecutarPorQuery("hrencuesta.editarHrEvalFIFA", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void finalizarHrEvalCeu(String requerimiento, String evalcas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		dao.ejecutarPorQuery("hrencuesta.finalizarHrEvalCeu", parametros);
	}

	@Override
	public void finalizarHrEvalFIFA(String requerimiento, String evalcas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, evalcas));
		dao.ejecutarPorQuery("hrencuesta.finalizarHrEvalFIFA", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPost> verPostulantesHrEvalCeu(DtoHrEvalCas obj) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteHrEvalCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, obj.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_cuidad", String.class, obj.getCiudad()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, obj.getCodigogrupo()));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPost> verPostulantesHrEvalCeu2(DtoHrEvalCas obj) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteHrEvalCeu2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, obj.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_cuidad", String.class, obj.getCiudad()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, obj.getCodigogrupo()));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);
	}

	@Override
	public List<DtoHrEntrCasPost> verPostulantesHrEvalFIFA2(DtoHrEvalCas obj) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteHrEvalFIFA2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, obj.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_cuidad", String.class, obj.getCiudad()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, obj.getCodigogrupo()));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPostEval> datosProcesoCeu(DtoHrEvalCas objevalcas) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.datosProcesoCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(
				new ParametroPersistenciaGenerico("pid_requerimiento", String.class, objevalcas.getRequerimiento()));
		parametros.add(new ParametroPersistenciaGenerico("pid_codigogrupo", String.class, objevalcas.getCodigogrupo()));
		parametros.add(new ParametroPersistenciaGenerico("pid_ciudad", String.class, objevalcas.getCiudad()));

		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registrarAsistenciaCeu(String requerimiento, String postulante, String asistencia) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_asistencia", String.class, asistencia));
		dao.ejecutarPorQuery("hrencuesta.registrarAsistenciaCeu", parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registrarAsistencia2Ceu(String requerimiento, String idevalcas) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, idevalcas));
		dao.ejecutarPorQuery("hrencuesta.registrarAsistencia2Ceu", parametros);
	}

	@Override
	public void actualizarMinutos(String idevalcas, String postulante, Integer minutos) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_idevalcas", String.class, idevalcas));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_minutos", Integer.class, minutos));
		dao.ejecutarPorQuery("hrencuesta.actualizarMinutos", parametros);
	}

	@Override
	public void actualizarSession(String aplicacioncodigo, String codigo1, String codigo2, String ultimousuario,
			String estado) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_aplicacioncodigo", String.class, aplicacioncodigo));
		parametros.add(new ParametroPersistenciaGenerico("p_codigo1", String.class, codigo1));
		parametros.add(new ParametroPersistenciaGenerico("p_codigo2", String.class, codigo2));
		parametros.add(new ParametroPersistenciaGenerico("p_ultimousuario", String.class, ultimousuario));
		parametros.add(new ParametroPersistenciaGenerico("p_estado", String.class, estado));

		dao.ejecutarPorQuery("hrencuesta.actualizarSession", parametros);

	}

	@Override
	public List<DtoHrEntrCasPostEval> listarSession(String aplicacioncodigo, String codigo1, String codigo2,
			String proceso) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarSession").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_aplicacioncodigo", String.class, aplicacioncodigo));
		parametros.add(new ParametroPersistenciaGenerico("p_codigo1", String.class, codigo1));
		parametros.add(new ParametroPersistenciaGenerico("p_codigo2", String.class, codigo2));
		parametros.add(new ParametroPersistenciaGenerico("p_proceso", String.class, proceso));

		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPostEval.class, query, parametros);
	}

	@Override
	public Integer obtenerDurExamen(String parflgTipoPuesto) {
		Integer retorno = 0;
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_codigoelemento", String.class, parflgTipoPuesto));
		List data = dao.listarPorQuery(HrPostulantes.class, "hrencuesta.getListaParametros1", parametros);

		if (!UValidador.esListaVacia(data)) {
			String val = ((HrPostulantes) data.get(0)).getNombres();
			if (!UValidador.estaVacio(val)) {
				retorno = Integer.parseInt(val);
			}
		}

		return retorno;
	}

	@Override
	public DtoHrEntrCasPost datosPostulanteExamenCEU(String id_evalcas, String postulante) {

		DtoHrEntrCasPost retorno = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.datosPostulanteExamenCEU").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, id_evalcas));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		List lista = dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (!UValidador.esListaVacia(lista)) {
			retorno = (DtoHrEntrCasPost) lista.get(0);
		}

		return retorno;
	}

	@Override
	public void actualizarMinutosCEU(String idevalcas, String postulante, Integer minutos) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_idevalcas", String.class, idevalcas));
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, postulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_minutos", Integer.class, minutos));
		dao.ejecutarPorQuery("hrencuesta.actualizarMinutosCEU", parametros);
	}

	@Override
	public void actualizarIntentosEvaluacionPostulanteCeu(String idpostulante, String idevalcas, BigDecimal intentos) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_postulante", String.class, idpostulante));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, idevalcas));
		parametros.add(new ParametroPersistenciaGenerico("pid_intentos", String.class, intentos));

		dao.ejecutarPorQuery("hrencuesta.actualizarIntentosEvaluacionPostulanteCeu", parametros);
	}

	@Override
	public List<DtoHrEvalCas> listarSalaPorPersonaCeu(Integer idPersona, String id_evalcas) {
		// TODO Auto-generated method stub
		List<DtoHrEvalCas> retorno = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarSalaPorPersonaCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, idPersona));
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, id_evalcas));

		retorno = (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
		return retorno;
	}

	@Override
	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalCeu(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documentoidentidad) {
		// TODO Auto-generated method stub
		List<DtoHrEntrCasPost> lista = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteSalaHrEvalCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_sala", String.class, dtoHrEvalCas.getId_sala()));
		parametros.add(new ParametroPersistenciaGenerico("pid_cuidad", String.class, dtoHrEvalCas.getCiudad()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, dtoHrEvalCas.getCodigogrupo()));
		parametros.add(new ParametroPersistenciaGenerico("pid_documento", String.class, documentoidentidad));
		lista = (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (incluirFoto) {
			if (UValidador.esNulo(cantidad)) {
				cantidad = lista.size();
			}

			HrPostulantes hrPostulantes = new HrPostulantes();

			Criteria c = daoMiscelaneos.getCriteria();
			c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
			List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

			if (!UValidador.esListaVacia(lista)) {
				int cont = 1;
				for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
					if (!UValidador.esListaVacia(detalle)) {
						if (cont <= cantidad) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									cont = cont + 1;
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}

						} else {
							break;
						}
					}
				}
			}
		}

		return lista;
	}

	@Override
	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalCeu2(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documentoidentidad) {
		// TODO Auto-generated method stub
		List<DtoHrEntrCasPost> lista = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteSalaHrEvalCeu2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_sala", String.class, dtoHrEvalCas.getId_sala()));
		parametros.add(new ParametroPersistenciaGenerico("pid_documento", String.class, documentoidentidad));
		lista = (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (incluirFoto) {
			if (UValidador.esNulo(cantidad)) {
				cantidad = lista.size();
			}

			HrPostulantes hrPostulantes = new HrPostulantes();

			Criteria c = daoMiscelaneos.getCriteria();
			c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
			List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

			if (!UValidador.esListaVacia(lista)) {
				int cont = 1;
				for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
					if (!UValidador.esListaVacia(detalle)) {
						if (cont <= cantidad) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									cont = cont + 1;
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}

						} else {
							break;
						}
					}
				}
			}
		}

		return lista;
	}

	public List<DtoHrEvalCas> listarHrEvalSalaCeu(String convocatoria, String despuesto, Integer empleado) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEvalSalaCeu").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_convocatoria", String.class, convocatoria));
		parametros.add(new ParametroPersistenciaGenerico("pid_puesto", String.class, despuesto));
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, empleado));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	public List<DtoHrEvalCas> listarHrEvalSalaFIFA(String convocatoria, String despuesto, Integer empleado) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.listarHrEvalSalaFIFA").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_convocatoria", String.class, convocatoria));
		parametros.add(new ParametroPersistenciaGenerico("pid_puesto", String.class, despuesto));
		parametros.add(new ParametroPersistenciaGenerico("pid_empleado", Integer.class, empleado));
		return (List) dao.listarPorSentenciaSQL(DtoHrEvalCas.class, query, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoHrEntrCasPost> verPostulantesHrEvalFIFA(DtoHrEvalCas obj) {
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteHrEvalFIFA").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, obj.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_cuidad", String.class, obj.getCiudad()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, obj.getCodigogrupo()));
		return (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);
	}

	@Override
	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalFIFA(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documentoidentidad) {
		// TODO Auto-generated method stub
		List<DtoHrEntrCasPost> lista = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteSalaHrEvalFIFA").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_sala", String.class, dtoHrEvalCas.getId_sala()));
		parametros.add(new ParametroPersistenciaGenerico("pid_cuidad", String.class, dtoHrEvalCas.getCiudad()));
		parametros.add(new ParametroPersistenciaGenerico("pid_grupo", String.class, dtoHrEvalCas.getCodigogrupo()));
		parametros.add(new ParametroPersistenciaGenerico("pid_documento", String.class, documentoidentidad));
		lista = (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (incluirFoto) {
			if (UValidador.esNulo(cantidad)) {
				cantidad = lista.size();
			}

			HrPostulantes hrPostulantes = new HrPostulantes();

			Criteria c = daoMiscelaneos.getCriteria();
			c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
			List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

			if (!UValidador.esListaVacia(lista)) {
				int cont = 1;
				for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
					if (!UValidador.esListaVacia(detalle)) {
						if (cont <= cantidad) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									cont = cont + 1;
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}

						} else {
							break;
						}
					}
				}
			}
		}

		return lista;
	}

	@Override
	public List<DtoHrEntrCasPost> verPostulantesSalaHrEvalFIFA2(DtoHrEvalCas dtoHrEvalCas, Boolean incluirFoto,
			Integer cantidad, String documentoidentidad) {
		// TODO Auto-generated method stub
		List<DtoHrEntrCasPost> lista = null;
		StringBuilder query = new StringBuilder(
				dao.getSesionActual().getNamedQuery("hrencuesta.verPostulanteSalaHrEvalFIFA2").getQueryString()
						+ System.lineSeparator());
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("pid_evalcas", String.class, dtoHrEvalCas.getId_evalcas()));
		parametros.add(new ParametroPersistenciaGenerico("pid_sala", String.class, dtoHrEvalCas.getId_sala()));
		parametros.add(new ParametroPersistenciaGenerico("pid_documento", String.class, documentoidentidad));
		lista = (List) dao.listarPorSentenciaSQL(DtoHrEntrCasPost.class, query, parametros);

		if (incluirFoto) {
			if (UValidador.esNulo(cantidad)) {
				cantidad = lista.size();
			}

			HrPostulantes hrPostulantes = new HrPostulantes();

			Criteria c = daoMiscelaneos.getCriteria();
			c.add(Restrictions.eq("pk.codigotabla", "DNIPARPIDE"));
			List<MaMiscelaneosdetalle> detalle = daoMiscelaneos.listarPorCriterios(c);

			if (!UValidador.esListaVacia(lista)) {
				int cont = 1;
				for (DtoHrEntrCasPost obj : (ArrayList<DtoHrEntrCasPost>) lista) {
					if (!UValidador.esListaVacia(detalle)) {
						if (cont <= cantidad) {
							for (MaMiscelaneosdetalle documento : detalle) {
								hrPostulantes = hrpostulanteServicio.obtenerFotoReniec(obj.getDocumento(),
										documento.getValorcodigo1());
								if (hrPostulantes.getAuxerrorreniec()) {
									continue;
								} else {
									cont = cont + 1;
									if (!UValidador.esNulo(hrPostulantes.getFoto())) {
										obj.setFotoPostulante(
												"data:image/png;base64," + hrPostulantes.getImagenBase64());
									}
									break;
								}
							}

						} else {
							break;
						}
					}
				}
			}
		}

		return lista;
	}

}