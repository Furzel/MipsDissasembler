package Immediate;

import java.io.BufferedWriter;
import java.io.IOException;

import tools.Tools;

public class Ins_rsrtlbl extends ImmediateInstruction {

	public static final int[] OP_CODE = { 4, 5 };
	public static final String[] FUNCTION_NAME = { "beq", "bne" };
	
	public Ins_rsrtlbl(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
		_imm = Integer.toString(Tools.getIntegerSignedValue(getImm(), 16));//"0x" + Integer.toHexString(Integer.valueOf(getImm(), 2));
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		output.write(_functionName + " " + _rs + ", " + _rt + ", " + _imm);
	}

}
