package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacion;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionPk;
import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.dominio.dto.OwHrEvaluacionempleadoEdit;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.controladora.CwFactoresCompetenciaHistorial;

import org.primefaces.event.SelectEvent;

/**
 * 
 * @author Jose Torres
 * @codigoapliacion HR
 * @libreria hrproc.pbl
 * @windows w_factores_competencia_calificar
 */
@ManagedBean
@SessionScoped
public class CwFactoresCompetenciaCalificar extends CBaseBean implements UIMantenimientoController {

	private String eventname, is_flagcalificacion, is_columna, ivCompania, mle_comentario, comentarioRetorno;
	private HrFactoresevaluacion dw_factores;
	private List<HrFactorvalor> dw_1;
	private HrFactorvalor registroSeleccionado;
	private DtoHrDetalleEvaluacion registroSeleccionadoExterno;
	private StrPass ls_str_pass;
	private Integer il_factor, ivEmpleado, ivSecuencia, altura, comentariorows;
	private BigDecimal em_calificacion, valorRetorno, factorCompetenciaRetorno, secuenciacompetenciaRetorno;
	private OwHrEvaluacionempleadoEdit opciones;
	private String descripcionRetorno, is_columna_5;

	@Override
	public String iniciarControladora() throws Exception {
		opciones = new OwHrEvaluacionempleadoEdit();
		registroSeleccionado = null;
		inicializarAcciones();
		getWebControlContext().ejecutar("PF('popComptencias').show();");
		getWebControlContext().actualizar("gdComptencias");
		return null;
	}

	/**
	 * @powerbuilder ObjectStartEvent.
	 *
	 * @return navigation case
	 * @throws Exception
	 */
	public String inicializarAcciones() throws Exception {
		LOGGER.debug("INICIAR EVENTO " + eventname);
		String msj;
		switch (eventname) {
		case "opened":

			if (!UValidador.esNulo(registroSeleccionadoExterno.getFactor())) {
				il_factor = registroSeleccionadoExterno.getFactor().intValue();
			}

			is_flagcalificacion = ls_str_pass.getS()[1];
			is_columna = ls_str_pass.getS()[2];
			ivCompania = ls_str_pass.getS()[3];
			ivEmpleado = ls_str_pass.getLo()[3];
			ivSecuencia = ls_str_pass.getLo()[4];
			is_columna_5 = ls_str_pass.getS()[9];

			mle_comentario = "";// esto viene como parametro vacio validar como
								// lo envian desde otra controladora

			em_calificacion = registroSeleccionadoExterno.getCalificacion();
			dw_1 = this.getFacRrhh().getHrFactorvalorServicio().obtenerLista(il_factor);
			dw_factores = (HrFactoresevaluacion) this.getFacRrhh().getHrFactoresevaluacionServicio()
					.obtenerPorId(new HrFactoresevaluacionPk(il_factor));

			if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_UNO)) {
				opciones.setMle_comentario(false);
				opciones.setSt_comentario(false);
				opciones.setSt_calificacion(true);
				opciones.setEm_calificacion(true);
				opciones.setVerValor(true);
				opciones.setVerValorhasta(true);
				opciones.setDw_1visible(true);
				comentariorows = 4;

				altura = 430;

			} else if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_TRES)) {
				opciones.setMle_comentario(false);
				opciones.setSt_comentario(false);
				opciones.setSt_calificacion(false);
				opciones.setEm_calificacion(false);
				opciones.setVerValor(false);
				opciones.setVerValorhasta(false);
				opciones.setDw_1visible(true);
				comentariorows = 4;

				altura = 430;
			} else if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)) {

				opciones.setSt_calificacion(false);
				opciones.setEm_calificacion(false);
				opciones.setMle_comentario(true);
				opciones.setSt_comentario(true);
				opciones.setVerValor(false);
				opciones.setVerValorhasta(false);
				opciones.setDw_1visible(true);
				comentariorows = 4;
				altura = 520;

			} else if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CINCO)) {

				opciones.setSt_calificacion(false);
				opciones.setEm_calificacion(false);
				opciones.setDw_1visible(false);
				opciones.setMle_comentario(true);
				opciones.setSt_comentario(true);
				comentariorows = 20;
				altura = 420;
			}

			if (is_columna.equals("calificacion")) {
				opciones.setCb_compromiso(true);
			} else {
				opciones.setCb_compromiso(false);
			}

			break;

		case "cb_aceptar_clicked":
			msj = wfProcess();
			if (UValidador.estaVacio(msj)) {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "insertarCalificacion");

				param.put("valor", valorRetorno);
				param.put("descripcion", descripcionRetorno);
				param.put("comentario", comentarioRetorno);
				param.put("factorCompetencia", factorCompetenciaRetorno);
				param.put("secuenciacompetencia", secuenciacompetenciaRetorno);
				param.put("registroSeleccionado", registroSeleccionado);

				if (!UValidador.esNulo(nombreContenedorRefrescar))
					this.getWebControlContext().actualizar(nombreContenedorRefrescar);

				if (!UValidador.esNulo(getNombreVentanaEmergente())) {
					String accionEmergente;
					accionEmergente = "PF('" + getNombreVentanaEmergente() + "').hide()";
					getWebControlContext().ejecutar(accionEmergente);
				}

				MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
				mensajeGenerico.setParametros(param);

				this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

				return null;
			} else {
				setMessageError(msj);
				return null;
			}

		case "dw_1_doubleclicked":
			if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_UNO)
					|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_TRES)
					|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)) {
				msj = wfProcess();
				if (UValidador.estaVacio(msj)) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "insertarCalificacion");

					param.put("valor", valorRetorno);
					param.put("descripcion", descripcionRetorno);
					param.put("comentario", comentarioRetorno);
					param.put("factorCompetencia", factorCompetenciaRetorno);
					param.put("secuenciacompetencia", secuenciacompetenciaRetorno);
					param.put("registroSeleccionado", registroSeleccionado);

					if (!UValidador.esNulo(nombreContenedorRefrescar))
						this.getWebControlContext().actualizar(nombreContenedorRefrescar);

					if (!UValidador.esNulo(getNombreVentanaEmergente())) {
						String accionEmergente;
						accionEmergente = "PF('" + getNombreVentanaEmergente() + "').hide()";
						getWebControlContext().ejecutar(accionEmergente);
					}

					MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
					mensajeGenerico.setParametros(param);

					this.getiMantenimientoReferencia().mensaje(mensajeGenerico);

					return null;
				} else {
					setMessageError(msj);
					return null;
				}
			}

		case "cb_compromiso_clicked":

			Integer li_existe = 0;
			Integer il_factorant = null;
			HrFactoresevaluacion factorant = (HrFactoresevaluacion) getFacRrhh().getHrFactoresevaluacionServicio()
					.obtenerPorId(new HrFactoresevaluacionPk(il_factor));
			if (!UValidador.esNulo(factorant)) {
				il_factorant = factorant.getFactorant();

				li_existe = getFacRrhh().getHrEvaluacionperiodoServicio().obtenerCantHistorial(ivCompania, ivEmpleado,
						il_factorant, ivSecuencia);
			}

			if (UValidador.esNulo(li_existe))
				li_existe = 0;
			if (li_existe > 0) {
				StrPass ls_str_pass1;
				ls_str_pass1 = new StrPass();
				ls_str_pass1.getS()[1] = ivCompania;
				ls_str_pass1.getLo()[1] = ivEmpleado;
				ls_str_pass1.getLo()[2] = il_factorant;
				ls_str_pass1.getLo()[3] = ivSecuencia;

				CwFactoresCompetenciaHistorial.getInstance().setLs_str_pass(ls_str_pass1);
				CwFactoresCompetenciaHistorial.getInstance().iniciarControladora();

			} else {
				setMessageSuccess("Aviso, El empleado no cuenta con historial de compromisos de mejora.");
				return null;
			}
			break;
		}
		return null;
	}

	public void selectRow(SelectEvent e) {
		registroSeleccionado = (HrFactorvalor) e.getObject();

		em_calificacion = registroSeleccionado.getValor();

		if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_TRES)
				|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)) {

		}

	}

	private String wfProcess() {
		String msj = "";

		if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_UNO)
				|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_DOS)) {
			msj = wfValidarNumerico();

			if (!UValidador.estaVacio(msj)) {
				return msj;
			}
			valorRetorno = em_calificacion;
		}

		if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_DOS)
				|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)
				|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CINCO)) {
			comentarioRetorno = mle_comentario;
		}

		if (is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_TRES)
				|| is_flagcalificacion.equals(ConstanteRrhh.TIPO_CALIFICACION_CUATRO)) {
			if (!UValidador.esNulo(registroSeleccionadoExterno)) {
				valorRetorno = new BigDecimal(registroSeleccionado.getPk().getSecuencia());
				descripcionRetorno = registroSeleccionado.getDescripcion();
			}
		}

		if (!UValidador.estaVacio(is_columna_5)) {
			factorCompetenciaRetorno = new BigDecimal(il_factor);
		}

		if (UValidador.esNulo(registroSeleccionado)) {
			secuenciacompetenciaRetorno = new BigDecimal(registroSeleccionado.getPk().getSecuencia());
		}

		return msj;
	}

	private String wfValidarNumerico() {
		Integer ld_calificacion, ld_cf_minimo = 0, ld_cf_maximo = 0;
		String msj = "";
		if (UValidador.esNulo(em_calificacion)) {
			ld_calificacion = null;
		} else {
			ld_calificacion = em_calificacion.intValue();
		}

		if (UValidador.esNulo(ld_calificacion))
			ld_calificacion = 0;

		if (dw_1.size() > 0) {
			ld_cf_minimo = getFacRrhh().getHrFactorvalorServicio().obtenerMim(il_factor);
			ld_cf_maximo = getFacRrhh().getHrFactorvalorServicio().obtenerMax(il_factor);
		}

		if (ld_calificacion < ld_cf_minimo || ld_calificacion > ld_cf_maximo) {
			msj = "El valor elegido está fuera del rango";
			return msj;
		}

		return msj;
	}

	public static CwFactoresCompetenciaCalificar getInstance() {
		return UFaces.evaluateExpressionGet("#{cwFactoresCompetenciaCalificar}", CwFactoresCompetenciaCalificar.class);
	}

	public void doubleclicked(SelectEvent e) throws Exception {
		registroSeleccionado = (HrFactorvalor) e.getObject();
		eventname = "dw_1_doubleclicked";
		inicializarAcciones();
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

	public StrPass getLs_str_pass() {
		return ls_str_pass;
	}

	public void setLs_str_pass(StrPass ls_str_pass) {
		this.ls_str_pass = ls_str_pass;
	}

	public HrFactoresevaluacion getDw_factores() {
		return dw_factores;
	}

	public void setDw_factores(HrFactoresevaluacion dw_factores) {
		this.dw_factores = dw_factores;
	}

	public List<HrFactorvalor> getDw_1() {
		return dw_1;
	}

	public void setDw_1(List<HrFactorvalor> dw_1) {
		this.dw_1 = dw_1;
	}

	public Integer getIl_factor() {
		return il_factor;
	}

	public void setIl_factor(Integer il_factor) {
		this.il_factor = il_factor;
	}

	public BigDecimal getEm_calificacion() {
		return em_calificacion;
	}

	public void setEm_calificacion(BigDecimal em_calificacion) {
		this.em_calificacion = em_calificacion;
	}

	public HrFactorvalor getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrFactorvalor registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public DtoHrDetalleEvaluacion getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(DtoHrDetalleEvaluacion registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

	public OwHrEvaluacionempleadoEdit getOpciones() {
		return opciones;
	}

	public void setOpciones(OwHrEvaluacionempleadoEdit opciones) {
		this.opciones = opciones;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public String getMle_comentario() {
		return mle_comentario;
	}

	public void setMle_comentario(String mle_comentario) {
		this.mle_comentario = mle_comentario;
	}

	public Integer getComentariorows() {
		return comentariorows;
	}

	public void setComentariorows(Integer comentariorows) {
		this.comentariorows = comentariorows;
	}

}
