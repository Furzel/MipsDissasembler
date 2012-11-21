package Main;




public class InstructionFactory {
	
	private final static int OP_FUNC0 = 0;
	private final static int OP_FUNC1 = 1;
	private final static int OP_FUNC28 = 28;

	
	public static final Instruction createInstruction(String binaryString) {
		Instruction ins = null; 
		int opCode = Integer.valueOf(binaryString.substring(0, 7), 2);
		/*
		 * Should we look at the function field ?
		 */
		if (opCode == OP_FUNC0) {
			
		}
		else if (opCode == OP_FUNC1) {
			
		}
		else if (opCode == OP_FUNC28) {
			
		}
		/*
		 * op code is enough to tell which function we want
		 */
		else {
			// Unrecognized opcode
			assert(false);
		}
		return ins;
	}
	
	private static boolean containsOpCode(String opCode, String[] opCodeClass) {
		for (int i = 0; i < opCodeClass.length; i++) {
			if (opCode.equals(opCodeClass[i])) {
				return true;
			}
		}
		return false;
	}
}
