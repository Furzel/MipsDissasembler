package Coprocessor;

public class Ins_rtfs extends CoprocessorInstruction {

	public static final int[] FUNCTION_FORMATCODE = { 0, 4 };
	public static final String[] FUNCTION_NAME = { "mfc1", "mtc1"};
	
	public Ins_rtfs(String binaryString){
		super(binaryString);
		_rt = binaryToReg(getRt());
		_rdfs = binaryToFReg(getRd());
	}
	
	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_FORMATCODE, Integer.valueOf(_formatCode, 2));
		System.out.println(_functionName + " " + _rt + " " + _rdfs);
	}

}
