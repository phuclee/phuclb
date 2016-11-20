package com.fujitsu.model;

public class OptHdr {

	private StdHdr					std;
	private WinHdr					win;
	
	private String	idd; //max 16
	public StdHdr getStd() {
		return std;
	}
	public void setStd(StdHdr std) {
		this.std = std;
	}
	public WinHdr getWin() {
		return win;
	}
	public void setWin(WinHdr win) {
		this.win = win;
	}
	public String getIdd() {
		return idd;
	}
	public void setIdd(String idd) {
		this.idd = idd;
	}

	
}
