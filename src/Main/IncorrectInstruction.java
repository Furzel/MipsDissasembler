package Main;

public class IncorrectInstruction extends Instruction {

	private String _message;
	
	public IncorrectInstruction(String binaryString, String message) {
		super(binaryString);
		_message = message;
	}

	@Override
	public void printDecomposedDecimal() {
		System.out.println("Incorrect instruction : " + _message);
	}

	@Override
	public void printDecomposedHexa() {
		System.out.println("Incorrect instruction : " + _message);
	}

	@Override
	public void printMnemonic() {
		System.out.println("Incorrect instruction : " + _message);
	}

	

}
