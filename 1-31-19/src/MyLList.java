/**
 * our singly-linked list class 
 * generic: can hold any item
 */

class MyLList<T> {
	
	/* class for the internal node */
	/* not visible to the outside */
	
	private class Node<T>{
		T value;		// data to store
		Node<T> next;	// link to the next node
		
		public Node(T value){
			this.value = value;
			this.next = null;  //can we omit this?
		}
	}
	
	
	private Node<T> head;  	// first node
	private Node<T> tail;  	// last node
	private int size=0;		// how many nodes
	// Think: redundant info? yes or no?
	
	// how many nodes are there?
	public int size(){
		return size;
	}
	
	// add a new node to the end of the linked list to hold thing
	public void append(T thing){
		// create a node for thing
		Node<T> toAdd = new Node<T>(thing);
		
		// add it to the end of the linked list
		if (size==0){
			//first item
			head = toAdd;
		}
		else{
			tail.next = toAdd;
		}
		tail = toAdd;

		// any other maintenance needed?
		size++;
		
	}
	
	
	
	// return item at location index
	public T get(int index){
		//check index
		if (index<0 || index>=size)
			throw new RuntimeException();
			//return null
			
		//valid index: grab the item to return
		Node<T> current = head;
		for (int i = 0; i<index; i++){
			current = current.next;
		}

		return current.value;
	}
	

	
	// return index of an item
	public int indexOf(T thing){
		Node<T> current = head;
		for (int i = 0; i<size; i++){
			if (current.value.equals(thing))
				return i;
			current = current.next;
		}
	
		return -1;
	}
	 

	
	// given a thing, remove the first occurrence of that thing
	// return true/false if succeed/fail
	// variations: return the original index
	public boolean remove(T thing){
		// find the first index of thing
		int index = this.indexOf(thing);
		
		if (index==-1)
			return false;

		this.remove(index);
		return true;
		// remove that index
		// code reuse!

	}
	
	// remove item at the given index from the linked list
	// return that item
	public T remove(int index){
	
		// important steps?
		// different situations to consider?
		T toReturn=null;
		
		// check index
		if (index<0 || index>=size)
			throw new RuntimeException();
			//return null

		// remove from beginning
		if (index == 0){
			toReturn = head.value;
			head = head.next;
			if (size==1)
				tail = null;
		}
		else{
			Node<T> previous = head;
			Node<T> current = previous.next;
			for (int i = 0; i< index-1; i++){
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			toReturn = current.value;
			
			if (index==size-1){
				tail = previous;
			}
		
		}
		size--;
		return toReturn;
	}
	
	/*	
	// set/replace item at location index
	public void set(int index, T thing){

	}
	*/
	
	/* 
	//insert by an index 
	public void add(int index, T thing){

	}
	*/
	
	
	public void printList() {
		Node<T> current = head;
		while(current != null) {
			//do something with current
			System.out.println(current.value);
			
			//go to next node
			current = current.next;
		}
	}

	// return a string representation
	public String toString(){
		StringBuilder s = new StringBuilder("a MyLList with " + 
											size() + " items:");
		if (size>0){
			Node<T> current = head;
			int index = 0;
			while (current!=null){
				s.append(" ["+current.value+"]-->");
				current = current.next;
				index ++;
				if (index % 8 == 0){
					s.append("\n");
				}
			}
			s.append(" null");
			s.append("\nhead-->["+head.value+"]\n");
			s.append("tail-->["+tail.value+"]\n");

		}
		else{
			if (head == null)
				s.append("\nhead-->null\n");
			if (tail == null)
				s.append("tail-->null\n");
		}
		
		return s.toString();
		
	}
	

}