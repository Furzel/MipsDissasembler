package Register;

public class Ins_rsrd extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 9 };
	public static final String[] FUNCTION_NAME = { "jalr" };
	
	public Ins_rsrd(String binaryString) {
		super(binaryString);
		_rs = binaryToReg(getRs());
		_rd = binaryToReg(getRd());
	}

	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName + " " + _rs + " " + _rd);
	}

}
