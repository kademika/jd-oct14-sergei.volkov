package day7.hashcode;

import day7.classroomBar7.Student;

public class Person {
	String name;
	int age;
	long salary;
	Address adr;

	public Person(String name, int age, long salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
		adr = new Address("Kiev","Khreschatik",26);
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	@Override
	public int hashCode() {
		int result = 25;
		
		result = result*37 + name.hashCode();
		result = result*37 + ((Integer)age).hashCode();
		result = result*37 + new Long(salary).hashCode();
		if(adr!=null){
		  result = result*37 + adr.hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Person){
			Person p = (Person) obj;
			if(name != null && name.equals(p.name) && age == p.age && salary == p.salary){
				return true;
			}
		}
		return false;
	}

}
