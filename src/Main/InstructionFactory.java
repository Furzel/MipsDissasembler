package Main;

import Coprocessor.Ins_cclbl;
import Coprocessor.Ins_rtfs;
import Coprocessor.Ins_rtrd_rdrt;
import Immediate.Ins_rsimm;
import Immediate.Ins_rslbl;
import Immediate.Ins_rsrtimm;
import Immediate.Ins_rsrtlbl;
import Immediate.Ins_rtaddr;
import Immediate.Ins_rtimm;
import Immediate.Ins_rtrsimm;
import Jump.Ins_jump;
import Register.Ins_rd;
import Register.Ins_rdrs;
import Register.Ins_rdrsrt;
import Register.Ins_rdrtimm;
import Register.Ins_rdrtrs;
import Register.Ins_rs;
import Register.Ins_rsrd;
import Register.Ins_rsrt;


public class InstructionFactory {

	private final static int OP_FUNC0 = 0;
	private final static int OP_FUNC1 = 1;
	private final static int OP_FUNC16 = 16;
	private final static int OP_FUNC17 = 17;
	private final static int OP_FUNC28 = 28;

	private static int _opCode;
	private static int _funcCode;
	private static int _rtCode;

	public static final Instruction createInstruction(String binaryString) {
		Instruction ins = null; 
		_opCode = Integer.valueOf(binaryString.substring(0, 6), 2);
		_funcCode = Integer.valueOf(binaryString.substring(26, 32), 2);
		_rtCode = Integer.valueOf(binaryString.substring(11, 16), 2);
		/*
		 * Check for special functions
		 */
		if (isSpecialFunction(binaryString)) {
			ins = new SpecialInstruction(binaryString);
		}
		/*
		 * Should we look at the function field ?
		 */
		else if (_opCode == OP_FUNC0) {
			if (containsFuncCode(Ins_rd.FUNCTION_CODE)) {
				ins = new Ins_rd(binaryString);
			}
			else if(containsFuncCode(Ins_rdrtimm.FUNCTION_CODE)){
				ins = new Ins_rdrtimm(binaryString);
			}
			else if(containsFuncCode(Ins_rs.FUNCTION_CODE)){
				ins = new Ins_rs(binaryString);
			}
			else if(containsFuncCode(Ins_rsrt.FUNCTION_CODE_OPCODE0)){
				ins = new Ins_rsrt(binaryString);
			}
			else if (containsFuncCode(Ins_rsrd.FUNCTION_CODE)) {
				ins = new Ins_rsrd(binaryString);
			}
			else if (containsFuncCode(Ins_rdrtrs.FUNCTION_CODE)) {
				ins = new Ins_rdrtrs(binaryString);
			}			
			else if (containsFuncCode(Ins_rd.FUNCTION_CODE)) {
				ins = new Ins_rd(binaryString);
			}
			else if(containsFuncCode(Ins_rdrsrt.FUNCTION_CODE_OPCODE0)){
				ins = new Ins_rdrsrt(binaryString);
			}
			else {
				ins = new IncorrectInstruction(binaryString, _funcCode + " is not a valid function code for opcode 0");
			}
			
		}
		else if (_opCode == OP_FUNC1) {
			if (containsRtCode(Ins_rslbl.RT_CODE)) {
				ins = new Ins_rslbl(binaryString);
			}
			else if (containsRtCode(Ins_rsimm.RT_CODE)) {
				ins = new Ins_rsimm(binaryString);
			}
			else {
				ins = new IncorrectInstruction(binaryString, _rtCode + " is not a valid value for the rt field for opcode 1");
			}
		}
		else if(_opCode == OP_FUNC16){
			int formatCode = Integer.valueOf(binaryString.substring(6, 11), 2);
			if(containsFormatCode(Ins_rtrd_rdrt.FUNCTION_FORMATCODE, formatCode)){
				ins = new Ins_rtrd_rdrt(binaryString);
			}
			else {
				ins = new IncorrectInstruction(binaryString, "Unrecognized instruction");
			}
		}
		else if(_opCode == OP_FUNC17){
			int formatCode = Integer.valueOf(binaryString.substring(6, 11), 2);
			if(containsFormatCode(Ins_rtfs.FUNCTION_FORMATCODE, formatCode)){
				ins = new Ins_rtfs(binaryString);
			}else if(containsFormatCode(Ins_cclbl.FORMAT_CODE, formatCode)){
				ins = new Ins_cclbl(binaryString);
			}
			else {
				ins = new IncorrectInstruction(binaryString, "Unrecognized instruction");
			}
		}
		else if (_opCode == OP_FUNC28) {
			if (containsFuncCode(Ins_rsrt.FUNCTION_CODE_OPCODE28)) {
				ins = new Ins_rsrt(binaryString);
			}
			else if (containsFuncCode(Ins_rdrs.FUNCTION_CODE)) {
				ins = new Ins_rdrs(binaryString);
			}
			else if(containsFuncCode(Ins_rdrsrt.FUNCTION_CODE_OPCODE28)){
				ins = new Ins_rdrsrt(binaryString);
			}
			else {
				ins = new IncorrectInstruction(binaryString, _funcCode + " is not a valid function code for opcode 28");
			}
		}
		/*
		 * op code is enough to tell which function we want
		 */
		else if (containsOpCode(Ins_rsrtlbl.OP_CODE)) {
			ins = new Ins_rsrtlbl(binaryString);
		}
		else if (containsOpCode(Ins_jump.OP_CODE)) {
			ins = new Ins_jump(binaryString);
		}
		else if (containsOpCode(Ins_rtrsimm.OP_CODE)) {
			ins = new Ins_rtrsimm(binaryString);
		}
		else if (containsOpCode(Ins_rtimm.OP_CODE)) {
			ins = new Ins_rtimm(binaryString);
		}
		else if (containsOpCode(Ins_rtaddr.OP_CODE)) {
			ins = new Ins_rtaddr(binaryString);
		}
		else if (containsOpCode(Ins_rsrtimm.OP_CODE)) {
			ins = new Ins_rsrtimm(binaryString);
		}
		else if (containsOpCode(Ins_rslbl.OP_CODE)) {
			ins = new Ins_rslbl(binaryString);
		}		
		else {
			ins = new IncorrectInstruction(binaryString, "Unrecognized instruction ( opcode = " + _opCode + " )");
		}
		assert(ins != null);
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
		assert(_opCode == 0 || _opCode == 28 || _opCode == 16 || _opCode == 17);
		for (int i = 0; i < funcCodeClass.length; i++) {
			if (_funcCode == funcCodeClass[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean containsFormatCode(int[] formatCodeClass, int formatCode){
		assert(_opCode == 16 || _opCode == 17);
		for (int i = 0; i < formatCodeClass.length; i++) {
			if (formatCode == formatCodeClass[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean containsRtCode(int[] rtCodeClass) {
		assert(_opCode == 1);
		for (int i = 0; i < rtCodeClass.length; i++) {
			if (_rtCode == rtCodeClass[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isSpecialFunction(String binaryString) {
		if (binaryString.equals(SpecialInstruction.OP_NOP)) {
			return true;
		}
		return false;
	}
}
