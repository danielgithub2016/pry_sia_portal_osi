package net.royal.seguridad.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.AplicacionesmastDao;
import net.royal.seguridad.dao.ParametrosmastDao;
import net.royal.seguridad.dominio.Aplicacionesmast;
import net.royal.seguridad.dominio.AplicacionesmastPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("aplicacionesmastDaoImplSeguridad")
public class AplicacionesmastDaoImpl extends
		GenericoDaoImpl<Aplicacionesmast, AplicacionesmastPk> implements
		AplicacionesmastDao {

	private static Log LOGGER = LogFactory.getLog(Aplicacionesmast.class);
	private ParametrosmastDao parametrosmastDao;

	public AplicacionesmastDaoImpl() {
		super("seguridad.aplicacionesmast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerPeriodoContable(String aplicacioncodigo) {
		String tipoPeriodoVoucher;
		String ultimoperiodocontable = null;

		tipoPeriodoVoucher = parametrosmastDao.obtenerValorCadena("999999",
				"WH", "TPERIODVOU");
		if (tipoPeriodoVoucher == null)
			tipoPeriodoVoucher = "";

		Aplicacionesmast obj = this.obtenerPorId(new AplicacionesmastPk(
				aplicacioncodigo), false);

		if (!tipoPeriodoVoucher.equals("S")) {
			Date today = new Date();

			try {
				ultimoperiodocontable = UFechaHora.convertirFechaCadena(today,
						"yyyy");
				ultimoperiodocontable = ultimoperiodocontable
						+ UFechaHora.convertirFechaCadena(today, "MM");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!UValidador.esNulo(obj)) {
				if (obj.getUltimoperiodocontable() != null) {
					if (!obj.getUltimoperiodocontable().equals(
							ultimoperiodocontable)) {
						/*
						 * obj.setUltimoperiodocontable(ultimoperiodocontable);
						 * this.update(obj);
						 */
					}
				}
			}

			if (aplicacioncodigo.equals("AP")) {
				Aplicacionesmast objCO = this.obtenerPorId(
						new AplicacionesmastPk("CO"), false);
				if (!objCO.getUltimoperiodocontable().equals(
						ultimoperiodocontable)) {
					/*
					 * objCO.setUltimoperiodocontable(ultimoperiodocontable);
					 * this.update(objCO);
					 */
				}
			}
		}

		obj = this
				.obtenerPorId(new AplicacionesmastPk(aplicacioncodigo), false);

		if (UValidador.esNulo(obj)) {
			obj = new Aplicacionesmast();
		}
		return obj.getUltimoperiodocontable();
	}

	@Autowired
	public void setParametrosmastDao(ParametrosmastDao parametrosmastDao) {
		this.parametrosmastDao = parametrosmastDao;
	}

	/**
	 * se lee de la tabla de parametros "SY","999999","SECURITY"
	 * 
	 * los tipos posibles
	 * 
	 * P:Seguridad Propia W:Seguridad x Ventana M:Seguridad x Menu
	 * 
	 * @return
	 */
	@Override
	public String obtenerTipoSeguridad() {
		String valor;
		valor = parametrosmastDao
				.obtenerValorCadena("999999", "SY", "SECURITY");
		if (valor == null)
			valor = "";
		if ((valor != "P") && (valor != "W"))
			valor = "M";
		return valor;
	}
}
