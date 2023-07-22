package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dao.HrPuestosubordinadoDao;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;
import net.royal.erp.rrhh.dominio.HrPuestosubordinadoPk;
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
public class HrPuestosubordinadoDaoImpl extends
		GenericoDaoImpl<HrPuestosubordinado, HrPuestosubordinadoPk> implements
		HrPuestosubordinadoDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestosubordinado.class);
	private HrPuestoempresaDao daoPuestoEmpresa;

	public HrPuestosubordinadoDaoImpl() {
		super("hrpuestosubordinado");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Autowired
	public void setDaoPuestoEmpresa(HrPuestoempresaDao daoPuestoEmpresa) {
		this.daoPuestoEmpresa = daoPuestoEmpresa;
	}

	@Override
	public List<HrPuestosubordinado> listarTabPuestosSubordinados(
			Integer codigopuesto) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestosubordinado> datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos))
			return null;
		HrPuestoempresaPk pk = new HrPuestoempresaPk();
		
		for (HrPuestosubordinado x : datos) {
				
				HrPuestoempresa objPuestoempresa = daoPuestoEmpresa
						.obtenerPuestoEmpresaporCodigo(x.getPk()
								.getCodigopuesto());
				
				x.setAuxPuestoDescripcion(objPuestoempresa.getDescripcion());
				LOGGER.debug(x.getAuxPuestoDescripcion());
			
		}

		return datos;
	}

}
