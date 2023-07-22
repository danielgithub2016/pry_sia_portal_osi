package net.royal.seguridad.vista.controladora;

import java.util.Map;
import java.util.Set;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.factory.FactoryErpSeguridad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UGestorNavegacion extends ConfigurableNavigationHandler {

	private static final Log LOGGER = LogFactory
			.getLog(UGestorNavegacion.class);

	private NavigationHandler parent;

	@ManagedProperty(value = "#{BeanFactorySeguridad}")
	private FactoryErpSeguridad seguridadFactory;

	public FactoryErpSeguridad getSeguridadFactory() {
		return seguridadFactory;
	}

	public void setSeguridadFactory(FactoryErpSeguridad seguridadFactory) {
		this.seguridadFactory = seguridadFactory;
	}

	public UGestorNavegacion(NavigationHandler parent) {
		this.parent = parent;
	}

	@Override
	public NavigationCase getNavigationCase(FacesContext arg0,
			String fromAction, String outcome) {
		// LOGGER.debug("=======>getNavigationCase");
		// LOGGER.debug("fromAction:" + fromAction);
		// LOGGER.debug("outcome:" + outcome);

		if (parent instanceof ConfigurableNavigationHandler) {
			return ((ConfigurableNavigationHandler) parent).getNavigationCase(
					arg0, fromAction, outcome);
		} else {
			return null;
		}
	}

	@Override
	public Map<String, Set<NavigationCase>> getNavigationCases() {
		if (parent instanceof ConfigurableNavigationHandler) {
			return ((ConfigurableNavigationHandler) parent)
					.getNavigationCases();
		} else {
			return null;
		}
	}

	@Override
	public void handleNavigation(FacesContext fc, String from, String outcome) {
		String codigoAplicacion = null;
		// LOGGER.debug("outcome");
		// LOGGER.debug(outcome);
		try {

			if (codigoAplicacion == null) {
				codigoAplicacion = (String) UAplicacion.getServletContext()
						.getInitParameter(
								UConstante.APLICACION_CODIGO_APLICACION);
			}
			if (outcome != null) {

				Seguridadconcepto con = null;
				UIBindingController binding = null;

				binding = UFaces.getControladora(
						UConstante.SESION_BEAN_BINDINGCONTROLLER,
						UIBindingController.class);

				if (outcome.equals(UConstante.NAVIGATIONCASE_BIENVENIDA)) {
					LOGGER.debug(UConstante.NAVIGATIONCASE_BIENVENIDA);

					String nuevaPantallaBienvenida = (String) UAplicacion
							.getServletContext()
							.getInitParameter(
									UConstante.APLICACION_NAVEGACION_BIENVENIDA);
					if (!UValidador.estaVacio(nuevaPantallaBienvenida)) {
						outcome = nuevaPantallaBienvenida;
					}
					if (binding!=null)
						binding.limpiarHerramientasLista();
				}
				else if (outcome.equals(UConstante.NAVIGATIONCASE_LOGIN)) {
					LOGGER.debug(UConstante.NAVIGATIONCASE_LOGIN);

					String nuevaPantallaLogin = (String) UAplicacion
							.getServletContext().getInitParameter(
									UConstante.APLICACION_NAVEGACION_LOGIN);
					if (!UValidador.estaVacio(nuevaPantallaLogin)) {
						outcome = nuevaPantallaLogin;
					}
					if (binding!=null)
						binding.limpiarHerramientasLista();
				} else if (outcome.equals(UConstante.NAVIGATIONCASE_ERROR)) {
					LOGGER.debug(UConstante.NAVIGATIONCASE_ERROR);
					String nuevaPantallaError = (String) UAplicacion
							.getServletContext().getInitParameter(
									UConstante.APLICACION_NAVEGACION_ERROR);
					if (!UValidador.estaVacio(nuevaPantallaError)) {
						outcome = nuevaPantallaError;
					}
					if (binding!=null)
						binding.limpiarHerramientasLista();
				} else if (outcome
						.equals(UConstante.NAVIGATIONCASE_VISTAEXPIRADA)) {
					LOGGER.debug(UConstante.NAVIGATIONCASE_VISTAEXPIRADA);
					String nuevaPantallaError = (String) UAplicacion
							.getServletContext()
							.getInitParameter(
									UConstante.APLICACION_NAVEGACION_VISTAEXPIRADA);
					if (!UValidador.estaVacio(nuevaPantallaError)) {
						outcome = nuevaPantallaError;
					}
					if (binding!=null)
						binding.limpiarHerramientasLista();
				} else {
					LOGGER.debug("redirigiendo pantalla");
					LOGGER.debug(outcome);

					if (seguridadFactory == null)
						seguridadFactory = (FactoryErpSeguridad) UAplicacion
								.getSpringBean("BeanFactorySeguridad");
					
                  if(!UValidador.esNulo(seguridadFactory))
					con = seguridadFactory.getSeguridadconceptoServicio()
							.buscarPorNombreObjeto(codigoAplicacion, outcome);

					/**
					 * se quito el ( else binding.limpiarHerramientasLista(); )
					 * porque no se mostraban los menus cuando se daba nuevo o
					 * editar
					 * **/
					if (con != null) {
						binding.iniciarHerramientasLista(con);

						// se comenta porque esto genera conflictos con otros
						// navigation case que no vienen
						// desde el menu
						// binding.setAccionPantalla(accion_solicitada.LISTAR);
					}

				}

			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			e.printStackTrace();
		}
		parent.handleNavigation(fc, from, outcome);
	}
}