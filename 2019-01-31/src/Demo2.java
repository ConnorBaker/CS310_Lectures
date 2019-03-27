class Demo2{
	public static void main(String[] args){
		DLList<String> sDLList = new DLList<String>();
		sDLList.printList();
		
		sDLList.append("Richmond");
		sDLList.append("Norfolk");
		sDLList.append("Virginia Beach");
		sDLList.append("Hampton");
		System.out.println("---------------");
		System.out.println("After appending:");
		sDLList.printList();
		System.out.println("---------------");
		sDLList.printReverseList();
		
	}

}