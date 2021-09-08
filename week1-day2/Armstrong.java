package week1.day2.assignments;

public class Armstrong {

	public static void main(String[] args) {
		int num = 153;
		int temp = 0, rem = 0;
		int result = 0;
		temp = num;
		
		while(temp>0) {
			rem = temp%10;
			result = result+(rem*rem*rem);
			temp = temp/10;
		}
		if(num == result) {
			System.out.println(num+ " Is an Armstrong Number");
		}else {
			System.out.println(num+ " is not an Armstrong Number");
		}

	}

}
