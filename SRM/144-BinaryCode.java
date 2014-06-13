public class BinaryCode {

	public String[] decode(String message) {
		return new String[] { decode('0', message), decode('1', message) };
	}
	
	public String decode(char firstValue, String encoded) {
		char[] decoded = new char[encoded.length()];
		decoded[0] = firstValue;
		
		int decPrev, decNext;
		int decCur = Character.getNumericValue(firstValue);

		for (int i = 0; i < encoded.length(); i++) {
			int encCur = Character.getNumericValue(encoded.charAt(i));
			decNext = encCur - decCur - decPrev;
			
			if (i == encoded.length() - 1) {
				if (encCur != decCur + decPrev) {
					return "NONE";
				}
			} else if (decNext > 1 || decNext < 0) {
				return "NONE";
			}

			decoded[i + 1] = decNext;
			decPrev = decCur;
			decCur = decNext;
		}
		
		return new String(decoded);
	}
}