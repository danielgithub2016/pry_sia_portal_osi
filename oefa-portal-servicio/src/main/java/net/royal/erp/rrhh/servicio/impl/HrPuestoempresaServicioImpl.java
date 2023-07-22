package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.servicio.HrPuestoempresaServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrPuestoempresa")
public class HrPuestoempresaServicioImpl extends GenericoServicioImpl implements
		HrPuestoempresaServicio {

	private HrPuestoempresaDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrPuestoempresaServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoempresaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoempresa> listarPuestoEmpresa() {
		// TODO Auto-generated method stub
		return dao.listarPuestoEmpresa();
	}

	@Override
	public List<HrPuestoempresa> listarPuestoEmpresaporFiltros(
			String codigopuesto, String flagpuestopracticante) {
		return dao.listarPuestoEmpresaporFiltros(codigopuesto, flagpuestopracticante);
	}

	public List<HrPuestoempresa> listarComboPuestos(){
		return dao.listarComboPuestos();
	}
	
	@Override
	public List<HrPuestoempresa> listarActivos() {
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("descripcion"));
		List<HrPuestoempresa> list = dao
				.listarPorCriterios(cri);		
		return list;
	}

	@Override
	public HrPuestoempresa obtenerPuestoEmpresaporCodigo(
			Integer codigopuesto) {
		return dao.obtenerPuestoEmpresaporCodigo(codigopuesto);
	}
}
