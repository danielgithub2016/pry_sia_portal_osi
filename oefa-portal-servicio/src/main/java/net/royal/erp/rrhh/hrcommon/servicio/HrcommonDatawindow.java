package net.royal.erp.rrhh.hrcommon.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrSolicitudCapacitacionSelect;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHRHrcommonDatawindow")
public class HrcommonDatawindow {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 * @powerbuilder dw_pr_empleado_select
	 * @return
	 */
	public List listarEmpleadoSelectEval(String s) {
		StringBuilder query = new StringBuilder(dao.getSesionActual()
				.getNamedQuery("hrcommon.listarEmpleadoSelectEval").getQueryString());
		query.append(s);
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("p_esempleado",
				String.class, "S"));
		List datos;
		
		if(UValidador.esNulo(s)){
			datos = dao.listarPorQuery(DtoDwHrSolicitudCapacitacionSelect.class,
					"hrcommon.listarEmpleadoSelectEval", filtro);
		}else {			
			datos = dao.listarPorSentenciaSQL(DtoDwHrSolicitudCapacitacionSelect.class, query, filtro);
		}
		
		return null;
	}
}
