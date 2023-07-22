package net.royal.seguridad.vista.controladora;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import net.royal.framework.web.controladora.UBaseBindingController;
import net.royal.framework.web.controladora.UBaseController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.controladora.UIWebControlContext;
import net.royal.framework.web.controladora.UWebControlContextPrimefaces;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.factory.FactoryErpSeguridad;

public class UBindingController extends UBaseBindingController implements UIBindingController, Serializable {

	protected static Logger LOGGER = Logger.getLogger(UBindingController.class);

	private UIWebControlContext iWebControlContext;
	// private String nombreArchivoAyuda = "BLANCO";
	private String archivoAyudaHtml;

	@ManagedProperty(value = "#{BeanFactorySeguridad}")
	private FactoryErpSeguridad seguridadFactory;

	public UBindingController() {
		iWebControlContext = new UWebControlContextPrimefaces();
	}

	public FactoryErpSeguridad getSeguridadFactory() {
		return seguridadFactory;
	}

	public void setSeguridadFactory(FactoryErpSeguridad seguridadFactory) {
		this.seguridadFactory = seguridadFactory;
	}

	public void iniciarHeaderNavegacion() {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_aplicacion", String.class, this.getIdCodigoAplicacion()));
		filtros.add(new ParametroPersistenciaGenerico("p_grupo", String.class, this.getIdCodigoGrupo()));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, this.getIdCodigoConcepto()));

		List data = seguridadFactory.getSeguridadconceptoServicio().listarConceptoNavegacion(DominioGenerico.class,
				filtros);
		LOGGER.debug(data.size());
		this.setListaMenuNavegacion(data);

	}

	public void iniciarHerramientasLista(Seguridadconcepto seguridadConcepto) {
		this.setVerAyuda(false);
		this.setVerProceso(false);
		archivoAyudaHtml = null;

		if (seguridadConcepto == null)
			return;

		// IMPLEMENTAR
		/*
		 * LOGGER.debug(seguridadConcepto.getArchivoAyudaHtml());
		 * 
		 * this.setIdProcesoActual(seguridadConcepto.getIdProceso());
		 * this.setIdSeguridadConceptoActual(seguridadConcepto.getCodigoCompleto
		 * ());
		 * 
		 * if (this.getIdProcesoActual() == null) this.setIdProcesoActual(0);
		 * 
		 * 
		 * if (seguridadConcepto.getArchivoAyudaHtml()!=null) { LOGGER.debug(
		 * "ver ayuda"); archivoAyudaHtml = new
		 * String(seguridadConcepto.getArchivoAyudaHtml());
		 * this.setVerAyuda(true); }
		 */

		this.setIdCodigoAplicacion(seguridadConcepto.getPk().getAplicacioncodigo());
		this.setIdCodigoGrupo(seguridadConcepto.getPk().getGrupo());
		this.setIdCodigoConcepto(seguridadConcepto.getPk().getConcepto());

		this.setNombreSeguridadConceptoActual(seguridadConcepto.getDescripcion());
		if (this.getNombreSeguridadConceptoActual() == null)
			this.setNombreSeguridadConceptoActual(seguridadConcepto.getDescripcion());

		if (this.getIdProcesoActual() > 0) {
			/*
			 * SnProceso pro; SnProcesoPk pkpro = new SnProcesoPk();
			 * pkpro.setIdProceso(idProcesoActual); pro = (SnProceso)
			 * CBaseBean.getInstance().factoryBase
			 * .getSnProcesoServicio().obtenerPorId(pkpro);
			 * this.nombreProcesoActual = pro.getNombre();
			 */
		}

		iniciarHeaderNavegacion();
	}

	public UIWebControlContext getWebControlContext() {
		return iWebControlContext;
	}

	public void llamarAyuda() {
		LOGGER.debug("llamarAyuda");
		if (this.getIdSeguridadConceptoActual() == null) {
			LOGGER.debug("idSeguridadConceptoActual es nulo");
			return;
		}
		this.getWebControlContext().ejecutar("PF('popAyudaEmergente').show();");
	}

	public void llamarFlujo() {
		LOGGER.debug("llamarFlujo");
		if (this.getIdProcesoActual() == null) {
			LOGGER.debug("idProcesoActual nulo");
			return;
		}
		if (this.getIdProcesoActual() == 0) {
			LOGGER.debug("idProcesoActual en 0");
			return;
		}
		this.getWebControlContext().ejecutar("PF('popFlujoEmergente').show();");

	}

	@Override
	public void setAccionPantalla(accion_solicitada accionPantalla) {

		UIComunSession comunSession = UFaces.getControladora(UConstante.SESION_BEAN_COMUNSESSIONCONTROLLER,
				UIComunSession.class);

		comunSession.parametroAgregar(UConstante.SESION_FORMULARIO_ACCION_SOLICITADA, accionPantalla);

		if (accionPantalla == null) {
			this.setPantallaTituloAccion("");
			UAplicacion.setSessionValue(UConstante.SESION_FORMULARIO_ACCION_SOLICITADA, accionPantalla);
			return;
		}

		if (accionPantalla == accion_solicitada.NUEVO) {
			this.setPantallaTituloAccion(UBaseController.getMessageProperty("generico_accion_nuevo"));
		}
		if (accionPantalla == accion_solicitada.LISTAR) {
			this.setPantallaTituloAccion(UBaseController.getMessageProperty("generico_accion_listar"));
		}
		if (accionPantalla == accion_solicitada.EDITAR) {
			this.setPantallaTituloAccion(UBaseController.getMessageProperty("generico_accion_editar"));
		}
		if (accionPantalla == accion_solicitada.VER) {
			this.setPantallaTituloAccion(UBaseController.getMessageProperty("generico_accion_ver"));
		}

		UAplicacion.setSessionValue(UConstante.SESION_FORMULARIO_ACCION_SOLICITADA, accionPantalla);
	}

	public String getArchivoAyudaHtml() {
		return archivoAyudaHtml;
	}

	public void setArchivoAyudaHtml(String archivoAyudaHtml) {
		this.archivoAyudaHtml = archivoAyudaHtml;
	}

	
}
