package Immediate;

public class Ins_rsrtlbl extends ImmediateInstruction {

	public static final int[] OP_CODE = { 4, 5 };
	public static final String[] FUNCTION_NAME = { "beq", "bne" };
	
	public Ins_rsrtlbl(String binaryString) {
		super(binaryString);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printMnemonic() {
		// TODO Auto-generated method stub

	}

}
