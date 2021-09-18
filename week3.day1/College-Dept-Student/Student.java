package org.student;

public class Student extends org.department.Department {
	public void studentName(String name) {
		System.out.println("Student Name: "+name);
	}
	public  void studentGrade(double grade) {
		System.out.println("Student's Grade: "+grade);
	}
	public  void studentId(int id) {
		System.out.println("Student's ID: "+id);
	}
	public static void main(String[] args) {
	Student student = new Student();
	student.studentName("Naresh");
	student.studentGrade(7.78);
	student.studentId(19);
	student.deptName("Mechanical");
	student.collegeName("SEC");
	student.collegeCode(1408);
	student.collegeRank(01);
	
	}

}
