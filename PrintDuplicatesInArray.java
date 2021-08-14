package week1.day2;

import java.util.Arrays;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] arr1 = { 100, 200, 300, 400, 500, 100, 250, 500, 600, 150, 800 };
			
			Arrays.sort(arr1);
			
			System.out.println("Sorted arr1ay is " + Arrays.toString(arr1));			
			
			int count;
			for (int i = 0; i < arr1.length - 1; i++) {
				count = 0;
				for (int j = i + 1; j < arr1.length - 1; j++) {
					while (arr1[i] == arr1[j]) {
						count++;
						break;

					}
					if (count > 0) {
						System.out.println("The Duplicate value is " + arr1[i]);
						break;
					}
				}

			}
	}

}
