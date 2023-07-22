package net.royal.erp.sistema.syroyal.estructura;

public class Syroyal {
	private StrGlobal strGlobal;
	private StrPass strPass;

	public Syroyal() {
		strGlobal = new StrGlobal();
		strPass = new StrPass();
	}

	public StrGlobal StrGlobal() {
		return strGlobal;
	}

	public StrPass StrPass() {
		return strPass;
	}

}
