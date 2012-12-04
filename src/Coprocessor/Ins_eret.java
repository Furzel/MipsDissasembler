package Coprocessor;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_eret extends EretInstruction {

	public static int[] FUNCTION_CODE = {24};
	public static String[] FUNCTION_NAME = {"eret"};
	
	public Ins_eret(String binaryString) {
		super(binaryString);
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		output.write(_functionName);
	}

}
