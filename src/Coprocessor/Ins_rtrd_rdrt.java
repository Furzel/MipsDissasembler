package Coprocessor;

import java.io.BufferedWriter;
import java.io.IOException;

public class Ins_rtrd_rdrt extends CoprocessorInstruction {

	public static final int[] FUNCTION_FORMATCODE = { 0, 4 };
	public static final String[] FUNCTION_NAME= { "mfc0", "mtc0"};

	public Ins_rtrd_rdrt(String binaryString){
		super(binaryString);
		_rt = binaryToReg(getRt());
		_rdfs = binaryToReg(getRd());
	}

	@Override
	public void printMnemonic(BufferedWriter output) throws IOException {
		String firstRegister, secondRegister;
		_functionName = getNameFromCode(FUNCTION_NAME, FUNCTION_FORMATCODE, Integer.valueOf(_formatCode, 2));
		if(Integer.valueOf(_formatCode, 2).equals(0)){
			firstRegister = _rt;
			secondRegister = _rdfs;
		}else{
			firstRegister = _rdfs;
			secondRegister = _rt;
		}
		output.write(_functionName + " " + firstRegister + " " + secondRegister);
	}

}
