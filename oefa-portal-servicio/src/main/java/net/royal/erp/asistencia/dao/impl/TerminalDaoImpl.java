package net.royal.erp.asistencia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import net.royal.erp.asistencia.dao.TerminalDao;
import net.royal.erp.asistencia.dominio.Terminal;
import net.royal.erp.asistencia.dominio.TerminalPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings("serial")
@Repository
public class TerminalDaoImpl extends GenericoDaoImpl<Terminal, TerminalPk>
		implements TerminalDao {

	public TerminalDaoImpl() {
		super("terminal");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Terminal> listarTerminalVista() {
		return this.listarPorCriterios(this.getCriteria()
				.addOrder(Order.asc("descripcion")));
	}

}
