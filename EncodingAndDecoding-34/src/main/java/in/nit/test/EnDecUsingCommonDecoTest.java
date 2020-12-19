package in.nit.test;

import org.apache.commons.codec.binary.Base64;

public class EnDecUsingCommonDecoTest {

	public static void main(String[] args) {
		
		//Original String or group of characters
		String welcome_Message="Welcome to Java Coding!";
		
		//converting String to bytes
		byte[] input=welcome_Message.getBytes();
		
		//Encode
		byte[] output=Base64.encodeBase64(input);
		
		//convert Encode  to String
		String encode=new String(output);
		//Encoded String
		System.out.println(encode);
		
		//Decode
		byte[] output1=Base64.decodeBase64(output);
		
		//convert Decode to String
		String decode=new String(output1);
		
		//Original String
		System.out.println(decode);

	}

}
