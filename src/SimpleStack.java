///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  VersionControlApp.java
// File:             SimpleStack.java
// Semester:         CS367 Spring 2015
//
// Author:           Thomas Whitburn
// CS Login:         whitburn
// Lecturer's Name:  Jim Skrentny
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     Haomin Li
// Email:            hli256@wisc.edu
// CS Login:         haomin
// Lecturer's Name:  Jim Skrentny
//
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Implements the StackADT using an array.
 * <p>@author Thomas Whitburn & Haomin Li
 * 
 */
public class SimpleStack<E> implements StackADT<E> {

	private E items[];
	int numItems;
	private static final int INITSIZE = 10;

	/**
	 * SimpleStack constructor. Initializes to size 10. 
	 *
	 */
	@SuppressWarnings("unchecked")
	public SimpleStack() {
		items = (E[])(new Object[INITSIZE]);
		numItems = 0;
	}

	/**
	 * Checks if the Stack is empty.
	 * @return true iff the Stack is empty.
	 */
	public boolean isEmpty() {
		if (numItems <= 0) return true;
		return false;
	}

	/**
	 * Returns the item on top of the Stack without removing it. 
	 * @return item from top of Stack.
	 */
	public E peek() throws EmptyStackException {
		return items[numItems-1];
	}

	/**
	 * Removes an item from the top of the Stack and returns it. 
	 * @return item from top of Stack.
	 */
	public E pop() throws EmptyStackException {
		//Check if empty
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		//Decrement numItems
		numItems--;
		//Return popped item
		return items[numItems];
	}

	/**
	 * Adds an item to the top of the Stack. 
	 * @param item item to be put in Stack.
	 */
	@SuppressWarnings("unchecked")
	public void push(E item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (items.length == numItems) {
			E tempitems[] = items;
			items = (E[])(new Object[2*INITSIZE]);
			for (int i = 0; i < tempitems.length; i++) {
				items[i] = tempitems[i];
			}
		}
		//Set last item
		items[numItems] = item;
		//Increment numItems
		numItems++;
	}

	/**
	 * Returns the number of elements in the Stack.
	 * @return int value of number of elements in Stack.
	 */
	public int size() {
		return numItems;
	}

	/**
	 * Return a string representation of the elements of the Stack in top to
	 * bottom order with each element appended with a newline character. If the 
	 * Stack is empty, it simply returns an empty string.
	 * @return string of all elements in Stack.
	 */
	@Override
	public String toString() {
		String temp = new String();

		for ( int i = numItems-1; i >= 0; i--) {
			temp = (temp + (items[i].toString() + "\n"));
		}

		return temp;

	}

}
