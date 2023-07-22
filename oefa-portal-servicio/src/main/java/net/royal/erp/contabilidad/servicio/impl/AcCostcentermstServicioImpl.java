package net.royal.erp.contabilidad.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.contabilidad.dao.AcCostcentermstDao;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.dto.DtoAcCostcentermst;
import net.royal.erp.contabilidad.servicio.AcCostcentermstServicio;
import net.royal.erp.core.dao.PrimemstDao;
import net.royal.erp.core.dominio.Primemst;
import net.royal.erp.sistema.dominio.dto.DtoDwMaAcCostcenterSelectMaster;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAcCostcentermst")
public class AcCostcentermstServicioImpl extends GenericoServicioImpl implements AcCostcentermstServicio {

	private AcCostcentermstDao dao;
	private PrimemstDao daoPrimemst;

	private static Log LOGGER = LogFactory.getLog(AcCostcentermstServicioImpl.class);

	@Autowired
	public void setDao(AcCostcentermstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setDaoPrimemst(PrimemstDao daoPrimemst) {
		this.daoPrimemst = daoPrimemst;
	}

	public List<AcCostcentermst> listaComboCentroCosto() {
		return dao.listaComboCentroCosto();
	}

	@Override
	public String obtenerCentroCosto(String par_costcenter) {
		return dao.obtenerCentroCosto(par_costcenter);
	}

	@Override
	public AcCostcentermst obtenerListCentroCosto(String par_costcenter) {
		return dao.obtenerListCentroCosto(par_costcenter);
	}

	@Override
	public List DwMaAcCostcenterSelectValida(Integer tabActivo) {
		List lstData = null;
		switch (tabActivo) {
		case 0:

			lstData = dao.listarPorQuery(DtoDwMaAcCostcenterSelectMaster.class,
					"accostcentermst.DwMaAcCostcenterSelectMaster");

			break;
		case 1:
			lstData = dao.listarPorQuery(DtoDwMaAcCostcenterSelectMaster.class,
					"accostcentermst.DwMaAcCostcenterSelectSupervisor");

			break;
		case 2:
			lstData = dao.listarPorQuery(DtoDwMaAcCostcenterSelectMaster.class,
					"accostcentermst.DwMaAcCostcenterSelectXpersona");

			break;

		default:
			break;
		}

		return lstData;
	}

	@Override
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ma_ac_costcenter_select_master
	 */
	// XTO
	@SuppressWarnings("rawtypes")
	public ParametroPaginacion DwMaAcCostcenterSelectMaster(ParametroPaginacion paginacion, Integer tabActivo,
			String w_supervisorflag, String w_buscarflag, String str_global_gv_value_selected) {
		LOGGER.debug("test de symast01.dw_ma_ac_costcenter_select_master");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaAcCostcenterSelectMaster");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DwMaAcCostcenterSelectMaster");

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();
		String q1 = "";

		// Llaman el query para el conteo de paginas

		switch (tabActivo) {
		case 0:
			query.append(filtrosListadoDinamicoCostcenter(paginacion.getParametros()));

			queryContar.append(dao.getSesionActual().getNamedQuery("accostcentermst.DwMaAcCostcenterSelectMasterContar")
					.getQueryString());

			// filtros para la paginacion
			sentenciaSQL.append(filtrosContarPaginacionCostcenter(paginacion.getParametros()));

			q1 = "accostcentermst.DwMaAcCostcenterSelectMaster";

			break;
		case 1:
			query.append(
					filtrosListadoDinamicoCostcenterTab2(paginacion.getParametros(), w_buscarflag, w_supervisorflag));

			queryContar.append(dao.getSesionActual()
					.getNamedQuery("accostcentermst.DwMaAcCostcenterSelectSupervisorContar").getQueryString());

			// filtros para la paginacion
			sentenciaSQL.append(
					filtrosContarPaginacionCostcenterTab2(paginacion.getParametros(), w_buscarflag, w_supervisorflag));

			q1 = "accostcentermst.DwMaAcCostcenterSelectSupervisor";

			break;
		case 2:

			if (!UValidador.esNulo(str_global_gv_value_selected)) {

				query.append(
						filtrosListadoDinamicoCostcenterTab3(paginacion.getParametros(), str_global_gv_value_selected));

				queryContar.append(dao.getSesionActual()
						.getNamedQuery("accostcentermst.DwMaAcCostcenterSelectXpersonaContar").getQueryString());

				// filtros para la paginacion
				sentenciaSQL.append(filtrosContarPaginacionCostcenterTab3(paginacion.getParametros(),
						str_global_gv_value_selected));

				q1 = "accostcentermst.DwMaAcCostcenterSelectXpersona";
			} else {

				query.append(filtrosListadoDinamicoCostcenterTab3(paginacion.getParametros(), null));

				queryContar.append(dao.getSesionActual()
						.getNamedQuery("accostcentermst.DwMaAcCostcenterSelectXpersonaContar").getQueryString());

				// filtros para la paginacion
				sentenciaSQL.append(filtrosContarPaginacionCostcenterTab3(paginacion.getParametros(), null));

				q1 = "accostcentermst.DwMaAcCostcenterSelectXpersona";
			}

			break;

		default:
			break;
		}

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), null, q1, paginacion.getClazz(),
				query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);
		return paginacion;

	}

	public String filtrosListadoDinamicoCostcenter(List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";
		String par1 = "";
		String par2 = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("C") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = w_where + "AND AC_CostCenterMst.CostCenter like '" + objParam.getValue() + "'";

					par2 = par2 + " ORDER BY AC_CostCenterMst.LocalName ASC";
					LOGGER.debug(w_where);
					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("D") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = w_where + "AND UPPER(AC_CostCenterMst.LocalName) like '" + objParam.getValue() + "'";

					par2 = par2 + " ORDER BY AC_CostCenterMst.LocalName ASC";
					LOGGER.debug(w_where);
					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");
					w_where = w_where + " AND (AC_CostCenterMst.MultiCompanyFlag = 'S' "
							+ " OR Exists (SELECT 1 FROM SGCORESYS.AC_CostCenterCompany "
							+ " WHERE AC_CostCenterMst.CostCenter = AC_CostCenterCompany.CostCenter "
							+ " AND AC_CostCenterCompany.CompanyOwner = '" + objParam.getValue() + "' ) ) ";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Autorizados")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Entra en CC Autorizados");

					par1 = par1 + " AND ( AC_CostCenterMst.Status = 'A' ) AND "
							+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
							+ "( SY_SeguridadAutorizaciones.Grupo = 'CENTROCOSTOS') and "
							+ "( UPPER(SY_SeguridadAutorizaciones.Usuario) = '" + objParam.getValue() + "') ";

					// par_sql = par1 + par2;
				}

			}

		}

		// **************************************************** // Si Existe
		// el Group By, se lo añadimos antes...
		// ****************************************************

		String w_groupbyposition = "GROUP BY";
		LOGGER.debug(w_groupbyposition.indexOf(par_sql));
		if (w_groupbyposition.indexOf(par_sql) > -1) {
			LOGGER.debug("Hay GROUP BY");

		}
		// **************************************************** // Si Existe
		// el Order By, se lo añadimos antes...
		// ****************************************************
		String w_orderbyposition = "ORDER BY";

		LOGGER.debug(w_orderbyposition.indexOf(par_sql));
		if (w_orderbyposition.indexOf(par_sql) > -1) {
			LOGGER.debug("Hay ORDER BY");
			par_sql = " ";
			par_sql = par1 + w_where + par2;
		}

		par_sql = " ";
		par_sql = par1 + w_where + par2;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());
		par1 = " ";
		return query.toString();
	}

	public String filtrosContarPaginacionCostcenter(List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("C") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = w_where + "AND AC_CostCenterMst.CostCenter like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("D") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = w_where + "AND UPPER(AC_CostCenterMst.LocalName) like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");
					w_where = w_where + " AND (AC_CostCenterMst.MultiCompanyFlag = 'S' "
							+ " OR Exists (SELECT 1 FROM SGCORESYS.AC_CostCenterCompany "
							+ " WHERE AC_CostCenterMst.CostCenter = AC_CostCenterCompany.CostCenter "
							+ " AND AC_CostCenterCompany.CompanyOwner = '" + objParam.getValue() + "' ) ) ";

					LOGGER.debug(w_where);
				}

				// Comparacion de listados por pestañas
				if (objParam.getField().equals("Autorizados")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Entra en CC Autorizados");

					par_sql = par_sql + " AND ( AC_CostCenterMst.Status = 'A' ) AND "
							+ "( SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' ) AND "
							+ "( SY_SeguridadAutorizaciones.Grupo = 'CENTROCOSTOS') and "
							+ "( SY_SeguridadAutorizaciones.Usuario = '" + objParam.getValue() + "') ";

				}

			}
		}

		par_sql = par_sql + w_where;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());
		par_sql = "";

		return query.toString();

	}

	public String filtrosListadoDinamicoCostcenterTab2(List<ParametroPersistenciaGenerico> parametros,
			String w_buscarflag, String w_supervisorflag) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";
		String par1 = "";
		String par2 = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("C") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = w_where + "AND AC_CostCenterMst.CostCenter like '" + objParam.getValue() + "'";

					par2 = par2 + " ORDER BY AC_CostCenterMst.LocalName ASC";
					LOGGER.debug(w_where);
					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("D") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = w_where + "AND UPPER(AC_CostCenterMst.LocalName) like '" + objParam.getValue() + "'";

					par2 = par2 + " ORDER BY AC_CostCenterMst.LocalName ASC";
					LOGGER.debug(w_where);
					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");
					w_where = w_where + " AND (AC_CostCenterMst.MultiCompanyFlag = 'S' "
							+ " OR Exists (SELECT 1 FROM SGCORESYS.AC_CostCenterCompany "
							+ " WHERE AC_CostCenterMst.CostCenter = AC_CostCenterCompany.CostCenter "
							+ " AND AC_CostCenterCompany.CompanyOwner = '" + objParam.getValue() + "' ) ) ";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Supervisados")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {

					LOGGER.debug("Entra en CC Supervisados");

					LOGGER.debug(w_supervisorflag);
					LOGGER.debug(w_buscarflag);
					LOGGER.debug(objParam.getValue());

					par1 = par1 + " AND ( AC_CostCenterMst.Status = 'A' ) AND " + "(AC_CostCenterMst.Vendor = "
							+ objParam.getValue() + " OR '" + w_supervisorflag + "' =  'S') ";

				}

			}

		}

		// **************************************************** // Si Existe
		// el Group By, se lo añadimos antes...
		// ****************************************************

		String w_groupbyposition = "GROUP BY";
		LOGGER.debug(w_groupbyposition.indexOf(par_sql));
		if (w_groupbyposition.indexOf(par_sql) > -1) {
			LOGGER.debug("Hay GROUP BY");

		}
		// **************************************************** // Si Existe
		// el Order By, se lo añadimos antes...
		// ****************************************************
		String w_orderbyposition = "ORDER BY";

		LOGGER.debug(w_orderbyposition.indexOf(par_sql));
		if (w_orderbyposition.indexOf(par_sql) > -1) {
			LOGGER.debug("Hay ORDER BY");
			par_sql = " ";
			par_sql = par1 + w_where + par2;
		}

		par_sql = " ";
		par_sql = par1 + w_where + par2;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());
		par1 = " ";
		return query.toString();
	}

	public String filtrosContarPaginacionCostcenterTab2(List<ParametroPersistenciaGenerico> parametros,
			String w_buscarflag, String w_supervisorflag) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("C") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = w_where + "AND AC_CostCenterMst.CostCenter like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("D") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = w_where + "AND UPPER(AC_CostCenterMst.LocalName) like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");
					w_where = w_where + " AND (AC_CostCenterMst.MultiCompanyFlag = 'S' "
							+ " OR Exists (SELECT 1 FROM SGCORESYS.AC_CostCenterCompany "
							+ " WHERE AC_CostCenterMst.CostCenter = AC_CostCenterCompany.CostCenter "
							+ " AND AC_CostCenterCompany.CompanyOwner = '" + objParam.getValue() + "' ) ) ";

					LOGGER.debug(w_where);
				}

				// Comparacion de listados por pestañas

				if (objParam.getField().equals("Supervisados")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Entra en CC Supervisados");

					par_sql = par_sql + " AND ( AC_CostCenterMst.Status = 'A' ) AND " + "(AC_CostCenterMst.Vendor = "
							+ objParam.getValue() + " OR  '" + w_supervisorflag + "' =  'S') ";

				}
			}
		}

		par_sql = par_sql + w_where;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());
		par_sql = "";

		return query.toString();

	}

	public String filtrosListadoDinamicoCostcenterTab3(List<ParametroPersistenciaGenerico> parametros,
			String str_global_gv_value_selected) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";
		String par2 = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("C") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = w_where + "AND AC_CostCenterMst.CostCenter like '" + objParam.getValue() + "'";

					par2 = par2 + " ORDER BY AC_CostCenterMst.LocalName ASC";
					LOGGER.debug(w_where);
					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("D") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = w_where + "AND UPPER(AC_CostCenterMst.LocalName) like '" + objParam.getValue() + "'";

					par2 = par2 + " ORDER BY AC_CostCenterMst.LocalName ASC";
					LOGGER.debug(w_where);
					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");
					w_where = w_where + " AND (AC_CostCenterMst.MultiCompanyFlag = 'S' "
							+ " OR Exists (SELECT 1 FROM SGCORESYS.AC_CostCenterCompany "
							+ " WHERE AC_CostCenterMst.CostCenter = AC_CostCenterCompany.CostCenter "
							+ " AND AC_CostCenterCompany.CompanyOwner = '" + objParam.getValue() + "' ) ) ";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Empleados") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Entra en CC Empleados");

					if (!UValidador.esNulo(str_global_gv_value_selected)) {

						switch (str_global_gv_value_selected) {
						case "REVIEW":
							LOGGER.debug("Bienvenido a REVIEW");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) "
									+ " And MA_PersonaCentroCostoAutorizac.RevisionFlag = 'S'";
							LOGGER.debug(par_sql);

							break;
						case "LIST":
							LOGGER.debug("Bienvenido a LIST");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) ";

							break;
						case "APPROVE":
							LOGGER.debug("Bienvenido a APPROVE");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) "
									+ " And MA_PersonaCentroCostoAutorizac.AprobacionFlag = 'S'";

							break;
						case "ADD":
							LOGGER.debug("Bienvenido a ADD");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) "
									+ " And MA_PersonaCentroCostoAutorizac.PreparacionFlag = 'S'";

							break;
						default:
							break;

						}

					} else {
						par_sql = par_sql

								+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
								+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) ";

					}

				}

			}

		}

		// **************************************************** // Si Existe
		// el Group By, se lo añadimos antes...
		// ****************************************************

		String w_groupbyposition = "GROUP BY";
		LOGGER.debug(w_groupbyposition.indexOf(par_sql));
		if (w_groupbyposition.indexOf(par_sql) > -1) {
			LOGGER.debug("Hay GROUP BY");

		}
		// **************************************************** // Si Existe
		// el Order By, se lo añadimos antes...
		// ****************************************************
		String w_orderbyposition = "ORDER BY";

		LOGGER.debug(w_orderbyposition.indexOf(par_sql));
		if (w_orderbyposition.indexOf(par_sql) > -1) {
			LOGGER.debug("Hay ORDER BY");
			par_sql = " ";
			par_sql = w_where + par2;
		}

		par_sql = par_sql + w_where + par2;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}

	public String filtrosContarPaginacionCostcenterTab3(List<ParametroPersistenciaGenerico> parametros,
			String str_global_gv_value_selected) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("C") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = w_where + "AND AC_CostCenterMst.CostCenter like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("D") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = w_where + "AND UPPER(AC_CostCenterMst.LocalName) like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("companyowner")
						&& !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a companyowner");
					w_where = w_where + " AND (AC_CostCenterMst.MultiCompanyFlag = 'S' "
							+ " OR Exists (SELECT 1 FROM SGCORESYS.AC_CostCenterCompany "
							+ " WHERE AC_CostCenterMst.CostCenter = AC_CostCenterCompany.CostCenter "
							+ " AND AC_CostCenterCompany.CompanyOwner = '" + objParam.getValue() + "' ) ) ";

					LOGGER.debug(w_where);
				}

				// Comparacion de listados por pestañas

				if (objParam.getField().equals("Empleados") && !UValidador.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Entra en CC Empleados");

					if (!UValidador.esNulo(str_global_gv_value_selected)) {

						switch (str_global_gv_value_selected) {
						case "REVIEW":
							LOGGER.debug("Bienvenido a REVIEW");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) "
									+ " And MA_PersonaCentroCostoAutorizac.RevisionFlag = 'S'";
							LOGGER.debug(par_sql);

							break;
						case "LIST":
							LOGGER.debug("Bienvenido a LIST");

							break;
						case "APPROVE":
							LOGGER.debug("Bienvenido a APPROVE");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) "
									+ " And MA_PersonaCentroCostoAutorizac.AprobacionFlag = 'S'";

							break;
						case "ADD":
							LOGGER.debug("Bienvenido a ADD");

							par_sql = par_sql

									+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
									+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) "
									+ " And MA_PersonaCentroCostoAutorizac.PreparacionFlag = 'S'";

							break;
						default:
							break;

						}

					} else {
						par_sql = par_sql

								+ " AND ( MA_PersonaCentroCostoAutorizac.AplicacionCodigo = 'WH') AND  "
								+ "( MA_PersonaCentroCostoAutorizac.Persona = " + objParam.getValue() + " ) ";

					}

				}
			}
		}

		par_sql = par_sql + w_where;
		query.append(par_sql);

		if (query.length() < 0) {
			LOGGER.debug("QUERY::" + query.toString());
			par_sql = "";
		}
		return query.toString();

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder accostcentermst.dw_ma_ac_costcenter_select_supervisor
	 */
	@Override
	public ParametroPaginacion DwMaAcCostcenterSelectSupervisor(ParametroPaginacion paginacion) {

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();

		
		query.append(filtrosListadoDinamicoCostcenter(paginacion.getParametros()));

		// Llaman el query para el conteo de paginas
		queryContar.append(dao.getSesionActual().getNamedQuery("accostcentermst.DwMaAcCostcenterSelectSupervisorContar")
				.getQueryString());

		// filtros para la paginacion
		sentenciaSQL.append(filtrosContarPaginacionCostcenter(paginacion.getParametros()));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), null,
				"accostcentermst.DwMaAcCostcenterSelectSupervisor", paginacion.getClazz(), query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilaccostcentermstst01.dw_ma_ac_costcenter_select_xpersona
	 */
	@Override
	public ParametroPaginacion DwMaAcCostcenterSelectXpersona(ParametroPaginacion paginacion) {

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();

		query.append(filtrosListadoDinamicoCostcenter(paginacion.getParametros()));

		// Llaman el query para el conteo de paginas
		queryContar.append(dao.getSesionActual().getNamedQuery("accostcentermst.DwMaAcCostcenterSelectXpersonaContar")
				.getQueryString());

		// filtros para la paginacion
		sentenciaSQL.append(filtrosContarPaginacionCostcenter(paginacion.getParametros()));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(), paginacion.getRegistrosPorPagina(),
				paginacion.getCampoOrden(), paginacion.getDireccionOrden(), null,
				"accostcentermst.DwMaAcCostcenterSelectXpersona", paginacion.getClazz(), query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);

		return paginacion;
	}

	@Override
	public List<DtoAcCostcentermst> listaPorPlanillaTipo(String tipo) {
		List<DtoAcCostcentermst> res = new ArrayList<DtoAcCostcentermst>();
		if (!UValidador.estaVacio(tipo)) {
			if ("C".equals(tipo)) {
				List<AcCostcentermst> accostcentermsts = dao
						.listarPorCriterios(dao.getCriteria().add(Restrictions.eq("status", "A")));
				for (AcCostcentermst acc : accostcentermsts) {
					DtoAcCostcentermst obj = new DtoAcCostcentermst();
					obj.setCostcenter(acc.getPk().getCostcenter());
					obj.setLocalname(acc.getLocalname());
					res.add(obj);
				}
			} else if ("P".equals(tipo)) {
				List<Primemst> primemsts = daoPrimemst.listarPorCriterios(daoPrimemst.getCriteria());
				for (Primemst prime : primemsts) {
					DtoAcCostcentermst obj = new DtoAcCostcentermst();
					obj.setCostcenter(prime.getPk().getPrime());
					obj.setLocalname(prime.getLocalname());
					res.add(obj);
				}
			}
		}
		return res;
	}

}
