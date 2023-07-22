package net.royal.erp.sistema.syfinan.servicio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dao.AccountmstDao;
import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.sistema.dominio.dto.DtoDwWhItemStockItem;
import net.royal.erp.sistema.dominio.dto.DtoImpuestos;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSyfinanFuncion")
public class SyfinanFuncion {

	private static Log LOGGER = LogFactory.getLog(SyfinanFuncion.class);
	private ComunDao dao;
	// private SycommonFuncionDao daoSycommonFuncion;
	private AccountmstDao daoAccountmst;
	private ParametrosmastDao daoParametrosmast;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.f_sql_read_tiposervicio_%
	 */
	public BigDecimal FSqlReadTiposervicioX(String par_tiposervicio, Integer w_decimales) {
		LOGGER.debug("test de syfinan.f_sql_read_tiposervicio_%");
		BigDecimal w_factor = new BigDecimal(0);

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_tiposervicio", String.class, par_tiposervicio));

		List datos = dao.listarPorQuery(DtoImpuestos.class, "syfinan.fsqlreadtiposerviciox", parametros);

		List<DtoImpuestos> par_dw = datos;

		if (!UValidador.esListaVacia(datos)) {
			for (DtoImpuestos objServicio : par_dw) {
				if (objServicio.getSigno().equals("+")) {
					w_factor = w_factor.add(objServicio.getFactorporcentaje());
				} else {
					w_factor = w_factor.subtract(objServicio.getFactorporcentaje());
				}
			}

			w_factor = w_factor.divide(new BigDecimal(100), w_decimales, RoundingMode.HALF_UP);
		}

		return w_factor;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.f_sql_validate_item
	 */
	public String FSqlValidateItem(String par_item) {
		LOGGER.debug("test de syfinan.f_sql_validate_item");
		String retorno = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_item", String.class, par_item));

		List data = dao.listarPorQuery(DtoDwWhItemStockItem.class, "syfinan.fSqlValidateItem", filtros);

		if (!UValidador.esListaVacia(data)) {
			retorno = ((DtoDwWhItemStockItem) data.get(0)).getItem();
		}

		return retorno;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder syfinan.f_sql_item_summarize_stock_almacen
	 */
	public BigDecimal FSqlItemSummarizeStockAlmacen(String par_item, String par_almacen) {
		LOGGER.debug("test de syfinan.f_voucher_select_fields");
		BigDecimal w_stock = BigDecimal.valueOf(0);

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_item", String.class, par_item));
		filtros.add(new ParametroPersistenciaGenerico("p_almacen", String.class, par_almacen));

		Integer value = dao.contar("whitemalmacenlote.obtenerStockActual", filtros);

		if (UValidador.esNulo(value)) {
			value = 0;
		}

		if (UValidador.esCero(value)) {
			w_stock = BigDecimal.valueOf(value);
		}
		return w_stock;
	}

	@Autowired
	public void setDaoAccountmst(AccountmstDao daoAccountmst) {
		this.daoAccountmst = daoAccountmst;
	}

	@Autowired
	public void setDaoParametrosmast(ParametrosmastDao daoParametrosmast) {
		this.daoParametrosmast = daoParametrosmast;
	}

}
