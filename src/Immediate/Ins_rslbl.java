package Immediate;

public class Ins_rslbl extends ImmediateInstruction {

	public static final int[] RT_CODE = { 0, 1, 16, 17 };
	public static final String[] RT_FUNCTION_NAME = { "bltz", "bgez", "bltzal", "bgezal" };
	public static final int[] OP_CODE = { 6, 7 };
	public static final String[] OP_FUNCTION_NAME = { "blez", "bgtz" };
	
	public Ins_rslbl(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_imm = Integer.toString(Integer.valueOf(getImm(), 2), 16);
	}

	@Override
	public void printMnemonic() {
		if (Integer.valueOf(_opCode, 2) == 1) {
			_functionName = getNameFromCode(RT_FUNCTION_NAME, RT_CODE, Integer.valueOf(getRt(), 2));
		} 
		else {
			_functionName = getNameFromCode(OP_FUNCTION_NAME, OP_CODE, Integer.valueOf(_opCode, 2));
		}
		System.out.println(_functionName + " " + _rs + " 0x" + _imm);
	}

}
