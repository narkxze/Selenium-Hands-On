package org.strings;

public class StringsCompare {

	public static void main(String[] args) {
		String String1 = "I am Learning Java";
		String String2 = "I am learning java?";
		if (String1.equalsIgnoreCase(String2)) {
			System.out.println("Both the Strings are same!");
		} else {
			System.out.println("Not the same strings!");
		}
	}
}
