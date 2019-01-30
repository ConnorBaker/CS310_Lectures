/**
 * Our expandable array class
 * generic: can hold any type
 */
 
public class MyArrayList<T>{

	// underlying array
	private T[] data;
	
	// how many items in data array currently
	private int size;
	
	// constructor
	// create an empty array of some default initial capacity	
	@SuppressWarnings("unchecked")
	public MyArrayList(){
		// data = new T[5];  // this will trigger compiler error
		// work around using Object array
		data = (T[])new Object[5];  
		size = 0;
	}
	
	// report how many items are stored
	// this also defines the range of "good" indexes 
	public int size(){
		return size;
	}


	
	// Add an element to the end 
	// double capacity if no more space	 		 
	@SuppressWarnings("unchecked")
	public void add(T x){
		// check capacity
		if (size == data.length){
			//double capacity
			T[] newData = (T[])new Object[size*2];
			
			//copy contents over
			for (int i=0;i<size;i++){
				newData[i] = data[i];
			}
			
			//update the reference
			data = newData;
			
		}

		// add x to the highest possible index	
		data[size]=x;
		size++;
		
					
	}
	
	private boolean isValidIndex(int i){
		return (i>=0 && i<size);
	}
	
	// return the item at index i
	public T get(int i){
		if (isValidIndex(i))
			return data[i];		//this simple???	
		else
			throw new RuntimeException("bad index");

	}
	
	// set/replace item at index i to be x	
	public void set(int i, T x){
		if (isValidIndex(i))
			data[i] = x;
		else
			throw new RuntimeException("bad index");				
	
	}
		
	
	// Insert x at position i, shift elements if necessary  
	@SuppressWarnings("unchecked")
	public void insert(int index, T x){
		// check index
		
		if (index==size)//appending
			this.add(x);
			
		else{
			//insertion
			if (isValidIndex(index)){
				//capacity
				if (size == data.length){
					//double capacity
					T[] newData = (T[])new Object[size*2];
			
					//copy contents over
					for (int i=0;i<size;i++){
						newData[i] = data[i];
					}
			
					data = newData;
				}
				
				//shifting
				for (int i=size;i>index;i--){  
					data[i] = data[i-1];
				}
				
				//put down x
				data[index]=x;
				size++;
			}
			else
				throw new RuntimeException("bad index");				
			
		}

	}
	
	/*
	// Remove and return element at position i
	// shift elements to remove the gap
	// Other variations: remove an item x?
	
	public T remove(int i){
		
	}  
	*/
	
	
	/*
	// search for x
	// return the index for its first occurence
	// return -1 if not found 
	// other variations: boolean contains()?
	// special case?
	
	public int indexOf(T x){
	
	}*/
	
	public String toString(){
		StringBuilder s = new StringBuilder("one MyArrayList with " + 
											size + " items:");
		for (int i=0; i<size(); i++)
			s.append("\n  ["+i+"]: "+data[i]);
		return s.toString();
		
	}

}

