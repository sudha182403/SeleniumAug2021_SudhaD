package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestCollect {
	public static void main(String[] args) {
		String[] arr1 = {"Google","Microsoft","TestLeaf","Maverick"};
		
		System.out.println("Length of array is "+arr1.length);
		
		ArrayList<String> al =  new ArrayList<String>(Arrays.asList(arr1));
		
		Collections.sort(al);
		
		System.out.println("Sorted array using collections: " + al);
		
		Collections.reverse(al);
		
		System.out.println("Reverse sorted array using collections: "+al);
	}
}
