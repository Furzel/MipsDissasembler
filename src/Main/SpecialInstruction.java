package Main;

import java.math.BigInteger;

public class SpecialInstruction extends Instruction {

	public static final String OP_NOP = "00000000000000000000000000000";
	
	protected String _mnemonic;
	
	public SpecialInstruction(String binaryString) {
		super(binaryString);
		if (binaryString.equals(OP_NOP)) {
			_mnemonic = "nop";
		}
	}

	@Override
	public void printDecomposedDecimal() {
		System.out.println(BigInteger.valueOf(Long.valueOf(_instructionString, 2)));
	}

	@Override
	public void printDecomposedHexa() {
		System.out.println("0x" + BigInteger.valueOf(Long.valueOf(_instructionString, 2)).toString(16));
	}

	@Override
	public void printMnemonic() {
		System.out.println(_mnemonic);
	}

}
