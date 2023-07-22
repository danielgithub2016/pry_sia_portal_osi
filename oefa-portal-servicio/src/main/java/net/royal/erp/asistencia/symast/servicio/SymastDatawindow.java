package net.royal.erp.asistencia.symast.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaTipodocumentocxpSelect;
import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaUnidadesmastSelect;
import net.royal.erp.sistema.dominio.dto.DtoDwMaElementSelect;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSymastDatawindow")
public class SymastDatawindow {

	private static Log LOGGER = LogFactory.getLog(SymastDatawindow.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast.dw_ma_element_select
	 */
	public List<DtoDwMaElementSelect> DwMaElementSelect() {
		LOGGER.debug("test de symast.dw_ma_element_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaElementSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast.DwMaElementSelect");
		
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("status", String.class, "A"));
		
		List datos;
		datos=dao.listarPorQuery(DtoDwMaElementSelect.class, "symast.DwMaElementSelectCombo", filtro);
		return datos;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast.dw_ma_miscelaneosdetalle_select
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwMaMiscelaneosdetalleSelect> DwMaMiscelaneosdetalleSelect(
			String par_aplicacion, String par_tabla, String par_companyowner) {
		LOGGER.debug("SymastDatawindow.DwMaMiscelaneosdetalleSelect()");
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_aplicacion",
				String.class, par_aplicacion));
		parametros.add(new ParametroPersistenciaGenerico("par_tabla",
				String.class, par_tabla));
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner",
				String.class, par_companyowner));
		List lista;
		lista = dao.listarPorQuery(DtoDwMaMiscelaneosdetalleSelect.class,
				"symast.DwMaMiscelaneosdetalleSelect", parametros);
		return lista;
	}

}
