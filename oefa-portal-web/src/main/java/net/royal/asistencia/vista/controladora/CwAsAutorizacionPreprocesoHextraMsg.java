package net.royal.asistencia.vista.controladora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextraDet;
import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwCambioHorarioExcepcion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.ParametroPersistenciaLista;

@ManagedBean
@SessionScoped
public class CwAsAutorizacionPreprocesoHextraMsg extends CBaseBean implements
		UIMantenimientoController {

	private List<DtoDwAsAutorizacionPreprocesoHextraDet> dw_detalle;
	private ParametroPersistenciaLista parametros;

	/*
	 * wf_Inicializar()
	 */
	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		// Detalle de ocurrencias

		Date par_FechaDesde;
		Date par_FechaHasta;
		Date par_HoraDesde;
		Date par_HoraHasta;

		Date FechaDesde;
		Date FechaHasta;

		par_FechaDesde = (Date) parametros.get("str_parametros1");
		par_FechaHasta = (Date) parametros.get("str_parametros2");
		par_HoraDesde = (Date) parametros.get("str_parametros3");
		par_HoraHasta = (Date) parametros.get("str_parametros4");

		dw_detalle = new ArrayList<DtoDwAsAutorizacionPreprocesoHextraDet>();

		Date Fecha;
		Fecha = par_FechaDesde;

		if (!UValidador.esNulo(parametros.get("str_parametros5"))) {
			@SuppressWarnings("unchecked")
			List<DtoDwCambioHorarioExcepcion> horarios = (List<DtoDwCambioHorarioExcepcion>) parametros
					.get("str_parametros5");

			if (!UValidador.esListaVacia(horarios)) {
				for (DtoDwCambioHorarioExcepcion objhor : horarios) {
					FechaDesde = UFechaHora.obtenerFechaCompuesta(
							objhor.getFecha(), objhor.getHorainicio());
					FechaHasta = UFechaHora.obtenerFechaCompuesta(
							objhor.getFechahasta(), objhor.getHorafin());
					dw_detalle.add(new DtoDwAsAutorizacionPreprocesoHextraDet(
							FechaDesde, FechaHasta, null));

					if (dw_detalle.size() > 100) {
						dw_detalle
								.add(new DtoDwAsAutorizacionPreprocesoHextraDet(
										null, null, "continua..."));
						break;
					}
				}
			}

		} else {

			while (!Fecha.after(par_FechaHasta)) {
				FechaDesde = UFechaHora.obtenerFechaCompuesta(Fecha,
						par_HoraDesde);
				if (par_HoraHasta.before(par_HoraDesde)) {
					FechaHasta = UFechaHora.obtenerFechaCompuesta(
							UFechaHora.obtenerFechaMasdias(Fecha, 1),
							par_HoraHasta);
				} else {
					FechaHasta = UFechaHora.obtenerFechaCompuesta(Fecha,
							par_HoraHasta);
				}

				Fecha = UFechaHora.obtenerFechaMasdias(Fecha, 1);
				dw_detalle.add(new DtoDwAsAutorizacionPreprocesoHextraDet(
						FechaDesde, FechaHasta, null));

				if (dw_detalle.size() > 100) {
					dw_detalle.add(new DtoDwAsAutorizacionPreprocesoHextraDet(
							null, null, "continua..."));
					break;
				}

			}
		}

		getWebControlContext().actualizar("dgIntervalosAutorizacion");
		getWebControlContext().ejecutar(
				"PF('popIntervalosAutorizacion').show()");

		return null;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		// TODO Auto-generated method stub
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("listarOcurrencias")) {
			parametros = mensajeControllerGenerico.getParametros();

			iniciarControladora();
		}
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

	public static CwAsAutorizacionPreprocesoHextraMsg getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwAsAutorizacionPreprocesoHextraMsg}",
				CwAsAutorizacionPreprocesoHextraMsg.class);
	}

	/**
	 * @return the dw_detalle
	 */
	public List<DtoDwAsAutorizacionPreprocesoHextraDet> getDw_detalle() {
		return dw_detalle;
	}

	/**
	 * @param dw_detalle
	 *            the dw_detalle to set
	 */
	public void setDw_detalle(
			List<DtoDwAsAutorizacionPreprocesoHextraDet> dw_detalle) {
		this.dw_detalle = dw_detalle;
	}

}
