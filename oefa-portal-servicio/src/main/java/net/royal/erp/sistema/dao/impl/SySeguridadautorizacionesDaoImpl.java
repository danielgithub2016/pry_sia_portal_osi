package net.royal.erp.sistema.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.sistema.dao.SySeguridadautorizacionesDao;
import net.royal.erp.sistema.dominio.SySeguridadautorizaciones;
import net.royal.erp.sistema.dominio.SySeguridadautorizacionesPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SySeguridadautorizacionesDaoImpl extends
		GenericoDaoImpl<SySeguridadautorizaciones, SySeguridadautorizacionesPk>
		implements SySeguridadautorizacionesDao {

	private static Log LOGGER = LogFactory
			.getLog(SySeguridadautorizaciones.class);

	public SySeguridadautorizacionesDaoImpl() {
		super("syseguridadautorizaciones");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 * f_sql_read_security
	 */
	
	@Override
	public Integer leerSeguridad(String par_grupo, String par_concepto,
			String gvUserid, String gvApplication) {
		
		LOGGER.debug("test de sycommon.f_sql_read_security");
		String w_aplicacion, w_usuario, w_masterbrowseflag="", w_masterupdateflag="";
		w_usuario = gvUserid;
		w_aplicacion = gvApplication;

		if (par_grupo.substring(0, 6).equals("MSTSYS")
				|| par_grupo.equals("SEGURIDAD")) {
			w_aplicacion = "SY";
		}
		
		
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.usuario", w_usuario));
		cri.add(Restrictions.eq("pk.grupo", par_grupo));
		cri.add(Restrictions.eq("pk.concepto", par_concepto));
		cri.add(Restrictions.eq("pk.aplicacioncodigo", w_aplicacion));

		List<SySeguridadautorizaciones> result = this.listarPorCriterios(cri);
		
		if (!UValidador.esListaVacia(result)){
			w_masterbrowseflag = result.get(0).getMasterbrowseflag();
			w_masterupdateflag = result.get(0).getMasterupdateflag();
		}

		if (par_grupo.substring(0, 3).equals("MTS")) {
			if (!w_masterbrowseflag.equals("S"))
				w_masterbrowseflag = "N";

			if (!w_masterupdateflag.equals("S"))
				w_masterupdateflag = "N";

			if (w_masterupdateflag.equals("S")) {
				return 0;
			}

			if (w_masterbrowseflag.equals("S"))
				return 1;
			return -1; // No one
		} else {
			return 0;
		}
	}

	
	@Override
	public List obtenerSeguridad(String par_option, String par_grupo,
			String par_concepto, String gvSeguridad, String gvEmpresa,
			String gvUserid, String gvApplication) {
		
		LOGGER.debug("test de sycommon.f_security");
		String mensaje = "";
		Integer w_answer, retorno = 0;
		List result = new ArrayList<>();

		if (gvSeguridad.equals("M")) {
			retorno = 0;
			result.add(retorno);
			result.add(mensaje);
			return result;
		}

		switch (gvEmpresa) {
		case "CITIBK":
			break;
		default:
			switch (par_option) {
			case "OPEN":
				w_answer = leerSeguridad(par_grupo, par_concepto,
						gvUserid.toUpperCase(), gvApplication);
				if (w_answer.equals(-1)) {
					mensaje = "Ud. no tiene autorización a esta opción";
					retorno = -1;
				} else {
					retorno = w_answer;
				}

				break;

			default:
				break;
			}
			break;
		}

		result.add(retorno);
		result.add(mensaje);
		return result;
	}

}
