import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestConverter {
	
	Converter converter;
	
	@Before
	public void setUp(){
		converter = new Converter();
	}
	
	// HexToInt - Tester
	
	@Test
	public void hexToInt_ValidHexString_ShouldReturnConvertedValue(){
		
		assertThat(converter.hexToInt("03ac0"), equalTo(15040));
	}
	
	@Test
	public void hexToInt_EmptyString_ShouldReturnZero(){
		
		assertThat(converter.hexToInt(""), equalTo(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hexToInt_TooLongString_ShouldThrowIllegalArgumentException(){
		
		converter.hexToInt("03ac0fb");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hexToInt_InvalidCharacterInString_ShouldThrowIllegalArgumentException(){
		
		converter.hexToInt("��tlk");
	}
	
	// BitToInt - tester
	
	@Test
	public void bitToInt_ValidBitString_ShouldReturnConvertedValue(){
		
		assertThat(converter.bitToInt("110101000000110111001101"), equalTo(13897165));
	}
	
	@Test
	public void bitToInt_EmptyString_ShouldReturnZero(){
		
		assertThat(converter.bitToInt(""), equalTo(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void bitToInt_TooLongString_ShouldThrowIllegalArgumentException(){
		
		converter.bitToInt("1101010000001101110011010");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void bitToInt_InvalidCharacterInString_ShouldThrowIllegalArgumentException(){
		
		converter.bitToInt("110101000002110111001101");
	}
	
	// IntToBit - Tester
	
	@Test
	public void intToBit_ValidIntValue_ShouldReturnConvertedValue(){
		
		assertThat(converter.intToBit(999), equalTo("000000000000001111100111"));
	}
	
	// Bitwise - Tester
	
	@Test
	public void bitwise_BitwiseANDOperationOnTwoBitStrings_ShouldReturnTwentyFourCharBitString(){
		
		assertThat(converter.bitwise("000000000000000000111100", "000000000000000000001101", 1), equalTo("000000000000000000001100"));
	}
	
	@Test
	public void bitwise_BitwiseOROperationOnTwoBitStrings_ShouldReturnTwentyFourCharBitString(){
		
		assertThat(converter.bitwise("000000000000000000111100", "000000000000000000001101", 2), equalTo("000000000000000000110001"));
	}
}