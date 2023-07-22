package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dao.HrCapacitacionDao;
import net.royal.erp.rrhh.dao.HrEmpleadocapacitacionDao;
import net.royal.erp.rrhh.dao.HrEncuestaDao;
import net.royal.erp.rrhh.dao.HrEncuestasujetoDao;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrCapacitacionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEncuesta;
import net.royal.erp.rrhh.dominio.HrEncuestaPk;
import net.royal.erp.rrhh.dominio.HrEncuestasujeto;
import net.royal.erp.rrhh.dominio.HrEncuestasujetoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrEncuestasujetoDaoImpl extends GenericoDaoImpl<HrEncuestasujeto, HrEncuestasujetoPk>
		implements HrEncuestasujetoDao {

	@Autowired
	private HrEncuestaDao daoHrEncuesta;
	@Autowired
	private HrEmpleadocapacitacionDao daoEmpleadoCapacitacion;
	@Autowired
	private HrCapacitacionDao daoCapacitacion;

	public HrEncuestasujetoDaoImpl() {
		super("hrencuestasujeto");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer obtenerNuevoSujeto(Integer secuencia) {
		return this.incrementarInteger(this.getCriteria().add(Restrictions.eq("pk.secuencia", secuencia))
				.setProjection(Projections.projectionList().add(Projections.max("pk.sujeto"))));
	}

	@Override
	@Transactional
	public void registrarSujeto(DtoHrEncuesta encuestaDto, List<HrEncuestasujeto> sujeto) {

		HrEncuesta encuesta;
		HrEncuestaPk pkEncuesta;

		for (HrEncuestasujeto hrEncuestasujeto : sujeto)
			this.registrar(hrEncuestasujeto);

		pkEncuesta = new HrEncuestaPk();
		pkEncuesta.setCompanyowner(encuestaDto.getCompanyowner());
		pkEncuesta.setPeriodo(encuestaDto.getPeriodo());
		pkEncuesta.setSecuencia(encuestaDto.getSecuencia().intValue());

		encuesta = this.daoHrEncuesta.obtenerPorId(pkEncuesta, false);

		if (UValidador.esNulo(encuesta.getMuestra()))
			encuesta.setMuestra(0);

		encuesta.setMuestra(encuesta.getMuestra() + 1);
		
		if (ConstanteRrhh.ENCUESTA_TIPO_CAPACITACION
				.equalsIgnoreCase(encuesta.getTipoencuesta())) {
			List<HrEmpleadocapacitacion> listaEmpleadosCapa = 
					daoEmpleadoCapacitacion.obtenerPorCapacitacion(encuesta.getCapacitacion());
			
			Integer totalParticipantes = 0;
			
			if (!UValidador.esNulo(listaEmpleadosCapa)) {
				totalParticipantes = listaEmpleadosCapa.size();
			}
			
			System.out.println("Total Participantes CAPA : " + 
					encuesta.getCapacitacion() + " = " +  totalParticipantes);
			
			System.out.println("Muestra : " + encuesta.getMuestra());
			
			if (encuesta.getMuestra() == totalParticipantes) {
				// Actualizamos el estado de la capacitacion
				HrCapacitacionPk pkCapa = new HrCapacitacionPk();
				pkCapa.setCompanyowner(encuestaDto.getCompanyowner());
				pkCapa.setCapacitacion(encuesta.getCapacitacion());
				HrCapacitacion cap = daoCapacitacion.obtenerPorId(pkCapa);
				
				if (!UValidador.esNulo(cap)) {
					cap.setEstado("L");
					daoCapacitacion.actualizar(cap);
				}
				
				//encuesta.setEstado("L");
			}
			
		}
		
		daoHrEncuesta.actualizar(encuesta);

	}

}
