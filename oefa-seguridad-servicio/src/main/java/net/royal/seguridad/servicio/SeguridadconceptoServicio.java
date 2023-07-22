package net.royal.seguridad.servicio;

import java.util.Date;
import java.util.List;

import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.seguridad.dominio.SeguridadconceptoPk;

public interface SeguridadconceptoServicio extends GenericoServicio {

	public Seguridadconcepto buscarPorNombreObjeto(String nombreObjeto);

	public Seguridadconcepto buscarPorNombreObjeto(String codigoAplicacion,
			String nombreObjeto);
	
	public List listarConceptoNavegacion(Class clazz,
			List<ParametroPersistenciaGenerico> parametros);
	
	/**
	 * hrmain.dw_ma_seguridad_concepto_opciones
	 * 
	 * @param codigoUsuario
	 * @return
	 **/

	public List<Seguridadconcepto> ListarentreConceptos(
			String aplicacioncodigo, String grupo, String concepto_desde,
			String concepto_hasta);
	public Date obtenerfechahora();
	
}
