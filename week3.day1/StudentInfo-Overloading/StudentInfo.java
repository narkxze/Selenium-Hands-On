package org.studentsinfo;

public class StudentInfo {

	public void getStudentInfo(int id) {
	System.out.println("Student ID is: "+id);
	System.out.println("******************");
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID: "+id);
		System.out.println("Student Name: "+name);
		System.out.println("******************");
	}
	
	public void getStudentInfo(String email, long phoneNo) {
		System.out.println("Student E-Mail: "+email);
		System.out.println("Student PhoneNo: "+phoneNo);
		System.out.println("******************");
	}
	public static void main(String[] args) {
		StudentInfo student = new StudentInfo();
		student.getStudentInfo(17);
		student.getStudentInfo(17, "Naresh");
		student.getStudentInfo("ennkaeyy@gmail.com", 9566110384l);
		
		

	}

}
