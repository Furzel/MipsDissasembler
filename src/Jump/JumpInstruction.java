package Jump;
import Main.Instruction;


public abstract class JumpInstruction extends Instruction {

	protected String _target;
	
	public JumpInstruction(String binaryString) {
		super(binaryString);
		_format = "J";
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
