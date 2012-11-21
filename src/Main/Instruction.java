package Main;

import java.math.BigInteger;

public abstract class Instruction {
	
	protected BigInteger _originalNumber;
	protected String _binaryString;
	protected static String _format;
	
	
	public Instruction(String binaryString) {
		_binaryString = binaryString;
	}
	
	public abstract void printDecomposedDecimal();
	public abstract void printDecomposedHexa();
	public abstract void printMnemonic();
	
	// @todo
	protected String binaryToReg(String binaryString) {
		return null;
	}
	
	// @todo
	protected String binaryToInt(String binaryString) {
		return null;
	}
	

}
