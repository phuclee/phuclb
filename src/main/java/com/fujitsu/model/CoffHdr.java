package com.fujitsu.model;

public class CoffHdr {

	private int			Machine;  // 0-1
	private int			NumberOfSections; //2-3
	private int				TimeDateStamp; //4-7
	private int				PointerToSymbolTable;//8-11
	private int				NumberOfSymbols;//12-15
	private int			SizeOfOptionalHeader;//16-17
	private int			Characteristics;//18-19
	public int getMachine() {
		return Machine;
	}
	public void setMachine(int machine) {
		Machine = machine;
	}
	public int getNumberOfSections() {
		return NumberOfSections;
	}
	public void setNumberOfSections(int numberOfSections) {
		NumberOfSections = numberOfSections;
	}
	public int getTimeDateStamp() {
		return TimeDateStamp;
	}
	public void setTimeDateStamp(int timeDateStamp) {
		TimeDateStamp = timeDateStamp;
	}
	public int getPointerToSymbolTable() {
		return PointerToSymbolTable;
	}
	public void setPointerToSymbolTable(int pointerToSymbolTable) {
		PointerToSymbolTable = pointerToSymbolTable;
	}
	public int getNumberOfSymbols() {
		return NumberOfSymbols;
	}
	public void setNumberOfSymbols(int numberOfSymbols) {
		NumberOfSymbols = numberOfSymbols;
	}
	public int getSizeOfOptionalHeader() {
		return SizeOfOptionalHeader;
	}
	public void setSizeOfOptionalHeader(int sizeOfOptionalHeader) {
		SizeOfOptionalHeader = sizeOfOptionalHeader;
	}
	public int getCharacteristics() {
		return Characteristics;
	}
	public void setCharacteristics(int characteristics) {
		Characteristics = characteristics;
	}
	
	
	
}
