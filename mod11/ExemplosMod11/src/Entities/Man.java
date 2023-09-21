package Entities;

public class Man {
	private int id;
	private String name;
	private double salary;
	private Gender gender;

	public Man() {
	}

	public Man(int id, String name, double salary, Gender gender) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.setGender(gender);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void increaseSalary(double percentage) {
		salary += salary * percentage / 100.0;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f%n", salary);
	}

}
