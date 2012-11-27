package Coprocessor;

public class Ins_eret extends EretInstruction {

	public static int[] FUNCTION_CODE = {24};
	public static String[] FUNCTION_NAME = {"eret"};
	
	public Ins_eret(String binaryString) {
		super(binaryString);
	}

	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName);
	}

}
