package Coprocessor;

import java.io.BufferedWriter;
import java.io.IOException;

import Main.Instruction;

public abstract class CoprocessorInstruction extends Instruction {

	public static String[] FREGISTER_NAME = {	"$f0",
											"$f1",
											"$f2",
											"$f3",
											"$f4",
											"$f5",
											"$f6",
											"$f7",
											"$f8",
											"$f9",
											"$f10",
											"$f11",
											"$f12",
											"$f13",
											"$f14",
											"$f15",
											"$f16",
											"$f17",
											"$f18",
											"$f19",
											"$f20",
											"$f21",
											"$f22",
											"$f23",
											"$f24",
											"$f25",
											"$f26",
											"$f27",
											"$f28",
											"$f29",
											"$f30",
											"$f31"
	};
	
	protected String _formatCode;
	protected String _rt;
	protected String _rdfs;
	protected String _end;

	/**
	 * Construct a coprocessor instruction (C-format)
	 * @param binaryString
	 */
	public CoprocessorInstruction(String binaryString){
		super(binaryString);
		_format = "C";
		_formatCode = binaryString.substring(6, 11);
	}

	@Override
	public void printDecomposedDecimal(BufferedWriter output) throws IOException {
		int opCode = Integer.valueOf(getOpCode(), 2);
		int functionCode = Integer.valueOf(_formatCode, 2);
		int rt = Integer.valueOf(getRt(), 2);
		int rdfs = Integer.valueOf(getRd(), 2);
		int end = Integer.valueOf(_instructionString.substring(21, 32), 2);
		output.write(opCode + " " + functionCode + " " + rt + " " + rdfs + " " + end);

	}

	@Override
	public void printDecomposedHexa(BufferedWriter output) throws IOException {
		String opCode = "0x" + Integer.toHexString(Integer.valueOf(getOpCode(), 2));
		String functionCode = "0x" + Integer.toHexString(Integer.valueOf(_formatCode, 2));
		String rt = "0x" + Integer.toHexString(Integer.valueOf(getRt(), 2));
		String rdfs = "0x" + Integer.toHexString(Integer.valueOf(getRd(), 2));
		String end = "0x" + Integer.toHexString(Integer.valueOf(_instructionString.substring(21, 32), 2));
		output.write(opCode + " " + functionCode + " " + rt + " " + rdfs + " " + end);
	}
	
	protected String binaryToFReg(String binaryString) {
		int regNumber = Integer.valueOf(binaryString, 2);
		assert(regNumber >= 0 && regNumber <= 31);
		return FREGISTER_NAME[regNumber];
	}

}
