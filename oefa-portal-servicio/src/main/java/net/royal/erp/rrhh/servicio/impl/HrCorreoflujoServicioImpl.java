package net.royal.erp.rrhh.servicio.impl;

import java.util.HashMap;
import java.util.List;

import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.rrhh.dao.HrCorreoflujoDao;
import net.royal.erp.rrhh.dominio.HrCorreoflujo;
import net.royal.erp.rrhh.servicio.HrCorreoflujoServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrCorreoflujo")
public class HrCorreoflujoServicioImpl extends GenericoServicioImpl implements
		HrCorreoflujoServicio {

	private HrCorreoflujoDao dao;
	private EmpleadomastDao daoEmpleado;

	private static Log LOGGER = LogFactory
			.getLog(HrCorreoflujoServicioImpl.class);

	@Autowired
	public void setDao(HrCorreoflujoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setDaoEmpleado(EmpleadomastDao daoEmpleado) {
		this.daoEmpleado = daoEmpleado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> flujoProcesoCorreoNuevo(Integer proceso,
			Integer accion, Integer usuario, String flagmotivo, String motivo,
			Integer solicitante, String compania) {
		HrCorreoflujo correoflujo = new HrCorreoflujo();
		HashMap<String, Object> retorno = new HashMap<String, Object>();
		String w_destino = "";

		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.proceso", proceso));
		cri.add(Restrictions.eq("pk.accion", accion));
		cri.add(Restrictions.eq("pk.usuario", usuario));

		List<HrCorreoflujo> datos = cri.list();

		if (!UValidador.esListaVacia(datos)) {
			correoflujo = datos.get(0);
		} else {
			retorno.put("registrado", false);
		}

		if (UValidador.estaVacio(correoflujo.getPk().getFlagaccion())) {
			correoflujo.getPk().setFlagaccion("");
		}

		/*
		 * SE COMENTADO DEBIDO A QUE SUSANA DESEA QUE NO SE VALIDE ESTO PARA
		 * ENVIAR CORREO if (correoflujo.getPk().getFlagaccion().equals("S")) {
		 * retorno.put("registrado", true); retorno.put("destinatario",
		 * correoflujo.getDestino()); retorno.put("copia",
		 * correoflujo.getCopia()); } else { if (flagmotivo.equals("N")) {
		 * cri.add(Restrictions.eq("pk.flagmotivo", flagmotivo));
		 * cri.add(Restrictions.eq("motivo", motivo)); } else {
		 * cri.add(Restrictions.eq("pk.flagmotivo", flagmotivo)); }
		 * 
		 * datos = cri.list(); }
		 */

		// ***************************************************
		// ESTA PARTE REEMPLAZA A LA DE ARRIBA
		if (!UValidador.estaVacio(correoflujo.getDestino())) {
			w_destino = w_destino + correoflujo.getDestino() + ";";
		}
		// ***************************************************

		if (UValidador.estaVacio(correoflujo.getFlagusuario())) {
			correoflujo.setFlagusuario("");
		}

		if (correoflujo.getFlagusuario().equals("S")) {
			EmpleadomastPk pkfind = new EmpleadomastPk();
			pkfind.setCompaniasocio(compania);
			pkfind.setEmpleado(solicitante);

			Empleadomast objfind = daoEmpleado.obtenerPorId(pkfind, false);

			if (!UValidador.estaVacio(objfind.getCorreointerno())) {
				w_destino = w_destino + objfind.getCorreointerno() + ";";
			}

		}

		if (UValidador.estaVacio(correoflujo.getFlagjefe())) {
			correoflujo.setFlagjefe("");
		}

		if (correoflujo.getFlagjefe().equals("S")) {
			EmpleadomastPk pkfind = new EmpleadomastPk();
			pkfind.setCompaniasocio(compania);
			pkfind.setEmpleado(solicitante);
			Empleadomast objfind = daoEmpleado.obtenerPorId(pkfind, false);

			EmpleadomastPk pkfind2 = new EmpleadomastPk();
			pkfind2.setCompaniasocio(compania);
			pkfind2.setEmpleado(objfind.getJefequienreporta());
			Empleadomast objfind2 = daoEmpleado.obtenerPorId(pkfind2, false);

			LOGGER.debug("objfind2.getCorreointerno() "
					+ objfind2.getCorreointerno());

			if (!UValidador.estaVacio(objfind2.getCorreointerno())) {
				w_destino = w_destino + objfind2.getCorreointerno() + ";";
			}

		}

		retorno.put("registrado", true);
		retorno.put("destinatario", w_destino);
		retorno.put("copia", correoflujo.getCopia());

		return retorno;
	}
}
