package Coprocessor;

import java.io.BufferedWriter;
import java.io.IOException;

import Main.Instruction;


public abstract class BranchInstruction extends Instruction {

	protected String _formatCode;
	protected String _cc;
	protected String _flag;
	protected String _offset;
	
	/**
	 * Construct a branch coprocessor instruction (BC-format)
	 * @param binaryString
	 */
	public BranchInstruction(String binaryString) {
		super(binaryString);
		_format = "BC";
		_formatCode = binaryString.substring(6, 11);
		_cc = binaryString.substring(11, 14);
		_flag = binaryString.substring(14,16);
		_offset = binaryString.substring(16, 32);
	}
	
	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int formatCode = Integer.valueOf(_formatCode, 2);
		int cc = Integer.valueOf(_cc, 2);
		int flag = Integer.valueOf(_flag, 2);
		int offset = Integer.valueOf(_offset, 2);
		output.write(opCode + " " + formatCode + " " + cc + " " + flag + " " + offset);

	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String formatCode = "0x" + Integer.toHexString(Integer.valueOf(_formatCode, 2));
		String cc = "0x" + Integer.toHexString(Integer.valueOf(_cc, 2));
		String flag = "0x" + Integer.toHexString(Integer.valueOf(_flag, 2));
		String offset = "0x" + Integer.toHexString(Integer.valueOf(_offset, 2));
		output.write(opCode + " " + formatCode + " " + cc + " " + flag + " " + offset);
	}

}
