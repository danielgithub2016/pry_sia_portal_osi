package net.royal.rrhh.vista.controladora;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrActividad;
import net.royal.erp.rrhh.dominio.HrActividadPk;
import net.royal.erp.rrhh.dominio.HrActividadparticipante;
import net.royal.erp.rrhh.dominio.HrActividadparticipantePk;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CHrEncuesta extends CBaseBean implements UIMantenimientoController {

	private DtoHrEncuesta filtro;
	private DtoHrEncuesta registroSeleccionado;
	private List<DtoHrEncuesta> lstDatos;
	private Integer segundosPrimeraEncuesta;


	public CHrEncuesta() {
		this.PANTALLA_LISTADO = "encuestaLista";
		this.PANTALLA_MANTENIMIENTO = "encuesta_ejecucion";
	}

	public static CHrEncuesta getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrEncuesta}", CHrEncuesta.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.setAccionPantalla(accion_solicitada.LISTAR);
		this.inicializarFiltrosListado();
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		if (UValidador.estaVacio(filtro.getFechaFiltro()))
			filtro.setFechaFiltro(null);
		if (UValidador.estaVacio(filtro.getEstado()))
			filtro.setEstado(null);

		filtro.setFechaFiltro(new Date());
		filtro.setEstado(ConstanteRrhh.ENCUESTA_ESTADO_EJECUCION);

		lstDatos = new ArrayList<DtoHrEncuesta>();

		LOGGER.debug(this.getUsuarioActual().getIdPersona());

		List<DtoHrEncuesta> lstDatosFull = this.getFacRrhh().getHrEncuestaServicio()
				.listarHrEncuesta(filtro.getEstado(), filtro.getFechaFiltro(), this.getUsuarioActual().getIdPersona());

		if (UValidador.esNulo(lstDatosFull))
			lstDatosFull = new ArrayList<DtoHrEncuesta>();

		LOGGER.debug("LISTA DE ENCUESTA " + lstDatosFull.size());

		for (int i = 0; i < lstDatosFull.size(); i++) {

			// TIPO ACTIVIDAD
			if (lstDatosFull.get(i).getTipoencuesta().equals(ConstanteRrhh.ENCUESTA_TIPO_ACTIVIDAD)
					|| lstDatosFull.get(i).getTipoencuesta().equals(ConstanteRrhh.ENCUESTA_TIPO_BIENESTAR)) {

				// Se obtiene la actividad de la encuesta
				HrActividadPk actiPk = new HrActividadPk();
				actiPk.setActividad(lstDatosFull.get(i).getActividad());
				actiPk.setCompanyowner(lstDatosFull.get(i).getCompanyowner());

				HrActividad actividad = (HrActividad) this.getFacRrhh().getHrActividadServicio().obtenerPorId(actiPk);

				if (!UValidador.esNulo(actividad)) {
					// Se verifica si el usuario esta participando de la
					// actividad
					HrActividadparticipantePk pkPart = new HrActividadparticipantePk();
					pkPart.setActividad(actividad.getPk().getActividad());
					pkPart.setCompanyowner(actividad.getPk().getCompanyowner());
					pkPart.setEmpleado(this.getUsuarioActual().getIdPersona());
					pkPart.setTipoactividad(actividad.getTipoactividad());

					HrActividadparticipante actPart = (HrActividadparticipante) this.getFacRrhh()
							.getHrActividadparticipanteServicio().obtenerPorId(pkPart);

					if (!UValidador.esNulo(actPart)) {
						// Si existe, se toma la encuesta
						lstDatos.add(lstDatosFull.get(i));
					}
				}

			} else if (lstDatosFull.get(i).getTipoencuesta().equals(ConstanteRrhh.ENCUESTA_TIPO_CLIMA)) {
				lstDatos.add(lstDatosFull.get(i));

			} else if (lstDatosFull.get(i).getTipoencuesta().equals(ConstanteRrhh.ENCUESTA_TIPO_CAPACITACION)) {
				HrEmpleadocapacitacionPk pk = new HrEmpleadocapacitacionPk();
				pk.setCapacitacion(lstDatosFull.get(i).getCapacitacion());
				pk.setEmpleado(this.getUsuarioActual().getIdPersona());

				HrEmpleadocapacitacion empCap = (HrEmpleadocapacitacion) this.getFacRrhh()
						.getHrEmpleadocapacitacionServicio().obtenerPorId(pk);

				if (!UValidador.esNulo(empCap)) {
					// Si existe, se toma la encuesta
					lstDatos.add(lstDatosFull.get(i));
				}

			}
		}

		Date fechamin = null;
		for (DtoHrEncuesta d : lstDatos) {

			if (UValidador.esNulo(fechamin)) {
				fechamin = d.getFechafin();
			}

			if (d.getFechafin().before(fechamin))
				fechamin = d.getFechafin();

		}

		if (!UValidador.esNulo(fechamin)) {
			GregorianCalendar fec1 = new GregorianCalendar();
			fec1.setTime(fechamin);

			GregorianCalendar fec2 = new GregorianCalendar();
			fec2.setTime(new Date());

			Long difms = fec1.getTimeInMillis() - fec2.getTimeInMillis();
			Long secs = difms / 1000;
			segundosPrimeraEncuesta = secs.intValue();
			LOGGER.debug(fechamin);
			LOGGER.debug(segundosPrimeraEncuesta);
		}

		return null;
	}

	@Override
	public String nuevo() throws Exception {
		this.setAccionPantalla(accion_solicitada.NUEVO);
		return this.PANTALLA_MANTENIMIENTO;
	}

	@Override
	public String editar() throws Exception {

		if (!validar()) {
			return null;
		}
		this.setAccionPantalla(accion_solicitada.EDITAR);

		CEjecutarEncuesta.getInstance().setEncuesta(registroSeleccionado);
		CEjecutarEncuesta.getInstance().iniciarControladora();
		return this.PANTALLA_MANTENIMIENTO;
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
		Date fechaActual = new Date();
		if (registroSeleccionado.getFechainicio() == null) {
			return false;
		}
		if (registroSeleccionado.getFechafin() == null) {
			return false;
		}

		Date fechaInicio = UFechaHora.obtenerFechaHoraInicioDia(registroSeleccionado.getFechainicio());
		Date fechaFin = UFechaHora.obtenerFechaHoraFinDia(registroSeleccionado.getFechafin());

		if (fechaActual.before(fechaInicio)) {
			setMessageError("Estas fuera del rango de fechas indicadas");
			return false;
		}

		if (fechaActual.after(fechaFin)) {
			setMessageError("Estas fuera del rango de fechas indicadas");
			return false;
		}

		return true;
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
		filtro = new DtoHrEncuesta();
		
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		return null;
	}

	public Integer retornaNotificaciones() throws Exception {
		this.inicializarFiltrosListado();
		buscar();

		return lstDatos.size();
	}

	public DtoHrEncuesta getFiltro() {
		return filtro;
	}

	public void setFiltro(DtoHrEncuesta filtro) {
		this.filtro = filtro;
	}

	public DtoHrEncuesta getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoHrEncuesta registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public List<DtoHrEncuesta> getLstDatos() {
		return lstDatos;
	}

	public void setLstDatos(List<DtoHrEncuesta> lstDatos) {
		this.lstDatos = lstDatos;
	}

	public Integer getSegundosPrimeraEncuesta() {
		return segundosPrimeraEncuesta;
	}

	public void setSegundosPrimeraEncuesta(Integer segundosPrimeraEncuesta) {
		this.segundosPrimeraEncuesta = segundosPrimeraEncuesta;
	}

}
