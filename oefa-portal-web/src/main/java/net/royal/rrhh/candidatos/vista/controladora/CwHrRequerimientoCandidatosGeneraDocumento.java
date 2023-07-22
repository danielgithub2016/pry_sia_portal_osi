package net.royal.rrhh.candidatos.vista.controladora;

import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionRequirimiento;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoPosition;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeControllerGenerico;


@ManagedBean
@SessionScoped
public class CwHrRequerimientoCandidatosGeneraDocumento extends CBaseBean implements UIMantenimientoController {

	private String eventname;
	private DtoDwHrRequerimientoPosition dw_position;
	private HashMap<String, Object> ivKeyRequerimiento;
	private List<DtoHrEvaluacion> lstEvaluacion;
	private List<DtoHrEvaluacionRequirimiento> lstRequerimiento;
	
	private static final long serialVersionUID = 1L;

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		return this.PANTALLA_LISTADO;
	}
	
	public CwHrRequerimientoCandidatosGeneraDocumento() {
		this.PANTALLA_LISTADO = "genera_documento_etapa_seleccion";
	}
	
	public static CwHrRequerimientoCandidatosGeneraDocumento getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrRequerimientoCandidatosGeneraDocumento}",
				CwHrRequerimientoCandidatosGeneraDocumento.class);
	}

	public void inicializarAcciones() throws Exception {
		
	}

	@Override
	public String buscar() throws Exception {	
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		return null;
	}

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public String ver() throws Exception {
		
		
		
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		return null;
	}

	@Override
	public String guardar() throws Exception {
		return null;
	}

	@Override
	public String salir() throws Exception {
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		
		lstEvaluacion = getFacRrhh().getHrEvaluacionServicio().listarDescripcion();
		lstRequerimiento = getFacRrhh().getHrEvaluacionRequerimientoServicio().listarDescripcion();
		LOGGER.debug(lstRequerimiento);
		
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public DtoDwHrRequerimientoPosition getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwHrRequerimientoPosition dw_position) {
		this.dw_position = dw_position;
	}

	public HashMap<String, Object> getIvKeyRequerimiento() {
		return ivKeyRequerimiento;
	}

	public void setIvKeyRequerimiento(HashMap<String, Object> ivKeyRequerimiento) {
		this.ivKeyRequerimiento = ivKeyRequerimiento;
	}

	public List<DtoHrEvaluacion> getLstEvaluacion() {
		return lstEvaluacion;
	}

	public void setLstEvaluacion(List<DtoHrEvaluacion> lstEvaluacion) {
		this.lstEvaluacion = lstEvaluacion;
	}

	public List<DtoHrEvaluacionRequirimiento> getLstRequerimiento() {
		return lstRequerimiento;
	}

	public void setLstRequerimiento(List<DtoHrEvaluacionRequirimiento> lstRequerimiento) {
		this.lstRequerimiento = lstRequerimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
