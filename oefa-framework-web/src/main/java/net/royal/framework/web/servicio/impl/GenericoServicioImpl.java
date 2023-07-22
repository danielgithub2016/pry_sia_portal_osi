package net.royal.framework.web.servicio.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.servicio.GenericoServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

public class GenericoServicioImpl implements GenericoServicio {

	private static final Log LOGGER = LogFactory
			.getLog(GenericoServicioImpl.class);

	@SuppressWarnings("rawtypes")
	private GenericoDao genericoDao;

	@SuppressWarnings("rawtypes")
	public void setGenericoDao(GenericoDao genericoDao) {
		this.genericoDao = genericoDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Object registrar(Object entidad) {
		return genericoDao.registrar(entidad);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void actualizar(Object entidad) {
		// logger.debug("actualizar - generico servicio impl");
		genericoDao.actualizar(entidad);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void eliminar(Object entidad) {
		genericoDao.eliminar(entidad);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void registrarOactualizar(Object entidad) {
		genericoDao.registrarOactualizar(entidad);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Object obtenerPorId(Serializable id, boolean lock) {
		return genericoDao.obtenerPorId(id, lock);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Object obtenerPorId(Serializable id) {
		return genericoDao.obtenerPorId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> listarTodos() {
		return genericoDao.listarTodos();
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public List<?> listarTodos(Class clazz) {
		return genericoDao.listarTodos(clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<?> listarPorEjemplo(Object ejemploEntidad,
			String... propiedadesExcluidas) {
		return genericoDao.listarPorEjemplo(ejemploEntidad,
				propiedadesExcluidas);
	}

	@Override
	@Transactional(readOnly = true)
	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente,
			Map parametros) throws Exception {
		return this.genericoDao.ejecutarReporteComoPDF(
				rutaArchivoReporteFuente, parametros);
	}

	@Override
	@Transactional(readOnly = true)
	public String ejecutarReporteComoPDF(Map<String, Object> map,
			String directorio, String nombreReporte) throws Exception {
		return this.genericoDao.ejecutarReporteComoPDF(map, directorio,
				nombreReporte);
	}

	@Override
	@Transactional(readOnly = true)
	public String ejecutarReporteIReport(String rutaArchivoReporteFuente,
			Map parametros) throws Exception {
		return genericoDao.ejecutarReporteIReport(rutaArchivoReporteFuente,
				parametros);
	}

	@Override
	public String ejecutarReporteIReportDesdeLista(
			String rutaArchivoReporteFuente, Map parametros, List lista)
			throws Exception {
		return genericoDao.ejecutarReporteIReportDesdeLista(rutaArchivoReporteFuente, parametros, lista);
	}

	@Override
	public byte[] ejecutarReporteComoPDFDesdeLista(
			String rutaArchivoReporteFuente, Map parametros, List lista) throws Exception {
		return genericoDao.ejecutarReporteComoPDFDesdeLista(rutaArchivoReporteFuente, parametros, lista);
	}

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Class>
	 * listarPorHqlQuery(Class clazz, String nombreHqlQuery){ return
	 * genericoDao.listarPorHqlQuery(clazz, nombreHqlQuery); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Class>
	 * listarPorHqlQuery(Class clazz, String nombreHqlQuery,
	 * List<ParametroPersistenciaGenerico> parametros) { return
	 * genericoDao.listarPorHqlQuery(clazz, nombreHqlQuery,parametros); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<?>
	 * listarPorCriterios(Criteria criteria) { return
	 * genericoDao.listarPorCriterios(criteria); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Connection getConnection() {
	 * return genericoDao.getConnection(); }
	 */

	/**
	 * retorna la seccion actual que esta activa del Hibernate
	 * 
	 * @return Session objeto del tipo <br>
	 *         org.hibernate.Session</br>
	 */
	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Session getSession() { return
	 * genericoDao.getSession(); }
	 */

	/**
	 * obtiene la instancia de los criterios para armar las condiciones de
	 * busqueda
	 * 
	 * @return Criteria del tipo <br>
	 *         org.hibernate.Criteria</br>
	 */
	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Criteria getCriteria() { return
	 * genericoDao.getCriteria(); }
	 */

	/**
	 * obtiene la instancia de los criterios para armar las condiciones de
	 * busqueda
	 * 
	 * @param clazz
	 *            especifica el tipo que se va a aplicar para obtener los
	 *            criterios
	 * @return Criteria del tipo <br>
	 *         org.hibernate.Criteria</br>
	 */
	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Criteria getCriteria(Class clazz)
	 * { return genericoDao.getCriteria(clazz); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<?>
	 * listarPorCriterios(Criterion... criterios) { return
	 * genericoDao.listarPorCriterios(criterios); }
	 */
}
