package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEmpleadorevisionDao;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.HrEmpleadorevisionPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HrEmpleadorevisionDaoImpl extends GenericoDaoImpl<HrEmpleadorevision, HrEmpleadorevisionPk> implements HrEmpleadorevisionDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadorevision.class);

	public HrEmpleadorevisionDaoImpl() {
		super("hrempleadorevision");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
	
	public List<HrEmpleadorevision> obtenerListaRevision(String companyowner, Integer empleado, Integer secuenciaeval, Integer empleadoevaluador){
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));
		
		List datos = this.listarPorCriterios(cri);
		
		return datos;
	}
	
	@Override
	public void grabarEmpleadoRevision(List<HrEmpleadorevision> dwrevision) {
		List<HrEmpleadorevision> dwrevisionARemover= new ArrayList<HrEmpleadorevision>();
		
		for (HrEmpleadorevision dw_revision : dwrevision) {
			HrEmpleadorevisionPk pk = new HrEmpleadorevisionPk();
			HrEmpleadorevision empleadoRevision = new HrEmpleadorevision();

			pk.setCompanyowner(dw_revision.getPk().getCompanyowner());
			pk.setEmpleado(dw_revision.getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_revision.getPk().getEmpleadoevaluador());
			pk.setSecuencia(dw_revision.getPk().getSecuencia());
			pk.setSecuenciaeval(dw_revision.getPk().getSecuenciaeval());
			//
			if (dw_revision.getEliminado().equals("N")) {
				empleadoRevision = this.obtenerPorId(pk,false);
				if (UValidador.esNulo(empleadoRevision)) {
					empleadoRevision = new HrEmpleadorevision();
					empleadoRevision.setPk(pk);

					setearValores(dw_revision, empleadoRevision);

					this.registrar(empleadoRevision);
				} else {
					setearValores(dw_revision, empleadoRevision);
					this.actualizar(empleadoRevision);
				}

			} else {
				empleadoRevision = this.obtenerPorId(pk,false);
				if (!UValidador.esNulo(empleadoRevision)) {
					this.eliminar(empleadoRevision);
				}else{
					dwrevisionARemover.add(dw_revision);
				}
			}
		}
		
		
		for (int i = 0; i < dwrevisionARemover.size(); i++) {
			for (int a = 0; a < dwrevision.size(); a++) {
				if (dwrevision.get(a).getPk().getSecuencia()
						.equals(dwrevisionARemover.get(i).getPk().getSecuencia())
						&& dwrevision.get(a).getEliminado().equals("S")) {

					dwrevision.remove(a);
				}
			}
		}
	}
	
	private void setearValores(HrEmpleadorevision dw_revision, HrEmpleadorevision empleadoRevision){
		empleadoRevision.setDescripcion(dw_revision.getDescripcion());
		empleadoRevision.setObservacion(dw_revision.getObservacion());
		empleadoRevision.setPeriodo(dw_revision.getPeriodo());
		empleadoRevision.setUltimaFechaModif(dw_revision.getUltimaFechaModif());
		empleadoRevision.setUltimoUsuario(dw_revision.getUltimoUsuario());
		
	}

}
