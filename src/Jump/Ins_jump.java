package Jump;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Ins_jump extends JumpInstruction{
	
	public static final int[] OP_CODE = { 2, 3 };
	public static final String[] FUNCTION_NAME = { "j", "jal" };
	
	public Ins_jump(String binaryString) {
		super(binaryString);
		_target = BigInteger.valueOf(Long.valueOf(getTarget(), 2)).toString(16);
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		output.write(_functionName + " 0x" + _target);
	}

	

}
