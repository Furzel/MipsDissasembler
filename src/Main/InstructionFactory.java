package Main;

import Immediate.Ins_rsrtlbl;
import Register.Ins_rd;
import Register.Ins_rdrtimm;
import Register.Ins_rs;
import Register.Ins_rsrt;




public class InstructionFactory {

	private final static int OP_FUNC0 = 0;
	private final static int OP_FUNC1 = 1;
	private final static int OP_FUNC28 = 28;

	private static int _opCode;
	private static int _funcCode;

	public static final Instruction createInstruction(String binaryString) {
		Instruction ins = null; 
		String temp = binaryString.substring(0, 6);
		_opCode = Integer.valueOf(temp, 2);
		_funcCode = Integer.valueOf(binaryString.substring(26, 32), 2);
		/*
		 * Should we look at the function field ?
		 */
		if (_opCode == OP_FUNC0) {
			if (containsFuncCode(Ins_rd.FUNCTION_CODE)) {
				ins = new Ins_rd(binaryString);
			}else if(containsFuncCode(Ins_rdrtimm.FUNCTION_CODE)){
				ins = new Ins_rdrtimm(binaryString);
			}else if(containsFuncCode(Ins_rs.FUNCTION_CODE)){
				ins = new Ins_rs(binaryString);
			}else if(containsFuncCode(Ins_rsrt.FUNCTION_CODE)){
				ins = new Ins_rsrt(binaryString);
			}
		}
		else if (_opCode == OP_FUNC1) {

		}
		else if (_opCode == OP_FUNC28) {
			if (containsFuncCode(Ins_rsrt.FUNCTION_CODE)) {
				ins = new Ins_rsrt(binaryString);
			}			
		}
		/*
		 * op code is enough to tell which function we want
		 */
		else if (containsOpCode(Ins_rsrtlbl.OP_CODE)) {
			ins = new Ins_rsrtlbl(binaryString);
		}
		else {
			// Unrecognized opcode
			assert(false);
		}
		return ins;
	}

	private static boolean containsOpCode(int[] opCodeClass) {
		assert(_opCode != 1 && _opCode != 0 && _opCode != 28);
		for (int i = 0; i < opCodeClass.length; i++) {
			if (_opCode == opCodeClass[i]) {
				return true;
			}
		}
		return false;
	}

	private static boolean containsFuncCode(int[] funcCodeClass) {
		assert(_opCode == 1 || _opCode == 0 || _opCode == 28);
		for (int i = 0; i < funcCodeClass.length; i++) {
			if (_funcCode == funcCodeClass[i]) {
				return true;
			}
		}
		return false;
	}
}
