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

public class FactoryErpCoreImpl implements FactoryErpCore {
	private AccountmstServicio accountmstServicio;

	@Override
	public AccountmstServicio getAccountmstServicio() {
		return accountmstServicio;
	}

	@Override
	public void setAccountmstServicio(AccountmstServicio accountmstServicio) {
		this.accountmstServicio = accountmstServicio;
	}

	private AfemstServicio afemstServicio;

	@Override
	public AfemstServicio getAfemstServicio() {
		return afemstServicio;
	}

	@Override
	public void setAfemstServicio(AfemstServicio afemstServicio) {
		this.afemstServicio = afemstServicio;
	}

	private AfetypemstServicio afetypemstServicio;

	@Override
	public AfetypemstServicio getAfetypemstServicio() {
		return afetypemstServicio;
	}

	@Override
	public void setAfetypemstServicio(AfetypemstServicio afetypemstServicio) {
		this.afetypemstServicio = afetypemstServicio;
	}

	private ColormastServicio colormastServicio;

	@Override
	public ColormastServicio getColormastServicio() {
		return colormastServicio;
	}

	@Override
	public void setColormastServicio(ColormastServicio colormastServicio) {
		this.colormastServicio = colormastServicio;
	}

	private CompaniamastServicio companiamastServicio;

	@Override
	public CompaniamastServicio getCompaniamastServicio() {
		return companiamastServicio;
	}

	@Override
	public void setCompaniamastServicio(
			CompaniamastServicio companiamastServicio) {
		this.companiamastServicio = companiamastServicio;
	}

	private CompanyownerServicio companyownerServicio;

	@Override
	public CompanyownerServicio getCompanyownerServicio() {
		return companyownerServicio;
	}

	@Override
	public void setCompanyownerServicio(
			CompanyownerServicio companyownerServicio) {
		this.companyownerServicio = companyownerServicio;
	}

	private DepartmentmstServicio departmentmstServicio;

	@Override
	public DepartmentmstServicio getDepartmentmstServicio() {
		return departmentmstServicio;
	}

	@Override
	public void setDepartmentmstServicio(
			DepartmentmstServicio departmentmstServicio) {
		this.departmentmstServicio = departmentmstServicio;
	}

	private EmpleadomastServicio empleadomastServicio;

	@Override
	public EmpleadomastServicio getEmpleadomastServicio() {
		return empleadomastServicio;
	}

	@Override
	public void setEmpleadomastServicio(
			EmpleadomastServicio empleadomastServicio) {
		this.empleadomastServicio = empleadomastServicio;
	}

	private MaMiscelaneosdetalleServicio maMiscelaneosdetalleServicio;

	@Override
	public MaMiscelaneosdetalleServicio getMaMiscelaneosdetalleServicio() {
		return maMiscelaneosdetalleServicio;
	}

	@Override
	public void setMaMiscelaneosdetalleServicio(
			MaMiscelaneosdetalleServicio maMiscelaneosdetalleServicio) {
		this.maMiscelaneosdetalleServicio = maMiscelaneosdetalleServicio;
	}

	private MaPersonacentrocostoautorizacServicio maPersonacentrocostoautorizacServicio;

	@Override
	public MaPersonacentrocostoautorizacServicio getMaPersonacentrocostoautorizacServicio() {
		return maPersonacentrocostoautorizacServicio;
	}

	@Override
	public void setMaPersonacentrocostoautorizacServicio(
			MaPersonacentrocostoautorizacServicio maPersonacentrocostoautorizacServicio) {
		this.maPersonacentrocostoautorizacServicio = maPersonacentrocostoautorizacServicio;
	}

	private MaUnidadnegocioServicio maUnidadnegocioServicio;

	@Override
	public MaUnidadnegocioServicio getMaUnidadnegocioServicio() {
		return maUnidadnegocioServicio;
	}

	@Override
	public void setMaUnidadnegocioServicio(
			MaUnidadnegocioServicio maUnidadnegocioServicio) {
		this.maUnidadnegocioServicio = maUnidadnegocioServicio;
	}

	private ParametrosmastServicio parametrosmastServicio;

	@Override
	public ParametrosmastServicio getParametrosmastServicio() {
		return parametrosmastServicio;
	}

	@Override
	public void setParametrosmastServicio(
			ParametrosmastServicio parametrosmastServicio) {
		this.parametrosmastServicio = parametrosmastServicio;
	}

	private PersonamastServicio personamastServicio;

	@Override
	public PersonamastServicio getPersonamastServicio() {
		return personamastServicio;
	}

	@Override
	public void setPersonamastServicio(PersonamastServicio personamastServicio) {
		this.personamastServicio = personamastServicio;
	}

	private ReferencefieldmstServicio referencefieldmstServicio;

	@Override
	public ReferencefieldmstServicio getReferencefieldmstServicio() {
		return referencefieldmstServicio;
	}

	@Override
	public void setReferencefieldmstServicio(
			ReferencefieldmstServicio referencefieldmstServicio) {
		this.referencefieldmstServicio = referencefieldmstServicio;
	}

	private ReferencefieldvaluesServicio referencefieldvaluesServicio;

	@Override
	public ReferencefieldvaluesServicio getReferencefieldvaluesServicio() {
		return referencefieldvaluesServicio;
	}

	@Override
	public void setReferencefieldvaluesServicio(
			ReferencefieldvaluesServicio referencefieldvaluesServicio) {
		this.referencefieldvaluesServicio = referencefieldvaluesServicio;
	}

	private ResponsiblemstServicio responsiblemstServicio;

	@Override
	public ResponsiblemstServicio getResponsiblemstServicio() {
		return responsiblemstServicio;
	}

	@Override
	public void setResponsiblemstServicio(
			ResponsiblemstServicio responsiblemstServicio) {
		this.responsiblemstServicio = responsiblemstServicio;
	}

	private TipocambiomastServicio tipocambiomastServicio;

	@Override
	public TipocambiomastServicio getTipocambiomastServicio() {
		return tipocambiomastServicio;
	}

	@Override
	public void setTipocambiomastServicio(
			TipocambiomastServicio tipocambiomastServicio) {
		this.tipocambiomastServicio = tipocambiomastServicio;
	}

	private TipodocumentocxpServicio tipodocumentocxpServicio;

	@Override
	public TipodocumentocxpServicio getTipodocumentocxpServicio() {
		return tipodocumentocxpServicio;
	}

	@Override
	public void setTipodocumentocxpServicio(
			TipodocumentocxpServicio tipodocumentocxpServicio) {
		this.tipodocumentocxpServicio = tipodocumentocxpServicio;
	}

	private TipopagoServicio tipopagoServicio;

	@Override
	public TipopagoServicio getTipopagoServicio() {
		return tipopagoServicio;
	}

	@Override
	public void setTipopagoServicio(TipopagoServicio tipopagoServicio) {
		this.tipopagoServicio = tipopagoServicio;
	}

	private TiposervicioServicio tiposervicioServicio;

	@Override
	public TiposervicioServicio getTiposervicioServicio() {
		return tiposervicioServicio;
	}

	@Override
	public void setTiposervicioServicio(
			TiposervicioServicio tiposervicioServicio) {
		this.tiposervicioServicio = tiposervicioServicio;
	}

	private UnidadesmastServicio unidadesmastServicio;

	@Override
	public UnidadesmastServicio getUnidadesmastServicio() {
		return unidadesmastServicio;
	}

	@Override
	public void setUnidadesmastServicio(
			UnidadesmastServicio unidadesmastServicio) {
		this.unidadesmastServicio = unidadesmastServicio;
	}

	private UltimonumeropagoServicio ultimonumeropagoServicio;

	@Override
	public UltimonumeropagoServicio getUltimonumeropagoServicio() {
		return ultimonumeropagoServicio;
	}

	@Override
	public void setUltimonumeropagoServicio(
			UltimonumeropagoServicio ultimonumeropagoServicio) {
		this.ultimonumeropagoServicio = ultimonumeropagoServicio;
	}

	private ServicioximpuestoServicio servicioximpuestoServicio;

	@Override
	public ServicioximpuestoServicio getServicioximpuestoServicio() {
		return servicioximpuestoServicio;
	}

	@Override
	public void setServicioximpuestoServicio(
			ServicioximpuestoServicio servicioximpuestoServicio) {
		this.servicioximpuestoServicio = servicioximpuestoServicio;
	}

	private ProveedormastServicio proveedormastServicio;

	@Override
	public ProveedormastServicio getProveedormastServicio() {
		return proveedormastServicio;
	}

	@Override
	public void setProveedormastServicio(
			ProveedormastServicio proveedormastServicio) {
		this.proveedormastServicio = proveedormastServicio;
	}

	private PrimemstServicio primemstServicio;

	@Override
	public PrimemstServicio getPrimemstServicio() {
		return primemstServicio;
	}

	@Override
	public void setPrimemstServicio(PrimemstServicio primemstServicio) {
		this.primemstServicio = primemstServicio;
	}

	private OrdenpagoServicio ordenpagoServicio;

	@Override
	public OrdenpagoServicio getOrdenpagoServicio() {
		return ordenpagoServicio;
	}

	@Override
	public void setOrdenpagoServicio(OrdenpagoServicio ordenpagoServicio) {
		this.ordenpagoServicio = ordenpagoServicio;
	}

	private ObligacionesximpuestoServicio obligacionesximpuestoServicio;

	@Override
	public ObligacionesximpuestoServicio getObligacionesximpuestoServicio() {
		return obligacionesximpuestoServicio;
	}

	@Override
	public void setObligacionesximpuestoServicio(
			ObligacionesximpuestoServicio obligacionesximpuestoServicio) {
		this.obligacionesximpuestoServicio = obligacionesximpuestoServicio;
	}

	private ObligacionesxcuentaServicio obligacionesxcuentaServicio;

	@Override
	public ObligacionesxcuentaServicio getObligacionesxcuentaServicio() {
		return obligacionesxcuentaServicio;
	}

	@Override
	public void setObligacionesxcuentaServicio(
			ObligacionesxcuentaServicio obligacionesxcuentaServicio) {
		this.obligacionesxcuentaServicio = obligacionesxcuentaServicio;
	}

	private ObligacionesServicio obligacionesServicio;

	@Override
	public ObligacionesServicio getObligacionesServicio() {
		return obligacionesServicio;
	}

	@Override
	public void setObligacionesServicio(
			ObligacionesServicio obligacionesServicio) {
		this.obligacionesServicio = obligacionesServicio;
	}

	private CuentabancariaServicio cuentabancariaServicio;

	@Override
	public CuentabancariaServicio getCuentabancariaServicio() {
		return cuentabancariaServicio;
	}

	@Override
	public void setCuentabancariaServicio(
			CuentabancariaServicio cuentabancariaServicio) {
		this.cuentabancariaServicio = cuentabancariaServicio;
	}

	private CorrelativosmastServicio correlativosmastServicio;

	@Override
	public CorrelativosmastServicio getCorrelativosmastServicio() {
		return correlativosmastServicio;
	}

	@Override
	public void setCorrelativosmastServicio(
			CorrelativosmastServicio correlativosmastServicio) {
		this.correlativosmastServicio = correlativosmastServicio;
	}

	private CompaniadistribucionsplitcxpServicio companiadistribucionsplitcxpServicio;

	@Override
	public CompaniadistribucionsplitcxpServicio getCompaniadistribucionsplitcxpServicio() {
		return companiadistribucionsplitcxpServicio;
	}

	@Override
	public void setCompaniadistribucionsplitcxpServicio(
			CompaniadistribucionsplitcxpServicio companiadistribucionsplitcxpServicio) {
		this.companiadistribucionsplitcxpServicio = companiadistribucionsplitcxpServicio;
	}

	private BancoServicio bancoServicio;

	@Override
	public BancoServicio getBancoServicio() {
		return bancoServicio;
	}

	@Override
	public void setBancoServicio(BancoServicio bancoServicio) {
		this.bancoServicio = bancoServicio;
	}

	private MaMiscelaneosheaderServicio maMiscelaneosheaderServicio;

	@Override
	public MaMiscelaneosheaderServicio getMaMiscelaneosheaderServicio() {
		return maMiscelaneosheaderServicio;
	}

	@Override
	public void setMaMiscelaneosheaderServicio(
			MaMiscelaneosheaderServicio maMiscelaneosheaderServicio) {
		this.maMiscelaneosheaderServicio = maMiscelaneosheaderServicio;
	}

	private MaCtsServicio maCtsServicio;

	@Override
	public MaCtsServicio getMaCtsServicio() {
		return maCtsServicio;
	}

	@Override
	public void setMaCtsServicio(MaCtsServicio maCtsServicio) {
		this.maCtsServicio = maCtsServicio;
	}

	private PaisServicio paisServicio;

	@Override
	public PaisServicio getPaisServicio() {
		return paisServicio;
	}

	@Override
	public void setPaisServicio(PaisServicio paisServicio) {
		this.paisServicio = paisServicio;
	}

	private MaPersonagrupoServicio maPersonagrupoServicio;

	@Override
	public MaPersonagrupoServicio getMaPersonagrupoServicio() {
		return maPersonagrupoServicio;
	}

	@Override
	public void setMaPersonagrupoServicio(
			MaPersonagrupoServicio maPersonagrupoServicio) {
		this.maPersonagrupoServicio = maPersonagrupoServicio;
	}
	
	private CorreoServicio correoServicio;

	@Override
	public CorreoServicio getCorreoServicio() {
		return correoServicio;
	}

	@Override
	public void setCorreoServicio(
			CorreoServicio correoServicio) {
		this.correoServicio = correoServicio;
	}
}
