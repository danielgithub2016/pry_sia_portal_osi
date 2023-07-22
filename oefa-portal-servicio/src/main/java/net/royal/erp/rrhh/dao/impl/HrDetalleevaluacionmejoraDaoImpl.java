package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrDetalleevaluacionmejoraDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejoraPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrDetalleevaluacionmejoraDaoImpl extends
		GenericoDaoImpl<HrDetalleevaluacionmejora, HrDetalleevaluacionmejoraPk>
		implements HrDetalleevaluacionmejoraDao {

	private static Log LOGGER = LogFactory
			.getLog(HrDetalleevaluacionmejora.class);

	public HrDetalleevaluacionmejoraDaoImpl() {
		super("hrdetalleevaluacionmejora");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<HrDetalleevaluacionmejora> obtenerListaCompromisoMejora(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {
		logger.debug(companyowner + "\n" + empleado + "\n" + secuenciaeval
				+ "\n" + empleadoevaluador);
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));

		List<HrDetalleevaluacionmejora> datos = this.listarPorCriterios(cri);

		return datos;
	}
	
	@Override
	public void grabarDetalleMejora(
			List<HrDetalleevaluacionmejora> dwCompromisomejora) {

		for (HrDetalleevaluacionmejora dw_compromisomejora : dwCompromisomejora) {
			HrDetalleevaluacionmejoraPk pk = new HrDetalleevaluacionmejoraPk();
			HrDetalleevaluacionmejora detalleMejora = new HrDetalleevaluacionmejora();

			pk.setCompanyowner(dw_compromisomejora.getPk().getCompanyowner());
			pk.setEmpleado(dw_compromisomejora.getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_compromisomejora.getPk()
					.getEmpleadoevaluador());
			pk.setSecuencia(dw_compromisomejora.getPk().getSecuencia());
			pk.setSecuenciaeval(dw_compromisomejora.getPk().getSecuenciaeval());
			pk.setTipo(dw_compromisomejora.getPk().getTipo());

			detalleMejora = this.obtenerPorId(pk,false);
			if (UValidador.esNulo(detalleMejora)) {
				detalleMejora = new HrDetalleevaluacionmejora();
				detalleMejora.setPk(pk);

				setearValores(dw_compromisomejora, detalleMejora);
				this.registrar(detalleMejora);
			} else {
				setearValores(dw_compromisomejora, detalleMejora);
				this.actualizar(detalleMejora);
			}
		}

	}

	private void setearValores(HrDetalleevaluacionmejora dw_compromisomejora,
			HrDetalleevaluacionmejora detalleMejora) {

		detalleMejora.setCalificacion(dw_compromisomejora.getCalificacion());
		detalleMejora.setComentarios(dw_compromisomejora.getComentarios());
		detalleMejora.setDescripcion(dw_compromisomejora.getDescripcion());
		detalleMejora.setFactor(dw_compromisomejora.getFactor());
		detalleMejora.setUltimaFechaModif(dw_compromisomejora
				.getUltimaFechaModif());
		detalleMejora.setUltimoUsuario(dw_compromisomejora.getUltimoUsuario());
		detalleMejora
				.setValorrequerido(dw_compromisomejora.getValorrequerido());

	}
	
	@Override
	public void eliminarDetalleEvaluacionMejora(String iv_compania,
			Integer iv_empleado, Integer iv_secuencia,
			Integer iv_empleadoevaluador) {

		HrDetalleevaluacionmejora evlauacionMejora = new HrDetalleevaluacionmejora();

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", iv_compania));
		cri.add(Restrictions.eq("pk.secuenciaeval", iv_secuencia));
		cri.add(Restrictions.eq("pk.empleado", iv_empleado));
		cri.add(Restrictions.eq("pk.empleadoevaluador", iv_empleadoevaluador));

		List<HrDetalleevaluacionmejora> lista = this.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(lista)) {
			for(HrDetalleevaluacionmejora dwcompromiso:lista ){
				this.eliminar(dwcompromiso);
			}
		}

	}


}
