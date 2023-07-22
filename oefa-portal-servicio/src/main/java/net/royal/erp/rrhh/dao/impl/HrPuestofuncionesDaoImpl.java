package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dao.HrPuestofuncionesDao;
import net.royal.erp.rrhh.dominio.HrPuestofunciones;
import net.royal.erp.rrhh.dominio.HrPuestofuncionesPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HrPuestofuncionesDaoImpl extends
		GenericoDaoImpl<HrPuestofunciones, HrPuestofuncionesPk> implements
		HrPuestofuncionesDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestofunciones.class);
	private MaMiscelaneosdetalleDao daoMa;

	@Autowired
	public void setDaoPuestoEmpresa(MaMiscelaneosdetalleDao daoMa) {
		this.daoMa = daoMa;
	}

	public HrPuestofuncionesDaoImpl() {
		super("hrpuestofunciones");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<HrPuestofunciones> listarFunciones(Integer par_codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", par_codigopuesto));

		List<HrPuestofunciones> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		Criteria cr = daoMa.getCriteria();
		cr.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		cr.add(Restrictions.eq("pk.codigotabla", "FUNCIONES"));
		cr.add(Restrictions.eq("pk.compania", "999999"));

		List<MaMiscelaneosdetalle> lis = daoMa.listarPorCriterios(cr);

		for (HrPuestofunciones x : datos) {
			for (MaMiscelaneosdetalle a : lis) {
				if (x.getFuncion().equals(a.getPk().getCodigoelemento())) {
					x.setAuxFuncion(a.getDescripcionlocal());
				}
			}
		}
		return datos;
	}

}
