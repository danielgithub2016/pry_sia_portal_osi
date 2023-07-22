package net.royal.comun.vista.controladora;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.core.dominio.Departmentmst;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrCentroestudios;
import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.dominio.HrProfesion;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.sistema.dominio.SyUnidadreplicacion;
import net.royal.framework.web.core.UFaces;

@ManagedBean
@ApplicationScoped
@SuppressWarnings("unchecked")
public class CComun {
	private List<HrCentroestudios> listaHrCentroEstudios;
	private List<HrPuestoempresa> listHrPuestoEmpresa;
	private List<MaMiscelaneosdetalle> listaInformatica;
	private List<MaMiscelaneosdetalle> listaMotivoRetiro;
	private List<MaMiscelaneosdetalle> listaAreaExperiencia;
	private List<MaMiscelaneosdetalle> listaTipoExperiencia;
	private List<MaMiscelaneosdetalle> listTipoEntidad;
	private List<MaMiscelaneosdetalle> listaTipoCurso;
	private List<MaMiscelaneosdetalle> listaDocumentos;
	private List<MaMiscelaneosdetalle> listaTipoCalle;
	private List<MaMiscelaneosdetalle> listaTipoZona;
	private List<MaMiscelaneosdetalle> listaTipoDocumentoIdentidad;
	private List<MaMiscelaneosdetalle> listaTipoBrevete;
	private List<MaMiscelaneosdetalle> listaTipoVinculo;
	private List<HrGradosalariomast> listaTipoRangoRemunerativo;
	private List<HrCargosmast> listaTipoCargo;
	private List<HrProfesion> listaHrProfesion;
	private List<MaMiscelaneosdetalle> listaColegioProfesional;
	private List<MaMiscelaneosdetalle> listaAreaProfesional;
	private List<MaMiscelaneosdetalle> listaTipoFamilia;
	private List<MaUnidadnegocio> lstpreferenciasUnidad;
	private List<SyUnidadreplicacion> lstunidadReplicacion;
	private List<AcCostcentermst> lstCentroCosto;
	private List<Departmentmst> lstDepartamento;

	public List<MaUnidadnegocio> getLstpreferenciasUnidad() {
		if (lstpreferenciasUnidad == null) {
			lstpreferenciasUnidad = CComunGlobal.getInstance().getFacCore()
					.getMaUnidadnegocioServicio().listarUnidadNegocio(null);
		}

		return lstpreferenciasUnidad;
	}

	public void setLstpreferenciasUnidad(
			List<MaUnidadnegocio> lstpreferenciasUnidad) {
		this.lstpreferenciasUnidad = lstpreferenciasUnidad;
	}

	public static CComun getInstance() {
		return UFaces.getControladora("cComun", CComun.class);
	}

	public List<MaMiscelaneosdetalle> getListaInformatica() {
		if (listaInformatica == null) {
			listaInformatica = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "INFORMAT", null);
		}
		return listaInformatica;
	}

	public void setListaInformatica(List<MaMiscelaneosdetalle> listaInformatica) {
		this.listaInformatica = listaInformatica;
	}

	public List<MaMiscelaneosdetalle> getListaMotivoRetiro() {
		if (listaMotivoRetiro == null) {
			listaMotivoRetiro = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "MOTIVOCESE", null);
		}
		return listaMotivoRetiro;
	}

	public void setListaMotivoRetiro(
			List<MaMiscelaneosdetalle> listaMotivoRetiro) {
		this.listaMotivoRetiro = listaMotivoRetiro;
	}

	public List<MaMiscelaneosdetalle> getListaAreaExperiencia() {
		if (listaAreaExperiencia == null) {
			listaAreaExperiencia = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "AREAEXPER", null);
		}
		return listaAreaExperiencia;
	}

	public void setListaAreaExperiencia(
			List<MaMiscelaneosdetalle> listaAreaExperiencia) {
		this.listaAreaExperiencia = listaAreaExperiencia;
	}

	public List<MaMiscelaneosdetalle> getListaTipoExperiencia() {
		if (listaTipoExperiencia == null) {
			listaTipoExperiencia = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOEXPER", null);
		}
		return listaTipoExperiencia;
	}

	public void setListaTipoExperiencia(
			List<MaMiscelaneosdetalle> listaTipoExperiencia) {
		this.listaTipoExperiencia = listaTipoExperiencia;
	}

	public List<MaMiscelaneosdetalle> getListTipoEntidad() {
		if (listTipoEntidad == null) {
			listTipoEntidad = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOENTID", null);
		}
		return listTipoEntidad;
	}

	public void setListTipoEntidad(List<MaMiscelaneosdetalle> listTipoEntidad) {
		this.listTipoEntidad = listTipoEntidad;
	}

	public List<HrPuestoempresa> getListHrPuestoEmpresa() {
		if (listHrPuestoEmpresa == null) {
			listHrPuestoEmpresa = CComunGlobal.getInstance().getFacRrhh()
					.getHrPuestoempresaServicio().listarActivos();
		}

		return listHrPuestoEmpresa;
	}

	public void setListHrPuestoEmpresa(List<HrPuestoempresa> listHrPuestoEmpresa) {
		this.listHrPuestoEmpresa = listHrPuestoEmpresa;
	}

	public List<MaMiscelaneosdetalle> getListaTipoCurso() {
		if (listaTipoCurso == null) {
			listaTipoCurso = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOCURSO", null);
		}
		return listaTipoCurso;
	}

	public void setListaTipoCurso(List<MaMiscelaneosdetalle> listaTipoCurso) {
		this.listaTipoCurso = listaTipoCurso;
	}

	public List<HrCentroestudios> getListaHrCentroEstudios() {
		if (listaHrCentroEstudios == null) {
			listaHrCentroEstudios = CComunGlobal.getInstance().getFacRrhh()
					.getHrCentroestudiosServicio().listarCentroEstudios();
		}
		return listaHrCentroEstudios;
	}

	public void setListaHrCentroEstudios(
			List<HrCentroestudios> listaHrCentroEstudios) {
		this.listaHrCentroEstudios = listaHrCentroEstudios;
	}

	public List<HrProfesion> getListaHrProfesion() {
		if (listaHrProfesion == null) {
			listaHrProfesion = CComunGlobal.getInstance().getFacRrhh()
					.getHrProfesionServicio().listarProfesion();
		}
		return listaHrProfesion;
	}

	public void setListaHrProfesion(List<HrProfesion> listaHrProfesion) {
		this.listaHrProfesion = listaHrProfesion;
	}

	public List<MaMiscelaneosdetalle> getListaColegioProfesional() {
		if (listaColegioProfesional == null) {
			listaColegioProfesional = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "COLEGIOSPR", null);
		}

		return listaColegioProfesional;
	}

	public void setListaColegioProfesional(
			List<MaMiscelaneosdetalle> listaColegioProfesional) {
		this.listaColegioProfesional = listaColegioProfesional;
	}

	public List<MaMiscelaneosdetalle> getListaAreaProfesional() {
		if (listaAreaProfesional == null) {
			listaAreaProfesional = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "AREAS", null);
		}
		return listaAreaProfesional;
	}

	public void setListaAreaProfesional(
			List<MaMiscelaneosdetalle> listaAreaProfesional) {
		this.listaAreaProfesional = listaAreaProfesional;
	}

	public List<MaMiscelaneosdetalle> getListaDocumentos() {
		if (listaDocumentos == null) {
			listaDocumentos = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "DOCUMENTOS", null);
		}
		return listaDocumentos;
	}

	public void setListaDocumentos(List<MaMiscelaneosdetalle> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}

	public List<MaMiscelaneosdetalle> getListaTipoCalle() {
		if (listaTipoCalle == null) {
			listaTipoCalle = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOVIAS", null);
		}
		return listaTipoCalle;
	}

	public void setListaTipoCalle(List<MaMiscelaneosdetalle> listaTipoCalle) {
		this.listaTipoCalle = listaTipoCalle;
	}

	public List<MaMiscelaneosdetalle> getListaTipoZona() {
		if (listaTipoZona == null) {
			listaTipoZona = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOZONA", null);
		}
		return listaTipoZona;
	}

	public void setListaTipoZona(List<MaMiscelaneosdetalle> listaTipoZona) {
		this.listaTipoZona = listaTipoZona;
	}

	public List<MaMiscelaneosdetalle> getListaTipoDocumentoIdentidad() {
		if (listaTipoDocumentoIdentidad == null) {
			listaTipoDocumentoIdentidad = CComunGlobal.getInstance()
					.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPODOCI", null);
		}
		return listaTipoDocumentoIdentidad;
	}

	public void setListaTipoDocumentoIdentidad(
			List<MaMiscelaneosdetalle> listaTipoDocumentoIdentidad) {
		this.listaTipoDocumentoIdentidad = listaTipoDocumentoIdentidad;
	}

	public List<MaMiscelaneosdetalle> getListaTipoBrevete() {
		if (listaTipoBrevete == null) {
			listaTipoBrevete = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOBREV", null);
		}
		return listaTipoBrevete;
	}

	public void setListaTipoBrevete(List<MaMiscelaneosdetalle> listaTipoBrevete) {
		this.listaTipoBrevete = listaTipoBrevete;
	}

	public List<MaMiscelaneosdetalle> getListaTipoVinculo() {
		if (listaTipoVinculo == null) {
			listaTipoVinculo = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "TIPOVINC", null);
		}
		return listaTipoVinculo;
	}

	public void setListaTipoVinculo(List<MaMiscelaneosdetalle> listaTipoVinculo) {
		this.listaTipoVinculo = listaTipoVinculo;
	}

	public List<HrGradosalariomast> getListaTipoRangoRemunerativo() {
		if (listaTipoRangoRemunerativo == null) {
			listaTipoRangoRemunerativo = CComunGlobal.getInstance()
					.getFacRrhh().getHrGradosalariomastServicio()
					.listarGradoSalario();
		}
		return listaTipoRangoRemunerativo;
	}

	public void setListaTipoRangoRemunerativo(
			List<HrGradosalariomast> listaTipoRangoRemunerativo) {
		this.listaTipoRangoRemunerativo = listaTipoRangoRemunerativo;
	}

	public List<HrCargosmast> getListaTipoCargo() {
		if (listaTipoCargo == null) {
			listaTipoCargo = CComunGlobal.getInstance().getFacRrhh()
					.getHrCargosmastServicio().ListarCargosmast();
		}
		return listaTipoCargo;
	}

	public void setListaTipoCargo(List<HrCargosmast> listaTipoCargo) {
		this.listaTipoCargo = listaTipoCargo;
	}

	public List<MaMiscelaneosdetalle> getListaTipoFamilia() {
		if (listaTipoFamilia == null) {
			listaTipoFamilia = CComunGlobal.getInstance().getFacCore()
					.getMaMiscelaneosdetalleServicio()
					.listarPorEjemplo("HR", "FAMPUESEVA", "999999");
		}
		return listaTipoFamilia;
	}

	public void setListaTipoFamilia(List<MaMiscelaneosdetalle> listaTipoFamilia) {
		this.listaTipoFamilia = listaTipoFamilia;
	}

	public List<SyUnidadreplicacion> getLstunidadReplicacion() {
		if (lstunidadReplicacion == null) {
			lstunidadReplicacion = CComunGlobal.getInstance().getFacSistema()
					.getSyUnidadreplicacionServicio().listaUnidadReplicacion();
		}

		return lstunidadReplicacion;
	}

	public void setLstunidadReplicacion(
			List<SyUnidadreplicacion> lstunidadReplicacion) {
		this.lstunidadReplicacion = lstunidadReplicacion;
	}

	/**
	 * @return the lstCentroCosto
	 */
	public List<AcCostcentermst> getLstCentroCosto() {
		if (lstCentroCosto == null) {
			lstCentroCosto = CComunGlobal.getInstance().getFacContabilidad()
					.getAcCostcentermstServicio().listaComboCentroCosto();
		}
		return lstCentroCosto;
	}

	/**
	 * @param lstCentroCosto
	 *            the lstCentroCosto to set
	 */
	public void setLstCentroCosto(List<AcCostcentermst> lstCentroCosto) {
		this.lstCentroCosto = lstCentroCosto;
	}

	/**
	 * @return the lstDepartamento
	 */
	public List<Departmentmst> getLstDepartamento() {
		return lstDepartamento;
	}

	/**
	 * @param lstDepartamento
	 *            the lstDepartamento to set
	 */
	public void setLstDepartamento(List<Departmentmst> lstDepartamento) {
		this.lstDepartamento = lstDepartamento;
	}

}
