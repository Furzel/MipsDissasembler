package Immediate;

public class Ins_rsimm extends ImmediateInstruction {

	public static final int[] RT_CODE = { 8, 9, 10, 11, 12, 14 };
	public static final String[] FUNCTION_NAME = { "tgei", "tgeiu", "tlti", "tltiu", "teqi", "tnei" };
	
	public Ins_rsimm(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_imm = Integer.valueOf(getImm(), 2).toString();
	}

	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, RT_CODE, Integer.valueOf(getRt(), 2));
		System.out.println(_functionName + " " + _rs + " " + _imm);
	}


}
