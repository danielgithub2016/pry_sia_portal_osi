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
import net.royal.erp.rrhh.dao.HrEmpleadoconsiderapotencialDao;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencialPk;

@Repository
public class HrEmpleadoconsiderapotencialDaoImpl extends GenericoDaoImpl<HrEmpleadoconsiderapotencial, HrEmpleadoconsiderapotencialPk> implements HrEmpleadoconsiderapotencialDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadoconsiderapotencial.class);

	public HrEmpleadoconsiderapotencialDaoImpl() {
		super("hrempleadoconsiderapotencial");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadoconsiderapotencial> obtenerLista(
			String par_companyowner, Integer par_empleado,
			Integer par_secuenciaeval, Integer par_Evaluador) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", par_companyowner));
		cri.add(Restrictions.eq("pk.empleado", par_empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", par_secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", par_Evaluador));
		LOGGER.debug("valores :: "+par_companyowner+par_empleado+par_secuenciaeval+par_Evaluador);
		List datos = this.listarPorCriterios(cri);
		
		if(UValidador.esListaVacia(datos))
			return null;
		
		return datos;
	}
	
	@Override
	public void grabarPotencial(List<HrEmpleadoconsiderapotencial> dw10) {
		for (HrEmpleadoconsiderapotencial dw_10 : dw10) {
			HrEmpleadoconsiderapotencialPk pk = new HrEmpleadoconsiderapotencialPk();
			HrEmpleadoconsiderapotencial empleadoPotencial = new HrEmpleadoconsiderapotencial();

			pk.setCompanyowner(dw_10.getPk().getCompanyowner());
			pk.setEmpleado(dw_10.getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_10.getPk().getEmpleadoevaluador());
			pk.setSecuencia(dw_10.getPk().getSecuencia());
			pk.setSecuenciaeval(dw_10.getPk().getSecuenciaeval());
			
			empleadoPotencial = this.obtenerPorId(pk,false);
			if (UValidador.esNulo(empleadoPotencial)) {
				empleadoPotencial = new HrEmpleadoconsiderapotencial();
				empleadoPotencial.setPk(pk);

				setearValores(dw_10, empleadoPotencial);

				this.registrar(empleadoPotencial);
			} else {
				setearValores(dw_10, empleadoPotencial);
				this.actualizar(empleadoPotencial);
			}
		}

	}

	private void setearValores(HrEmpleadoconsiderapotencial dw_10,
			HrEmpleadoconsiderapotencial empleadoPotencial) {
		empleadoPotencial.setComentario(dw_10.getComentario());
		empleadoPotencial.setConsideracion(dw_10.getConsideracion());
		empleadoPotencial.setFlagconclusion(dw_10.getFlagconclusion());
		empleadoPotencial.setUltimaFechaModif(dw_10.getUltimaFechaModif());
		empleadoPotencial.setUltimoUsuario(dw_10.getUltimoUsuario());

	}


}
