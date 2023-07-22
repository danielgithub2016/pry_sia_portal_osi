PrimeFaces.locales['es'] = {
	closeText : 'Cerrar',
	prevText : 'Anterior',
	nextText : 'Siguiente',
	monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
			'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
			'Diciembre' ],
	monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago',
			'Sep', 'Oct', 'Nov', 'Dic' ],
	dayNames : [ 'Domingo', 'Lunes', 'Martes', 'MiÃƒÂ©rcoles', 'Jueves',
			'Viernes', 'SÃƒÂ¡bado' ],
	dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab' ],
	dayNamesMin : [ 'D', 'L', 'M', 'X', 'J', 'V', 'S' ],
	weekHeader : 'Semana',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	timeOnlyTitle : 'S&oacute;lo hora',
	timeText : 'Tiempo',
	hourText : 'Hora',
	minuteText : 'Minuto',
	secondText : 'Segundo',
	currentText : 'Fecha actual',
	ampm : false,
	month : 'Mes',
	week : 'Semana',
	day : 'DÃƒÂ­a',
	allDayText : 'Todo el dÃƒÂ­a'
};

function selectTipoDocumento(source, controlIdTarget) {
	switch (source.value) {
	case "D": // DNI
		assignMaxlength(controlIdTarget, 8);
		break;
	case "P": // Pasaporte
		assignMaxlength(controlIdTarget, 6);
		break;
	case "X": // Carnet extranjeria
		assignMaxlength(controlIdTarget, 8);
		break;
	case "R": // RUC
		assignMaxlength(controlIdTarget, 11);
		break;
	}
}

function ValidarNumeroDecimal(evt) {
	var key = evt.which ? evt.which : evt.keyCode;
	return (key <= 13 || (key >= 48 && key <= 57) || key == 46);
}

function ValidarNumero(evt) {
	var key = evt.which ? evt.which : evt.keyCode;
	return (key <= 13 || (key >= 48 && key <= 57));
}

function validarIngreso(e, opcion) {

	tecla = (document.all) ? e.keyCode : e.which;

	if (tecla == 0 || tecla == 8 || tecla == 127)
		return true;

	if (opcion == 'T') {
		patron = /[A-Za-z\/\d\sÃ¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½!Ã¯Â¿Â½$%&()=?Ã¯Â¿Â½^*Ã¯Â¿Â½Ã¯Â¿Â½;:_,.Ã¯Â¿Â½Ã¯Â¿Â½`+Ã¯Â¿Â½@\-\\]/; // Todo
	} else if (opcion == 'L') {
		patron = /[a-zA-Z \xc0-\xff]/; // Letras Mayusculas, Minusculas y
		// Acentuadas, Espacio en blanco
	} else if (opcion == 'N') {
		patron = /[\d.]/; // NÃ¯Â¿Â½meros
	} else if (opcion == 'NF') {
		// patron = /^\d{2}\/\d{2}\/\d{4}$/; // NÃ¯Â¿Â½meros - Fecha
		patron = /[\/\d]/; // NÃ¯Â¿Â½meros - Fecha
	} else if (opcion == 'NH') {
		// patron = /^(0\d|1\d|2[0-3]):([0-5]\d)$/; // NÃ¯Â¿Â½meros - Hora
		patron = /[\d:]/; // NÃ¯Â¿Â½meros - Hora
	} else if (opcion == 'LM') {
		patron = /[A-Z]/; // Letras Mayusculas
	} else if (opcion == 'Lm') {
		patron = /[a-z]/; // Letras minusculas
	} else if (opcion == 'NL') {
		patron = /\w/; // NÃ¯Â¿Â½meros y Letras
	} else if (opcion == 'C') { // Correo electronico
		patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/;
	} else if (opcion == 'PretEcon') {
		// Caja de texto de pretension economica (frm_TabDatosPersonales.jspx)
		// Caja de texto para total horas (fda_AcademicosCursos.jspx)
		// Caja de texto de sueldo (fel_Experiencia.jspx)
		patron = /[\d.]/;
	} else if (opcion == 'TN') {
		// Letras Mayusculas, Minusculas,Acentuadas, guion, guion bajo,
		// punto y coma
		patron = /[a-zA-Z \xc0-\xff\-\_\,.\\\/\d]/;
	} else if (opcion == 'ResEjec') {
		// Caja de texto de Resumen Ejecutivo
		patron = /[a-zA-Z \xc0-\xff\d\,.:-_]/;
	} else if (opcion == 'Domic') {
		// Caja de texto de Resumen Ejecutivo
		patron = /[a-zA-Z \xc0-\xff\d\,;:.]/;
	} else if (opcion == 'nomCurso') {
		// Caja de texto de Resumen Ejecutivo
		patron = /[a-zA-Z \xc0-\xff\,;:.]/;
	}

	te = String.fromCharCode(tecla);

	return patron.test(te);
}

function validarIngresoMaximo(e, opcion) {

	tecla = (document.all) ? e.keyCode : e.which;

	if (tecla == 0 || tecla == 8 || tecla == 127)
		return true;

	if (opcion == 'T') {
		patron = /[A-Za-z\/\d\sÃ¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½Ã¯Â¿Â½!Ã¯Â¿Â½$%&()=?Ã¯Â¿Â½^*Ã¯Â¿Â½Ã¯Â¿Â½;:_,.Ã¯Â¿Â½Ã¯Â¿Â½`+Ã¯Â¿Â½@-]/; // Todo
		document.getElementById("frmRegistrar:txtValor").maxLength = 200;
	} else if (opcion == 'NL') {
		patron = /\w/; // NÃ¯Â¿Â½meros y Letras
		document.getElementById("frmRegistrar:txtValor").maxLength = 50;
	} else if (opcion == 'N') {
		patron = /\d/; // NÃ¯Â¿Â½meros
		document.getElementById("frmRegistrar:txtValor").maxLength = 20;
	} else if (opcion == 'NF') {
		// patron = /^\d{2}\/\d{2}\/\d{4}$/; // NÃ¯Â¿Â½meros - Fecha
		patron = /[\/\d]/; // NÃ¯Â¿Â½meros - Fecha
		document.getElementById("frmRegistrar:txtValor").maxLength = 10;
	}

	te = String.fromCharCode(tecla);

	return patron.test(te);
}

function estadoFiltroFPIM() {

	if (document.getElementById("frmprogramacionim:chkFecSolicitud_input").checked == true) {
		document.getElementById("frmprogramacionim:chkFecSolicitud_input")
				.nodeName("span").className = "hola";
	}

	document.getElementById("frmprogramacionim:chkCodInasistencia_input").checked = false;
	document.getElementById("frmprogramacionim:chkNomMedico_input").checked = false;
	document.getElementById("frmprogramacionim:chkPeriodo_input").checked = false;
	document.getElementById("frmprogramacionim:chkFecSolicitud_input").checked = false;
	document.getElementById("frmprogramacionim:chkMedico_input").checked = false;
	document.getElementById("frmprogramacionim:txtCodInasistencia").disabled = false;
	document.getElementById("frmprogramacionim:txtCMP").disabled = false;
	document.getElementById("frmprogramacionim:txtMedico").disabled = false;
	document.getElementById("frmprogramacionim:txtNomMedico").disabled = false;
	document.getElementById("frmprogramacionim:fecIni_input").disabled = false;
	document.getElementById("frmprogramacionim:cboOpFec").disabled = false;
	document.getElementById("frmprogramacionim:fecFin_input").disabled = false;
	document.getElementById("frmprogramacionim:txtPeriodo").disabled = false;
	document.getElementById("frmprogramacionim:btnBuscarMedico").disabled = false;

}

function mostrarIndCompa() {
	if (document.getElementById("frmHorarios:chkindcompa_input").checked == true) {
		document.getElementById("frmHorarios:cboIndCompa").style.display = "";
	} else {
		document.getElementById("frmHorarios:cboIndCompa").style.display = "none";
	}
}

function validarOpcionFechas() {

	if (document.getElementById("frmprogramacionim:cboOpFec").value == "[]") {
		document.getElementById("frmprogramacionim:fecFin_input").value = fecFin;
		document.getElementById("frmprogramacionim:fecFin_input").style.display = "";
	} else {
		document.getElementById("frmprogramacionim:fecFin_input").value = "01/01/1900";
		document.getElementById("frmprogramacionim:fecFin_input").style.display = "none";
	}

}

function noAcepto(e) {
	
	console.log("validando..");
	invalido = '#Ã‚Â¨Ã‚Â¨*?![]%&$';
	tecla = (document.all) ? e.keyCode : e.which;
	tecla = String.fromCharCode(tecla);
	if (invalido.indexOf(tecla) != -1)
		return false;
}

function validarOpcionFechasReprogra() {

	if (document.getElementById("frmReprograCitaInasMedico:cboFecProc").value == "[]") {
		document.getElementById("frmReprograCitaInasMedico:fecProc2_input").value = fecProc2;
		document.getElementById("frmReprograCitaInasMedico:fecProc2_input").style.display = "";
	} else {
		document.getElementById("frmReprograCitaInasMedico:fecProc2_input").value = "01/01/1900";
		document.getElementById("frmReprograCitaInasMedico:fecProc2_input").style.display = "none";
	}

}

function formateaSegundos(value) {
	var sec_num = parseInt(value, 10);

	if (sec_num < 0)
		sec_num = sec_num * -1;

	var days = Math.floor(sec_num / 86400);
	var hours = Math.floor((sec_num % 86400) / 3600);
	var minutes = Math.floor(((sec_num % 86400) % 3600) / 60);
	var seconds = ((sec_num % 86400) % 3600) % 60;

	if (days < 10) {
		days = "0" + days;
	}
	if (hours < 10) {
		hours = "0" + hours;
	}
	if (minutes < 10) {
		minutes = "0" + minutes;
	}
	if (seconds < 10) {
		seconds = "0" + seconds;
	}
	var time = 'Te quedan ' + days + ' d&iacute;as, ' + hours + ' horas, y ' + minutes
			+ ' minutos , para participar de la actividad m&aacute;s cercana.';

	return time;
}


function clock() {
	var time = new Date(document.getElementById('idwasmarcar:relojito').value);
	time.setSeconds(time.getSeconds()+1);
	
	var yy = time.getFullYear();
	var dd = time.getDate();
	var mm = time.getMonth() + 1;
	var hr = time.getHours();
	var min = time.getMinutes();
	var sec = time.getSeconds();
	
	
//	if (hr > 12) {
//		hr -= 12;
//	}
	if (mm < 10) {
		mm = "0" + mm;
	}
	if (dd < 10) {
		dd = "0" + dd;
	}
	if (hr < 10) {
		hr = "0" + hr;
	}
	if (min < 10) {
		min = "0" + min;
	}
	if (sec < 10) {
		sec = "0" + sec;
	}
	
	try {
		document.getElementById('idwasmarcar:relojito').value = yy + "/" + mm + "/" + dd + " " + hr + ":"
				+ min + ":" + sec;
		console.log("No hay error : El reloj ha sido construido.");
	} catch (err) {
	}
	
	setTimeout("clock()", 1000);
}




function ejecutarapplet(docs) {
	document.getElementById('DocumentosSinFirma').value = docs;
	var applet = document.appletxxx;
	//applet.preFirma();
}

function configurarapplet() {
	alert('configurarapplet');
	var applet = document.appletxxx;
	applet.preConfiguracion();
}

