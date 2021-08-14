package week1.day2;

public class ChangeOddIndexToUpperCase {
	public static void main(String[] args) {
		//Declare String Input as Follow
		String test = "changeme";
		
		//a) Convert the String to character array
		char[] ch = test.toCharArray();
		  
	    //b) Traverse through each character (using loop)
	    for (int i = 0; i < ch.length; i++) {
	    	char c = ch[i];
	        ch[i] = test.charAt(i);
	        
	        //c)find the odd index within the loop (use mod operator)     
	        if(i%2 != 0){
	        	c = Character.toUpperCase(c);
	        	
	        	//d)within the loop, change the character to upper case, if the index is odd else don't change
	        	System.out.println("value of c is "+c);
	        }
	    }		
	}
}
