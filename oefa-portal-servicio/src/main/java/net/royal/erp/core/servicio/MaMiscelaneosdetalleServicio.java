package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.framework.web.servicio.GenericoServicio;

public interface MaMiscelaneosdetalleServicio extends GenericoServicio {
	public List<MaMiscelaneosdetalle> ListarMiscelaneosdetalle();

	public String obtenerValorCodigo(String aplicacionCodigo, String compania,
			String codigoTabla, String descripcionlocal);

	public String obtenerValorCodigo2(String aplicacionCodigo, String compania,
			String codigoTabla, String descripcionlocal);
	/**
	 * Obtener descripcion miscelaneos x param.
	 *
	 * @author nunezh
	 * @powerbuilder <strong>hrbienestar.f_descripcion_miscelaneos</strong>
	 * @param par_companyowner
	 *            companyowner
	 * @param par_aplicacion
	 *            código de aplicación
	 * @param par_tabla
	 *            tabla a la que se consultará
	 * @param par_codigoelemento
	 *            código del elemento para la consulta
	 * @return descripción
	 */
	public String obtenerDescripcionMiscelaneosXParam(String par_companyowner,
			String par_aplicacion, String par_tabla, String par_codigoelemento);
	
	public List<MaMiscelaneosdetalle> listarPorEjemplo(String aplicacionCodigo,
			String codigoTabla, String compania);
	
	public MaMiscelaneosdetalle obtenerPorId(String aplicacionCodigo,
			String codigoTabla, String codigoElemento);
	
	public String obtenerNombreMiscelaneo(String par_aplicacion,String par_compania, String par_miscelaneo, String[] par_valores);

	public List<MaMiscelaneosdetalle> listarSelectorVariosMiscelaneos(String par_aplicacion,
			String par_compania, String par_tabla);
	
	public List<MaMiscelaneosdetalle> listarBusquedaMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal);
	
	public List<MaMiscelaneosdetalle> listarVerMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal,String[] areas,Integer iv_objetos, String actionButton);
}
