package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		//a) Declare An array for {3,2,11,4,6,7};	
		int[] arrNum_1 = {3,2,11,4,6,7};
		
		//b) Declare another array for {1,2,8,4,9,7};
		int[] arrNum_2 = {1,2,8,4,9,7};
		
		//Declare for loop iterator from 0 to array length
		for(int i=0;i<arrNum_1.length;i++) {
			//Declare a nested for another array from 0 to array length
			for(int j=0;j<arrNum_2.length;j++) {
				
				//Compare Both the arrays using a condition statement
				if(arrNum_1[i] == arrNum_2[j]) {
					//Print the first array (shoud match item in both arrays)
					System.out.println(arrNum_1[i]);
				}
			}
		}
		
	}

}
