package Register;

public class Ins_rdrs extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 32, 33 };
	public static final String[] FUNCTION_NAME = { "clz", "clo" };
	
	public Ins_rdrs(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rs = binaryToReg(getRs());
	}

	@Override
	public void printMnemonic() {
		_functionName =  getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName + " " + _rd + " " + _rs);
	}

}
