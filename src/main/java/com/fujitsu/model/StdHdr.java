package com.fujitsu.model;

public class StdHdr {

	private int				Magic;                      //0-1
	private char			MajorLinkerVersion;			//2
	private char			MinorLinkerVersion;			//3
	private int				SizeOfCode;					//4-7
	private int				SizeOfInitializedData;		//8-11
	private int				SizeOfUninitializedData;	//12-15
	private int				AddressOfEntryPoint;		//16-19
	private int				BaseOfCode;					//20-23
	private int				BaseOfData;					//24-27
	public int getMagic() {
		return Magic;
	}
	public void setMagic(int magic) {
		Magic = magic;
	}
	public char getMajorLinkerVersion() {
		return MajorLinkerVersion;
	}
	public void setMajorLinkerVersion(char majorLinkerVersion) {
		MajorLinkerVersion = majorLinkerVersion;
	}
	public char getMinorLinkerVersion() {
		return MinorLinkerVersion;
	}
	public void setMinorLinkerVersion(char minorLinkerVersion) {
		MinorLinkerVersion = minorLinkerVersion;
	}
	public int getSizeOfCode() {
		return SizeOfCode;
	}
	public void setSizeOfCode(int sizeOfCode) {
		SizeOfCode = sizeOfCode;
	}
	public int getSizeOfInitializedData() {
		return SizeOfInitializedData;
	}
	public void setSizeOfInitializedData(int sizeOfInitializedData) {
		SizeOfInitializedData = sizeOfInitializedData;
	}
	public int getSizeOfUninitializedData() {
		return SizeOfUninitializedData;
	}
	public void setSizeOfUninitializedData(int sizeOfUninitializedData) {
		SizeOfUninitializedData = sizeOfUninitializedData;
	}
	public int getAddressOfEntryPoint() {
		return AddressOfEntryPoint;
	}
	public void setAddressOfEntryPoint(int addressOfEntryPoint) {
		AddressOfEntryPoint = addressOfEntryPoint;
	}
	public int getBaseOfCode() {
		return BaseOfCode;
	}
	public void setBaseOfCode(int baseOfCode) {
		BaseOfCode = baseOfCode;
	}
	public int getBaseOfData() {
		return BaseOfData;
	}
	public void setBaseOfData(int baseOfData) {
		BaseOfData = baseOfData;
	}
	
	

}
