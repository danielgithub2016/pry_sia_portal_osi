package net.royal.rrhh.vista.controladora;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrCapacitacion;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SessionScoped
@ManagedBean
public class CHrCapacitacionPublica extends CBaseBean implements UIMantenimientoController {

	private static final long serialVersionUID = 1L;

	private List<DtoHrCapacitacion> lstDatos;
	private DtoHrCapacitacion registroSeleccionado;
	private String curso;

	public static CHrCapacitacionPublica getInstance() {
		return UFaces.evaluateExpressionGet("#{cHrCapacitacionPublica}", CHrCapacitacionPublica.class);
	}

	public CHrCapacitacionPublica() {
		this.PANTALLA_LISTADO = "capacitaciones_publicadas";
		this.PANTALLA_MANTENIMIENTO = "";
	}

	@Override
	public String iniciarControladora() throws Exception {
		this.buscar();
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		if(UValidador.esNulo(curso) || UValidador.estaVacio(curso) ){
			curso=null;
		}
		
		String tipoRegistro=this.getFacCore()
				.getParametrosmastServicio()
				.obtenerValorCadena(new ParametrosmastPk("HR", "999999", "REGISTIPO"));
		
		String[] palabrasSeparadas = tipoRegistro.split(",");
		String tipos="";
		
		for(int i=0;i<palabrasSeparadas.length;i++){
			tipos=tipos+"'"+palabrasSeparadas[i]+"',";
		}
		
		tipos=tipos.substring(0,tipos.length()-1);
		
		lstDatos = this.getFacRrhh().getHrCapacitacionServicio() 
				.listarCapacitacionPublicadas(tipos, curso);
		
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		return null;
	}

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public String ver() throws Exception {
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		return null;
	}

	@Override
	public String guardar() throws Exception {
		return null;
	}

	@Override
	public String salir() throws Exception {
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public List<DtoHrCapacitacion> getLstDatos() {
		return lstDatos;
	}

	public void setLstDatos(List<DtoHrCapacitacion> lstDatos) {
		this.lstDatos = lstDatos;
	}

	public DtoHrCapacitacion getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DtoHrCapacitacion registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	
	
}
