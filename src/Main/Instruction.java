package Main;

import java.math.BigInteger;

public abstract class Instruction {
	
	
	protected static final String[] REGISTER_NAME= {	"$zero",
														"$at",
														"$vo",
														"$v1",
														"$a0",
														"$a1",
														"$a2",
														"$a3",
														"$t0",
														"$t1",
														"$t2",
														"$t3",
														"$t4",
														"$t5",
														"$t6",
														"$t7",
														"$s0",
														"$s1",
														"$s2",
														"$s3",
														"$s4",
														"$s5",
														"$s6",
														"$s7",
														"$t8",
														"$t9",
														"$k0",
														"$k1",
														"$gp",
														"$sp",
														"$fp",
														"$ra" };
	protected BigInteger _originalNumber;
	protected String _instructionString;
	protected static String _format;
	protected String _functionName;
	protected String _opCode;
	
	public Instruction(String binaryString) {
		_instructionString = binaryString;
		_opCode = getOpCode();
	}
	
	public abstract void printDecomposedDecimal();
	public abstract void printDecomposedHexa();
	public abstract void printMnemonic();
	
	public void printFormat() {
		System.out.println("Format : " + _format);
	}
	
	protected String binaryToReg(String binaryString) {
		int regNumber = Integer.valueOf(binaryString, 2);
		assert(regNumber >= 0 && regNumber <= 31);
		return REGISTER_NAME[regNumber];
	}
	
	protected String binaryToInt(String binaryString) {
		return Integer.valueOf(binaryString, 2).toString();
	}
	
	protected String getNameFromCode(String[] nameArray, int[] codeArray, int code) {
		assert(nameArray.length == codeArray.length);
		int namePosition = -1;
		for (int i = 0; i < codeArray.length; i++) {
			if (codeArray[i] == code) {
				namePosition = i;
			}
		}
		assert(namePosition != -1);
		return nameArray[namePosition];
	}
	
	protected String getOpCode() {
		return _instructionString.substring(0, 6);
	}
	
	protected String getFuncCode() {
		return _instructionString.substring(26, 32);
	}
	
	protected String getRs() {
		return _instructionString.substring(6, 11);
	}
	
	protected String getRt() {
		return _instructionString.substring(11, 16);
	}
	
	protected String getRd() {
		return _instructionString.substring(16, 21);
	}
}
