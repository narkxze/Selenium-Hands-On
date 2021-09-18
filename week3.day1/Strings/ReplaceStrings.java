package org.strings;
public class ReplaceStrings {
	public static void main(String[] args) {
		String sentence = "I am working with Java8";
		String hash ="#";
		System.out.println(sentence.replace("8","11"));
		System.out.println(sentence.substring(5, 14).concat(hash));	
	}
}
