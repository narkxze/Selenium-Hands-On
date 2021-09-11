package week2.day1.assignments;

public class FindTypes {
	public static void main(String[] args) {
		int  letter=0, space=0, num=0, specialChar=0;
		String test = "$$ Welcome to 2nd Class of Automation $$";
		char[] arr = test.toCharArray();
		
		for(int i =0; i<arr.length;i++) {
			if(Character.isLetter(arr[i])) {
				letter++;
			}else if(Character.isDigit(arr[i])) {
				num++;
			}else if(Character.isSpace(arr[i])) {
				space++;
			}else {
				specialChar++;
			}
		}
		System.out.println("Letters: "+letter);
		System.out.println("Numbers: "+num);
		System.out.println("Space: "+space);
		System.out.println("Special Characters: "+specialChar);

	}

}
