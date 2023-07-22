package net.royal.seguridad.vista.controladora;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import net.royal.framework.web.controladora.UBaseComunGlobal;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UValidador;
import net.royal.seguridad.constante.ConstanteSeguridad;
import net.royal.seguridad.dominio.Aplicacionesmast;
import net.royal.seguridad.dominio.AplicacionesmastPk;
import net.royal.seguridad.dominio.Parametrosmast;
import net.royal.seguridad.dominio.ParametrosmastPk;
import net.royal.seguridad.factory.FactoryErpSeguridad;

import org.apache.log4j.Logger;

public class UComunGlobal extends UBaseComunGlobal {

	protected static Logger LOGGER = Logger.getLogger(UComunGlobal.class);

	@PostConstruct
	public void init() {
		// capturando el codigo y nombre de la aplicacion
		String codigoAplicacion, nombreAplicacion1, nombreAplicacion2;
		codigoAplicacion = UAplicacion.getServletContext().getInitParameter(
				ConstanteSeguridad.APLICACION_CODIGO_APLICACION);

		this.setCodigoAplicacion(codigoAplicacion);
		Aplicacionesmast bean;
		AplicacionesmastPk pk = new AplicacionesmastPk();
		pk.setAplicacioncodigo(this.getCodigoAplicacion());
		try {
			bean = (Aplicacionesmast) this.facSeguridad
					.getAplicacionesmastServicio().obtenerPorId(pk);

			if (bean != null) {
				if (bean.getDescripcionlarga() != null)
					this.setNombreAplicacion(bean.getDescripcionlarga());
			}

			leerConfiguraciones();
			
			obtenerParametrosVista();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

	private void leerConfiguraciones() {
		String verLista;
		try {
			verLista = null;
			verLista = UAplicacion.getServletContext().getInitParameter(
					"APLICACION.VER_LISTA_COMPANIAS");
			if (verLista == null)
				verLista = "N";
			this.setVerListaCompanias(false);
			if (verLista.equals("S"))
				this.setVerListaCompanias(true);

			verLista = null;
			verLista = UAplicacion.getServletContext().getInitParameter(
					"APLICACION.VER_LISTA_CLIENTES");
			if (verLista == null)
				verLista = "N";
			this.setVerListaCliente(false);
			if (verLista.equals("S"))
				this.setVerListaCliente(true);

			verLista = null;
			verLista = UAplicacion.getServletContext().getInitParameter(
					"APLICACION.VER_LISTA_PERIODOS");
			if (verLista == null)
				verLista = "N";
			this.setVerListaPeriodo(false);
			if (verLista.equals("S"))
				this.setVerListaPeriodo(true);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	public void obtenerParametrosVista() {


		String objParametro;
		Parametrosmast parametro;
		ParametrosmastPk pk;

		pk = new ParametrosmastPk();
		pk.setAplicacioncodigo(ConstanteSeguridad.CODIGO_APP_HR);
		pk.setCompaniacodigo(ConstanteSeguridad.COMPANIA_CODIGO_DEFAULT);
		pk.setParametroclave(ConstanteSeguridad.PARAMETRO_CLAVE_URL_POSTULANTE);

		parametro = (Parametrosmast) this.getFacSeguridad().getParametrosmastServicio()
				.obtenerPorId(pk);
		parametro = UValidador.esNulo(parametro)?new Parametrosmast():parametro;

		objParametro = parametro.getExplicacionadicional();
		this.setUrlPostulante(UValidador.esNulo(objParametro) ? "NO_SE_ENCONTRO_PARAMETRO"
				: objParametro);
		

		pk = new ParametrosmastPk();
		pk.setAplicacioncodigo(ConstanteSeguridad.CODIGO_APP_HR);
		pk.setCompaniacodigo(ConstanteSeguridad.COMPANIA_CODIGO_DEFAULT);
		pk.setParametroclave(ConstanteSeguridad.PARAMETRO_CLAVE_PRIVATECK_CONVOCATORIA);

		parametro = (Parametrosmast) this.getFacSeguridad().getParametrosmastServicio()
				.obtenerPorId(pk);
		parametro = UValidador.esNulo(parametro)?new Parametrosmast():parametro;
		
		objParametro = parametro.getExplicacionadicional();
		this.setConvocatoriaPrivateCaptchaKey(UValidador.esNulo(objParametro) ? "NO_SE_ENCONTRO_PARAMETRO"
				: objParametro);

		pk = new ParametrosmastPk();
		pk.setAplicacioncodigo(ConstanteSeguridad.CODIGO_APP_HR);
		pk.setCompaniacodigo(ConstanteSeguridad.COMPANIA_CODIGO_DEFAULT);
		pk.setParametroclave(ConstanteSeguridad.PARAMETRO_CLAVE_PUBLICCK_CONVOCATORIA);

		parametro = (Parametrosmast) this.getFacSeguridad().getParametrosmastServicio()
				.obtenerPorId(pk);
		parametro = UValidador.esNulo(parametro)?new Parametrosmast():parametro;
		
		objParametro = parametro.getExplicacionadicional();
		this.setConvocatoriaPublicCaptchaKey(UValidador.esNulo(objParametro) ? "NO_SE_ENCONTRO_PARAMETRO"
				: objParametro);
	}

	

	@ManagedProperty(value = "#{BeanFactorySeguridad}")
	private FactoryErpSeguridad facSeguridad;

	public FactoryErpSeguridad getFacSeguridad() {
		return facSeguridad;
	}

	public void setFacSeguridad(FactoryErpSeguridad facSeguridad) {
		this.facSeguridad = facSeguridad;
	}
}
