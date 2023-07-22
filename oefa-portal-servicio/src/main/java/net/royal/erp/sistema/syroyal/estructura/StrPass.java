package net.royal.erp.sistema.syroyal.estructura;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("rawtypes")
public class StrPass {
	private String[] s;
	private Integer d[];
	private boolean b;
	private Date dt[];
	private Integer[] lo;
	private BigDecimal de;
	private String s2;
	private List po[];

	public StrPass() {
		s = new String[11];
		d = new Integer[10];
		dt = new Date[10];
		po = new ArrayList[10];
		lo= new Integer[10]; 
	}

	public String[] getS() {
		return s;
	}

	public void setS(String[] s) {
		this.s = s;
	}

	public Integer[] getD() {
		return d;
	}

	public void setD(Integer[] d) {
		this.d = d;
	}

	public void setDt(Date[] dt) {
		this.dt = dt;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public BigDecimal getDe() {
		return de;
	}

	public void setDe(BigDecimal de) {
		this.de = de;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public Date[] getDt() {
		return dt;
	}

	public List[] getPo() {
		return po;
	}

	public void setPo(List[] po) {
		this.po = po;
	}

	public Integer[] getLo() {
		return lo;
	}

	public void setLo(Integer[] lo) {
		this.lo = lo;
	}


}
