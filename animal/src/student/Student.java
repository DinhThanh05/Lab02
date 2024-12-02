package student;

public class Student {
	private String name;
	private int age;
	private double grade;
	public Student(String name,int age,double grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getGrade() {
		return grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public void isEligibleForGraduation() {
		//this.grade = grade;
		if (grade >= 5)  System.out.println("Khong du dieu kien");
		else System.out.println("Du dieu kien");
	}
	public void displayInfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("grade : " + grade);
	}
}
