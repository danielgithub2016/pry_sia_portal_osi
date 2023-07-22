package net.royal.seguridad.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.SeguridadperfilusuarioDao;
import net.royal.seguridad.dao.UsuarioDao;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.dominio.SeguridadperfilusuarioPk;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("seguridadperfilusuarioDaoImplSeguridad")
public class SeguridadperfilusuarioDaoImpl extends
		GenericoDaoImpl<Seguridadperfilusuario, SeguridadperfilusuarioPk>
		implements SeguridadperfilusuarioDao {

	private static Log LOGGER = LogFactory.getLog(Seguridadperfilusuario.class);
	private UsuarioDao daoUsuario;

	public SeguridadperfilusuarioDaoImpl() {
		super("seguridad.seguridadperfilusuario");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Usuario obtenerUsuarioPorPerfil(String userid) {
		List<String> perfiles = new ArrayList<String>();

		List<Seguridadperfilusuario> spu = this.listarPorCriterios(this
				.getCriteria().add(Restrictions.eq("pk.usuario", userid)));

		UsuarioPk pkUsuario = new UsuarioPk();
		pkUsuario.setUsuario(userid);
		Usuario u = daoUsuario.obtenerPorId(pkUsuario);

		if (!UValidador.esListaVacia(spu) && !UValidador.esNulo(u)) {
			if (spu.get(0).getPk().getUsuario().equals(u.getPk().getUsuario())) {
				List<Usuario> uPer = daoUsuario.listarPorCriterios(daoUsuario
						.getCriteria().add(
								Restrictions.eq("usuarioperfil", u.getPk()
										.getUsuario())));
				if(!UValidador.esListaVacia(uPer))
					return uPer.get(0);
			}
		}

		return new Usuario();
	}

	@Autowired
	public void setDaoUsuario(UsuarioDao daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@Override
	public List<Seguridadperfilusuario> listarPerfilActivoXUsuario(
			String usuario) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.usuario",usuario));
		cri.add(Restrictions.eq("estado","A"));
		cri.addOrder(Order.asc("pk.perfil"));
		
		return cri.list();
	}

}
