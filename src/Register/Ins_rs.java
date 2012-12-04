package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rs extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 8, 17, 19};
	public static final String[] FUNCTION_NAME = { "jr", "mthi", "mtlo"};
	
	public Ins_rs(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException { 
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		output.write(_functionName + " " + _rs);
	}

}
