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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrEmpleadocomentariosDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentariosPk;

@Repository
public class HrEmpleadocomentariosDaoImpl extends GenericoDaoImpl<HrEmpleadocomentarios, HrEmpleadocomentariosPk> implements HrEmpleadocomentariosDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadocomentarios.class);

	public HrEmpleadocomentariosDaoImpl() {
		super("hrempleadocomentarios");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<HrEmpleadocomentarios> obtenerListaComentarios(String companyowner, Integer empleado, Integer secuenciaeval, Integer empleadoevaluador){
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));
		
		List datos = this.listarPorCriterios(cri);
		
		return datos;
	}
	
	@Override
	public void grabardwComentario(List<HrEmpleadocomentarios> dwComentario) {
		for (HrEmpleadocomentarios dw_comentario : dwComentario) {
			HrEmpleadocomentarios detalle = new HrEmpleadocomentarios();
			HrEmpleadocomentariosPk pk = new HrEmpleadocomentariosPk();

			pk.setCompanyowner(dw_comentario.getPk().getCompanyowner());
			pk.setEmpleado(dw_comentario.getPk().getEmpleado().intValue());
			pk.setEmpleadoevaluador(dw_comentario.getPk().getEmpleadoevaluador().intValue());
			pk.setSecuencia(dw_comentario.getPk().getSecuencia().intValue());
			pk.setSecuenciaeval(dw_comentario.getPk().getSecuenciaeval().intValue());

			detalle = this.obtenerPorId(pk,false);

			if (UValidador.esNulo(detalle)) {
				detalle = new HrEmpleadocomentarios();
				detalle.setPk(pk);
				setearValores(dw_comentario, detalle);
				this.registrar(detalle);
			} else {
				setearValores(dw_comentario, detalle);
				this.actualizar(detalle);
			}
		}
	}
	
	
	private void setearValores(HrEmpleadocomentarios dw_comentario, HrEmpleadocomentarios detalle){
		detalle.setComentarios(dw_comentario.getComentarios());
		detalle.setDescripcion(dw_comentario.getDescripcion());
		detalle.setFactor(dw_comentario.getFactor());
		detalle.setUltimaFechaModif(dw_comentario.getUltimaFechaModif());
		detalle.setUltimoUsuario(dw_comentario.getUltimoUsuario());
		
	}
}
