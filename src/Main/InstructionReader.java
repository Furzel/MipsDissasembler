package Main;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Set;


public final class InstructionReader {
	
	private static final String FILE_NAME = "data/all_hex.txt";
	//private static final String FILE_NAME = "data/paul_hex.txt";
	public static final ArrayList<SimpleEntry<String, String>> readFile(String filename) {
		ArrayList<SimpleEntry<String, String>> stringList = new ArrayList<SimpleEntry<String, String>>();
		try {
			FileInputStream input = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(input)));
			String line;
			while ((line = reader.readLine()) != null) {
				String binaryString = "";
				//System.out.println("Line read = " + line);
				if (line.contains("0x")) {
					BigInteger value = new BigInteger(line.replace("0x", ""), 16);
					binaryString = value.toString(2);
				}
				else {
					BigInteger value = new BigInteger(line);
					binaryString = value.toString(2);
				}
				// Add 0 to the begining if the string is less than 32 bit long
				if (binaryString.length() < 32) {
					int nbMissingZero = 32 - binaryString.length();
					for (int i = 0; i < nbMissingZero; i++) {
						binaryString = "0" + binaryString;
					}
				}
				assert(binaryString.length() == 32);
				SimpleEntry<String, String> entry = new SimpleEntry<String, String>(binaryString, line);
				stringList.add(entry);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find or open file : " + FILE_NAME + "\nclosing");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringList;
	}
	
}
