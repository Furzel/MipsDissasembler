package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rsrt extends RegisterInstruction {
	
	public static final int[] FUNCTION_CODE_OPCODE0 = {24, 25, 26, 27, 48, 49, 50, 51, 52, 54};
	public static final String[] FUNCTION_NAME_OPCODE0 = {"mult", "multu", "div", "divu", "tge", "tgeu", "tlt", "tltu", "teq", "tne"};
	public static final int[] FUNCTION_CODE_OPCODE28 = {0, 1, 4, 5};
	public static final String[] FUNCTION_NAME_OPCODE28 = {  "madd", "maddu", "msub", "msubu"};
	
	public Ins_rsrt(String binaryString) {
		super(binaryString);
		// TODO Auto-generated constructor stub
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		if(Integer.parseInt(_opCode, 2) == 0){
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE0, FUNCTION_CODE_OPCODE0, Integer.valueOf(_functionCode, 2));
		}else{
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE28, FUNCTION_CODE_OPCODE28, Integer.valueOf(_functionCode, 2));
		}
		output.write(_functionName + " " + _rs  + " " + _rt);
	}

	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int rs = Integer.valueOf(getRs(), 2);
		int rt = Integer.valueOf(getRt(), 2);
		int part5 = Integer.valueOf(_instructionString.substring(16, 26), 2);
		int funcCode = Integer.valueOf(getFuncCode(), 2);
		output.write(opCode + " " + rs + " " + rt + " " + part5 + " " + funcCode);
	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String rs = "0x" + Integer.toHexString(Integer.valueOf(getRs(), 2));
		String rt = "0x" + Integer.toHexString(Integer.valueOf(getRt(), 2));
		String part5 = "0x" + Integer.toHexString(Integer.valueOf(_instructionString.substring(16, 26), 2));
		String funcCode = "0x" + Integer.toHexString(Integer.valueOf(getFuncCode(), 2));
		output.write(opCode + " " + rs + " " + rt + " " + part5 + " " + funcCode);
	}
}
