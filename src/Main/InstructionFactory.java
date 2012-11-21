package Main;

import Immediate.Ins_rsrtlbl;
import Register.Ins_rd;




public class InstructionFactory {
	
	private final static int OP_FUNC0 = 0;
	private final static int OP_FUNC1 = 1;
	private final static int OP_FUNC28 = 28;

	private static int _opCode;
	private static int _funcCode;
	
	public static final Instruction createInstruction(String binaryString) {
		Instruction ins = null; 
		_opCode = Integer.valueOf(binaryString.substring(0, 7), 2);
		_funcCode = Integer.valueOf(binaryString.substring(25, 32));
		/*
		 * Should we look at the function field ?
		 */
		if (_opCode == OP_FUNC0) {
			if (containsFuncCode(Ins_rd.FUNCTION_CODE)) {
				ins = new Ins_rd(binaryString);
			}
		}
		else if (_opCode == OP_FUNC1) {
			
		}
		else if (_opCode == OP_FUNC28) {
			
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
