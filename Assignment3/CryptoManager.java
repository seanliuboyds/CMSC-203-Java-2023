

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; 

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// throw new RuntimeException("method not implemented");
		for (int i = 0; i < plainText.length(); i++) {
			
			if (plainText.charAt(i) < (int)LOWER_BOUND || plainText.charAt(i) > (int)UPPER_BOUND) {
				return false;
			}
		}
		return true;
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		

        String message = "";
        if (stringInBounds(plainText)) {
		for (int i = 0; i < plainText.length(); i++) {
				int pos1 = (int)(plainText.charAt(i));
                int pos2 = (pos1 + key);
                while (pos2 > UPPER_BOUND) {
                	pos2 -= RANGE;
                }
                char newCh = (char) pos2;
                message = message + newCh;
			
			}
        
		return message;	
		}
        return "encryption failed";
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		String key = "";
		
		String encrypted = "";
		
		for (int i = 0, j = 0; i < plainText.length(); i++, j++) {
			if (j == bellasoStr.length()) {
				j = 0;
			}
			key += bellasoStr.charAt(j);
			
		}
		if (stringInBounds(plainText)) {
		for (int i = 0; i < plainText.length(); i++) {
			int encryptInt = (int)(plainText.charAt(i) + key.charAt(i));
			while (encryptInt > UPPER_BOUND) {
				encryptInt -= RANGE;
			}
			encrypted += (((char)(encryptInt)));
			
		}
		return encrypted;
		} else {
		return "encryption failed";
		}
		
		
		
	
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
	//	throw new RuntimeException("method not implemented");
		
		  String decryptedMessage = "";
		  if (stringInBounds(encryptedText)) {
			for (int i = 0; i < encryptedText.length(); i++) {

	            int pos1 = (int)encryptedText.charAt(i);

	            int pos2 = (int)(pos1 - key);

	            while (pos2 < LOWER_BOUND) {
	                pos2 += RANGE;
	            } 

	            char newCh = (char) pos2;
	            
	            
	            

	            decryptedMessage += newCh;
	        } 
	        
	    return decryptedMessage;
		  }
	    return "decryption failed";
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		String key = "";
		String decryptText = "";
		
		
		for (int i = 0, j = 0; i < encryptedText.length(); i++, j++) {
			if (j == bellasoStr.length()) {
				j = 0;
			}
			key += bellasoStr.charAt(j);
			
		}
		if (stringInBounds(encryptedText)) {
		for (int i = 0; i < encryptedText.length(); i++) {
			int decryptInt = (int) ((encryptedText.charAt(i) - key.charAt(i)));
			while (decryptInt < LOWER_BOUND) {
				decryptInt += RANGE;
			}
			decryptText += (char)decryptInt;
			
		}
		
		
		return decryptText;
		}
		return "decryption failed";

	}
}
