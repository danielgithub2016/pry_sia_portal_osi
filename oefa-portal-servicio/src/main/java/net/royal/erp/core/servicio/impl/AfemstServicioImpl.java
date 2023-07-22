package net.royal.erp.core.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.core.dao.AfemstDao;
import net.royal.erp.core.dominio.Afemst;
import net.royal.erp.core.servicio.AfemstServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAfemst")
public class AfemstServicioImpl extends GenericoServicioImpl implements
		AfemstServicio {

	private AfemstDao dao;

	private static Log LOGGER = LogFactory.getLog(AfemstServicioImpl.class);

	@Autowired
	public void setDao(AfemstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Afemst validarAfe(String afe) {
		return dao.validarAfe(afe);
	}

	@Override
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ac_afe_select_list
	 */
	// XTO
	public ParametroPaginacion DwAcAfeSelectList(
			ParametroPaginacion paginacion, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion) {


		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();
		
		// Llaman el query para el conteo de paginas
		query.append(filtrosListadoDinamicoAfe(paginacion.getParametros(),
				w_afe, iv_companyowner, w_afetype, str_global_gv_userid,
				w_numeroInterno, iv_afesecurity, w_orden, w_descripcion));

		queryContar.append(dao.getSesionActual()
				.getNamedQuery("afemst.DwAcAfeSelectListConteo")
				.getQueryString());

		sentenciaSQL.append(filtrosContarPaginacionAfe(
				paginacion.getParametros(), w_afe, iv_companyowner, w_afetype,
				str_global_gv_userid, w_numeroInterno, iv_afesecurity, w_orden,
				w_descripcion));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), null,
				"afemst.DwAcAfeSelectList", paginacion.getClazz(),
				query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);
		return paginacion;
	}
	
	public String filtrosListadoDinamicoAfe(
			List<ParametroPersistenciaGenerico> parametros, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion) {

		StringBuilder query = new StringBuilder();
		String w_where = " ";
		String w_order = " ";
		String w_group = " ";
		String par_sql = "";
		String par1 = " ";
		String par2 = " ";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("AT")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al TIPO DE PROYECTO(Afetype)");
					
					par1 = " AND (afetype = '" + objParam.getValue() + "') ";
					
					LOGGER.debug(par1);
				}

				if (objParam.getField().equals("NI")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Número Interno (internalnumber)");
					par2 = " AND (InternalNumber = '" + objParam.getValue()
							+ "') ";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");

					switch (iv_afesecurity) {
					case "S":
						LOGGER.debug("No hay companyowner");

						break;
					case "N":
						w_where = w_where + " AND ( companyowner = '"
								+ objParam.getValue() + "') ";

						LOGGER.debug(w_where);
						break;
					default:
						break;
					}

				}

				if (objParam.getField().equals("Afesecurity")) {
					LOGGER.debug("Entra en el listado Principal");

					switch (iv_afesecurity) {
					case "S":
						if (w_orden.equals("C")) {

							if (w_afe.equals(null)) {
								par_sql = " AND "
										+ "( afemst.status = 'A' ) AND "
										+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
										+ "( SY_SeguridadAutorizaciones.Grupo = 'CUENTAS' ) AND "
										+ "( SY_SeguridadAutorizaciones.Usuario = '"
										+ str_global_gv_userid + "' ) ";
							}
							else{
							par_sql = " AND ( afemst.afe >= '"
									+ w_afe
									+ "%' ) AND "
									+ "( afemst.status = 'A' ) AND "
									+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
									+ "( SY_SeguridadAutorizaciones.Grupo = 'CUENTAS' ) AND "
									+ "( SY_SeguridadAutorizaciones.Usuario = '"
									+ str_global_gv_userid + "' ) ";
							}
							w_order = "ORDER BY afemst.afe ASC ";

						} else if (w_orden.equals("D")) {

							if (w_descripcion.equals(null)) {
								w_descripcion = " ";
							}
							
							
							par_sql = " AND ( UPPER(afemst.localname) >= '"
									+ w_descripcion
									+ "%' ) AND "
									+ "( afemst.status = 'A' ) AND "
									+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
									+ "( SY_SeguridadAutorizaciones.Grupo = 'CUENTAS' ) AND "
									+ "( SY_SeguridadAutorizaciones.Usuario = '"
									+ str_global_gv_userid + "' ) ";

							w_order = "ORDER BY afemst.localname ASC ";
						}

						break;

					case "N":

						if (w_orden.equals("C")) {

							if (w_afe.equals(null)) {
								w_afe = " ";
							}
							
							par_sql = " AND ( afemst.afe >= '" + w_afe
									+ "%' ) AND " + "( afemst.status = 'A' ) ";

							w_order = "ORDER BY afemst.afe ASC ";

						} else if (w_orden.equals("D")) {
							
							if (w_descripcion.equals(null)) {
								w_descripcion = " ";
							}
							
							par_sql = " AND ( UPPER(afemst.localname) >= '"
									+ w_descripcion + "%' ) AND "
									+ "( afemst.status = 'A' ) ";

							w_order = "ORDER BY afemst.localname ASC ";
						}

					default:
						break;
					}

				}
			}
		}

		// **************************************************** // Si Existe
		// el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");
		}

		// **************************************************** // Si Existe
		// el Order By, se lo añadimos antes...
		// ****************************************************
		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");
			par_sql = par_sql + par1 + par2 + w_where + w_order;
		} else {
			par_sql = par_sql + par1 + par2 + w_where;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		par2 = " ";
		w_where = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();

	}

	public String filtrosContarPaginacionAfe(
			List<ParametroPersistenciaGenerico> parametros, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion) {

		StringBuilder query = new StringBuilder();
		String w_where = " ";
		String w_order = " ";
		String w_group = " ";
		String par_sql = "";
		String par1 = " ";
		String par2 = " ";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("AT")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al TIPO DE PROYECTO(Afetype)");
					
					par1 = " AND (afetype = '" + objParam.getValue() + "') ";
					
					LOGGER.debug(par1);
				}

				if (objParam.getField().equals("NI")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Número Interno (internalnumber)");
					par2 = " AND (InternalNumber = '" + objParam.getValue()
							+ "') ";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");

					switch (iv_afesecurity) {
					case "S":
						LOGGER.debug("No hay companyowner");

						break;
					case "N":
						w_where = w_where + " AND ( companyowner = '"
								+ objParam.getValue() + "') ";

						LOGGER.debug(w_where);
						break;
					default:
						break;
					}

				}

				if (objParam.getField().equals("Afesecurity")) {
					LOGGER.debug("Entra en el listado Principal");

					switch (iv_afesecurity) {
					case "S":
						if (w_orden.equals("C")) {

							if (w_afe.equals(null)) {
								par_sql = " AND "
										+ "( afemst.status = 'A' ) AND "
										+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
										+ "( SY_SeguridadAutorizaciones.Grupo = 'CUENTAS' ) AND "
										+ "( SY_SeguridadAutorizaciones.Usuario = '"
										+ str_global_gv_userid + "' ) ";
							}
							else{
							par_sql = " AND ( afemst.afe >= '"
									+ w_afe
									+ "%' ) AND "
									+ "( afemst.status = 'A' ) AND "
									+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
									+ "( SY_SeguridadAutorizaciones.Grupo = 'CUENTAS' ) AND "
									+ "( SY_SeguridadAutorizaciones.Usuario = '"
									+ str_global_gv_userid + "' ) ";
							}
							w_order = "ORDER BY afemst.afe ASC ";

						} else if (w_orden.equals("D")) {

							if (w_descripcion.equals(null)) {
								w_descripcion = " ";
							}
							
							
							par_sql = " AND ( UPPER(afemst.localname) >= '"
									+ w_descripcion
									+ "%' ) AND "
									+ "( afemst.status = 'A' ) AND "
									+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
									+ "( SY_SeguridadAutorizaciones.Grupo = 'CUENTAS' ) AND "
									+ "( SY_SeguridadAutorizaciones.Usuario = '"
									+ str_global_gv_userid + "' ) ";

							w_order = "ORDER BY afemst.localname ASC ";
						}

						break;

					case "N":

						if (w_orden.equals("C")) {

							if (w_afe.equals(null)) {
								w_afe = " ";
							}
							
							par_sql = " AND ( afemst.afe >= '" + w_afe
									+ "%' ) AND " + "( afemst.status = 'A' ) ";

							w_order = "ORDER BY afemst.afe ASC ";

						} else if (w_orden.equals("D")) {
							
							if (w_descripcion.equals(null)) {
								w_descripcion = " ";
							}
							
							par_sql = " AND ( UPPER(afemst.localname) >= '"
									+ w_descripcion + "%' ) AND "
									+ "( afemst.status = 'A' ) ";

							w_order = "ORDER BY afemst.localname ASC ";
						}

					default:
						break;
					}

				}
			}
		}

		// **************************************************** // Si Existe
		// el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");
		}

		// **************************************************** // Si Existe
		// el Order By, se lo añadimos antes...
		// ****************************************************
		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");
			par_sql = par_sql + par1 + par2 + w_where + w_order;
		} else {
			par_sql = par_sql + par1 + par2 + w_where;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		par2 = " ";
		w_where = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}

	@Override
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ac_afe_select_security_list
	 */
	// XTO
	public ParametroPaginacion DwAcAfeSelectSecurityList(
			ParametroPaginacion paginacion, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion) {

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();

		// Llaman el query para el conteo de paginas
		query.append(filtrosListadoDinamicoAfe(paginacion.getParametros(),
				w_afe, iv_companyowner, w_afetype, str_global_gv_userid,
				w_numeroInterno, iv_afesecurity, w_orden, w_descripcion));

		queryContar.append(dao.getSesionActual()
				.getNamedQuery("afemst.DwAcAfeSelectSecurityListConteo")
				.getQueryString());

		sentenciaSQL.append(filtrosContarPaginacionAfe(
				paginacion.getParametros(), w_afe, iv_companyowner, w_afetype,
				str_global_gv_userid, w_numeroInterno, iv_afesecurity, w_orden,
				w_descripcion));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), null,
				"afemst.DwAcAfeSelectSecurityList", paginacion.getClazz(),
				query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}



}
