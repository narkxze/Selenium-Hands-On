package week1.day1.assignments;

/*PRIME NUMBER CHECK*/
public class PrimeNumberCheck {

	public static void main(String[] args) {

		int num = 13; // Initializing a number
		boolean isPrime = false; // Boolean condition set to false
		for (int count = 2; count < num / 2; count++) { // Iterating from2 to half of input
			if (num % count == 0) { // Checking the remainder
				isPrime = true; // Boolean Variable Updated
				break; // Iterator break
			}
		}
		if (isPrime) { // flag check
			System.out.println(num + " is a Prime Number");
		} else {
			System.out.println(num + " is not a prime Number");
		}

	}
}
