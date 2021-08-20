package week2.day2;

public class SumofDigitsFromStringAssignment {
	public static void main(String[] args) {
			
		/*
		 * Method 2
		 * Pseudo Code
		 * Declare a String text with the following value
			String text = "Tes12Le79af65";
		   Declare a int variable sum
			int sum = 0;
		 * a) Iterate an  array over the String
		 * b) Get each character and check if it is a number using Character.isDigit()
		 * c) Now covert char to int using Character.getNumericValue() and add it to sum
		 * d) Now Print the value
		 */
		
		String text1 = "Tes12Le79af65";
		int sum=0;
		String ReplacedText1 = text1.replaceAll("\\D", "");
		System.out.println(ReplacedText1);
		char[] CA = ReplacedText1.toCharArray();
		for(int i=0;i<CA.length;i++) {
			int num = Character.getNumericValue(CA[i]);
			sum=sum+num;
		}
		System.out.println(sum);
	}
}
