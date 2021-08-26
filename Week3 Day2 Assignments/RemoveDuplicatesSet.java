package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesSet {

	public static void main(String[] args) {
		String str =  "paypal india";
		
		char[] c1 = str.toCharArray();
		
		Set<Character> charSet1 = new LinkedHashSet<Character> ();
		
		Set<Character> dupCharSet = new LinkedHashSet<Character> ();
		
		
		for (int i = 0; i < c1.length; i++) {
			if(charSet1.contains(c1[i])) {
				dupCharSet.add(c1[i]);
			}else {
				charSet1.add(c1[i]);
			}
		}
		
		System.out.println("Charset value: "+charSet1);	
		System.out.println("Duplicate Charset value: "+ dupCharSet);
		
		dupCharSet.retainAll(charSet1);
		
		charSet1.removeIf(n -> (n==' '));
	        
		System.out.println("Charset without duplicates and spaces: "+charSet1);
	}

}
