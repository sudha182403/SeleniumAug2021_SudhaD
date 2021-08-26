package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesCollection {

	public static void main(String[] args) {
		
		int[] arr1 = { 14, 12, 13, 11, 15, 13, 14, 18, 16, 17, 19, 18, 17, 20 };
		Arrays.sort(arr1);
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i+1; j < arr1.length; j++) {
				if(arr1[i]==arr1[j]) {
					list2.add(arr1[i]);
				}
			}
			list1.add(arr1[i]);
		}
		list1.removeAll(list2);
		System.out.println("List after duplicates removal: "+list1);
	}

}
