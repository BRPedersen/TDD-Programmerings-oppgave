import java.util.Arrays;
import java.util.Collections;

public class Converter {
	
	static String hexValues = "0123456789ABCDEF";		// String som brukes til � definerer tallverdier for karakterene
	
	/** Metode for � konvertere en Hex-string til en int verdi */
	public static int hexToInt(String hex) {
		
		if (hex.length() > 6) throw new IllegalArgumentException();		// Sjekker om stringen som kommer inn er for lang, kaster IllegalArgumentException.
		
		
		for (int i = 0; i < hex.length(); i++)		// Sjekker om en karakter i stringen er en hexadecimal karakter, hvis ikke kastest IllegalArgumentException 
			if (Character.digit(hex.charAt(i), 16) == -1) 
				throw new IllegalArgumentException();
			
			
		int counter = hex.length() -1;			// Lengde p� hex-verdi
		int sum = 0;							// int som skal returneres, hvis hex stringen er tom vil det returneres 0
			
		
		for (char c : hex.toCharArray()) {			// G�r gjennom alle verdiene som sendes inn
			char d = Character.toUpperCase(c);		// Gj�r om hver karakter til upperCase, slik at koden finner den i hexValues
			int i = hexValues.indexOf(d);			// "konverterer" verdiene til tallverdien de har i posisjonen i stringen
			sum = (int) (sum + (Math.pow(16, counter))*i);	// Bruker Math.pow til � regne ut desimal-verdien av hex-verdien
			counter--;
		}
		return sum;	
		
	}
	
	/** Metode for � konvertere en Bit-string til en int verdi */
	public static int bitToInt(String binary) {
		
		if (binary.length() > 24) throw new IllegalArgumentException();		// Sjekker lengden p� bit stringen
	    for (int i = 0; i < binary.length(); i++)							// Sjekker om andre tegn enn 0 og 1 sendes inn
	    	if (Character.digit(binary.charAt(i), 2) == -1)
	    		throw new IllegalArgumentException();
		
	    char[] numbers = binary.toCharArray();		// Lager et array av stringen med bit-verdier
	    int result = 0;								// Variabel som returneres, returnerer 0 hvis String binary er en tom string
	    
	    for(int i = numbers.length - 1; i >= 0; i--)	// For-l�kke som g�r gjennom bit-stringen og bruker Math.pow til � regne ut verdien
	        if(numbers[i]=='1')
	            result += Math.pow(2, (numbers.length-i - 1));
	    return result;
	}
	
	/** Metode for � konvertere en int verdi til en Bit-string */
	public static String intToBit(int num){
		 java.util.ArrayList<Integer> binary = new java.util.ArrayList<>();		// ArrayList for � holde p� bit-stringen
	     
	     while(num > 0){		// Konverterer int verdi til bit
	       binary.add(num%2);
	       num = num/2;
	     }
	     
	     Collections.reverse(binary);	// Reverserer ArrayList for � f� riktig rekkef�lge p� bin�r-tallene
	     
	     StringBuilder builder = new StringBuilder();	// Oppretter en StringBuilder for � kunne returnere en String
	     
	     for (Integer i : binary){
	    	 while(builder.length() < 24 - binary.size()){		// Legger til 0'er fremst i stringen for � oppfylle kravet om 24 tegn
	    		 builder.append(0);								// Legger bin�rtallene fra binary til StringBuilder builder
	    	 }
	     builder.append(i);
	     }
	     
	     return builder.toString();
	  }
	
	/** Metode for � utf�re Bitwise operasjoner p� to bit-stringer */
	public static String bitwise(String one, String two, int operation){
		int first = bitToInt(one);		// F�rste bitstring
		int second = bitToInt(two);		// Andre bitstring
		int result = 0;				
		
		if(operation == 1) {			// Gj�r en Bitwise AND (&)
			result = first & second;
			return intToBit(result);
		}
		else result = first ^ second;	// Bitwise OR (^)
		return intToBit(result);
	}
	
	
	
	
	
	
	

}
