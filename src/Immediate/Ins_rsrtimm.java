package Immediate;

public class Ins_rsrtimm extends ImmediateInstruction {

	public static final int[] OP_CODE = { 9 };
	public static final String[] FUNCTION_NAME = { "addiu" };
	
	public Ins_rsrtimm(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
		_imm = Integer.valueOf(getImm(), 2).toString();
	}

	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		System.out.println(_functionName + " " + _rs + " " + _rt + " " + _imm);
	}

}
