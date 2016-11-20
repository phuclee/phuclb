package com.fujitsu;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.ArrayUtils;

import com.fujitsu.binarydata.PasteHdr;
import com.fujitsu.binarydata.PasteSection011;
import com.fujitsu.binarydata.PasteSection012;
import com.fujitsu.binarydata.PasteSection02;
import com.fujitsu.binarydata.PasteSection03;
import com.fujitsu.binarydata.PasteSection04;
import com.fujitsu.binarydata.PasteSection05;
import com.fujitsu.model.CoffHdr;
import com.fujitsu.model.DivInfo;
import com.fujitsu.model.OptHdr;
import com.fujitsu.model.ParamConst;
import com.fujitsu.model.SectionHdr;
import com.fujitsu.model.WinHdr;

/**
 * Hello World!
 */
public class SmallBinaryFiles {
	public static void main(String... aArgs) throws IOException {
		SmallBinaryFiles binary = new SmallBinaryFiles();
		CoffHdr pCoff = new CoffHdr();
		OptHdr pOpt = new OptHdr();
		SectionHdr pSect = new SectionHdr();
		/*
		 * byte[] bytes = binary.readSmallBinaryFile(FILE_NAME);
		 * log("Small - size of file read in:" + bytes.length);
		 * log("isExcutable : "+ Files.isExecutable(Paths.get(FILE_NAME)));
		 * binary.writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
		 */

		int off = convertByteToUnsightInt(PasteHdr.PasteHdrBin[(int)0x3c]);
		byte[] PasteSection01 = ArrayUtils.addAll(PasteSection011.PasteSection011bin,
				PasteSection012.PasteSection012bin);

		int indexCoff = off + 4;
		log(off);
		// get value pCoff
		byte[] numberOfSectionsBytes = new byte[] { PasteHdr.PasteHdrBin[indexCoff + 2],
				PasteHdr.PasteHdrBin[indexCoff + 3] };
		pCoff.setNumberOfSections(convert2ByteToIntValue(numberOfSectionsBytes));
		log(convert2ByteToIntValue(numberOfSectionsBytes));

		byte[] sizeOfOptionalHeaderBytes = new byte[] { PasteHdr.PasteHdrBin[indexCoff + 16],
				PasteHdr.PasteHdrBin[indexCoff + 17] };
		pCoff.setSizeOfOptionalHeader(convert2ByteToIntValue(sizeOfOptionalHeaderBytes));
		log(convert2ByteToIntValue(sizeOfOptionalHeaderBytes));

		int indexOpt = indexCoff+ParamConst.MAX_SIZE_COFFHDR;
		// get value pOpt
		byte[] sizeOfHeadersBytes = new byte[] { PasteHdr.PasteHdrBin[indexOpt +60],
				PasteHdr.PasteHdrBin[indexOpt  + 61], PasteHdr.PasteHdrBin[indexOpt  + 62],
				PasteHdr.PasteHdrBin[indexOpt  + 63] };
		WinHdr pWin = new WinHdr();
		pWin.setSizeOfHeaders(convert4ByteToIntValue(sizeOfHeadersBytes));
		pOpt.setWin(pWin);
		log(convert4ByteToIntValue(sizeOfHeadersBytes));
		DivInfo pdi = new DivInfo();
		//get value pSect
		int indexSect = indexOpt + pCoff.getSizeOfOptionalHeader();

		for (int dSection = 0; dSection< pCoff.getNumberOfSections();dSection++) {
			pSect = getDataFromSectionDhr(indexSect, dSection);
		
			if (pSect.getName().equals(ParamConst.SZSECTION_NAMEDATA)) {
				int indexOfPdi = 0;
				for (int dCnt = 0; dCnt < pSect.getSizeOfRawData();dCnt++){
					int indexSectionOfDivInfo = getIndexSectionOfDivInfo(dSection, dCnt);
					switch (indexSectionOfDivInfo)
					{
					
					case ParamConst.SECTION1:
						pdi = getDataFromDivInfo(PasteSection01, indexOfPdi);
						break;
					case ParamConst.SECTION2:
						pdi = getDataFromDivInfo(PasteSection02.PasteSection02bin, indexOfPdi);
						break;
					case ParamConst.SECTION3:
						pdi = getDataFromDivInfo(PasteSection03.PasteSection03bin, indexOfPdi);
						break;
					case ParamConst.SECTION4:
						pdi = getDataFromDivInfo(PasteSection04.PasteSection04bin, indexOfPdi);
						break;
					case ParamConst.SECTION5:
						pdi = getDataFromDivInfo(PasteSection05.PasteSection05bin, indexOfPdi);
						break;
						
					}
				}
			}
		}
		
		
		

	}

	final static String FILE_NAME = "D:\\New folder\\E1019301.exe";
	final static String OUTPUT_FILE_NAME = "D:\\New folder\\Copy.exe";

	byte[] readSmallBinaryFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		return Files.readAllBytes(path);
	}

	void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aBytes); // creates, overwrites
	}

	void getInfoFromBinaryData() {

	}

	Boolean isFileNeedSplit(String sourceFileName) {
		Boolean result = false;
		Path path = Paths.get(sourceFileName);
		File file = new File(path.toString());

		return result;
	}

	static int convert2ByteToIntValue(byte[] byteArray) {
		return ((byteArray[1] & 0xff) << 8) | (byteArray[0] & 0xff);
	}

	static int convert4ByteToIntValue(byte[] byteArray) {
		return ((byteArray[3] & 0xff) << 24) | ((byteArray[2] & 0xff) << 16) | ((byteArray[1] & 0xff) << 8)
				| (byteArray[0] & 0xff);
	}

	static int convertByteToUnsightInt(byte input) {
		return 0x00 << 24 | input & 0xff;
	}

	static SectionHdr getDataFromSectionDhr (int index, int no){
		SectionHdr sectionHdr = new SectionHdr();
		int currentIndex = index + no*40;
		byte[] nameBytes = new byte[] {PasteHdr.PasteHdrBin[currentIndex],PasteHdr.PasteHdrBin[currentIndex+1],
				PasteHdr.PasteHdrBin[currentIndex+2],PasteHdr.PasteHdrBin[currentIndex+3],
				PasteHdr.PasteHdrBin[currentIndex+4]};
		sectionHdr.setName(nameBytes.toString());
		
		byte[] sizeOfRawDataBytes = new byte[] {PasteHdr.PasteHdrBin[currentIndex+16],
				PasteHdr.PasteHdrBin[currentIndex+17],PasteHdr.PasteHdrBin[currentIndex+18],
				PasteHdr.PasteHdrBin[currentIndex+19]};
		sectionHdr.setSizeOfRawData(convert4ByteToIntValue(sizeOfRawDataBytes));
		
		return sectionHdr;
	}

	static int getIndexSectionOfDivInfo (int section, int index){
		int sectionIndex = 0;
		switch (section){
		case ParamConst.SECTION1:
			byte[] PasteSection01 = ArrayUtils.addAll(PasteSection011.PasteSection011bin,
					PasteSection012.PasteSection012bin);
			byte[] section1 = new byte[] {
					PasteSection01[index],PasteSection01[index+1],PasteSection01[index+2],
					PasteSection01[index+3],PasteSection01[index+4],PasteSection01[index+5]
			};
			if ((section1.equals(ParamConst.VALIDATE_SECTION))&&(PasteSection01[index+6]==0)) {
				sectionIndex = ParamConst.SECTION1;
			}
			break;
		case ParamConst.SECTION2:
			byte[] section2 = new byte[] {
					PasteSection02.PasteSection02bin[index],PasteSection02.PasteSection02bin[index+1],
					PasteSection02.PasteSection02bin[index+2],PasteSection02.PasteSection02bin[index+3],
					PasteSection02.PasteSection02bin[index+4],PasteSection02.PasteSection02bin[index+5]
			};
			if ((section2.equals(ParamConst.VALIDATE_SECTION))&&(PasteSection02.PasteSection02bin[index+6]==0)) {
				sectionIndex = ParamConst.SECTION2;
			}
			break;
		case ParamConst.SECTION3:
			byte[] section3 = new byte[] {
					PasteSection03.PasteSection03bin[index],PasteSection03.PasteSection03bin[index+1],
					PasteSection03.PasteSection03bin[index+2],PasteSection03.PasteSection03bin[index+3],
					PasteSection03.PasteSection03bin[index+4],PasteSection03.PasteSection03bin[index+5]
			};
			if ((section3.equals(ParamConst.VALIDATE_SECTION))&&(PasteSection03.PasteSection03bin[index+6]==0)) {
				sectionIndex = ParamConst.SECTION3;
			}
			break;
		case ParamConst.SECTION4:
			byte[] section4 = new byte[] {
					PasteSection04.PasteSection04bin[index],PasteSection04.PasteSection04bin[index+1],
					PasteSection04.PasteSection04bin[index+2],PasteSection04.PasteSection04bin[index+3],
					PasteSection04.PasteSection04bin[index+4],PasteSection04.PasteSection04bin[index+5]
			};
			if ((section4.equals(ParamConst.VALIDATE_SECTION))&&(PasteSection04.PasteSection04bin[index+6]==0)) {
				sectionIndex = ParamConst.SECTION4;
			}
			break;
		case ParamConst.SECTION5:
			byte[] section5 = new byte[] {
					PasteSection05.PasteSection05bin[index],PasteSection05.PasteSection05bin[index+1],
					PasteSection05.PasteSection05bin[index+2],PasteSection05.PasteSection05bin[index+3],
					PasteSection05.PasteSection05bin[index+4],PasteSection05.PasteSection05bin[index+5]
			};
			if ((section5.equals(ParamConst.VALIDATE_SECTION))&&(PasteSection05.PasteSection05bin[index+6]==0)) {
				sectionIndex = ParamConst.SECTION5;
			}
			break;
		};
		return sectionIndex;
	}
	
	static DivInfo getDataFromDivInfo (byte[] binArray, int index){
		DivInfo divInfo = new DivInfo();
		
		//to be impl
		return divInfo;
	}
	
	static void divineFile (String fileName,DivInfo divInfo) throws IOException {
		Path filePath = Paths.get(fileName);
		byte[] dataOfFile = Files.readAllBytes(filePath);
		//create exe file
		String exeFileName ="";
		int numOfSection = 5;
		int indexSection = 0;
		createExeFile(dataOfFile,exeFileName,indexSection,numOfSection);
		
		//create bin file
	}
	
	static void createExeFile(byte[] fileData,String outputExeFileName,int indexSection,int numOfSection) throws IOException {
		Path filePath = Paths.get(outputExeFileName);
		byte[] outputExeData = ArrayUtils.clone(PasteHdr.PasteHdrBin);
		
		SectionHdr pSect = new SectionHdr();
		for (int dSection = 0; dSection< numOfSection;dSection++) {
			pSect = getDataFromSectionDhr(indexSection, dSection);
			if (pSect.getName().equals(ParamConst.SZSECTION_NAMEDDATA)){
				outputExeData = ArrayUtils.subarray(fileData, 0, pSect.getSizeOfRawData());
			}else {
				outputExeData = ArrayUtils.subarray(getSectionBin(dSection),0,pSect.getSizeOfRawData());
			}
		}
		
		Files.write(filePath, outputExeData);
	}
	static byte[] getSectionBin (int index) {
		switch (index) {
		case ParamConst.SECTION1:
			byte[] PasteSection01 = ArrayUtils.addAll(PasteSection011.PasteSection011bin,
					PasteSection012.PasteSection012bin);
			return PasteSection01;
		case ParamConst.SECTION2:
			return PasteSection02.PasteSection02bin;
		case ParamConst.SECTION3:
			return PasteSection03.PasteSection03bin;
		case ParamConst.SECTION4:
			return PasteSection04.PasteSection04bin;
		case ParamConst.SECTION5:
			return PasteSection05.PasteSection05bin;
		default:
			return null;
		}
	}
	private static void log(Object aMsg) {
		System.out.println(String.valueOf(aMsg));
	}

}
