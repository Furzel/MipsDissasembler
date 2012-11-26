package Coprocessor;

public class Ins_mv extends CoprocessorInstruction {

	public static final int[] FUNCTION_CODE_COPROCESSOR = { 0 };
	public static final int[] FUNCTION_FORMAT_OPCODE16 = { 0, 4 };
	public static final String[] FUNCTION_NAME_OPCODE16 = { "mfc0", "mtc0"};
	public static final int[] FUNCTION_FORMAT_OPCODE17 = { 0, 4 };
	public static final String[] FUNCTION_NAME_OPCODE17 = { "mfc1", "mtc1"};
	
	public Ins_mv(String binaryString){
		super(binaryString);
		_rt = binaryToReg(getRt());
		_rdfs = (Integer.valueOf(_opCode, 2).equals(16)) ? _rdfs = binaryToReg(getRd()) : binaryToFReg(getRd());
	}
	
	@Override
	public void printMnemonic() {
		String firstRegister, secondRegister;
		if(Integer.valueOf(_opCode, 2).equals(16)){
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE16, FUNCTION_FORMAT_OPCODE16, Integer.valueOf(_formatCode, 2));
			if(Integer.valueOf(_formatCode, 2).equals(0)){
				firstRegister = _rt;
				secondRegister = _rdfs;
			}else{
				firstRegister = _rdfs;
				secondRegister = _rt;
			}
		}else{
			_functionName = getNameFromCode(FUNCTION_NAME_OPCODE17, FUNCTION_FORMAT_OPCODE17, Integer.valueOf(_formatCode, 2));
			firstRegister = _rt;
			secondRegister = _rdfs;
		}
		System.out.println(_functionName + " " + firstRegister + " " + secondRegister);
	}

}
