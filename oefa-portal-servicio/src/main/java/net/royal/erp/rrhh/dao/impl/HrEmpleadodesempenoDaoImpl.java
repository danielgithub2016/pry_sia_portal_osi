package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrEmpleadodesempenoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempenoPk;

@Repository
public class HrEmpleadodesempenoDaoImpl extends GenericoDaoImpl<HrEmpleadodesempeno, HrEmpleadodesempenoPk> implements HrEmpleadodesempenoDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadodesempeno.class);

	public HrEmpleadodesempenoDaoImpl() {
		super("hrempleadodesempeno");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public void grabardw5(List<HrEmpleadodesempeno> dw5) {
		List<HrEmpleadodesempeno> dw5ARemover= new ArrayList<HrEmpleadodesempeno>();
		
		for (HrEmpleadodesempeno dw_5 : dw5) {
			HrEmpleadodesempenoPk pk = new HrEmpleadodesempenoPk();
			HrEmpleadodesempeno desempeno = new HrEmpleadodesempeno();

			pk.setCompanyowner(dw_5.getPk().getCompanyowner());
			pk.setEmpleado(dw_5.getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_5.getPk()
					.getEmpleadoevaluador());
			pk.setSecuencia(dw_5.getPk().getSecuencia());
			pk.setSecuenciaeval(dw_5.getPk().getSecuenciaeval());
			//
			if (dw_5.getEliminado().equals("N")) {
				desempeno = this.obtenerPorId(pk,false);
				if (UValidador.esNulo(desempeno)) {
					desempeno = new HrEmpleadodesempeno();
					desempeno.setPk(pk);

					setearValores(dw_5, desempeno);
					
					this.registrar(desempeno);
				}else{
					setearValores(dw_5, desempeno);
					this.actualizar(desempeno);
				}

			}else{
				desempeno = this.obtenerPorId(pk,false);
				if (!UValidador.esNulo(desempeno)) {
					this.eliminar(desempeno);
				}else{
					dw5ARemover.add(dw_5);
				}
			}
		}
		
		
		for (int i = 0; i < dw5ARemover.size(); i++) {
			for (int a = 0; a < dw5.size(); a++) {
				if (dw5.get(a).getPk().getSecuencia()
						.equals(dw5ARemover.get(i).getPk().getSecuencia())
						&& dw5.get(a).getEliminado().equals("S")) {

					dw5.remove(a);
				}
			}
		}
	}
	
	 private void setearValores(HrEmpleadodesempeno dw_5, HrEmpleadodesempeno desempeno){
		   desempeno.setDescripcion(dw_5.getDescripcion());
		   desempeno.setTipo(dw_5.getTipo());
		   desempeno.setUltimaFechaModif(dw_5.getUltimaFechaModif());
		   desempeno.setUltimoUsuario(dw_5.getUltimoUsuario());
		}
	
	@Override
	public List<HrEmpleadodesempeno> ListarEmpleadoDesempenoporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {
		
		Criteria cri = this.getCriteria();
		
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));
		
		List datos = this.listarPorCriterios(cri);
		
		return datos;
	}

	@Override
	public Integer ObtenerMaximaSecuencia(Integer empleado,
			Integer secuenciaeval) {
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.and(
						Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("pk.secuenciaeval", secuenciaeval)))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("pk.secuencia")));

		return this.incrementarInteger(cri);
	}

}
