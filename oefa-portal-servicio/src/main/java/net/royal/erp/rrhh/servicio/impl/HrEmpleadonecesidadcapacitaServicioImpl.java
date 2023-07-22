package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dao.HrCapacitacionDao;
import net.royal.erp.rrhh.dao.HrEmpleadocapacitacionDao;
import net.royal.erp.rrhh.dao.HrEmpleadonecesidadcapacitaDao;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacitaPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.hrrep.dominio.dto.DtoDwHrEvaluacionCapacitacionDetail;
import net.royal.erp.rrhh.servicio.HrEmpleadonecesidadcapacitaServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrEmpleadonecesidadcapacita")
public class HrEmpleadonecesidadcapacitaServicioImpl extends
		GenericoServicioImpl implements HrEmpleadonecesidadcapacitaServicio {

	private HrEmpleadonecesidadcapacitaDao dao;
	private HrCapacitacionDao daoHrCapacitacion;
	private HrEmpleadocapacitacionDao daoRmpleadocapacitacion;

	private static Log LOGGER = LogFactory
			.getLog(HrEmpleadonecesidadcapacitaServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadonecesidadcapacitaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrEmpleadonecesidadcapacita> ListarEmpleadoNecesidadCapacitaxParam(
			String companyowner, Integer empleado, Integer secuenciaeval) {
		return dao.ListarEmpleadoNecesidadCapacitaxParam(companyowner,
				empleado, secuenciaeval);
	}

	@Override
	public Integer ObtenerMaximaSecuencia(Integer empleado,
			Integer secuenciaeval) {

		return dao.ObtenerMaximaSecuencia(empleado, secuenciaeval);
	}

	@Override
	public List<DtoDwHrEmpleadonecesidadcapacitaEdit> eliminarNecesidad(
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> lista,
			DtoDwHrEmpleadonecesidadcapacitaEdit seleccion, Integer empleado) {
		String wCapacitacion;
		Integer llAno = null, wParticipante, wNumerovacantes;
		List<HrCapacitacion> dw17;
		List<DtoDwHrEvaluacionCapacitacionDetail> dw18;

		wCapacitacion = seleccion.getBean().getCapacitacion();

		HrCapacitacion obj = daoHrCapacitacion
				.obtenerAnioPlanxParam(wCapacitacion);

		if (!UValidador.esNulo(obj))
			llAno = obj.getAnioplan();

		dw17 = daoHrCapacitacion.listarPorAnioPlan(llAno);
		dw18 = daoRmpleadocapacitacion.dwHrEvaluacionCapacitacionDetail(llAno);

		for (int i = 0; i < dw18.size(); i++) {
			if (dw18.get(i).getCapacitacion().equals(wCapacitacion)
					&& dw18.get(i).getEmpleado()
							.compareTo(new BigDecimal(empleado)) == 0) {
				HrEmpleadocapacitacionPk pk = new HrEmpleadocapacitacionPk();
				pk.setCapacitacion(dw18.get(i).getCapacitacion());
				pk.setEmpleado(dw18.get(i).getEmpleado().intValue());

				HrEmpleadocapacitacion ecapac = daoRmpleadocapacitacion
						.obtenerPorId(pk,false);

				daoRmpleadocapacitacion.eliminar(ecapac);

				dw18.remove(i);
				break;
			}
		}

		for (int i = 0; i < dw17.size(); i++) {
			if (dw17.get(i).getPk().getCapacitacion().equals(wCapacitacion)) {
				{
					wNumerovacantes = dw17.get(i).getNumerovacantes();
					if (wNumerovacantes > 0) {
						wNumerovacantes--;
						if (wNumerovacantes == 0) {
							dw17.get(i).setNumerovacantes(wNumerovacantes);
							dw17.get(i).setNumeroparticipantes(wNumerovacantes);

							daoHrCapacitacion.actualizar(dw17.get(i));
						}
					}
				}
				break;
			}
		}

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getBean().getPk().getSecuencia() == seleccion
					.getBean().getPk().getSecuencia()) {
				lista.get(i).setEliminado("S");
				break;
			}
		}

		return lista;
	}

	@Autowired
	public void setDaoHrCapacitacion(HrCapacitacionDao daoHrCapacitacion) {
		this.daoHrCapacitacion = daoHrCapacitacion;
	}

	@Autowired
	public void setDaoRmpleadocapacitacion(
			HrEmpleadocapacitacionDao daoRmpleadocapacitacion) {
		this.daoRmpleadocapacitacion = daoRmpleadocapacitacion;
	}

	@Override
	//@Transactional  
	public void grabarEmpleadoNecesidad(
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7) {

		dao.grabarEmpleadoNecesidad(dw7);

	}

}
