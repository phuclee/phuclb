/**
 * 
 */
/**
 * @author PhucLB
 *
 */
package com.fujitsu.model;
public class DivInfo{
	private char[] szSign;          //0-7
	private char[]  szPrefix;		//8-14	
	private char[]  szSrcFile;		//15-xx
	private int dwFD1Size;
	private int dwSrcFileSize;
	private int dwDivSize;
	private int dwNum;
	private int dwFileAttrib;
	private char[]  bSum;
	private FileTime ftC;
	private FileTime ftW;
	private FileTime ftR;
	public char[] getSzSign() {
		return szSign;
	}
	public void setSzSign(char[] szSign) {
		this.szSign = szSign;
	}
	public char[] getSzPrefix() {
		return szPrefix;
	}
	public void setSzPrefix(char[] szPrefix) {
		this.szPrefix = szPrefix;
	}
	public char[] getSzSrcFile() {
		return szSrcFile;
	}
	public void setSzSrcFile(char[] szSrcFile) {
		this.szSrcFile = szSrcFile;
	}
	public int getDwFD1Size() {
		return dwFD1Size;
	}
	public void setDwFD1Size(int dwFD1Size) {
		this.dwFD1Size = dwFD1Size;
	}
	public int getDwSrcFileSize() {
		return dwSrcFileSize;
	}
	public void setDwSrcFileSize(int dwSrcFileSize) {
		this.dwSrcFileSize = dwSrcFileSize;
	}
	public int getDwDivSize() {
		return dwDivSize;
	}
	public void setDwDivSize(int dwDivSize) {
		this.dwDivSize = dwDivSize;
	}
	public int getDwNum() {
		return dwNum;
	}
	public void setDwNum(int dwNum) {
		this.dwNum = dwNum;
	}
	public int getDwFileAttrib() {
		return dwFileAttrib;
	}
	public void setDwFileAttrib(int dwFileAttrib) {
		this.dwFileAttrib = dwFileAttrib;
	}
	public char[] getbSum() {
		return bSum;
	}
	public void setbSum(char[] bSum) {
		this.bSum = bSum;
	}
	public FileTime getFtC() {
		return ftC;
	}
	public void setFtC(FileTime ftC) {
		this.ftC = ftC;
	}
	public FileTime getFtW() {
		return ftW;
	}
	public void setFtW(FileTime ftW) {
		this.ftW = ftW;
	}
	public FileTime getFtR() {
		return ftR;
	}
	public void setFtR(FileTime ftR) {
		this.ftR = ftR;
	}
	
	
}