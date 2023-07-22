package net.royal.erp.asistencia.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

@SuppressWarnings("serial")
public class DtoDwAsRep001ReporteOficialMinisterio implements Serializable {
	private Integer empleado;
	private Date fecha;
	private Integer tipodia;
	private String nombrecompleto;
	private Date hora1;
	private Date hora2;
	private Date hora3;
	private Date hora4;
	private Date hora5;
	private Date hora6;
	private BigDecimal sobretiempo;
	private BigDecimal tardanza;
	private BigDecimal tardanzaConTolerancia;
	private Integer cantidadconceptofalta;
	private String conceptofalta;
	private String companiasocio;
	private String tipodocumento;
	private String documento;
	private String tipoplanilla;
	private String sucursal;
	private String locaciondepago;
	private String centrocostos;
	private Integer area;
	private Integer tipohorario;
	private String estadoempleado;
	private BigDecimal faltaporhora;

	private String tipodiadescripcion;
	private String conceptofaltadescripcion;
	private String sobretiempodescripcion;
	private String tardanzadescripcion;
	private String tardanzatoleranciadescripcion;
	private String faltaporhoradescripcion;

	private String totalpermanenciadescripcion;
	private String totaltardanzadescripcion;
	private String totaltardanzatoleranciadescripcion;
	private String totalpermisosdescripcion;

	private BigDecimal ganadas;
	private BigDecimal comp;
	private BigDecimal feriarecu;

	private String ganadasdescripcion;
	private String compdescripcion;
	private String feriarecudescripcion;

	private String totalganadasdescripcion;
	private String totalcompdescripcion;
	private String totalferiarecudescripcion;

	private BigDecimal permisopersonaldias;
	private BigDecimal totalpermisopersonaldias;

	private BigDecimal permisopersonalhoras;
	private String permisopersonalhorasdescripcion;
	private String totalpermisopersonalhorasdescripcion;

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getTipodia() {
		return tipodia;
	}

	public void setTipodia(Integer tipodia) {
		this.tipodia = tipodia;
	}

	public Date getHora1() {
		return hora1;
	}

	public void setHora1(Date hora1) {
		this.hora1 = hora1;
	}

	public Date getHora2() {
		return hora2;
	}

	public void setHora2(Date hora2) {
		this.hora2 = hora2;
	}

	public Date getHora3() {
		return hora3;
	}

	public void setHora3(Date hora3) {
		this.hora3 = hora3;
	}

	public Date getHora4() {
		return hora4;
	}

	public void setHora4(Date hora4) {
		this.hora4 = hora4;
	}

	public Date getHora5() {
		return hora5;
	}

	public void setHora5(Date hora5) {
		this.hora5 = hora5;
	}

	public Date getHora6() {
		return hora6;
	}

	public void setHora6(Date hora6) {
		this.hora6 = hora6;
	}

	public BigDecimal getSobretiempo() {
		return sobretiempo;
	}

	public void setSobretiempo(BigDecimal sobretiempo) {
		this.sobretiempo = sobretiempo;
	}

	public BigDecimal getTardanza() {
		if (UValidador.esNulo(tardanza)) {
			tardanza = BigDecimal.ZERO;
		}
		return tardanza;
	}

	public void setTardanza(BigDecimal tardanza) {
		this.tardanza = tardanza;
	}

	public Integer getCantidadconceptofalta() {
		return cantidadconceptofalta;
	}

	public void setCantidadconceptofalta(Integer cantidadconceptofalta) {
		this.cantidadconceptofalta = cantidadconceptofalta;
	}

	public String getConceptofalta() {
		if (UValidador.estaVacio(conceptofalta)) {
			conceptofalta = "";
		}
		return conceptofalta;
	}

	public void setConceptofalta(String conceptofalta) {
		this.conceptofalta = conceptofalta;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getLocaciondepago() {
		return locaciondepago;
	}

	public void setLocaciondepago(String locaciondepago) {
		this.locaciondepago = locaciondepago;
	}

	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(Integer tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getEstadoempleado() {
		return estadoempleado;
	}

	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}

	public BigDecimal getFaltaporhora() {
		return faltaporhora;
	}

	public void setFaltaporhora(BigDecimal faltaporhora) {
		this.faltaporhora = faltaporhora;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getTipodiadescripcion() {
		return tipodiadescripcion;
	}

	public void setTipodiadescripcion(String tipodiadescripcion) {
		this.tipodiadescripcion = tipodiadescripcion;
	}

	public String getConceptofaltadescripcion() {
		return conceptofaltadescripcion;
	}

	public void setConceptofaltadescripcion(String conceptofaltadescripcion) {
		this.conceptofaltadescripcion = conceptofaltadescripcion;
	}

	public String getSobretiempodescripcion() {
		return sobretiempodescripcion;
	}

	public void setSobretiempodescripcion(String sobretiempodescripcion) {
		this.sobretiempodescripcion = sobretiempodescripcion;
	}

	public String getTardanzadescripcion() {
		return tardanzadescripcion;
	}

	public void setTardanzadescripcion(String tardanzadescripcion) {
		this.tardanzadescripcion = tardanzadescripcion;
	}

	public String getFaltaporhoradescripcion() {
		return faltaporhoradescripcion;
	}

	public void setFaltaporhoradescripcion(String faltaporhoradescripcion) {
		this.faltaporhoradescripcion = faltaporhoradescripcion;
	}

	public String getTotalpermanenciadescripcion() {
		return totalpermanenciadescripcion;
	}

	public void setTotalpermanenciadescripcion(String totalpermanenciadescripcion) {
		this.totalpermanenciadescripcion = totalpermanenciadescripcion;
	}

	public String getTotaltardanzadescripcion() {
		return totaltardanzadescripcion;
	}

	public void setTotaltardanzadescripcion(String totaltardanzadescripcion) {
		this.totaltardanzadescripcion = totaltardanzadescripcion;
	}

	public String getTotalpermisosdescripcion() {
		return totalpermisosdescripcion;
	}

	public void setTotalpermisosdescripcion(String totalpermisosdescripcion) {
		this.totalpermisosdescripcion = totalpermisosdescripcion;
	}

	public BigDecimal getGanadas() {
		return ganadas;
	}

	public void setGanadas(BigDecimal ganadas) {
		this.ganadas = ganadas;
	}

	public BigDecimal getComp() {
		return comp;
	}

	public void setComp(BigDecimal comp) {
		this.comp = comp;
	}

	public BigDecimal getFeriarecu() {
		return feriarecu;
	}

	public void setFeriarecu(BigDecimal feriarecu) {
		this.feriarecu = feriarecu;
	}

	public String getGanadasdescripcion() {
		return ganadasdescripcion;
	}

	public void setGanadasdescripcion(String ganadasdescripcion) {
		this.ganadasdescripcion = ganadasdescripcion;
	}

	public String getCompdescripcion() {
		return compdescripcion;
	}

	public void setCompdescripcion(String compdescripcion) {
		this.compdescripcion = compdescripcion;
	}

	public String getFeriarecudescripcion() {
		return feriarecudescripcion;
	}

	public void setFeriarecudescripcion(String feriarecudescripcion) {
		this.feriarecudescripcion = feriarecudescripcion;
	}

	public String getTotalganadasdescripcion() {
		return totalganadasdescripcion;
	}

	public void setTotalganadasdescripcion(String totalganadasdescripcion) {
		this.totalganadasdescripcion = totalganadasdescripcion;
	}

	public String getTotalcompdescripcion() {
		return totalcompdescripcion;
	}

	public void setTotalcompdescripcion(String totalcompdescripcion) {
		this.totalcompdescripcion = totalcompdescripcion;
	}

	public String getTotalferiarecudescripcion() {
		return totalferiarecudescripcion;
	}

	public void setTotalferiarecudescripcion(String totalferiarecudescripcion) {
		this.totalferiarecudescripcion = totalferiarecudescripcion;
	}

	public String getTardanzatoleranciadescripcion() {
		return tardanzatoleranciadescripcion;
	}

	public void setTardanzatoleranciadescripcion(String tardanzatoleranciadescripcion) {
		this.tardanzatoleranciadescripcion = tardanzatoleranciadescripcion;
	}

	public String getTotaltardanzatoleranciadescripcion() {
		return totaltardanzatoleranciadescripcion;
	}

	public void setTotaltardanzatoleranciadescripcion(String totaltardanzatoleranciadescripcion) {
		this.totaltardanzatoleranciadescripcion = totaltardanzatoleranciadescripcion;
	}

	public BigDecimal getPermisopersonaldias() {
		return permisopersonaldias;
	}

	public void setPermisopersonaldias(BigDecimal permisopersonaldias) {
		this.permisopersonaldias = permisopersonaldias;
	}

	public BigDecimal getPermisopersonalhoras() {
		return permisopersonalhoras;
	}

	public void setPermisopersonalhoras(BigDecimal permisopersonalhoras) {
		this.permisopersonalhoras = permisopersonalhoras;
	}

	public BigDecimal getTotalpermisopersonaldias() {
		return totalpermisopersonaldias;
	}

	public void setTotalpermisopersonaldias(BigDecimal totalpermisopersonaldias) {
		this.totalpermisopersonaldias = totalpermisopersonaldias;
	}

	public String getPermisopersonalhorasdescripcion() {
		return permisopersonalhorasdescripcion;
	}

	public void setPermisopersonalhorasdescripcion(String permisopersonalhorasdescripcion) {
		this.permisopersonalhorasdescripcion = permisopersonalhorasdescripcion;
	}

	public String getTotalpermisopersonalhorasdescripcion() {
		return totalpermisopersonalhorasdescripcion;
	}

	public void setTotalpermisopersonalhorasdescripcion(String totalpermisopersonalhorasdescripcion) {
		this.totalpermisopersonalhorasdescripcion = totalpermisopersonalhorasdescripcion;
	}

	public BigDecimal getTardanzaConTolerancia() {
		return tardanzaConTolerancia;
	}

	public void setTardanzaConTolerancia(BigDecimal tardanzaConTolerancia) {
		this.tardanzaConTolerancia = tardanzaConTolerancia;
	}
	
}
