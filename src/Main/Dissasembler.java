package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;


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
		if (args.length < 2) {
			System.out.println("Usage : Dissasembler <input file name> <output file name>");
			System.out.println("Output is an html file");
			System.exit(0);
		}
		else {
			String inputFileName = args[0];
			String outputFileName = args[1];
			try {
				FileWriter fw = new FileWriter(outputFileName);
				BufferedWriter output = new BufferedWriter(fw);
				ArrayList<SimpleEntry<String, String>> entryList = InstructionReader.readFile(inputFileName);
				printHtmlHeader(output);
				for (SimpleEntry<String,String> entry : entryList) {
					Instruction ins = InstructionFactory.createInstruction((String)entry.getKey());
					output.write("<tr>\n<td>");
					output.write((String)entry.getValue());
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
