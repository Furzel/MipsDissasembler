package Coprocessor;

import Main.Instruction;

public abstract class EretInstruction extends Instruction {

	protected String _functionCode;
	protected String _flag;
	protected String _instruction;
	
	public EretInstruction(String binaryString) {
		super(binaryString);
		_format = "E";
		_functionCode = getFuncCode();
		_flag = binaryString.substring(6, 7);
		_instruction = binaryString.substring(7, 26);
	}

	@Override
	public void printDecomposedDecimal() {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int functionCode = Integer.valueOf(_functionCode, 2);
		int flag = Integer.valueOf(_flag, 2);
		int instruction = Integer.valueOf(_instruction, 2);
		System.out.println(opCode + " " + flag + " " + instruction + " " + functionCode);
	}

	@Override
	public void printDecomposedHexa() {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String functionCode = "0x" +  Integer.toHexString(Integer.valueOf(_functionCode, 2));
		String flag = "0x" + Integer.toHexString(Integer.valueOf(_flag, 2));
		String instruction = "0x" +  Integer.toHexString(Integer.valueOf(_instruction, 2));
		System.out.println(opCode + " " + flag + " " + instruction + " " + functionCode);
	}

}
