package com.fujitsu.model;

public class WinHdr {

	private int			ImageBase;						//0-3
	private int			SectionAlignment;				//4-7
	private int			FileAlignment;					//8-11
	private int			MajorOperatingSystemVersion;	//12-13
	private int			MinorOperatingSystemVersion;
	private int			MajorImageVersion;
	private int			MinorImageVersion;
	private int			MajorSubsystemVersion;
	private int			MinorSubsystemVersion;
	private int			Reserved;
	private int			SizeOfImage;				//	*
	private int			SizeOfHeaders;
	private int			CheckSum;
	private int			Subsystem;
	private int			DllCharacteristics;
	private int			SizeOfStackReserve;
	private int			SizeOfStackCommit;
	private int			SizeOfHeapReserve;
	private int			SizeOfHeapCommit;
	private int			LoaderFlags;
	private int			NumberOfRvaAndSizes;
	public int getImageBase() {
		return ImageBase;
	}
	public void setImageBase(int imageBase) {
		ImageBase = imageBase;
	}
	public int getSectionAlignment() {
		return SectionAlignment;
	}
	public void setSectionAlignment(int sectionAlignment) {
		SectionAlignment = sectionAlignment;
	}
	public int getFileAlignment() {
		return FileAlignment;
	}
	public void setFileAlignment(int fileAlignment) {
		FileAlignment = fileAlignment;
	}
	public int getMajorOperatingSystemVersion() {
		return MajorOperatingSystemVersion;
	}
	public void setMajorOperatingSystemVersion(int majorOperatingSystemVersion) {
		MajorOperatingSystemVersion = majorOperatingSystemVersion;
	}
	public int getMinorOperatingSystemVersion() {
		return MinorOperatingSystemVersion;
	}
	public void setMinorOperatingSystemVersion(int minorOperatingSystemVersion) {
		MinorOperatingSystemVersion = minorOperatingSystemVersion;
	}
	public int getMajorImageVersion() {
		return MajorImageVersion;
	}
	public void setMajorImageVersion(int majorImageVersion) {
		MajorImageVersion = majorImageVersion;
	}
	public int getMinorImageVersion() {
		return MinorImageVersion;
	}
	public void setMinorImageVersion(int minorImageVersion) {
		MinorImageVersion = minorImageVersion;
	}
	public int getMajorSubsystemVersion() {
		return MajorSubsystemVersion;
	}
	public void setMajorSubsystemVersion(int majorSubsystemVersion) {
		MajorSubsystemVersion = majorSubsystemVersion;
	}
	public int getMinorSubsystemVersion() {
		return MinorSubsystemVersion;
	}
	public void setMinorSubsystemVersion(int minorSubsystemVersion) {
		MinorSubsystemVersion = minorSubsystemVersion;
	}
	public int getReserved() {
		return Reserved;
	}
	public void setReserved(int reserved) {
		Reserved = reserved;
	}
	public int getSizeOfImage() {
		return SizeOfImage;
	}
	public void setSizeOfImage(int sizeOfImage) {
		SizeOfImage = sizeOfImage;
	}
	public int getSizeOfHeaders() {
		return SizeOfHeaders;
	}
	public void setSizeOfHeaders(int sizeOfHeaders) {
		SizeOfHeaders = sizeOfHeaders;
	}
	public int getCheckSum() {
		return CheckSum;
	}
	public void setCheckSum(int checkSum) {
		CheckSum = checkSum;
	}
	public int getSubsystem() {
		return Subsystem;
	}
	public void setSubsystem(int subsystem) {
		Subsystem = subsystem;
	}
	public int getDllCharacteristics() {
		return DllCharacteristics;
	}
	public void setDllCharacteristics(int dllCharacteristics) {
		DllCharacteristics = dllCharacteristics;
	}
	public int getSizeOfStackReserve() {
		return SizeOfStackReserve;
	}
	public void setSizeOfStackReserve(int sizeOfStackReserve) {
		SizeOfStackReserve = sizeOfStackReserve;
	}
	public int getSizeOfStackCommit() {
		return SizeOfStackCommit;
	}
	public void setSizeOfStackCommit(int sizeOfStackCommit) {
		SizeOfStackCommit = sizeOfStackCommit;
	}
	public int getSizeOfHeapReserve() {
		return SizeOfHeapReserve;
	}
	public void setSizeOfHeapReserve(int sizeOfHeapReserve) {
		SizeOfHeapReserve = sizeOfHeapReserve;
	}
	public int getSizeOfHeapCommit() {
		return SizeOfHeapCommit;
	}
	public void setSizeOfHeapCommit(int sizeOfHeapCommit) {
		SizeOfHeapCommit = sizeOfHeapCommit;
	}
	public int getLoaderFlags() {
		return LoaderFlags;
	}
	public void setLoaderFlags(int loaderFlags) {
		LoaderFlags = loaderFlags;
	}
	public int getNumberOfRvaAndSizes() {
		return NumberOfRvaAndSizes;
	}
	public void setNumberOfRvaAndSizes(int numberOfRvaAndSizes) {
		NumberOfRvaAndSizes = numberOfRvaAndSizes;
	}
	
	
}