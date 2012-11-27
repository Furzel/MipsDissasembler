package Interruption;

public class Ins_irq extends InterruptionInstruction {

	public static int[] FUNCTION_CODE = {12, 13};
	public static String[] FUNCTION_NAME = {"syscall", "break"};
	
	public Ins_irq(String binaryString) {
		super(binaryString);
	}

	@Override
	public void printMnemonic() {
		String code = "";
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode,2));
		if(Integer.valueOf(_functionCode, 2).equals(13)){
			code = " " + "0x" + Integer.toHexString(Integer.valueOf(_code, 2));
		}
		System.out.println(_functionName + code);
	}

}
