package net.royal.seguridad.correo.servicio;

import java.util.List;

import net.royal.framework.correo.constante.ConstanteCorreo;
import net.royal.framework.correo.dominio.ConfiguracionCorreo;
import net.royal.framework.correo.servicio.CoreCorreoServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.seguridad.dao.UsuarioDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioCorreoSeguridad")
public class CorreoServicio extends CoreCorreoServicio {
	public static String SPRING_NOMBRE = "BeanServicioCorreoSeguridad";
	private static Log LOGGER = LogFactory.getLog(CorreoServicio.class);
	private UsuarioDao dao;
	
	public Boolean configurarCorreo() throws Exception {
		ConfiguracionCorreo configInterna = new ConfiguracionCorreo();
		String correoTipoConfiguracion=null;
		
		String emailCuenta=null;
		String emailClave=null;
		String emailFrom=null;
		String emailPerfil=null;
		String emailFlgPrueba = null;
		String emailCorreoPrueba = null;
		try {
			StringBuilder sentenciaSQL=new StringBuilder();
			sentenciaSQL.append("SELECT CORREO_TIPO_CONFIGURACION, EMAIL_CUENTA, EMAIL_CLAVE, EMAIL_PERFIL, EMAIL_FROM, FLG_CORREO_PRUEBA, CORREO_PRUEBA  FROM SGALERTASSYS.CONFIGURACION_SERVICIO");
			List lista = dao.ejecutarListaSQL(sentenciaSQL);
			if (lista!= null){
				if (lista.size()==2){
					List registro = (List) lista.get(1);  
					if (registro!=null){
						List columna = (List) registro.get(0);
						correoTipoConfiguracion = (String) columna.get(0); 
						emailCuenta = (String) columna.get(1);
						emailClave = (String) columna.get(2);
						emailPerfil = (String) columna.get(3);
						emailFrom = (String) columna.get(4);
						emailFlgPrueba =  (String) columna.get(5);
						emailCorreoPrueba = (String) columna.get(6);
						
					}
				}
			}
			
			if ( UValidador.estaVacio(correoTipoConfiguracion)){
				correoTipoConfiguracion = ConstanteCorreo.CORREO_TIPO_CONFIGURACION_CLASE;
			}
			LOGGER.debug("CONFIGURACION DEL TIPO DE ENVIO DE CORREO COMPONENTE SEGURIDAD");
			LOGGER.debug(correoTipoConfiguracion);
			configInterna.setCorreoTipoConfiguracion(correoTipoConfiguracion);
			configInterna.setEmailCuenta(emailCuenta);
			configInterna.setEmailClave(emailClave);
			configInterna.setEmailPerfil(emailPerfil);
			configInterna.setEmailFrom(emailFrom);
			configInterna.setFlgCorreoPrueba(emailFlgPrueba);
			configInterna.setCorreoPrueba(emailCorreoPrueba);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.setSessionBD(this.dao.getSesionActual());
		return configurarCorreo(configInterna) ;
	}
	
	@Autowired
	@Qualifier("usuarioDaoImplSeguridad")
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
}
