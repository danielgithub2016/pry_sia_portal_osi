package net.royal.erp.core.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.framework.web.dao.GenericoDao;

public interface EmpleadomastDao extends
		GenericoDao<Empleadomast, EmpleadomastPk> {

	/**
	 * 
	 * @param codigoUsuario
	 * @return maximoCodigoUsuario
	 */
	public Integer obtenerMaximoEmpleado(String codigoUsuario);

	/**
	 * @powerbuilder wf_next_screen - selectSuelto <br>
	 *               hrproc.f_sql_get_areaopertiva <br>
	 *               w_hr_evaluacionperiodo_list_evaluar <br>
	 *               wf_retrieve_evaluador <br>
	 *               f_get_empleadoxusuario
	 * @param codigoUsuario
	 * @author nunezh
	 * @return
	 */
	public Empleadomast obtenerPorCodigoUsuario(String codigoUsuario);

	/**
	 * @powerbuilder hrothers.f_sql_centrocostos_select
	 * @param p_empleado
	 * @return Objeto para que sea reutilizable
	 */
	public Empleadomast obtenerEmpleadoMast(Integer p_empleado);

	public String obtenerNombreCargoEmpleado(Integer par_empleado,
			String par_compania);

	/**
	 * @powerbuilder dw_hr_empleado_select_multiple_sincia
	 * @param sb
	 * @return
	 */
	public List listardwList(String sb);

	/**
	 * @powerbuilder dw_pr_empleado_select
	 * @param sb
	 * @return
	 */
	public List listarEmpleadoEval(String sb);

	public BigDecimal obtenerCodigoCargo(Integer empleado);
	

}
