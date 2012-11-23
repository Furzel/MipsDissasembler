package Main;

import java.util.ArrayList;


public class Dissasembler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> stringList = InstructionReader.readFile();
		for (String s : stringList) {
			Instruction ins = InstructionFactory.createInstruction(s);
			ins.printFormat();
			ins.printMnemonic();
			ins.printDecomposedDecimal();
			ins.printDecomposedHexa();
		}
	}

}
