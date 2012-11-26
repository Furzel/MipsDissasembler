package Coprocessor;

public class Ins_cclbl extends BranchInstruction {

	public static int[] FORMAT_CODE = {8};
	public static int[] FLAG_CODE = {0 , 1 };
	public static String[] FUNCTION_NAME = {"bc1f", "bc1t"};
	
	public Ins_cclbl(String binaryString){
		super(binaryString);
	}
	
	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, FLAG_CODE, Integer.valueOf(_flag, 2));
		System.out.println(_functionName + " " + Integer.valueOf(_cc, 2) + " " + Integer.valueOf(_offset, 2));
	}

}
