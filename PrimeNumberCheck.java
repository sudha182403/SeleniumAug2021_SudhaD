package week1.day1;

public class PrimeNumberCheck {

	/*
	 * Goal: To find whether a number is a Prime number or not
	 * 
	 * input: 13
	 * output: 13 is a Prime Number
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
	 * 3) To create an 'if' condition: type 'if', followed by ctrl + space +down arrow + enter
	 *   
	 * What are my learnings from this code?
	 * 1) the curly braces of for loop if ended after if (b == true) condition, the result was different. learnt where to end the for loop in this java file.
	 * 2)
	 * 3) 
	 * 
	 */

	

	public static void main(String[] args) {
		
		// Declare an int Input and assign a value 13
		int a = 13;
		

		// Declare a boolean variable flag as false
		boolean b = false;		

		// Iterate from 2 to half of the input
		for(int i=2;i<=a/2;++i) {
			// Divide the input with each for loop variable and check the remainder
						// Set the flag as true when there is no remainder
						if(a % i == 0) {
							b = true;
							// break the iterator
							break;
						}
		}
						// Check the flag (Provide a condition)
						if (b == true)
							  // Print 'Prime' when the condition matches
						      System.out.println(a + " is a prime number.");
						 else
						      // Print 'Not a Prime' when the condition doesn't match 
						      System.out.println(a + " is not a prime number.");
						
		}		

}
