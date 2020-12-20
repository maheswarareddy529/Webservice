package in.nit.test;

import org.apache.commons.codec.binary.Base64;

public class TestCodec {

	public static void main(String[] args) {
		//1. Take One input String
		String india="India is a Multi region Country";
		
		//2.Convert to byte[] format
		byte[] characters=india.getBytes();
		
		//3.Give data to Encoder
		byte[] encode=Base64.encodeBase64(characters);
		
		//4.convert Output byte[] to String
		String converted_String=new String(encode);
		
		//5.Print Encoding String
		System.out.println(converted_String);
		
		//--------------------------------------------------------------------------------------------------------------//
		
		//6.Read encoded String and convert to byte[]
		byte[] decode=converted_String.getBytes();
		
		//7.Decode byte[] given
		byte[] decoded_String=Base64.decodeBase64(decode);
		
		//8.Convert back to String Data Type
		String orignal_String=new String(decoded_String);
		
		//9.Print Decoded Data
		System.out.println(orignal_String);
	}

}
