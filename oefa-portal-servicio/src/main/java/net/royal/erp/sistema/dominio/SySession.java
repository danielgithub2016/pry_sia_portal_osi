package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySession
*/
public class SySession extends DominioGenerico implements java.io.Serializable{

	private SySessionPk pk;
	private String programname;
	private String hostname;
	private String ntusername;
	private String loginame;
	private String ipaddress;


	public SySession() {
		pk = new SySessionPk();
	}

	public SySessionPk getPk() {
		return pk;
	}

	public void setPk(SySessionPk pk) {
		this.pk = pk;
	}
	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getNtusername() {
		return ntusername;
	}

	public void setNtusername(String ntusername) {
		this.ntusername = ntusername;
	}
	public String getLoginame() {
		return loginame;
	}

	public void setLoginame(String loginame) {
		this.loginame = loginame;
	}
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

}
