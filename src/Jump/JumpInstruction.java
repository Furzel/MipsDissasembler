package Jump;
import java.math.BigInteger;

import Main.Instruction;


public abstract class JumpInstruction extends Instruction {

	protected String _target;
	
	public JumpInstruction(String binaryString) {
		super(binaryString);
		_format = "J";
	}

	@Override
	public void printDecomposedDecimal() {
		int opCode = Integer.valueOf(_instructionString.substring(0, 7), 2);
		BigInteger target = BigInteger.valueOf(Long.valueOf(_instructionString.substring(7, 32), 2));
		System.out.println(opCode + " " + target);
	}

	@Override
	public void printDecomposedHexa() {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(_instructionString.substring(0, 7), 2));
		String target = "0x" + BigInteger.valueOf(Long.valueOf(_instructionString.substring(7, 32), 2)).toString(16);
		System.out.println(opCode + " " + target);
	}

	
}
