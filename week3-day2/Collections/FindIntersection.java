package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FindIntersection {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		Collections.addAll(list1, 3,2,11,4,6,7);
		Collections.addAll(list2, 1,2,8,4,9,7);
		list2.retainAll(list1);
		System.out.println(list2);

	}

}
