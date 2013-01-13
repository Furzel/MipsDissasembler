package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rdrs extends RegisterInstruction {

	public static final int[] FUNCTION_CODE_OPCODE0 = {9};
	public static final String[] FUNCTION_NAME_OPCODE0 = {"jalr"};
	public static final int[] FUNCTION_CODE_OPCODE28 = {  32, 33 };
	public static final String[] FUNCTION_NAME_OPCODE28 = {"clz", "clo"};
	
	public Ins_rdrs(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rs = binaryToReg(getRs());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		if(Integer.parseInt(_opCode, 2) == 0){
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE0, FUNCTION_CODE_OPCODE0, Integer.valueOf(_functionCode, 2));
		}else{
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE28, FUNCTION_CODE_OPCODE28, Integer.valueOf(_functionCode, 2));
		}
		output.write(_functionName + " " + _rd + ", " + _rs);
	}

}
