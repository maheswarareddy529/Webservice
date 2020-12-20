package in.nit.test;

import java.util.Base64;

public class EnCoDecTest {

	public static void main(String[] args) {
		String message_name="Welcome To All!";
		byte[] encode=Base64.getEncoder().encode(message_name.getBytes());
		String data=new String(encode);
		System.out.println(data);
		//---------------------------------------------------------------------------------------------
		byte[] decode=Base64.getDecoder().decode(data.getBytes());
		String data1=new String(decode);
		System.out.println(data1);
		

	}

}
