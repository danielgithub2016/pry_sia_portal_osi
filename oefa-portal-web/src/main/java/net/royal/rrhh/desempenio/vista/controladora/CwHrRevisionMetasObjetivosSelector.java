package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SessionScoped
@ManagedBean
public class CwHrRevisionMetasObjetivosSelector extends CBaseBean implements
		UIMantenimientoController {

	public String calificar() throws Exception {
		StrPass lvPass;

		lvPass = new StrPass();
		lvPass.getD()[1] = registroSeleccionadoExterno.getPk()
				.getSecuenciaeval();
		lvPass.getD()[2] = 1;

		CwHrFactoresvalorListXperiodo.getInstance().setStr_pass(lvPass);
		CwHrFactoresvalorListXperiodo.getInstance().iniciarControladora();
		this.getWebControlContext().ejecutar("PF('popCalificativos').show();");

		return null;
	}

	private HrEmpleadometas registroSeleccionadoExterno;

	@Override
	public String iniciarControladora() throws Exception {
		getWebControlContext().ejecutar("PF('popRevisionMetasObj').show()");
		getWebControlContext().actualizar("dgRevisionMetasObj");

		return null;
	}

	public static CwHrRevisionMetasObjetivosSelector getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrRevisionMetasObjetivosSelector}",
				CwHrRevisionMetasObjetivosSelector.class);
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

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"insertObjetivosMetas");
		param.put("registroSeleccionado", registroSeleccionadoExterno);


		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);
		CwHrRevisionMetasObjetivos.getInstance().mensaje(mensajeGenerico);
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {

		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarObjetivos")) {

			registroSeleccionadoExterno = (HrEmpleadometas) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			
			registroSeleccionadoExterno
			.setCalificacionAnt(registroSeleccionadoExterno
					.getCalificacion());
			
			iniciarControladora();
		}

		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("editarObjetivos")) {

			registroSeleccionadoExterno = (HrEmpleadometas) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			
			registroSeleccionadoExterno
					.setCalificacionAnt(registroSeleccionadoExterno
							.getCalificacion());
			iniciarControladora();
		}

		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("popFactorValorListXperiodo")) {
			StrPass lvPass;
			lvPass = (StrPass) mensajeControllerGenerico.getParametros().get(
					"lv_pass");

			if (lvPass.getD().length > 0) {

				registroSeleccionadoExterno.setCalificacion(UValidador
						.esNulo(lvPass.getD()[1]) ? BigDecimal.ZERO
						: new BigDecimal(lvPass.getD()[1]));
				registroSeleccionadoExterno
						.setFactorsecuencia(lvPass.getD()[2]);

			}

		}

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

	public HrEmpleadometas getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(
			HrEmpleadometas registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

}
