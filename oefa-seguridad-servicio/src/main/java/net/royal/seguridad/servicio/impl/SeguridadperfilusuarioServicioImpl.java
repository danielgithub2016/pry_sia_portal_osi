package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.SeguridadperfilusuarioDao;
import net.royal.seguridad.dao.UsuarioDao;
import net.royal.seguridad.dominio.Seguridadperfilusuario;
import net.royal.seguridad.dominio.Usuario;
import net.royal.seguridad.dominio.UsuarioPk;
import net.royal.seguridad.servicio.SeguridadperfilusuarioServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSeguridadperfilusuarioSeguridad")
public class SeguridadperfilusuarioServicioImpl extends GenericoServicioImpl
		implements SeguridadperfilusuarioServicio {

	private SeguridadperfilusuarioDao dao;
	private UsuarioDao daoUsuario;
	
	@Autowired
	public void setDaoUsuario(UsuarioDao daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	private static Log LOGGER = LogFactory
			.getLog(SeguridadperfilusuarioServicioImpl.class);

	@Autowired
	@Qualifier("seguridadperfilusuarioDaoImplSeguridad")
	public void setDao(SeguridadperfilusuarioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Usuario obtenerUsuarioPorPerfil(String userid) {
		return dao.obtenerUsuarioPorPerfil(userid);
	}

	@Override
	public List<Seguridadperfilusuario> listarPerfilActivoXUsuario(
			String usuario) {
		return dao.listarPerfilActivoXUsuario(usuario);
	}

	@Override
	public List<Usuario> fSqlGetUsuarioxPerfil(String userid) {

		List<Usuario> perfiles=  new ArrayList<Usuario>();
		List<Seguridadperfilusuario> spu = dao.listarPorCriterios(dao
				.getCriteria().add(Restrictions.eq("pk.usuario", userid)));
        
        for(Seguridadperfilusuario obj:spu){
        	UsuarioPk pkUsuario = new UsuarioPk();
    		pkUsuario.setUsuario(obj.getPk().getPerfil());
    		Usuario u = daoUsuario.obtenerPorId(pkUsuario);
    		
    		perfiles.add(u);
        }
		return perfiles;
	}

}
