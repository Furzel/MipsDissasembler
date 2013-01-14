package Register;

import java.io.BufferedWriter;
import java.io.IOException;

@Deprecated
public class Ins_rsrd extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 9 };
	public static final String[] FUNCTION_NAME = { "jalr" };
	
	public Ins_rsrd(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_rd = binaryToReg(getRd());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		output.write
		(_functionName + " " + _rs + ", " + _rd);
	}

}
