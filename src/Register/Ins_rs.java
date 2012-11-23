package Register;

public class Ins_rs extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 8, 17, 19};
	public static final String[] FUNCTION_NAME = { "jr", "mthi", "mtlo"};
	
	public Ins_rs(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
	}

	@Override
	public void printMnemonic() { 
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName + " " + _rs);
	}

}
