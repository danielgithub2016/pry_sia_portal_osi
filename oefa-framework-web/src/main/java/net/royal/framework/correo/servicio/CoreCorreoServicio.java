package net.royal.framework.correo.servicio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.internal.SessionImpl;

import com.sun.mail.util.MailSSLSocketFactory;

import net.royal.framework.correo.constante.ConstanteCorreo;
import net.royal.framework.correo.constante.ConstanteCorreo.tipo_destino;
import net.royal.framework.correo.dominio.ConfiguracionCorreo;
import net.royal.framework.correo.dominio.CorreoAdjuntoCore;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UString;
import net.royal.framework.web.core.UValidador;

public class CoreCorreoServicio implements Serializable {
	private static Log LOGGER = LogFactory.getLog(CoreCorreoServicio.class);
	private Session sessionCorreo;
	private Boolean flgMotorConfigurado;
	private String rutaRaizAdjuntos = null;
	public Exception exceptionRetorno;
	private ConfiguracionCorreo configuracionCorreo;
	private org.hibernate.Session sessionBD;
	private String separadorCorreos = ";";

	public org.hibernate.Session getSessionBD() {
		return sessionBD;
	}

	public void setSessionBD(org.hibernate.Session sessionBD) {
		this.sessionBD = sessionBD;
	}

	// estos es llamado por las clases de otros proyectos pero no se especifica
	// un
	public Boolean configurarCorreo(ConfiguracionCorreo config) throws Exception {
		Boolean flgRetorno = false;
		if (config == null)
			config = new ConfiguracionCorreo();

		if (UValidador.estaVacio(config.getCorreoTipoConfiguracion()))
			config.setCorreoTipoConfiguracion(ConstanteCorreo.CORREO_TIPO_CONFIGURACION_CLASE);

		LOGGER.debug("configurarCorreo() : " + config.getCorreoTipoConfiguracion());

		if (config.getCorreoTipoConfiguracion().equals(ConstanteCorreo.CORREO_TIPO_CONFIGURACION_BDFUNCION)) {
			config.setEmailCuenta("sia@oefa.gob.pe");
			flgRetorno = true;
		}

		if (config.getCorreoTipoConfiguracion().equals(ConstanteCorreo.CORREO_TIPO_CONFIGURACION_CLASE)) {
			Properties properties = new Properties();
			String perfilCadena;
			final String correo;
			final String clave;
			correo = config.getEmailCuenta();
			clave = config.getEmailClave();
			perfilCadena = config.getEmailPerfil();
			config.setEmailClave(clave);
			config.setEmailCuenta(correo);

			InputStream finDoc = new ByteArrayInputStream(perfilCadena.getBytes());

			properties.load(finDoc);
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.socketFactory", sf);

			sessionCorreo = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(correo, clave);
				}
			});
			config.setSessionCorreo(sessionCorreo);
			flgRetorno = true;
		}
		configuracionCorreo = config;
		return flgRetorno;
	}

	public Boolean enviarCorreo(String correoPara, String asunto, String cuerpoCorreo, byte[] archivoAdjunto)
			throws Exception {
		CorreoCore correo = new CorreoCore();
		correo.setAsunto(asunto);
		correo.setCuerpoCorreo(cuerpoCorreo.getBytes());
		correo.getListaCorreoDestino().add(new CorreoDestinoCore(correoPara));
		if (!UValidador.esNulo(archivoAdjunto)) {
			correo.getListaCorreoAdjunto().add(new CorreoAdjuntoCore(archivoAdjunto));
		}
		return this.enviarCorreo(correo);
	}

	public Boolean enviarCorreo(String correoPara, String asunto, String cuerpoCorreo) throws Exception {
		CorreoCore correo = new CorreoCore();
		correo.setAsunto(asunto);
		correo.setCuerpoCorreo(cuerpoCorreo.getBytes());
		correo.getListaCorreoDestino().add(new CorreoDestinoCore(correoPara));
		return this.enviarCorreo(correo);
	}

	public Boolean enviarCorreo(CorreoCore correo) throws Exception {
		Boolean flgRetorno = false;

		if (configuracionCorreo == null) {
			this.exceptionRetorno = new Exception("NO SE HA CONFIGURADO EL MOTOR DE REGLAS");
			return false;
		}

		if (configuracionCorreo.getCorreoTipoConfiguracion().equals(ConstanteCorreo.CORREO_TIPO_CONFIGURACION_CLASE)) {
			configuracionCorreo = enviarCorreoJava(configuracionCorreo, correo);
			this.exceptionRetorno = configuracionCorreo.getExceptionRetorno();
			return configuracionCorreo.getFlgResultadoEnvioCorreo();
		}
		if (configuracionCorreo.getCorreoTipoConfiguracion()
				.equals(ConstanteCorreo.CORREO_TIPO_CONFIGURACION_BDFUNCION)) {
			configuracionCorreo = this.enviarCorreoBdParametros(configuracionCorreo, correo);
			this.exceptionRetorno = configuracionCorreo.getExceptionRetorno();
			return configuracionCorreo.getFlgResultadoEnvioCorreo();
		}

		return flgRetorno;
	}

	private String baseDatosGenerarSessionId() throws Exception {
		Connection cnn = ((SessionImpl) sessionBD).connection();
		CallableStatement call = cnn.prepareCall("{ ? = call SGCORESYS.fn_sn_generar_session_id () }");
		call.registerOutParameter(1, Types.VARCHAR);
		call.execute();
		String sid = (String) call.getObject(1);

		baseDatosLiberar(cnn, call, null);
		return sid;
	}

	private CorreoCore prepaparaEntidadCorreo(ConfiguracionCorreo configInterno, CorreoCore correoInterno) {
		String remitente;
		if (UValidador.estaVacio(correoInterno.getRemitente())) {
			correoInterno.setRemitente(configInterno.getEmailCuenta());
		} else {
			correoInterno.setRemitente(correoInterno.getRemitente());
		}
		correoInterno.evaluarCorreos();
		return correoInterno;
	}

	private String baseDatosEnviarCorreoCuerpoHtml(ConfiguracionCorreo config, CorreoCore correo) throws Exception {
		LOGGER.debug("baseDatosEnviarCorreoCuerpoHtml");
		correo = prepaparaEntidadCorreo(this.configuracionCorreo, correo);
		Connection cnn = ((SessionImpl) sessionBD).connection();

		String sid = null;
		CallableStatement calli = cnn.prepareCall("{ ? = call SGCORESYS.fn_sn_generar_session_id () }");
		calli.registerOutParameter(1, Types.VARCHAR);
		calli.execute();
		sid = (String) calli.getObject(1);

		PreparedStatement pst = cnn.prepareStatement("INSERT INTO SGCORESYS.GTS_SN_ENVIAR_CORREO VALUES(?, ?, ?)");
		pst.setString(1, sid);
		pst.setString(2, "");
		pst.setBytes(3, correo.getCuerpoCorreo());
		pst.executeUpdate();
		LOGGER.debug("INSERTO EN GTS_SN_ENVIAR_CORREO");

		CallableStatement call = cnn.prepareCall("CALL SGCORESYS.sp_enviar_correo_htmlsplit(?,?,?,?,?,?,?)");
		call.setString(1, correo.getRemitente());

		if (esCorreoPrueba(config, correo)) {
			call.setString(2, config.getCorreoPrueba());
			call.setString(3, "");
		} else {
			call.setString(2, correo.getCorreoDestinoPara());
			call.setString(3, correo.getCorreoDestinoCopia());
		}

		call.setString(4, correo.getAsunto());
		call.setString(5, sid);
		call.setString(6, this.separadorCorreos);
		call.registerOutParameter(7, Types.VARCHAR);
		call.execute();
		String resultado = (String) call.getObject(7);

		baseDatosLiberar(cnn, call, pst);
		return resultado;
	}

	private String baseDatosEnviarCorreoCuerpoHtmlSplit(ConfiguracionCorreo config, CorreoCore correo, String sessionId)
			throws Exception {
		LOGGER.debug("baseDatosEnviarCorreoCuerpoHtmlSplit");
		correo = prepaparaEntidadCorreo(this.configuracionCorreo, correo);
		Connection cnn = ((SessionImpl) sessionBD).connection();
		CallableStatement call = cnn.prepareCall("CALL SGCORESYS.sp_enviar_correo_htmlsplit(?,?,?,?,?,?,?)");
		call.setString(1, correo.getRemitente());

		if (esCorreoPrueba(config, correo)) {
			call.setString(2, config.getCorreoPrueba());
			call.setString(3, "");
		} else {
			call.setString(2, correo.getCorreoDestinoPara());
			call.setString(3, correo.getCorreoDestinoCopia());
		}

		call.setString(4, correo.getAsunto());
		call.setString(5, sessionId);
		call.setString(6, this.separadorCorreos);
		call.registerOutParameter(7, Types.VARCHAR);
		call.execute();
		String resultado = (String) call.getObject(7);

		baseDatosLiberar(cnn, call, null);
		return resultado;
	}

	private String baseDatosEnviarCorreoAdjunto(ConfiguracionCorreo config, CorreoCore correo, String sessionId)
			throws Exception {
		LOGGER.debug("baseDatosEnviarCorreoAdjunto");
		correo = prepaparaEntidadCorreo(this.configuracionCorreo, correo);
		Connection cnn = ((SessionImpl) sessionBD).connection();
		CallableStatement call = cnn
				.prepareCall("CALL SGCORESYS.PKG_SN_ENVIAR_CORREO.sp_enviar_correo(?,?,?,?,?,?,?,?)");
		call.setString(1, sessionId);
		call.setString(2, correo.getRemitente());

		if (esCorreoPrueba(config, correo)) {
			call.setString(3, config.getCorreoPrueba());
			call.setString(4, "");
		} else {
			call.setString(3, correo.getCorreoDestinoPara());
			call.setString(4, correo.getCorreoDestinoCopia());
		}

		call.setString(5, correo.getAsunto());
		String cuerpo = new String(correo.getCuerpoCorreo(), StandardCharsets.ISO_8859_1);
		cuerpo = UString.cambiarCaracteresEspecialesHTML(cuerpo);
		call.setString(6, cuerpo);
		call.setString(7, this.separadorCorreos);
		call.registerOutParameter(8, Types.VARCHAR);
		call.execute();
		String resultado = (String) call.getObject(8);

		baseDatosLiberar(cnn, call, null);
		return resultado;
	}

	private String baseDatosAdjuntarArchivo(String sessionId, String nombreArchivo, byte[] archivoAdjunto)
			throws Exception {
		Connection cnn = ((SessionImpl) sessionBD).connection();
		CallableStatement call = cnn.prepareCall("CALL SGCORESYS.pkg_sn_enviar_correo.sp_adjuntar_archivo(?,?,?,?)");
		call.setString(1, sessionId);
		call.setString(2, nombreArchivo);
		call.setBytes(3, archivoAdjunto);
		call.registerOutParameter(4, Types.VARCHAR);
		call.execute();
		String resultado = (String) call.getObject(4);
		baseDatosLiberar(cnn, call, null);
		return resultado;
	}

	public ConfiguracionCorreo enviarCorreoBdParametros(ConfiguracionCorreo config, CorreoCore correo)
			throws Exception {
		int lon_length = 0;
		int constantepesoarchivo = 20000; // 30000 20000 5000
		LOGGER.debug("enviarCorreoBdParametros");
		String sessionId = null;
		String resultado = null;

		sessionId = this.baseDatosGenerarSessionId();

		if (config == null) {
			LOGGER.debug("==>> 1");
			config = new ConfiguracionCorreo();
			config.setFlgResultadoEnvioCorreo(false);
			config.setExceptionRetorno(new Exception("NO SE HA CONFIGURADO EL MOTOR DE REGLAS"));
			return config;
		}

		try {
			lon_length = correo.getCuerpoCorreo().length;
		} catch (Exception e) {
			LOGGER.debug("==>> 2");
			e.printStackTrace();
			lon_length = 0;
		}

		try {
			if (lon_length < constantepesoarchivo) {
				if (UValidador.esListaVacia(correo.getListaCorreoAdjunto())) {
					resultado = this.baseDatosEnviarCorreoCuerpoHtml(config, correo);
				} else {
					for (CorreoAdjuntoCore adj : correo.getListaCorreoAdjunto()) {
						this.baseDatosAdjuntarArchivo(sessionId, adj.getNombreArchivo(), adj.getArchivoAdjunto());
					}
					resultado = this.baseDatosEnviarCorreoAdjunto(config, correo, sessionId);
				}

				if (resultado == null)
					resultado = "0";
				if (resultado.substring(0, 1).equals("0")) {
					config.setFlgResultadoEnvioCorreo(false);
					config.setExceptionRetorno(new Exception(resultado));
					return config;
				} else {
					config.setFlgResultadoEnvioCorreo(true);
					return config;
				}
			} else {
				int contador = 0;
				boolean procesar = true;
				String correoTxt = null;
				int beginIndex = 0, endIndex = 50;
				String palabra;
				endIndex = constantepesoarchivo;

				correoTxt = new String(correo.getCuerpoCorreo(), "ISO-8859-1");

				while (procesar) {
					contador = contador + 1;
					if (correoTxt.length() >= constantepesoarchivo) {
						palabra = correoTxt.substring(beginIndex, endIndex);
						correoTxt = correoTxt.substring(endIndex);
					} else {
						procesar = false;
						palabra = correoTxt;
					}
					byte[] archivoAdjunto = palabra.getBytes("ISO-8859-1");
					this.baseDatosAdjuntarArchivo(sessionId, String.valueOf(contador), archivoAdjunto);
				}

				if (UValidador.esListaVacia(correo.getListaCorreoAdjunto())) {
					resultado = this.baseDatosEnviarCorreoCuerpoHtmlSplit(config, correo, sessionId);
				} else {
					for (CorreoAdjuntoCore adj : correo.getListaCorreoAdjunto()) {
						this.baseDatosAdjuntarArchivo(sessionId, adj.getNombreArchivo(), adj.getArchivoAdjunto());
					}
					resultado = this.baseDatosEnviarCorreoAdjunto(config, correo, sessionId);
				}

				if (resultado == null)
					resultado = "0";
				if (resultado.substring(0, 1).equals("0")) {
					config.setFlgResultadoEnvioCorreo(false);
					config.setExceptionRetorno(new Exception(resultado));
					return config;
				} else {
					config.setFlgResultadoEnvioCorreo(true);
					return config;
				}
			}
		} catch (Exception ex) {
			config.setFlgResultadoEnvioCorreo(false);
			config.setExceptionRetorno(ex);
		}
		return config;
	}

	public static Boolean esCorreoPrueba(ConfiguracionCorreo configInterno, CorreoCore correoInterno) {
		Boolean flgEnvioCorreoPrueba = false;

		flgEnvioCorreoPrueba = UValidador.validarFlag(configInterno.getFlgCorreoPrueba());
		if (!flgEnvioCorreoPrueba) {
			if (correoInterno.getFlgCorreoPrueba()) {
				flgEnvioCorreoPrueba = Boolean.TRUE;
			}
		}

		return flgEnvioCorreoPrueba;
	}

	public static ConfiguracionCorreo enviarCorreoJava(ConfiguracionCorreo config, CorreoCore correo) {

		if (config == null) {
			config = new ConfiguracionCorreo();
			config.setFlgResultadoEnvioCorreo(false);
			config.setExceptionRetorno(new Exception("NO SE HA CONFIGURADO EL MOTOR DE REGLAS"));
			return config;
		}

		config.setFlgResultadoEnvioCorreo(false);

		try {
			// LOGGER.debug("enviando el correo");
			Message message = new MimeMessage(config.getSessionCorreo());

			if (UValidador.estaVacio(correo.getRemitente())) {
				message.setFrom(new InternetAddress(config.getEmailFrom(), "OEFA"));
			} else {
				message.setFrom(new InternetAddress(config.getEmailFrom(), "OEFA"));
			}

			message.setSentDate(new Date());

			// LOGGER.debug("verificando que tipo de envio se realizara");
			if (esCorreoPrueba(config, correo)) {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(config.getCorreoPrueba()));
			} else {
				int contadorInternoTO = 0;
				int contadorInternoCC = 0;
				int contadorInternoBCC = 0;

				for (CorreoDestinoCore correoDestino : correo.getListaCorreoDestino()) {
					if (correoDestino.getDestino() == null)
						correoDestino.setDestino(tipo_destino.TO);

					if (correoDestino.getDestino().equals(tipo_destino.TO))
						contadorInternoTO++;
					if (correoDestino.getDestino().equals(tipo_destino.CC))
						contadorInternoCC++;
					if (correoDestino.getDestino().equals(tipo_destino.BCC))
						contadorInternoBCC++;
				}

				InternetAddress[] addressTo = new InternetAddress[contadorInternoTO];
				InternetAddress[] addressCC = new InternetAddress[contadorInternoCC];
				InternetAddress[] addressBCC = new InternetAddress[contadorInternoBCC];

				contadorInternoTO = 0;
				contadorInternoCC = 0;
				contadorInternoBCC = 0;
				for (CorreoDestinoCore correoDestino : correo.getListaCorreoDestino()) {
					if (correoDestino.getDestino() == null)
						correoDestino.setDestino(tipo_destino.TO);

					if (correoDestino.getDestino().equals(tipo_destino.TO)) {
						addressTo[contadorInternoTO] = new InternetAddress(correoDestino.getCorreoDestino());
						contadorInternoTO++;
					}
					if (correoDestino.getDestino().equals(tipo_destino.CC)) {
						addressCC[contadorInternoCC] = new InternetAddress(correoDestino.getCorreoDestino());
						contadorInternoCC++;
					}
					if (correoDestino.getDestino().equals(tipo_destino.BCC)) {
						addressBCC[contadorInternoBCC] = new InternetAddress(correoDestino.getCorreoDestino());
						contadorInternoBCC++;
					}
				}

				 message.setRecipients(Message.RecipientType.TO, addressTo);
				 message.setRecipients(Message.RecipientType.CC, addressCC);
				 message.setRecipients(Message.RecipientType.BCC, addressBCC);
			}

			// LOGGER.debug("preparando el contenido del correo");
			String cuerpoCorreo = new String(correo.getCuerpoCorreo());
			message.setSubject(correo.getAsunto());
			message.setContent(cuerpoCorreo, "text/html");
			// LOGGER.debug("cuerpoCorreo " + cuerpoCorreo);

			// LOGGER.debug("proceso de adjuntar archivos");
			String nombreCarpetaSession = UFile.archivoUnico();
			if (!UValidador.esListaVacia(correo.getListaCorreoAdjunto())) {
				message = adjuntarArchivosJava(config, correo, message, nombreCarpetaSession);
			}
			// LOGGER.debug("transporte enviando el correo");
			Transport.send(message);

			config.setFlgResultadoEnvioCorreo(true);
			config.setExceptionRetorno(null);

			try {
				UFile.carpetaBorrar(new File(config.getRutaRaizAdjuntos() + nombreCarpetaSession));
			} catch (Exception e) {
				LOGGER.error("ERROR al momento de intentar eliminar una carpeta");
			}
			return config;
		} catch (Exception ex) {
			config.setFlgResultadoEnvioCorreo(false);
			config.setExceptionRetorno(ex);
			LOGGER.error(ex.getMessage());
		}
		return config;
	}

	public static Message adjuntarArchivosJava(ConfiguracionCorreo config, CorreoCore correo, Message message,
			String nombreCarpetaSession) throws Exception {
		MimeMultipart multipart = new MimeMultipart();

		Boolean flgCarpetaCreada = false;

		if (correo.getListaCorreoAdjunto() == null)
			correo.setListaCorreoAdjunto(new ArrayList<CorreoAdjuntoCore>());

		for (CorreoAdjuntoCore correoAdjunto : correo.getListaCorreoAdjunto()) {
			String nombreArchivoTmp = null;

			// crear por primera vez la carpeta temporal
			if (!flgCarpetaCreada) {
				flgCarpetaCreada = true;
				boolean bCreado = new File(config.getRutaRaizAdjuntos() + nombreCarpetaSession).mkdir();
				if (!bCreado) {
					LOGGER.debug("carpeta de session no creada");
				}
			}

			nombreArchivoTmp = config.getRutaRaizAdjuntos() + nombreCarpetaSession + UFile.getSeparador();
			if (UValidador.estaVacio(correoAdjunto.getNombreArchivo()))
				nombreArchivoTmp = nombreArchivoTmp + UFile.archivoUnico();
			else
				nombreArchivoTmp = nombreArchivoTmp + correoAdjunto.getNombreArchivo();

			// crear el archivo en disco duro
			FileOutputStream fos = new FileOutputStream(nombreArchivoTmp);
			fos.write(correoAdjunto.getArchivoAdjunto());
			fos.close();

			// leer archivo creado y adjuntarlo al mensaje
			MimeBodyPart attachFilePart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(nombreArchivoTmp);
			attachFilePart.setDataHandler(new DataHandler(fds));
			attachFilePart.setFileName(fds.getName());
			multipart.addBodyPart(attachFilePart);

			MimeBodyPart content = new MimeBodyPart();
			content.setContent(message.getContent(), "text/html");
			multipart.addBodyPart(content);
		}
		message.setContent(multipart);
		return message;
	}

	private static CoreCorreoServicio _instance;

	public static CoreCorreoServicio getInstance() {
		if (_instance == null)
			_instance = new CoreCorreoServicio();
		return _instance;
	}

	private void baseDatosLiberar(Connection connection, CallableStatement callableStatement, PreparedStatement pst)
			throws Exception {
		if (callableStatement != null) {
			try {
				callableStatement.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}

		if (pst != null) {
			try {
				pst.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}

	}

}
