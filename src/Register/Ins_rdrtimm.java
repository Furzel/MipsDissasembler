package Register;

public class Ins_rdrtimm extends RegisterInstruction {

	public static final int[] FUNCTION_CODE = { 0, 2, 3};
	public static final String[] FUNCTION_NAME = { "sll", "srl", "sra" };
	
	private String _shamt;
	
	public Ins_rdrtimm(String binaryString) {
		super(binaryString);
		_rd = binaryToReg(getRd());
		_rt = binaryToReg(getRt());
		_shamt = getShamt();
	}

	@Override
	public void printMnemonic() {
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_CODE, Integer.valueOf(_functionCode, 2));
		System.out.println(_functionName + " " + _rd + " " + _rd + " " + Integer.valueOf(_shamt, 2));
	}
	
	public String getShamt(){
		String t = _instructionString.substring(21, 26);
		return t;
		
	}

}
