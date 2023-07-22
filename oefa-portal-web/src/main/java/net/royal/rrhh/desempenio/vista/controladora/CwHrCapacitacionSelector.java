package net.royal.rrhh.desempenio.vista.controladora;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrCursodescripcion;
import net.royal.erp.rrhh.dominio.HrCursodescripcionPk;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.CwHrCursoSelector;

@SessionScoped
@ManagedBean
public class CwHrCapacitacionSelector extends CBaseBean implements UIMantenimientoController {

	private DtoDwHrEmpleadonecesidadcapacitaEdit registroSeleccionadoExterno;
	private Integer secuenciaeval;
	private Boolean editar;

	public static CwHrCapacitacionSelector getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrCapacitacionSelector}", CwHrCapacitacionSelector.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		editar = false;
		getWebControlContext().ejecutar("PF('popNecesidadEdicion').show()");
		getWebControlContext().actualizar("dgNecesidadEdicion");
		return null;
	}

	public String seleccionarCurso() throws Exception {
		return CwHrCursoSelector.getInstance().iniciarControladora();
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

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCursoSelector")) {
			DtoDwHrCursoSelector obj = (DtoDwHrCursoSelector) (mensajeControllerGenerico.getParametros().get("curso"));

			HrEvaluacionperiodo evaper = this.getFacRrhh().getHrEvaluacionperiodoServicio()
					.ObtenerxSecuenciaeval(registroSeleccionadoExterno.getBean().getPk().getSecuenciaeval());

			HrCapacitacion capa = this.getFacRrhh().getHrCapacitacionServicio().obtenerCapacitacionxparam(
					obj.getCurso().intValue(),
					Integer.parseInt(new SimpleDateFormat("yyyy").format(evaper.getFechaevalinicio())));

			LOGGER.debug(obj.getCurso().intValue());
			LOGGER.debug(new SimpleDateFormat("yyyy").format(evaper.getFechaevalinicio()));

			String lsCapacitacion = UValidador.esNulo(capa) ? null : capa.getPk().getCapacitacion();

			registroSeleccionadoExterno.setCursonombre(obtenernombreCurso(obj.getCurso().intValue()));
			registroSeleccionadoExterno.getBean().setCurso(obj.getCurso().intValue());
			registroSeleccionadoExterno.getBean().setCapacitacion(lsCapacitacion);

		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarCapacitacion")) {

			registroSeleccionadoExterno = (DtoDwHrEmpleadonecesidadcapacitaEdit) (mensajeControllerGenerico
					.getParametros().get("registroSeleccionado"));
			iniciarControladora();
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("editarCapacitacion")) {
			
			registroSeleccionadoExterno = (DtoDwHrEmpleadonecesidadcapacitaEdit) (mensajeControllerGenerico
					.getParametros().get("registroSeleccionado"));
			iniciarControladora();
			editar = true;
		}

		return null;
	}

	private String obtenernombreCurso(Integer curso) {
		HrCursodescripcionPk pk = new HrCursodescripcionPk();
		pk.setCurso(curso);
		HrCursodescripcion cd = (HrCursodescripcion) this.getFacRrhh().getHrCursodescripcionServicio().obtenerPorId(pk);
		return cd.getDescripcion();
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		return null;
	}

	public String grabarNecesidad() throws Exception {

		if (!editar) {
			Boolean valor = CwHrNecesidadesCapacitacion.getInstance().validarIngreso();
			if (!valor) {
				LOGGER.debug("esta repetido");
				return null;
			}

		}
		getWebControlContext().ejecutar("PF('popNecesidadEdicion').hide();");
		getWebControlContext().ejecutar("filtrarTable();");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "insertCapacitacion");
		param.put("registroSeleccionado", registroSeleccionadoExterno);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);
		CwHrNecesidadesCapacitacion.getInstance().mensaje(mensajeGenerico);

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public void validatorPrioridad(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		Integer proveedor = (Integer) value;

		if (!UValidador.esNulo(proveedor)) {
			if (proveedor > ConstanteRrhh.TAMANO_PRIORIDAD) {
				FacesMessage message = new FacesMessage(
						"La Prioridad no debe ser mayor a " + ConstanteRrhh.TAMANO_PRIORIDAD);
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		} else {
			FacesMessage message = new FacesMessage("El campo Prioridad es Obligatorio");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

	public DtoDwHrEmpleadonecesidadcapacitaEdit getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(DtoDwHrEmpleadonecesidadcapacitaEdit registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

}
