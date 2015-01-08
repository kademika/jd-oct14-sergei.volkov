package day7.listsortBar17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> stringsList = new ArrayList();
		
		stringsList.add("Sergei Volkov");
		stringsList.add("Mariya Romanova");
		stringsList.add("Alex Bezlepkin");
		stringsList.add("Vladimir Derevianko");
		stringsList.add("Sergei Voschikov");
		stringsList.add("Mariya Derevianko");
		stringsList.add("Alexandr Popov");
		stringsList.add("Dmitriy Korotkih");
		stringsList.add("Petr Ivanov");
		stringsList.add("Ivan Petrov");
		
		Collections.sort(stringsList);
		
		for(String str : stringsList){
			System.out.println(str);
			}
		System.out.println();
		Collections.sort(stringsList, new StringsComparator());
		for(String str : stringsList){
			System.out.println(str);
			}
	}
}
