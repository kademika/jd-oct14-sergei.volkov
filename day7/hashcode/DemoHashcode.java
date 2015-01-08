package day7.hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DemoHashcode {

	public static void main(String[] args) {
		Person p1 = new Person("Nick",23, 1500);
		Person p2 = new Person("Nick",23, 1500);
		HashMap<String, Person> hMap = new HashMap<String, Person>();
		Set<String> keys;
		String keysString[];
		ArrayList <Person> listPerson = new ArrayList(); 
		
		
		
		if(p1.equals(p2)){
			System.out.println(p1.hashCode());
			System.out.println(p2.hashCode());
		}else{
			System.out.println("Not equal");
			System.out.println(p1.hashCode());
			System.out.println(p2.hashCode());
		}
		
        hMap.put(p1.name, p1);
        hMap.put(p2.name, p2);
        
        p2 = new Person("Jack",21, 1500);
        hMap.put(p2.name, p2);
        p2 = new Person("Mick",24, 1340);
        hMap.put(p2.name, p2);
        p2 = new Person("Mary",23, 1500);
        hMap.put(p2.name, p2);
        p2 = new Person("Liza",22, 1550);
        hMap.put(p2.name, p2);
        System.out.println();
        
        System.err.println("Get all keys and print them out");
        
       // keys=hMap.keySet();
        keysString = new String[hMap.size()];
       // keysString=(String[]) keys.toArray(); 
        int i =0;
        for(String str : hMap.keySet()){
        	keysString[i]=str;
        	i++;
        }
                
        for(i=0;i<keysString.length;i++){
        	System.out.print(keysString[i]+" ");
        }
        System.out.println();
        
        for(String k : hMap.keySet()){
        	System.out.println(k);
        }
       
       /* ArrayList <Person> listPerson = (ArrayList<Person>) hMap.values();
        Iterator<Person> itr = listPerson.iterator();
        
        Person tmp;
        while(itr.hasNext()){
        	tmp = itr.next();
        	System.out.print(tmp.getName() + ", age "+tmp.getAge()+", salary " + tmp.getSalary()+
        			", city "+tmp.adr.getCity()+", street "+tmp.adr.getStreet()+", house "+tmp.adr.getHouse());
        }*/
        
        System.err.println("Get all values and print them out without help of their keys");
        
        for(Person p : hMap.values()){
        	listPerson.add(p);
        }
        Iterator<Person> itr = listPerson.iterator();
        
        Person tmp;
        while(itr.hasNext()){
        	tmp = itr.next();
        	System.out.println(tmp.getName() + ", age "+tmp.getAge()+", salary " + tmp.getSalary()+
        			", city "+tmp.adr.getCity()+", street "+tmp.adr.getStreet()+", house "+tmp.adr.getHouse());
	    }
        System.out.println();
        
        for(Person p : hMap.values()){
        	System.out.println(p.getName() + ", age "+p.getAge()+", salary " + p.getSalary()+
        			", city "+p.adr.getCity()+", street "+p.adr.getStreet()+", house "+p.adr.getHouse());
        }
        System.out.println();
        
        System.err.println("Get all values and print them out with help of their keys");
               
        for(i=0;i<keysString.length;i++){
        	 tmp=hMap.get(keysString[i]);
        	 System.out.println(tmp.getName() + ", age "+tmp.getAge()+", salary " + tmp.getSalary()+
        			", city "+tmp.adr.getCity()+", street "+tmp.adr.getStreet()+", house "+tmp.adr.getHouse());
        }
	}
}
