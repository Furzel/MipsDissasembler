package Register;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rdrtimm extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 0, 2, 3};
	public static final String[] FUNCTION_NAME = { "sll", "srl", "sra" };
	
	private String _shamt;
	
	public Ins_rdrtimm(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rt = binaryToReg(getRt());
		_shamt = getShamt();
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		output.write(_functionName + " " + _rd + " " + _rt + " " + Integer.valueOf(_shamt, 2));
	}
	
	public String getShamt(){
		return _instructionString.substring(21, 26);
	}

}
