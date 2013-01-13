package tools;

public final class Tools {

	/**
	 * Create a binary string using 2 complements on a specified number of bit
	 * @param binaryString a binary string to extend
	 * @param bitNumber length of the desired string
	 * @return binary string using 2 complements on a specified number of bit
	 */
	public static String extendToMaxBitsSigned(String binaryString, int bitNumber){
		String ret = binaryString;
		boolean isNegative = (binaryString.length() == bitNumber && binaryString.charAt(0) == '1') ? true : false;
		if(binaryString.length() < bitNumber){
			for(int i = binaryString.length(); i < bitNumber; i++){
				ret = (isNegative) ? "1" + ret : "0" + ret;
			}
		}else{
			ret = binaryString.substring(binaryString.length() - bitNumber);
		}
		return ret;
	}
	
	public static int getIntegerSignedValue(String binaryString, int bitNumber){
		int x = 0;
		binaryString = extendToMaxBitsSigned(binaryString, bitNumber);
		boolean isNegative = (binaryString.length() == bitNumber && binaryString.charAt(0) == '1') ? true : false;
		if(isNegative){
			for(int i = 0; i < 32 - bitNumber; i++){
				x <<= 1;
				x |= 1;
			}
		}
		for(int i = 0; i < bitNumber; i++){
			x <<= 1;
			x |= (binaryString.charAt(i) == '1') ? 1 : 0;
		}
		return x;
	}
	
}
