package Register;

public class Ins_rd extends RegisterInstruction{

	public static final int[] FUNCTION_CODE = { 16, 18 };
	public static final String[] FUNCTION_NAME = { "mfhi", "mflo" };
	
	public Ins_rd(String binaryString) {
		super(binaryString);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printMnemonic() {
		// TODO Auto-generated method stub
		
	}

}
