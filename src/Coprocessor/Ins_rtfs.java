package Coprocessor;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rtfs extends CoprocessorInstruction {

	public static final int[] FUNCTION_FORMATCODE = { 0, 4 };
	public static final String[] FUNCTION_NAME = { "mfc1", "mtc1"};
	
	public Ins_rtfs(String binaryString){
		super(binaryString);
		_rt = binaryToReg(getRt());
		_rdfs = binaryToFReg(getRd());
	}
	
	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_FORMATCODE, Integer.valueOf(_formatCode, 2));
		output.write(_functionName + " " + _rt + ", " + _rdfs);
	}

}
