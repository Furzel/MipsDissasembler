package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rdrsrt extends RegisterInstruction {
	
	public static final int[] FUNCTION_CODE_OPCODE0 = { 10, 11, 32, 33, 34, 35, 36, 37, 38, 39, 42, 43 };
	public static final String[] FUNCTION_NAME_OPCODE0 = { "movz", "movn", "add", "addu", "sub", "subu", "and", "or", "xor", "nor", "slt", "sltu" };
	public static final int[] FUNCTION_CODE_OPCODE28 = { 2 };
	public static final String[] FUNCTION_NAME_OPCODE28 = { "mul" };
	
	public Ins_rdrsrt(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
		
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		if(Integer.valueOf(_opCode, 2) == 0){
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE0, FUNCTION_CODE_OPCODE0, Integer.valueOf(_functionCode, 2));
		}else{
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE28, FUNCTION_CODE_OPCODE28, Integer.valueOf(_functionCode, 2));
		}
		output.write(_functionName + " " + _rd + ", " + _rs + ", " + _rt);
	}

}
