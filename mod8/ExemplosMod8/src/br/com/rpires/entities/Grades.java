package entities;

public class Grades {
	public String name;
	public double grade1;
	public double grade2;
	public double grade3;
	public double grade4;

	public double finalGrade() {
		return grade1 + grade2 + grade3 + grade4;
	}
	
	public double mediaOfGrades() {
		return (grade1 + grade2 + grade3 + grade4) / 4;
	}
}
