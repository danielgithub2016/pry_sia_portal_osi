package net.royal.rrhh.vista.controladora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.royal.asistencia.vista.paginacion.PHrPostulantes;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.dto.DtoHrPostulantes;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.seguridad.SeguridadHelper;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dominio.Parametrosmast;
import net.royal.seguridad.dominio.ParametrosmastPk;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CHrAdmPostulantes extends CBaseBean implements UIMantenimientoController {

	private LazyDataModel<DtoHrPostulantes> lstPostulantes;
	private DtoHrPostulantes filtro;
	private DtoHrPostulantes dtoHrPostulantes;
	private String linkAdmPostulante;
	private String tipoconvocatoria;

	public static CHrAdmPostulantes getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrAdmPostulantes}", CHrAdmPostulantes.class);
	}

	public CHrAdmPostulantes() {
		this.PANTALLA_LISTADO = "postulantesAdm";
		this.PANTALLA_MANTENIMIENTO = "";
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.inicializarFiltrosListado();
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<>();
		parametros.add(new ParametroPersistenciaGenerico("p_documento", String.class,
				UValidador.estaVacio(filtro.getDocumento()) ? "" : filtro.getDocumento()));
		parametros.add(new ParametroPersistenciaGenerico("p_nombre", String.class,
				UValidador.estaVacio(filtro.getNombrecompleto()) ? "" : filtro.getNombrecompleto()));
		lstPostulantes = new PHrPostulantes(parametros);

		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		String SECRET_KEY = SeguridadHelper.encriptar(ConstanteSeguridad.TOKEN_KEY);
		byte signingKey[] = SECRET_KEY.getBytes();

		// 1. Id de persona SIA
		String idUsuario = getUsuarioActual().getIdPersona().toString();
		// 2. Código del usuario SIA
		String usuarioLogin = getUsuarioActual().getCodigoUsuario();

		String accion = accion_solicitada.NUEVO.toString();

		String token = Jwts.builder().setSubject(usuarioLogin).claim("idusuario", idUsuario)
				.claim("usuariologin", usuarioLogin).claim("postulante", "").claim("unidadreplicacion", "")
				.claim("accion", accion).signWith(SignatureAlgorithm.HS512, signingKey)
				.setIssuedAt(new Date(System.currentTimeMillis())).setIssuer("https://www.oefa.gob.pe")
				.setExpiration(new Date(System.currentTimeMillis() + ConstanteSeguridad.TOKEN_EXPIRATION_TIME))
				.compact();

		System.out.println(token);

		Parametrosmast p;
		ParametrosmastPk pk = new ParametrosmastPk();
		pk.setAplicacioncodigo(ConstanteSeguridad.CODIGO_APP_HR);
		pk.setCompaniacodigo(ConstanteSeguridad.COMPANIA_CODIGO_DEFAULT);
		pk.setParametroclave(ConstanteSeguridad.PARAMETRO_CLAVE_URL_POSTULANTE_ADM);

		p = (Parametrosmast) this.getFacSeguridad().getParametrosmastServicio().obtenerPorId(pk);

		if (p == null)
			p = new Parametrosmast();

		linkAdmPostulante = p.getExplicacion();

		linkAdmPostulante = linkAdmPostulante + "?message=" + token;

		getWebControlContext().ejecutar("window.open('" + linkAdmPostulante + "','_blank');");

		// ExternalContext ec =
		// FacesContext.getCurrentInstance().getExternalContext();
		// ec.redirect(linkAdmPostulante);

		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		String SECRET_KEY = SeguridadHelper.encriptar(ConstanteSeguridad.TOKEN_KEY);
		byte signingKey[] = SECRET_KEY.getBytes();

		// 1. Id de persona SIA
		String idUsuario = getUsuarioActual().getIdPersona().toString();
		// 2. Código del usuario SIA
		String usuarioLogin = getUsuarioActual().getCodigoUsuario();

		String postulante = dtoHrPostulantes.getPostulante();

		String unidadreplicacion = dtoHrPostulantes.getUnidadreplicacion();

		String tipopostulante = tipoconvocatoria;

		String accion = accion_solicitada.ACTUALIZAR.toString();

		String token = Jwts.builder().setSubject(usuarioLogin).claim("idusuario", idUsuario)
				.claim("usuariologin", usuarioLogin).claim("postulante", postulante)
				.claim("unidadreplicacion", unidadreplicacion).claim("tipopostulante", tipopostulante)
				.claim("accion", accion).signWith(SignatureAlgorithm.HS512, signingKey)
				.setIssuedAt(new Date(System.currentTimeMillis())).setIssuer("https://www.oefa.gob.pe")
				.setExpiration(new Date(System.currentTimeMillis() + ConstanteSeguridad.TOKEN_EXPIRATION_TIME))
				.compact();

		System.out.println(token);

		Parametrosmast p;
		ParametrosmastPk pk = new ParametrosmastPk();
		pk.setAplicacioncodigo(ConstanteSeguridad.CODIGO_APP_HR);
		pk.setCompaniacodigo(ConstanteSeguridad.COMPANIA_CODIGO_DEFAULT);
		pk.setParametroclave(ConstanteSeguridad.PARAMETRO_CLAVE_URL_POSTULANTE_ADM);

		p = (Parametrosmast) this.getFacSeguridad().getParametrosmastServicio().obtenerPorId(pk);

		if (p == null)
			p = new Parametrosmast();

		linkAdmPostulante = p.getExplicacion();

		linkAdmPostulante = linkAdmPostulante + "?message=" + token;

		// ExternalContext ec =
		// FacesContext.getCurrentInstance().getExternalContext();
		// ec.redirect(linkAdmPostulante);
		getWebControlContext().ejecutar("window.open('" + linkAdmPostulante + "','_blank');");

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

		return true;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		filtro = new DtoHrPostulantes();
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String mostrarTipoConvocatoria() {
		getWebControlContext().ejecutar("PF('popTipoConvocatoria').show()");
		getWebControlContext().actualizar("dgTipoConvocatoria");
		return null;
	}

	public LazyDataModel<DtoHrPostulantes> getLstPostulantes() {
		return lstPostulantes;
	}

	public void setLstPostulantes(LazyDataModel<DtoHrPostulantes> lstPostulantes) {
		this.lstPostulantes = lstPostulantes;
	}

	public DtoHrPostulantes getFiltro() {
		return filtro;
	}

	public void setFiltro(DtoHrPostulantes filtro) {
		this.filtro = filtro;
	}

	public String getLinkAdmPostulante() {
		return linkAdmPostulante;
	}

	public void setLinkAdmPostulante(String linkAdmPostulante) {
		this.linkAdmPostulante = linkAdmPostulante;
	}

	public DtoHrPostulantes getDtoHrPostulantes() {
		return dtoHrPostulantes;
	}

	public void setDtoHrPostulantes(DtoHrPostulantes dtoHrPostulantes) {
		this.dtoHrPostulantes = dtoHrPostulantes;
	}

	public String getTipoconvocatoria() {
		return tipoconvocatoria;
	}

	public void setTipoconvocatoria(String tipoconvocatoria) {
		this.tipoconvocatoria = tipoconvocatoria;
	}

}
