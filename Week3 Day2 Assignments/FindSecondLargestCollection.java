package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {3,2,11,4,6,7};

		List<Integer> list1 = new ArrayList<Integer>();
		
		for(Integer i:data) {
			list1.add(i);
		}
		
		Collections.sort(list1);
		
		System.out.println("List values after sorting are: "+list1);
		
		System.out.println("2nd element from last: "+(list1.get(list1.size()-2)));
	}

}
