package Immediate;
import Main.Instruction;


public abstract class ImmediateInstruction extends Instruction {

	protected String _rs;
	protected String _rt;
	protected String _imm;
	
	
	public ImmediateInstruction(String binaryString) {
		super(binaryString);
		_format = "I";
	}

	@Override
	public void printDecomposedDecimal() {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int rs = Integer.valueOf(getRs(), 2);
		int rt = Integer.valueOf(getRt(), 2);
		int imm = Integer.valueOf(getImm(), 2);
		System.out.println(opCode + " " + rs + " " + rt + " " + imm);
	}

	@Override
	public void printDecomposedHexa() {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String rs = "0x" + Integer.toHexString(Integer.valueOf(getRs(), 2));
		String rt = "0x" + Integer.toHexString(Integer.valueOf(getRt(), 2));
		String imm = "0x" + Integer.toHexString(Integer.valueOf(getImm(), 2));
		System.out.println(opCode + " " + rs + " " + rt + " " + imm);
	}
	
	protected String getImm() {
		return _instructionString.substring(16, 32);
	}

}
