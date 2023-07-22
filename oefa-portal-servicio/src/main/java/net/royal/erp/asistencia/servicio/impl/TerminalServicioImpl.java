package net.royal.erp.asistencia.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.asistencia.dao.TerminalDao;
import net.royal.erp.asistencia.servicio.TerminalServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioTerminal")
public class TerminalServicioImpl extends GenericoServicioImpl implements
		TerminalServicio {

	private TerminalDao dao;

	@Autowired
	public void setDao(TerminalDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	
}
