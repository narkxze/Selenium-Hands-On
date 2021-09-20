package week3.day2.assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String Text = "We learn java basics as part of java sessions in java week1";	
		String text = Text.replaceAll("\\s", "");
		System.out.println(text);
		char[] chArray = text.toCharArray();
		Set<Character>charSet = new LinkedHashSet<Character>();
		for(char c: chArray) {
			if(charSet.add(c)) {
				charSet.add(c);	
			}
		}
		System.out.println(charSet);
		

	}

}
