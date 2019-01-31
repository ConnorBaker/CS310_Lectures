/**
 * A generic, expandable array.
 * @author Connor Baker
 * CS 310
 * Spring 2019
 */

public class MyArrayList<T> {
    /**
     * The default is 5 so that we can ensure our {@link #add(Object)} can correctly resize
     * the underlying data structure.
     */
    private static final int DEFAULT_SIZE = 5;

    private static final String INVALID_INDEX = "Invalid Index";

    private static final int NOT_FOUND = -1;

    /**
     * The underlying data structure.
     */
    private T[] data;

    /**
     * Holds the current number of used spaces in {@link #data}.
     */
    private int size;

    /**
     * No argument constructor.
     * The default size is {@value DEFAULT_SIZE}.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // By casting an array of Object we can get around the creation of generic arrays being
        // forbidden
        data = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Returns the number of items in an array.
     * @return The number of items currently in the array
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of the list. Doubles the capacity if there is no more space.
     * @param x The element to be added
     * @throws IllegalArgumentException if {@code x} is null
     */
    public void add(final T x) {
        if (x == null) {
            throw new IllegalArgumentException();
        }

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

    /**
     * Return the item at the specified index.
     * @param i The index to retrieve from
     * @return The value found at the index
     * @throws ArrayIndexOutOfBoundsException If the index is not valid.
     */
    public T get(final int i) {
        if (this.isValidIndex(i)) {
            return data[i];
        } else {
            throw new ArrayIndexOutOfBoundsException(INVALID_INDEX);
        }
    }

    /**
     * Set or replace the item at the specified index to/with the parameter.
     * @param i The index to set.
     * @param x The value to set the index to.
     * @throws IllegalArgumentException if {@code x} is null.
     */
    public void set(final int i, final T x) {
        if (x == null) {
            throw new IllegalArgumentException();
        }

        if (this.isValidIndex(i)) {
            data[i] = x;
        } else {
            throw new ArrayIndexOutOfBoundsException(INVALID_INDEX);
        }
    }

    /**
     * Inserts an item at an index, shifting elements to the right.
     * @param index The index to insert the item at.
     * @param x The item to be inserted.
     * @throws IllegalArgumentException if {@code x} is null.
     */
    @SuppressWarnings("unchecked")
    public void insert(final int index, final T x) {
        if (x == null) {
            throw new IllegalArgumentException();
        }

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

    /**
     * Removes and returns an element at the given index. Shifts elements to remove the gap created.
     * @param i The index.
     * @return The item removed.
     */
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

    /**
     * Searches for an item, returning the index if it is found, or {@value NOT_FOUND} if it is not
     * found.
     * @param x The item to locate.
     * @return The index of the item, or {@value NOT_FOUND} if it is not found.
     */
	public int indexOf(final T x){
        int i = 0;
        while (i < size && !(data[i].equals(x))) {
            i++;
        }

        return (i < size) ? i : NOT_FOUND;
	}

    /**
     * Converts the list to a string.
     * @return The array formatted as [i] get(i)
     */
    public String toString() {
        final var s = new StringBuilder("one MyArrayList with " + size + " items:");

        for (int i = 0; i < size; i++) {
            s.append("\n  [").append(i).append("]: ").append(data[i]);
        }

        return s.toString();
    }

}

