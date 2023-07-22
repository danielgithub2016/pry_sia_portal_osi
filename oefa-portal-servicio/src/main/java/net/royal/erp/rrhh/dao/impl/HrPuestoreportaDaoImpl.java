package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dao.HrPuestoreportaDao;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDoc;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.erp.rrhh.dominio.HrPuestoreporta;
import net.royal.erp.rrhh.dominio.HrPuestoreportaPk;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;

@Repository
public class HrPuestoreportaDaoImpl extends GenericoDaoImpl<HrPuestoreporta, HrPuestoreportaPk> implements HrPuestoreportaDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestoreporta.class);
	private HrPuestoempresaDao daoPuestoEmpresa;

	public HrPuestoreportaDaoImpl() {
		super("hrpuestoreporta");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestoreporta> listarTabRelaciones(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestoreporta> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;
		
		HrPuestoempresaPk pk = new HrPuestoempresaPk();
		
		for (HrPuestoreporta x : datos) {
				
				HrPuestoempresa objPuestoempresa = daoPuestoEmpresa
						.obtenerPuestoEmpresaporCodigo(x.getPk()
								.getCodigopuesto());
				
				x.setDescripcionreporta(objPuestoempresa.getDescripcion());
			
		}


		return datos;
	}

	@Autowired
	public void setDaoPuestoEmpresa(HrPuestoempresaDao daoPuestoEmpresa) {
		this.daoPuestoEmpresa = daoPuestoEmpresa;
	}

}
