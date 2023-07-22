package net.royal.erp.contabilidad.dao;

import java.util.List;

import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.contabilidad.dominio.AcCostcentermstPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AcCostcentermstDao extends GenericoDao<AcCostcentermst, AcCostcentermstPk> {

	/**
	 * Lista combo centro costo.
	 *
	 * @powerbuilder comboCentroCosto - dw_ma_ac_costcenter_select
	 * @return the list
	 */
	public List<AcCostcentermst> listaComboCentroCosto();
	
	/**
	 * Obtener centro costo.
	 *
	 * @powerbuilder f_sql_read_costcenter_name.
	 * @param par_costcenter the par_costcenter
	 * @return the string
	 */
	public String obtenerCentroCosto(String par_costcenter);
	
	/**
	 * Obtener list centro costo.
	 *
	 * @param par_costcenter the par_costcenter
	 * @return the ac costcentermst
	 */
	public AcCostcentermst obtenerListCentroCosto(String par_costcenter);
	
	
	
	
}
