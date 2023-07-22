package net.royal.erp.core.factory;

import net.royal.erp.core.servicio.AccountmstServicio;
import net.royal.erp.core.servicio.AfemstServicio;
import net.royal.erp.core.servicio.AfetypemstServicio;
import net.royal.erp.core.servicio.BancoServicio;
import net.royal.erp.core.servicio.ColormastServicio;
import net.royal.erp.core.servicio.CompaniadistribucionsplitcxpServicio;
import net.royal.erp.core.servicio.CompaniamastServicio;
import net.royal.erp.core.servicio.CompanyownerServicio;
import net.royal.erp.core.servicio.CorrelativosmastServicio;
import net.royal.erp.core.servicio.CorreoServicio;
import net.royal.erp.core.servicio.CuentabancariaServicio;
import net.royal.erp.core.servicio.DepartmentmstServicio;
import net.royal.erp.core.servicio.EmpleadomastServicio;
import net.royal.erp.core.servicio.MaCtsServicio;
import net.royal.erp.core.servicio.MaMiscelaneosdetalleServicio;
import net.royal.erp.core.servicio.MaMiscelaneosheaderServicio;
import net.royal.erp.core.servicio.MaPersonacentrocostoautorizacServicio;
import net.royal.erp.core.servicio.MaPersonagrupoServicio;
import net.royal.erp.core.servicio.MaUnidadnegocioServicio;
import net.royal.erp.core.servicio.ObligacionesServicio;
import net.royal.erp.core.servicio.ObligacionesxcuentaServicio;
import net.royal.erp.core.servicio.ObligacionesximpuestoServicio;
import net.royal.erp.core.servicio.OrdenpagoServicio;
import net.royal.erp.core.servicio.PaisServicio;
import net.royal.erp.core.servicio.ParametrosmastServicio;
import net.royal.erp.core.servicio.PersonamastServicio;
import net.royal.erp.core.servicio.PrimemstServicio;
import net.royal.erp.core.servicio.ProveedormastServicio;
import net.royal.erp.core.servicio.ReferencefieldmstServicio;
import net.royal.erp.core.servicio.ReferencefieldvaluesServicio;
import net.royal.erp.core.servicio.ResponsiblemstServicio;
import net.royal.erp.core.servicio.ServicioximpuestoServicio;
import net.royal.erp.core.servicio.TipocambiomastServicio;
import net.royal.erp.core.servicio.TipodocumentocxpServicio;
import net.royal.erp.core.servicio.TipopagoServicio;
import net.royal.erp.core.servicio.TiposervicioServicio;
import net.royal.erp.core.servicio.UltimonumeropagoServicio;
import net.royal.erp.core.servicio.UnidadesmastServicio;

public interface FactoryErpCore {
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Accountmst
	 */
	public AccountmstServicio getAccountmstServicio();

	public void setAccountmstServicio(AccountmstServicio accountmstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Afemst
	 */
	public AfemstServicio getAfemstServicio();

	public void setAfemstServicio(AfemstServicio afemstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Afetypemst
	 */
	public AfetypemstServicio getAfetypemstServicio();

	public void setAfetypemstServicio(AfetypemstServicio afetypemstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Colormast
	 */
	public ColormastServicio getColormastServicio();

	public void setColormastServicio(ColormastServicio colormastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Companiamast
	 */
	public CompaniamastServicio getCompaniamastServicio();

	public void setCompaniamastServicio(
			CompaniamastServicio companiamastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Companyowner
	 */
	public CompanyownerServicio getCompanyownerServicio();

	public void setCompanyownerServicio(
			CompanyownerServicio companyownerServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Departmentmst
	 */
	public DepartmentmstServicio getDepartmentmstServicio();

	public void setDepartmentmstServicio(
			DepartmentmstServicio departmentmstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Empleadomast
	 */
	public EmpleadomastServicio getEmpleadomastServicio();

	public void setEmpleadomastServicio(
			EmpleadomastServicio empleadomastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.MaMiscelaneosdetalle
	 */
	public MaMiscelaneosdetalleServicio getMaMiscelaneosdetalleServicio();

	public void setMaMiscelaneosdetalleServicio(
			MaMiscelaneosdetalleServicio maMiscelaneosdetalleServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.MaPersonacentrocostoautorizac
	 */
	public MaPersonacentrocostoautorizacServicio getMaPersonacentrocostoautorizacServicio();

	public void setMaPersonacentrocostoautorizacServicio(
			MaPersonacentrocostoautorizacServicio maPersonacentrocostoautorizacServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.MaUnidadnegocio
	 */
	public MaUnidadnegocioServicio getMaUnidadnegocioServicio();

	public void setMaUnidadnegocioServicio(
			MaUnidadnegocioServicio maUnidadnegocioServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Parametrosmast
	 */
	public ParametrosmastServicio getParametrosmastServicio();

	public void setParametrosmastServicio(
			ParametrosmastServicio parametrosmastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Personamast
	 */
	public PersonamastServicio getPersonamastServicio();

	public void setPersonamastServicio(PersonamastServicio personamastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Referencefieldmst
	 */
	public ReferencefieldmstServicio getReferencefieldmstServicio();

	public void setReferencefieldmstServicio(
			ReferencefieldmstServicio referencefieldmstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Referencefieldvalues
	 */
	public ReferencefieldvaluesServicio getReferencefieldvaluesServicio();

	public void setReferencefieldvaluesServicio(
			ReferencefieldvaluesServicio referencefieldvaluesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Responsiblemst
	 */
	public ResponsiblemstServicio getResponsiblemstServicio();

	public void setResponsiblemstServicio(
			ResponsiblemstServicio responsiblemstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Tipocambiomast
	 */
	public TipocambiomastServicio getTipocambiomastServicio();

	public void setTipocambiomastServicio(
			TipocambiomastServicio tipocambiomastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Tipodocumentocxp
	 */
	public TipodocumentocxpServicio getTipodocumentocxpServicio();

	public void setTipodocumentocxpServicio(
			TipodocumentocxpServicio tipodocumentocxpServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Tipopago
	 */
	public TipopagoServicio getTipopagoServicio();

	public void setTipopagoServicio(TipopagoServicio tipopagoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Tiposervicio
	 */
	public TiposervicioServicio getTiposervicioServicio();

	public void setTiposervicioServicio(
			TiposervicioServicio tiposervicioServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Unidadesmast
	 */
	public UnidadesmastServicio getUnidadesmastServicio();

	public void setUnidadesmastServicio(
			UnidadesmastServicio unidadesmastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Ultimonumeropago
	 */
	public UltimonumeropagoServicio getUltimonumeropagoServicio();

	public void setUltimonumeropagoServicio(
			UltimonumeropagoServicio ultimonumeropagoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Servicioximpuesto
	 */
	public ServicioximpuestoServicio getServicioximpuestoServicio();

	public void setServicioximpuestoServicio(
			ServicioximpuestoServicio servicioximpuestoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Proveedormast
	 */
	public ProveedormastServicio getProveedormastServicio();

	public void setProveedormastServicio(
			ProveedormastServicio proveedormastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Primemst
	 */
	public PrimemstServicio getPrimemstServicio();

	public void setPrimemstServicio(PrimemstServicio primemstServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Ordenpago
	 */
	public OrdenpagoServicio getOrdenpagoServicio();

	public void setOrdenpagoServicio(OrdenpagoServicio ordenpagoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Obligacionesximpuesto
	 */
	public ObligacionesximpuestoServicio getObligacionesximpuestoServicio();

	public void setObligacionesximpuestoServicio(
			ObligacionesximpuestoServicio obligacionesximpuestoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Obligacionesxcuenta
	 */
	public ObligacionesxcuentaServicio getObligacionesxcuentaServicio();

	public void setObligacionesxcuentaServicio(
			ObligacionesxcuentaServicio obligacionesxcuentaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Obligaciones
	 */
	public ObligacionesServicio getObligacionesServicio();

	public void setObligacionesServicio(
			ObligacionesServicio obligacionesServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Cuentabancaria
	 */
	public CuentabancariaServicio getCuentabancariaServicio();

	public void setCuentabancariaServicio(
			CuentabancariaServicio cuentabancariaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Correlativosmast
	 */
	public CorrelativosmastServicio getCorrelativosmastServicio();

	public void setCorrelativosmastServicio(
			CorrelativosmastServicio correlativosmastServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Companiadistribucionsplitcxp
	 */
	public CompaniadistribucionsplitcxpServicio getCompaniadistribucionsplitcxpServicio();

	public void setCompaniadistribucionsplitcxpServicio(
			CompaniadistribucionsplitcxpServicio companiadistribucionsplitcxpServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Banco
	 */
	public BancoServicio getBancoServicio();

	public void setBancoServicio(BancoServicio bancoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.MaMiscelaneosheader
	 */
	public MaMiscelaneosheaderServicio getMaMiscelaneosheaderServicio();

	public void setMaMiscelaneosheaderServicio(
			MaMiscelaneosheaderServicio maMiscelaneosheaderServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.MaCts
	 */
	public MaCtsServicio getMaCtsServicio();

	public void setMaCtsServicio(MaCtsServicio maCtsServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.Pais
	 */
	public PaisServicio getPaisServicio();

	public void setPaisServicio(PaisServicio paisServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder core.MaPersonagrupo
	 */
	public MaPersonagrupoServicio getMaPersonagrupoServicio();

	public void setMaPersonagrupoServicio(
			MaPersonagrupoServicio maPersonagrupoServicio);
	
	public CorreoServicio getCorreoServicio();

	public void setCorreoServicio(
			CorreoServicio correoServicio);
	
	
	
}
