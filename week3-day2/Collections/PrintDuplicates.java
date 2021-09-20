package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintDuplicates {

	public static void main(String[] args) {
		List<Integer>numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, 14,12,13,11,15,14,18,16,17,19,18,17,20);
		Set<Integer> s = new HashSet<Integer>();
		for(int duplicates:numbers) {
		if(!s.add(duplicates)) {
			System.out.println(duplicates);
		}

	}

}}
