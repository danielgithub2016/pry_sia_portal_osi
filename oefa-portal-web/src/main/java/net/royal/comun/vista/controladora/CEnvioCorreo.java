package net.royal.comun.vista.controladora;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.framework.correo.constante.ConstanteCorreo.tipo_destino;
import net.royal.framework.correo.dominio.CorreoCore;
import net.royal.framework.correo.dominio.CorreoDestinoCore;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
/*import net.royal.seguridad.correo.constante.ConstanteCorreo.tipo_destino;
import net.royal.seguridad.correo.dominio.Correo;
import net.royal.seguridad.correo.dominio.CorreoDestino;*/

@SessionScoped
@ManagedBean
public class CEnvioCorreo extends CBaseBean {
	private CorreoCore correo;
	private CorreoDestinoCore destino;
	private CorreoDestinoCore seleccionado;
	private String cuerpo;

	public static CEnvioCorreo getInstance() {
		return UFaces.evaluateExpressionGet("#{cEnvioCorreo}",
				CEnvioCorreo.class);
	}

	public void iniciar() {
		correo = new CorreoCore();
		cuerpo = null;
	}

	public String nuevoDestino(int tipo) {
		destino = new CorreoDestinoCore();
		switch (tipo) {
		case 1:
			destino.setDestino(tipo_destino.TO);
			break;
		case 2:
			destino.setDestino(tipo_destino.CC);
			break;

		}

		return null;
	}

	public String agregarDestino() {
		LOGGER.debug(destino.getCorreoDestino());

		for (CorreoDestinoCore des : correo.getListaCorreoDestino()) {
			if (des.getCorreoDestino().equals(destino.getCorreoDestino())
					&& des.getDestino().equals(destino.getDestino())) {
				setMessageError("Ya se ingresó este destino");
				return null;
			}
		}

		correo.getListaCorreoDestino().add(destino);
		return null;
	}

	public String eliminarDestino() {
		for (int i = 0; i < correo.getListaCorreoDestino().size(); i++) {
			CorreoDestinoCore des = correo.getListaCorreoDestino().get(i);
			if (des.getCorreoDestino().equals(seleccionado.getCorreoDestino())
					&& des.getDestino().equals(seleccionado.getDestino())) {
				correo.getListaCorreoDestino().remove(i);
				break;
			}

		}

		return null;
	}

	public String enviarCorreo() throws Exception {

		if (UValidador.esListaVacia(correo.getListaCorreoDestino())) {
			setMessageError("Ingrese un destino");
			return null;
		}
		int destino = 0;
		for (CorreoDestinoCore des : correo.getListaCorreoDestino()) {
			if (des.getDestino().equals(tipo_destino.TO)) {
				destino++;
			}
		}

		if (destino < 1) {
			setMessageError("Ingrese un destino");
			return null;
		}

		Boolean isconfiguradocorreo = getFacSeguridad().getCorreoServicio()
				.configurarCorreo();

		if (!isconfiguradocorreo) {
			setMessageError("No se ha configurado el Perfil del Correo. Consulte al Administrador");
			return null;
		}

		cuerpo = cuerpo
				+ "<br/><br/><p style=\"text-align: right;\"><span style=\"color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 9px; background-color: rgb(255, 255, 255);\">Este correo fue enviado por el usuario: "
				+ this.getUsuarioActual().getCodigoUsuario() + "("
				+ this.getUsuarioActual().getNombreCompleto() + ")</span></p>";
		correo.setCuerpoCorreo(cuerpo.getBytes());
		getFacSeguridad().getCorreoServicio().enviarCorreo(correo);

		this.getWebControlContext().ejecutar("PF('popEnvioCorreo').hide();");

		setMessageSuccess("El correo fue enviado correctamente");

		return null;
	}

	public CorreoCore getCorreo() {
		return correo;
	}

	public void setCorreo(CorreoCore correo) {
		this.correo = correo;
	}

	public CorreoDestinoCore getDestino() {
		return destino;
	}

	public void setDestino(CorreoDestinoCore destino) {
		this.destino = destino;
	}

	public CorreoDestinoCore getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(CorreoDestinoCore seleccionado) {
		this.seleccionado = seleccionado;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

}
