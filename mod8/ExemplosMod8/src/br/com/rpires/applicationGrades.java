package exercise_module8;

import java.util.Locale;
import java.util.Scanner;

import entities.Grades;

/*
* @author: Steve.Vaz
*/
public class applicationGrades {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Grades student = new Grades();
		
	    student.name = sc.nextLine();
	    student.grade1 = sc.nextDouble();
	    student.grade2 = sc.nextDouble();
	    student.grade3 = sc.nextDouble();
	    student.grade4 = sc.nextDouble();
	    
	    System.out.printf("Final Grade: %.2f%n", student.finalGrade());
	    System.out.printf("Grade average: %.2f%n", student.mediaOfGrades());
	    
	    if (student.finalGrade() < 32.00) {
	    	System.out.println("Disapproved");
	    } else {
	    	System.out.println("Mission complete");
	    }
	    
	    sc.close();
	}
}
