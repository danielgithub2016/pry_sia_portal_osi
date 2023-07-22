package net.royal.rrhh;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.presupuesto.dominio.BuCertificacion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@ManagedBean
@SessionScoped
public class CwBuCertificacionSelect extends CBaseBean implements
		UIMantenimientoController {
	private List<BuCertificacion> dw_list;
	private ListDataModel<BuCertificacion> dw_listdatamodel;
	

	public static CwBuCertificacionSelect getInstance() {
		return UFaces.evaluateExpressionGet("#{cwBuCertificacionSelect}",
				CwBuCertificacionSelect.class);
	}

	@Override
	public String iniciarControladora() throws Exception {

		inicializarFiltrosListado();
		getWebControlContext().ejecutar(
				"PF('popSelectorCertificacionSelect').show();");
		getWebControlContext().actualizar("dgSelectorCertificacionSelect");
		return null;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		LOGGER.debug("DATOS DEL MENSAJE");
		LOGGER.debug("AGREGANDO DATOS EN DURO");

		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BuCertificacion> getDw_list() {
		return dw_list;
	}

	public ListDataModel<BuCertificacion> getDw_listdatamodel() {
		return dw_listdatamodel;
	}

	public void setDw_list(List<BuCertificacion> dw_list) {
		this.dw_list = dw_list;
	}

	public void setDw_listdatamodel(ListDataModel<BuCertificacion> dw_listdatamodel) {
		this.dw_listdatamodel = dw_listdatamodel;
	}

}
