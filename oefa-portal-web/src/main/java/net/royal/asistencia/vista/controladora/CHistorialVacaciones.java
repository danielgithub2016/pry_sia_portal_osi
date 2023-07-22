package net.royal.asistencia.vista.controladora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionPeriodo;
import net.royal.erp.planilla.dominio.dto.DtoPrVacacionUtilizacion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SessionScoped
@ManagedBean

public class CHistorialVacaciones extends CBaseBean implements UIMantenimientoController {

	private Integer empleado;
	private Integer nroperiodo;
	private List<DtoPrVacacionPeriodo> lstPeriodoVacion;
	private List<DtoPrVacacionUtilizacion> lstVacacionUtilizacion;
	private BigDecimal totalDias;

	public static CHistorialVacaciones getInstance() {
		return UFaces.evaluateExpressionGet("#{cHistorialVacaciones}", CHistorialVacaciones.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub

		buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		lstPeriodoVacion = getFacPlanilla().getPrVacacionesprogramadasServicio().listarVacacionPeriodo(empleado);
		lstVacacionUtilizacion = new ArrayList<>();
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void verUtilizacion() {
		totalDias = BigDecimal.ZERO;
		lstVacacionUtilizacion = getFacPlanilla().getPrVacacionesprogramadasServicio()
				.listarVacacionUtilizacion(empleado, nroperiodo);

		if (!UValidador.esListaVacia(lstVacacionUtilizacion)) {
			for (DtoPrVacacionUtilizacion obj : lstVacacionUtilizacion) {
				if (!obj.getUtilizacion().equals("SEF")){
					totalDias = totalDias.add(obj.getDias());
				}
			}
		}
	}

	public List<DtoPrVacacionPeriodo> getLstPeriodoVacion() {
		return lstPeriodoVacion;
	}

	public void setLstPeriodoVacion(List<DtoPrVacacionPeriodo> lstPeriodoVacion) {
		this.lstPeriodoVacion = lstPeriodoVacion;
	}

	public List<DtoPrVacacionUtilizacion> getLstVacacionUtilizacion() {
		return lstVacacionUtilizacion;
	}

	public void setLstVacacionUtilizacion(List<DtoPrVacacionUtilizacion> lstVacacionUtilizacion) {
		this.lstVacacionUtilizacion = lstVacacionUtilizacion;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getNroperiodo() {
		return nroperiodo;
	}

	public void setNroperiodo(Integer nroperiodo) {
		this.nroperiodo = nroperiodo;
	}

	public BigDecimal getTotalDias() {
		return totalDias;
	}

	public void setTotalDias(BigDecimal totalDias) {
		this.totalDias = totalDias;
	}

}
