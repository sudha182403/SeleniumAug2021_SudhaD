package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionCollections {

	public static void main(String[] args) {
		
		int[] arrNum_1 = {3,2,11,4,6,7}; 
		int[] arrNum_2 = {1,2,8,4,9,7}; 
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		for(Integer i : arrNum_1) {
			list1.add(i);
		}
		
		for(Integer j : arrNum_2) {
			list2.add(j);
		}
		
		list1.retainAll(list2);
		
		System.out.println("intersection values of both arrays are: "+list1);		
		
	}

}
