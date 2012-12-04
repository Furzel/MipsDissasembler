package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Dissasembler {

	private static final String BEAUTIFUL_CSS = "<style type=\"text/css\">body{ padding:0; margin:0; width: 100%;}" +
			"table{ width: 100%; margin:0; padding:0; border:none; border-spacing: 0;}" +
			"tr:nth-child(even) {background: #CCCCCC; border:none;}"+
			"tr:nth-child(odd) {background: #FFFFFF; border:none;}"+
			"td{ margin:0; padding:0; text-align:center; border:none; padding: 8pt;}" +
			"th{ border-bottom: 4px solid black; padding: 8pt;}"+
			"</style>";
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
		output.write("<html>\n"+BEAUTIFUL_CSS+"<body>\n<table>\n<tr>\n<th>Value</th><th>Format</th><th>Mnemonic</th><th>Decimal decomposition</th><th>Hexadecimal decomposition</th>\n</tr>\n");
	}

	private static void printHtmlFooter(BufferedWriter output) throws IOException {
		output.write("</table>\n</body>\n</html>");
	}

}
