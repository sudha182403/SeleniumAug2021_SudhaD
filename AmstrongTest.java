package week1.day1;

public class AmstrongTest {
	/*
	 * Goal: To find whether a number is an Armstrong number or not
	 * 
	 * inputs: 153 output: (1*1*1)+(5*5*5)+(3*3*3) = 153
	 * 
	 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
	 * create a While loop, type 'while' followed by: ctrl + space + down arrow +
	 * enter 3) To create an 'if' condition: type 'if', followed by ctrl + space
	 * +down arrow + enter
	 * 
	 * What are my learnings from this code? 1) 2) 3)
	 * learnt the purpose of while loop and how it is different from for loop.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare your input
		int armNo = 153;

		// Declare 3 more int variables as calculated, remainder, original (Tip:
		// Initialize calculated alone)
		int a = 0, n, temp;
		// Assign input into variable original
		temp = armNo;
		// Use loop to calculate: use while loop to set condition until the number
		// greater than 0
		while (temp != 0) {
			// Within loop: get the remainder when done by 10 (Tip: Use Mod operator)
			n = temp % 10;

			// Within loop: get the quotient when done by 10 (Tip: Assign the result to
			// input)
			temp = temp / 10;

			// Within loop: Add calculated with the cube of remainder & assign it to
			// calculated
			a = a + (n * n * n);

			// Check whether calculated and original are same
			if (a == armNo) {
				// When it matches print it as Armstrong number
				System.out.println(armNo + " is an Armstrong number");
			}
		}
	}

}
