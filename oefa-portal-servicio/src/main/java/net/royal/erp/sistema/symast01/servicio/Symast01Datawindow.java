package net.royal.erp.sistema.symast01.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.sistema.dominio.dto.DtoDsSySecurityResponsable;
import net.royal.erp.sistema.dominio.dto.DtoDwAcCashflowSelectList;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

@Service(value = "BeanServicioSymast01Datawindow")
public class Symast01Datawindow {

	private static Log LOGGER = LogFactory.getLog(Symast01Datawindow.class);
	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.ds_sy_security_responsable
	 */
	public List DsSySecurityResponsable(BigDecimal vendor, String usertype) {
		LOGGER.debug("test de symast01.ds_sy_security_responsable");
		LOGGER.debug(" usar el siguiente dto :  DtoDsSySecurityResponsable");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DsSySecurityResponsable");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_vendor",
				BigDecimal.class, vendor));
		filtros.add(new ParametroPersistenciaGenerico("p_usertype",
				String.class, usertype));

		List data = dao.listarPorQuery(DtoDsSySecurityResponsable.class,
				"symast01.DsSySecurityResponsable", filtros);

		return data;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ac_afe_select_list_by_company
	 */
	// XTO
	public ParametroPaginacion DwAcAfeSelectListByCompany(
			ParametroPaginacion paginacion, String w_afe,
			String iv_companyowner, String w_afetype,
			String str_global_gv_userid, String w_numeroInterno,
			String iv_afesecurity, String w_orden, String w_descripcion) {
		LOGGER.debug("test de symast01.dw_ac_afe_select_list_by_company");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAcAfeSelectListByCompany");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DwAcAfeSelectListByCompany");

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();

		// Llaman el query para el conteo de paginas
		query.append(filtrosListadoDinamicoAfeDinamico(
				paginacion.getParametros(), w_afe, iv_companyowner, w_afetype,
				str_global_gv_userid, w_numeroInterno, iv_afesecurity, w_orden,
				w_descripcion));

		queryContar.append(dao.getSesionActual()
				.getNamedQuery("symast01.DwAcAfeSelectListByCompanyConteo")
				.getQueryString());

		sentenciaSQL.append(filtrosContarPaginacionAfeDinamico(
				paginacion.getParametros(), w_afe, iv_companyowner, w_afetype,
				str_global_gv_userid, w_numeroInterno, iv_afesecurity, w_orden,
				w_descripcion));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), null,
				"symast01.DwAcAfeSelectListByCompany", paginacion.getClazz(),
				query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

	public String filtrosListadoDinamicoAfeDinamico(
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

					LOGGER.debug(w_where);
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

					w_where = w_where + " AND ( AC_AfeCompany.CompanyOwner = '"
							+ objParam.getValue() + "') ";

					LOGGER.debug(w_where);

				}

				if (objParam.getField().equals("Afesecurity")) {
					LOGGER.debug("Entra en el listado Principal");

					if (w_orden.equals("C")) {

						par_sql = " AND ( afemst.afe >= '" + w_afe + "' ) AND "
								+ "( afemst.status = 'A' ) ";

						w_order = "ORDER BY afemst.afe ASC ";

					} else if (w_orden.equals("D")) {

						par_sql = " AND ( UPPER(afemst.localname) >= '"
								+ w_descripcion + "' ) AND "
								+ "( afemst.status = 'A' ) ";

						w_order = "ORDER BY afemst.localname ASC ";
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

	public String filtrosContarPaginacionAfeDinamico(
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

					LOGGER.debug(w_where);
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

					w_where = w_where + " AND ( AC_AfeCompany.CompanyOwner = '"
							+ objParam.getValue() + "') ";

					LOGGER.debug(w_where);

				}

				if (objParam.getField().equals("Afesecurity")) {
					LOGGER.debug("Entra en el listado Principal");

					if (w_orden.equals("C")) {

						par_sql = " AND ( afemst.afe >= '" + w_afe + "' ) AND "
								+ "( afemst.status = 'A' ) ";

						w_order = "ORDER BY afemst.afe ASC ";

					} else if (w_orden.equals("D")) {

						par_sql = " AND ( UPPER(afemst.localname) >= '"
								+ w_descripcion + "' ) AND "
								+ "( afemst.status = 'A' ) ";

						w_order = "ORDER BY afemst.localname ASC ";
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


	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ac_cashflow_select_list
	 */
	
	public ParametroPaginacion DwAcCashflowSelectList(
			ParametroPaginacion paginacion) {
		LOGGER.debug("test de symast01.dw_ac_cashflow_select_list");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAcCashflowSelectList");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DwAcCashflowSelectList");

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();

		query.append(filtrosListadoCashflow(paginacion.getParametros()));

		queryContar.append(dao.getSesionActual()
				.getNamedQuery("symast01.DwAcCashflowSelectContar")
				.getQueryString());

		sentenciaSQL.append(filtrosContarCashflow(paginacion.getParametros()));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);
		LOGGER.debug("ESTOS SON LOS REGISTROS: " + registros);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), null,
				"symast01.DwAcCashflowSelectList", paginacion.getClazz(),
				query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);
		return paginacion;

	}

	public String filtrosListadoCashflow(
			List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("estado")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a estado");
					query.append(" and AC_CashFlowGroup.cashflowgroup = 22 ");
				}

			}

		}

		LOGGER.debug("QUERY::" + query.toString());
		return query.toString();
	}

	public String filtrosContarCashflow(
			List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("estado")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a estado");
					query.append(" and AC_CashFlowGroup.cashflowgroup = 22 ");
				}

			}

		}

		LOGGER.debug("QUERY::" + query.toString());
		return query.toString();
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ac_cashflow_select_position
	 */
	public String DwAcCashflowSelectPosition() {
		LOGGER.debug("test de symast01.dw_ac_cashflow_select_position");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAcCashflowSelectPosition");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DwAcCashflowSelectPosition");
		
		StringBuilder sb = new StringBuilder();
		sb.append(dao.obtenerSentenciaSqlPorQuery("symast01.DwAcCashflowSelectPosition"));
		
		return sb.toString();
	}

	
	public List obtenerLista(String w_where){
		StringBuilder sb= new StringBuilder(w_where);
		List datos;
		
		datos = dao.listarPorSentenciaSQL(DtoDwAcCashflowSelectList.class, sb /*sb1*/, null);

		return datos;
	}
	
	public List obtenerListaFiltrada(String w_where, String filtro, String orden){
		StringBuilder sb= new StringBuilder(w_where);
		sb.append(" AND "+filtro);
		List datos;
		sb.append(" ORDER BY CG.CASHFLOWMAJOR ASC, CG.CASHFLOWGROUP ASC, CM.CASHFLOWCODE ASC");
		if(orden.equals("C")){
			sb.append(" ,CM.CASHFLOWCODE ASC ");
		}else {
			sb.append(" ,CJ.LOCALNAME ASC ");
		}
		datos = dao.listarPorSentenciaSQL(DtoDwAcCashflowSelectList.class, sb, null);

		return datos;
	}
	
}
