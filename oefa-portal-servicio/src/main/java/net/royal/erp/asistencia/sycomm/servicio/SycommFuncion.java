package net.royal.erp.asistencia.sycomm.servicio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.royal.erp.core.dominio.Parametrosmast;
import net.royal.erp.core.dominio.Personamast;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSycommFuncion")
public class SycommFuncion {

	private static Log LOGGER = LogFactory.getLog(SycommFuncion.class);
	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder sycomm.f_obtener_extremos_mes
	 */
	public Date[] FObtenerExtremosMes(Date par_inicio, Date par_fin)
			throws Exception {
		LOGGER.debug("test de sycomm.f_obtener_extremos_mes");
		Date lv_hoy;
		Integer lv_mes, lv_anio;

		Date[] obj = new Date[2];


		lv_hoy = new Date();
		// hallando el mes actual:
		String mes = new SimpleDateFormat("MM").format(lv_hoy);
		String anio = new SimpleDateFormat("yyyy").format(lv_hoy);

		lv_mes = Integer.parseInt(mes);
		lv_anio = Integer.parseInt(anio);

		// rango inicial:
		String fecIni = /* anio + "-" + mes + "-01"; */"01-" + mes + "-" + anio;
		par_inicio = UFechaHora.convertirCadenaFecha(fecIni, "dd-MM-yyyy");

		String sdf;
		// rango final:
		if (lv_mes < 12) {
			Integer i = lv_mes + 1;
			String fecha1 = /* lv_anio + "/" + i + "/01"; */"01-" + i + "-"
					+ lv_anio;
			SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
			Date b = a.parse(fecha1);
			Date d1 = UFechaHora.anadirDiasAFechas(b, -1);
			sdf = new SimpleDateFormat("dd/MM/yyyy").format(d1);

		} else {
			Integer n = lv_anio + 1;
			String fecha2 = "01/01/" + n; // "01-01-" + n;
			SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
			Date b = a.parse(fecha2);
			Date d1 = UFechaHora.anadirDiasAFechas(b, -1);
			sdf = new SimpleDateFormat("dd/MM/yyyy").format(d1);
		}

		SimpleDateFormat x = new SimpleDateFormat("dd/MM/yyyy");
		par_fin = x.parse(sdf);

		obj[0] = par_inicio;
		obj[1] = par_fin;

		return obj;

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycomm.f_sql_get_persona_nombrecompleto
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String FSqlGetPersonaNombrecompleto(Integer par_persona) {
		List<Personamast> lista = (List) dao.listarPorCriterios(dao
				.getCriteria(Personamast.class).add(
						Restrictions.eq("pk.persona", par_persona)));

		if (!UValidador.esListaVacia(lista))
			return lista.get(0).getNombrecompleto();

		return null;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycomm.f_sql_read_parametrosmast_#
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer FSqlReadParametrosmastN(String par_aplication,
			String par_company, String par_key) {
		LOGGER.debug("test de sycomm.f_sql_read_parametrosmast_#");

		List<Parametrosmast> lista = (List) dao
				.listarPorCriterios(dao.getCriteria(Parametrosmast.class).add(
						Restrictions.and(Restrictions.eq("pk.companiacodigo",
								par_company), Restrictions.eq(
								"pk.aplicacioncodigo", par_aplication),
								Restrictions.eq("pk.parametroclave", par_key))));

		if (!UValidador.esListaVacia(lista))
			return lista.get(0).getNumero();

		return null;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycomm.f_sql_read_parametrosmast_$
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String FSqlReadParametrosmastS(String par_aplication,
			String par_company, String par_key) {
		LOGGER.debug("test de sycomm.f_sql_read_parametrosmast_$");
		List<Parametrosmast> lista = (List) dao
				.listarPorCriterios(dao.getCriteria(Parametrosmast.class).add(
						Restrictions.and(Restrictions.eq("pk.companiacodigo",
								par_company), Restrictions.eq(
								"pk.aplicacioncodigo", par_aplication),
								Restrictions.eq("pk.parametroclave", par_key))));

		if (!UValidador.esListaVacia(lista))
			return lista.get(0).getTexto();

		return null;
	}

}
