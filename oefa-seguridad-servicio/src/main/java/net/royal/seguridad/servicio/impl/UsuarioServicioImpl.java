package net.royal.seguridad.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dao.AcCostcentermstDao;
import net.royal.seguridad.dao.AcSucursalDao;
import net.royal.seguridad.dao.AplicacionesmastDao;
import net.royal.seguridad.dao.AsAreaDao;
import net.royal.seguridad.dao.CompaniamastDao;
import net.royal.seguridad.dao.CompanyownerDao;
import net.royal.seguridad.dao.EmpleadomastDao;
import net.royal.seguridad.dao.HrPuestoempresaDao;
import net.royal.seguridad.dao.ImpuestosDao;
import net.royal.seguridad.dao.MaUnidadnegocioDao;
import net.royal.seguridad.dao.ParametrosmastDao;
import net.royal.seguridad.dao.PersonamastDao;
import net.royal.seguridad.dao.SeguridadautorizacioncompaniaDao;
import net.royal.seguridad.dao.SeguridadautorizacionesDao;
import net.royal.seguridad.dao.SeguridadconceptoDao;
import net.royal.seguridad.dao.SeguridadgrupoDao;
import net.royal.seguridad.dao.SeguridadperfilusuarioDao;
import net.royal.seguridad.dao.SyEmpresaDao;
import net.royal.seguridad.dao.SyPreferencesDao;
import net.royal.seguridad.dao.TipocambiomastDao;
import net.royal.seguridad.dao.UsuarioDao;
import net.royal.seguridad.dominio.AcCostcentermst;
import net.royal.seguridad.dominio.AcCostcentermstPk;
import net.royal.seguridad.dominio.AcSucursal;
import net.royal.seguridad.dominio.AcSucursalPk;
import net.royal.seguridad.dominio.AsArea;
import net.royal.seguridad.dominio.AsAreaPk;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.dominio.HrPuestoempresa;
import net.royal.seguridad.dominio.HrPuestoempresaPk;
import net.royal.seguridad.dominio.MaUnidadnegocio;
import net.royal.seguridad.dominio.MaUnidadnegocioPk;
import net.royal.seguridad.dominio.Personamast;
import net.royal.seguridad.dominio.PersonamastPk;
import net.royal.seguridad.dominio.Seguridadautorizaciones;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.dominio.SeguridadconceptoPk;
import net.royal.seguridad.dominio.Seguridadgrupo;
import net.royal.seguridad.dominio.SeguridadgrupoPk;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.dto.DtoMenu;
import net.royal.seguridad.servicio.UsuarioServicio;

@Service(value = "BeanServicioUsuarioSeguridad")
public class UsuarioServicioImpl extends GenericoServicioImpl implements UsuarioServicio {

	private UsuarioDao dao;
	private EmpleadomastDao empleadomastDao;
	private PersonamastDao personamastDao;
	private SeguridadgrupoDao seguridadgrupoDao;
	private SeguridadconceptoDao seguridadconceptoDao;
	private AplicacionesmastDao aplicacionesmastDao;
	private SyEmpresaDao syEmpresaDao;
	private SyPreferencesDao syPreferencesDao;
	private ParametrosmastDao parametrosmastDao;
	private CompaniamastDao companiamastDao;
	private ImpuestosDao impuestosDao;
	private TipocambiomastDao tipocambiomastDao;
//	private CompanyownerDao companyownerDao;
	private HrPuestoempresaDao hrPuestoempresaDao;
	private AcSucursalDao acSucursalDao;
	private AcCostcentermstDao acCostcentermstDao;
	private AsAreaDao asAreaDao;
	private MaUnidadnegocioDao maUnidadnegocioDao;
	private SeguridadperfilusuarioDao seguridadperfilusuarioDao;
	private SeguridadautorizacionesDao seguridadautorizacionesDao;
	private SeguridadautorizacioncompaniaDao seguridadautorizacioncompaniaDao;

	private static Log LOGGER = LogFactory.getLog(UsuarioServicioImpl.class);

	@Override
	public UsuarioActual traerDatosEmpleadoLogin(String usuario) {
		LOGGER.debug("buscando informacion de los empleados login - inicio");

		String temporal = null;
		UsuarioActual usuarioActual = null;
		Personamast persona;

		Criteria criteriaEmpleado = empleadomastDao.getCriteria();
		criteriaEmpleado.add(Restrictions.eq("codigousuario", usuario));
		List<Empleadomast> listEmpleadoMast = empleadomastDao.listarPorCriterios(criteriaEmpleado);
		LOGGER.debug("buscando informacion de los empleados login - fin");
		if (listEmpleadoMast == null) {
			LOGGER.debug("listEmpleadoMast es null");
			return null;
		}

		if (listEmpleadoMast.size() == 0) {
			LOGGER.debug("listEmpleadoMast size = 0");
			return null;
		}

		if (listEmpleadoMast.size() > 1) {
			LOGGER.debug("listEmpleadoMast size > 1");
			usuarioActual = new UsuarioActual();
			usuarioActual.setMensaje("Existe más de una persona con ese código de usuario.");
			return usuarioActual;
		}

		LOGGER.debug("buscando informacion de la persona 1");
		LOGGER.debug(listEmpleadoMast.get(0).getPk().getEmpleado());
		persona = personamastDao.obtenerPorId(new PersonamastPk(listEmpleadoMast.get(0).getPk().getEmpleado()));
		LOGGER.debug("buscando informacion de la persona 2");

		if (persona == null) {
			LOGGER.debug("persona es null");
			return null;
		}

		usuarioActual = new UsuarioActual();
		usuarioActual.setIdPersona(persona.getPk().getPersona());
		usuarioActual.setNombreCompleto(persona.getNombrecompleto());
		usuarioActual.setTipoDocumento(persona.getTipodocumento());
		usuarioActual.setNroDocumento(persona.getDocumento());
		usuarioActual.setNombres(persona.getNombres());
		usuarioActual.setApellidoPaterno(persona.getApellidopaterno());
		usuarioActual.setApellidoMaterno(persona.getApellidomaterno());
		usuarioActual.setSexo(persona.getSexo());

		usuarioActual.setCodigoUsuario(listEmpleadoMast.get(0).getCodigousuario());
		usuarioActual.setLoginUsuario(usuarioActual.getCodigoUsuario());

		// datos del empleado
		usuarioActual.setCompaniaSocioCodigo(listEmpleadoMast.get(0).getPk().getCompaniasocio());

		usuarioActual.setCentroCostosCodigo(listEmpleadoMast.get(0).getCentrocostos());
		AcCostcentermst centroCostos = this.acCostcentermstDao
				.obtenerPorId(new AcCostcentermstPk(usuarioActual.getCentroCostosCodigo()), false);
		if (centroCostos != null)
			usuarioActual.setCentroCostosNombre(centroCostos.getLocalname());

		usuarioActual.setUnidadNegocioCodigo(listEmpleadoMast.get(0).getUnidadnegocioasignada());
		MaUnidadnegocio unidadNegocio = this.maUnidadnegocioDao
				.obtenerPorId(new MaUnidadnegocioPk(usuarioActual.getUnidadNegocioCodigo()), false);
		if (unidadNegocio != null)
			usuarioActual.setUnidadNegocioNombre(unidadNegocio.getDescripcionlocal());

		usuarioActual.setSucursalCodigo(listEmpleadoMast.get(0).getSucursal());
		AcSucursal sucursal = acSucursalDao.obtenerPorId(new AcSucursalPk(usuarioActual.getSucursalCodigo()));
		if (sucursal != null)
			usuarioActual.setSucursalNombre(sucursal.getDescripcionlocal());

		usuarioActual.setIdResponsableEmpleado(listEmpleadoMast.get(0).getResponsableempleado());

		usuarioActual.setIdResponsableJefe(listEmpleadoMast.get(0).getResponsablejefe());

		Integer enteroTemporal = listEmpleadoMast.get(0).getDptoareaoperativa();
		if (enteroTemporal == null)
			usuarioActual.setAreaCodigo("");
		else
			usuarioActual.setAreaCodigo(enteroTemporal.toString());
		AsArea area = asAreaDao.obtenerPorId(new AsAreaPk(enteroTemporal));
		if (area != null)
			usuarioActual.setAreaNombre(area.getNombre());

		enteroTemporal = listEmpleadoMast.get(0).getCodigocargo();
		if (enteroTemporal == null)
			usuarioActual.setCargoCodigo("");
		else
			usuarioActual.setCargoCodigo(enteroTemporal.toString());
		HrPuestoempresa puesto = hrPuestoempresaDao.obtenerPorId(new HrPuestoempresaPk(enteroTemporal));
		if (puesto != null)
			usuarioActual.setCargoNombre(puesto.getDescripcion());

		// PREFERENCIAS
		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_EMPRESA);
		usuarioActual.setPreferenciasEmpresa(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_DATABASE);
		usuarioActual.setPreferenciasDataBase(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_UNIDAD_REPLICACION);
		usuarioActual.setUnidadReplicacionCodigo(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.APLICACION_CODIGO_APLICACION);
		usuarioActual.setAplicacionCodigo(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_ALMACEN);
		usuarioActual.setAlmacenCodigo(temporal);
		temporal = syPreferencesDao.obtenerValorString(usuarioActual.getLoginUsuario(), "ALMACEN");
		if (temporal != null)
			usuarioActual.setAlmacenCodigo(temporal);

		// PARAMETROS MAST
		usuarioActual.setTipoSeguridad(aplicacionesmastDao.obtenerTipoSeguridad());

		temporal = parametrosmastDao.obtenerValorCadena(usuarioActual.getCompaniaSocioCodigo().substring(0, 6), "SY",
				"FISCAL");
		usuarioActual.setEsFiscal(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "SY", "CLOSEDAILY");
		usuarioActual.setCierreDiario(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "SY", "SECUNEG");
		usuarioActual.setSeguridadPorUnidadNegocio(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "SY", "COMPANYPRO");
		usuarioActual.setCompaniaProtegida(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "AC", "LEDGRPDFT");
		usuarioActual.setContabilidadPorDefecto(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "AP", "IGVCODE");
		BigDecimal importePorcentajeIgv = impuestosDao.obtenerFactorPorcentaje(temporal);
		usuarioActual.setImportePorcentajeIgv(importePorcentajeIgv);

		// COMPANIAMAST : obtener el plan contable
		usuarioActual.setPlanContable(
				companiamastDao.obtenerPlanContable(usuarioActual.getCompaniaSocioCodigo().substring(0, 6)));

		// SY_EMPRESA : PIAS por defecto PER
		usuarioActual.setPaisCodigo(syEmpresaDao.obtenerPais(usuarioActual.getPreferenciasEmpresa()));

		// obtener el periodo
		usuarioActual.setPeriodoContableActual(
				aplicacionesmastDao.obtenerPeriodoContable(usuarioActual.getAplicacionCodigo()));
		LOGGER.debug("Periodo Contable v2");
		LOGGER.debug(usuarioActual.getAplicacionCodigo());
		LOGGER.debug(usuarioActual.getPeriodoContableActual());

		BigDecimal tipoCamioDelDia = null;
		tipoCamioDelDia = tipocambiomastDao.obtenerFactor(new Date(), "V");
		if (tipoCamioDelDia == null) {
			usuarioActual.setTieneTipoCambioDelDia(false);
			usuarioActual.setTipoCambioDelDia(null);
		} else {
			usuarioActual.setTieneTipoCambioDelDia(true);
			usuarioActual.setTipoCambioDelDia(tipoCamioDelDia);
		}

		usuarioActual.setUniqueIdString(this.generateUniqueIdString());
		usuarioActual.setUniqueIdInteger(this.generateUniqueIdInteger());
		usuarioActual.setTipoPlanilla(listEmpleadoMast.get(0).getTipoplanilla());

		LOGGER.debug("regresando usuarioActual");
		return usuarioActual;
	}

	private String generateUniqueIdString() {
		String unique = null;
		unique = UUID.randomUUID().toString();
		return unique;
	}

	private Integer generateUniqueIdInteger() {
		int uniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
		return uniqueId;
	}

	@Override
	public List<DtoMenu> listarMenuPorUsuarioRoyal(String codigoAplicacion, List<DtoMenu> lstMenuPortal,
			String usuario) {
		if (lstMenuPortal == null)
			lstMenuPortal = new ArrayList<DtoMenu>();
		List<DtoMenu> lstMenuRelacion = new ArrayList<DtoMenu>();
		List<Seguridadconcepto> lstConceptos = seguridadconceptoDao.listarConceptosPermitidosPorUsuario(usuario);
		for (Seguridadconcepto concepto : lstConceptos) {
			DtoMenu conc = new DtoMenu();
			String codigoCompleto = null;
			codigoCompleto = concepto.getConceptoRelacion();

			conc.setAplicacionCodigo(codigoCompleto.substring(0, 2));
			conc.setGrupo(codigoCompleto.substring(2, 8));
			conc.setConcepto(codigoCompleto.substring(8));

			conc.setObjeto(concepto.getObjeto());
			conc.setConceptoPadre(concepto.getConceptopadre());
			conc.setDescripcion(concepto.getDescripcion());
			conc.setConceptoRelacion(concepto.getConceptoRelacion());
			conc.setCodigoCompleto(codigoCompleto);
			conc.setWebpage(concepto.getWebpage());
			lstMenuRelacion.add(conc);
		}

		if (lstMenuRelacion.size() > 0) {
			DtoMenu e = new DtoMenu();
			e.setAplicacionCodigo(codigoAplicacion);
			e.setDescripcion("RELACIONADOS");
			e.setGrupo("RELACION");
			e.setHijos(lstMenuRelacion);
			lstMenuPortal.add(e);
		}

		return lstMenuPortal;
	}

//	private List<DtoMenu> listarMenuPorUsuarioRoyalHijos(List<DtoMenu> lstMenuRelacion, List<DtoMenu> lstMenuHijos) {
//		for (DtoMenu dtoMenu : lstMenuHijos) {
//			if (dtoMenu.getHijos() == null)
//				dtoMenu.setHijos(new ArrayList<DtoMenu>());
//			if (dtoMenu.getHijos().size() > 0) {
//				lstMenuRelacion = listarMenuPorUsuarioRoyalHijos(lstMenuRelacion, dtoMenu.getHijos());
//			} else {
//				if (!UValidador.estaVacio(dtoMenu.getConceptoRelacion())) {
//					lstMenuRelacion.add(dtoMenu);
//				}
//			}
//		}
//		return lstMenuRelacion;
//	}

	@Override
	public List<DtoMenu> listarMenuPorUsuario(String codigoAplicacion, String usuario) {
		List<DtoMenu> lstNodos = new ArrayList<DtoMenu>();
		Integer posPadre;
		List<Seguridadperfilusuario> listaPerfiles = seguridadperfilusuarioDao.listarPerfilActivoXUsuario(usuario);

		List<Seguridadautorizaciones> listaConceptos = seguridadautorizacionesDao
				.listarActivosXPerfilesUsuario(codigoAplicacion, usuario, listaPerfiles);

		for (Seguridadautorizaciones sa : listaConceptos) {
			Seguridadconcepto concepto = seguridadconceptoDao.obtenerPorId(new SeguridadconceptoPk(
					sa.getPk().getAplicacioncodigo(), sa.getPk().getGrupo(), sa.getPk().getConcepto()));

			DtoMenu conc = new DtoMenu();

			if (UValidador.esNulo(concepto)) {
				concepto = new Seguridadconcepto();
			}

			conc.setAplicacionCodigo(concepto.getPk().getAplicacioncodigo());
			conc.setGrupo(concepto.getPk().getGrupo());
			conc.setConcepto(concepto.getPk().getConcepto());
			conc.setObjeto(concepto.getObjeto());
			conc.setConceptoPadre(concepto.getConceptopadre());
			conc.setDescripcion(concepto.getDescripcion());
			conc.setConceptoRelacion(concepto.getConceptoRelacion());
			conc.setWebpage(concepto.getWebpage());

			posPadre = 0;
			if (lstNodos.size() == 0) {
				Seguridadgrupo gru = seguridadgrupoDao.obtenerPorId(
						new SeguridadgrupoPk(concepto.getPk().getAplicacioncodigo(), concepto.getPk().getGrupo()));
				DtoMenu pad = new DtoMenu();

				if (UValidador.esNulo(gru)) {
					gru = new Seguridadgrupo();
				}

				pad.setAplicacionCodigo(gru.getPk().getAplicacioncodigo());
				pad.setGrupo(gru.getPk().getGrupo());
				pad.setDescripcion(gru.getDescripcion());
				pad.setHijos(new ArrayList<DtoMenu>());
				lstNodos.add(pad);
			} else {
				boolean flgEncontrado = false;
				for (DtoMenu padre : lstNodos) {
					if ((UValidador.esNulo(padre.getGrupo()) ? "" : padre.getGrupo()).equals(conc.getGrupo())) {
						flgEncontrado = true;
						break;
					}
					posPadre++;
				}
				if (!flgEncontrado) {
					Seguridadgrupo gru = seguridadgrupoDao.obtenerPorId(
							new SeguridadgrupoPk(concepto.getPk().getAplicacioncodigo(), concepto.getPk().getGrupo()));

					if (UValidador.esNulo(gru)) {
						gru = new Seguridadgrupo();
					}

					DtoMenu pad = new DtoMenu();
					pad.setAplicacionCodigo(gru.getPk().getAplicacioncodigo());
					pad.setGrupo(gru.getPk().getGrupo());
					pad.setDescripcion(gru.getDescripcion());
					pad.setHijos(new ArrayList<DtoMenu>());
					lstNodos.add(pad);
				}
			}
			// LOGGER.debug(posPadre);
			// LOGGER.debug(lstNodos.size());
			lstNodos.get(posPadre).getHijos().add(conc);
		}
		return lstNodos;
	}

	/*
	 * @Override public List<DtoMenu> listarMenuPorUsuario2(String
	 * codigoAplicacion, String usuario) { List<DtoMenu> lstPadres = new
	 * ArrayList<DtoMenu>();
	 * 
	 * Criteria criteriaseguridadGrupo = seguridadgrupoDao.getCriteria();
	 * criteriaseguridadGrupo.add(Restrictions.eq("pk.aplicacioncodigo",
	 * codigoAplicacion)); List<Seguridadgrupo> grupos = seguridadgrupoDao
	 * .listarPorCriterios(criteriaseguridadGrupo); for (Seguridadgrupo grupo :
	 * grupos) { DtoMenu grp = new DtoMenu();
	 * grp.setAplicacionCodigo(grupo.getPk().getAplicacioncodigo());
	 * grp.setGrupo(grupo.getPk().getGrupo());
	 * grp.setDescripcion(grupo.getDescripcion()); lstPadres.add(grp); }
	 * 
	 * List<ParametroPersistenciaGenerico> parametros = new
	 * ArrayList<ParametroPersistenciaGenerico>(); for (DtoMenu grupo :
	 * lstPadres) { parametros.clear(); parametros.add(new
	 * ParametroPersistenciaGenerico("p_appCodigo", String.class,
	 * grupo.getAplicacionCodigo())); parametros.add(new
	 * ParametroPersistenciaGenerico("p_grupo", String.class,
	 * grupo.getGrupo())); parametros.add(new
	 * ParametroPersistenciaGenerico("p_concepto", String.class, null));
	 * listarMenuHijoPorUsuario(grupo, parametros); } return lstPadres; }
	 */

//	private List<DtoMenu> listarMenuHijoPorUsuario(DtoMenu grupo, List<ParametroPersistenciaGenerico> parametros) {
//
//		List<DtoMenu> lstHijos = new ArrayList<DtoMenu>();
//		Criteria criteriaseguridadConcepto = seguridadconceptoDao.getCriteria();
//		criteriaseguridadConcepto.add(Restrictions.eq("pk.aplicacioncodigo", parametros.get(0).getValue()));
//		criteriaseguridadConcepto.add(Restrictions.eq("pk.grupo", parametros.get(1).getValue()));
//		criteriaseguridadConcepto.add(Restrictions.eq("visibleflag", "S"));
//		if (!UValidador.estaVacio(parametros.get(2).getValue()))
//			criteriaseguridadConcepto.add(Restrictions.eq("conceptopadre", parametros.get(2).getValue()));
//		List<Seguridadconcepto> conceptos = seguridadconceptoDao.listarPorCriterios(criteriaseguridadConcepto);
//		for (Seguridadconcepto concepto : conceptos) {
//			DtoMenu conc = new DtoMenu();
//			conc.setAplicacionCodigo(concepto.getPk().getAplicacioncodigo());
//			conc.setGrupo(concepto.getPk().getGrupo());
//			conc.setConcepto(concepto.getPk().getConcepto());
//			conc.setObjeto(concepto.getObjeto());
//			conc.setConceptoPadre(concepto.getConceptopadre());
//			conc.setDescripcion(concepto.getDescripcion());
//			conc.setConceptoRelacion(concepto.getConceptoRelacion());
//			conc.setWebpage(concepto.getWebpage());
//			lstHijos.add(conc);
//		}
//
//		grupo.setHijos(new ArrayList<DtoMenu>());
//		for (DtoMenu concepto : lstHijos) {
//			if (UValidador.esNulo(concepto.getConceptoPadre())) {
//				grupo.getHijos().add(concepto);
//				parametros.clear();
//				parametros.add(
//						new ParametroPersistenciaGenerico("p_appCodigo", String.class, concepto.getAplicacionCodigo()));
//				parametros.add(new ParametroPersistenciaGenerico("p_grupo", String.class, concepto.getGrupo()));
//				parametros.add(new ParametroPersistenciaGenerico("p_concepto", String.class, concepto.getConcepto()));
//				listarMenuHijoPorUsuario(concepto, parametros);
//			} else {
//				LOGGER.debug("parametro concepto " + UValidador.esNulo(parametros.get(2).getValue()));
//				if (!UValidador.esNulo(concepto.getConcepto())) {
//					grupo.getHijos().add(concepto);
//				}
//			}
//		}
//		return null;
//	}

	@Override
	public UsuarioActual traerDatosEmpleadoDocumentoPersona(String nroDocumento) {
		LOGGER.debug("buscando informacion de los empleados por nro documento");

		UsuarioActual usuarioActual = null;
		Personamast persona = null;
		Empleadomast empleado = null;

		Criteria criteriaPersona = personamastDao.getCriteria();
		criteriaPersona.add(Restrictions.eq("documento", nroDocumento));
		List<Personamast> listPersonaMast = personamastDao.listarPorCriterios(criteriaPersona);

		if (listPersonaMast == null) {
			LOGGER.debug("listPersonaMast es null");
			return null;
		}

		if (listPersonaMast.size() == 0) {
			LOGGER.debug("listPersonaMast size = 0");
			return null;
		}

		if (listPersonaMast.size() > 1) {
			LOGGER.debug("listPersonaMast size > 1");
			return usuarioActual;
		}

		persona = listPersonaMast.get(0);

		Criteria criteriaEmpleado = personamastDao.getCriteria();
		criteriaEmpleado.add(Restrictions.eq("pk.empleado", persona.getPk().getPersona()));
		List<Empleadomast> listEmpleadoMast = empleadomastDao.listarPorCriterios(criteriaEmpleado);
		if (listEmpleadoMast == null) {
			listEmpleadoMast = new ArrayList<Empleadomast>();
		}
		if (listEmpleadoMast.size() == 1)
			empleado = listEmpleadoMast.get(0);

		usuarioActual = new UsuarioActual();
		usuarioActual.setIdPersona(persona.getPk().getPersona());
		usuarioActual.setNombreCompleto(persona.getNombrecompleto());
		usuarioActual.setTipoDocumento(persona.getTipodocumento());
		usuarioActual.setNroDocumento(persona.getDocumento());
		usuarioActual.setNombres(persona.getNombres());
		usuarioActual.setApellidoPaterno(persona.getApellidopaterno());
		usuarioActual.setApellidoMaterno(persona.getApellidomaterno());

		if (empleado != null)
			usuarioActual.setCodigoUsuario(empleado.getCodigousuario());

		return usuarioActual;
	}

	@Override
	public Boolean listarUsuarioIguales(String usuario, String nombrAccion) {
//		String nombreEditado = usuario;
		Boolean igual;

		if (nombrAccion.equals("NUEVO")) {
			igual = consultaUsuarioIguales(usuario);
			return igual;
		}

		return true;
	}

	private Boolean consultaUsuarioIguales(String usuario) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, usuario));

		Integer usuarioIguales = dao.contar("usuario.listarIguales", filtros);

		if (!UValidador.esCero(usuarioIguales)) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Usuario> listarOracleCursor(String usuario) {
//		Integer registros;
		List lstResultado;

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_usuario", String.class, usuario));

		lstResultado = dao.listarPorQuery(Usuario.class, "seguridad.usuario.listarOracleCursor", parametros);

		return lstResultado;

	}

	@Override
	public Integer contarPerfilAdministradorFicha(String usuario) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("usuario", String.class, usuario));
		return dao.contar("seguridad.usuario.contarPerfilAdministradorFicha", parametros);
	}

	@Override
	public Integer contarPerfilAdministradorEmpleados(String usuario) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("usuario", String.class, usuario));
		return dao.contar("seguridad.usuario.contarPerfilAdministradorEmpleados", parametros);
	}

	@Autowired
	@Qualifier("usuarioDaoImplSeguridad")
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setAplicacionesmastDao(AplicacionesmastDao aplicacionesmastDao) {
		this.aplicacionesmastDao = aplicacionesmastDao;
	}

	@Autowired
	public void setSeguridadconceptoDao(SeguridadconceptoDao seguridadconceptoDao) {
		this.seguridadconceptoDao = seguridadconceptoDao;
	}

	@Autowired
	public void setSeguridadgrupoDao(SeguridadgrupoDao seguridadgrupoDao) {
		this.seguridadgrupoDao = seguridadgrupoDao;
	}

	@Autowired
	public void setPersonamastDao(PersonamastDao personamastDao) {
		this.personamastDao = personamastDao;
	}

	@Autowired
	public void setEmpleadomastDao(EmpleadomastDao empleadomastDao) {
		this.empleadomastDao = empleadomastDao;
	}

	@Autowired
	public void setSyEmpresaDao(SyEmpresaDao syEmpresaDao) {
		this.syEmpresaDao = syEmpresaDao;
	}

	@Autowired
	public void setSyPreferencesDao(SyPreferencesDao syPreferencesDao) {
		this.syPreferencesDao = syPreferencesDao;
	}

	@Autowired
	public void setParametrosmastDao(ParametrosmastDao parametrosmastDao) {
		this.parametrosmastDao = parametrosmastDao;
	}

	@Autowired
	public void setCompaniamastDao(CompaniamastDao companiamastDao) {
		this.companiamastDao = companiamastDao;
	}

	@Autowired
	public void setImpuestosDao(ImpuestosDao impuestosDao) {
		this.impuestosDao = impuestosDao;
	}

	@Autowired
	public void setTipocambiomastDao(TipocambiomastDao tipocambiomastDao) {
		this.tipocambiomastDao = tipocambiomastDao;
	}

	@Override
	public List<Usuario> ListarUsuariosxPerfil(String usuarioperfil) {
		return dao.ListarUsuariosxPerfil(usuarioperfil);
	}

//	@Autowired
//	@Qualifier("companyownerDaoImplSeguridad")
//	public void setCompanyownerDao(CompanyownerDao companyownerDao) {
//		this.companyownerDao = companyownerDao;
//	}

	@Autowired
	@Qualifier("hrPuestoempresaDaoImplSeguridad")
	public void setHrPuestoempresaDao(HrPuestoempresaDao hrPuestoempresaDao) {
		this.hrPuestoempresaDao = hrPuestoempresaDao;
	}

	@Autowired
	@Qualifier("acSucursalDaoImplSeguridad")
	public void setAcSucursalDao(AcSucursalDao acSucursalDao) {
		this.acSucursalDao = acSucursalDao;
	}

	@Autowired
	@Qualifier("acCostcentermstDaoImplSeguridad")
	public void setAcCostcentermstDao(AcCostcentermstDao acCostcentermstDao) {
		this.acCostcentermstDao = acCostcentermstDao;
	}

	@Autowired
	@Qualifier("asAreaDaoImplSeguridad")
	public void setAsAreaDao(AsAreaDao asAreaDao) {
		this.asAreaDao = asAreaDao;
	}

	@Autowired
	@Qualifier("maUnidadnegocioDaoImplSeguridad")
	public void setMaUnidadnegocioDao(MaUnidadnegocioDao maUnidadnegocioDao) {
		this.maUnidadnegocioDao = maUnidadnegocioDao;
	}

	@Autowired
	@Qualifier("seguridadautorizacionesDaoImplSeguridad")
	public void setSeguridadautorizacionesDao(SeguridadautorizacionesDao seguridadautorizacionesDao) {
		this.seguridadautorizacionesDao = seguridadautorizacionesDao;
	}

	@Autowired
	@Qualifier("seguridadperfilusuarioDaoImplSeguridad")
	public void setSeguridadperfilusuarioDao(SeguridadperfilusuarioDao seguridadperfilusuarioDao) {
		this.seguridadperfilusuarioDao = seguridadperfilusuarioDao;
	}

	@Autowired
	@Qualifier("seguridadautorizacioncompaniaDaoImplSeguridad")
	public void setCompanyownerDao(SeguridadautorizacioncompaniaDao seguridadautorizacioncompaniaDao) {
		this.seguridadautorizacioncompaniaDao = seguridadautorizacioncompaniaDao;
	}

	public List<Usuario> listarCierreDiario(String usuario) {
		return dao.listarCierreDiario(usuario);
	}

	@Override
	public UsuarioActual traerDatosOtroLogin(String usuario) {
		// TODO Auto-generated method stub
		String temporal = null;
		UsuarioActual usuarioActual = null;
		Personamast persona;

		persona = personamastDao.obtenerPorUsuario(usuario);
		LOGGER.debug("buscando informacion de la persona 2");

		if (persona == null) {
			LOGGER.debug("persona es null");
			return null;
		}

		usuarioActual = new UsuarioActual();
		usuarioActual.setIdPersona(persona.getPk().getPersona());
		usuarioActual.setNombreCompleto(persona.getNombrecompleto());
		usuarioActual.setTipoDocumento(persona.getTipodocumento());
		usuarioActual.setNroDocumento(persona.getDocumento());
		usuarioActual.setNombres(persona.getNombres());
		usuarioActual.setApellidoPaterno(persona.getApellidopaterno());
		usuarioActual.setApellidoMaterno(persona.getApellidomaterno());

		usuarioActual.setCodigoUsuario(persona.getCodigousuario());
		usuarioActual.setLoginUsuario(usuarioActual.getCodigoUsuario());

		// datos del empleado
		usuarioActual
				.setCompaniaSocioCodigo(seguridadautorizacioncompaniaDao.obtenerCompania(persona.getCodigousuario()));

		if (UValidador.estaVacio(usuarioActual.getCompaniaSocioCodigo())) {
			return null;
		}
		// usuarioActual.setCentroCostosCodigo(listEmpleadoMast.get(0).getCentrocostos());
		// AcCostcentermst centroCostos = this.acCostcentermstDao
		// .obtenerPorId(new
		// AcCostcentermstPk(usuarioActual.getCentroCostosCodigo()), false);
		// if (centroCostos != null)
		// usuarioActual.setCentroCostosNombre(centroCostos.getLocalname());
		//
		// usuarioActual.setUnidadNegocioCodigo(listEmpleadoMast.get(0).getUnidadnegocioasignada());
		// MaUnidadnegocio unidadNegocio = this.maUnidadnegocioDao
		// .obtenerPorId(new
		// MaUnidadnegocioPk(usuarioActual.getUnidadNegocioCodigo()), false);
		// if (unidadNegocio != null)
		// usuarioActual.setUnidadNegocioNombre(unidadNegocio.getDescripcionlocal());
		//
		// usuarioActual.setSucursalCodigo(listEmpleadoMast.get(0).getSucursal());
		// AcSucursal sucursal = acSucursalDao.obtenerPorId(new
		// AcSucursalPk(usuarioActual.getSucursalCodigo()));
		// if (sucursal != null)
		// usuarioActual.setSucursalNombre(sucursal.getDescripcionlocal());
		//
		// usuarioActual.setIdResponsableEmpleado(listEmpleadoMast.get(0).getResponsableempleado());
		//
		// usuarioActual.setIdResponsableJefe(listEmpleadoMast.get(0).getResponsablejefe());
		//
		// Integer enteroTemporal =
		// listEmpleadoMast.get(0).getDptoareaoperativa();
		// if (enteroTemporal == null)
		// usuarioActual.setAreaCodigo("");
		// else
		// usuarioActual.setAreaCodigo(enteroTemporal.toString());
		// AsArea area = asAreaDao.obtenerPorId(new AsAreaPk(enteroTemporal));
		// if (area != null)
		// usuarioActual.setAreaNombre(area.getNombre());
		//
		// enteroTemporal = listEmpleadoMast.get(0).getCodigocargo();
		// if (enteroTemporal == null)
		// usuarioActual.setCargoCodigo("");
		// else
		// usuarioActual.setCargoCodigo(enteroTemporal.toString());
		// HrPuestoempresa puesto = hrPuestoempresaDao.obtenerPorId(new
		// HrPuestoempresaPk(enteroTemporal));
		// if (puesto != null)
		// usuarioActual.setCargoNombre(puesto.getDescripcion());

		// PREFERENCIAS
		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_EMPRESA);
		usuarioActual.setPreferenciasEmpresa(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_DATABASE);
		usuarioActual.setPreferenciasDataBase(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_UNIDAD_REPLICACION);
		usuarioActual.setUnidadReplicacionCodigo(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.APLICACION_CODIGO_APLICACION);
		usuarioActual.setAplicacionCodigo(temporal);

		temporal = UAplicacion.getServletContext().getInitParameter(ConstanteSeguridad.PREFERENCIAS_ALMACEN);
		usuarioActual.setAlmacenCodigo(temporal);
		temporal = syPreferencesDao.obtenerValorString(usuarioActual.getLoginUsuario(), "ALMACEN");
		if (temporal != null)
			usuarioActual.setAlmacenCodigo(temporal);

		// PARAMETROS MAST
		usuarioActual.setTipoSeguridad(aplicacionesmastDao.obtenerTipoSeguridad());

		temporal = parametrosmastDao.obtenerValorCadena(usuarioActual.getCompaniaSocioCodigo().substring(0, 6), "SY",
				"FISCAL");
		usuarioActual.setEsFiscal(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "SY", "CLOSEDAILY");
		usuarioActual.setCierreDiario(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "SY", "SECUNEG");
		usuarioActual.setSeguridadPorUnidadNegocio(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "SY", "COMPANYPRO");
		usuarioActual.setCompaniaProtegida(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "AC", "LEDGRPDFT");
		usuarioActual.setContabilidadPorDefecto(temporal);

		temporal = parametrosmastDao.obtenerValorCadena("999999", "AP", "IGVCODE");
		BigDecimal importePorcentajeIgv = impuestosDao.obtenerFactorPorcentaje(temporal);
		usuarioActual.setImportePorcentajeIgv(importePorcentajeIgv);

		// COMPANIAMAST : obtener el plan contable
		usuarioActual.setPlanContable(
				companiamastDao.obtenerPlanContable(usuarioActual.getCompaniaSocioCodigo().substring(0, 6)));

		// SY_EMPRESA : PIAS por defecto PER
		usuarioActual.setPaisCodigo(syEmpresaDao.obtenerPais(usuarioActual.getPreferenciasEmpresa()));

		// obtener el periodo
		usuarioActual.setPeriodoContableActual(
				aplicacionesmastDao.obtenerPeriodoContable(usuarioActual.getAplicacionCodigo()));
		LOGGER.debug("Periodo Contable v2");
		LOGGER.debug(usuarioActual.getAplicacionCodigo());
		LOGGER.debug(usuarioActual.getPeriodoContableActual());

		BigDecimal tipoCamioDelDia = null;
		tipoCamioDelDia = tipocambiomastDao.obtenerFactor(new Date(), "V");
		if (tipoCamioDelDia == null) {
			usuarioActual.setTieneTipoCambioDelDia(false);
			usuarioActual.setTipoCambioDelDia(null);
		} else {
			usuarioActual.setTieneTipoCambioDelDia(true);
			usuarioActual.setTipoCambioDelDia(tipoCamioDelDia);
		}

		usuarioActual.setUniqueIdString(this.generateUniqueIdString());
		usuarioActual.setUniqueIdInteger(this.generateUniqueIdInteger());

		LOGGER.debug("regresando usuarioActual");
		return usuarioActual;
	}

}