package Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;

public class SpecialInstruction extends Instruction {

	public static final String OP_NOP = "00000000000000000000000000000000";
	
	protected String _mnemonic;
	
	public SpecialInstruction(String binaryString) {
		super(binaryString);
		if (binaryString.equals(OP_NOP)) {
			_mnemonic = "nop";
		}
	}

	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		output.write(BigInteger.valueOf(Long.valueOf(_instructionString, 2)).toString());
	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		output.write("0x" + BigInteger.valueOf(Long.valueOf(_instructionString, 2)).toString(16));
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		output.write(_mnemonic);
	}

}
