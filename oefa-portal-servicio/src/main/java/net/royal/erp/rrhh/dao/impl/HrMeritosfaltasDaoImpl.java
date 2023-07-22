package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrMeritosfaltasDao;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrMeritosfaltas;
import net.royal.erp.rrhh.dominio.HrMeritosfaltasPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HrMeritosfaltasDaoImpl extends GenericoDaoImpl<HrMeritosfaltas, HrMeritosfaltasPk>
		implements HrMeritosfaltasDao {

	private static Log LOGGER = LogFactory.getLog(HrMeritosfaltas.class);

	public HrMeritosfaltasDaoImpl() {
		super("hrmeritosfaltas");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public void grabardw3(List<DtoDwHrIncidentecriticoList> dw3) {
		List<DtoDwHrIncidentecriticoList> dw3ARemover = new ArrayList<DtoDwHrIncidentecriticoList>();

		for (DtoDwHrIncidentecriticoList dw_3 : dw3) {
			HrMeritosfaltasPk pk = new HrMeritosfaltasPk();
			HrMeritosfaltas desempeno = new HrMeritosfaltas();

			pk.setCompanyowner(dw_3.getCompanyowner());
			pk.setEmpleado(dw_3.getEmpleado().intValue());
			pk.setSecuencia(dw_3.getSecuencia().intValue());
			pk.setTipo(dw_3.getTipo());
			//
			if (dw_3.getEliminado().equals("N")) {
				desempeno = this.obtenerPorId(pk, false);
				if (UValidador.esNulo(desempeno)) {
					desempeno = new HrMeritosfaltas();
					desempeno.setPk(pk);

					setearValores(dw_3, desempeno);

					this.registrar(desempeno);
				} else {
					setearValores(dw_3, desempeno);
					this.actualizar(desempeno);
				}

			} else {
				desempeno = this.obtenerPorId(pk, false);
				if (!UValidador.esNulo(desempeno)) {
					this.eliminar(desempeno);
				} else {
					dw3ARemover.add(dw_3);

				}
			}
		}

		for (int i = 0; i < dw3ARemover.size(); i++) {
			for (int a = 0; a < dw3.size(); a++) {
				if (dw3.get(a).getSecuencia().equals(dw3ARemover.get(i).getSecuencia())
						&& dw3.get(a).getEliminado().equals("S")) {

					dw3.remove(a);

				}
			}
		}

	}

	private void setearValores(DtoDwHrIncidentecriticoList dw_3, HrMeritosfaltas desempeno) {
		if (!UValidador.esNulo(dw_3.getClasificacion())) {
			desempeno.setClasificacion(dw_3.getClasificacion());
		}

		if (!UValidador.esNulo(dw_3.getDiasSuspension())) {
			desempeno.setDiassuspension(dw_3.getDiasSuspension());
		}
		if (!UValidador.esNulo(dw_3.getDocumento())) {
			desempeno.setDocumento(dw_3.getDocumento());
		}
		if (!UValidador.esNulo(dw_3.getFechafin())) {
			desempeno.setFechafin(dw_3.getFechafin());
		}
		if (!UValidador.esNulo(dw_3.getFechainicio())) {
			desempeno.setFechainicio(dw_3.getFechainicio());
		}
		if (!UValidador.esNulo(dw_3.getMedidaDisciplinaria())) {
			desempeno.setMedidadisciplinaria(dw_3.getMedidaDisciplinaria());
		}
		if (!UValidador.esNulo(dw_3.getResponsable())) {
			desempeno.setResponsable(dw_3.getResponsable().intValue());
		}
		
		
		desempeno.setDescripcion(dw_3.getDescripcion());
		desempeno.setFecha(dw_3.getFecha());
		desempeno.setFlagsoloenevaluacion(dw_3.getFlagsoloenevaluacion());
		desempeno.setPeriodo(dw_3.getPeriodo());
		desempeno.setUltimaFechaModif(dw_3.getUltimafechamodif());
		desempeno.setUltimoUsuario(dw_3.getUltimousuario());
		desempeno.setUnidadnegocio(dw_3.getUnidadnegocio());
	}

	@Override
	public Integer ObtenerMaximaSecuenciaxEmp(Integer empleado) {
		LOGGER.debug("logger para prueba");

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", empleado));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));

		cri.setProjection(proj);

		return this.incrementarInteger(cri);

	}

}
