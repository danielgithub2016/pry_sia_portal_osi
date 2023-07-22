package net.royal.framework.web.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import net.royal.framework.web.dao.impl.GenericoDaoImpl.SORT_ORDER;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

// TODO: Auto-generated Javadoc
/**
 * The Interface GenericoDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public interface GenericoDao<T, ID extends Serializable> {

	public Connection getConnection();

	/**
	 * retorna la seccion actual que esta activa del Hibernate
	 *
	 * @return Session objeto del tipo <br>
	 *         org.hibernate.Session</br>
	 */
	public Session getSesionActual();
	
	public void setSesionActual(Session SessionInterna);

	public SessionFactory getSessionFactory();
	
	/**
	 * obtiene la instancia de los criterios para armar las condiciones de
	 * busqueda
	 *
	 * @return Criteria del tipo <br>
	 *         org.hibernate.Criteria</br>
	 */
	public Criteria getCriteria();

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
	public Criteria getCriteria(Class clazz);

	public T registrar(T entity);

	public void actualizar(T entity);

	public void eliminar(T entity);

	public void registrarOactualizar(T entity);

	public void ejecutarPorQuery(String nombreQuery,
			List<ParametroPersistenciaGenerico> parametros);
	
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL);
	
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros);

	/**
	 * Find by id. realiza la busqueda en base al ID
	 *
	 * @param id
	 *            representa la clave primaria de la entidad o el valor unico de
	 *            la entidad T
	 * @param lock
	 *            the lock
	 * @return T: es la clase generica que se devuelve Si no se encuentra se
	 *         devuelve null.
	 */
	public T obtenerPorId(ID id, boolean lock);

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @param lock
	 *            the lock
	 * @return the by id
	 */
	public T obtenerPorId(ID id);

	/**
	 * Gets the named query.
	 *
	 * @param clazz
	 *            the clazz
	 * @param namedQuery
	 *            the named query
	 * @param parameters
	 *            the parameters
	 * @return the named query
	 */
	public Object obtenerPorQuery(Class clazz, String nombreQuery,
			List<ParametroPersistenciaGenerico> parametros);

	/**
	 * Find all.
	 *
	 * @return regresa la lista completa de objetos del tipo T
	 */
	public List<T> listarTodos();

	public List<Class> listarTodos(Class clazz);

	/**
	 * Find by example.
	 *
	 * @param exampleInstance
	 *            the example instance
	 * @param excludeProperty
	 *            the exclude property
	 * @return the list
	 */
	public List<T> listarPorEjemplo(T entity, String... excludeProperty);

	/**
	 * Find by criteria.
	 *
	 * @param criterion
	 *            the criterion
	 * @return the list
	 */
	public List<T> listarPorCriterios(Criterion... criterios);

	public List<T> listarPorCriterios(Class clazz, Criterion... criterios);

	public List<T> listarPorCriterios(Criteria criteria);
	
	/**
	 * Gets the named query.
	 *
	 * @param clazz
	 *            the clazz
	 * @param nombreHqlQuery
	 *            the named Hql query
	 * @return la lista con la sentencia Hql
	 */
	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery);
	
	/**
	 * Gets the named query.
	 *
	 * @param clazz
	 *            the clazz
	 * @param nombreHqlQuery
	 *            the named Hql query
	 * @param parametros
	 *            del tipo List<ParametroPersistenciaGenerico>
	 * @return la lista con la sentencia Hql
	 */
	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery, List<ParametroPersistenciaGenerico> parametros);
	
	/**
	 * Gets the named query.
	 *
	 * @param clazz
	 *            the clazz
	 * @param namedQuery
	 *            the named query
	 * @return the named query
	 */
	public List<Class> listarPorQuery(Class clazz, String nombreQuery);

	/**
	 * Gets the named query.
	 *
	 * @param clazz
	 *            the clazz
	 * @param namedQuery
	 *            the named query
	 * @param parameters
	 *            the parameters
	 * @return the named query
	 */
	public List<Class> listarPorQuery(Class clazz, String nombreQuery,
			List<ParametroPersistenciaGenerico> parametros);

	/**
	 * Gets the named query.
	 *
	 * @param clazz
	 *            the clazz
	 * @param sentenciaSQL
	 *            the sentencia sql
	 * @param parameters
	 *            the parameters
	 * @return list the named query
	 */
	public List<Class> listarPorSentenciaSQL(Class clazz,
			StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros);

	/**
	 * Find by filter.
	 *
	 * @param firstRow
	 *            the first row
	 * @param maxResult
	 *            the max result
	 * @param orderByAttribute
	 *            the order by attribute
	 * @param sortOrder
	 *            the sort order
	 * @param filterMap
	 *            the filter map
	 * @return the list
	 */
	public List<T> listarConPaginacion(int regInicio, int regMaximoDevolver,
			String atributoOrdenar, SORT_ORDER direccionOrdenAtributo,
			List<ParametroPersistenciaGenerico> parametros);

	public List<T> listarConPaginacion(int regInicio, int regMaximoDevolver,
			String atributoOrdenar, SORT_ORDER direccionOrdenAtributo,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery);

	public List<Class> listarConPaginacion(int regInicio,
			int regMaximoDevolver, String atributoOrdenar,
			SORT_ORDER direccionOrdenAtributo,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery,
			Class clazz);

	public List<Class> listarConPaginacion(int regInicio,
			int regMaximoDevolver, String atributoOrdenar,
			SORT_ORDER direccionOrdenAtributo,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery,
			Class clazz, String condicionesConsulta);

	/**
	 * Ejecuta la sentencia SQL enviada y devuelve los resultado en un una
	 * coleccion de objetos
	 *
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO
	 * @return representa la coleccion de objetos encontrados como resultado de
	 *         la ejecucion de la sentencia SQL
	 */
	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL);

	/**
	 * Ejecuta la sentencia SQL enviada y devuelve los resultado en un una
	 * coleccion de objetos
	 *
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar
	 *            la consulta
	 * @return representa la coleccion de objetos encontrados como resultado de
	 *         la ejecucion de la sentencia SQL
	 */
	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros);

	/**
	 * Ejecuta la sentencia SQL enviada y devuelve los resultado en un una
	 * coleccion de objetos
	 *
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar
	 *            la consulta
	 * @param clazz
	 *            especifica el tipo de objeto que se devolvera en el resultado
	 * @return representa la coleccion de objetos encontrados como resultado de
	 *         la ejecucion de la sentencia SQL
	 */
	public List<Class> listarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros, Class clazz);

	/**
	 * retorna la cantidad de registros de una tabla en base a una sentencia SQL
	 *
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar
	 *            registros
	 * @return representa a la cantidad de registros encontrados
	 */
	public Integer contar(String nombreQuery);

	/**
	 * retorna la cantidad de registros de una tabla en base a una sentencia SQL
	 *
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar
	 *            registros
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar
	 *            la consulta
	 * @return representa a la cantidad de registros encontrados
	 */
	public Integer contar(String nombreQuery,
			List<ParametroPersistenciaGenerico> parametros);

	/**
	 * retorna la cantidad de registros de una tabla en base a los filtros
	 * enviados
	 *
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar
	 *            la consulta
	 * @return representa a la cantidad de registros encontrados
	 */
	public Integer contar(List<ParametroPersistenciaGenerico> parametros);

	/**
	 * Contar por Sentencia SQL, retorna la cantidad de registros de una tabla
	 * en base a una sentencia SQL
	 *
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO la consulta
	 * @return the count, representa a la cantidad de registros encontrados
	 */
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL);

	/**
	 * Contar por Sentencia SQL, retorna la cantidad de registros de una tabla
	 * en base a una sentencia SQL
	 *
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO la consulta
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar
	 *            la consulta
	 * @return the count, representa a la cantidad de registros encontrados
	 */
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros);

	public String obtenerSentenciaSqlPorQuery(String nombreQuery);

	/**
	 * retorna un objeto generico que estaba basado en la consulta sql
	 *
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar
	 *            registros
	 * @return Object retorna la informacion dependiendo la sentencia sql
	 */
	public Object buscarGenerico(String nombreQuery);

	/**
	 * retorna un objeto generico que estaba basado en la consulta sql
	 *
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar
	 *            registros
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar
	 *            la consulta
	 * @return Object retorna la informacion dependiendo la sentencia sql
	 */
	public Object buscarGenerico(String nombreQuery,
			List<ParametroPersistenciaGenerico> parametros);

	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente,
			Map parametros) throws Exception;
	
	public String ejecutarReporteIReportDesdeLista(String rutaArchivoReporteFuente,
			Map parametros,List lista) throws Exception;
	public byte[] ejecutarReporteComoPDFDesdeLista(String rutaArchivoReporteFuente,
			Map parametros,List lista) throws Exception;

	public String ejecutarReporteComoPDF(Map<String, Object> map,
			String directorio, String nombreReporte) throws Exception;

	public String ejecutarReporteIReport(String rutaArchivoReporteFuente,
			Map parametros) throws Exception;

	public List ejecutarListaSQL(StringBuilder sentenciaSQL) throws Exception;
	
	public BigDecimal incrementarBigDecimal(Criteria cri);
	
	public Integer incrementarInteger(Criteria cri);
}
