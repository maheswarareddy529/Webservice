package in.nit.test;

import java.util.Base64;
//core API
public class Encoding_Decoding_Test {

	public static void main(String[] args) {
		
		String sentence="you are good boy...";
		
		//Create Encoder Object
		Base64.Encoder en_Base=Base64.getEncoder();
		
		//Encoding String
		String encode=en_Base.encodeToString(sentence.getBytes());
		
		//Encoded String
		System.out.println("Encoded String            :           "+encode);

		System.out.println("-----------------------------------------------------------------------------------");
		
		//Decoding Object
		Base64.Decoder de_Base=Base64.getDecoder();
		
		
		//DeCoded String
		String decode=new String(de_Base.decode(encode.getBytes()));
		
		//decoded String
		System.out.println("Decoded String             :             "+decode);
		
	}

}
