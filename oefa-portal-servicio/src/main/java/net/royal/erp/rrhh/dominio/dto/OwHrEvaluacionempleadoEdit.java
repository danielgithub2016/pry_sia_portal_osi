package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OwHrEvaluacionempleadoEdit implements Serializable {

	private boolean cbseguimiento_visible;
	private boolean dwevaluacionperiodo_disable;
	private boolean dwevaluacionjefeorgano_disable;
	private boolean dwevaluacioncomentariorevisor_disable;
	private boolean dwevaluacion_disable;
	private boolean dwevaluacioncodigoempleado_disable;
	private boolean dwevaluacioncodigosupervisor_disable;
	private boolean p1_visible;
	private boolean p2_visible;
	private boolean p3_visible;
	private boolean p5_visible;
	private boolean p6_visible;
	private boolean p7_visible;
	private boolean p8_visible;
	private boolean p9_visible;
	private boolean p10_visible;
	private boolean p11_visible;
	private boolean p12_visible;
	private boolean p16_visible;
	private boolean p17_visible;
	private boolean p18_visible;
	private boolean p19_visible;
	private boolean dw1_disable;
	private boolean dw2_disable;
	private boolean dw3_disable;
	private boolean dw5_disable;
	private boolean dw6_disable;
	private boolean dw7_disable;
	private boolean dw8_disable;
	private boolean dw9_disable;
	private boolean dw10_disable;
	private boolean dw11_disable;
	private boolean dwcampo_disable;
	private boolean dw19_disable;
	private boolean dwcomentario_disable;
	private boolean dwcompromisomejora_disable;
	private boolean p5cbagregar_disable;
	private boolean p5cbeliminar_disable;
	private boolean p1cb1_disable;
	private boolean p1cb2_disable;
	private boolean p1cbimprimir_disable;
	private boolean p7cbagregacapacita_disable;
	private boolean p7cbeliminacapacita_disable;
	private boolean p7cbseleccionar;
	private boolean p10cbagregaconsidera_disable;
	private boolean p11cbagregarfuncion_disable;
	private boolean p11cbeliminarfuncion_disable;
	private boolean p11cbcalificacionfunciones_disable;
	private boolean p12cbagregarcampo_disable;
	private boolean p12cbeliminarcampo_disable;
	private boolean p16cb4_disable;
	private boolean p16cb5_disable;
	private boolean ib_evaluar;

	private boolean mle_comentario;
	private boolean st_comentario;
	private boolean st_calificacion;
	private boolean em_calificacion;
	private boolean cb_compromiso;
	private boolean verValor;
	private boolean verValorhasta;
	private boolean dw_1visible;
	private boolean iv_eliminar;
	private String isEstadoDefault;

	public OwHrEvaluacionempleadoEdit() {
		ib_evaluar = true;
		isEstadoDefault = "CE";
		p1cb2_disable = false;
		p6_visible = true;
	}

	public boolean isCbseguimiento_visible() {
		return cbseguimiento_visible;
	}

	public void setCbseguimiento_visible(boolean cbseguimiento_visible) {
		this.cbseguimiento_visible = cbseguimiento_visible;
	}

	public boolean isDwevaluacionperiodo_disable() {
		return dwevaluacionperiodo_disable;
	}

	public void setDwevaluacionperiodo_disable(
			boolean dwevaluacionperiodo_disable) {
		this.dwevaluacionperiodo_disable = dwevaluacionperiodo_disable;
	}

	public boolean isP9_visible() {
		return p9_visible;
	}

	public void setP9_visible(boolean p9_visible) {
		this.p9_visible = p9_visible;
	}

	public boolean isP11_visible() {
		return p11_visible;
	}

	public void setP11_visible(boolean p11_visible) {
		this.p11_visible = p11_visible;
	}

	public boolean isP6_visible() {
		return p6_visible;
	}

	public void setP6_visible(boolean p6_visible) {
		this.p6_visible = p6_visible;
	}

	public boolean isP1_visible() {
		return p1_visible;
	}

	public void setP1_visible(boolean p1_visible) {
		this.p1_visible = p1_visible;
	}

	public boolean isDwevaluacionjefeorgano_disable() {
		return dwevaluacionjefeorgano_disable;
	}

	public void setDwevaluacionjefeorgano_disable(
			boolean dwevaluacionjefeorgano_disable) {
		this.dwevaluacionjefeorgano_disable = dwevaluacionjefeorgano_disable;
	}

	public boolean isDwevaluacioncomentariorevisor_disable() {
		return dwevaluacioncomentariorevisor_disable;
	}

	public void setDwevaluacioncomentariorevisor_disable(
			boolean dwevaluacioncomentariorevisor_disable) {
		this.dwevaluacioncomentariorevisor_disable = dwevaluacioncomentariorevisor_disable;
	}

	public boolean isDwevaluacion_disable() {
		return dwevaluacion_disable;
	}

	public void setDwevaluacion_disable(boolean dwevaluacion_disable) {
		this.dwevaluacion_disable = dwevaluacion_disable;
	}

	public boolean isDw1_disable() {
		return dw1_disable;
	}

	public void setDw1_disable(boolean dw1_disable) {
		this.dw1_disable = dw1_disable;
	}

	public boolean isDw2_disable() {
		return dw2_disable;
	}

	public void setDw2_disable(boolean dw2_disable) {
		this.dw2_disable = dw2_disable;
	}

	public boolean isDw3_disable() {
		return dw3_disable;
	}

	public void setDw3_disable(boolean dw3_disable) {
		this.dw3_disable = dw3_disable;
	}

	public boolean isDw5_disable() {
		return dw5_disable;
	}

	public void setDw5_disable(boolean dw5_disable) {
		this.dw5_disable = dw5_disable;
	}

	public boolean isDw6_disable() {
		return dw6_disable;
	}

	public void setDw6_disable(boolean dw6_disable) {
		this.dw6_disable = dw6_disable;
	}

	public boolean isDw7_disable() {
		return dw7_disable;
	}

	public void setDw7_disable(boolean dw7_disable) {
		this.dw7_disable = dw7_disable;
	}

	public boolean isDw8_disable() {
		return dw8_disable;
	}

	public void setDw8_disable(boolean dw8_disable) {
		this.dw8_disable = dw8_disable;
	}

	public boolean isDw9_disable() {
		return dw9_disable;
	}

	public void setDw9_disable(boolean dw9_disable) {
		this.dw9_disable = dw9_disable;
	}

	public boolean isDw10_disable() {
		return dw10_disable;
	}

	public void setDw10_disable(boolean dw10_disable) {
		this.dw10_disable = dw10_disable;
	}

	public boolean isDw11_disable() {
		return dw11_disable;
	}

	public void setDw11_disable(boolean dw11_disable) {
		this.dw11_disable = dw11_disable;
	}

	public boolean isDwcampo_disable() {
		return dwcampo_disable;
	}

	public void setDwcampo_disable(boolean dwcampo_disable) {
		this.dwcampo_disable = dwcampo_disable;
	}

	public boolean isDw19_disable() {
		return dw19_disable;
	}

	public void setDw19_disable(boolean dw19_disable) {
		this.dw19_disable = dw19_disable;
	}

	public boolean isDwcomentario_disable() {
		return dwcomentario_disable;
	}

	public void setDwcomentario_disable(boolean dwcomentario_disable) {
		this.dwcomentario_disable = dwcomentario_disable;
	}

	public boolean isDwcompromisomejora_disable() {
		return dwcompromisomejora_disable;
	}

	public void setDwcompromisomejora_disable(boolean dwcompromisomejora_disable) {
		this.dwcompromisomejora_disable = dwcompromisomejora_disable;
	}

	public boolean isP5cbagregar_disable() {
		return p5cbagregar_disable;
	}

	public void setP5cbagregar_disable(boolean p5cbagregar_disable) {
		this.p5cbagregar_disable = p5cbagregar_disable;
	}

	public boolean isP5cbeliminar_disable() {
		return p5cbeliminar_disable;
	}

	public void setP5cbeliminar_disable(boolean p5cbeliminar_disable) {
		this.p5cbeliminar_disable = p5cbeliminar_disable;
	}

	public boolean isP1cb1_disable() {
		return p1cb1_disable;
	}

	public void setP1cb1_disable(boolean p1cb1_disable) {
		this.p1cb1_disable = p1cb1_disable;
	}

	public boolean isP1cb2_disable() {
		return p1cb2_disable;
	}

	public void setP1cb2_disable(boolean p1cb2_disable) {
		this.p1cb2_disable = p1cb2_disable;
	}

	public boolean isP1cbimprimir_disable() {
		return p1cbimprimir_disable;
	}

	public void setP1cbimprimir_disable(boolean p1cbimprimir_disable) {
		this.p1cbimprimir_disable = p1cbimprimir_disable;
	}

	public boolean isP7cbagregacapacita_disable() {
		return p7cbagregacapacita_disable;
	}

	public void setP7cbagregacapacita_disable(boolean p7cbagregacapacita_disable) {
		this.p7cbagregacapacita_disable = p7cbagregacapacita_disable;
	}

	public boolean isP7cbeliminacapacita_disable() {
		return p7cbeliminacapacita_disable;
	}

	public void setP7cbeliminacapacita_disable(
			boolean p7cbeliminacapacita_disable) {
		this.p7cbeliminacapacita_disable = p7cbeliminacapacita_disable;
	}

	public boolean isP7cbseleccionar() {
		return p7cbseleccionar;
	}

	public void setP7cbseleccionar(boolean p7cbseleccionar) {
		this.p7cbseleccionar = p7cbseleccionar;
	}

	public boolean isP10cbagregaconsidera_disable() {
		return p10cbagregaconsidera_disable;
	}

	public void setP10cbagregaconsidera_disable(
			boolean p10cbagregaconsidera_disable) {
		this.p10cbagregaconsidera_disable = p10cbagregaconsidera_disable;
	}

	public boolean isP11cbagregarfuncion_disable() {
		return p11cbagregarfuncion_disable;
	}

	public void setP11cbagregarfuncion_disable(
			boolean p11cbagregarfuncion_disable) {
		this.p11cbagregarfuncion_disable = p11cbagregarfuncion_disable;
	}

	public boolean isP11cbeliminarfuncion_disable() {
		return p11cbeliminarfuncion_disable;
	}

	public void setP11cbeliminarfuncion_disable(
			boolean p11cbeliminarfuncion_disable) {
		this.p11cbeliminarfuncion_disable = p11cbeliminarfuncion_disable;
	}

	public boolean isP11cbcalificacionfunciones_disable() {
		return p11cbcalificacionfunciones_disable;
	}

	public void setP11cbcalificacionfunciones_disable(
			boolean p11cbcalificacionfunciones_disable) {
		this.p11cbcalificacionfunciones_disable = p11cbcalificacionfunciones_disable;
	}

	public boolean isP12cbagregarcampo_disable() {
		return p12cbagregarcampo_disable;
	}

	public void setP12cbagregarcampo_disable(boolean p12cbagregarcampo_disable) {
		this.p12cbagregarcampo_disable = p12cbagregarcampo_disable;
	}

	public boolean isP12cbeliminarcampo_disable() {
		return p12cbeliminarcampo_disable;
	}

	public void setP12cbeliminarcampo_disable(boolean p12cbeliminarcampo_disable) {
		this.p12cbeliminarcampo_disable = p12cbeliminarcampo_disable;
	}

	public boolean isP16cb4_disable() {
		return p16cb4_disable;
	}

	public void setP16cb4_disable(boolean p16cb4_disable) {
		this.p16cb4_disable = p16cb4_disable;
	}

	public boolean isP16cb5_disable() {
		return p16cb5_disable;
	}

	public void setP16cb5_disable(boolean p16cb5_disable) {
		this.p16cb5_disable = p16cb5_disable;
	}

	public boolean isP3_visible() {
		return p3_visible;
	}

	public void setP3_visible(boolean p3_visible) {
		this.p3_visible = p3_visible;
	}

	public boolean isP5_visible() {
		return p5_visible;
	}

	public void setP5_visible(boolean p5_visible) {
		this.p5_visible = p5_visible;
	}

	public boolean isP8_visible() {
		return p8_visible;
	}

	public void setP8_visible(boolean p8_visible) {
		this.p8_visible = p8_visible;
	}

	public boolean isP10_visible() {
		return p10_visible;
	}

	public void setP10_visible(boolean p10_visible) {
		this.p10_visible = p10_visible;
	}

	public boolean isP2_visible() {
		return p2_visible;
	}

	public void setP2_visible(boolean p2_visible) {
		this.p2_visible = p2_visible;
	}

	public boolean isP7_visible() {
		return p7_visible;
	}

	public void setP7_visible(boolean p7_visible) {
		this.p7_visible = p7_visible;
	}

	public boolean isP12_visible() {
		return p12_visible;
	}

	public void setP12_visible(boolean p12_visible) {
		this.p12_visible = p12_visible;
	}

	public boolean isP16_visible() {
		return p16_visible;
	}

	public void setP16_visible(boolean p16_visible) {
		this.p16_visible = p16_visible;
	}

	public boolean isP17_visible() {
		return p17_visible;
	}

	public void setP17_visible(boolean p17_visible) {
		this.p17_visible = p17_visible;
	}

	public boolean isP18_visible() {
		return p18_visible;
	}

	public void setP18_visible(boolean p18_visible) {
		this.p18_visible = p18_visible;
	}

	public boolean isIb_evaluar() {
		return ib_evaluar;
	}

	public void setIb_evaluar(boolean ib_evaluar) {
		this.ib_evaluar = ib_evaluar;
	}

	public boolean isMle_comentario() {
		return mle_comentario;
	}

	public void setMle_comentario(boolean mle_comentario) {
		this.mle_comentario = mle_comentario;
	}

	public boolean isSt_comentario() {
		return st_comentario;
	}

	public void setSt_comentario(boolean st_comentario) {
		this.st_comentario = st_comentario;
	}

	public boolean isSt_calificacion() {
		return st_calificacion;
	}

	public void setSt_calificacion(boolean st_calificacion) {
		this.st_calificacion = st_calificacion;
	}

	public boolean isEm_calificacion() {
		return em_calificacion;
	}

	public void setEm_calificacion(boolean em_calificacion) {
		this.em_calificacion = em_calificacion;
	}

	public boolean isCb_compromiso() {
		return cb_compromiso;
	}

	public void setCb_compromiso(boolean cb_compromiso) {
		this.cb_compromiso = cb_compromiso;
	}

	public boolean isVerValor() {
		return verValor;
	}

	public void setVerValor(boolean verValor) {
		this.verValor = verValor;
	}

	public boolean isVerValorhasta() {
		return verValorhasta;
	}

	public void setVerValorhasta(boolean verValorhasta) {
		this.verValorhasta = verValorhasta;
	}

	public boolean isDw_1visible() {
		return dw_1visible;
	}

	public void setDw_1visible(boolean dw_1visible) {
		this.dw_1visible = dw_1visible;
	}

	public boolean isIv_eliminar() {
		return iv_eliminar;
	}

	public void setIv_eliminar(boolean iv_eliminar) {
		this.iv_eliminar = iv_eliminar;
	}

	public String getIsEstadoDefault() {
		return isEstadoDefault;
	}

	public void setIsEstadoDefault(String isEstadoDefault) {
		this.isEstadoDefault = isEstadoDefault;
	}

	public boolean isDwevaluacioncodigoempleado_disable() {
		return dwevaluacioncodigoempleado_disable;
	}

	public void setDwevaluacioncodigoempleado_disable(
			boolean dwevaluacioncodigoempleado_disable) {
		this.dwevaluacioncodigoempleado_disable = dwevaluacioncodigoempleado_disable;
	}

	public boolean isDwevaluacioncodigosupervisor_disable() {
		return dwevaluacioncodigosupervisor_disable;
	}

	public void setDwevaluacioncodigosupervisor_disable(
			boolean dwevaluacioncodigosupervisor_disable) {
		this.dwevaluacioncodigosupervisor_disable = dwevaluacioncodigosupervisor_disable;
	}

	public boolean isP19_visible() {
		return p19_visible;
	}

	public void setP19_visible(boolean p19_visible) {
		this.p19_visible = p19_visible;
	}

}
