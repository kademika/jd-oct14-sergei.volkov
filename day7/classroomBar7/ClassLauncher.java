package day7.classroomBar7;

public class ClassLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Classroom classroom = new Classroom();
     
     Student student1 = new Student("Sergei","Volkov");
     classroom.enter(student1);
    // classroom.printStudentInfo();
     Student student2 = new Student("Natalia","Dilova");
     classroom.enter(student2);
     Student student3 = new Student("Vlad","Petrov");
     classroom.enter(student3);
     Student student4 = new Student("Ivan","Sidorov");
     classroom.enter(student4);
     classroom.printStudentInfo();
    
     classroom.leave(student3);
     classroom.printStudentInfo();
     classroom.getStudentCount();
     classroom.isPresent("Sergei","Volkov");
     classroom.isPresent("Ivan","Volkov");
     
     Classroom classroom1 = new Classroom();
     classroom1.students = classroom.getStudents();
     classroom1.printStudentInfo();
	}

}
