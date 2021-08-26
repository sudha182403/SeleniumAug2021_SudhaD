package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindMissingElementsCollection {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,7,6,8};
		
		List<Integer> arr1 = new ArrayList<Integer>();
		
		for(Integer i:arr) {
			arr1.add(i);			
		}
		for (int j = 0; j < arr1.size()-1; j++) {
			if(arr1.get(j) != j) {
				System.out.println(" missing element :" + j);
				break;
			}
		}
		

	}

}
