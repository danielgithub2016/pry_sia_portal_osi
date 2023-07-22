package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrPuestoempresaServicio extends GenericoServicio {

	public List<HrPuestoempresa> listarPuestoEmpresa();

	public List<HrPuestoempresa> listarPuestoEmpresaporFiltros(
			String w_filtroCod, String flagpuestopracticante);
	
	public List<HrPuestoempresa> listarComboPuestos();
	
	public List<HrPuestoempresa> listarActivos();
	
	public HrPuestoempresa obtenerPuestoEmpresaporCodigo(Integer codigopuesto);
}
