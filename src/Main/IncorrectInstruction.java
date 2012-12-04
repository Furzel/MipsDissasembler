package Main;

import java.io.BufferedWriter;
import java.io.IOException;

public class IncorrectInstruction extends Instruction {

	private String _message;
	
	public IncorrectInstruction(String binaryString, String message) {
		super(binaryString);
		_message = message;
	}

	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		output.write("Incorrect instruction : " + _message);
	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		output.write("Incorrect instruction : " + _message);
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		output.write("Incorrect instruction : " + _message);
	}

	

}
