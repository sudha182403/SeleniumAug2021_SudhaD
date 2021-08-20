package week2.day2;

public class RemoveDuplicatesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
		//Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";	
		
		//Initialize an integer variable as count
		int count=0;
		
		//Split the String into array and iterate over it
		String[] split = text.split(" ");
		
		//Initialize another loop to check whether the word is there in the array
		for (int i = 0; i < split.length; i++) {
			System.out.println("split[i]: "+split[i]);
			for(int j=0; j<split.length; j++) {
				System.out.println("split[j]: "+split[j]);
				if (split[i] == split[j]) {
					count++;
					break;
	
				}else {
					split[i].replace("\\D", "");
					break;
				}
			}
			//g) Displaying the String without duplicate words
			char[] evenWords = (split[i]).toCharArray();
			for (int k = evenWords.length - 1; k >= 0; k--) {
				//System.out.print(evenWords[k]);
			}
	}
	}
}
