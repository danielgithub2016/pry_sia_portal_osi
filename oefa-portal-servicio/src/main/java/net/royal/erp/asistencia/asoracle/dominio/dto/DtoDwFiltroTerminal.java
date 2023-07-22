package net.royal.erp.asistencia.asoracle.dominio.dto;

import net.royal.erp.asistencia.asmast.dominio.dto.DtoDddwAsTempusTerminal;

/**
 *
 * @author desarrollo
 * @powerbuilder asoracle.dw_filtro_terminal
 */
public class DtoDwFiltroTerminal implements java.io.Serializable {

	private String allterminal;
	private Integer anterminal;
	private DtoDddwAsTempusTerminal objtempusterminal;
	
	/**
	 * @return the allterminal
	 */
	public String getAllterminal() {
		return allterminal;
	}
	/**
	 * @param allterminal the allterminal to set
	 */
	public void setAllterminal(String allterminal) {
		this.allterminal = allterminal;
	}
	/**
	 * @return the objtempusterminal
	 */
	public DtoDddwAsTempusTerminal getObjtempusterminal() {
		return objtempusterminal;
	}
	/**
	 * @param objtempusterminal the objtempusterminal to set
	 */
	public void setObjtempusterminal(DtoDddwAsTempusTerminal objtempusterminal) {
		this.objtempusterminal = objtempusterminal;
	}
	/**
	 * @return the anterminal
	 */
	public Integer getAnterminal() {
		return anterminal;
	}
	/**
	 * @param anterminal the anterminal to set
	 */
	public void setAnterminal(Integer anterminal) {
		this.anterminal = anterminal;
	}
	
}
