package net.royal.rrhh.desempenio.vista.controladora;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * 
 * @author Jose Torres
 * @codigoapliacion HR
 * @libreria hroracle.pbl
 * @windows w_hr_evaluacionempleado_edit
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CwHrFortalezasDebilidades extends
		CwHrEvaluacionempleadoEditMaestra implements UIMantenimientoController {

	private List<DtoDwMaMiscelaneosdetalleSelect> lstTipo = new ArrayList<DtoDwMaMiscelaneosdetalleSelect>();
	private DtoDwMaMiscelaneosdetalleSelect dtoMiscelaneos = new DtoDwMaMiscelaneosdetalleSelect();

	private HrEmpleadodesempeno registroSeleccionado;
	private Integer empleado, empleadoevaluador, secuenciaeval;
	private String compania;

	@Override
	public String iniciarControladora() throws Exception {
		buscar();
		return null;
	}

	public static CwHrFortalezasDebilidades getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrFortalezasDebilidades}",
				CwHrFortalezasDebilidades.class);
	}

	@Override
	public String buscar() throws Exception {
		this.setDw5(new ArrayList<HrEmpleadodesempeno>());

		List<HrEmpleadodesempeno> lista = getFacRrhh()
				.getHrEmpleadodesempenoServicio()
				.ListarEmpleadoDesempenoporParametros(compania, empleado,
						secuenciaeval, empleadoevaluador);

		for (HrEmpleadodesempeno en : lista) {
			HrEmpleadodesempeno dto = new HrEmpleadodesempeno();
			dto = en;
			for (DtoDwMaMiscelaneosdetalleSelect foda : lstTipo) {
				if (foda.getCodigoelemento().equals(en.getTipo())) {
					dto.setDescripcionFoda(foda.getDescripcionlocal());
				}
			}
			dto.setEliminado(ConstanteRrhh.TIPO_NO);
			this.getDw5().add(dto);
		}
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		this.setAccionPantalla(accion_solicitada.NUEVO);
		Integer llSecuencia;
		llSecuencia = this.getFacRrhh().getHrEmpleadodesempenoServicio()
				.ObtenerMaximaSecuencia(empleado, secuenciaeval);

		if ((this.getDw5().size() + 1) > llSecuencia)
			llSecuencia = this.getDw5().size() + 1;
		
		llSecuencia=obtenerUltimoSecuencia(this.getDw5(), llSecuencia);

		HrEmpleadodesempeno bean = new HrEmpleadodesempeno();
		bean.getPk().setCompanyowner(compania);
		bean.getPk().setEmpleado(empleado);
		bean.getPk().setSecuenciaeval(secuenciaeval);
		bean.getPk().setSecuencia(llSecuencia);
		bean.getPk().setEmpleadoevaluador(empleadoevaluador);
		bean.setDescripcion("");
		bean.setEliminado(ConstanteRrhh.TIPO_NO);
		
		registroSeleccionado = bean;

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"agregarFortalezas");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrFortalezasDebilidadesSelector.getInstance().mensaje(mensajeGenerico);
		CwHrFortalezasDebilidadesSelector.getInstance().setLstTipo(lstTipo);

		return null;
	}

	private Integer obtenerUltimoSecuencia(List<HrEmpleadodesempeno> dw5,Integer secuencia) {
		int num, max = 0, min = 0;
		Integer llSecuencia=secuencia;
		
		List<HrEmpleadodesempeno> lstdw5= new ArrayList<HrEmpleadodesempeno>();
		for(HrEmpleadodesempeno objt: dw5){
			if(objt.getEliminado().equals(ConstanteRrhh.TIPO_NO)){
				lstdw5.add(objt);
			}
		}
		
		for (int i = 0; i < lstdw5.size(); i++) {
			num = lstdw5.get(i).getPk().getSecuencia().intValue();
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

		if (max >=llSecuencia) {
			llSecuencia = max+1;
		}
		return llSecuencia;
	}

	
	@Override
	public String editar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,
				"editarFortalezas");
		param.put("registroSeleccionado", registroSeleccionado);

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrFortalezasDebilidadesSelector.getInstance().mensaje(mensajeGenerico);
		
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

		for (HrEmpleadodesempeno em : this.getDw5()) {
			if (em.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia()) {
				em.setEliminado("S");
				break;
			}
		}

		for (int i = 0; i < this.getDw5().size(); i++) {
			if (this.getDw5().get(i).getEliminado().equals(ConstanteRrhh.TIPO_NO))
				registroSeleccionado = this.getDw5().get(i);
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

		for (HrEmpleadodesempeno em : this.getDw5()) {
			if (em.getPk().getSecuencia() == registroSeleccionado.getPk()
					.getSecuencia()) {
				em.setDescripcion(registroSeleccionado.getDescripcion());
				em.setDescripcionFoda(registroSeleccionado.getDescripcionFoda());
				em.setTipo(registroSeleccionado.getTipo());
				break;
			}
		}
		this.getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:dtFortalezas");
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
				.equals("insertFortalezas")) {

			registroSeleccionado =   (HrEmpleadodesempeno) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			
			LOGGER.debug("ACCION::"+accion_solicitada.NUEVO);
			if (this.getAccionPantalla().equals(accion_solicitada.NUEVO)) {
				this.getDw5().add(registroSeleccionado);
			}
		}
		
		this.getWebControlContext().actualizar(
				"frmEvaluacionEmpleado:tvDatos:dtFortalezas");
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

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
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

	public List<DtoDwMaMiscelaneosdetalleSelect> getLstTipo() {
		return lstTipo;
	}

	public void setLstTipo(List<DtoDwMaMiscelaneosdetalleSelect> lstTipo) {
		this.lstTipo = lstTipo;
	}

	public DtoDwMaMiscelaneosdetalleSelect getDtoMiscelaneos() {
		return dtoMiscelaneos;
	}

	public void setDtoMiscelaneos(DtoDwMaMiscelaneosdetalleSelect dtoMiscelaneos) {
		this.dtoMiscelaneos = dtoMiscelaneos;
	}

	public HrEmpleadodesempeno getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrEmpleadodesempeno registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}
