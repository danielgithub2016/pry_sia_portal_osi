package net.royal.erp.documento.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.royal.framework.web.core.UValidador;


public class DtoElementoArbol implements Serializable {

	/*
	 * ALMACEN CARPETA CARPETAVIRTUAL = (ANIO, ANIO-MES, ANIO-MES-DIA)
	 */
	public static String TIPO_ALMACEN = "ALMACEN";
	public static String TIPO_CARPETA = "CARPETA";
	public static String TIPO_CARPETA_VIRTUAL = "CARPETAVIRTUAL";
	public static String TIPO_DOCUMENTO = "DOCUMENTO";
	public static String TIPO_REPOSITORIO = "REPOSITORIO";
	public static String TIPO_FAVORITO = "FAVORITO";
	public static String TIPO_EDICION = "EDICION";

	public static String SUB_TIPO_ANIO = "ANIO";
	public static String SUB_TIPO_ANIO_MES = "ANIOMES";
	public static String SUB_TIPO_ANIO_MES_DIA = "ANIOMESDIA";
	public static String SUB_TIPO_GRUPO_NIVEL1 = "GRUPONIVEL1";
	public static String SUB_TIPO_GRUPO_NIVEL2 = "GRUPONIVEL2";
	public static String SUB_TIPO_GRUPO_NIVEL3 = "GRUPONIVEL3";

	// Representa el tipo de elemento (ALMACEN, CARPETA,
	// CARPETAVIRTUAL,DOCUMENTO, REPOSITORIO).
	private String tipo = null;
	private String subTipo = null;

	private String logicaIdRepositorio;
	private BigDecimal logicaIdAlmacen;
	private BigDecimal logicaIdCarpeta;
	private BigDecimal idDocumento;

	// Codigo unico generado, por lo general se genera cuando se crea data
	// temporal.
	// Un caso tipico es cuando se firma el documento y graba en un mismo
	// proceso.
	private String uuid;

	private String nombre;
	private String descripcion;
	private String tamanio;
	private String extension;
	private String auditoria;
	private String flgFavorito;

	private String idAnio;
	private String idMes;
	private String idDia;

	private String grupoNivel1;
	private String grupoNivel2;
	private String grupoNivel3;

	private BigDecimal nivel;
	private BigDecimal cantidadComentarios;
	private BigDecimal cantidadElementos;

	private Date fechacreacion;

	// Representa la concatenación del id y nombre de documento para obtener un
	// nombre único.
	private String idUnicoDocumento;

	// Representa la ultima fecha de modificación de un elemento.
	private Date ultimafechamodificacion;

	// Representa el identificador secuencial estándar para los elementos
	// (carpetas, documentos)
	private BigDecimal secuencia;

	private List<DtoElementoArbol> listaElementos;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(BigDecimal idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}

	public String getFlgFavorito() {
		return flgFavorito;
	}

	public void setFlgFavorito(String flgFavorito) {
		this.flgFavorito = flgFavorito;
	}


	public BigDecimal getCantidadComentarios() {
		if (UValidador.esNulo(cantidadComentarios)) {
			cantidadComentarios = BigDecimal.ZERO;
		}
		return cantidadComentarios;
	}

	public void setCantidadComentarios(BigDecimal cantidadComentarios) {
		this.cantidadComentarios = cantidadComentarios;
	}

	public BigDecimal getCantidadElementos() {
		return cantidadElementos;
	}

	public void setCantidadElementos(BigDecimal cantidadElementos) {
		this.cantidadElementos = cantidadElementos;
	}

	public List<DtoElementoArbol> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(List<DtoElementoArbol> listaElementos) {
		this.listaElementos = listaElementos;
	}

	public BigDecimal getNivel() {
		return nivel;
	}

	public void setNivel(BigDecimal nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the idUnicoDocumento
	 */
	public String getIdUnicoDocumento() {
		String id = null;
		if (net.royal.framework.web.core.UValidador.esNulo(getIdDocumento())) {
			id = getUuid();
		} else {
			id = getIdDocumento().toString();
		}
		idUnicoDocumento = id + "_" + getNombre().replace(" ", "");
		return idUnicoDocumento;
	}

	/**
	 * @param idUnicoDocumento
	 *            the idUnicoDocumento to set
	 */
	public void setIdUnicoDocumento(String idUnicoDocumento) {
		this.idUnicoDocumento = idUnicoDocumento;
	}

	/**
	 * @return the ultimafechamodificacion
	 */
	public Date getUltimafechamodificacion() {
		return ultimafechamodificacion;
	}

	/**
	 * @param ultimafechamodificacion
	 *            the ultimafechamodificacion to set
	 */
	public void setUltimafechamodificacion(Date ultimafechamodificacion) {
		this.ultimafechamodificacion = ultimafechamodificacion;
	}

	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the fechacreacion
	 */
	public Date getFechacreacion() {
		return fechacreacion;
	}

	/**
	 * @param fechacreacion
	 *            the fechacreacion to set
	 */
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

	public String getIdAnio() {
		return idAnio;
	}

	public void setIdAnio(String idAnio) {
		this.idAnio = idAnio;
	}

	public String getIdMes() {
		return idMes;
	}

	public void setIdMes(String idMes) {
		this.idMes = idMes;
	}

	public String getIdDia() {
		return idDia;
	}

	public void setIdDia(String idDia) {
		this.idDia = idDia;
	}

	public String getGrupoNivel1() {
		return grupoNivel1;
	}

	public void setGrupoNivel1(String grupoNivel1) {
		this.grupoNivel1 = grupoNivel1;
	}

	public String getGrupoNivel2() {
		return grupoNivel2;
	}

	public void setGrupoNivel2(String grupoNivel2) {
		this.grupoNivel2 = grupoNivel2;
	}

	public String getGrupoNivel3() {
		return grupoNivel3;
	}

	public void setGrupoNivel3(String grupoNivel3) {
		this.grupoNivel3 = grupoNivel3;
	}

	public String getLogicaIdRepositorio() {
		return logicaIdRepositorio;
	}

	public void setLogicaIdRepositorio(String logicaIdRepositorio) {
		this.logicaIdRepositorio = logicaIdRepositorio;
	}

	public BigDecimal getLogicaIdAlmacen() {
		return logicaIdAlmacen;
	}

	public void setLogicaIdAlmacen(BigDecimal logicaIdAlmacen) {
		this.logicaIdAlmacen = logicaIdAlmacen;
	}

	public BigDecimal getLogicaIdCarpeta() {
		return logicaIdCarpeta;
	}

	public void setLogicaIdCarpeta(BigDecimal logicaIdCarpeta) {
		this.logicaIdCarpeta = logicaIdCarpeta;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
