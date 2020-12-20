package in.nit.test;

import java.util.Base64;

public class TestCodec1 {

	public static void main(String[] args) {
		//1. Take One input String
		String india="Naresh I Technologies";
		
		//2.Convert to byte[] format
		byte[] characters=india.getBytes();
		
		//3.Give data to Encoder
		Base64.Encoder encode=Base64.getEncoder();
		
		//4.Encode Data
		byte[] data=encode.encode(characters);
		
		//5.Covert Encode  Data to String
		String encode_Data=new String(data);
		
		//6.Print Data
		System.out.println(encode_Data);
		
		
		//--------------------------------------------------------------------------------------------------------------//
		
		//6.Read encoded String and convert to byte[]
		byte[] decode=encode_Data.getBytes();
		
		//7.Decode byte[] given
		Base64.Decoder decoded_String=Base64.getDecoder();
		
		//8.Convert to byte[]
		byte[] decode_Data=decoded_String.decode(decode);
		
		//9.Convert back to String Data Type
		String orignal_String=new String(decode_Data);
		
		//10.Print Decoded Data
		System.out.println(orignal_String);
	}

}
