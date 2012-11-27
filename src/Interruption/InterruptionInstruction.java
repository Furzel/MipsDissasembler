package Interruption;

import Main.Instruction;

public abstract class InterruptionInstruction extends Instruction {

	protected String _functionCode;
	protected String _code;
	
	public InterruptionInstruction(String binaryString) {
		super(binaryString);
		_format = "IRQ";
		_functionCode = getFuncCode();
		_code = binaryString.substring(6, 26);
	}

	@Override
	public void printDecomposedDecimal() {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int functionCode = Integer.valueOf(_functionCode, 2);
		int code = Integer.valueOf(_code, 2);
		System.out.println(opCode + " " + code + " " + functionCode);
	}

	@Override
	public void printDecomposedHexa() {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String functionCode = "0x" + Integer.toHexString(Integer.valueOf(_functionCode, 2));
		String code = "0x" + Integer.toHexString(Integer.valueOf(_code, 2));
		System.out.println(opCode + " " + code + " " + functionCode);

	}

}
