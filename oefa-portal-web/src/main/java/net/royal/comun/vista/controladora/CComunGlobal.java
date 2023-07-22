package net.royal.comun.vista.controladora;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import net.royal.erp.alfresco.factory.FactoryAlfresco;
import net.royal.erp.asistencia.factory.FactoryErpAsistencia;
import net.royal.erp.contabilidad.factory.FactoryErpContabilidad;
import net.royal.erp.core.factory.FactoryErpCore;
import net.royal.erp.mantenimiento.factory.FactoryErpMantenimiento;
import net.royal.erp.planilla.factory.FactoryErpPlanilla;
import net.royal.erp.presupuesto.factory.FactoryErpPresupuesto;
import net.royal.erp.rrhh.factory.FactoryErpRrhh;
import net.royal.erp.sistema.factory.FactoryErpSistema;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.seguridad.vista.controladora.UComunGlobal;

import org.springframework.context.annotation.Scope;

@ManagedBean
@Scope("globalSession")
public class CComunGlobal extends UComunGlobal {

	public static CComunGlobal getInstance() {

		return UFaces.getControladora(
				UConstante.SESION_BEAN_GLOBALSESSIONCONTROLLER,
				CComunGlobal.class);
	}


	@ManagedProperty(value = "#{BeanFactoryErpAsistencia}")
	private FactoryErpAsistencia facAsistencia;

	public FactoryErpAsistencia getFacAsistencia() {
		return facAsistencia;
	}

	public void setFacAsistencia(FactoryErpAsistencia facAsistencia) {
		this.facAsistencia = facAsistencia;
	}

	@ManagedProperty(value = "#{BeanFactoryErpSistema}")
	private FactoryErpSistema facSistema;

	public FactoryErpSistema getFacSistema() {
		return facSistema;
	}

	public void setFacSistema(FactoryErpSistema facSistema) {
		this.facSistema = facSistema;
	}

	@ManagedProperty(value = "#{BeanFactoryErpCore}")
	private FactoryErpCore facCore;

	public FactoryErpCore getFacCore() {
		return facCore;
	}

	public void setFacCore(FactoryErpCore facCore) {
		this.facCore = facCore;
	}

	@ManagedProperty(value = "#{BeanFactoryErpContabilidad}")
	private FactoryErpContabilidad facContabilidad;

	public FactoryErpContabilidad getFacContabilidad() {
		return facContabilidad;
	}

	public void setFacContabilidad(FactoryErpContabilidad facContabilidad) {
		this.facContabilidad = facContabilidad;
	}

	@ManagedProperty(value = "#{BeanFactoryErpPresupuesto}")
	private FactoryErpPresupuesto facPresupuesto;

	public FactoryErpPresupuesto getFacPresupuesto() {
		return facPresupuesto;
	}

	public void setFacPresupuesto(FactoryErpPresupuesto facPresupuesto) {
		this.facPresupuesto = facPresupuesto;
	}

	@ManagedProperty(value = "#{BeanFactoryErpRrhh}")
	private FactoryErpRrhh facRrhh;

	public FactoryErpRrhh getFacRrhh() {
		return facRrhh;
	}

	public void setFacRrhh(FactoryErpRrhh facRrhh) {
		this.facRrhh = facRrhh;
	}

	@ManagedProperty(value = "#{BeanFactoryErpPlanilla}")
	private FactoryErpPlanilla facPlanilla;

	public FactoryErpPlanilla getFacPlanilla() {
		return facPlanilla;
	}

	public void setFacPlanilla(FactoryErpPlanilla facPlanilla) {
		this.facPlanilla = facPlanilla;
	}

	@ManagedProperty(value = "#{BeanFactoryErpMantenimiento}")
	private FactoryErpMantenimiento facMantenimiento;

	public FactoryErpMantenimiento getFacMantenimiento() {
		return facMantenimiento;
	}

	public void setFacMantenimiento(FactoryErpMantenimiento facMantenimiento) {
		this.facMantenimiento = facMantenimiento;
	}
	
	

	@ManagedProperty(value = "#{BeanFactoryAlfresco}")
	private FactoryAlfresco facAlfresco;

	public FactoryAlfresco getFacAlfresco() {
		return facAlfresco;
	}

	public void setFacAlfresco(FactoryAlfresco facAlfresco) {
		this.facAlfresco = facAlfresco;
	}

}
