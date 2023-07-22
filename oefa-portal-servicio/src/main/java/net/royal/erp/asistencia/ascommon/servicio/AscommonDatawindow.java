package net.royal.erp.asistencia.ascommon.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.ascommon.dominio.dto.DtoDwAsEventoUseridActivo;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAscommonDatawindow")
public class AscommonDatawindow {

	private static Log LOGGER = LogFactory.getLog(AscommonFuncion.class);
	private ComunDao dao;
	private String tipo;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	public List<DtoFiltrosGenericos> DwFiltrosGenericos(
			List<ParametroPersistenciaGenerico> parametros, String tipo) {
		LOGGER.debug("test de symast01.dw_ma_ac_costcenter_select_master");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaAcCostcenterSelectMaster");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DwMaAcCostcenterSelectMaster");

		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();
		String q1 = "";
		this.tipo = tipo;

		// Llaman el query para el conteo de paginas

		List<ParametroPersistenciaGenerico> parametrosPeticion = new ArrayList<>();

		switch (tipo) {

		case "compania":
			parametrosPeticion = parametros;

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosCompania";
			break;

		case "costos":

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosCostos";

			break;

		case "sucursal":

			parametrosPeticion = parametros;

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosOficina";

			break;

		case "categoria":

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosCategoria";

			break;

		case "planilla":

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosPlanilla";

			break;

		case "operaria":

			parametrosPeticion = parametros;

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosAreaOperaria";

			break;

		case "inactivos":

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosInactivos";

			break;

		case "puestos":

			query.append(filtrosListadoDinamicofiltros(parametros));

			q1 = "ascommon.DwFiltrosPuesto";

		default:
			break;
		}

		sentenciaSQLCompleto.append(dao.obtenerSentenciaSqlPorQuery(q1));
		sentenciaSQLCompleto.append(query);
		lstResultado = dao.listarPorSentenciaSQL(DtoFiltrosGenericos.class,
				sentenciaSQLCompleto, parametrosPeticion);
		return lstResultado;

	}

	public String filtrosContarPaginacionfiltros(
			List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";
		String par1 = "";
		String par2 = "";

		if (!UValidador.estaVacio(this.tipo)) {
			if (!this.tipo.equals("operaria") && !this.tipo.equals("compania")
					&& !this.tipo.equals("sucursal")) {
				query.append(" WHERE 1=1 ");
			}
		}

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("Ccompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY  " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ncompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY  " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}
				if (objParam.getField().equals("Ccostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY  " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ncostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Coficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY sucursal ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Noficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY sucursal ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ccategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY  " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ncategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Cplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY  " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Nplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Coperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY  " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Noperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}
				if (objParam.getField().equals("Cinactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ninactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Cpuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Npuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Codcompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND UPPER(COMPANYOWNER) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Descompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND UPPER(DESCRIPTION) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codcostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND status = 'A' AND UPPER(COSTCENTER) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Descostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND status = 'A' AND UPPER(LOCALNAME) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}
				if (objParam.getField().equals("Codoficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND UPPER(SUCURSAL) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desoficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND UPPER(DESCRIPCIONLOCAL) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codcategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND UPPER(CARGO) like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Descategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND UPPER(DESCRIPCIONLOCAL) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND UPPER(TIPOPLANILLA) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(DESCRIPCION) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codoperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND UPPER(AREA) like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desoperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(NOMBRE) like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codinactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = " AND status = 'I' AND UPPER(COSTCENTER) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desinactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "  AND status = 'I' AND UPPER(LOCALNAME) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codpuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND UPPER(CODIGOPUESTO) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Despuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(DESCRIPCION) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}
			}

		}

		par_sql = " ";
		par_sql = w_where + par2;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());
		par1 = " ";
		return query.toString();

	}

	public String filtrosListadoDinamicofiltros(
			List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();
		String w_where = "";
		String par_sql = "";
		String par1 = "";
		String par2 = "";

		if (!UValidador.estaVacio(this.tipo)) {
			if (!this.tipo.equals("operaria") && !this.tipo.equals("compania")
					&& !this.tipo.equals("sucursal")) {
				query.append(" WHERE 1=1 ");
			}
		}

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("Ccompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ncompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}
				if (objParam.getField().equals("Ccostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY COSTCENTER ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ncostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY COSTCENTER ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Coficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY sucursal ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Noficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY sucursal ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ccategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ncategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Cplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Nplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Coperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Noperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}
				if (objParam.getField().equals("Cinactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Ninactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Cpuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Codigo");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Npuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Ordena por Nombre");

					par2 = " ORDER BY " + objParam.getValue() + " ";

					LOGGER.debug(par2);
				}

				if (objParam.getField().equals("Codcompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND COMPANYOWNER like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Descompania")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND UPPER(DESCRIPTION) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codcostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = " AND status = 'A' AND COSTCENTER like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Descostos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = " AND status = 'A' AND UPPER(LOCALNAME) like '"
							+ objParam.getValue() + "'";
					LOGGER.debug(w_where);
				}
				if (objParam.getField().equals("Codoficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND SUCURSAL like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desoficina")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND UPPER(DESCRIPCIONLOCAL) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codcategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND CARGO like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Descategoria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");
					w_where = "AND UPPER(DESCRIPCIONLOCAL) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND TIPOPLANILLA like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desplanilla")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(DESCRIPCION) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codoperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND AREA like '" + objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desoperaria")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(NOMBRE) like '" + objParam.getValue()
							+ "'";
					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codinactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND COSTCENTER like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Desinactivos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(LOCALNAME) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Codpuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra al Código");
					w_where = "AND CODIGOPUESTO like '" + objParam.getValue()
							+ "'";

					LOGGER.debug(w_where);
				}

				if (objParam.getField().equals("Despuestos")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a la Descripcion");

					w_where = "AND UPPER(DESCRIPCION) like '"
							+ objParam.getValue() + "'";

					LOGGER.debug(w_where);
				}
			}

		}

		par_sql = " ";
		par_sql = w_where + par2;
		query.append(par_sql);

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());
		par1 = " ";
		return query.toString();
	}
	
	public List DwAsEventoUseridActivoSIGED(String userid, Integer[] estado) {
		LOGGER.debug("test de ascommon.dw_as_evento_userid_activo");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsEventoUseridActivo");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  ascommon.DwAsEventoUseridActivo");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_userid", String.class,
				userid));
		filtros.add(new ParametroPersistenciaGenerico("p_estado1",
				Integer.class, estado[0]));
		filtros.add(new ParametroPersistenciaGenerico("p_estado2",
				Integer.class, estado[1]));

		return dao.listarPorQuery(DtoDwAsEventoUseridActivo.class,
				"ascommon.DwAsEventoUseridActivoSIGED", null);
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder ascommon.dw_as_evento_userid_activo
	 */
	public List DwAsEventoUseridActivo(String userid, Integer[] estado) {
		LOGGER.debug("test de ascommon.dw_as_evento_userid_activo");
		LOGGER.debug(" usar el siguiente dto :  DtoDwAsEventoUseridActivo");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  ascommon.DwAsEventoUseridActivo");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_userid", String.class,
				userid));
		filtros.add(new ParametroPersistenciaGenerico("p_estado1",
				Integer.class, estado[0]));
		filtros.add(new ParametroPersistenciaGenerico("p_estado2",
				Integer.class, estado[1]));

		return dao.listarPorQuery(DtoDwAsEventoUseridActivo.class,
				"ascommon.DwAsEventoUseridActivo", filtros);
	}
	
	
	
}
