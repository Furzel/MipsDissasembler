package Register;

import Main.Instruction;


public abstract class RegisterInstruction extends Instruction {

	protected String _rs;
	protected String _rd;
	protected String _rt;
	protected String _functionCode;
	
	public RegisterInstruction(String binaryString) {
		super(binaryString);
		_format = "R";
		_functionCode = binaryString.substring(25, 32);
	}

	@Override
	public void printDecomposedDecimal() {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int rs = Integer.valueOf(getRs(), 2);
		int rt = Integer.valueOf(getRt(), 2);
		int rd = Integer.valueOf(getRd(), 2);
		int part5 = Integer.valueOf(_instructionString.substring(21, 26), 2);
		int funcCode = Integer.valueOf(getFuncCode(), 2);
		System.out.println(opCode + " " + rs + " " + rt + " " + rd + " " + part5 + " " + funcCode);
	}

	@Override
	public void printDecomposedHexa() {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String rs = "0x" + Integer.toHexString(Integer.valueOf(getRs(), 2));
		String rt = "0x" + Integer.toHexString(Integer.valueOf(getRt(), 2));
		String rd = "0x" + Integer.toHexString(Integer.valueOf(getRd(), 2));
		String part5 = "0x" + Integer.toHexString(Integer.valueOf(_instructionString.substring(21, 26), 2));
		String funcCode = "0x" + Integer.toHexString(Integer.valueOf(getFuncCode(), 2));
		System.out.println(opCode + " " + rs + " " + rt + " " + rd + " " + part5 + " " + funcCode);
	}

	
}
