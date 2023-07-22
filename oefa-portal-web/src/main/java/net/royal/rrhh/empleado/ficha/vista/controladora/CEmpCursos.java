package net.royal.rrhh.empleado.ficha.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.StreamedContent;

import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.asistencia.vista.controladora.CwWhDocumentoArchivoList;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadocursos;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosdocumentoPk;
import net.royal.erp.sistema.dominio.dto.DtoDwWhDocumentoarchivoList;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.controladora.CHrActividad;
import net.royal.seguridad.constante.ConstanteSeguridad;
import pe.gob.oefa.ws.alfresco.service.UOefaAlfresco;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CEmpCursos extends CBaseBean implements UIMantenimientoController {

	private static Log LOGGER = LogFactory.getLog(CEmpCursos.class);

	private List<HrEmpleadocursos> lista;
	private List<HrEmpleadocursosdocumento> documentos;
	private HrEmpleadocursosdocumento bean;
	private HrEmpleadocursosdocumento registroSeleccionadoDocumento;
	private HrEmpleadocursos registroSeleccionado;
	private String nombreNuevo;
	private boolean verArchivosPublicos, verBotonNuevo;
	private String key, ws;
	private Boolean esInformeFinal;
	private String titulo, curso, mensaje;
	private Integer cantDias;

	public Boolean getEsInformeFinal() {
		return esInformeFinal;
	}

	public void setEsInformeFinal(Boolean esInformeFinal) {
		this.esInformeFinal = esInformeFinal;
	}

	private StreamedContent archivodescargar;
	private int maxTamanioArchivo;

	public CEmpCursos() {
		this.PANTALLA_LISTADO = "cursosempleado";
	}

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		this.buscar();

		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		LOGGER.debug("buscar");
		LOGGER.debug(verArchivosPublicos);

		if (UValidador.esNulo(curso) || UValidador.estaVacio(curso))
			curso = null;

		if (!verArchivosPublicos) {
			titulo = "Cursos del Empleado";
			lista = this.getFacRrhh().getHrEmpleadocursosServicio()
					.listarPorEmpleado(this.getUsuarioActual().getIdPersona(), curso, null);
		} else {
			titulo = "Materiales Disponibles";
			lista = this.getFacRrhh().getHrEmpleadocursosServicio().listarPorEmpleadoMateriales(curso);
		}

		LOGGER.debug(lista.size());
		return null;
	}

	public String buscarPendientes() throws Exception {
		inicializarFiltrosListado();

		List<HrEmpleadocapacitacion> cantidadSinInforme = this.getFacRrhh().getHrEmpleadocapacitacionServicio()
				.contarCapacitacionDocumentoPendiente(this.getUsuarioActual().getIdPersona(), cantDias);
		String capacitaciones = "";
		for (HrEmpleadocapacitacion obj : cantidadSinInforme) {
			if (UValidador.esNulo(obj.getFlgadjuntoinformfinal())) {
				capacitaciones = capacitaciones + "'" + obj.getCapacitacion() + "',";
			} else {
				Integer cantDocumentos = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio()
						.obtenerCantDocumentos(obj.getEmpleado().intValue(), obj.getCapacitacion(), null);

				if (cantDocumentos < 2) {
					capacitaciones = capacitaciones + "'" + obj.getCapacitacion() + "',";
				}
			}
		}

		lista = null;

		if (CHrActividad.getInstance().getListaNotificacionDP2() > 0) {
			capacitaciones = capacitaciones.substring(0, capacitaciones.length() - 1);

			lista = this.getFacRrhh().getHrEmpleadocursosServicio()
					.listarPorEmpleado(this.getUsuarioActual().getIdPersona(), curso, capacitaciones);
		}
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String nuevo() throws Exception {
		return null;
	}

	public String nuevoArchivo() throws Exception {
		if (!verArchivosPublicos) {
			this.setAccionPantalla(accion_solicitada.NUEVO);
			Integer sec = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().incrementarDocumenoSecuencia(
					registroSeleccionado.getEmpleado().intValue(), registroSeleccionado.getCapacitacion());

			esInformeFinal = false;
			this.getBindingController().setAuditoriaNuevo();
			this.bean = new HrEmpleadocursosdocumento();
			bean.getPk().setEmpleado(registroSeleccionado.getEmpleado().intValue());
			bean.getPk().setSecuencia(sec);
			bean.getPk().setCapacitacion(registroSeleccionado.getCapacitacion());
			CwWhDocumentoArchivoList.getInstance().nuevo();
		}
		return null;
	}

	@Override
	public String editar() throws Exception {
		this.setAccionPantalla(accion_solicitada.EDITAR);
		HrEmpleadocursosdocumentoPk pk = new HrEmpleadocursosdocumentoPk();
		pk.setDocumento(registroSeleccionadoDocumento.getPk().getDocumento());
		pk.setEmpleado(registroSeleccionadoDocumento.getPk().getEmpleado());
		pk.setSecuencia(registroSeleccionadoDocumento.getPk().getSecuencia());
		bean = (HrEmpleadocursosdocumento) this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().obtenerPorId(pk);
		this.getBindingController().setAuditoriaModificar(bean);
		return null;
	}

	@Override
	public String ver() throws Exception {

		if (!verArchivosPublicos) {

			documentos = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().listarPorEmpleadoSecuencia(
					registroSeleccionado.getEmpleado().intValue(), registroSeleccionado.getCapacitacion(), null);
		} else {
			documentos = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().listarPorEmpleadoSecuencia(null,
					registroSeleccionado.getCapacitacion(), "S");
		}

		if (!UValidador.esNulo(registroSeleccionado.getAuxDateFechaFin())) {
			Date fecha = UFechaHora.anadirDiasAFechas(registroSeleccionado.getAuxDateFechaFin(), cantDias);

			if (new Date().after(registroSeleccionado.getAuxDateFechaFin()) && new Date().before(fecha)) {
				verBotonNuevo = false;
			} else {
				verBotonNuevo = true;
			}
		} else {
			verBotonNuevo = true;
		}

		return "cursosdocumentolista";
	}

	private String obtenerParametroModoArchivo() {
		String modo = ConstanteSeguridad.PARAMETRO_MODOARCHIVO_BD;
		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "MODOARCHIV");
		String param = this.getFacCore().getParametrosmastServicio().obtenerValorCadena(pk);
		if (!UValidador.estaVacio(param)) {
			modo = param;
		} else {
			this.setMessageInfo("No se encontró el parámetro MODOARCHIV. Se tomó valor por defecto");
		}

		key = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "KEYALFRESC"));
		ws = this.getFacCore().getParametrosmastServicio()
				.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "WSALFRESCO"));
		return modo;
	}

	@Override
	public String eliminar() throws Exception {
		if (!verArchivosPublicos) {

			HrEmpleadocursosdocumentoPk pk = new HrEmpleadocursosdocumentoPk();
			pk.setDocumento(registroSeleccionadoDocumento.getPk().getDocumento());
			pk.setEmpleado(registroSeleccionadoDocumento.getPk().getEmpleado());
			pk.setSecuencia(registroSeleccionadoDocumento.getPk().getSecuencia());
			pk.setCapacitacion(registroSeleccionadoDocumento.getPk().getCapacitacion());
			pk.setCompanyowner(getUsuarioActual().getCompaniaSocioCodigo());

			bean = (HrEmpleadocursosdocumento) this.getFacRrhh().getHrEmpleadocursosdocumentoServicio()
					.obtenerPorId(pk);

			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				if (!UValidador.estaVacio(bean.getUuidalfresco())) {
					try {
						RptaWsBean resws = UOefaAlfresco.eliminarDocumento(bean.getUuidalfresco(), key);
						if (!resws.getCodMsg().equalsIgnoreCase("ok")) {
							this.setMessageError(resws.getCadMsg());
						} else {
							LOGGER.debug(resws.getCadMsg());
						}
					} catch (Exception e) {
						LOGGER.debug(e.getMessage());
						return null;
					}

				}
			}

			this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().eliminar(bean);

			buscar();
			ver();
			this.setMessageSuccess("Se eliminó correctamente");
		}
		return null;
	}

	@Override
	public String inactivar() throws Exception {

		return null;
	}

	public String verDocumento() throws Exception {
		String archivo = String.format("%s.%s", registroSeleccionadoDocumento.getNombrearchivo(),
				registroSeleccionadoDocumento.getExtension());
		if (!UValidador.esNulo(registroSeleccionadoDocumento.getUuidalfresco())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = UOefaAlfresco
							.obtenerDocumento(registroSeleccionadoDocumento.getUuidalfresco(), key);
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						File file = new File(UAplicacion.getRealPath() + UFile.getSeparador() + "temporaloefa"
								+ File.separator + archivo);
						FileUtils.writeByteArrayToFile(file, respuestaconsulta.getContenidoFile());
						System.gc();
						// new
						// UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(),
						// archivo, "temporaloefa");
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					System.gc();
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
			}
		} else {
			System.gc();
			setMessageError("No ha seleccionado ningún archivo");
			return null;
		}

		setSessionValue("nombrearchivo", archivo);

		return "documentos";
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		String archivo = registroSeleccionadoDocumento.getRutaArchivo();
		if (!UValidador.esNulo(registroSeleccionadoDocumento.getUuidalfresco())) {
			switch (obtenerParametroModoArchivo()) {
			case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

				if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
					this.setMessageError("No se encontraron los parametros key o ws");
					return null;
				}

				try {
					ContenidoECMBean respuestaconsulta = UOefaAlfresco
							.obtenerDocumento(registroSeleccionadoDocumento.getUuidalfresco(), key);
					LOGGER.debug(respuestaconsulta);
					if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
						LOGGER.debug("Se encontro el archivo");
						new UFile().cargarArchivoXByte(respuestaconsulta.getContenidoFile(), archivo, "temporaloefa");
					}
				} catch (Exception e) {
					LOGGER.debug(e.getMessage());
					this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
					return null;
				}
			}
		} else {
			setMessageError("No ha seleccionado ningún archivo");
			return null;
		}

		setSessionValue("nombrearchivo", archivo);

		return "documentos";
	}

	@Override
	public Boolean validar() throws Exception {
		boolean valido = true;
		if (!UValidador.esNulo(nombreNuevo)) {
			Integer iguales = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio()
					.contarNombreIgual(bean.getPk().getEmpleado(), nombreNuevo, bean.getPk().getCapacitacion());
			if (iguales > 0)
				valido = false;
		}
		return valido;
	}

	private Boolean validarInformeFinal() {

		Integer cantDocumentos = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().obtenerCantDocumentos(
				registroSeleccionado.getEmpleado().intValue(), registroSeleccionado.getCapacitacion(), "S");

		if (cantDocumentos > 0 && esInformeFinal) {
			return false;
		}

		return true;
	}

	@Override
	public String guardar() throws Exception {
		if (UValidador.estaVacio(bean.getNombrearchivo())) {
			setMessageError("El nombre del archivo no puede estar vacío");
			return null;
		}
		nombreNuevo = bean.getNombrearchivo();

		if (!validar()) {
			setMessageError("Ya se tiene un archivo con el mismo nombre");
			System.gc();
			return null;
		}

		if (!validarInformeFinal()) {
			setMessageError("Esta Capacitación ya se le agregado un archivo como Informe Final");
			System.gc();
			return null;
		}

		if (esInformeFinal) {
			bean.setFlgAdjuntoInformFinal("S");

			// SI ES INFORME FINAL GRABARLO TAMBIEN EN LA TABLA
			// HR_EMPLEADOCAPACITACION
			HrEmpleadocapacitacionPk pk = new HrEmpleadocapacitacionPk();
			pk.setCapacitacion(registroSeleccionado.getCapacitacion());
			pk.setEmpleado(bean.getPk().getEmpleado().intValue());

			HrEmpleadocapacitacion hrempleadocapacitacion = (HrEmpleadocapacitacion) this.getFacRrhh()
					.getHrEmpleadocapacitacionServicio().obtenerPorId(pk, false);
			hrempleadocapacitacion.setFlgadjuntoinformfinal("S");
			this.getFacRrhh().getHrEmpleadocapacitacionServicio().actualizar(hrempleadocapacitacion);
		}

		switch (obtenerParametroModoArchivo()) {
		case ConstanteSeguridad.PARAMETRO_MODOARCHIVO_ALFRESCO:

			if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
				this.setMessageError("No se encontraron los parametros key o ws");
				System.gc();
				return null;
			}

			if (!UValidador.estaVacio(bean.getUuidalfresco())) {
				UOefaAlfresco.eliminarDocumento(bean.getUuidalfresco(), key);
			}
			try {
				LOGGER.debug("Archivo a guardar " + bean.getNombrearchivo());
				RptaWsBean respuestaws = UOefaAlfresco.registrarDocumento(bean.getNombrearchivo(),
						UOefaAlfresco.RUTA_MATERIALES + bean.getPk().getEmpleado() + "/" + bean.getPk().getSecuencia(),
						UFile.obtenerArregloByte(bean.getRutaArchivo()), key);
				LOGGER.debug(respuestaws);
				if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
					bean.setUuidalfresco(respuestaws.getUuid());
					UFile.borrarArchivoTemporal(bean.getRutaArchivo());
				} else {
					System.gc();
					this.setMessageError(respuestaws.getCadMsg());
					return null;
				}
			} catch (Exception e) {
				this.setMessageError("Ocurrio un error al comunicarse con el ws\n no se pudo guardar el archivo");
				System.gc();
				return null;
			}

		}

		if (this.getAccionPantalla().equals(accion_solicitada.NUEVO)) {

			Integer doc = this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().incrementarDocumento(
					bean.getPk().getEmpleado(), bean.getPk().getSecuencia(), bean.getPk().getCapacitacion());
			bean.getPk().setDocumento(doc);
			bean.getPk().setCompanyowner(getUsuarioActual().getCompaniaSocioCodigo());
			bean.setEstado("A");
			bean = (HrEmpleadocursosdocumento) this.getBindingController().getAuditoriaNuevo(bean);
			bean.setNombrearchivo(FilenameUtils.getBaseName(bean.getNombrearchivo()));
			this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().registrar(bean);
			this.setMessageSuccess("Se registró correctamente");

		} else if (this.getAccionPantalla().equals(accion_solicitada.EDITAR)) {
			bean = (HrEmpleadocursosdocumento) this.getBindingController().getAuditoriaModificar(bean);
			bean.setNombrearchivo(FilenameUtils.getBaseName(bean.getNombrearchivo()));
			this.getFacRrhh().getHrEmpleadocursosdocumentoServicio().actualizar(bean);
			this.setMessageSuccess("Se actualizó correctamente");
		}
		buscar();
		ver();
		this.getWebControlContext().actualizar("frmCursosDocumentos:dtCapacitacionDocPen");
		this.getWebControlContext().actualizar("frmDocumentoEmpleado:dtCursosEmpleado");
		System.gc();
		return null;
	}

	@Override
	public String salir() throws Exception {

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
				.equals("cargarArchivo")) {
			DtoDwWhDocumentoarchivoList documento = (DtoDwWhDocumentoarchivoList) mensajeControllerGenerico
					.getParametros().get("documento");
			System.gc();

			bean.setNombrearchivo(documento.getArchivo());
			String extension = documento.getExtension();
			bean.setExtension(extension);
			bean.setRutaArchivo(documento.getRuta());
			esInformeFinal = documento.getEsInformeFinal();
			guardar();
		}
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		curso = null;
		verBotonNuevo = false;

		cantDias = this.getFacCore().getParametrosmastServicio()
				.obtenerValorInteger(new ParametrosmastPk("HR", "999999", "CANTDIAS"));

		mensaje = "Este botón estará activo durante " + cantDias + " dias después de finalizada la capacitación";

		BigDecimal tamArchivo = new BigDecimal(2);

		ParametrosmastPk pk = new ParametrosmastPk("HR", "999999", "TAMAARCH");
		Integer tamanioMB = this.getFacCore().getParametrosmastServicio().obtenerValorInteger(pk);
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {

		return null;
	}

	public static CEmpCursos getInstance() {
		return UFaces.evaluateExpressionGet("#{cEmpCursos}", CEmpCursos.class);
	}

	public List<HrEmpleadocursos> getLista() {
		return lista;
	}

	public void setLista(List<HrEmpleadocursos> lista) {
		this.lista = lista;
	}

	public List<HrEmpleadocursosdocumento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<HrEmpleadocursosdocumento> documentos) {
		this.documentos = documentos;
	}

	public HrEmpleadocursos getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(HrEmpleadocursos registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public HrEmpleadocursosdocumento getBean() {
		return bean;
	}

	public void setBean(HrEmpleadocursosdocumento bean) {
		this.bean = bean;
	}

	public HrEmpleadocursosdocumento getRegistroSeleccionadoDocumento() {
		return registroSeleccionadoDocumento;
	}

	public void setRegistroSeleccionadoDocumento(HrEmpleadocursosdocumento registroSeleccionadoDocumento) {
		this.registroSeleccionadoDocumento = registroSeleccionadoDocumento;
	}

	public boolean isVerArchivosPublicos() {
		return verArchivosPublicos;
	}

	public void setVerArchivosPublicos(boolean verArchivosPublicos) {
		this.verArchivosPublicos = verArchivosPublicos;
	}

	public StreamedContent getArchivodescargar() {
		return archivodescargar;
	}

	public void setArchivodescargar(StreamedContent archivodescargar) {
		this.archivodescargar = archivodescargar;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isVerBotonNuevo() {
		return verBotonNuevo;
	}

	public void setVerBotonNuevo(boolean verBotonNuevo) {
		this.verBotonNuevo = verBotonNuevo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
