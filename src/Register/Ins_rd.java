package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rd extends RegisterInstruction{

	public static final int[] FUNCTION_CODE = { 16, 18 };
	public static final String[] FUNCTION_NAME = { "mfhi", "mflo" };
	
	public Ins_rd(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException { 
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		output.write(_functionName + " " + _rd);
	}

}
