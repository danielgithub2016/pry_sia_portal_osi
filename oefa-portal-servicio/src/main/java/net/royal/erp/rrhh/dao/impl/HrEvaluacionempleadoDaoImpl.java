package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacionempleadoDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleado;
import net.royal.erp.rrhh.dominio.HrEvaluacionempleadoPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionEdit;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Repository
public class HrEvaluacionempleadoDaoImpl extends
		GenericoDaoImpl<HrEvaluacionempleado, HrEvaluacionempleadoPk> implements
		HrEvaluacionempleadoDao {

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionempleado.class);

	public HrEvaluacionempleadoDaoImpl() {
		super("hrevaluacionempleado");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public void actualizaEvaluacionEmpleado(Integer empleado,
			Integer secuenciaeval) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));

		List<HrEvaluacionempleado> datos = this.listarPorCriterios(cri);

		if (!UValidador.esListaVacia(datos)) {
			HrEvaluacionempleado ee = datos.get(0);
			ee.setEstado("PR");
			this.actualizar(ee);
		}

	}
	
	
	@Override
	public void grabarEvaluacionEmpleado(String estado, Date wFecha,
			BigDecimal wPuntaje, Integer ivEmpleado, Integer ivSecuencia,
			String tipoEvaluador, String companyowner, Integer empleadoevaluador) {

		HrEvaluacionempleado empleado = new HrEvaluacionempleado();
		HrEvaluacionempleadoPk pk = new HrEvaluacionempleadoPk();

		pk.setCompanyowner(companyowner);
		pk.setEmpleado(ivEmpleado);
		pk.setEmpleadoevaluador(empleadoevaluador);
		pk.setSecuenciaeval(ivSecuencia);

		empleado = this.obtenerPorId(pk);

		empleado.setEstado(estado);

		if (!UValidador.esNulo(wFecha))
			empleado.setFechaevaluacion(wFecha);

		if (!UValidador.esNulo(wPuntaje))
			empleado.setTotalpuntos(wPuntaje);

		this.actualizar(empleado);
	}
	

	@Override
	public HrEvaluacionempleado obtenerPorPkEvaluadorDiferente(
			HrEvaluacionempleadoPk pk) {
		List<HrEvaluacionempleado> lista = this.listarPorCriterios(this
				.getCriteria()
				.add(Restrictions.and(
						Restrictions.eq("pk.companyowner",pk.getCompanyowner()), 
						Restrictions.eq("pk.secuenciaeval", pk.getSecuenciaeval()),
						Restrictions.eq("pk.empleado", pk.getEmpleado()),
						Restrictions.ne("pk.empleadoevaluador",	pk.getEmpleadoevaluador()))));

		if (!UValidador.esListaVacia(lista))
			return lista.get(0);

		return null;
	}
	
	
	@Override
	public void grabarEvaluacionCompleta(
			DtoDwHrEmpleadoevaluacionEdit evaluacion) {

		HrEvaluacionempleado empleadoEvaluacion = new HrEvaluacionempleado();
		HrEvaluacionempleadoPk pk = new HrEvaluacionempleadoPk();

		pk.setCompanyowner(evaluacion.getCompanyowner());
		pk.setEmpleado(evaluacion.getEmpleado().intValue());
		pk.setEmpleadoevaluador(evaluacion.getEmpleadoevaluador().intValue());
		pk.setSecuenciaeval(evaluacion.getSecuenciaeval().intValue());

		empleadoEvaluacion = this.obtenerPorId(pk,false);
		if (UValidador.esNulo(empleadoEvaluacion)) {
			empleadoEvaluacion.setPk(pk);
			setearValores(evaluacion, empleadoEvaluacion);
			this.registrar(empleadoEvaluacion);

		} else {
			setearValores(evaluacion, empleadoEvaluacion);
			this.actualizar(empleadoEvaluacion);
		}
	}

	private void setearValores(DtoDwHrEmpleadoevaluacionEdit evaluacion,
			HrEvaluacionempleado empleadoEvaluacion) {
		empleadoEvaluacion.setCentrocostos(evaluacion.getCentrocostos());
		empleadoEvaluacion.setComentario(evaluacion.getComentario());
		empleadoEvaluacion.setComentarioevaluado(evaluacion
				.getComentarioevaluado());
		empleadoEvaluacion.setComentariorevisor(evaluacion
				.getComentariorevisor());
		empleadoEvaluacion.setComentariosupervisor(evaluacion
				.getComentariosupervisor());
		empleadoEvaluacion.setEmpleadogerente(evaluacion.getEmpleadogerente());
		empleadoEvaluacion.setEmpleadosupervisor(evaluacion
				.getEmpleadosupervisor());
		empleadoEvaluacion.setTotalpuntosfuncion(evaluacion
				.getTotalpuntosfuncion());
		empleadoEvaluacion.setTotalpuntospotencial(evaluacion
				.getTotalpuntospotencial());

		empleadoEvaluacion.setEstado(evaluacion.getEstado());
		empleadoEvaluacion.setEvaluado(evaluacion.getEvaluado());
		empleadoEvaluacion.setEvaluador(evaluacion.getEvaluador());
		empleadoEvaluacion.setFechaevaluacion(evaluacion.getFechaevaluacion());
		empleadoEvaluacion.setFlagpresento(evaluacion.getFlagpresento());
		empleadoEvaluacion.setJefeOrgano(evaluacion.getJefe_organo());
		empleadoEvaluacion.setPeriodo(evaluacion.getPeriodo());
		empleadoEvaluacion.setTipoevaluador(evaluacion.getTipoevaluador());
		empleadoEvaluacion.setTotalpuntos(evaluacion.getTotalpuntos());

		empleadoEvaluacion
				.setTotalpuntosmetas(evaluacion.getTotalpuntosmetas());

		empleadoEvaluacion
				.setUltimaFechaModif(evaluacion.getUltimafechamodif());
		empleadoEvaluacion.setUltimoUsuario(evaluacion.getUltimousuario());
		empleadoEvaluacion.setUnidadnegocio(evaluacion.getUnidadnegocio());
	}
	
}
