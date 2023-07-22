package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoexperiencia
*/
public class HrPuestoexperiencia extends DominioGenerico implements java.io.Serializable{

	private HrPuestoexperienciaPk pk;
	private String tipoexperiencia;
	private String flagnecesario;
	private Integer meses;
	private String estado;
	private String gradocuantitativo;
	private Integer puntosgrado;
	private Integer porcentajegrado;
	private String flagconocimiento;
	private Integer puntos;
	private Integer meseshasta;

	private String auxFuncion;
	
	public HrPuestoexperiencia() {
		pk = new HrPuestoexperienciaPk();
	}

	public HrPuestoexperienciaPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoexperienciaPk pk) {
		this.pk = pk;
	}
	public String getTipoexperiencia() {
		return tipoexperiencia;
	}

	public void setTipoexperiencia(String tipoexperiencia) {
		this.tipoexperiencia = tipoexperiencia;
	}
	public String getFlagnecesario() {
		return flagnecesario;
	}

	public void setFlagnecesario(String flagnecesario) {
		this.flagnecesario = flagnecesario;
	}
	public Integer getMeses() {
		return meses;
	}

	public void setMeses(Integer meses) {
		this.meses = meses;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getGradocuantitativo() {
		return gradocuantitativo;
	}

	public void setGradocuantitativo(String gradocuantitativo) {
		this.gradocuantitativo = gradocuantitativo;
	}
	public Integer getPuntosgrado() {
		return puntosgrado;
	}

	public void setPuntosgrado(Integer puntosgrado) {
		this.puntosgrado = puntosgrado;
	}
	public Integer getPorcentajegrado() {
		return porcentajegrado;
	}

	public void setPorcentajegrado(Integer porcentajegrado) {
		this.porcentajegrado = porcentajegrado;
	}
	public String getFlagconocimiento() {
		return flagconocimiento;
	}

	public void setFlagconocimiento(String flagconocimiento) {
		this.flagconocimiento = flagconocimiento;
	}
	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Integer getMeseshasta() {
		return meseshasta;
	}

	public void setMeseshasta(Integer meseshasta) {
		this.meseshasta = meseshasta;
	}

	public String getAuxFuncion() {
		return auxFuncion;
	}

	public void setAuxFuncion(String auxFuncion) {
		this.auxFuncion = auxFuncion;
	}

}
