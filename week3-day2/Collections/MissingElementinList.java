package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementinList {

	public static void main(String[] args) {
		List<Integer> list1= new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		Collections.addAll(list1,1,2,3,4,7,6,8);
		Collections.addAll(list2, 1,2,3,4,5,6,7,8,9,10);
		list2.removeAll(list1);
		System.out.println(list2);
		
		

	}

}
