package net.royal.comun.vista.controladora;

import java.io.Serializable;

import net.royal.erp.alfresco.factory.FactoryAlfresco;
import net.royal.erp.asistencia.factory.FactoryErpAsistencia;
import net.royal.erp.contabilidad.factory.FactoryErpContabilidad;
import net.royal.erp.core.factory.FactoryErpCore;
import net.royal.erp.mantenimiento.factory.FactoryErpMantenimiento;
import net.royal.erp.planilla.factory.FactoryErpPlanilla;
import net.royal.erp.presupuesto.factory.FactoryErpPresupuesto;
import net.royal.erp.rrhh.factory.FactoryErpRrhh;
import net.royal.erp.sistema.factory.FactoryErpSistema;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.SeguridadOperaciones;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.seguridad.factory.FactoryErpSeguridad;
import net.royal.seguridad.vista.controladora.UBaseBean;
import pe.gob.oefa.ws.alfresco.service.UOsinergminAlfresco;

import org.apache.log4j.Logger;

public class CBaseBean extends UBaseBean implements Serializable {

	protected static Logger LOGGER = Logger.getLogger(CBaseBean.class);

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Tesoreria (AP)
	 */

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Control Patrimonial (FA)
	 */

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Seguridad (SG)
	 */
	public FactoryErpSeguridad getFacSeguridad() {
		return CComunGlobal.getInstance().getFacSeguridad();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Mantenimiento (ME)
	 */
	public FactoryErpMantenimiento getFacMantenimiento() {
		return CComunGlobal.getInstance().getFacMantenimiento();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Planilla (PR)
	 */
	public FactoryErpPlanilla getFacPlanilla() {
		return CComunGlobal.getInstance().getFacPlanilla();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Presupuesto (BU)
	 */
	public FactoryErpPresupuesto getFacPresupuesto() {
		return CComunGlobal.getInstance().getFacPresupuesto();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Contabilidad (AC)
	 */
	public FactoryErpContabilidad getFacContabilidad() {
		return CComunGlobal.getInstance().getFacContabilidad();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Tesoreria (AP)
	 */
	/*
	 * public FactoryErpTesoreria getFacTesoreria() { return
	 * CComunGlobal.getInstance().getFacTesoreria(); }
	 */

	/**
	 * @author desarrollo
	 * @hibernate Modulo de RRHH (HR)
	 */
	public FactoryErpRrhh getFacRrhh() {
		return CComunGlobal.getInstance().getFacRrhh();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Asistencia (AS)
	 */
	public FactoryErpAsistencia getFacAsistencia() {
		return CComunGlobal.getInstance().getFacAsistencia();
	}

	/**
	 * @author desarrollo
	 * @hibernate Tablas Maestras (sin nomenclatura)
	 */
	public FactoryErpCore getFacCore() {
		return CComunGlobal.getInstance().getFacCore();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Configuracion (SY)
	 */
	public FactoryErpSistema getFacSistema() {
		return CComunGlobal.getInstance().getFacSistema();
	}

	/**
	 * @author desarrollo
	 * @hibernate Modulo de Seguridad (SG)
	 */
	public FactoryAlfresco getFacAlfresco() {
		return CComunGlobal.getInstance().getFacAlfresco();
	}

	public String generarTituloReferente(UsuarioActual hrPostulantes) {
		String nombreCompleto = "";
		if (hrPostulantes == null)
			return "";
		nombreCompleto = hrPostulantes.getNombres();
		if (nombreCompleto == null)
			nombreCompleto = "";
		if (hrPostulantes.getApellidoPaterno() != null)
			nombreCompleto = nombreCompleto + " " + hrPostulantes.getApellidoPaterno();
		if (hrPostulantes.getApellidoMaterno() != null)
			nombreCompleto = nombreCompleto + " " + hrPostulantes.getApellidoMaterno();
		return nombreCompleto;
	}

	protected SeguridadOperaciones leerSeguridadOperaciones(String aplicacion, String grupo, String concepto,
			String usuario) {
		// TODO Auto-generated method stub
		SeguridadOperaciones permisos = getFacSeguridad().getSeguridadautorizacionesServicio().leerOpciones(aplicacion,
				grupo, concepto, usuario);
		return permisos;
	}

	private UOsinergminAlfresco uOsinergminAlfresco;

	public UOsinergminAlfresco getuOsinergminAlfresco() {
		if (UValidador.esNulo(uOsinergminAlfresco)) {
			uOsinergminAlfresco = new UOsinergminAlfresco();
		}
		return uOsinergminAlfresco;
	}

}
