package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_itemmast_retrieve
 */
public class DtoDwMaItemmastRetrieve implements java.io.Serializable {

	private String item;
	private String itemtipo;
	private String marcacodigo;
	private String linea;
	private String familia;
	private String subfamilia;
	private String descripcionlocal;
	private String descripcioningles;
	private String descripcioncompleta;
	private String numerodeparte;
	private String codigointerno;
	private String unidadcodigo;
	private String unidadcodigodoble;
	private String partidaarancelaria;
	private String modelo;
	private String color;
	private String codigobarras;
	private String codigobarrasfabricante;
	private String monedacodigo;
	private BigDecimal preciocosto;
	private BigDecimal preciounitariolocal;
	private BigDecimal preciounitariodolares;
	private String itemprecioflag;
	private String itempreciocodigo;
	private String disponibleventaflag;
	private String itemprocedencia;
	private String manejoxloteflag;
	private String manejoxserieflag;
	private String manejoxkitflag;
	private String afectoimpuestoventasflag;
	private String afectoimpuesto2flag;
	private String requisicionamientoautomaticofl;
	private String disponibletransferenciaflag;
	private String disponibleconsumoflag;
	private String formularioflag;
	private Integer formularionrojuegos;
	private String manejoxunidadflag;
	private String isoaplicableflag;
	private String cantidaddobleflag;
	private String isonormainterna;
	private String unidadreplicacion;
	private String imagefile;
	private String mapafile;
	private String cuentainventario;
	private String cuentagasto;
	private String cuentainversion;
	private String cuentaserviciotecnico;
	private String cuentasalidaterceros;
	private String elementogasto;
	private String elementoinversion;
	private String partidapresupuestal;
	private String flujodecaja;
	private BigDecimal lotedecompra;
	private BigDecimal lotededespacho;
	private Integer periodicidadcomprameses;
	private String especificaciontecnica;
	private String dimensiones;
	private BigDecimal factorequivalenciacomercial;
	private String abccodigo;
	private BigDecimal inventariotolerancia;
	private String estado;
	private Date ultimafechamodif;
	private String ultimousuario;
	private String descripcionlocalclasefamilia;
	private String elementogastoclasefamilia;
	private String medicinagrupoaflag;
	private String medicinagrupohflag;
	private String medicinagrupoeflag;
	private String medicinagruporflag;
	private String unidadcompra;
	private String clasificacioncomercial;
	private String referenciafiscal02;
	private BigDecimal lotedecomprakg;
	private String activofijoflag;
	private String referenciafiscalingreso02;
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * @return the itemtipo
	 */
	public String getItemtipo() {
		return itemtipo;
	}
	/**
	 * @param itemtipo the itemtipo to set
	 */
	public void setItemtipo(String itemtipo) {
		this.itemtipo = itemtipo;
	}
	/**
	 * @return the marcacodigo
	 */
	public String getMarcacodigo() {
		return marcacodigo;
	}
	/**
	 * @param marcacodigo the marcacodigo to set
	 */
	public void setMarcacodigo(String marcacodigo) {
		this.marcacodigo = marcacodigo;
	}
	/**
	 * @return the linea
	 */
	public String getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}
	/**
	 * @return the familia
	 */
	public String getFamilia() {
		return familia;
	}
	/**
	 * @param familia the familia to set
	 */
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	/**
	 * @return the subfamilia
	 */
	public String getSubfamilia() {
		return subfamilia;
	}
	/**
	 * @param subfamilia the subfamilia to set
	 */
	public void setSubfamilia(String subfamilia) {
		this.subfamilia = subfamilia;
	}
	/**
	 * @return the descripcionlocal
	 */
	public String getDescripcionlocal() {
		return descripcionlocal;
	}
	/**
	 * @param descripcionlocal the descripcionlocal to set
	 */
	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	/**
	 * @return the descripcioningles
	 */
	public String getDescripcioningles() {
		return descripcioningles;
	}
	/**
	 * @param descripcioningles the descripcioningles to set
	 */
	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	/**
	 * @return the descripcioncompleta
	 */
	public String getDescripcioncompleta() {
		return descripcioncompleta;
	}
	/**
	 * @param descripcioncompleta the descripcioncompleta to set
	 */
	public void setDescripcioncompleta(String descripcioncompleta) {
		this.descripcioncompleta = descripcioncompleta;
	}
	/**
	 * @return the numerodeparte
	 */
	public String getNumerodeparte() {
		return numerodeparte;
	}
	/**
	 * @param numerodeparte the numerodeparte to set
	 */
	public void setNumerodeparte(String numerodeparte) {
		this.numerodeparte = numerodeparte;
	}
	/**
	 * @return the codigointerno
	 */
	public String getCodigointerno() {
		return codigointerno;
	}
	/**
	 * @param codigointerno the codigointerno to set
	 */
	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}
	/**
	 * @return the unidadcodigo
	 */
	public String getUnidadcodigo() {
		return unidadcodigo;
	}
	/**
	 * @param unidadcodigo the unidadcodigo to set
	 */
	public void setUnidadcodigo(String unidadcodigo) {
		this.unidadcodigo = unidadcodigo;
	}
	/**
	 * @return the unidadcodigodoble
	 */
	public String getUnidadcodigodoble() {
		return unidadcodigodoble;
	}
	/**
	 * @param unidadcodigodoble the unidadcodigodoble to set
	 */
	public void setUnidadcodigodoble(String unidadcodigodoble) {
		this.unidadcodigodoble = unidadcodigodoble;
	}
	/**
	 * @return the partidaarancelaria
	 */
	public String getPartidaarancelaria() {
		return partidaarancelaria;
	}
	/**
	 * @param partidaarancelaria the partidaarancelaria to set
	 */
	public void setPartidaarancelaria(String partidaarancelaria) {
		this.partidaarancelaria = partidaarancelaria;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the codigobarras
	 */
	public String getCodigobarras() {
		return codigobarras;
	}
	/**
	 * @param codigobarras the codigobarras to set
	 */
	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}
	/**
	 * @return the codigobarrasfabricante
	 */
	public String getCodigobarrasfabricante() {
		return codigobarrasfabricante;
	}
	/**
	 * @param codigobarrasfabricante the codigobarrasfabricante to set
	 */
	public void setCodigobarrasfabricante(String codigobarrasfabricante) {
		this.codigobarrasfabricante = codigobarrasfabricante;
	}
	/**
	 * @return the monedacodigo
	 */
	public String getMonedacodigo() {
		return monedacodigo;
	}
	/**
	 * @param monedacodigo the monedacodigo to set
	 */
	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}
	/**
	 * @return the preciocosto
	 */
	public BigDecimal getPreciocosto() {
		return preciocosto;
	}
	/**
	 * @param preciocosto the preciocosto to set
	 */
	public void setPreciocosto(BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}
	/**
	 * @return the preciounitariolocal
	 */
	public BigDecimal getPreciounitariolocal() {
		return preciounitariolocal;
	}
	/**
	 * @param preciounitariolocal the preciounitariolocal to set
	 */
	public void setPreciounitariolocal(BigDecimal preciounitariolocal) {
		this.preciounitariolocal = preciounitariolocal;
	}
	/**
	 * @return the preciounitariodolares
	 */
	public BigDecimal getPreciounitariodolares() {
		return preciounitariodolares;
	}
	/**
	 * @param preciounitariodolares the preciounitariodolares to set
	 */
	public void setPreciounitariodolares(BigDecimal preciounitariodolares) {
		this.preciounitariodolares = preciounitariodolares;
	}
	/**
	 * @return the itemprecioflag
	 */
	public String getItemprecioflag() {
		return itemprecioflag;
	}
	/**
	 * @param itemprecioflag the itemprecioflag to set
	 */
	public void setItemprecioflag(String itemprecioflag) {
		this.itemprecioflag = itemprecioflag;
	}
	/**
	 * @return the itempreciocodigo
	 */
	public String getItempreciocodigo() {
		return itempreciocodigo;
	}
	/**
	 * @param itempreciocodigo the itempreciocodigo to set
	 */
	public void setItempreciocodigo(String itempreciocodigo) {
		this.itempreciocodigo = itempreciocodigo;
	}
	/**
	 * @return the disponibleventaflag
	 */
	public String getDisponibleventaflag() {
		return disponibleventaflag;
	}
	/**
	 * @param disponibleventaflag the disponibleventaflag to set
	 */
	public void setDisponibleventaflag(String disponibleventaflag) {
		this.disponibleventaflag = disponibleventaflag;
	}
	/**
	 * @return the itemprocedencia
	 */
	public String getItemprocedencia() {
		return itemprocedencia;
	}
	/**
	 * @param itemprocedencia the itemprocedencia to set
	 */
	public void setItemprocedencia(String itemprocedencia) {
		this.itemprocedencia = itemprocedencia;
	}
	/**
	 * @return the manejoxloteflag
	 */
	public String getManejoxloteflag() {
		return manejoxloteflag;
	}
	/**
	 * @param manejoxloteflag the manejoxloteflag to set
	 */
	public void setManejoxloteflag(String manejoxloteflag) {
		this.manejoxloteflag = manejoxloteflag;
	}
	/**
	 * @return the manejoxserieflag
	 */
	public String getManejoxserieflag() {
		return manejoxserieflag;
	}
	/**
	 * @param manejoxserieflag the manejoxserieflag to set
	 */
	public void setManejoxserieflag(String manejoxserieflag) {
		this.manejoxserieflag = manejoxserieflag;
	}
	/**
	 * @return the manejoxkitflag
	 */
	public String getManejoxkitflag() {
		return manejoxkitflag;
	}
	/**
	 * @param manejoxkitflag the manejoxkitflag to set
	 */
	public void setManejoxkitflag(String manejoxkitflag) {
		this.manejoxkitflag = manejoxkitflag;
	}
	/**
	 * @return the afectoimpuestoventasflag
	 */
	public String getAfectoimpuestoventasflag() {
		return afectoimpuestoventasflag;
	}
	/**
	 * @param afectoimpuestoventasflag the afectoimpuestoventasflag to set
	 */
	public void setAfectoimpuestoventasflag(String afectoimpuestoventasflag) {
		this.afectoimpuestoventasflag = afectoimpuestoventasflag;
	}
	/**
	 * @return the afectoimpuesto2flag
	 */
	public String getAfectoimpuesto2flag() {
		return afectoimpuesto2flag;
	}
	/**
	 * @param afectoimpuesto2flag the afectoimpuesto2flag to set
	 */
	public void setAfectoimpuesto2flag(String afectoimpuesto2flag) {
		this.afectoimpuesto2flag = afectoimpuesto2flag;
	}
	/**
	 * @return the requisicionamientoautomaticofl
	 */
	public String getRequisicionamientoautomaticofl() {
		return requisicionamientoautomaticofl;
	}
	/**
	 * @param requisicionamientoautomaticofl the requisicionamientoautomaticofl to set
	 */
	public void setRequisicionamientoautomaticofl(
			String requisicionamientoautomaticofl) {
		this.requisicionamientoautomaticofl = requisicionamientoautomaticofl;
	}
	/**
	 * @return the disponibletransferenciaflag
	 */
	public String getDisponibletransferenciaflag() {
		return disponibletransferenciaflag;
	}
	/**
	 * @param disponibletransferenciaflag the disponibletransferenciaflag to set
	 */
	public void setDisponibletransferenciaflag(String disponibletransferenciaflag) {
		this.disponibletransferenciaflag = disponibletransferenciaflag;
	}
	/**
	 * @return the disponibleconsumoflag
	 */
	public String getDisponibleconsumoflag() {
		return disponibleconsumoflag;
	}
	/**
	 * @param disponibleconsumoflag the disponibleconsumoflag to set
	 */
	public void setDisponibleconsumoflag(String disponibleconsumoflag) {
		this.disponibleconsumoflag = disponibleconsumoflag;
	}
	/**
	 * @return the formularioflag
	 */
	public String getFormularioflag() {
		return formularioflag;
	}
	/**
	 * @param formularioflag the formularioflag to set
	 */
	public void setFormularioflag(String formularioflag) {
		this.formularioflag = formularioflag;
	}
	/**
	 * @return the formularionrojuegos
	 */
	public Integer getFormularionrojuegos() {
		return formularionrojuegos;
	}
	/**
	 * @param formularionrojuegos the formularionrojuegos to set
	 */
	public void setFormularionrojuegos(Integer formularionrojuegos) {
		this.formularionrojuegos = formularionrojuegos;
	}
	/**
	 * @return the manejoxunidadflag
	 */
	public String getManejoxunidadflag() {
		return manejoxunidadflag;
	}
	/**
	 * @param manejoxunidadflag the manejoxunidadflag to set
	 */
	public void setManejoxunidadflag(String manejoxunidadflag) {
		this.manejoxunidadflag = manejoxunidadflag;
	}
	/**
	 * @return the isoaplicableflag
	 */
	public String getIsoaplicableflag() {
		return isoaplicableflag;
	}
	/**
	 * @param isoaplicableflag the isoaplicableflag to set
	 */
	public void setIsoaplicableflag(String isoaplicableflag) {
		this.isoaplicableflag = isoaplicableflag;
	}
	/**
	 * @return the cantidaddobleflag
	 */
	public String getCantidaddobleflag() {
		return cantidaddobleflag;
	}
	/**
	 * @param cantidaddobleflag the cantidaddobleflag to set
	 */
	public void setCantidaddobleflag(String cantidaddobleflag) {
		this.cantidaddobleflag = cantidaddobleflag;
	}
	/**
	 * @return the isonormainterna
	 */
	public String getIsonormainterna() {
		return isonormainterna;
	}
	/**
	 * @param isonormainterna the isonormainterna to set
	 */
	public void setIsonormainterna(String isonormainterna) {
		this.isonormainterna = isonormainterna;
	}
	/**
	 * @return the unidadreplicacion
	 */
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}
	/**
	 * @param unidadreplicacion the unidadreplicacion to set
	 */
	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	/**
	 * @return the imagefile
	 */
	public String getImagefile() {
		return imagefile;
	}
	/**
	 * @param imagefile the imagefile to set
	 */
	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}
	/**
	 * @return the mapafile
	 */
	public String getMapafile() {
		return mapafile;
	}
	/**
	 * @param mapafile the mapafile to set
	 */
	public void setMapafile(String mapafile) {
		this.mapafile = mapafile;
	}
	/**
	 * @return the cuentainventario
	 */
	public String getCuentainventario() {
		return cuentainventario;
	}
	/**
	 * @param cuentainventario the cuentainventario to set
	 */
	public void setCuentainventario(String cuentainventario) {
		this.cuentainventario = cuentainventario;
	}
	/**
	 * @return the cuentagasto
	 */
	public String getCuentagasto() {
		return cuentagasto;
	}
	/**
	 * @param cuentagasto the cuentagasto to set
	 */
	public void setCuentagasto(String cuentagasto) {
		this.cuentagasto = cuentagasto;
	}
	/**
	 * @return the cuentainversion
	 */
	public String getCuentainversion() {
		return cuentainversion;
	}
	/**
	 * @param cuentainversion the cuentainversion to set
	 */
	public void setCuentainversion(String cuentainversion) {
		this.cuentainversion = cuentainversion;
	}
	/**
	 * @return the cuentaserviciotecnico
	 */
	public String getCuentaserviciotecnico() {
		return cuentaserviciotecnico;
	}
	/**
	 * @param cuentaserviciotecnico the cuentaserviciotecnico to set
	 */
	public void setCuentaserviciotecnico(String cuentaserviciotecnico) {
		this.cuentaserviciotecnico = cuentaserviciotecnico;
	}
	/**
	 * @return the cuentasalidaterceros
	 */
	public String getCuentasalidaterceros() {
		return cuentasalidaterceros;
	}
	/**
	 * @param cuentasalidaterceros the cuentasalidaterceros to set
	 */
	public void setCuentasalidaterceros(String cuentasalidaterceros) {
		this.cuentasalidaterceros = cuentasalidaterceros;
	}
	/**
	 * @return the elementogasto
	 */
	public String getElementogasto() {
		return elementogasto;
	}
	/**
	 * @param elementogasto the elementogasto to set
	 */
	public void setElementogasto(String elementogasto) {
		this.elementogasto = elementogasto;
	}
	/**
	 * @return the elementoinversion
	 */
	public String getElementoinversion() {
		return elementoinversion;
	}
	/**
	 * @param elementoinversion the elementoinversion to set
	 */
	public void setElementoinversion(String elementoinversion) {
		this.elementoinversion = elementoinversion;
	}
	/**
	 * @return the partidapresupuestal
	 */
	public String getPartidapresupuestal() {
		return partidapresupuestal;
	}
	/**
	 * @param partidapresupuestal the partidapresupuestal to set
	 */
	public void setPartidapresupuestal(String partidapresupuestal) {
		this.partidapresupuestal = partidapresupuestal;
	}
	/**
	 * @return the flujodecaja
	 */
	public String getFlujodecaja() {
		return flujodecaja;
	}
	/**
	 * @param flujodecaja the flujodecaja to set
	 */
	public void setFlujodecaja(String flujodecaja) {
		this.flujodecaja = flujodecaja;
	}
	/**
	 * @return the lotedecompra
	 */
	public BigDecimal getLotedecompra() {
		return lotedecompra;
	}
	/**
	 * @param lotedecompra the lotedecompra to set
	 */
	public void setLotedecompra(BigDecimal lotedecompra) {
		this.lotedecompra = lotedecompra;
	}
	/**
	 * @return the lotededespacho
	 */
	public BigDecimal getLotededespacho() {
		return lotededespacho;
	}
	/**
	 * @param lotededespacho the lotededespacho to set
	 */
	public void setLotededespacho(BigDecimal lotededespacho) {
		this.lotededespacho = lotededespacho;
	}
	/**
	 * @return the periodicidadcomprameses
	 */
	public Integer getPeriodicidadcomprameses() {
		return periodicidadcomprameses;
	}
	/**
	 * @param periodicidadcomprameses the periodicidadcomprameses to set
	 */
	public void setPeriodicidadcomprameses(Integer periodicidadcomprameses) {
		this.periodicidadcomprameses = periodicidadcomprameses;
	}
	/**
	 * @return the especificaciontecnica
	 */
	public String getEspecificaciontecnica() {
		return especificaciontecnica;
	}
	/**
	 * @param especificaciontecnica the especificaciontecnica to set
	 */
	public void setEspecificaciontecnica(String especificaciontecnica) {
		this.especificaciontecnica = especificaciontecnica;
	}
	/**
	 * @return the dimensiones
	 */
	public String getDimensiones() {
		return dimensiones;
	}
	/**
	 * @param dimensiones the dimensiones to set
	 */
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	/**
	 * @return the factorequivalenciacomercial
	 */
	public BigDecimal getFactorequivalenciacomercial() {
		return factorequivalenciacomercial;
	}
	/**
	 * @param factorequivalenciacomercial the factorequivalenciacomercial to set
	 */
	public void setFactorequivalenciacomercial(
			BigDecimal factorequivalenciacomercial) {
		this.factorequivalenciacomercial = factorequivalenciacomercial;
	}
	/**
	 * @return the abccodigo
	 */
	public String getAbccodigo() {
		return abccodigo;
	}
	/**
	 * @param abccodigo the abccodigo to set
	 */
	public void setAbccodigo(String abccodigo) {
		this.abccodigo = abccodigo;
	}
	/**
	 * @return the inventariotolerancia
	 */
	public BigDecimal getInventariotolerancia() {
		return inventariotolerancia;
	}
	/**
	 * @param inventariotolerancia the inventariotolerancia to set
	 */
	public void setInventariotolerancia(BigDecimal inventariotolerancia) {
		this.inventariotolerancia = inventariotolerancia;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the ultimafechamodif
	 */
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}
	/**
	 * @param ultimafechamodif the ultimafechamodif to set
	 */
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	/**
	 * @return the ultimousuario
	 */
	public String getUltimousuario() {
		return ultimousuario;
	}
	/**
	 * @param ultimousuario the ultimousuario to set
	 */
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	/**
	 * @return the descripcionlocalclasefamilia
	 */
	public String getDescripcionlocalclasefamilia() {
		return descripcionlocalclasefamilia;
	}
	/**
	 * @param descripcionlocalclasefamilia the descripcionlocalclasefamilia to set
	 */
	public void setDescripcionlocalclasefamilia(String descripcionlocalclasefamilia) {
		this.descripcionlocalclasefamilia = descripcionlocalclasefamilia;
	}
	/**
	 * @return the elementogastoclasefamilia
	 */
	public String getElementogastoclasefamilia() {
		return elementogastoclasefamilia;
	}
	/**
	 * @param elementogastoclasefamilia the elementogastoclasefamilia to set
	 */
	public void setElementogastoclasefamilia(String elementogastoclasefamilia) {
		this.elementogastoclasefamilia = elementogastoclasefamilia;
	}
	/**
	 * @return the medicinagrupoaflag
	 */
	public String getMedicinagrupoaflag() {
		return medicinagrupoaflag;
	}
	/**
	 * @param medicinagrupoaflag the medicinagrupoaflag to set
	 */
	public void setMedicinagrupoaflag(String medicinagrupoaflag) {
		this.medicinagrupoaflag = medicinagrupoaflag;
	}
	/**
	 * @return the medicinagrupohflag
	 */
	public String getMedicinagrupohflag() {
		return medicinagrupohflag;
	}
	/**
	 * @param medicinagrupohflag the medicinagrupohflag to set
	 */
	public void setMedicinagrupohflag(String medicinagrupohflag) {
		this.medicinagrupohflag = medicinagrupohflag;
	}
	/**
	 * @return the medicinagrupoeflag
	 */
	public String getMedicinagrupoeflag() {
		return medicinagrupoeflag;
	}
	/**
	 * @param medicinagrupoeflag the medicinagrupoeflag to set
	 */
	public void setMedicinagrupoeflag(String medicinagrupoeflag) {
		this.medicinagrupoeflag = medicinagrupoeflag;
	}
	/**
	 * @return the medicinagruporflag
	 */
	public String getMedicinagruporflag() {
		return medicinagruporflag;
	}
	/**
	 * @param medicinagruporflag the medicinagruporflag to set
	 */
	public void setMedicinagruporflag(String medicinagruporflag) {
		this.medicinagruporflag = medicinagruporflag;
	}
	/**
	 * @return the unidadcompra
	 */
	public String getUnidadcompra() {
		return unidadcompra;
	}
	/**
	 * @param unidadcompra the unidadcompra to set
	 */
	public void setUnidadcompra(String unidadcompra) {
		this.unidadcompra = unidadcompra;
	}
	/**
	 * @return the clasificacioncomercial
	 */
	public String getClasificacioncomercial() {
		return clasificacioncomercial;
	}
	/**
	 * @param clasificacioncomercial the clasificacioncomercial to set
	 */
	public void setClasificacioncomercial(String clasificacioncomercial) {
		this.clasificacioncomercial = clasificacioncomercial;
	}
	/**
	 * @return the referenciafiscal02
	 */
	public String getReferenciafiscal02() {
		return referenciafiscal02;
	}
	/**
	 * @param referenciafiscal02 the referenciafiscal02 to set
	 */
	public void setReferenciafiscal02(String referenciafiscal02) {
		this.referenciafiscal02 = referenciafiscal02;
	}
	/**
	 * @return the lotedecomprakg
	 */
	public BigDecimal getLotedecomprakg() {
		return lotedecomprakg;
	}
	/**
	 * @param lotedecomprakg the lotedecomprakg to set
	 */
	public void setLotedecomprakg(BigDecimal lotedecomprakg) {
		this.lotedecomprakg = lotedecomprakg;
	}
	/**
	 * @return the activofijoflag
	 */
	public String getActivofijoflag() {
		return activofijoflag;
	}
	/**
	 * @param activofijoflag the activofijoflag to set
	 */
	public void setActivofijoflag(String activofijoflag) {
		this.activofijoflag = activofijoflag;
	}
	/**
	 * @return the referenciafiscalingreso02
	 */
	public String getReferenciafiscalingreso02() {
		return referenciafiscalingreso02;
	}
	/**
	 * @param referenciafiscalingreso02 the referenciafiscalingreso02 to set
	 */
	public void setReferenciafiscalingreso02(String referenciafiscalingreso02) {
		this.referenciafiscalingreso02 = referenciafiscalingreso02;
	}

}
