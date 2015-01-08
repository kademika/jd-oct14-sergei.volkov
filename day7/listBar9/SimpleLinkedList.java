package day7.listBar9;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object>{
	private Node root;
	private int size;

	
		
	public SimpleLinkedList(){
		size = 0;
	}
	
	public void addFirst(Object obj){
		Node node = new Node();
		node.obj = obj;
		if(root != null){
			node.ref=root;
		}
		root = node;
		size++;
	}
	
		
	public void addLast(Object obj){
		Node node = new Node();
		Node tmp = root;
		Node last = root;
		
		node.obj = obj;
		if(root == null){
		  root = node;
		}else {
			
		    while (last.ref!=null){
		    	last=tmp;
		    	tmp=tmp.ref;
		    }
		    last.ref=node;
		}
		size++;
	}
	
	public void addAfter(Object obj, Object prev ){
		boolean found = false;
		
		Node node = new Node();
		node.obj = obj;
		if(root == null){
		  root = node;
		  found = true;
		}else{
			Node tmp = root;
			Node pointer = root;
		    do {
		     if(!pointer.obj.equals(prev)){
		    	pointer=tmp;
		    	tmp=tmp.ref;
		     }else{
		    	 if(tmp == root){
		    		 node.ref=root.ref;
		    		 root.ref=node;
		    		 
		       	 }else{
		    		//pointer=tmp.ref;
		          	node.ref=pointer.ref;
		    	    pointer.ref=node;
		          }
		    	 found = true;
		    	 break;
		    }
		   }
		  while (pointer.ref!=null);  
	   }
	  if(found){
		size++;
	  }else{
		  throw new IllegalStateException("The <previous> element for addAfter() operation was not found");
	  }
	}
	
	public void printList(){
		Node tmp = root;
		Node pointer = root;	
		 
		if(root!=null){
		   System.out.println();
		   System.out.print("{");
		   do{
				tmp=pointer;
				pointer=pointer.ref;
				System.out.print((String)tmp.obj+", ");
			 }
		   while (tmp.ref!=null);
		   System.out.println("}");
		   System.out.println();
	    }else{
			 System.out.println("The List is empty");
		 }
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	private class Node {
		  Object obj;
		  Node ref;
		}
	
	private class SLLIterator implements Iterator<Object>{
		Node pointer;
		Node previous;
		
		public SLLIterator(){
			}
		
		public boolean hasNext(){
			if((pointer == null && root!=null)||(pointer!=null && pointer.ref!=null)){
				return true;
			}return false;
		}
		
		public Object next(){
			
			if(pointer == null && root!=null){
				pointer = root;
				return pointer.obj;
			}else{
				if(hasNext()){
					previous = pointer;
					pointer = pointer.ref;
					return pointer.obj;
				}else{
					throw new IllegalStateException("The list has gone to the end");
				}
			}
		}

		
		@Override
		
		public void remove(){
			if(!hasNext() && previous==null){ // one element
				pointer = null;
				root = null;
			}else{
				if(!hasNext() && previous!=null){ // last element
					previous.ref = null;
					pointer = null;
				}else{
					
					if(hasNext() && previous==null){//first element after root
					  if(pointer==root){
						  root=pointer.ref;
						  pointer=root;
					  }else{
						root.ref=null;
						pointer=root;
					  }
					}else{// element is in the middle 
						previous.ref = pointer.ref;
					    pointer = previous.ref;
						
					}
				}
			}
			size--;
		}
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return new SLLIterator();
	}


}
