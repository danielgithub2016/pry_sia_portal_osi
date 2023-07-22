package net.royal.erp.presupuesto.servicio;

import java.util.List;

import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.framework.web.servicio.GenericoServicio;

public interface BuNivelserviciomstServicio extends GenericoServicio {

	public List<BuNivelserviciomst> listarNivelServiciomst(String companiasocio);

	public String obtenerDescripcion(String par_compania, Integer par_nivel);

	public List<BuNivelserviciomst> listarNivelporFiltos(String companiasocio,
			Integer[] object);

	public BuNivelserviciomst obtenerporRequerimiento(String compania,
			String req);

	public Integer obtenerSecuencia();
}
