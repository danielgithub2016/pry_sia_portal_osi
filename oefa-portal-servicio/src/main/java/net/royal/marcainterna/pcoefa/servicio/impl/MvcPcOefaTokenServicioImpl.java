package net.royal.marcainterna.pcoefa.servicio.impl;

import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.marcainterna.pcoefa.dao.MvcPcOefaTokenDao;
import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;
import net.royal.marcainterna.pcoefa.servicio.MvcPcOefaTokenServicio;

@Service(value = "BeanServicioMapPcOefaToken")
public class MvcPcOefaTokenServicioImpl extends GenericoServicioImpl implements MvcPcOefaTokenServicio {

	private MvcPcOefaTokenDao dao;

	private static Log LOGGER = LogFactory.getLog(MvcPcOefaTokenServicioImpl.class);

	@Autowired
	public void setDao(MvcPcOefaTokenDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public MvcPcOefaToken obtenerPorEstado(String estado) {
		// TODO Auto-generated method stub

		MvcPcOefaToken mvcPcOefaToken = dao.obtenerPorEstado(estado);

		return mvcPcOefaToken;
	}

	@Override
	public MvcPcOefaToken obtenerPorToken(String token) {
		// TODO Auto-generated method stub

		MvcPcOefaToken mvcPcOefaToken = dao.obtenerPorToken(token);

		return mvcPcOefaToken;
	}

	@Override
	@Transactional
	public MvcPcOefaToken generarToken(MvcPcOefaToken mvcPcOefaToken) {
		// TODO Auto-generated method stub
		MvcPcOefaToken mvcPcOefaTokenIns = new MvcPcOefaToken();
		mvcPcOefaTokenIns.setTx_pc(mvcPcOefaToken.getTx_pc());
		mvcPcOefaTokenIns.setTx_token(UUID.randomUUID().toString());
		mvcPcOefaTokenIns.setTx_estado("C");
		mvcPcOefaTokenIns.setActivo("1");
		mvcPcOefaTokenIns.setFe_fecha_hora_token(new Date());
		mvcPcOefaTokenIns.setTx_codigo_usuario_creacion(mvcPcOefaToken.getTx_codigo_usuario_creacion());
		mvcPcOefaTokenIns.setFe_fecha_creacion(new Date());
		dao.registrar(mvcPcOefaTokenIns);
		return mvcPcOefaTokenIns;
	}

}
