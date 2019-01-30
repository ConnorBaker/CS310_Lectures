/**
 * Our expandable array class
 * generic: can hold any type
 */

public class MyArrayList<T> {
    // Constants used by the class
    private static final int DEFAULT_SIZE = 5;
    private static final String INVALID_INDEX = "Invalid Index";
    // Our data structure is a fixed size array
    private T[] data;
    // The current number of items in our array
    private int size;

    // Create an initial array of some default capacity
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // By casting an array of Object we can get around the creation of generic arrays being
        // forbidden
        data = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    // Returns the number of items currently in the array
    // This also defines the range of valid indices [0, size)
    public int size() {
        return size;
    }

    // Adds an element to the end of the list
    // Double the capacity if there is no more space
    public void add(final T x) {
        if (size == data.length) {
            this.doubleSize();
        }

        // Insert x after all the currently stored items
        data[size] = x;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void doubleSize() {
        // Double the capacity of the array
        final T[] newData = (T[]) new Object[size * 2];

        // Copy the contents to the new array
        System.arraycopy(data, 0, newData, 0, size);

        // Update the reference the the new array
        data = newData;
    }

    private boolean isValidIndex(final int i) {
        return (0 <= i && i < size);
    }

    // Return the item at index i
    public T get(final int i) {
        if (this.isValidIndex(i)) {
            return data[i];
        } else {
            throw new ArrayIndexOutOfBoundsException(INVALID_INDEX);
        }

    }

    // Set or replace the item at index i to/with x
    public void set(final int i, final T x) {
        if (this.isValidIndex(i)) {
            data[i] = x;
        } else {
            throw new ArrayIndexOutOfBoundsException(INVALID_INDEX);
        }
    }

    // Insert x at position i, shifting elements if necessary
    @SuppressWarnings("unchecked")
    public void insert(final int index, final T x) {
        if (index == size) { // We can reuse the add function we wrote if we're appending
            this.add(x);
        } else {
            if (this.isValidIndex(index)) {
                if (size == data.length) {
                    // Double the capacity of the array
                    final T[] newData = (T[]) new Object[size * 2];

                    // Copy the contents to the new array
                    System.arraycopy(data, 0, newData, 0, index);
                    System.arraycopy(data, index, newData, index + 1, size - index);

                    // Update the reference the the new array
                    data = newData;
                } else {
                    // Move the data after the index one space over and fill in the gap
                    System.arraycopy(data, index, data, index + 1, size - index);
                }

                // Fill in the gap we created in moving things to make space
                data[index] = x;
                size++;
            } else {
                throw new ArrayIndexOutOfBoundsException(INVALID_INDEX);
            }
        }
    }

	// Remove and return element at position i
	// shift elements to remove the gap
	// Other variations: remove an item x?
	public T remove(final int i){
        final T ret;

        if (this.isValidIndex(i)) {
            ret = data[i];
            System.arraycopy(data, i+1, data, i, size - (i + 1));
        } else {
            throw new ArrayIndexOutOfBoundsException(INVALID_INDEX);
        }

        size--;
        return ret;
	}


	// search for x
	// return the index for its first occurrence
	// return -1 if not found 
	// other variations: boolean contains()?
	// special case?
	
	public int indexOf(final T x){
        final int NOT_FOUND = -1;

        int i = 0;
        while (i < size && !(data[i].equals(x))) {
            i++;
        }

        return (i < size) ? i : NOT_FOUND;
	}

    public String toString() {
        final var s = new StringBuilder("one MyArrayList with " + size + " items:");

        for (int i = 0; i < size; i++) {
            s.append("\n  [").append(i).append("]: ").append(data[i]);
        }

        return s.toString();
    }

}

