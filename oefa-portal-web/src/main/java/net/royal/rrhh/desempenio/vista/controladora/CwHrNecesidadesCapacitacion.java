package net.royal.rrhh.desempenio.vista.controladora;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrCursodescripcion;
import net.royal.erp.rrhh.dominio.HrCursodescripcionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrCursoSelector;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDwHrEvaluacionCapacitacionDetail;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.CwHrCursoSelector;

/**
 * The Class CwHrNecesidadesCapacitacion.
 * 
 * @author nunezh
 * @powerbuilder p7 (dw7)
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrNecesidadesCapacitacion extends CwHrEvaluacionempleadoEditMaestra
		implements UIMantenimientoController {

	private DtoDwHrEmpleadonecesidadcapacitaEdit registroSeleccionado;
	private Integer empleado, empleadoevaluador, secuenciaeval;
	private String compania;
	private List<String> tipo;

	public static CwHrNecesidadesCapacitacion getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrNecesidadesCapacitacion}", CwHrNecesidadesCapacitacion.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return null;
	}

	@Override
	public String buscar() throws Exception {
		this.setDw7(new ArrayList<DtoDwHrEmpleadonecesidadcapacitaEdit>());
		List<HrEmpleadonecesidadcapacita> lista = this.getFacRrhh().getHrEmpleadonecesidadcapacitaServicio()
				.ListarEmpleadoNecesidadCapacitaxParam(compania, empleado, secuenciaeval);

		for (HrEmpleadonecesidadcapacita en : lista) {
			DtoDwHrEmpleadonecesidadcapacitaEdit dto = new DtoDwHrEmpleadonecesidadcapacitaEdit();
			dto.setBean(en);
			dto.setCursonombre(obtenernombreCurso(en.getCurso()));
			dto.setEliminado(ConstanteRrhh.TIPO_NO);

			this.getDw7().add(dto);
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
	public String nuevo() throws Exception {
		this.setAccionPantalla(accion_solicitada.NUEVO);
		Integer llSecuencia;
		llSecuencia = this.getFacRrhh().getHrEmpleadonecesidadcapacitaServicio().ObtenerMaximaSecuencia(empleado,
				secuenciaeval);

		if (!UValidador.esListaVacia(this.getDw7())) {
			Integer secuencia = obtenerSecuenciaActual(this.getDw7());
			if (secuencia >= llSecuencia) {
				llSecuencia = secuencia + 1;
			}
		}

		// obtener la secuencia
		llSecuencia = obtenerUltimoSecuencia(this.getDw7(), llSecuencia);

		registroSeleccionado = new DtoDwHrEmpleadonecesidadcapacitaEdit();

		DtoDwHrEmpleadonecesidadcapacitaEdit nuevaFila = new DtoDwHrEmpleadonecesidadcapacitaEdit();
		HrEmpleadonecesidadcapacita bean = new HrEmpleadonecesidadcapacita();
		bean.getPk().setCompanyowner(compania);
		bean.getPk().setEmpleado(empleado);
		bean.getPk().setSecuenciaeval(secuenciaeval);
		bean.getPk().setSecuencia(llSecuencia);
		bean.getPk().setEmpleadoevaluador(empleadoevaluador);
		nuevaFila.setBean(bean);
		nuevaFila.setEliminado(ConstanteRrhh.TIPO_NO);
		nuevaFila.setCursonombre("");

		registroSeleccionado = nuevaFila;

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "agregarCapacitacion");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrCapacitacionSelector.getInstance().mensaje(mensajeGenerico);
		return null;
	}

	private Integer obtenerUltimoSecuencia(List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7, Integer secuencia) {
		int num, max = 0, min = 0;
		Integer llSecuencia = secuencia;

		List<DtoDwHrEmpleadonecesidadcapacitaEdit> lstdw7 = new ArrayList<DtoDwHrEmpleadonecesidadcapacitaEdit>();
		for (DtoDwHrEmpleadonecesidadcapacitaEdit objt : dw7) {
			if (objt.getEliminado().equals(ConstanteRrhh.TIPO_NO)) {
				lstdw7.add(objt);
			}
		}

		for (int i = 0; i < lstdw7.size(); i++) {
			num = lstdw7.get(i).getBean().getPk().getSecuencia().intValue();
			if (min != 0 && max != 0) {
				if (num > max) {
					max = num;
				}
				if (num < min) {
					min = num;
				}
			} else {
				min = num;
				max = num;
			}
		}

		if (max >= llSecuencia) {
			llSecuencia = max + 1;
		}
		return llSecuencia;
	}

	@Override
	public String editar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "editarCapacitacion");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrCapacitacionSelector.getInstance().mensaje(mensajeGenerico);

		return null;
	}

	@Override
	public String ver() throws Exception {
		return null;
	}

	@Override
	public String eliminar() throws Exception {

		if (UValidador.esNulo(registroSeleccionado)) {
			this.setMessageError("Seleccione una fila");
			return null;
		}

		this.setDw7(this.getFacRrhh().getHrEmpleadonecesidadcapacitaServicio().eliminarNecesidad(this.getDw7(),
				registroSeleccionado, empleado));

		for (int i = 0; i < this.getDw7().size(); i++) {
			if (this.getDw7().get(i).getEliminado().equals(ConstanteRrhh.TIPO_NO))
				registroSeleccionado = this.getDw7().get(i);
		}
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
		for (int i = 0; i < this.getDw7().size(); i++) {
			if (this.getDw7().get(i).getBean().getPk().getSecuencia() == registroSeleccionado.getBean().getPk()
					.getSecuencia()) {
				this.getDw7().get(i).getBean().setNecesidad(registroSeleccionado.getBean().getNecesidad());
				this.getDw7().get(i).getBean().setObjetivo(registroSeleccionado.getBean().getObjetivo());

				this.getDw7().get(i).getBean().setCurso(registroSeleccionado.getBean().getCurso().intValue());
				this.getDw7().get(i).getBean().setCapacitacion(registroSeleccionado.getBean().getCapacitacion());
				this.getDw7().get(i).setCursonombre(registroSeleccionado.getCursonombre());

				this.getWebControlContext().actualizar("frmEvaluacionEmpleado:tvDatos:dtNecesidades");
				break;
			}
		}
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
		String lsCapacitacion = null;

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("insertCapacitacion")) {

			registroSeleccionado = (DtoDwHrEmpleadonecesidadcapacitaEdit) (mensajeControllerGenerico.getParametros()
					.get("registroSeleccionado"));

			this.getWebControlContext().actualizar("frmEvaluacionEmpleado:tvDatos:dtNecesidades");
		}

		return null;
	}

	public Boolean validarIngreso() {
		List<String> codigoCurso = new ArrayList<String>();

		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			codigoCurso.add(CwHrCapacitacionSelector.getInstance().getRegistroSeleccionadoExterno().getCursonombre());
		}

		// VALIDA QUE NO SE ENCUENTREN CURSOS REPETIDOS
		if (this.getDw7().size() > 0) {
			for (int i = 0; i < this.getDw7().size(); i++) {
				String codigoCursoNombre = this.getDw7().get(i).getCursonombre();
				if (codigoCursoNombre
						.equals(CwHrCapacitacionSelector.getInstance().getRegistroSeleccionadoExterno()
								.getCursonombre())
						&& this.getDw7().get(i).getEliminado().equals("N")
						&& getAccionPantalla().equals(accion_solicitada.EDITAR)) {
					codigoCurso.add(codigoCursoNombre);
				}
				if (!codigoCurso.contains(codigoCursoNombre)) {
					codigoCurso.add(codigoCursoNombre);
				} else {
					setMessageError("Este Curso se encuentra repetido.");
					return false;
				}
			}
		}

		this.getDw7().add(CwHrCapacitacionSelector.getInstance().getRegistroSeleccionadoExterno());
		return true;

	}

	@Override
	public String inicializarFiltrosListado() throws Exception {

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public DtoDwHrEmpleadonecesidadcapacitaEdit getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoDwHrEmpleadonecesidadcapacitaEdit registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

}
