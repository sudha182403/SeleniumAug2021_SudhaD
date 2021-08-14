package week1.day2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Pseudo Code
		  
		 *Declare a String 
			String text1 = "stops";
		 *Declare another String
			String text2 = "potss"; 
		 * a) Check length of the strings are same then (Use A Condition)
		 * b) Convert both Strings in to characters
		 * c) Sort Both the arrays
		 * d) Check both the arrays has same value
		 * 
		 */
		
		// *Declare a String 
		String text1 = "stops";
		
		//*Declare another String
		String text2 = "potss"; 
		 
		//a) Check length of the strings are same then (Use A Condition)
		if(text1.length() == text2.length()) {
			//b) Convert both Strings in to characters
			char[] ArrayS1 = text1.toLowerCase().toCharArray();  
            char[] ArrayS2 = text2.toLowerCase().toCharArray();  
            
            //c) Sort Both the arrays
            Arrays.sort(ArrayS1);  
            Arrays.sort(ArrayS2);  
            
            //d) Check both the arrays has same value
            if(Arrays.equals(ArrayS1, ArrayS2)) {
            	System.out.println(text1+" and "+text2+" are anagram");
            }else {
            	System.out.println(text1+" and "+text2+" are not anagram");
            }
		}
	}

}
