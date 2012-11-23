package Register;

public class Ins_rd extends RegisterInstruction{

	public static final int[] FUNCTION_CODE = { 16, 18 };
	public static final String[] FUNCTION_NAME = { "mfhi", "mflo" };
	
	public Ins_rd(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
	}

	@Override
	public void printMnemonic() { 
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName + " " + _rd);
	}

}
