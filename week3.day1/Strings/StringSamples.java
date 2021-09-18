package org.strings;

public class StringSamples {

	public static void main(String[] args) {
		String str3 = new String("Kutty");
		String str4 = new String("Kutty");
		if(str3 == str4) {
			System.out.println("Same text");
		}else {
			System.out.println("Diff text");
		}
		System.out.println("***********");
	}
}
// The "==" operator compares the memory address of the String Values.
//As both the strings are declared in different objects, though the content is same,
//because of the different address, it is insignificant to use this.
//To avoid this, we can use equals() or equalsIgnoreCase().
//Also, if strings are declared in same address such as 
//str3 = "Kutty"; and str4 = "Kutty"; an if we use "==" operator, it will show as same text.