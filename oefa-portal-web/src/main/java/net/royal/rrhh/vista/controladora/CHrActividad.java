package net.royal.rrhh.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrActividad;
import net.royal.erp.rrhh.dominio.HrActividadparticipante;
import net.royal.erp.rrhh.dominio.HrActividadparticipantePk;
import net.royal.erp.rrhh.dominio.dto.DtoHrActividad;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CHrActividad extends CBaseBean implements
		UIMantenimientoController {

	private List<DtoHrActividad> lstDatos;
	private DtoHrActividad filtro;
	private DtoHrActividad registroSeleccionado;
	private HrActividad bean;
	private HrActividadparticipante beanParticipante;
	private BigDecimal montoDonativo;
	private Integer segundosPrimeraActividad;

	private Integer listaNotificacion;
	private Integer listaNotificacionE;
	private Integer listaNotificacionDP1;
	private Integer listaNotificacionDP2;

	public static CHrActividad getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrActividad}",
				CHrActividad.class);
	}

	public CHrActividad() {
		this.PANTALLA_LISTADO = "actividadLista";
		this.PANTALLA_MANTENIMIENTO = "";
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {

		List<DtoHrActividad> actividadFull;

		if (UValidador.estaVacio(filtro.getFlagpublicacion()))
			filtro.setFlagpublicacion(null);
		if (UValidador.estaVacio(filtro.getEstado()))
			filtro.setEstado(null);
		if (UValidador.estaVacio(filtro.getFechafiltro()))
			filtro.setFechafiltro(null);

		//
		filtro.setEstado(ConstanteRrhh.ACTIVIDAD_ESTADO_EJECUCION);
		filtro.setFlagpublicacion(ConstanteRrhh.ACTIVIDAD_PUBLICADO);
		filtro.setFechafiltro(new Date());
		//

		LOGGER.debug(filtro.getFlagpublicacion());

		lstDatos = new ArrayList<DtoHrActividad>();

		// Cambio 17/09/2015 - Ya no se toma el estado

		actividadFull = this
				.getFacRrhh()
				.getHrActividadServicio()
				.listarHrActividad(filtro.getFlagpublicacion(),
						filtro.getFechafiltro(), filtro.getEstado(),
						this.getUsuarioActual().getIdPersona());

		if (UValidador.esNulo(actividadFull))
			actividadFull = new ArrayList<DtoHrActividad>();

		LOGGER.debug("LISTAR ACTIVIDADES POR FECHA : " + actividadFull.size());

		for (int i = 0; i < actividadFull.size(); i++) {

			if (actividadFull.get(i).getTipoactividad()
					.equals(ConstanteRrhh.ACTIVIDAD_TIPO_ACTIVIDAD)) {
			//AHORA MUESTRA A TODAS LAS QUE ESTAN EN ESTADO APROBADAS Y EJECUTADAS
				
					// Específica
					if (ConstanteRrhh.ACTIVIDAD_ESTRATEGIA_ESPECIFICA.equals(actividadFull
							.get(i)
							.getCodigoestrategia())) {
						HrActividadparticipantePk pk = new HrActividadparticipantePk();
						pk.setActividad(actividadFull.get(i).getActividad());
						pk.setCompanyowner(actividadFull.get(i)
								.getCompanyowner());
						pk.setEmpleado(this.getUsuarioActual().getIdPersona());
						pk.setTipoactividad(actividadFull.get(i)
								.getTipoactividad());

						HrActividadparticipante par = (HrActividadparticipante) this
								.getFacRrhh()
								.getHrActividadparticipanteServicio()
								.obtenerPorId(pk);

						if (!UValidador.esNulo(par)) {
							lstDatos.add(actividadFull.get(i));
						}
					} else if (ConstanteRrhh.ACTIVIDAD_ESTRATEGIA_ENTIDAD.equals(actividadFull.get(i).getCodigoestrategia())) {
						lstDatos.add(actividadFull.get(i));
					}
				//}

			} else if (ConstanteRrhh.ACTIVIDAD_TIPO_BIENESTAR.equals(actividadFull.get(i).getTipoactividad())) {
				if (ConstanteRrhh.ACTIVIDAD_ESTADO_APROBADO.equals(actividadFull.get(i).getEstado())) {
					// Específica
					if (ConstanteRrhh.ACTIVIDAD_ESTRATEGIA_ESPECIFICA.equals(actividadFull
							.get(i)
							.getCodigoestrategia())) {
						HrActividadparticipantePk pk = new HrActividadparticipantePk();
						pk.setActividad(actividadFull.get(i).getActividad());
						pk.setCompanyowner(actividadFull.get(i)
								.getCompanyowner());
						pk.setEmpleado(this.getUsuarioActual().getIdPersona());
						pk.setTipoactividad(actividadFull.get(i)
								.getTipoactividad());

						HrActividadparticipante par = (HrActividadparticipante) this
								.getFacRrhh()
								.getHrActividadparticipanteServicio()
								.obtenerPorId(pk);

						if (!UValidador.esNulo(par)) {
							lstDatos.add(actividadFull.get(i));
						}
					} else if (ConstanteRrhh.ACTIVIDAD_ESTRATEGIA_ENTIDAD.equals(actividadFull.get(i).getCodigoestrategia())) {
						lstDatos.add(actividadFull.get(i));
					}
				}
			}

		}

		Date fechamin = null;

		for (DtoHrActividad a : lstDatos) {

			if (UValidador.esNulo(fechamin)) {
				fechamin = a.getFechahastapublicacion();
			}
			if (a.getFechahastapublicacion().before(fechamin))
				fechamin = a.getFechahastapublicacion();

			Calendar c1, c2;
			c1 = Calendar.getInstance();
			c1.setTime(a.getFechadesde());
			c2 = Calendar.getInstance();
			c2.setTime(a.getFechahasta());

			if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
					&& c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
					&& c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)
					&& c1.get(Calendar.HOUR_OF_DAY) == c2.get(Calendar.HOUR_OF_DAY)
					&& c1.get(Calendar.MINUTE) == c2.get(Calendar.MINUTE)) {
				a.setFechaevento("<strong>"
						+ new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(c1
								.getTime()) + "</strong>");
			} else {
				a.setFechaevento("<strong>"
						+ new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(c1
								.getTime())
						+ "</strong>"
						+ "<br/>  hasta <br/><strong>"
						+ new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(c2
								.getTime()) + "</strong>");
			}
		}

		if (!UValidador.esNulo(fechamin)) {
			GregorianCalendar fec1 = new GregorianCalendar();
			fec1.setTime(fechamin);

			GregorianCalendar fec2 = new GregorianCalendar();
			fec2.setTime(new Date());

			Long difms = fec1.getTimeInMillis() - fec2.getTimeInMillis();
			Long secs = difms / 1000;
			segundosPrimeraActividad = secs.intValue();
			LOGGER.debug(fechamin);
			LOGGER.debug(segundosPrimeraActividad);
		}

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

	public String participar() throws Exception {

		if (!validar()) {
			return null;
		}

		this.getBindingController().setAuditoriaNuevo();
		HrActividadparticipantePk pk = new HrActividadparticipantePk();
		pk.setActividad(registroSeleccionado.getActividad());
		pk.setCompanyowner(registroSeleccionado.getCompanyowner());
		pk.setEmpleado(this.getUsuarioActual().getIdPersona());
		pk.setTipoactividad(registroSeleccionado.getTipoactividad());

		beanParticipante = (HrActividadparticipante) this.getFacRrhh()
				.getHrActividadparticipanteServicio().obtenerPorId(pk);

		if (UValidador.esNulo(beanParticipante)) {

			beanParticipante = new HrActividadparticipante();
			beanParticipante.setPk(pk);
			beanParticipante
					.setFlagasistencia(ConstanteRrhh.ACTIVIDAD_PARTICIPANTE_ASISTIO);
			beanParticipante = (HrActividadparticipante) this
					.getBindingController().getAuditoriaNuevo(beanParticipante);
			this.getFacRrhh().getHrActividadparticipanteServicio()
					.registrar(beanParticipante);
		} else {
			beanParticipante
					.setFlagasistencia(ConstanteRrhh.ACTIVIDAD_PUBLICADO);
			beanParticipante = (HrActividadparticipante) this
					.getBindingController().getAuditoriaModificar(
							beanParticipante);
			this.getFacRrhh().getHrActividadparticipanteServicio()
					.actualizar(beanParticipante);
		}

		this.setMessageSuccess("Su participación fué registrada");
		buscar();
		this.getWebControlContext().actualizar(
				"frmActividades_lista:dtActividades");
		return null;
	}

	public String retirar() throws Exception {
		if (!validar())
			return null;

		HrActividadparticipantePk pk = new HrActividadparticipantePk();
		pk.setActividad(registroSeleccionado.getActividad());
		pk.setCompanyowner(registroSeleccionado.getCompanyowner());
		pk.setEmpleado(this.getUsuarioActual().getIdPersona());
		pk.setTipoactividad(registroSeleccionado.getTipoactividad());

		beanParticipante = (HrActividadparticipante) this.getFacRrhh()
				.getHrActividadparticipanteServicio().obtenerPorId(pk);

		this.getFacRrhh().getHrActividadparticipanteServicio()
				.eliminar(beanParticipante);
		this.setMessageSuccess("Su participación fué retirada");
		buscar();
		this.getWebControlContext().actualizar(
				"frmActividades_lista:dtActividades");
		return null;
	}

	public String donar() throws Exception {
		this.getBindingController().setAuditoriaNuevo();

		if (!validar())
			return null;

		if (montoDonativo.compareTo(BigDecimal.ZERO) == 0
				|| montoDonativo.compareTo(BigDecimal.ZERO) == -1) {
			this.setMessageError("Ingrese un monto mayor a cero");
			return null;
		}

		HrActividadparticipantePk pk = new HrActividadparticipantePk();
		pk.setActividad(registroSeleccionado.getActividad());
		pk.setCompanyowner(registroSeleccionado.getCompanyowner());
		pk.setEmpleado(this.getUsuarioActual().getIdPersona());
		pk.setTipoactividad(registroSeleccionado.getTipoactividad());

		beanParticipante = (HrActividadparticipante) this.getFacRrhh()
				.getHrActividadparticipanteServicio().obtenerPorId(pk);

		if (UValidador.esNulo(beanParticipante)) {
			beanParticipante = new HrActividadparticipante();
			beanParticipante.setPk(pk);
			beanParticipante.setMonto(montoDonativo);
			beanParticipante
					.setFlagasistencia(ConstanteRrhh.ACTIVIDAD_PARTICIPANTE_ASISTIO);
			beanParticipante = (HrActividadparticipante) this
					.getBindingController().getAuditoriaNuevo(beanParticipante);
			this.getFacRrhh().getHrActividadparticipanteServicio()
					.registrar(beanParticipante);
		} else {

			if ((UValidador.esNulo(beanParticipante.getFlagasistencia()) ? ConstanteRrhh.ACTIVIDAD_PARTICIPANTE_NO_ASISTIO
					: beanParticipante.getFlagasistencia())
					.equals(ConstanteRrhh.ACTIVIDAD_PARTICIPANTE_NO_ASISTIO)) {
				beanParticipante.setMonto(montoDonativo);
				beanParticipante
						.setFlagasistencia(ConstanteRrhh.ACTIVIDAD_PARTICIPANTE_ASISTIO);
				beanParticipante = (HrActividadparticipante) this
						.getBindingController().getAuditoriaModificar(
								beanParticipante);
				this.getFacRrhh().getHrActividadparticipanteServicio()
						.actualizar(beanParticipante);
			} else {
				setMessageError("Ya se realizo la donacion");
				return null;
			}
		}

		enviarCorreos();

		montoDonativo = BigDecimal.ZERO;
		this.setMessageSuccess("Su donación fué registrada");
		this.getWebControlContext().ejecutar("PF('popDonar').hide()");
		buscar();
		this.getWebControlContext().actualizar(
				"frmActividades_lista:dtActividades");
		return null;
	}

	private void enviarCorreos() throws Exception {

		net.royal.seguridad.dominio.Empleadomast emp = this.getFacSeguridad()
				.getEmpleadomastServicio()
				.obtenerPorPersona(this.getUsuarioActual().getIdPersona());
		String correoPersona = "";
		if (!UValidador.esNulo(emp)) {
			correoPersona = UValidador.esNulo(emp.getCorreointerno()) ? ""
					: emp.getCorreointerno();
		}

		boolean flgConfigurado = this.getFacSeguridad().getCorreoServicio()
				.configurarCorreo();
		if (!flgConfigurado) {
			this.setMessageError("Error interno del envio de correos");
			return;
		}

		String correoCuerpo;
		String rutaCompleta = UAplicacion.getRealPath() + File.separator
				+ "comun" + File.separator + "plantillas" + File.separator
				+ "oefa" + File.separator + "correos" + File.separator
				+ "confirmar_donacion.html";
		LOGGER.debug(rutaCompleta);
		correoCuerpo = UFile.obtenerContenidoFile(rutaCompleta);
		LOGGER.debug(correoCuerpo);
		correoCuerpo = correoCuerpo.replace("[NOMBRES]", this
				.getUsuarioActual().getNombreCompleto());
		correoCuerpo = correoCuerpo.replace("[TEXTO]", "[TEXTO]");

		CorreoCore mail = new CorreoCore();
		mail.setAsunto("OEFA | Confirmación de donativo");
		mail.setCuerpoCorreo(correoCuerpo.getBytes());
		mail.setListaCorreoDestino(Arrays.asList(new CorreoDestinoCore(
				correoPersona), new CorreoDestinoCore(
				"valenzuelad@royalsystems.net")));

		this.getFacSeguridad().getCorreoServicio().enviarCorreo(mail);
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		Date fechaActual = new Date();
		if (registroSeleccionado.getFechadesdepublicacion() == null) {
			return false;
		}
		if (registroSeleccionado.getFechahastapublicacion() == null) {
			return false;
		}
		if (fechaActual.before(registroSeleccionado.getFechadesdepublicacion())) {
			setMessageError("Estas fuera del rango de fechas indicadas");
			return false;
		}

		if (fechaActual.after(registroSeleccionado.getFechahastapublicacion())) {
			setMessageError("Estas fuera del rango de fechas indicadas");
			return false;
		}
		return true;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		filtro = new DtoHrActividad();
		return null;
	}

	public String cargarNotificaciones() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		listaNotificacionDP1 = CHrCapacitacionDocumentoPendiente.getInstance()
				.retornaNotificaciones1();
		listaNotificacionDP2 = CHrCapacitacionDocumentoPendiente.getInstance()
				.retornaNotificaciones2();
		listaNotificacionE = CHrEncuesta.getInstance().retornaNotificaciones();
		listaNotificacion = lstDatos.size();

		if (listaNotificacionE > 0 || listaNotificacion > 0
				|| listaNotificacionDP1 > 0 || listaNotificacionDP2 > 0) {
			this.getWebControlContext().ejecutar("PF('notiBar').show()");
		}

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DtoHrActividad> getLstDatos() {
		return lstDatos;
	}

	public void setLstDatos(List<DtoHrActividad> lstDatos) {
		this.lstDatos = lstDatos;
	}

	public DtoHrActividad getFiltro() {
		return filtro;
	}

	public void setFiltro(DtoHrActividad filtro) {
		this.filtro = filtro;
	}

	public HrActividad getBean() {
		return bean;
	}

	public void setBean(HrActividad bean) {
		this.bean = bean;
	}

	public DtoHrActividad getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoHrActividad registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public HrActividadparticipante getBeanParticipante() {
		return beanParticipante;
	}

	public void setBeanParticipante(HrActividadparticipante beanParticipante) {
		this.beanParticipante = beanParticipante;
	}

	public BigDecimal getMontoDonativo() {
		return montoDonativo;
	}

	public void setMontoDonativo(BigDecimal montoDonativo) {
		this.montoDonativo = montoDonativo;
	}

	public Integer getListaNotificacion() {
		return listaNotificacion;
	}

	public void setListaNotificacion(Integer listaNotificacion) {
		this.listaNotificacion = listaNotificacion;
	}

	public Integer getListaNotificacionE() {
		return listaNotificacionE;
	}

	public void setListaNotificacionE(Integer listaNotificacionE) {
		this.listaNotificacionE = listaNotificacionE;
	}

	public Integer getSegundosPrimeraActividad() {
		return segundosPrimeraActividad;
	}

	public void setSegundosPrimeraActividad(Integer segundosPrimeraActividad) {
		this.segundosPrimeraActividad = segundosPrimeraActividad;
	}

	public Integer getListaNotificacionDP1() {
		return listaNotificacionDP1;
	}

	public void setListaNotificacionDP1(Integer listaNotificacionDP1) {
		this.listaNotificacionDP1 = listaNotificacionDP1;
	}

	public Integer getListaNotificacionDP2() {
		return listaNotificacionDP2;
	}

	public void setListaNotificacionDP2(Integer listaNotificacionDP2) {
		this.listaNotificacionDP2 = listaNotificacionDP2;
	}

}
