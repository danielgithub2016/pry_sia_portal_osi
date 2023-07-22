package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.SeguridadautorizacionesDao;
import net.royal.seguridad.dao.SeguridadperfilusuarioDao;
import net.royal.seguridad.dominio.Seguridadautorizaciones;
import net.royal.seguridad.dominio.SeguridadautorizacionesPk;
import net.royal.seguridad.dominio.Seguridadperfilusuario;

@Repository("seguridadautorizacionesDaoImplSeguridad")
public class SeguridadautorizacionesDaoImpl extends
		GenericoDaoImpl<Seguridadautorizaciones, SeguridadautorizacionesPk>
		implements SeguridadautorizacionesDao {

	private static Log LOGGER = LogFactory
			.getLog(Seguridadautorizaciones.class);

	public SeguridadautorizacionesDaoImpl() {
		super("seguridad.seguridadautorizaciones");
	}

	private SeguridadperfilusuarioDao daoSeguridadperfilusuario;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Seguridadautorizaciones obtenerSeguridadUsuarioporConcepto(
			String usuario, String grupo, String concepto,
			String aplicacioncodigo) {
		
		LOGGER.debug("aplicacion " + aplicacioncodigo );
		LOGGER.debug("usuario " + usuario );

		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.usuario", usuario));
		cri.add(Restrictions.eq("pk.grupo", grupo));
		cri.add(Restrictions.eq("pk.concepto", concepto));
		cri.add(Restrictions.eq("pk.aplicacioncodigo", aplicacioncodigo));

		List<Seguridadautorizaciones> result = this.listarPorCriterios(cri);

		if (!UValidador.esListaVacia(result)) {
			return result.get(0);
		}

		// NUEVO
		Seguridadautorizaciones object = leerAutorizacionesPerfil(
				aplicacioncodigo, grupo, concepto, usuario);
		if (!UValidador.esNulo(object)) {
			return object;
		}
		//

		return null;
	}

	@Override
	public Integer leerAutorizaciones(String par_aplicacion, String par_grupo,
			String par_concepto, String par_user) {

		LOGGER.debug("test de sycommon.f_sql_read_user_autorizacion");

		String w_codigo = "";

		Seguridadautorizaciones datos = obtenerSeguridadUsuarioporConcepto(
				par_user.toUpperCase(), par_grupo, par_concepto, par_aplicacion);

		LOGGER.debug("par_aplicacion " + par_aplicacion);
		LOGGER.debug("par_grupo " + par_grupo);
		LOGGER.debug("par_user " + par_user);
		LOGGER.debug("par_concepto " + par_concepto);

		if (UValidador.esNulo(datos)) {
			datos = leerAutorizacionesPerfil(par_aplicacion, par_grupo,
					par_concepto, par_user);

			if (!UValidador.esNulo(datos)) {
				w_codigo = datos.getPk().getAplicacioncodigo();
			}

			if (UValidador.esNulo(w_codigo) || UValidador.estaVacio(w_codigo)) {
				return -1;
			} else {
				return 0;
			}
		}

		return 0;

	}

	@Override
	public Seguridadautorizaciones leerAutorizacionesPerfil(
			String par_aplicacion, String par_grupo, String par_concepto,
			String par_user) {

		Criteria criPerfil = daoSeguridadperfilusuario.getCriteria();
		criPerfil.add(Restrictions.eq("pk.usuario", par_user));
		List<Seguridadperfilusuario> result = daoSeguridadperfilusuario
				.listarPorCriterios(criPerfil);


		if (!UValidador.esListaVacia(result)) {

			String[] seguridadAut = new String[result.size() + 1];
			Integer contador = 0;

			for (Seguridadperfilusuario seg : result) {
				seguridadAut[contador] = seg.getPk().getPerfil();
				contador++;
			}

			Criteria cri = this.getCriteria();
			cri.add(Restrictions.in("pk.usuario", seguridadAut));
			
			
			cri.add(Restrictions.eq("pk.grupo", par_grupo));
			cri.add(Restrictions.eq("pk.concepto", par_concepto));
			cri.add(Restrictions.eq("pk.aplicacioncodigo", par_aplicacion));

			List<Seguridadautorizaciones> resultado = this
					.listarPorCriterios(cri);

			if (!UValidador.esListaVacia(resultado))
				return resultado.get(0);
		}
		return null;

	}
	
	@Override
	public List<Seguridadautorizaciones> leerAutorizacionesPerfil2(
			String par_aplicacion, String par_grupo, String par_concepto,
			String par_user) {

		Criteria criPerfil = daoSeguridadperfilusuario.getCriteria();
		criPerfil.add(Restrictions.eq("pk.usuario", par_user));
		List<Seguridadperfilusuario> result = daoSeguridadperfilusuario
				.listarPorCriterios(criPerfil);

		if (!UValidador.esListaVacia(result)) {

			String[] seguridadAut = new String[result.size() + 1];
			Integer contador = 0;

			for (Seguridadperfilusuario seg : result) {
				seguridadAut[contador] = seg.getPk().getPerfil();
				contador++;
			}

			Criteria cri = this.getCriteria();
			cri.add(Restrictions.in("pk.usuario", seguridadAut));
			cri.add(Restrictions.eq("pk.grupo", par_grupo));
			cri.add(Restrictions.eq("pk.concepto", par_concepto));
			cri.add(Restrictions.eq("pk.aplicacioncodigo", par_aplicacion));

			List<Seguridadautorizaciones> resultado = this
					.listarPorCriterios(cri);

			if (!UValidador.esListaVacia(resultado))
				return resultado;
		}
		return null;

	}

	@Autowired
	public void setDaoSeguridadperfilusuario(
			SeguridadperfilusuarioDao daoSeguridadperfilusuario) {
		this.daoSeguridadperfilusuario = daoSeguridadperfilusuario;
	}

	@Override
	public List<Seguridadautorizaciones> listarActivosXPerfilesUsuario(
			String codigoAplicacion, String usuario,
			List<Seguridadperfilusuario> listaPerfiles) {

		String[] perfiles = new String[listaPerfiles.size() + 1];
		Integer contador = 0;

		for (Seguridadperfilusuario perfil : listaPerfiles) {
			perfiles[contador] = perfil.getPk().getPerfil();
			contador++;
		}
		perfiles[contador] = usuario;
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.aplicacioncodigo", codigoAplicacion));
		cri.add(Restrictions.eq("estado", "A"));
		cri.add(Restrictions.in("pk.usuario", perfiles));

		cri.addOrder(Order.asc("pk.aplicacioncodigo"));
		cri.addOrder(Order.asc("pk.grupo"));
		cri.addOrder(Order.asc("pk.concepto"));

		return cri.list();
	}

}
