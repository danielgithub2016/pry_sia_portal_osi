package net.royal.erp.presupuesto.dao;

import java.util.List;

import net.royal.erp.presupuesto.dominio.BuNivelserviciomst;
import net.royal.erp.presupuesto.dominio.BuNivelserviciomstPk;
import net.royal.framework.web.dao.GenericoDao;

public interface BuNivelserviciomstDao extends
		GenericoDao<BuNivelserviciomst, BuNivelserviciomstPk> {

	/**
	 * @powerbuilder comboCentroCosto - dw_ma_nivelservicio_select
	 * @param companiasocio
	 * @return
	 */
	public List<BuNivelserviciomst> listarNivelServiciomst(String companiasocio);

	public String readReferenciaFiscalNS(String par_ano, String par_tipo,
			String par_valor, String par_nivel, String gv_version,
			String gv_companyowner);

	/**
	 * @powerbuilder f_nombre_nivelservicio
	 * @param par_compania
	 * @param par_nivel
	 * @return
	 */
	public String obtenerDescripcion(String par_compania, Integer par_nivel);

	
	public List<BuNivelserviciomst> listarNivelporFiltos(String companiasocio, Integer[] object);
	
}
