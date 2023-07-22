package net.royal.erp.rrhh.prmast.servicio;

import java.util.List;

import net.royal.erp.rrhh.prmast.dominio.dto.DtoDwMaPrTipoplantillaSelect;
import net.royal.framework.web.dao.ComunDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioPrmastDatawindow")
public class PrmastDatawindow {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDwMaPrTipoplantillaSelect> dwMaPrTipoplantillaSelect() {
		return (List) dao.listarPorQuery(DtoDwMaPrTipoplantillaSelect.class,
				"prmast.dwMaPrTipoplantillaSelect");
	}

}
