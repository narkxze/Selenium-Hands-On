package week1.day1.assignments;

/*FACTORIALS*/
public class Factorials {

	public static void main(String[] args) {
		int number = 5; // number initialized
		int fact = 1; // factorial initialized
		for (int i = number; i >= 1; i--) { // looping statement
			fact = fact * i;
		}
		System.out.println(fact); // print statement

	}

}
