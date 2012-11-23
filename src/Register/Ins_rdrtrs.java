package Register;

public class Ins_rdrtrs extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 4, 6, 7 };
	public static final String[] FUNCTION_NAME = { "sllv", "srlv", "srav" };
	
	public Ins_rdrtrs(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rs = binaryToReg(getRs());
		_rt = binaryToReg(getRt());
	}

	@Override
	public void printMnemonic() {
		_functionName =  getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName + " " + _rd + " " + _rt + " " + _rs);
	}

}
