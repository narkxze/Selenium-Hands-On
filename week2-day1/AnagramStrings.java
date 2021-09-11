package week2.day1.assignments;

import java.util.Arrays;

public class AnagramStrings {

	public static void main(String[] args) {
		String s1 = "supersonic";
		String s2 = "percussion";
		
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean result =Arrays.equals(arr1, arr2);
		if(result) {
			System.out.println("Strings are Anagram");
		}else {
			System.out.println("Strings are not Anagram");
		}
			
			
	
		

	}

}
