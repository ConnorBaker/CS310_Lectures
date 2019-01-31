/* class for our nodes */
class Node {
	String data;
	Node next;
}

class LList {
	Node head;
	/* implementations of set/get/add/remove/... */
}

/* let's play with the nodes */
// create some nodes, assemble them in a linked list
// check/print the list, etc...

class Test {
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.data = "hello world";
		
		Node n2 = new Node();
		n2.data = "goodbye world";
		
		n1.next = n2;
		
		//Node n3 = new Node();
		//n3.data = "hello again";
		//n2.next = n3; //n1.next.next = n3; // add to the end
		n2 = new Node();
		n2.data = "hello again";
		n2.next = n1.next;
		n1.next = n2;
				
		Node current = n1; //first item in list
		while (current!=null){
			// do sth to every Node
			System.out.println(current.data);
			
			// move to the next Node
			current = current.next;
		}

	}
}






