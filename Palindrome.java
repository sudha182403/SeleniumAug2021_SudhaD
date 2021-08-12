package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		
		 * a) Declare A String value as"madam"
		 
		 * b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order
		 * d) Add the char into rev
		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		 */
		
		//a) Declare A String value as"madam"
		String str_1 = "madam";
		
		//b) Declare another String rev value as ""
		String str_2 = "";
		
		//c) Iterate over the String in reverse order
		for(int i=(str_1.length()-1);i>=0;--i) {
		
			//d) Add the char into rev
			str_2 = str_2 + str_1.charAt(i);
			
		}
		
			//e) Compare the original String with the reversed String, if it is same then print palinDrome
			if(str_1.equals(str_2)) {
				System.out.println("Entered string is a palindrome");
			}else {
				System.out.println("Entered string is not a palindrome");
			}
		
	}

}
