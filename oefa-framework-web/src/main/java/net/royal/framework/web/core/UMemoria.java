package net.royal.framework.web.core;

public class UMemoria {
	
	public static void pasarGarbageCollector(){
		try {
			Runtime garbage = Runtime.getRuntime();
			garbage.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
}
