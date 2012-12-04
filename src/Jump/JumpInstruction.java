package Jump;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;

import Main.Instruction;


public abstract class JumpInstruction extends Instruction {

	protected String _target;
	
	/**
	 * Construct a Jump instruction (J-format)
	 * @param binaryString
	 */
	public JumpInstruction(String binaryString) {
		super(binaryString);
		_format = "J";
	}

	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		int opCode = Integer.valueOf(_instructionString.substring(0, 7), 2);
		BigInteger target = BigInteger.valueOf(Long.valueOf(_instructionString.substring(7, 32), 2));
		output.write(opCode + " " + target);
	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(_instructionString.substring(0, 7), 2));
		String target = "0x" + BigInteger.valueOf(Long.valueOf(_instructionString.substring(7, 32), 2)).toString(16);
		output.write(opCode + " " + target);
	}

	protected String getTarget() {
		return _instructionString.substring(6, 32);
	}
}
