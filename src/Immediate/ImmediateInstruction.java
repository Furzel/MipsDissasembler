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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printDecomposedHexa() {
		// TODO Auto-generated method stub
		
	}

}
