package net.royal.rrhh.vista.controladora;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.HrRequerimientoPk;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrRequerimientoMotivoSuspension extends CBaseBean implements
		UIMantenimientoController {

	private String st_pregunta;
	private StrPass str_pass = new StrPass();
	private String mle_motivo;
	private HrRequerimiento x = new HrRequerimiento();
	private HrRequerimientoPk hrRequerimientopk = new HrRequerimientoPk();

	public static CwHrRequerimientoMotivoSuspension getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrRequerimientoMotivoSuspension}",
				CwHrRequerimientoMotivoSuspension.class);
	}

	public String aceptar() {
		String w_motivo, w_estado;
		Integer w_empleado, w_numeroproceso;
		Date fecha = new Date();
		w_empleado = this
				.getFacCore()
				.getEmpleadomastServicio()
				.obtenerPorCodigoUsuario(
						getUsuarioActual().getLoginUsuario().toUpperCase())
				.getPk().getEmpleado();
		LOGGER.debug("w_empleado == " + w_empleado);
		w_motivo = mle_motivo;
		LOGGER.debug("w_motivo == " + w_motivo);
		if (UValidador.estaVacio(w_motivo)) {
			setMessageError("Por favor, ingrese un Motivo. ");
			return null;
		}

		Integer w_numeroacta, w_anoactual;

		String fecha1 = new SimpleDateFormat("YYYY").format(fecha);
		w_anoactual = Integer.parseInt(fecha1);
		if ("S".equals(str_pass.getS()[1])) {

		} else {
			hrRequerimientopk.setCompanyowner(str_pass.getS()[3]);
			hrRequerimientopk.setRequerimiento(str_pass.getS()[2]);

			x = (HrRequerimiento) this.getFacRrhh()
					.getHrRequerimientoServicio()
					.obtenerPorId(hrRequerimientopk);
			x.setFlagdesierto(ConstanteRrhh.TIPO_SI);
			x.setMotivodesierto(w_motivo);
			this.getFacRrhh().getHrRequerimientoServicio().actualizar(x);
		}

		return null;
	}

	public String open() {

		if ("S".equals(str_pass.getS()[1])) {

		} else {
			st_pregunta = "El Requerimiento será declarado como Desierto. Por favor, ingrese el Motivo: ";
			LOGGER.debug("st_pregunta = " + st_pregunta);
		}
		return null;
	}

	public String getSt_pregunta() {
		return st_pregunta;
	}

	public void setSt_pregunta(String st_pregunta) {
		this.st_pregunta = st_pregunta;
	}

	public StrPass getStr_pass() {
		return str_pass;
	}

	public void setStr_pass(StrPass str_pass) {
		this.str_pass = str_pass;
	}

	public String getMle_motivo() {
		return mle_motivo;
	}

	public void setMle_motivo(String mle_motivo) {
		this.mle_motivo = mle_motivo;
	}

	@Override
	public String iniciarControladora() throws Exception {
		open();
		LOGGER.debug("despues de open");
		return null;
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {

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

}
