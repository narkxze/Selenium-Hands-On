package week2.day2.assignments;

public class RemoveDuplicatesinString {
	
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		char[] ch = text.toCharArray();
		for(int i = 0; i<ch.length;i++) {
			int count = 0;
			for(int j = 0; j<ch.length;j++) {
				if(ch[i]==ch[j]) {
					count= count+1;
				}
			}if(count<=1) {
				System.out.print(ch[i]);
			}
			
		}
		

	}

}
