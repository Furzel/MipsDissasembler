package Immediate;

public class Ins_rtimm extends ImmediateInstruction {

	
	public static final int[] OP_CODE = { 15 };
	public static final String[] FUNCTION_NAME = { "lui" };
	
	public Ins_rtimm(String binaryString) {
		super(binaryString);
		_rt = binaryToReg(getRt());
		_imm = Integer.valueOf(getImm(), 2).toString();
	}
	
	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		System.out.println(_functionName + " " + _rt + " " + _imm);
	}
	

}
