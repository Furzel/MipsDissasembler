package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rdrs extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 32, 33 };
	public static final String[] FUNCTION_NAME = { "clz", "clo" };
	
	public Ins_rdrs(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rs = binaryToReg(getRs());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName =  getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		output.write(_functionName + " " + _rd + " " + _rs);
	}

}
