package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dao.HrEmpleadocapaDocumentoDao;
import net.royal.erp.rrhh.dao.HrEmpleadocapacitacionDao;
import net.royal.erp.rrhh.dominio.HrCapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumentoPk;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacion;
import net.royal.erp.rrhh.dominio.HrEmpleadocapacitacionPk;
import net.royal.erp.rrhh.servicio.HrEmpleadocapacitacionServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.MensajeUsuario.tipo_mensaje;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrEmpleadocapacitacion")
public class HrEmpleadocapacitacionServicioImpl extends GenericoServicioImpl implements HrEmpleadocapacitacionServicio {

	private HrEmpleadocapacitacionDao dao;
	private HrEmpleadocapaDocumentoDao daoEmpleadocapaDoc;

	@Autowired
	public void setDao(HrEmpleadocapacitacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setDaoEmpleadocapaDoc(HrEmpleadocapaDocumentoDao daoEmpleadocapaDoc) {
		this.daoEmpleadocapaDoc = daoEmpleadocapaDoc;
	}

	@Override
	public List<MensajeUsuario> ingresarInscripcion(HrCapacitacion capa, UsuarioActual usuario) {
		Date ahora = new Date();
		List<MensajeUsuario> msj = new ArrayList<MensajeUsuario>();
		HrEmpleadocapacitacionPk pk = new HrEmpleadocapacitacionPk();
		pk.setCapacitacion(capa.getPk().getCapacitacion());
		pk.setEmpleado(usuario.getIdPersona());

		if ((ahora.after(capa.getFechadesdeinscripcion()) || ahora.equals(capa.getFechadesdeinscripcion()))
				&& (ahora.before(capa.getFechahastainscripcion()) || ahora.equals(capa.getFechahastainscripcion()))) {
			if (UValidador.esNulo(dao.obtenerPorId(pk))) {
				HrEmpleadocapacitacion emp = new HrEmpleadocapacitacion();
				emp.setPk(pk);
				dao.registrar(emp);
			} else {
				msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Ud. ya se encuentra inscrito en esta capacitación"));
			}
		} else {
			msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Ud. está fuera del rango de fechas de inscripción"));
		}

		return msj;
	}

	@Override
	public List<MensajeUsuario> ingresarDocumentoPendiente(HrCapacitacion capa, UsuarioActual usuario, int tipo,
			HrEmpleadocapaDocumento doc) {
		List<MensajeUsuario> msj = new ArrayList<MensajeUsuario>();
		HrEmpleadocapaDocumentoPk pk = new HrEmpleadocapaDocumentoPk();
		HrEmpleadocapacitacionPk pkEc = new HrEmpleadocapacitacionPk();
		HrEmpleadocapacitacion ec;

		pkEc.setCapacitacion(capa.getPk().getCapacitacion());
		pkEc.setEmpleado(usuario.getIdPersona());

		ec = dao.obtenerPorId(pkEc);

		if (!UValidador.esNulo(ec)) {

			pk.setCapacitacion(capa.getPk().getCapacitacion());
			pk.setEmpleado(usuario.getIdPersona());
			pk.setSecuencia(
					daoEmpleadocapaDoc.generarSecuencia(capa.getPk().getCapacitacion(), usuario.getIdPersona()));
			doc.setPk(pk);

			if (tipo == 1) {
				if (!ConstanteRrhh.TIPO_SI.equals(ec.getFlgadjuntosolicitud())) {
					ec.setFlgadjuntosolicitud(ConstanteRrhh.TIPO_SI);
					daoEmpleadocapaDoc.registrar(doc);
					dao.actualizar(ec);
				} else {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Ud. ya adjunto el documento solicitado."));
				}
			} else if (tipo == 2) {
				if (!ConstanteRrhh.TIPO_SI.equals(ec.getFlgadjuntoinformfinal())) {
					ec.setFlgadjuntoinformfinal(ConstanteRrhh.TIPO_SI);
					daoEmpleadocapaDoc.registrar(doc);
					dao.actualizar(ec);
				} else {
					msj.add(new MensajeUsuario(tipo_mensaje.ERROR, "Ud. ya adjunto el documento solicitado."));
				}
			}

		}

		return msj;
	}
	
	
	@Override
	public List<HrEmpleadocapacitacion> contarCapacitacionDocumentoPendiente(Integer empleado, Integer dias_revision) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("empleado", Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico("dias_revision", Integer.class, dias_revision));
		
		List datos=dao.listarPorQuery(HrEmpleadocapacitacion.class, "hrempleadocapacitacion.contarCapacitacionDocumentoPendiente", parametros);
		return datos;
	}

	@Override
	public List<HrEmpleadocapacitacion> obtenerPorCapacitacion(String capacitacion) {
		return dao.obtenerPorCapacitacion(capacitacion);
	}

}
