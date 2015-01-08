package day7.classroomBar5;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	List<Student> students;

	public Classroom() {
		this.students = new ArrayList<>();
	}

	public void enter(String name, String secondName) {
		students.add(new Student(name, secondName));
	}

	/*
	 * public void leave(String name, String secondName){ int i = 0;
	 * 
	 * for (Student s : students){ if (s.name.equalsIgnoreCase(name) &&
	 * s.secondName.equalsIgnoreCase(secondName)){ break; }else { i++; } }
	 * if(!students.remove(students.get(i))){
	 * System.out.println("Element was not found"); }; }
	 */
	public void leave(String name, String secondName) {
		if (!students.remove(new Student(name, secondName))) {
			System.out.println("Element was not found");
		}
	}

	public void getStudentCount() {
		int i = 0;

		for (Student s : students) {
			i++;
		}
		System.out.println("  " + i + " student(s) in the classroom now");
	}

	public void printStudentInfo() {
		System.out.println("Students in the classroom:");
		for (Student s : students) {
			System.out.println("   " + s.getName() + " " + s.getSecondName());
		}
	}

	public void isPresent(String name, String secondName) {
		boolean found = false;
		for (Student s : students) {
			if (s.getName().equalsIgnoreCase(name)
					&& s.getSecondName().equalsIgnoreCase(secondName)) {
				System.out.println("Student " + name + " " + secondName
						+ " is present in the classroom.");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Student " + name + " " + secondName
					+ " is not present in the classroom.");
		}
	}

	public List<Student> getStudents() {
		return new ArrayList<Student>(students);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		this.printStudentInfo();
		return super.toString();
	}

}
