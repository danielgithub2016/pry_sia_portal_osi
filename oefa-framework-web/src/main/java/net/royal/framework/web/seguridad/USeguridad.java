package net.royal.framework.web.seguridad;

import java.net.InetAddress;

public class USeguridad {
	public static String obtenerIpAddressLogin() throws Exception {
		String ipAddressLogin,hostNameLogin;
		InetAddress local = InetAddress.getLocalHost();
		InetAddress ip = InetAddress.getByName("" + local.getHostAddress());
		String[] partesIpHost = ip.getLocalHost().toString().split("/");
		ipAddressLogin = partesIpHost[1];
		// hostNameLogin = partesIpHost[0];
		return ipAddressLogin;
	}
	
	public static String obtenerHostNameLogin() throws Exception {
		String ipAddressLogin,hostNameLogin;
		InetAddress local = InetAddress.getLocalHost();
		InetAddress ip = InetAddress.getByName("" + local.getHostAddress());
		String[] partesIpHost = ip.getLocalHost().toString().split("/");
		//ipAddressLogin = partesIpHost[1];
		hostNameLogin = partesIpHost[0];
		return hostNameLogin;
	}
}
