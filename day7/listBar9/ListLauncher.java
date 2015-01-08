package day7.listBar9;

import java.util.Iterator;

public class ListLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleLinkedList myList = new SimpleLinkedList();
		System.err.println("AddFirst, AddLast operations:");
		myList.addFirst("Object 1");
		myList.addLast("Object 3");
		myList.addFirst("Object 0");
		myList.printList();
		myList.addLast("Object 0");
		myList.printList();
		System.err.println("AddAfter operations:");
		
		myList.addAfter("Object 2","Object 1");
		myList.printList();
		myList.addAfter("Object 4","Object 3");
		myList.printList();
		
	   // System.err.println("Check exception: AddAfter absent element");
		//myList.addAfter("Object 1","Object 5");
		//myList.printList();
		
		System.err.println("Check Iterator: hasNext() and next()");
		Iterator<Object> itr = myList.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			System.out.println(obj);
		}
		itr.remove();
		myList.printList();
		
		itr = myList.iterator();
		itr.next();
		
		itr.remove();
		myList.printList();
		itr.next();
		itr.remove();
		myList.printList();
	}

}
