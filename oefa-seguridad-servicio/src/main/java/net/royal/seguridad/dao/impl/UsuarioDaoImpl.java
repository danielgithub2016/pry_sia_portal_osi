package net.royal.seguridad.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.UsuarioDao;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("usuarioDaoImplSeguridad")
public class UsuarioDaoImpl extends GenericoDaoImpl<Usuario, UsuarioPk>
		implements UsuarioDao {

	private static Log LOGGER = LogFactory.getLog(Usuario.class);

	public UsuarioDaoImpl() {
		super("seguridad.usuario");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Usuario> ListarUsuariosxPerfil(String usuarioperfil) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("usuarioperfil", usuarioperfil));

		List result = this.listarPorCriterios(cri);

		return result;

	}

	@Override
	public List<Usuario> listarCierreDiario(String usuario) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.usuario", usuario.toLowerCase()).ignoreCase());
		List datos = this.listarPorCriterios(cri);
		if(UValidador.esListaVacia(datos)){
			return null;
		}
		return datos;
	}

}
