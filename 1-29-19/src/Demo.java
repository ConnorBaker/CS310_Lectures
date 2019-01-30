/**
 * Demo of how to use / test MyArrayList
 */
class Demo{

	public static void main(String[] args){
		MyArrayList<Integer> intAL = new MyArrayList<Integer>();
		System.out.println("Initial: "+intAL);
		
		//System.out.println(intAL.get(3));
		
		for (int i=0; i<8; i++)
			intAL.add(i);
			
		System.out.println("---------------------");
		System.out.println("After add: "+intAL);
		
		
		//switch location 3 and 5
		Integer i = intAL.get(3);
		intAL.set(3, intAL.get(5));
		intAL.set(5,i);

		System.out.println("---------------------");
		System.out.println("After switching 3 and 5: " + intAL);
		//intAL.set(100,200);
		
		
		// insert		
		intAL.insert(0,100);
		intAL.insert(3,200);
		intAL.insert(intAL.size(),300);
		
		System.out.println("---------------------");
		System.out.println("After three insertions: " + intAL);


		/*
		// remove
		System.out.println("---------------------");
		System.out.println("Removed:"+intAL.remove(0));
		System.out.println("Removed:"+intAL.remove(5));
		System.out.println("After two removals: " + intAL);

		/*
		// search for items
		System.out.println(intAL.indexOf(3));
		System.out.println(intAL.indexOf(100));
		//System.out.println(intAL.indexOf(null));
		
		*/
		
	}
}