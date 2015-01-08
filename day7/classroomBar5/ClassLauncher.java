package day7.classroomBar5;

public class ClassLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Classroom classroom = new Classroom();
     
     classroom.enter("Sergei","Volkov");
     classroom.printStudentInfo();
     classroom.enter("Natalia","Dilova");
     classroom.enter("Vlad","Petrov");
     classroom.enter("Ivan","Sidorov");
     classroom.printStudentInfo();
     classroom.leave("Vlad","Petrov");
     classroom.printStudentInfo();
     classroom.getStudentCount();
     classroom.isPresent("Sergei","Volkov");
     classroom.isPresent("Ivan","Volkov");
     
     Classroom classroom1 = new Classroom();
     classroom1.students = classroom.getStudents();
     classroom1.printStudentInfo();
	}

}
