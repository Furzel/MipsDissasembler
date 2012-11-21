package Register;

import Main.Instruction;


public abstract class RegisterInstruction extends Instruction {

	protected String _rs;
	protected String _rd;
	protected String _rt;
	
	public RegisterInstruction(String binaryString) {
		super(binaryString);
		_format = "R";
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
