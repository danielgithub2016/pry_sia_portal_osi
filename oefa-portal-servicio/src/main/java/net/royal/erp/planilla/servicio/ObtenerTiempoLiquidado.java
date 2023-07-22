package net.royal.erp.planilla.servicio;

import java.util.ArrayList;

public class ObtenerTiempoLiquidado {

   public ObtenerTiempoLiquidado() {
   }

    public static String TraeLiquidacion(ArrayList<String> tiempocancelar) {
    	String tiempoliquidado;
    	Integer meses =0,mesesacumulado=0,ano=0,dias=0,diasacumulado=0;
    	String cadena="";
    	
    	for(int i=0;i<tiempocancelar.size();i++){
    				meses =Integer.parseInt(tiempocancelar.get(i).substring(2,4));
    				dias =Integer.parseInt(tiempocancelar.get(i).substring(4,6));
    				mesesacumulado=mesesacumulado + meses; 
    				diasacumulado =diasacumulado + dias;
    				if(diasacumulado >= 30){
    					mesesacumulado=mesesacumulado + 1;
    	    			diasacumulado=diasacumulado - 30;
    				}   					
    				if(mesesacumulado >= 12) {
    					ano=ano + 1;
    	    			mesesacumulado=mesesacumulado - 12;
    				}
    	}

    			if(ano >0 && ano <= 1) {
    				cadena=ano +" Año ";
    			}
    			if(ano > 1) {
    				cadena=ano +" Años ";
    			}
    			if(mesesacumulado > 0) {
    				cadena= cadena+mesesacumulado +" meses ";
    			}	
    			if (diasacumulado > 0) {
    				cadena=cadena+ diasacumulado +" días ";
    			}	
    			
    			tiempoliquidado=cadena;
    			return tiempoliquidado;
    }


}

