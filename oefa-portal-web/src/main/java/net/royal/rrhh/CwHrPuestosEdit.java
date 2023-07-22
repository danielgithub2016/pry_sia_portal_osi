package net.royal.rrhh;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.core.dominio.MaMiscelaneosdetallePk;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrClasificadorcargo;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantilla;
import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrPosicionempresa;
import net.royal.erp.rrhh.dominio.HrPosicionempresaPk;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajo;
import net.royal.erp.rrhh.dominio.HrPuestoconfianza;
import net.royal.erp.rrhh.dominio.HrPuestoconfianzaPk;
import net.royal.erp.rrhh.dominio.HrPuestocursos;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDoc;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.erp.rrhh.dominio.HrPuestoexperiencia;
import net.royal.erp.rrhh.dominio.HrPuestoformacion;
import net.royal.erp.rrhh.dominio.HrPuestofunciones;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;
import net.royal.erp.rrhh.dominio.HrPuestoinformatica;
import net.royal.erp.rrhh.dominio.HrPuestorelaciones;
import net.royal.erp.rrhh.dominio.HrPuestoreporta;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestosimilar;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;
import net.royal.erp.rrhh.dominio.dto.DtoDSeleccionEvaluacion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

import org.primefaces.event.TabChangeEvent;

@ManagedBean
@SessionScoped
public class CwHrPuestosEdit extends CBaseBean implements UIMantenimientoController {
	private List<HrPuestosubordinado> dw_subordinado;
	private List<HrPuestocursos> dw_cursos;
	private List<HrMetaspuesto> dw_metas;
	private List<DtoDSeleccionEvaluacion> dw_evaluacion;
	private List<DtoDSeleccionEvaluacion> dw_seleccion;
	private List<HrPuestoempresaDoc> dw_puestodoc;
	private List<HrPuestoreporta> dw_reporta;
	private HrPuestoempresa dw_header;
	private List<HrPuestorelaciones> dw_relacion;
	private List<HrPuestofunciones> dw_detail_funciones;
	private List<HrPuestoexperiencia> dw_experiencia_exterior;
	private HrPuestoexperiencia dw_registro_experiencia;
	private HrPuestoexperiencia obj_experiencia_exterior;
	private List<HrPuestoexperiencia> dw_experiencia_local;
	private List<HrPuestoformacion> dw_formacion;
	private List<HrPuestoidiomas> dw_idioma;
	private List<HrPuestoinformatica> dw_informatica;
	private List<HrPuestocondicionestrabajo> dw_condiciones_trabajo;
	private List<HrPuestoriesgotrabajo> dw_riesgo;
	private List<HrPuestosimilar> dw_similar;

	private List<MaMiscelaneosdetalle> familia;
	private MaMiscelaneosdetalle fam_position;

	private String nombreArchivoPDF;

	private Integer tabActivo;
	private Integer tabActivo1 = 0;
	private String descripcion, str_familia, cargo, puestoconfianza, gradosalario, puestosuperior, clasificadorcargo,
			str_RTPS, entregaplantillas, clasificadorpuesto, RTPS, w$_data, dwo_name, cadena, unidadOrganica;

	private Integer codigopuesto;

	private String pantallaReferencia;

	public String imprimirRequisitos() throws Exception {
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();

		parametrosReport.put("PAR_PUESTO", new BigDecimal(codigopuesto));

		File archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "rrhh" + File.separator
				+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
				+ File.separator + "formatos" + File.separator + File.separator + "Dw_requisitos.jasper");

		nombreArchivoPDF = getFacRrhh().getHrEmpleadoasistenciasServicio().ejecutarReporteIReport(archivo.getPath(),
				parametrosReport);

		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);
		return null;

	}

	public String imprimir() throws Exception {
		Integer ls_codigo = 0;
		String ls_cadena = " ";
		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");
		if (!UValidador.esListaVacia(dw_subordinado)) {
			for (HrPuestosubordinado obj : dw_subordinado) {
				ls_codigo = obj.getPk().getPuestosubordinado();
				HrPuestoempresaPk a = new HrPuestoempresaPk();
				HrPuestoempresa b = new HrPuestoempresa();
				a.setCodigopuesto(ls_codigo);
				if (!ls_cadena.equals(" ")) {
					ls_cadena = ls_cadena + ", ";
				}
				b = (HrPuestoempresa) this.getFacRrhh().getHrPuestoempresaServicio().obtenerPorId(a);
				if (!UValidador.estaVacio(b.getDescripcion())) {
					ls_cadena = ls_cadena + b.getDescripcion() + " ";
				}
				b.setDescripcion(null);
			}
		}
		// enviar parametro a imprimir

		Map<String, Object> parametrosReport = new HashMap<String, Object>();
		String anio = new SimpleDateFormat("yyyy").format(new Date());
		parametrosReport.put("par_cia", getUsuarioActual().getCompaniaSocioCodigo());
		parametrosReport.put("par_ano", new BigDecimal(anio));
		parametrosReport.put("par_puesto", new BigDecimal(codigopuesto));
		parametrosReport.put("par_tipoplanilla", "S");
		parametrosReport.put("par_supervisa", ls_cadena);

		File archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "rrhh" + File.separator
				+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
				+ File.separator + "formatos" + File.separator + File.separator + "Dw_formato.jasper");

		nombreArchivoPDF = getFacRrhh().getHrEmpleadoasistenciasServicio().ejecutarReporteIReport(archivo.getPath(),
				parametrosReport);

		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);
		return null;

	}

	public static CwHrPuestosEdit getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrPuestosEdit}", CwHrPuestosEdit.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		fam_position = new MaMiscelaneosdetalle();
		dw_subordinado = new ArrayList<HrPuestosubordinado>();
		dw_subordinado = this.getFacRrhh().getHrPuestosubordinadoServicio().listarTabPuestosSubordinados(codigopuesto);
		return null;
	}

	public void onTabChange2(TabChangeEvent event) throws Exception {
		if (!UValidador.esNulo(event.getTab())) {
			if (event.getTab().getId().equals("tVistaPrevia")) {
				imprimir();
			}
			if (event.getTab().getId().equals("tRequisitoMinimo")) {
				imprimirRequisitos();
			}
		} else {
			imprimir();
		}

	}

	public void onTabChange(TabChangeEvent event) throws Exception {
		if (event.getTab().getId().equals("tpuestossubordinados")) {
			LOGGER.debug("Entrando en el TAB PUESTOS SUBORDINADOS");
		}
		if (event.getTab().getId().equals("totrosestudios")) {
			LOGGER.debug("Entrando en el TAB OTROS ESTUDIOS");

			dw_cursos = new ArrayList<HrPuestocursos>();
			dw_cursos = this.getFacRrhh().getHrPuestocursosServicio().listarTabOtrosEstudios(codigopuesto);
		}
		if (event.getTab().getId().equals("tobjetivosmetas")) {
			LOGGER.debug("Entrando en el TAB OBJETIVOS METAS");

			dw_metas = new ArrayList<HrMetaspuesto>();
			dw_metas = this.getFacRrhh().getHrMetaspuestoServicio().listarTabObjetivosMetas(codigopuesto);
		}
		if (event.getTab().getId().equals("tevaluacion")) {
			LOGGER.debug("Entrando en el TAB EVALUACION");

			dw_evaluacion = new ArrayList<DtoDSeleccionEvaluacion>();
			dw_evaluacion = this.getFacRrhh().getHr().getHrmastDatawindow().dSeleccionEvaluacion("S",
					BigDecimal.valueOf(codigopuesto));

		}
		if (event.getTab().getId().equals("tseleccion")) {
			LOGGER.debug("Entrando en el TAB SELECCION");

			dw_seleccion = new ArrayList<DtoDSeleccionEvaluacion>();
			dw_seleccion = this.getFacRrhh().getHr().getHrmastDatawindow().dSeleccionEvaluacion("S",
					BigDecimal.valueOf(codigopuesto));

		}
		if (event.getTab().getId().equals("tformatosevaluacion")) {
			LOGGER.debug("Entrando en el TAB FORMATOS EVALUACION");

			dw_puestodoc = new ArrayList<HrPuestoempresaDoc>();
			dw_puestodoc = this.getFacRrhh().getHrPuestoempresaDocServicio().listarTabFormatosEvaluacion(codigopuesto);

		}
		if (event.getTab().getId().equals("tpuesto")) {
			LOGGER.debug("Entrando en el TAB PUESTO");

			fam_position = new MaMiscelaneosdetalle();
			dw_header = new HrPuestoempresa();

			dw_header = this.getFacRrhh().getHrPuestoempresaServicio().obtenerPuestoEmpresaporCodigo(codigopuesto);
			// puestoconfianza
			HrPuestoconfianzaPk pkcp = new HrPuestoconfianzaPk();
			pkcp.setCodigopuestoconfianza(dw_header.getCodigopuestoconfianza());

			HrPuestoconfianza objPuestoconfianza = (HrPuestoconfianza) getFacRrhh().getHrPuestoconfianzaServicio()
					.obtenerPorId(pkcp);

			if (!UValidador.esNulo(objPuestoconfianza)) {
				puestoconfianza = objPuestoconfianza.getDescripcionlocal();

			} else {
				puestoconfianza = " ";
			}
			// gradosalario

			HrGradosalariomast objSal = this.getFacRrhh().getHrGradosalariomastServicio()
					.obtenerGradoSalarioxParam(dw_header.getGradosalario());

			if (!UValidador.esNulo(objSal)) {
				gradosalario = objSal.getDescripcionlocal();

			} else {
				gradosalario = " ";
			}
			// clasificadorcargo

			HrCargosmast objCargo = this.getFacRrhh().getHrCargosmastServicio()
					.obtenerCargosmastxparam(dw_header.getCategoriafuncional());

			if (!UValidador.esNulo(objCargo)) {
				clasificadorcargo = objCargo.getDescripcionlocal();

			} else {
				clasificadorcargo = " ";
			}
			// puestosuperior

			HrPuestoempresa objpempresa = this.getFacRrhh().getHrPuestoempresaServicio()
					.obtenerPuestoEmpresaporCodigo(dw_header.getPuestosuperior());

			if (!UValidador.esNulo(objpempresa)) {
				puestosuperior = objpempresa.getDescripcion();

			} else {
				puestosuperior = " ";
			}

			// plantillasentregas

			HrCtrlentregasplantilla objplantillas = this.getFacRrhh().getHrCtrlentregasplantillaServicio()
					.obtenerplantillaparam(dw_header.getPlantillaentregas());

			if (!UValidador.esNulo(objplantillas)) {
				entregaplantillas = objplantillas.getDescripcion();

			} else {
				entregaplantillas = " ";
			}

			// RTPS
			str_RTPS = String.valueOf(dw_header.getCodigortps());

			MaMiscelaneosdetallePk pk2 = new MaMiscelaneosdetallePk();
			pk2.setAplicacioncodigo("PR");
			pk2.setCompania("999999");
			pk2.setCodigotabla("RTPS_TB_10");
			pk2.setCodigoelemento(str_RTPS.trim());

			fam_position = (MaMiscelaneosdetalle) getFacCore().getMaMiscelaneosdetalleServicio().obtenerPorId(pk2,
					false);

			if (!UValidador.esNulo(fam_position)) {
				RTPS = fam_position.getDescripcionlocal();

			} else {
				RTPS = "";
			}

			// clasificardo cargo

			HrClasificadorcargo objclasicargo = this.getFacRrhh().getHrClasificadorcargoServicio()
					.obtenerClasificadorCargoparam(dw_header.getClasificadorcargo());

			if (!UValidador.esNulo(objclasicargo)) {
				clasificadorpuesto = objclasicargo.getDescripcionlocal();

			} else {
				clasificadorpuesto = " ";
			}

			// familia
			str_familia = String.valueOf(dw_header.getFamiliapuesto());

			MaMiscelaneosdetallePk pk = new MaMiscelaneosdetallePk();
			pk.setAplicacioncodigo("HR");
			pk.setCompania("999999");
			pk.setCodigotabla("FAMPUESEVA");
			pk.setCodigoelemento(str_familia.trim());

			fam_position = (MaMiscelaneosdetalle) getFacCore().getMaMiscelaneosdetalleServicio().obtenerPorId(pk,
					false);

			//Unidad orgánica
			HrPosicionempresa pos;
			HrPosicionempresaPk pkPos = new HrPosicionempresaPk();
			pkPos.setCodigoposicion(dw_header.getCodigoposicion());
			pkPos.setCompanyowner(this.getUsuarioActual().getCompaniaSocioCodigo());

			pos = (HrPosicionempresa) this.getFacRrhh().getHrPosicionempresaServicio().obtenerPorId(pkPos, false);

			if (!UValidador.esNulo(pos))
				this.unidadOrganica = pos.getDescripcion();

		}
		if (event.getTab().getId().equals("trelaciones")) {
			LOGGER.debug("Entrando en el TAB RELACIONES");

			dw_reporta = new ArrayList<HrPuestoreporta>();
			dw_reporta = this.getFacRrhh().getHrPuestoreportaServicio().listarTabRelaciones(codigopuesto);

			dw_relacion = new ArrayList<HrPuestorelaciones>();
			dw_relacion = this.getFacRrhh().getHrPuestorelacionesServicio().listarTabPuestoRelacion(codigopuesto);

		}
		if (event.getTab().getId().equals("tfunciones")) {
			LOGGER.debug("Entrando en el TAB FUNCIONES");

			dw_detail_funciones = new ArrayList<HrPuestofunciones>();
			dw_detail_funciones = this.getFacRrhh().getHrPuestofuncionesServicio().listarFunciones(codigopuesto);
		}
		if (event.getTab().getId().equals("tformacion")) {
			LOGGER.debug("Entrando en el TAB FORMACION");

			dw_formacion = new ArrayList<HrPuestoformacion>();
			dw_formacion = this.getFacRrhh().getHrPuestoformacionServicio().listarPuestoFormacion(codigopuesto);

			dw_idioma = new ArrayList<HrPuestoidiomas>();
			dw_idioma = this.getFacRrhh().getHrPuestoidiomasServicio().listarPuestoidiomas(codigopuesto);

			dw_informatica = new ArrayList<HrPuestoinformatica>();
			dw_informatica = this.getFacRrhh().getHrPuestoinformaticaServicio().listarPuestosInformaticas(codigopuesto);

		}
		if (event.getTab().getId().equals("texperienciaprevia")) {
			LOGGER.debug("Entrando en el TAB EXPERIENCIA PREVIA");

			dw_experiencia_exterior = new ArrayList<HrPuestoexperiencia>();
			dw_experiencia_exterior = this.getFacRrhh().getHrPuestoexperienciaServicio()
					.listarPuestoExperienciaporCodigo(codigopuesto);

			if (!UValidador.esListaVacia(dw_experiencia_exterior)) {

				obj_experiencia_exterior = dw_experiencia_exterior.get(0);
				w$_data = obj_experiencia_exterior.getPk().getAreaexperiencia();
				LOGGER.debug(w$_data);
			}

			dw_experiencia_local = new ArrayList<HrPuestoexperiencia>();

		}
		if (event.getTab().getId().equals("tcondicionestrabajo")) {
			LOGGER.debug("Entrando en el TAB CONDICIONES TRABAJO");

			dw_condiciones_trabajo = new ArrayList<HrPuestocondicionestrabajo>();
			dw_condiciones_trabajo = this.getFacRrhh().getHrPuestocondicionestrabajoServicio()
					.listarCondicionesTrabajo(codigopuesto);

		}
		if (event.getTab().getId().equals("triesgotrabajo")) {
			LOGGER.debug("Entrando en el TAB RIESGO TRABAJO");

			dw_riesgo = new ArrayList<HrPuestoriesgotrabajo>();
			dw_riesgo = this.getFacRrhh().getHrPuestoriesgotrabajoServicio().listarRiesgosTrabajo(codigopuesto);

		}
		if (event.getTab().getId().equals("tpuestosimilares")) {
			LOGGER.debug("Entrando en el TAB PUESTOS SIMILARES");

			dw_similar = new ArrayList<HrPuestosimilar>();
			dw_similar = this.getFacRrhh().getHrPuestosimilarServicio().listarPuestosSimilar(codigopuesto);

		}
		if (event.getTab().getId().equals("tFormato")) {
			LOGGER.debug("Entrando en el TAB PUESTOS SIMILARES");
			if (tabActivo1 == 0) {
				imprimir();
			} else {
				imprimirRequisitos();
			}

			// LOGGER.debug(dw_similar.size());

		}
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String buscarMiscelaneos() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "buscaMisc");
		// param.put("w_str_pass1", obj_experiencia_exterior);
		param.put("w_str_pass2", w$_data);
		param.put("w_str_pass3", "HR");
		param.put("w_str_pass4", "999999");
		param.put("w_str_pass5", "AREAEXPER");

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);

		CwHrMiscelaneoSelectorVarios.getInstance().mensaje(mensajeGenerico);
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
		return pantallaReferencia;
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

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("traerMiscelaneo")) {

			if (!UValidador.estaVacio(mensajeControllerGenerico.getParametros().get("miscelaneo"))) {

				cadena = mensajeControllerGenerico.getParametros().get("miscelaneo").toString();

				for (HrPuestoexperiencia obj : dw_experiencia_exterior) {
					obj.setAuxFuncion(cadena);
				}

			} else {
				return null;
			}

		}

		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		tabActivo = 0;

		dw_subordinado = this.getFacRrhh().getHrPuestosubordinadoServicio().listarTabPuestosSubordinados(codigopuesto);

		obj_experiencia_exterior = new HrPuestoexperiencia();
		dw_registro_experiencia = new HrPuestoexperiencia();

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getTabActivo() {
		return tabActivo;
	}

	public void setTabActivo(Integer tabActivo) {
		this.tabActivo = tabActivo;
	}

	public List<HrPuestosubordinado> getDw_subordinado() {
		return dw_subordinado;
	}

	public void setDw_subordinado(List<HrPuestosubordinado> dw_subordinado) {
		this.dw_subordinado = dw_subordinado;
	}

	public List<HrPuestocursos> getDw_cursos() {
		return dw_cursos;
	}

	public void setDw_cursos(List<HrPuestocursos> dw_cursos) {
		this.dw_cursos = dw_cursos;
	}

	public List<DtoDSeleccionEvaluacion> getDw_evaluacion() {
		return dw_evaluacion;
	}

	public List<DtoDSeleccionEvaluacion> getDw_seleccion() {
		return dw_seleccion;
	}

	public void setDw_evaluacion(List<DtoDSeleccionEvaluacion> dw_evaluacion) {
		this.dw_evaluacion = dw_evaluacion;
	}

	public void setDw_seleccion(List<DtoDSeleccionEvaluacion> dw_seleccion) {
		this.dw_seleccion = dw_seleccion;
	}

	public List<HrMetaspuesto> getDw_metas() {
		return dw_metas;
	}

	public void setDw_metas(List<HrMetaspuesto> dw_metas) {
		this.dw_metas = dw_metas;
	}

	public List<HrPuestoempresaDoc> getDw_puestodoc() {
		return dw_puestodoc;
	}

	public void setDw_puestodoc(List<HrPuestoempresaDoc> dw_puestodoc) {
		this.dw_puestodoc = dw_puestodoc;
	}

	public List<HrPuestoreporta> getDw_reporta() {
		return dw_reporta;
	}

	public List<HrPuestorelaciones> getDw_relacion() {
		return dw_relacion;
	}

	public void setDw_reporta(List<HrPuestoreporta> dw_reporta) {
		this.dw_reporta = dw_reporta;
	}

	public void setDw_relacion(List<HrPuestorelaciones> dw_relacion) {
		this.dw_relacion = dw_relacion;
	}

	public List<HrPuestoformacion> getDw_formacion() {
		return dw_formacion;
	}

	public List<HrPuestoidiomas> getDw_idioma() {
		return dw_idioma;
	}

	public List<HrPuestoinformatica> getDw_informatica() {
		return dw_informatica;
	}

	public void setDw_formacion(List<HrPuestoformacion> dw_formacion) {
		this.dw_formacion = dw_formacion;
	}

	public void setDw_idioma(List<HrPuestoidiomas> dw_idioma) {
		this.dw_idioma = dw_idioma;
	}

	public void setDw_informatica(List<HrPuestoinformatica> dw_informatica) {
		this.dw_informatica = dw_informatica;
	}

	public List<HrPuestocondicionestrabajo> getDw_condiciones_trabajo() {
		return dw_condiciones_trabajo;
	}

	public List<HrPuestoriesgotrabajo> getDw_riesgo() {
		return dw_riesgo;
	}

	public List<HrPuestosimilar> getDw_similar() {
		return dw_similar;
	}

	public void setDw_condiciones_trabajo(List<HrPuestocondicionestrabajo> dw_condiciones_trabajo) {
		this.dw_condiciones_trabajo = dw_condiciones_trabajo;
	}

	public void setDw_riesgo(List<HrPuestoriesgotrabajo> dw_riesgo) {
		this.dw_riesgo = dw_riesgo;
	}

	public void setDw_similar(List<HrPuestosimilar> dw_similar) {
		this.dw_similar = dw_similar;
	}

	public List<HrPuestoexperiencia> getDw_experiencia_exterior() {
		return dw_experiencia_exterior;
	}

	public List<HrPuestoexperiencia> getDw_experiencia_local() {
		return dw_experiencia_local;
	}

	public void setDw_experiencia_exterior(List<HrPuestoexperiencia> dw_experiencia_exterior) {
		this.dw_experiencia_exterior = dw_experiencia_exterior;
	}

	public void setDw_experiencia_local(List<HrPuestoexperiencia> dw_experiencia_local) {
		this.dw_experiencia_local = dw_experiencia_local;
	}

	public HrPuestoempresa getDw_header() {
		return dw_header;
	}

	public void setDw_header(HrPuestoempresa dw_header) {
		this.dw_header = dw_header;
	}

	public List<MaMiscelaneosdetalle> getFamilia() {
		return familia;
	}

	public void setFamilia(List<MaMiscelaneosdetalle> familia) {
		this.familia = familia;
	}

	public MaMiscelaneosdetalle getFam_position() {
		return fam_position;
	}

	public void setFam_position(MaMiscelaneosdetalle fam_position) {
		this.fam_position = fam_position;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStr_familia() {
		return str_familia;
	}

	public void setStr_familia(String str_familia) {
		this.str_familia = str_familia;
	}

	public String getPuestoconfianza() {
		return puestoconfianza;
	}

	public void setPuestoconfianza(String puestoconfianza) {
		this.puestoconfianza = puestoconfianza;
	}

	public String getGradosalario() {
		return gradosalario;
	}

	public void setGradosalario(String gradosalario) {
		this.gradosalario = gradosalario;
	}

	public String getClasificadorcargo() {
		return clasificadorcargo;
	}

	public void setClasificadorcargo(String clasificadorcargo) {
		this.clasificadorcargo = clasificadorcargo;
	}

	public String getPuestosuperior() {
		return puestosuperior;
	}

	public void setPuestosuperior(String puestosuperior) {
		this.puestosuperior = puestosuperior;
	}

	public String getStr_RTPS() {
		return str_RTPS;
	}

	public void setStr_RTPS(String str_RTPS) {
		this.str_RTPS = str_RTPS;
	}

	public List<HrPuestofunciones> getDw_detail_funciones() {
		return dw_detail_funciones;
	}

	public void setDw_detail_funciones(List<HrPuestofunciones> dw_detail_funciones) {
		this.dw_detail_funciones = dw_detail_funciones;
	}

	public String getEntregaplantillas() {
		return entregaplantillas;
	}

	public String getClasificadorpuesto() {
		return clasificadorpuesto;
	}

	public void setEntregaplantillas(String entregaplantillas) {
		this.entregaplantillas = entregaplantillas;
	}

	public void setClasificadorpuesto(String clasificadorpuesto) {
		this.clasificadorpuesto = clasificadorpuesto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getRTPS() {
		return RTPS;
	}

	public void setRTPS(String rTPS) {
		RTPS = rTPS;
	}

	/**
	 * @return the codigopuesto
	 */
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	/**
	 * @param codigopuesto
	 *            the codigopuesto to set
	 */
	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	public HrPuestoexperiencia getObj_experiencia_exterior() {
		return obj_experiencia_exterior;
	}

	public void setObj_experiencia_exterior(HrPuestoexperiencia obj_experiencia_exterior) {
		this.obj_experiencia_exterior = obj_experiencia_exterior;
	}

	public String getW$_data() {
		return w$_data;
	}

	public void setW$_data(String w$_data) {
		this.w$_data = w$_data;
	}

	public String getDwo_name() {
		return dwo_name;
	}

	public void setDwo_name(String dwo_name) {
		this.dwo_name = dwo_name;
	}

	public HrPuestoexperiencia getDw_registro_experiencia() {
		return dw_registro_experiencia;
	}

	public void setDw_registro_experiencia(HrPuestoexperiencia dw_registro_experiencia) {
		this.dw_registro_experiencia = dw_registro_experiencia;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getNombreArchivoPDF() {
		return nombreArchivoPDF;
	}

	public void setNombreArchivoPDF(String nombreArchivoPDF) {
		this.nombreArchivoPDF = nombreArchivoPDF;
	}

	public Integer getTabActivo1() {
		return tabActivo1;
	}

	public void setTabActivo1(Integer tabActivo1) {
		this.tabActivo1 = tabActivo1;
	}

	public String getPantallaReferencia() {
		return pantallaReferencia;
	}

	public void setPantallaReferencia(String pantallaReferencia) {
		this.pantallaReferencia = pantallaReferencia;
	}

	public String getUnidadOrganica() {
		return unidadOrganica;
	}

	public void setUnidadOrganica(String unidadOrganica) {
		this.unidadOrganica = unidadOrganica;
	}

}
