package Coprocessor;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_cclbl extends BranchInstruction {

	public static int[] FORMAT_CODE = {8};
	public static int[] FLAG_CODE = {0 , 1 };
	public static String[] FUNCTION_NAME = {"bc1f", "bc1t"};
	
	public Ins_cclbl(String binaryString){
		super(binaryString);
	}
	
	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, FLAG_CODE, Integer.valueOf(_flag, 2));
		output.write(_functionName + " " + Integer.valueOf(_cc, 2) + ", " + Integer.valueOf(_offset, 2));
	}

}
