package day7.classroomBar7;

public class Student {
  private String name;
  private String secondName;
  
  public Student(){
  }
  public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSecondName() {
	return secondName;
}
public void setSecondName(String secondName) {
	this.secondName = secondName;
}
public Student(String name, String secondName){
	  this.name = name;
	  this.secondName = secondName;
	  
  }

@Override
public String toString() {
	// TODO Auto-generated method stub
	return this.name + " " + this.secondName;
}
@Override
public boolean equals(Object obj) {
		
	if (obj instanceof Student){
		Student s = (Student) obj;
		if(name != null && name.equals(s.name) && secondName != null && 
				secondName.equals(s.secondName)){
			return true;
		}
	}
	return false; //(this.name.equals(((Student)obj).name) && (this.secondName.equals(((Student)obj).secondName)));
}
  
  
}
