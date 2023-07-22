package net.royal.framework.web.dao.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public abstract class GenericoDaoImpl<T, ID extends Serializable> extends HibernateTemplate
		implements GenericoDao<T, ID>, Serializable {

	private static final Log LOGGER = LogFactory.getLog(GenericoDaoImpl.class);
	private static final long serialVersionUID = 8704138686206423411L;
	private Class<T> persistentClass;
	private String nombreAlias;
	private Session SessionInterna;

	@Override
	public Session getSesionActual() {
		if (SessionInterna == null) {// LOGGER.debug("****************SESSION
										// CURRENT");
			return super.getSessionFactory().getCurrentSession();
		} else {// LOGGER.debug("SESSION CUSTOMIZADA");
			return SessionInterna;
		}
	}

	@Override
	public void setSesionActual(Session SessionInterna) {
		this.SessionInterna = SessionInterna;
	}

	@SuppressWarnings("unchecked")
	public GenericoDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public GenericoDaoImpl(String nombreAlias) {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

		this.nombreAlias = nombreAlias;
	}

	@SuppressWarnings("unchecked")
	public GenericoDaoImpl(SessionFactory factory, String nombreAlias) {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		super.setSessionFactory(factory);
		this.nombreAlias = nombreAlias;
	}

	@Override
	public Connection getConnection() {
		return ((SessionImpl) this.getSesionActual()).connection();
	}

	/**
	 * obtiene la instancia de los criterios para armar las condiciones de busqueda
	 * 
	 * @return Criteria del tipo <br>
	 *         org.hibernate.Criteria</br>
	 */
	@Override
	public Criteria getCriteria() {
		return this.getSesionActual().createCriteria(persistentClass);
	}

	/**
	 * obtiene la instancia de los criterios para armar las condiciones de busqueda
	 * 
	 * @param clazz
	 *            especifica el tipo que se va a aplicar para obtener los criterios
	 * @return Criteria del tipo <br>
	 *         org.hibernate.Criteria</br>
	 */
	@Override
	public Criteria getCriteria(Class clazz) {
		return this.getSesionActual().createCriteria(clazz);
	}

	public enum SORT_ORDER {
		ASC, DESC
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T registrar(T entity) {
		return (T) this.getSesionActual().save(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void actualizar(T entity) {
		this.getSesionActual().update(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void eliminar(T entity) {
		this.getSesionActual().delete(entity);
	}

	@Override
	public void registrarOactualizar(T entity) {
		this.getSesionActual().saveOrUpdate(entity);
	}

	@Override
	public void ejecutarPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {

		if (!validarAlias(nombreQuery))
			return;

		Query query = this.getSesionActual().getNamedQuery(nombreQuery);

		query = getNamedQueryByPatametersSet(query, parametros);

		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL) {

		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		logger.debug(query.toString());
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {

		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		query = getNamedQueryByPatametersSet(query, parametros);

		logger.debug(query.toString());
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T obtenerPorId(ID id, boolean lock) {
		T entity = null;

		try {
			if (lock)
				entity = (T) this.getSesionActual().get(getPersistentClass(), id, LockMode.UPGRADE);
			else
				entity = (T) this.getSesionActual().get(getPersistentClass(), id);
		} catch (Exception ex) {
			LOGGER.error(ex);
			return null;
		}
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T obtenerPorId(ID id) {
		return this.obtenerPorId(id, true);
	}

	@Override
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public Object obtenerPorQuery(Class clazz, String namedQuery, List<ParametroPersistenciaGenerico> parameters) {

		if (!validarAlias(namedQuery))
			return null;

		Query query = this.getSesionActual().getNamedQuery(namedQuery);
		query = getNamedQueryByPatametersSet(query, parameters);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarTodos() {
		return listarPorCriterios();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarTodos(Class clazz) {
		return (List<Class>) listarPorCriterios(clazz);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> listarPorEjemplo(T exampleInstance, String... excludeProperty) {
		Criteria crit = this.getSesionActual().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);

		if (excludeProperty != null) {
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
		}

		crit.add(example);
		return crit.list();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery) {
		if (!validarAlias(nombreHqlQuery))
			return null;
		LOGGER.debug("listarPorHqlQuery");

		String sentenciaHql = this.getSesionActual().getNamedQuery(nombreHqlQuery).getQueryString();

		Query query = this.getSesionActual().createQuery(sentenciaHql);

		query = query.setResultTransformer(Transformers.aliasToBean(clazz));

		return query.list();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery,
			List<ParametroPersistenciaGenerico> parametros) {
		if (!validarAlias(nombreHqlQuery))
			return null;
		LOGGER.debug("listarPorHqlQuery");

		String sentenciaHql = this.getSesionActual().getNamedQuery(nombreHqlQuery).getQueryString();
		LOGGER.debug(sentenciaHql);

		Query query = this.getSesionActual().createQuery(sentenciaHql);
		query = getNamedQueryByPatametersSet(query, parametros);
		LOGGER.debug(query);
		LOGGER.debug(clazz);

		query = query.setResultTransformer(Transformers.aliasToBean(clazz));

		return query.list();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Class> listarPorQuery(Class clazz, String namedQuery) {
		if (!validarAlias(namedQuery))
			return null;

		Query query = this.getSesionActual().getNamedQuery(namedQuery);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Class> listarPorQuery(Class clazz, String namedQuery, List<ParametroPersistenciaGenerico> parameters) {

		if (!validarAlias(namedQuery))
			return null;

		Query query = this.getSesionActual().getNamedQuery(namedQuery);

		query = getNamedQueryByPatametersSet(query, parameters);

		query = query.setResultTransformer(Transformers.aliasToBean(clazz));

		return query.list();
	}

	private Boolean validarAlias(String nombreQuery) {
		if (nombreAlias == null)
			return true;
		if (nombreQuery == null)
			return true;
		int indicador = nombreQuery.indexOf(nombreAlias + ".");

		if (indicador == -1)
			try {
				throw new Exception("El nombre del alias:(" + nombreAlias + "), no se encuentra en el query:("
						+ nombreQuery
						+ "). Verifique el nombre de los metodos en el archivo xml donde se encuentra la sentencia sql.");
			} catch (Exception e) {
				LOGGER.error(e);
				return false;
			}

		return true;
	}

	@Override
	public List<Class> listarPorSentenciaSQL(Class clazz, StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros) {

		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		query = getNamedQueryByPatametersSet(query, parametros);

		query = query.setResultTransformer(Transformers.aliasToBean(clazz));

		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> listarConPaginacion(int regInicio, int regMaximoDevolver, String atributoOrdenar,
			SORT_ORDER direccionOrdenAtributo, List<ParametroPersistenciaGenerico> parametros) {

		return this.listarConPaginacion(regInicio, regMaximoDevolver, atributoOrdenar, direccionOrdenAtributo,
				parametros, null);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional(readOnly = true)
	public List<T> listarConPaginacion(int regInicio, int regMaximoDevolver, String atributoOrdenar,
			SORT_ORDER direccionOrdenAtributo, List<ParametroPersistenciaGenerico> parametros, String nombreQuery) {

		if (!validarAlias(nombreQuery))
			return null;

		StringBuffer queryS = new StringBuffer();

		if (nombreQuery == null)
			queryS.append("SELECT e FROM " + persistentClass.getName() + " e");
		else
			queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());

		// sort order
		String sortOrderString = "desc";
		if (direccionOrdenAtributo == SORT_ORDER.ASC)
			sortOrderString = "asc";

		LOGGER.debug("ordenamiento: " + sortOrderString);

		// order by
		if (atributoOrdenar != null) {
			queryS.append(" ORDER BY " + atributoOrdenar + " " + sortOrderString);
		}

		Query q = this.getSesionActual().createSQLQuery(queryS.toString());

		// parameter
		q = this.getNamedQueryByPatametersSet(q, parametros);

		if (regInicio > 0) {
			q.setFirstResult(regInicio);
		}
		if (regMaximoDevolver > 0) {
			LOGGER.debug("maximo :" + regMaximoDevolver);
			q.setMaxResults(regMaximoDevolver);
		}

		return q.list();
	}

	@Override
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List<Class> listarConPaginacion(int regInicio, int regMaximoDevolver, String atributoOrdenar,
			SORT_ORDER direccionOrdenAtributo, List<ParametroPersistenciaGenerico> parametros, String nombreQuery,
			Class clazz) {

		if (!validarAlias(nombreQuery))
			return null;

		return listarConPaginacion(regInicio, regMaximoDevolver, atributoOrdenar, direccionOrdenAtributo, parametros,
				nombreQuery, clazz, null);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional(readOnly = true)
	public List<Class> listarConPaginacion(int regInicio, int regMaximoDevolver, String atributoOrdenar,
			SORT_ORDER direccionOrdenAtributo, List<ParametroPersistenciaGenerico> parametros, String nombreQuery,
			Class clazz, String condicionesConsulta) {

		if (!validarAlias(nombreQuery))
			return null;

		StringBuffer queryS = new StringBuffer();

		queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());

		// agregar condiciones del tipo where, a la consulta orginal que se
		// encuentra en el XML
		if (condicionesConsulta != null)
			queryS.append(condicionesConsulta);

		// sort order
		String sortOrderString = "desc";
		if (direccionOrdenAtributo == SORT_ORDER.ASC)
			sortOrderString = "asc";

		// order by
		if (atributoOrdenar != null) {
			queryS.append(" ORDER BY " + atributoOrdenar + " " + sortOrderString);
		}

		Query q = this.getSesionActual().createSQLQuery(queryS.toString());

		// parameter
		q = this.getNamedQueryByPatametersSet(q, parametros);

		if (regInicio > 0) {
			q.setFirstResult(regInicio);
		}

		// se comenta este codigi porque cuando se pone en el nuevo
		// framework falla

		if (regMaximoDevolver > 0) {
			q.setMaxResults(regMaximoDevolver);
		}

		q = q.setResultTransformer(Transformers.aliasToBean(clazz));

		List listaRegreso = q.list();

		return listaRegreso;
	}

	/**
	 * Ejecuta la sentencia SQL enviada y devuelve los resultado en un una coleccion
	 * de objetos
	 * 
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO la consulta
	 * @return representa la coleccion de objetos encontrados como resultado de la
	 *         ejecucion de la sentencia SQL
	 */
	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		return query.list();
	}

	/**
	 * Ejecuta la sentencia SQL enviada y devuelve los resultado en un una coleccion
	 * de objetos
	 * 
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar la
	 *            consulta
	 * @return representa la coleccion de objetos encontrados como resultado de la
	 *         ejecucion de la sentencia SQL
	 */
	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		// parameter
		query = this.getNamedQueryByPatametersSet(query, parametros);

		return query.list();
	}

	/**
	 * Ejecuta la sentencia SQL enviada y devuelve los resultado en un una coleccion
	 * de objetos
	 * 
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar la
	 *            consulta
	 * @param clazz
	 *            especifica el tipo de objeto que se devolvera en el resultado
	 * @return representa la coleccion de objetos encontrados como resultado de la
	 *         ejecucion de la sentencia SQL
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Class> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros,
			Class clazz) {

		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		// parameter
		query = this.getNamedQueryByPatametersSet(query, parametros);

		query = query.setResultTransformer(Transformers.aliasToBean(clazz));

		return query.list();
	}

	/**
	 * retorna la cantidad de registros de una tabla en base a una sentencia SQL
	 * 
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar registros
	 * @return representa a la cantidad de registros encontrados
	 */
	@Override
	@Transactional(readOnly = true)
	public Integer contar(String nombreQuery) {
		if (!validarAlias(nombreQuery))
			return null;

		return contar(nombreQuery, null);
	}

	/**
	 * retorna la cantidad de registros de una tabla en base a una sentencia SQL
	 * 
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar registros
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar la
	 *            consulta
	 * @return representa a la cantidad de registros encontrados
	 */
	@Override
	@Transactional(readOnly = true)
	public Integer contar(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		if (!validarAlias(nombreQuery))
			return null;

		Integer cantReg;
		StringBuffer queryS = new StringBuffer();

		queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());

		Query query = this.getSesionActual().createSQLQuery(queryS.toString());

		// parameter
		query = this.getNamedQueryByPatametersSet(query, parametros);

		Object resultado;

		resultado = query.uniqueResult();

		if (resultado == null)
			cantReg = 0;
		else
			cantReg = Integer.parseInt(resultado.toString());

		return cantReg;
	}

	/**
	 * retorna la cantidad de registros de una tabla en base a los filtros enviados
	 * 
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar la
	 *            consulta
	 * @return representa a la cantidad de registros encontrados
	 */
	@Override
	@Transactional(readOnly = true)
	public Integer contar(List<ParametroPersistenciaGenerico> parametros) {
		Integer cantRegistros;
		StringBuffer queryS = new StringBuffer();

		queryS.append("SELECT e FROM " + persistentClass.getName() + " e");

		Query query = this.getSesionActual().createSQLQuery(queryS.toString());

		// parameter
		query = this.getNamedQueryByPatametersSet(query, parametros);

		cantRegistros = Integer.parseInt(query.uniqueResult().toString());

		return cantRegistros;
	}

	/**
	 * Contar por Sentencia SQL, retorna la cantidad de registros de una tabla en
	 * base a una sentencia SQL
	 * 
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO la consulta
	 * @return the count, representa a la cantidad de registros encontrados
	 */
	@Override
	@Transactional(readOnly = true)
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		return contarPorSentenciaSQL(sentenciaSQL, null);
	}

	/**
	 * Contar por Sentencia SQL, retorna la cantidad de registros de una tabla en
	 * base a una sentencia SQL
	 * 
	 * @param sentenciaSQL
	 *            sentencia SQL enviada para ser ejecutada por DAO la consulta
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar la
	 *            consulta
	 * @return the count, representa a la cantidad de registros encontrados
	 */
	@Override
	@Transactional(readOnly = true)
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros) {

		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());

		// parameter
		query = this.getNamedQueryByPatametersSet(query, parametros);

		BigDecimal cantRegistros = (BigDecimal) query.uniqueResult();

		return cantRegistros;
	}

	/**
	 * genera la condiciona dinamicamente en base a los paarametros enviados
	 * 
	 * @param parametros
	 *            representa la coleccion de parametros enviados para generar las
	 *            condiciones
	 * @param sentenciaSQL
	 *            Sentencia SQL que se utilizara para contar registros, se usa como
	 *            referencia
	 * @return una cadena, representa a la condicion generada como resultado de los
	 *         parametros
	 */
	protected String getWhereClause(List<ParametroPersistenciaGenerico> parametros, StringBuffer sentenciaSQL) {
		StringBuffer sentenciaWhere = new StringBuffer();
		String parameter = null;
		Object tipoDatos = null;
		boolean primerFiltro;

		if (sentenciaSQL == null)
			sentenciaSQL = new StringBuffer();

		if (parametros == null)
			return sentenciaWhere.toString();
		if (parametros.isEmpty())
			return sentenciaWhere.toString();

		String sqlTemp = "";
		sqlTemp = sentenciaSQL.toString().toUpperCase();
		int indexOfWhere = sqlTemp.indexOf("WHERE");

		if (indexOfWhere == -1) {
			sentenciaWhere.append(" WHERE ");
			primerFiltro = true;
		} else {
			primerFiltro = false;
		}

		for (ParametroPersistenciaGenerico item : parametros) {
			tipoDatos = item.getClazz();
			parameter = item.getField();

			if (tipoDatos == char.class) {
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					sentenciaWhere.append(" " + parameter + " = '" + item.getValue() + "' ");
				}
			}
			if (tipoDatos == Timestamp.class) {
				// pendiente de implementacion
			}
			if (tipoDatos == BigDecimal.class) {
				LOGGER.debug("es bigdecimal");
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					sentenciaWhere.append(" " + parameter + " = " + item.getValue() + " ");
				}

			}
			if (tipoDatos == Integer.class) {
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					sentenciaWhere.append(" " + parameter + " = " + item.getValue() + " ");
				}
			}
			if (tipoDatos == String.class) {
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					sentenciaWhere.append(" " + parameter + " = '" + item.getValue() + "' ");
				}
			}
			if (tipoDatos == Double.class) {
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					sentenciaWhere.append(" " + parameter + " = " + item.getValue() + " ");
				}
			}
			if (tipoDatos == double.class) {
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					sentenciaWhere.append(" " + parameter + " = " + item.getValue() + " ");
				}

			}
			if (tipoDatos == Boolean.class) {
				if (item.getValue() != null) {
					sentenciaWhere.append(primerFiltro == true ? "" : " AND ");
					if (((Boolean) tipoDatos) == true)
						sentenciaWhere.append(" " + parameter + " = " + item.getValue() + " ");
					else
						sentenciaWhere.append(" " + parameter + " = " + item.getValue() + " ");
				}
			}
			if (tipoDatos == Date.class) {
				// pendiente de implementacion
			}

		}

		return sentenciaWhere.toString();
	}

	/**
	 * Asigna los parametros enviados a un objeto del tipo <strong>Query</strong>
	 * 
	 * @param query
	 *            .
	 * 
	 * @parameters parameters.
	 * 
	 * @return retorno un objeto tipo <strong>Query</strong>
	 * 
	 */
	protected Query getNamedQueryByPatametersSet(Query query, List<ParametroPersistenciaGenerico> parameters) {
		String parameter = null;
		Object tipoDatos = null;

		if (parameters == null)
			return query;

		for (ParametroPersistenciaGenerico item : parameters) {
			tipoDatos = item.getClazz();
			parameter = item.getField();

			if (tipoDatos == char.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.STRING);
			}
			if (tipoDatos == Timestamp.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.DATE);
			}
			if (tipoDatos == Integer.class) {
				if (item.getValue() != null) {
					try {
						query.setParameter(parameter, item.getValue());
					} catch (Exception e) {
						LOGGER.debug("=======> parametro no encontrado :" + parameter);
					}

				} else {
					try {
						query.setParameter(parameter, null, StandardBasicTypes.INTEGER);
					} catch (Exception e) {
						LOGGER.debug("=======> parametro no encontrado :" + parameter);
					}
				}
			}
			if (tipoDatos == BigDecimal.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.DOUBLE);
			}
			if (tipoDatos == Double.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.DOUBLE);
			}
			if (tipoDatos == double.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.DOUBLE);
			}
			if (tipoDatos == long.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.LONG);
			}
			if (tipoDatos == Long.class) {
				if (item.getValue() != null) {
					try {
						query.setParameter(parameter, item.getValue());
					} catch (Exception e) {
						LOGGER.debug("=======> parametro no encontrado :" + parameter);
					}

				} else {
					try {
						query.setParameter(parameter, null, StandardBasicTypes.LONG);
					} catch (Exception e) {
						LOGGER.debug("=======> parametro no encontrado :" + parameter);
					}
				}
			}
			if (tipoDatos == String.class) {

				if (item.getValue() != null) {

					try {
						query.setParameter(parameter, item.getValue());
					} catch (Exception e) {
						LOGGER.debug("=======> parametro no encontrado :" + parameter);
					}
				} else {
					try {
						query.setParameter(parameter, null, StandardBasicTypes.STRING);

					} catch (Exception e) {
						LOGGER.debug("=======> parametro no encontrado :" + parameter);
					}
				}
			}

			if (tipoDatos == Boolean.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.BOOLEAN);
			}
			if (tipoDatos == Date.class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.DATE);
			}

			if (tipoDatos == byte[].class) {
				if (item.getValue() != null)
					query.setParameter(parameter, item.getValue());
				else
					query.setParameter(parameter, null, StandardBasicTypes.BYTE);
			}
		}

		return query;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> listarPorCriterios(Class clazz, Criterion... criterion) {
		Criteria crit = this.getSesionActual().createCriteria(clazz);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> listarPorCriterios(Criterion... criterion) {
		Criteria crit = this.getSesionActual().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> listarPorCriterios(Criteria criteria) {
		return criteria.list();
	}

	@Override
	public String obtenerSentenciaSqlPorQuery(String nombreQuery) {
		if (!validarAlias(nombreQuery))
			return null;

		StringBuffer queryS = new StringBuffer();

		queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());

		return queryS.toString();
	}

	/**
	 * retorna un objeto generico que estaba basado en la consulta sql
	 * 
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar registros
	 * @return Object retorna la informacion dependiendo la sentencia sql
	 */
	@Override
	@Transactional(readOnly = true)
	public Object buscarGenerico(String nombreQuery) {
		if (!validarAlias(nombreQuery))
			return null;

		return buscarGenerico(nombreQuery, null);
	}

	/**
	 * retorna un objeto generico que estaba basado en la consulta sql
	 * 
	 * @param nombreQuery
	 *            representa la sentencia SQL que se utilizara para contar registros
	 * @param parametros
	 *            representa la coleccion de parametros enviados para realizar la
	 *            consulta
	 * @return Object retorna la informacion dependiendo la sentencia sql
	 */
	@Override
	@Transactional(readOnly = true)
	public Object buscarGenerico(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		if (!validarAlias(nombreQuery))
			return null;

		StringBuffer queryS = new StringBuffer();

		queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());

		Query query = this.getSesionActual().createSQLQuery(queryS.toString());

		// parameter
		query = this.getNamedQueryByPatametersSet(query, parametros);

		return query.uniqueResult();
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente, Map parametros) throws Exception {
		Connection conexion = null;
		byte[] bytes2 = null;

		conexion = ((SessionImpl) getSesionActual()).connection();

		LOGGER.debug("conexion :: " + conexion);
		bytes2 = JasperRunManager.runReportToPdf(rutaArchivoReporteFuente, parametros, conexion);

		return bytes2;
	}

	@Override
	public byte[] ejecutarReporteComoPDFDesdeLista(String rutaArchivoReporteFuente, Map parametros, List lista)
			throws JRException {
		Connection conexion = null;
		byte[] bytes2 = null;

		LOGGER.debug("conexion :: " + conexion);
		bytes2 = JasperRunManager.runReportToPdf(rutaArchivoReporteFuente, parametros,
				new JRBeanCollectionDataSource(lista));

		return bytes2;
	}

	@Override
	public String ejecutarReporteComoPDF(Map<String, Object> map, String directorio, String nombreReporte)
			throws Exception {
		String archivoRuta = null;

		String pathPrincipal;
		pathPrincipal = UAplicacion.getRealPath();

		try {

			JasperPrint jasperPrint;

			File archivo = new File(
					pathPrincipal + UFile.getSeparador() + directorio + UFile.getSeparador() + nombreReporte);

			archivoRuta = ejecutarReporteIReport(archivo.getPath(), map);

		} catch (Exception ex) {
			LOGGER.error(ex);
		}

		return archivoRuta;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public String ejecutarReporteIReport(String rutaArchivoReporteFuente, Map parametros) throws Exception {
		String nombreArchivoReporteGenerado = null;
		String rutaCarpetaTemporal = null;
		String nombreArchivoTemporal = null;
		String rutaCarpateServidor = null;
		byte[] reporteGenerado;

		reporteGenerado = this.ejecutarReporteComoPDF(rutaArchivoReporteFuente, parametros);

		LOGGER.debug("generado pdf ..");

		rutaCarpateServidor = UAplicacion.getRealPath() + File.separator + "temporal";
		rutaCarpetaTemporal = rutaCarpateServidor + UFile.getSeparador();
		nombreArchivoTemporal = UFile.archivoUnico() + ".pdf";
		nombreArchivoReporteGenerado = rutaCarpetaTemporal + nombreArchivoTemporal;

		BufferedOutputStream bs = null;
		FileOutputStream fs = new FileOutputStream(new File(nombreArchivoReporteGenerado));
		bs = new BufferedOutputStream(fs);
		bs.write(reporteGenerado);
		bs.close();
		bs = null;

		LOGGER.debug("Archivo PDF: " + nombreArchivoTemporal);

		return nombreArchivoTemporal;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public String ejecutarReporteIReportDesdeLista(String rutaArchivoReporteFuente, Map parametros, List lista)
			throws Exception {
		String nombreArchivoReporteGenerado = null;
		String rutaCarpetaTemporal = null;
		String nombreArchivoTemporal = null;
		String rutaCarpateServidor = null;
		byte[] reporteGenerado;

		reporteGenerado = this.ejecutarReporteComoPDFDesdeLista(rutaArchivoReporteFuente, parametros, lista);

		LOGGER.debug("generado pdf ..");

		rutaCarpateServidor = UAplicacion.getRealPath() + File.separator + "temporal";
		rutaCarpetaTemporal = rutaCarpateServidor + UFile.getSeparador();
		nombreArchivoTemporal = UFile.archivoUnico() + ".pdf";
		nombreArchivoReporteGenerado = rutaCarpetaTemporal + nombreArchivoTemporal;

		BufferedOutputStream bs = null;
		FileOutputStream fs = new FileOutputStream(new File(nombreArchivoReporteGenerado));
		bs = new BufferedOutputStream(fs);
		bs.write(reporteGenerado);
		bs.close();
		bs = null;

		LOGGER.debug("Archivo PDF: " + nombreArchivoTemporal);

		return nombreArchivoTemporal;
	}

	@Override
	public List ejecutarListaSQL(StringBuilder sentenciaSQL) throws Exception {
		Connection conexion = null;
		ResultSet rs = null;
		SessionFactoryImplementor sessionFactory = null;
		List listaResultado = new ArrayList();
		List listaHeader = new ArrayList();
		List listaValores = new ArrayList();
		List listaTabla = new ArrayList();

		try {

			sessionFactory = (SessionFactoryImplementor) this.getSesionActual().getSessionFactory();

			Statement st = this.getConnection().createStatement();

			logger.debug(sentenciaSQL);

			rs = st.executeQuery(sentenciaSQL.toString());

			ResultSetMetaData metaDatos = rs.getMetaData();
			int numeroColumnas = metaDatos.getColumnCount();
			logger.debug("-------------------------");
			for (int i = 0; i < numeroColumnas; i++) {
				logger.debug(metaDatos.getColumnLabel(i + 1).toUpperCase());
				listaHeader.add(metaDatos.getColumnLabel(i + 1).toUpperCase());
			}

			while (rs.next()) {
				listaValores = new ArrayList();
				for (int i = 1; i <= numeroColumnas; i++) {
					listaValores.add(rs.getObject(i));
				}
				listaTabla.add(listaValores);
			}

		} catch (Exception e) {
			logger.error("error:" + e.getMessage());
			logger.error(e.getStackTrace().toString());
			e.printStackTrace();
		}

		listaResultado.add(listaHeader);
		listaResultado.add(listaTabla);
		logger.debug("fin de ejecucion de sentencia sql");
		return listaResultado;
	}

	public BigDecimal incrementarBigDecimal(Criteria cri) {
		List results = cri.list();

		if (results == null)
			return new BigDecimal(1);
		if (results.size() == 0)
			return new BigDecimal(1);

		BigDecimal obj = (BigDecimal) results.get(0);
		if (obj == null)
			return new BigDecimal(1);

		return obj.add(new BigDecimal(1));
	}

	public StreamedContent escribirTxt(String archivo, String texto, String objectoARefrescar) {
		String rutaCarpateServidor = UAplicacion.getRealPath() + File.separator + "temporal";
		String rutaCarpetaTemporal = rutaCarpateServidor + UFile.getSeparador();
		archivo = archivo + ".txt";
		rutaCarpetaTemporal = rutaCarpetaTemporal + archivo;

		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter wr;
		try {
			f = new File(rutaCarpetaTemporal);
			if (!f.exists()) {
				w = new FileWriter(f);
				bw = new BufferedWriter(w);
				wr = new PrintWriter(bw);
				wr.write(texto);
				wr.close();
				bw.close();
			} else {
				f.delete();
				w = new FileWriter(f);
				bw = new BufferedWriter(w);
				wr = new PrintWriter(bw);
				wr.write(texto);
				wr.close();
				bw.close();
			}

			RequestContext.getCurrentInstance().execute(objectoARefrescar);

		} catch (Exception e) {
			System.err.println("No se ha creado el archivo" + e.getMessage());
		}

		return descargarArchivo(archivo);
	}

	public StreamedContent descargarArchivo(String archivo) {
		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/temporal/" + archivo);
		StreamedContent file = new DefaultStreamedContent(stream, "image/jpg", archivo);
		return file;
	}

	/**
	 * 
	 * @param cri
	 * @return Integer
	 */
	public Integer incrementarInteger(Criteria cri) {
		List results = cri.list();

		if (results == null)
			return 1;
		if (results.size() == 0)
			return 1;

		Integer obj = (Integer) results.get(0);
		if (obj == null)
			return 1;

		return obj + 1;
	}

}
