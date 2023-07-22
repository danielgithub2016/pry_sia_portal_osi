package net.royal.framework.web.servicio;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericoServicio extends Serializable{

	//public Connection getConnection();

	/**
	 * retorna la seccion actual que esta activa del Hibernate
	 *
	 * @return Session objeto del tipo <br>
	 *         org.hibernate.Session</br>
	 */
	//public Session getSession();

	/**
	 * obtiene la instancia de los criterios para armar las condiciones de
	 * busqueda
	 *
	 * @return Criteria del tipo <br>
	 *         org.hibernate.Criteria</br>
	 */
	//public Criteria getCriteria();

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
	//public Criteria getCriteria(Class clazz);

	public Object registrar(Object entidad);

	public void actualizar(Object entidad);

	public void eliminar(Object entidad);

	public void registrarOactualizar(Object entidad);

	public Object obtenerPorId(Serializable id, boolean lock);

	public Object obtenerPorId(Serializable id);

	public List<?> listarTodos();

	public List<?> listarTodos(Class clazz);

	public List<?> listarPorEjemplo(Object ejemploEntidad,
			String... propiedadesExcluidas);

	//public List<?> listarPorCriterios(Criterion... criterios);

	//public List<?> listarPorCriterios(Criteria criteria);

	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente,
			Map parametros) throws Exception;

	public String ejecutarReporteComoPDF(Map<String, Object> map,
			String directorio, String nombreReporte) throws Exception;

	public String ejecutarReporteIReport(String rutaArchivoReporteFuente,
			Map parametros) throws Exception;

	//public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery);
	
	//public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery, List<ParametroPersistenciaGenerico> parametros);
	
	public String ejecutarReporteIReportDesdeLista(String rutaArchivoReporteFuente,
			Map parametros,List lista) throws Exception;
	
	public byte[] ejecutarReporteComoPDFDesdeLista(
			String rutaArchivoReporteFuente, Map parametros, List lista) throws Exception;
}
