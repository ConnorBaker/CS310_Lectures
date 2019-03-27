/**
 * Demo of how to use / test MyLList
 */
class Demo{

	public static void main(String[] args){
		MyLList<Integer> intLL = new MyLList<Integer>();
		System.out.println("Initial: "+intLL);
						
		
		
		// append to the end of list
		
		for (int i=0; i<8; i++){
			intLL.append(i);
			//System.out.println(intLL);
		}
			
		System.out.println("---------------------");
		System.out.println("After appending: \n"+intLL);
		
		
		// get by index
		Integer i = intLL.get(3);
		System.out.println("get(3) returns: "+i);
		
		
		// search for items
		System.out.println("Index of 3: "+intLL.indexOf(3));
		System.out.println("Index of 100: "+intLL.indexOf(100));
		//System.out.println("Index of null: "+ intLL.indexOf(null));

		
		//remove by index
		System.out.println("---------------------");
		System.out.println("Remove index 2 returns "+intLL.remove(2));
		System.out.println("After removal: \n" + intLL);
		System.out.println("Remove index 0 returns "+intLL.remove(0));
		System.out.println("After removal: \n" + intLL);
		System.out.println("Remove index 5 returns "+intLL.remove(5));
		System.out.println("After removal: \n" + intLL);
		//System.out.println("Remove index 5 returns "+intLL.remove(10));

		
		/*
		MyLList<Integer> intLL2 = new MyLList<Integer>();
		intLL2.append(20);
		System.out.println("---------------------");
		System.out.println("Initial: "+intLL2);
		System.out.println("Remove index 0:"+intLL2.remove(0)); //remove the only node
		System.out.println("After removal: \n" + intLL2);
		

		/*
		// remove by value
		System.out.println("---------------------");
		System.out.println("Remove 100:"+intLL.remove(new Integer(100))); // no removal
		System.out.println("After removal: \n" + intLL);
		System.out.println("Remove 5:"+intLL.remove(new Integer(5))); //remove middle
		System.out.println("After removal: \n" + intLL);
		System.out.println("Remove 6:"+intLL.remove(new Integer(6))); //remove tail
		// System.out.println("Remove 6:"+intLL.remove(6)); //int or Integer argument
		System.out.println("After removal: \n" + intLL);
		*/

		/*MyLList<Integer> intLL2 = new MyLList<Integer>();
		intLL2.append(20);
		System.out.println("---------------------");
		System.out.println("Initial: "+intLL2);
		System.out.println("Remove 20:"+intLL2.remove(new Integer(20))); //remove the only node
		System.out.println("After removal: \n" + intLL2);
		
		System.out.println("Remove 20:"+intLL2.remove(new Integer(20)));// remove from an empty list
		System.out.println("After removal: \n" + intLL2);
		*/

		
		//switch location 3 and 5
		/*i = intLL.get(0);
		intLL.set(0, intLL.get(1));
		intLL.set(1,i);
		
		System.out.println("---------------------");
		System.out.println("After switching 0 and 1: \n"+intLL);
		
		
		


		// insert		
		intLL.insert(0,100);
		System.out.println("---------------------");
		System.out.println("After insert(0,100): \n"+intLL);
		intLL.insert(1,200);
		System.out.println("After insert(1,200): \n"+intLL);
		intLL.insert(intLL.size(),300);
		System.out.println("After insert(tailIndex,300): \n"+intLL);
		
		*/
		
	}
}