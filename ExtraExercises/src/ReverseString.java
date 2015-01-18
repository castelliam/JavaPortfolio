/**
 * 
 * @author a_mcastelli
 * Reverses a string uses recursion
 *
 */


public class ReverseString {
	
	String reversed = "";
	
	public String reverse(String s){
		
		if(s.length() == 1){
			return s;
		}
		reversed += s.charAt(s.length()-1) + reverse(s.substring(0,s.length()-1));
		return reversed;
	}
	
	public static void main(String[] args){
		
		ReverseString s = new ReverseString();
		System.out.println(s.reverse("Hello"));
		
	}

}
