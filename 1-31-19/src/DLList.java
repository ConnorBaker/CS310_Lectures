/* Example: doubly-linked list */

class DLList<T>{

	private class Node<T>{
		T value; //data storage
		Node<T> prev, next;	// two links
		
		// constructor
		public Node(T value){
			this.value = value;
			prev = next = null; //kind of default
		}

		// constructor that sets the two links
		public Node(T value, Node<T> p, Node<T> n){
			this.value = value;
			this.prev = p; //my predecessor
			this.next = n; //my successor
		}
	}
	
	private Node<T> headNode, tailNode; // always present, contains no data
	private int size;	// number of data items
	
	public DLList(){
		// initial setup for headNode, tailNode, size
		headNode = new Node<>(null);
		tailNode = new Node<>(null,headNode,null);
		headNode.next = tailNode;
		size = 0;		
	}
	
	// add a new item to the end
	public void append(T thing){
		// create a new node
		// add before the dummy tail node 
		Node<T> newNode = new Node<>(thing,tailNode.prev,tailNode);
		tailNode.prev.next = newNode;
		tailNode.prev = newNode;

		// update size
		size++;		
	}
	
	// print from head to tail
	public void printList(){
		System.out.println("DLList with "+size+" elements");
		Node<T> current = headNode;
		for (int i=0; i<size+1; i++){
			System.out.print("["+current.value+"]-->");
			current = current.next;
		}
		System.out.println("["+current.value+"]");
			
	}
	
	// print from tail to head	
	public void printReverseList(){
		System.out.println("DLList with "+size+" elements");
		System.out.println("Reverse order:");
		Node<T> current = tailNode;
		for (int i=0; i<size+1; i++){
			System.out.print("["+current.value+"]-->");
			current = current.prev;
		}
		System.out.println("["+current.value+"]");
	
	}

}