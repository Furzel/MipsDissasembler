package Immediate;

public class Ins_rsrtlbl extends ImmediateInstruction {

	public static final int[] OP_CODE = { 4, 5 };
	public static final String[] FUNCTION_NAME = { "beq", "bne" };
	
	public Ins_rsrtlbl(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
		_imm = "0x" + Integer.toHexString(Integer.valueOf(getImm(), 2));
	}

	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		System.out.println(_functionName + " " + _rs + " " + _rt + " " + _imm);
	}

}
