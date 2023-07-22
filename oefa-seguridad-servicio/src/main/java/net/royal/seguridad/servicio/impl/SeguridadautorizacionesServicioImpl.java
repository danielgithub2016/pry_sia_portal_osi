package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.SeguridadOperaciones;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.SeguridadautorizacionesDao;
import net.royal.seguridad.dao.SeguridadperfilusuarioDao;
import net.royal.seguridad.dominio.Seguridadautorizaciones;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.servicio.SeguridadautorizacionesServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSeguridadautorizacionesSeguridad")
public class SeguridadautorizacionesServicioImpl extends GenericoServicioImpl
		implements SeguridadautorizacionesServicio {

	private SeguridadautorizacionesDao dao;
	private SeguridadperfilusuarioDao daoPerfilUsuario;

	@Autowired
	public void setDaoPerfilUsuario(SeguridadperfilusuarioDao daoPerfilUsuario) {
		this.daoPerfilUsuario = daoPerfilUsuario;
	}

	private static Log LOGGER = LogFactory.getLog(SeguridadautorizacionesServicioImpl.class);

	@Autowired
	@Qualifier("seguridadautorizacionesDaoImplSeguridad")
	public void setDao(SeguridadautorizacionesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Seguridadautorizaciones obtenerSeguridadUsuarioporConcepto(String usuario, String grupo, String concepto,
			String aplicacioncodigo) {

		return dao.obtenerSeguridadUsuarioporConcepto(usuario, grupo, concepto, aplicacioncodigo);
	}

	/**
	 * valida primero SYSADM, si es admin devuelve TRUE, si es falso pasa a la
	 * siguiente evaluacion en segundo lugar SECADM, si es TRUE sale, si es
	 * falso pasa a el siguiente evaluacion valida por el componente
	 * 
	 * @param aplicacioncodigo
	 * @param grupo
	 * @param concepto
	 * @param usuario
	 * @return
	 */
	@Override
	public Boolean tieneAcceso(String aplicacioncodigo, String grupo, String concepto, String usuario) {

		// Todo por perfil
		List<Seguridadperfilusuario> perfiles = daoPerfilUsuario.listarPerfilActivoXUsuario(usuario);

		LOGGER.debug(perfiles.toArray());

		for (Seguridadperfilusuario per : perfiles) {
			Seguridadautorizaciones autoSysAdm = dao.obtenerSeguridadUsuarioporConcepto(per.getPk().getPerfil(),
					"SYSTEM", "SYSADM", aplicacioncodigo);
			Seguridadautorizaciones autoSecAdm = dao.obtenerSeguridadUsuarioporConcepto(per.getPk().getPerfil(),
					"SYSTEM", "SECADM", aplicacioncodigo);
			Seguridadautorizaciones autoConcepto = dao.obtenerSeguridadUsuarioporConcepto(per.getPk().getPerfil(),
					grupo, concepto, aplicacioncodigo);

			if (autoSysAdm != null) {
				if (UValidador.obtenerValorActivo(autoSysAdm.getEstado()))
					return true;
			}
			if (autoSecAdm != null) {
				if (UValidador.obtenerValorActivo(autoSecAdm.getEstado()))
					return true;
			}
			if (autoConcepto != null)
				if (UValidador.obtenerValorActivo(autoConcepto.getEstado()))
					return true;
		}

		return false;
	}

	@Override
	public Boolean tieneAccesoSysAdm(String aplicacioncodigo, String usuario) {
		Seguridadautorizaciones autoSysAdm = dao.obtenerSeguridadUsuarioporConcepto(usuario, "SYSTEM", "SYSADM",
				aplicacioncodigo);
		if (autoSysAdm != null) {
			if (UValidador.obtenerValorActivo(autoSysAdm.getEstado()))
				return true;
		}
		return false;
	}

	@Override
	public Boolean tieneAccesoSecAdm(String aplicacioncodigo, String usuario) {
		Seguridadautorizaciones autoSecAdm = dao.obtenerSeguridadUsuarioporConcepto(usuario, "SYSTEM", "SECADM",
				aplicacioncodigo);
		if (autoSecAdm != null) {
			if (UValidador.obtenerValorActivo(autoSecAdm.getEstado()))
				return true;
		}
		return false;
	}

	@Override
	public Integer leerAutorizaciones(String par_aplicacion, String par_grupo, String par_concepto, String par_user) {
		return dao.leerAutorizaciones(par_aplicacion, par_grupo, par_concepto, par_user);
	}

	@Override
	public SeguridadOperaciones leerOpciones(String aplicacion, String grupo, String concepto, String usuario) {
		// TODO Auto-generated method stub
		SeguridadOperaciones permisos = new SeguridadOperaciones();
		permisos.setIspuedeagregar(true);
		permisos.setIspuedemodificar(true);
		permisos.setIspuedeeliminar(true);

		Seguridadautorizaciones seguruser = new Seguridadautorizaciones();
		seguruser.getPk().setAplicacioncodigo(aplicacion);
		seguruser.getPk().setGrupo(grupo);
		seguruser.getPk().setConcepto(concepto);
		seguruser.getPk().setUsuario(usuario);

		// validamos por usuario
		seguruser = (Seguridadautorizaciones) obtenerPorId(seguruser.getPk());
		if (UValidador.esNulo(seguruser)) {
			seguruser = new Seguridadautorizaciones();
		}

		// validamos por perfil

		Seguridadautorizaciones segurpef = new Seguridadautorizaciones();
		List<Seguridadautorizaciones> segurpeflst = dao.leerAutorizacionesPerfil2(aplicacion, grupo, concepto, usuario);
		if (!UValidador.esListaVacia(segurpeflst)) {
			// de todos los perfiles armamos un objeto con los permisos
			for (Seguridadautorizaciones obj : segurpeflst) {
				if ("S".equals(obj.getOpcionagregarflag())) {
					segurpef.setOpcionagregarflag("S");
				}
				if ("S".equals(obj.getOpcionmodificarflag())) {
					segurpef.setOpcionmodificarflag("S");
				}
				if ("S".equals(obj.getOpcionborrarflag())) {
					segurpef.setOpcionborrarflag("S");
				}
			}
		}

		permisos.setIspuedeagregar(UValidador.obtenerValorDisjuntivo(
				new ArrayList<Boolean>(Arrays.asList(UValidador.obtenerValorLogico(seguruser.getOpcionagregarflag()),
						UValidador.obtenerValorLogico(segurpef.getOpcionagregarflag())))));

		permisos.setIspuedemodificar(UValidador.obtenerValorDisjuntivo(
				new ArrayList<Boolean>(Arrays.asList(UValidador.obtenerValorLogico(seguruser.getOpcionmodificarflag()),
						UValidador.obtenerValorLogico(segurpef.getOpcionmodificarflag())))));

		permisos.setIspuedeeliminar(UValidador.obtenerValorDisjuntivo(
				new ArrayList<Boolean>(Arrays.asList(UValidador.obtenerValorLogico(seguruser.getOpcionborrarflag()),
						UValidador.obtenerValorLogico(segurpef.getOpcionborrarflag())))));

		return permisos;
	}

}
