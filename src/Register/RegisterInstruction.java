package Register;

import java.io.BufferedWriter;
import java.io.IOException;

import Main.Instruction;


public abstract class RegisterInstruction extends Instruction {

	protected String _rs;
	protected String _rd;
	protected String _rt;
	protected String _functionCode;
	
	/**
	 * Construct a register instruction (R format)
	 * @param binaryString
	 */
	public RegisterInstruction(String binaryString) {
		super(binaryString);
		_format = "R";
		_functionCode = binaryString.substring(26, 32);
	}

	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int rs = Integer.valueOf(getRs(), 2);
		int rt = Integer.valueOf(getRt(), 2);
		int rd = Integer.valueOf(getRd(), 2);
		int part5 = Integer.valueOf(_instructionString.substring(21, 26), 2);
		int funcCode = Integer.valueOf(getFuncCode(), 2);
		output.write(opCode + " " + rs + " " + rt + " " + rd + " " + part5 + " " + funcCode);
	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String rs = "0x" + Integer.toHexString(Integer.valueOf(getRs(), 2));
		String rt = "0x" + Integer.toHexString(Integer.valueOf(getRt(), 2));
		String rd = "0x" + Integer.toHexString(Integer.valueOf(getRd(), 2));
		String part5 = "0x" + Integer.toHexString(Integer.valueOf(_instructionString.substring(21, 26), 2));
		String funcCode = "0x" + Integer.toHexString(Integer.valueOf(getFuncCode(), 2));
		output.write(opCode + " " + rs + " " + rt + " " + rd + " " + part5 + " " + funcCode);
	}

	
}
