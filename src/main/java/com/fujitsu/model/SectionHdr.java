package com.fujitsu.model;

public class SectionHdr {

	private String			Name;                      //max character 8   0-7
	private int			VirtualSize;					//	* 				8-11
	private int			VirtualAddress;					//	*				12-15
	private int			SizeOfRawData;					//	*				16-19
	private int			PointerToRawData;				//	*				20-23
	private int			PointerToRelocations;					//			24-27
	private int			PointerToLinenumbers;					//			28-31
	private short			NumberOfRelocations;				//			32-33
	private short			NumberOfLinenumbers;				//			34-35
	private int			Characteristics;						//			36-39
	public String getName() {						
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getVirtualSize() {
		return VirtualSize;
	}
	public void setVirtualSize(int virtualSize) {
		VirtualSize = virtualSize;
	}
	public int getVirtualAddress() {
		return VirtualAddress;
	}
	public void setVirtualAddress(int virtualAddress) {
		VirtualAddress = virtualAddress;
	}
	public int getSizeOfRawData() {
		return SizeOfRawData;
	}
	public void setSizeOfRawData(int sizeOfRawData) {
		SizeOfRawData = sizeOfRawData;
	}
	public int getPointerToRawData() {
		return PointerToRawData;
	}
	public void setPointerToRawData(int pointerToRawData) {
		PointerToRawData = pointerToRawData;
	}
	public int getPointerToRelocations() {
		return PointerToRelocations;
	}
	public void setPointerToRelocations(int pointerToRelocations) {
		PointerToRelocations = pointerToRelocations;
	}
	public int getPointerToLinenumbers() {
		return PointerToLinenumbers;
	}
	public void setPointerToLinenumbers(int pointerToLinenumbers) {
		PointerToLinenumbers = pointerToLinenumbers;
	}
	public short getNumberOfRelocations() {
		return NumberOfRelocations;
	}
	public void setNumberOfRelocations(short numberOfRelocations) {
		NumberOfRelocations = numberOfRelocations;
	}
	public short getNumberOfLinenumbers() {
		return NumberOfLinenumbers;
	}
	public void setNumberOfLinenumbers(short numberOfLinenumbers) {
		NumberOfLinenumbers = numberOfLinenumbers;
	}
	public int getCharacteristics() {
		return Characteristics;
	}
	public void setCharacteristics(int characteristics) {
		Characteristics = characteristics;
	}
	
	

}
