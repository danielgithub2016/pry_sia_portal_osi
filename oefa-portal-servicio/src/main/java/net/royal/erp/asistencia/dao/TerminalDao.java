package net.royal.erp.asistencia.dao;

import java.util.List;

import net.royal.erp.asistencia.dominio.Terminal;
import net.royal.erp.asistencia.dominio.TerminalPk;
import net.royal.framework.web.dao.GenericoDao;

public interface TerminalDao extends GenericoDao<Terminal, TerminalPk> {
	
   /**
	 * @powerbuilder dddw_as_tempus_terminal
	 * @return lista
	 */
public List<Terminal> listarTerminalVista();
}
