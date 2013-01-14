package Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;

public abstract class Instruction {
	
	
	protected static final String[] REGISTER_NAME= {	"$zero",
														"$at",
														"$v0",
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
	
	/**
	 * Construct an instruction from a binary string
	 * @param binaryString
	 */
	public Instruction(String binaryString) {
		_instructionString = binaryString;
		_opCode = getOpCode();
		_originalNumber = BigInteger.valueOf(Long.parseLong(_instructionString, 2));
	}
	
	/**
	 * Display the decimal decomposition of the instruction
	 * @param output the buffer of output file
	 * @throws IOException
	 */
	public abstract void printDecomposedDecimal(BufferedWriter output) throws IOException;
	
	/**
	 * Display the hexadecimal decomposition of the instruction
	 * @param output the buffer of output file
	 * @throws IOException
	 */
	public abstract void printDecomposedHexa(BufferedWriter output) throws IOException;
	
	/**
	 * Display the mnemonic decomposition of the instruction
	 * @param output the buffer of output file
	 * @throws IOException
	 */
	public abstract void printMnemonic(BufferedWriter output) throws IOException;
	
	/**
	 * Display the value of the instruction in the input file
	 * @param output the buffer of output file
	 * @throws IOException
	 */
	public void printValue(BufferedWriter output) throws IOException {
		output.write(_originalNumber.toString());
	}
	
	/**
	 * Display the format of the instruction
	 * @param output the buffer of output file
	 * @throws IOException
	 */
	public void printFormat(BufferedWriter output) throws IOException {
		output.write(_format);
	}
	
	/**
	 * Get the mnemonic representation of a register from a binary string
	 * @param binaryString
	 * @return
	 */
	protected String binaryToReg(String binaryString) {
		int regNumber = Integer.valueOf(binaryString, 2);
		assert(regNumber >= 0 && regNumber <= 31);
		return REGISTER_NAME[regNumber];
	}
	
	/**
	 * Get the integer representation of a binary string
	 * @param binaryString
	 * @return
	 */
	protected String binaryToInt(String binaryString) {
		return Integer.valueOf(binaryString, 2).toString();
	}
	
	/**
	 * Get function name from an array
	 * @param nameArray array of function name
	 * @param codeArray array of function code 
	 * @param code code of the instruction
	 * @return
	 */
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
	
	/**
	 * Retrieve the opcode of an instruction
	 * @return
	 */
	protected String getOpCode() {
		return _instructionString.substring(0, 6);
	}
	
	/**
	 * Retrieve the function code of an instruction
	 * @return
	 */
	protected String getFuncCode() {
		return _instructionString.substring(26, 32);
	}
	
	/**
	 * Retrieve the rs value of an instruction
	 * @return
	 */
	protected String getRs() {
		return _instructionString.substring(6, 11);
	}
	
	/**
	 * Retrieve the rt value of an instruction
	 * @return
	 */
	protected String getRt() {
		return _instructionString.substring(11, 16);
	}
	
	/**
	 * Retrieve the rd value of an instruction
	 * @return
	 */
	protected String getRd() {
		return _instructionString.substring(16, 21);
	}
}
