package Immediate;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rtrsimm extends ImmediateInstruction {

	public static final int[] OP_CODE = { 8, 10, 11, 12, 13, 14 };
	public static final String[] FUNCTION_NAME = { "addi", "slti", "sltiu", "andi", "ori", "xori" };
	
	public Ins_rtrsimm(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
		_imm = Integer.valueOf(getImm(), 2).toString();
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		output.write(_functionName + " " + _rt + " " + _rs + " " + _imm);
	}

}
