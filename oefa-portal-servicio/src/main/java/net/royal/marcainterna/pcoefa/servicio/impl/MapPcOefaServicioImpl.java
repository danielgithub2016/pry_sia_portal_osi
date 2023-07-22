package net.royal.marcainterna.pcoefa.servicio.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.marcainterna.pcoefa.dao.MapPcOefaDao;
import net.royal.marcainterna.pcoefa.dao.MvcPcOefaTokenDao;
import net.royal.marcainterna.pcoefa.dominio.MapPcOefa;
import net.royal.marcainterna.pcoefa.servicio.MapPcOefaServicio;

@Service(value = "BeanServicioMapPcOefa")
public class MapPcOefaServicioImpl extends GenericoServicioImpl implements MapPcOefaServicio {

	private MapPcOefaDao dao;

	private MvcPcOefaTokenDao daoToken;

	private EmpleadomastDao daoEmpleado;

	private static Log LOGGER = LogFactory.getLog(MapPcOefaServicioImpl.class);

	@Autowired
	public void setDao(MapPcOefaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setEmpleadomastDao(EmpleadomastDao daoEmpleado) {
		this.daoEmpleado = daoEmpleado;
	}

	@Autowired
	public void setMvcPcOefaTokenDao(MvcPcOefaTokenDao daoToken) {
		this.daoToken = daoToken;
	}

	@Override
	public Boolean existePcOefa(String nombre) {
		// TODO Auto-generated method stub
		Boolean retorno = false;

		MapPcOefa obj = new MapPcOefa();
		obj.setTx_nombre(nombre);

		List<MapPcOefa> datos = dao.listarPorCriterios(obj);

		if (!UValidador.esListaVacia(datos)) {
			retorno = true;
		}

		return retorno;
	}

	@Override
	public Boolean existePcFisicamenteOefa(String nombre) {
		// TODO Auto-generated method stub
		Boolean retorno = false;

		MapPcOefa obj = new MapPcOefa();
		obj.setTx_nombre(nombre);
		obj.setFlg_prestamo("0");

		List<MapPcOefa> datos = dao.listarPorCriterios(obj);

		if (!UValidador.esListaVacia(datos)) {
			retorno = true;
		}

		return retorno;
	}

//	@Override
//	public ValidaPcOefaDto generarTokenMarcaPcOefa(ValidaPcOefaDto dtoPcOefaDto) throws ValidateException {
//		// TODO Auto-generated method stub
//		ValidaPcOefaDto retorno = new ValidaPcOefaDto();
//
//		// validar nombre de PC
//		if (!this.existePcOefa(dtoPcOefaDto.getNombrePcOfea())) {
//			throw new ValidateException("La pc no corresponde a un equipo de OEFA");
//		}
//
//		// Validar usuario de red
//		if (daoEmpleado.obtenerPorCodigoUsuario(dtoPcOefaDto.getUsuarioPcOefa()) == null) {
//			throw new ValidateException("el usuario de la pc no es un usuario de OEFA");
//		}
//
//		boolean blgenerar = false;
//		// si el usuario ya tiene un token devolvemos ese valor
//		MvcPcOefaToken mvcPcOefaTokenCon = daoToken.obtenerPorUsuario(dtoPcOefaDto.getUsuarioPcOefa());
//
//		// generar token
//		String token = "";
//		if (!UValidador.esNulo(mvcPcOefaTokenCon)) {
//			// validamos la caducidad del token
//			int minutos;
//			try {
//				minutos = UFechaHora.obtenerDiferenciaMinutos(mvcPcOefaTokenCon.getFe_fecha_hora_token(), new Date());
//				if (minutos <= 30) {
//					token = mvcPcOefaTokenCon.getTx_token();
//				} else {
//					token = UUID.randomUUID().toString();
//					blgenerar = true;
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				throw new ValidateException("ocurrió un error al validar caducidad del token");
//			}
//
//		} else {
//			token = UUID.randomUUID().toString();
//			blgenerar = true;
//		}
//
//		// grabar token
//		if (blgenerar) {
//			MvcPcOefaToken mvcPcOefaToken = new MvcPcOefaToken();
//			mvcPcOefaToken.setTx_token(token);
//			mvcPcOefaToken.setTx_usuario_red(dtoPcOefaDto.getUsuarioPcOefa());
//			mvcPcOefaToken.setFe_fecha_hora_token(new Date());
//			mvcPcOefaToken.setTx_codigo_usuario_creacion(dtoPcOefaDto.getUsuarioPcOefa());
//			mvcPcOefaToken.setFe_fecha_creacion(new Date());
//			mvcPcOefaToken.setActivo("1");
//
//			daoToken.registrar(mvcPcOefaToken);
//		}
//
//		retorno.setToken(token);
//
//		return retorno;
//	}

}
