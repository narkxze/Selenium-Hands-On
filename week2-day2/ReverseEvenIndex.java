package week2.day2.assignments;

public class ReverseEvenIndex {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] s = test.split(" ");
		for (int i = 0; i < s.length; i++) {
			if (i % 2 != 0) {
				char[] ch = s[i].toCharArray();
				for (int j = ch.length - 1; j >= 0; j--) {
					System.out.print(ch[j]);
				}
				System.out.print(" ");
			} else {
				char[] ch = s[i].toCharArray();
				for (int j = 0; j < ch.length; j++) {
					System.out.print(ch[j]);
				}
				System.out.print(" ");
			}
		}
	}
}
