package week2.day2.assignments;

public class ReverseString {

	public static void main(String[] args) {
		String test = "feeling good";
		char[] arr = test.toCharArray();
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}

	}

}
