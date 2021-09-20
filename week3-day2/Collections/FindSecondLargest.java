package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FindSecondLargest {
	public static void main(String[] args) {
		List<Integer> num = new ArrayList<Integer>();
		Collections.addAll(num, 3,2,11,4,6,7);
		//sorts in ascending order
		Collections.sort(num);
		//gets the true maximum
		int trueMax =Collections.max(num); 
		//removes the index of that maximum
		num.remove(num.indexOf(trueMax)); 
		//printing the maximum in the now updated list
		System.out.println("2nd Maximum Value in the Array is "+Collections.max(num));
		

	}

}
