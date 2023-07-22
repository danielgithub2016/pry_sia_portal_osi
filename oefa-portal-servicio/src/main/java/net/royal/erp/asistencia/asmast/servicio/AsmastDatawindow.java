package net.royal.erp.asistencia.asmast.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsConceptoaccesoSelectPre;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsEmpleadosmastSelectCarnets;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTempusTerminal;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTipodiaasistenciaSelect;
import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsmastDatawindow")
public class AsmastDatawindow {

	private static Log LOGGER = LogFactory.getLog(AsmastDatawindow.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmast.dddw_as_conceptoacceso_select_pre
	 */
	public List DddwAsConceptoaccesoSelectPre(String administrador, String usuario) {
		LOGGER.debug("test de asmast.dddw_as_conceptoacceso_select_pre");
		LOGGER.debug(" usar el siguiente dto :  DtoDddwAsConceptoaccesoSelectPre");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmast.DddwAsConceptoaccesoSelectPre");
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_administrador", String.class, administrador));
		filtros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, usuario));

		return dao.listarPorQuery(DtoDddwAsConceptoaccesoSelectPre.class, "asmast.DddwAsConceptoaccesoSelectPre",
				filtros);

	}
	
	public List DddwAsConceptoaccesoSelectPreSiged(String administrador, String usuario) {
		LOGGER.debug("test de asmast.dddw_as_conceptoacceso_select_pre");
		LOGGER.debug(" usar el siguiente dto :  DtoDddwAsConceptoaccesoSelectPre");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmast.DddwAsConceptoaccesoSelectPre");
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_administrador", String.class, administrador));
		filtros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, usuario));

		return dao.listarPorQuery(DtoDddwAsConceptoaccesoSelectPre.class, "asmast.DddwAsConceptoaccesoSelectPreSiged",
				null);

	}
	
	

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmast.dddw_as_empleadosmast_select_carnets
	 */
	public List DddwAsEmpleadosmastSelectCarnets() {
		LOGGER.debug("test de asmast.dddw_as_empleadosmast_select_carnets");
		LOGGER.debug(" usar el siguiente dto :  DtoDddwAsEmpleadosmastSelectCarnets");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmast.DddwAsEmpleadosmastSelectCarnets");
		return dao.listarPorQuery(DtoDddwAsEmpleadosmastSelectCarnets.class, "asmast.DddwAsEmpleadosmastSelectCarnets");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmast.dddw_as_tempus_terminal
	 */
	public List DddwAsTempusTerminal() {
		LOGGER.debug("test de asmast.dddw_as_tempus_terminal");
		LOGGER.debug(" usar el siguiente dto :  DtoDddwAsTempusTerminal");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmast.DddwAsTempusTerminal");
		return dao.listarPorQuery(DtoDddwAsTempusTerminal.class, "asmast.DddwAsTempusTerminal");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmast.dddw_as_tipodiaasistencia_select
	 */
	public List DddwAsTipodiaasistenciaSelect() {
		LOGGER.debug("test de asmast.dddw_as_tipodiaasistencia_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDddwAsTipodiaasistenciaSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmast.DddwAsTipodiaasistenciaSelect");

		return dao.listarPorQuery(DtoDddwAsTipodiaasistenciaSelect.class, "asmast.DddwAsTipodiaasistenciaSelect");

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asmast.dw_pr_empleado_select
	 */
	public List DwPrEmpleadoSelect(String par_centrocosto, String par_tipoplanilla, String par_apellido,
			String par_codigo, String par_estadoempleado, String par_estado, String par_incluirNegativos) {
		LOGGER.debug("test de asmast.dw_pr_empleado_select");
		LOGGER.debug(" usar el siguiente dto :  DtoDwPrEmpleadoSelect");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  asmast.DwPrEmpleadoSelect");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_centrocosto", String.class, par_centrocosto));
		parametros.add(new ParametroPersistenciaGenerico("p_tipoplanilla", String.class, par_tipoplanilla));
		parametros.add(new ParametroPersistenciaGenerico("p_apellido", String.class, par_apellido));
		parametros.add(new ParametroPersistenciaGenerico("p_codigo", String.class, par_codigo));
		parametros.add(new ParametroPersistenciaGenerico("p_estadoempleado", String.class, par_estadoempleado));
		parametros.add(new ParametroPersistenciaGenerico("p_estado", String.class, par_estado));
		parametros.add(new ParametroPersistenciaGenerico("p_negativo", String.class,
				UValidador.estaVacio(par_incluirNegativos) ? "" : par_incluirNegativos));
		List lista;
		lista = dao.listarPorQuery(DtoDwPrEmpleadoSelect.class, "asmast.DwPrEmpleadoSelect", parametros);
		return lista;

	}

}
