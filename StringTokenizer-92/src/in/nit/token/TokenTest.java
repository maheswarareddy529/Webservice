package in.nit.token;

import java.util.StringTokenizer;

public class TokenTest {
/*
 * StringTokenizer is used to break a String into Tokens.
 * 
 */
	public static void main(String[] args) {
		
//StringTokenizer st=new StringTokenizer("MY,NAME IS SANKAR",",");
		StringTokenizer st=new StringTokenizer("MY NAME IS SANKAR"," ");
while(st.hasMoreTokens()) {
	System.out.println(st.nextToken());
}
System.out.println("----------------------------------------------------------------");
StringTokenizer st1=new StringTokenizer("MY NAME IS SANKAR");
System.out.println(st1.nextToken(" "));
	}

}
