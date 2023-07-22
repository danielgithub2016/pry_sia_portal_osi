package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientofuncas
*/
public class HrRequerimientofuncas extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientofuncasPk pk;
	private String funciondescripcion;
	private String funcioncomentarios;
	
	private String auxTipoRequisito;


	public HrRequerimientofuncas() {
		pk = new HrRequerimientofuncasPk();
	}

	public HrRequerimientofuncasPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientofuncasPk pk) {
		this.pk = pk;
	}
	public String getFunciondescripcion() {
		return funciondescripcion;
	}

	public void setFunciondescripcion(String funciondescripcion) {
		this.funciondescripcion = funciondescripcion;
	}
	public String getFuncioncomentarios() {
		return funcioncomentarios;
	}

	public void setFuncioncomentarios(String funcioncomentarios) {
		this.funcioncomentarios = funcioncomentarios;
	}

	public String getAuxTipoRequisito() {
		return auxTipoRequisito;
	}

	public void setAuxTipoRequisito(String auxTipoRequisito) {
		this.auxTipoRequisito = auxTipoRequisito;
	}

}
