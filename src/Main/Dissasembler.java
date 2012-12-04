package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Dissasembler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage : Dissasembler <File name>");
			System.exit(0);
		}
		else {
			String fileName = args[0];
			try {
				FileWriter fw = new FileWriter("output.html");
				BufferedWriter output = new BufferedWriter(fw);
				ArrayList<String> stringList = InstructionReader.readFile(fileName);
				printHtmlHeader(output);
				for (String s : stringList) {
					Instruction ins = InstructionFactory.createInstruction(s);
					output.write("<tr>\n<td>");
					ins.printValue(output);
					output.write("</td><td>");
					ins.printFormat(output);
					output.write("</td><td>");
					ins.printMnemonic(output);
					output.write("</td><td>");
					ins.printDecomposedDecimal(output);
					output.write("</td><td>");
					ins.printDecomposedHexa(output);
					output.write("</td>\n</tr>\n");
				}
				printHtmlFooter(output);
				output.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void printHtmlHeader(BufferedWriter output) throws IOException {
		output.write("<html>\n<body>\n<table>\n<tr>\n<th>Value</th><th>Format</th><th>Mnemonic</th><th>Decimal decomposition</th><th>Hexadecimal decomposition</th>\n</tr>\n");
	}

	private static void printHtmlFooter(BufferedWriter output) throws IOException {
		output.write("</table>\n</body>\n</html>");
	}

}
