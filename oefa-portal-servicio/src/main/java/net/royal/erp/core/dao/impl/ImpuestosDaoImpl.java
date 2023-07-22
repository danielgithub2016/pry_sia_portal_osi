package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.AccountmstDao;
import net.royal.erp.core.dao.ImpuestosDao;
import net.royal.erp.core.dao.ServicioximpuestoDao;
import net.royal.erp.core.dominio.Impuestos;
import net.royal.erp.core.dominio.ImpuestosPk;
import net.royal.erp.core.dominio.Servicioximpuesto;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("impuestosDaoImplCore")
public class ImpuestosDaoImpl extends GenericoDaoImpl<Impuestos, ImpuestosPk>
		implements ImpuestosDao {

	private static Log LOGGER = LogFactory.getLog(Impuestos.class);
	private ServicioximpuestoDao daoServicioximpuesto;
	
	public ImpuestosDaoImpl() {
		super("core.impuestos");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Impuestos> listarPorTipoServicio(String tiposervicio) {
		List<Servicioximpuesto>  listaServicios = null;
		List<Impuestos> lista = new ArrayList<Impuestos>();
		listaServicios = daoServicioximpuesto.listarPorTipoServicio(tiposervicio);
		
		for (Servicioximpuesto servicioximpuesto : listaServicios) {
			Impuestos obj=null;
			obj = this.obtenerPorId(new ImpuestosPk(servicioximpuesto.getPk().getImpuesto()));
			lista.add(obj);
		}
		
		return lista;
	}
	
	@Autowired
	public void setServicioximpuestoDao(ServicioximpuestoDao daoServicioximpuesto) {
		this.daoServicioximpuesto =daoServicioximpuesto;
	}

}
