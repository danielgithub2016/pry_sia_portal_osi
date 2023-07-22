package net.royal.erp.asistencia.servicio.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextraeditV2;
import net.royal.erp.asistencia.dao.AsDetallesigedDao;
import net.royal.erp.asistencia.dominio.AsDetallesiged;
import net.royal.erp.asistencia.dominio.AsDetallesigedPk;
import net.royal.erp.asistencia.dominio.dto.DtoBandejaSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoEmpleadoSIGED;
import net.royal.erp.asistencia.servicio.AsDetallesigedServicio;
import net.royal.erp.core.dao.PersonamastDao;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioAsDetallesiged")
public class AsDetallesigedServicioImpl extends GenericoServicioImpl implements AsDetallesigedServicio {

	private AsDetallesigedDao dao;

	private static Log LOGGER = LogFactory.getLog(AsDetallesigedServicioImpl.class);

	@Autowired
	private PersonamastDao personamastDao;

	@Autowired
	public void setDao(AsDetallesigedDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<AsDetallesiged> listaDetalleSiged(AsDetallesigedPk pk) {
		Criteria cri = dao.getCriteria();

		cri.add(Restrictions.eq("pk.conceptoacceso", pk.getConceptoacceso()));
		cri.add(Restrictions.eq("pk.empleado", pk.getEmpleado()));
		cri.add(Restrictions.eq("pk.fechadesde", pk.getFechadesde()));
		cri.add(Restrictions.eq("pk.fechahasta", pk.getFechahasta()));

		List<AsDetallesiged> lista = dao.listarPorCriterios(cri);

		return lista;
	}

	@Override
	public DtoEmpleadoSIGED obtenerBandejas(DtoEmpleadoSIGED empleadoNuevaBandeja,
			DtoDwAsAutorizacionPreprocesoHextraeditV2 dw_1) {
		AsDetallesigedPk pk = new AsDetallesigedPk();
		pk.setConceptoacceso(dw_1.getConceptoacceso());
		pk.setEmpleado(new BigDecimal(dw_1.getEmpleado()));
		pk.setFechadesde(dw_1.getFecha());
		pk.setFechahasta(dw_1.getFechafin());

		List<AsDetallesiged> detalleRegistrado = this.listaDetalleSiged(pk);

		if (!UValidador.esNulo(empleadoNuevaBandeja)) {
			for (AsDetallesiged detalleguardado : detalleRegistrado) {
				for (DtoBandejaSIGED detalle : empleadoNuevaBandeja.getBandejas()) {
					if (detalle.getIdArea() == detalleguardado.getIdarea().intValue()
							&& detalle.getIdCargo() == detalleguardado.getIdcargo().intValue()) {

						detalle.setIdPersonaSIA(detalleguardado.getIdempleadosia());
						detalle.setNombrePersonaSIA(
								personamastDao.obtenerNombrePersona(detalleguardado.getIdempleadosia()));
						detalle.setSecuencia(detalleguardado.getPk().getSecuencia());
						detalle.setIdPersona(detalleguardado.getIdpersona().intValue());
						detalle.setBlJefe(detalleguardado.getFlgjefe().equals("S") ? true : false);
					}
				}
			}
		}
		return empleadoNuevaBandeja;
	}
}
