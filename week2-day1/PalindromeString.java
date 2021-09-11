package week2.day1.assignments;

public class PalindromeString {

	public static void main(String[] args) {
		String s = "Rotavator";
		String reverse ="";
		for(int i = s.length()-1; i>=0; i--) {
			reverse = reverse+s.charAt(i); 
		}
		if(s.equalsIgnoreCase(reverse)) {
			System.out.println(s+" is Palindrome");
		}else {
			System.out.println(s+" is not palindrome");
		}
	}

}
