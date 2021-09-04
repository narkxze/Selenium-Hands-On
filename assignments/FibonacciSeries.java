package week1.day1.assignments;

/*FIBONACCI SEQUENCE*/
public class FibonacciSeries {

	public static void main(String[] args) {
		int range = 8, first = 0, second = 1; // Initializing Variables.
		System.out.println("Fibonaaci series for first " + range + " terms are: ");
		for (int i = 1; i <= range; i++) { // For Loop up to "range" times execution.
			System.out.print(first + ", "); // Printing the first term of every loop.
			int sum = first + second; // Addition Operation to find the sum.
			first = second; // Assignment of second term to first term.
			second = sum; // Assignment of sum to second term.
		}

	}

}
