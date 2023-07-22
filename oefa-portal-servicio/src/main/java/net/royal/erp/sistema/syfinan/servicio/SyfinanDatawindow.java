package net.royal.erp.sistema.syfinan.servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.sistema.dominio.dto.DtoDwBuBudgetValidationDetail;
import net.royal.erp.sistema.dominio.dto.DtoDwCpObligacionRetrieve;
import net.royal.erp.sistema.dominio.dto.DtoDwCpOrdenpagoRetrieve;
import net.royal.erp.sistema.dominio.dto.DtoDwMaWhCommodityClassSelect;
import net.royal.erp.sistema.dominio.dto.DtoDwWhImportacionContratoSelect;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

@Service(value = "BeanServicioSyfinanDatawindow")
public class SyfinanDatawindow {

	private static Log LOGGER = LogFactory.getLog(SyfinanFuncion.class);
	private ComunDao dao;
	//private SycommonFuncionDao sycommonFuncionDao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.dw_bu_budget_validation_detail
	 */
	public List DwBuBudgetValidationDetail() {
		LOGGER.debug("test de syfinan.dw_bu_budget_validation_detail");
		LOGGER.debug(" usar el siguiente dto :  DtoDwBuBudgetValidationDetail");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwBuBudgetValidationDetail");

		List datos = dao.listarPorQuery(DtoDwBuBudgetValidationDetail.class,
				"sycampocalculado.DwBuBudgetValidationDetail");
		return datos;

	}

	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.dw_cp_obligacion_retrieve
	 */
	public List DwCpObligacionRetrieve(Integer Proveedor, String TipoDocumento,
			String NumeroDocumento) {
		LOGGER.debug("test de syfinan.dw_cp_obligacion_retrieve");
		LOGGER.debug(" usar el siguiente dto :  DtoDwCpObligacionRetrieve");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwCpObligacionRetrieve");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("Proveedor",
				Integer.class, Proveedor));
		parametros.add(new ParametroPersistenciaGenerico("TipoDocumento",
				String.class, TipoDocumento));
		parametros.add(new ParametroPersistenciaGenerico("NumeroDocumento",
				String.class, NumeroDocumento));

		List datos = dao.listarPorQuery(DtoDwCpObligacionRetrieve.class,
				"obligaciones.DwCpObligacionRetrieve", parametros);

		return datos;

	}
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.dw_cp_ordenpago_retrieve
	 */
	public List DwCpOrdenpagoRetrieve(Integer proveedor, String tipodocumento,
			String numerodocumento) {
		LOGGER.debug("test de syfinan.dw_cp_ordenpago_retrieve");
		LOGGER.debug(" usar el siguiente dto :  DtoDwCpOrdenpagoRetrieve");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwCpOrdenpagoRetrieve");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("proveedor",
				Integer.class, proveedor));
		parametros.add(new ParametroPersistenciaGenerico("tipodocumento",
				String.class, tipodocumento));
		parametros.add(new ParametroPersistenciaGenerico("numerodocumento",
				String.class, numerodocumento));

		List datos = dao.listarPorQuery(DtoDwCpOrdenpagoRetrieve.class,
				"ordenpago.DwCpOrdenpagoRetrieve", parametros);
		return datos;

	}



	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.dw_ma_wh_commodity_class_select
	 */
	public List DwMaWhCommodityClassSelect() {
		LOGGER.debug("test de syfinan.dw_ma_wh_commodity_class_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaWhCommodityClassSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwMaWhCommodityClassSelect");

		return dao.listarPorQuery(DtoDwMaWhCommodityClassSelect.class,
				"syfinan.DwMaWhCommodityClassSelect");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.dw_wh_importacion_contrato_select
	 */
	public List DwWhImportacionContratoSelect(String companiasocio) {
		LOGGER.debug("test de syfinan.dw_wh_importacion_contrato_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDwWhImportacionContratoSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwWhImportacionContratoSelect");

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();

		filtros.add(new ParametroPersistenciaGenerico("companiasocio",
				String.class, companiasocio));

		List lista = dao.listarPorQuery(DtoDwWhImportacionContratoSelect.class,
				"syfinan.DwWhImportacionContratoSelect", filtros);

		return lista;

	}


	public String filtrosListadoDinamicoControlcalidad(
			List<ParametroPersistenciaGenerico> parametros, String par_item) {

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

				if (objParam.getField().equals("ControlCalidad")) {
					LOGGER.debug("Entrando a: " + "Control de Calidad");

					w_where = " AND (( WH_OrdenCompraDetalle.Item = '"
							+ par_item + "' ) AND "
							+ "(WH_ControlCalidadDetalle.Estado = 'PR' OR "
							+ "WH_ControlCalidadDetalle.Estado = 'CO')) ";

				}
			}
		}
		// ****************************************************
		// Si no existe el Where , se lo añadimos
		// ****************************************************
		if (!UValidador.estaVacio(w_where)) {
			LOGGER.debug("Hay WHERE");

		}

		// ****************************************************
		// Si Existe el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");

		}
		// ***************************************************
		// Si Existe el Sort By, se lo añadimos antes...
		// ***************************************************

		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");

			par_sql = par_sql + par1 + par2 + w_where + w_order;
		} else {
			par_sql = par_sql + par1 + par2 + w_where;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		w_where = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}

	public String filtrosContarPaginacionControlcalidad(
			List<ParametroPersistenciaGenerico> parametros, String par_item) {
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

				if (objParam.getField().equals("ControlCalidad")) {
					LOGGER.debug("Entrando a: " + "Control de Calidad");

					w_where = " AND (( WH_OrdenCompraDetalle.Item = '"
							+ par_item + "' ) AND "
							+ "(WH_ControlCalidadDetalle.Estado = 'PR' OR "
							+ "WH_ControlCalidadDetalle.Estado = 'CO')) ";

				}
			}
		}
		// ****************************************************
		// Si no existe el Where , se lo añadimos
		// ****************************************************
		if (!UValidador.estaVacio(w_where)) {
			LOGGER.debug("Hay WHERE");

		}

		// ****************************************************
		// Si Existe el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");

		}
		// ***************************************************
		// Si Existe el Sort By, se lo añadimos antes...
		// ***************************************************

		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");

			par_sql = par_sql + par1 + par2 + w_where + w_order;
		} else {
			par_sql = par_sql + par1 + par2 + w_where;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		w_where = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}


	public String filtrosListadoDinamicoDirecciondestino(
			List<ParametroPersistenciaGenerico> parametros, String par_item) {

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

				if (objParam.getField().equals("Distribuidores")) {
					LOGGER.debug("Entrando a: " + "Distribuidores");

					w_where = " AND ( WH_Kardex.Item = '" + par_item + "' ) ";

					w_group = " GROUP BY"
							+ " WH_TransaccionHeader.CompaniaSocio ,"
							+ " WH_TransaccionHeader.DireccionDestino , "
							+ " WH_Kardex.Item, "
							+ " WH_DestinoFinal.DescripcionLocal";

					w_order = " ORDER BY "
							+ "WH_TransaccionHeader.DireccionDestino ASC ";

				}
			}
		}
		// ****************************************************
		// Si no existe el Where , se lo añadimos
		// ****************************************************
		if (!UValidador.estaVacio(w_where)) {
			LOGGER.debug("Hay WHERE");

		}

		// ****************************************************
		// Si Existe el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");

		}
		// ***************************************************
		// Si Existe el Sort By, se lo añadimos antes...
		// ***************************************************

		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");

			par_sql = par_sql + w_where + w_group + w_order;
		} else {
			par_sql = par_sql + w_where + w_group;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		w_where = " ";
		w_group = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}

	public String filtrosContarPaginacionDirecciondestino(
			List<ParametroPersistenciaGenerico> parametros, String par_item) {

		StringBuilder query = new StringBuilder();
		String w_where = " ";
		String w_order = " ";
		String w_group = " ";
		String par_sql = "";

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("Distribuidores")) {
					LOGGER.debug("Entrando a: " + "Distribuidores");

					w_where = " AND ( WH_Kardex.Item = '" + par_item + "' ) ";

					w_order = " ORDER BY "
							+ "WH_TransaccionHeader.DireccionDestino ASC ";

				}
			}
		}
		// ****************************************************
		// Si no existe el Where , se lo añadimos
		// ****************************************************
		if (!UValidador.estaVacio(w_where)) {
			LOGGER.debug("Hay WHERE");

		}

		// ****************************************************
		// Si Existe el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");

		}
		// ***************************************************
		// Si Existe el Sort By, se lo añadimos antes...
		// ***************************************************

		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");

			par_sql = par_sql + w_where + w_group + w_order;
		} else {
			par_sql = par_sql + w_where + w_group;
		}

		query.append(par_sql);

		par_sql = " ";
		w_where = " ";
		w_group = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();

	}


	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.dw_wh_item_stock_item_filter
	 */
	public void DwWhItemStockItemFilter() {
		LOGGER.debug("test de syfinan.dw_wh_item_stock_item_filter");
		LOGGER.debug(" usar el siguiente dto :  DtoDwWhItemStockItemFilter");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  syfinan.DwWhItemStockItemFilter");
	}


	public String filtrosListadoDinamicoAlmacen(
			List<ParametroPersistenciaGenerico> parametros, String par_item) {

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

				if (objParam.getField().equals("userid")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Solo entra si el ITEM ha sido validado");

					par1 = " AND EXISTS ( SELECT 1 FROM sgcoresys.SY_SeguridadAutorizaciones "
							+ " WHERE WH_ItemAlmacenLote.AlmacenCodigo = SY_SeguridadAutorizaciones.Concepto "
							+ " AND SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' "
							+ " AND SY_SeguridadAutorizaciones.Grupo = 'ALMACEN' "
							+ " AND SY_SeguridadAutorizaciones.Estado = 'A' "
							+ " AND UPPER(SY_SeguridadAutorizaciones.Usuario) = '"
							+ objParam.getValue() + "') ";

				}

				if (objParam.getField().equals("Almacen")) {
					LOGGER.debug("Entrando a: " + "Almacen");

					w_where = " AND ( WH_ItemAlmacenLote.Item = '" + par_item
							+ "' ) ";

					w_order = "ORDER BY "
							+ "WH_ItemAlmacenLote.Condicion ASC, "
							+ "WH_ItemAlmacenLote.AlmacenCodigo ASC, "
							+ "WH_ItemAlmacenLote.Item ASC";
				}
			}
		}
		// ****************************************************
		// Si no existe el Where , se lo añadimos
		// ****************************************************
		if (!UValidador.estaVacio(w_where)) {
			LOGGER.debug("Hay WHERE");

		}

		// ****************************************************
		// Si Existe el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");

		}
		// ***************************************************
		// Si Existe el Sort By, se lo añadimos antes...
		// ***************************************************

		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");

			par_sql = par_sql + par1 + par2 + w_where + w_order;
		} else {
			par_sql = par_sql + par1 + par2 + w_where;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		w_where = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}

	public String filtrosContarPaginacionAlmacen(
			List<ParametroPersistenciaGenerico> parametros, String par_item) {

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

				if (objParam.getField().equals("userid")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("Solo entra si el ITEM ha sido validado");

					par1 = " AND EXISTS ( SELECT 1 FROM sgcoresys.SY_SeguridadAutorizaciones "
							+ " WHERE WH_ItemAlmacenLote.AlmacenCodigo = SY_SeguridadAutorizaciones.Concepto "
							+ " AND SY_SeguridadAutorizaciones.AplicacionCodigo = 'SY' "
							+ " AND SY_SeguridadAutorizaciones.Grupo = 'ALMACEN' "
							+ " AND SY_SeguridadAutorizaciones.Estado = 'A' "
							+ " AND UPPER(SY_SeguridadAutorizaciones.Usuario) = '"
							+ objParam.getValue() + "') ";

				}

				if (objParam.getField().equals("Almacen")) {
					LOGGER.debug("Entrando a: " + "Almacen");

					w_where = " AND ( WH_ItemAlmacenLote.Item = '" + par_item
							+ "' ) ";

					w_order = "ORDER BY "
							+ "WH_ItemAlmacenLote.Condicion ASC, "
							+ "WH_ItemAlmacenLote.AlmacenCodigo ASC, "
							+ "WH_ItemAlmacenLote.Item ASC";
				}
			}
		}
		// ****************************************************
		// Si no existe el Where , se lo añadimos
		// ****************************************************
		if (!UValidador.estaVacio(w_where)) {
			LOGGER.debug("Hay WHERE");

		}

		// ****************************************************
		// Si Existe el Group By, se lo añadimos antes...
		// ****************************************************

		if (!UValidador.estaVacio(w_group)) {
			LOGGER.debug("Hay GROUP BY");

		}
		// ***************************************************
		// Si Existe el Sort By, se lo añadimos antes...
		// ***************************************************

		if (!UValidador.estaVacio(w_order)) {
			LOGGER.debug("Hay ORDER BY");

			par_sql = par_sql + par1 + par2 + w_where + w_order;
		} else {
			par_sql = par_sql + par1 + par2 + w_where;
		}

		query.append(par_sql);

		par_sql = " ";
		par1 = " ";
		w_where = " ";

		if (query.length() < 0)
			LOGGER.debug("QUERY::" + query.toString());

		return query.toString();
	}

}
