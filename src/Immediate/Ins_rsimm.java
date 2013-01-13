package Immediate;

import java.io.BufferedWriter;
import java.io.IOException;

import tools.Tools;

public class Ins_rsimm extends ImmediateInstruction {

	public static final int[] RT_CODE = { 8, 9, 10, 11, 12, 14 };
	public static final String[] FUNCTION_NAME = { "tgei", "tgeiu", "tlti", "tltiu", "teqi", "tnei" };
	
	public Ins_rsimm(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_imm = Integer.toString(Tools.getIntegerSignedValue(getImm(), 16));
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, RT_CODE, Integer.valueOf(getRt(), 2));
		output.write(_functionName + " " + _rs + ", " + _imm);
	}


}
