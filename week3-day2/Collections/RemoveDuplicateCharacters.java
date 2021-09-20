package week3.day2.assignments;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		String Name = "Paypal India";
		//Removes Blank Spaces
		String name =Name.replaceAll("\\s", ""); 
		//Conversion to Character Array
		char[] chArray = name.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		for (char c : chArray) {	
		if(charSet.add(c)) {
			charSet.add(c);
		}else {
			dupCharSet.add(c);
		}
		}
		//Removal of common elements from both set
		charSet.removeAll(dupCharSet);
		System.out.println(charSet);
		System.out.println(dupCharSet);

	}
}
