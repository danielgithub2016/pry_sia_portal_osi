package net.royal.erp.sistema.sycommon.servicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.dto.DtoAcCierreDiario;
import net.royal.erp.core.dominio.dto.DtoSeguridadautorizaciones;
import net.royal.erp.core.dominio.dto.DtoUsuario;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSycommonFuncion")
public class SycommonFuncion {

	private static Log LOGGER = LogFactory.getLog(SycommonFuncion.class);
	private ComunDao dao;
	private ParametrosmastDao daoParametrosmast;
 
	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder sycommon.f_sql_read_cierrediario_horario
	 */
	public List FSqlReadCierrediarioHorario(Date par_date,
			String parametroCierre, String parametroCompania,
			String parametroUsuario) throws Exception {
		LOGGER.debug("test de sycommon.f_sql_read_cierrediario_horario");
		List result = new ArrayList();
		String mensaje = "";
		String w_fecha, w_time, w_timedesde = "", w_timehasta = "";
		Integer retorno = 1;

		if (parametroCierre.equals("S")) {
			w_fecha = new SimpleDateFormat("yyyyMMdd").format(par_date);
			w_time = UFechaHora.convertirFechaCadena(par_date, "HH:mm:ss");

			List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
			parametros.add(new ParametroPersistenciaGenerico(
					"str_global_gv_companyowner", String.class,
					parametroCompania));
			parametros.add(new ParametroPersistenciaGenerico("w_fecha",
					String.class, w_fecha));

			List datosCierre = dao.listarPorQuery(DtoAcCierreDiario.class,
					"SycommonFuncion.fsqlreadcierrediariohorario", parametros);

			if (UValidador.esListaVacia(datosCierre)) {
				mensaje = "Fecha no esta Aperturada.";
				
				/*POR EL MOMENTO PARA QUE NO SALGA ERROR*/
				if (!FSqlReadUserAutorizacion("AC", "SYSTEM", "DIASUP",
						parametroUsuario).equals(0)) {
					retorno = 0;
					result.add(retorno);
					result.add(mensaje);
					return result;
				}
			}

			List<ParametroPersistenciaGenerico> parametro = new ArrayList<ParametroPersistenciaGenerico>();
			parametro.add(new ParametroPersistenciaGenerico(
					"str_global_gv_userid", String.class, parametroUsuario));

			List datos01 = dao.listarPorQuery(DtoUsuario.class,
					"SycommonFuncion.fsqlreadcierrediariohorario01", parametro);
			if (!UValidador.esListaVacia(datos01)) {
				DtoUsuario dtousuar = new DtoUsuario();
				dtousuar = (DtoUsuario) datos01.get(0);
				w_timedesde = dtousuar.getHorainicio();
				w_timehasta = dtousuar.getHorafin();
			}

			if (UValidador.estaVacio(w_timedesde)) {
				w_timedesde = "000000";
			}

			if (UValidador.estaVacio(w_timehasta)) {
				w_timehasta = "000000";
			}

		}
		result.add(retorno);
		result.add(mensaje);

		return result;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycommon.f_sql_read_user_autorizacion
	 */
	public Integer FSqlReadUserAutorizacion(String par_aplicacion,
			String par_grupo, String par_concepto, String par_user) {
		LOGGER.debug("test de sycommon.f_sql_read_user_autorizacion");
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_aplicacion",
				String.class, par_aplicacion));
		parametros.add(new ParametroPersistenciaGenerico("par_grupo",
				String.class, par_grupo));
		parametros.add(new ParametroPersistenciaGenerico("par_user",
				String.class, par_user.toUpperCase()));
		parametros.add(new ParametroPersistenciaGenerico("par_concepto",
				String.class, par_concepto));

		String w_codigo;
		List datos = null;

		datos = dao.listarPorQuery(DtoSeguridadautorizaciones.class,
				"SycommonFuncion.fsqlreaduserautorizacion01", parametros);

		LOGGER.debug("datos " + datos.size());
		LOGGER.debug("par_aplicacion " + par_aplicacion);
		LOGGER.debug("par_grupo " + par_grupo);
		LOGGER.debug("par_user " + par_user);
		LOGGER.debug("par_concepto " + par_concepto);

		if (UValidador.esListaVacia(datos)) {

			datos = dao.listarPorQuery(DtoSeguridadautorizaciones.class,
					"SycommonFuncion.fsqlreaduserautorizacion02", parametros);
			w_codigo = ((DtoSeguridadautorizaciones) datos.get(0))
					.getAplicacioncodigo();

			if (UValidador.esNulo(w_codigo) || UValidador.estaVacio(w_codigo)) {
				return -1;
			} else {
				return 0;
			}
		}

		return 0;

	}

@Autowired
public void setDaoParametrosmast(ParametrosmastDao daoParametrosmast) {
	this.daoParametrosmast = daoParametrosmast;
}
}
