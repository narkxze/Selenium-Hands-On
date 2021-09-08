package week1.day2.assignments;

public class FrequencyOfElements {

	public static void main(String[] args) {
		int[]arr = {3,4,2,5,1,2,6,3,6,2,4,7,1};
		for(int i = 0; i<arr.length;i++) {
			int count = 0;
			for(int j = 0; j<arr.length;j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			} System.out.println(" The frequency count of "+arr[i]+" is "+ count);
		}
	}

}
