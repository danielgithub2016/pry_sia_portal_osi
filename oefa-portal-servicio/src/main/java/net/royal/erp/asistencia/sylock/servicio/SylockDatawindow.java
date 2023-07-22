package net.royal.erp.asistencia.sylock.servicio;

import java.util.List;

import net.royal.erp.asistencia.sylock.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.dao.ComunDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSylockDatawindow")
public class SylockDatawindow {

	private static Log LOGGER = LogFactory.getLog(SylockFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.dw_ma_companyowner_select
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwMaCompanyownerSelect> DwMaCompanyownerSelect() {
		return (List) dao.listarPorQuery(DtoDwMaCompanyownerSelect.class,
				"sylock.DwMaCompanyownerSelect");
	}


}
