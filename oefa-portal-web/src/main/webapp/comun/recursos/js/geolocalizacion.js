$mtmin = 50;
$latitud = 0
$longitud = 0;

function GetComputerName() {
        var network = new ActiveXObject('WScript.Network');
        // Show a pop up if it works
        alert(network.computerName);
}

function funcionInit(coordJson) {

	 GetComputerName();
	
	 let datos = coordJson;
     console.log(datos);
    
	if (!"geolocation" in navigator) {
		alert("Tu navegador no soporta el acceso a la ubicación. Intenta con otro");
		return false;
	}

	const onUbicacionConcedida = ubicacion => {
		
		let navegador = navigator.userAgent;
        if (navigator.userAgent.match(/Android/i) || navigator.userAgent.match(/webOS/i) || navigator.userAgent.match(/iPhone/i) || navigator.userAgent.match(/iPad/i) || navigator.userAgent.match(/iPod/i) || navigator.userAgent.match(/BlackBerry/i) || navigator.userAgent.match(/Windows Phone/i)) {
            console.log("Estás usando un dispositivo móvil!!");
        } else {
            console.log("No estás usando un móvil");
        }
		
		console.log("Tengo la ubicación: ", ubicacion);
		const coordenadas = ubicacion.coords;
		$latitud = coordenadas.latitude;
		$longitud = coordenadas.longitude;
		
		//metro
		//-12.0897446, -77.0578492
		
		// puerta principal oefa
		// -12.0896643, -77.0582106
		
		// piso 18
		// -12.0892813,-77.05801
		// -12.089345, -77.0579855
		
		// av. eeuu
		// -12.089294168350595, -77.0585957190011
		
		//const $mt = calcularDistanciaEntreDosCoordenadas(-12.0896643, -77.0582106,-12.089388258009098, -77.05840528245196);
		
		const valido = false;
		
		for (let item in datos) {                
		   console.log('item '+ datos[item]);  
		   const $mt = calcularDistanciaEntreDosCoordenadas($latitud, $longitud,datos[item].latitud,datos[item].longitud);
		   console.log('$mt ' + $mt);
		   if($mt <= $mtmin){
			   valido = true;
			   break;
		   }
		}
		
		if(!valido){
			alert("No puedes marcar: (lat:" + $latitud + " lon:" + $longitud + ")" );
			return false;
		}
		else{
			document.getElementById('idwasmarcar:btnSave').click();
			return true;
		}
		
	};
	
	const onErrorDeUbicacion = err => {
		console.log("Error obteniendo ubicación: ", err);
		return false;
	};

	const opcionesDeSolicitud = {
		enableHighAccuracy: true, // Alta precisión
		maximumAge: 0, // No queremos caché
		timeout: 5000 // Esperar solo 5 segundos
	};
	
	const gradosARadianes = (grados) => {
		return grados * Math.PI / 180;
	};
	
	const calcularDistanciaEntreDosCoordenadas = (lat1, lon1, lat2, lon2) => {
		// Convertir todas las coordenadas a radianes
	    lat1 = gradosARadianes(lat1);
	    lon1 = gradosARadianes(lon1);
	    lat2 = gradosARadianes(lat2);
	    lon2 = gradosARadianes(lon2);
	    // Aplicar fórmula
	    const RADIO_TIERRA_EN_KILOMETROS = 6371;
	    let diferenciaEntreLongitudes = (lon2 - lon1);
	    let diferenciaEntreLatitudes = (lat2 - lat1);
	    let a = Math.pow(Math.sin(diferenciaEntreLatitudes / 2.0), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(diferenciaEntreLongitudes / 2.0), 2);
	    let c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    return RADIO_TIERRA_EN_KILOMETROS * c * 1000;
	};

	navigator.geolocation.getCurrentPosition(onUbicacionConcedida, onErrorDeUbicacion, opcionesDeSolicitud);

	return true;
};
// document.addEventListener("DOMContentLoaded", funcionInit);
