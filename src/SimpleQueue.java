///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  VersionControlApp.java
// File:             SimpleQueue.java
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
 * Implements the QueueADT using a circular array.
 * <p>@author Thomas Whitburn & Haomin Li
 * 
 */
public class SimpleQueue<E> implements QueueADT<E>  {

	E items[];
	int numItems;
	int frontIndex;
	int rearIndex; //First unused element
	private static final int INITSIZE = 10;

	/**
	 * SimpleQueue constructor. Initializes to size 10.
	 */
	@SuppressWarnings("unchecked")
	public SimpleQueue() {
		items = (E[])(new Object[INITSIZE]);
		numItems = 0;
		frontIndex = -1;
		rearIndex = 0;
	}

	/**
	 * Checks if the Queue is empty.
	 * @return true iff the Queue is empty.
	 */
	public boolean isEmpty() {

		if (numItems <= 0) return true;
		return false;
	}

	/**
	 * Removes an item from the front of the Queue and returns it.
	 * @return item from front of Queue.
	 */
	public E dequeue() throws EmptyQueueException {

		if (numItems == 0) {
			throw new EmptyQueueException();
		}
		E temp = items[frontIndex];
		items[frontIndex] = null;
		frontIndex++;
		numItems--;
		//need second thought here
		if (numItems == 0) {
			frontIndex = -1;
			rearIndex = 0;
		}
		return temp;
	}

	/**
	 * Adds an item to the back of the Queue.
	 */
	@SuppressWarnings("unchecked")
	public void enqueue(E item) {

		if (numItems == items.length) {
			E tempitems[] = items;
			items = (E[])(new Object[2*INITSIZE]);
			for (int i = 0; i < tempitems.length; i++) {
				items[i] = tempitems[i];
				frontIndex = 0;
				rearIndex = numItems - 1;
			}
		}
		if (frontIndex == -1) {
			frontIndex = 0;
		}
		items[rearIndex] = item;
		//Increment rearIndex
		rearIndex++;
		if (rearIndex == items.length) {
			rearIndex = 0;
		}
		numItems++;
	}

	/**
	 * Return the item in front of the Queue without removing it.
	 * @return item in front of Queue.
	 */
	public E peek() throws EmptyQueueException {
		return items[frontIndex];
	}

	/**
	 * Returns the number of elements in the Queue.
	 * @return int value of number of items in Queue.
	 */
	public int size() {
		return numItems;
	}

	/**
	 * Return a string representation of the elements of the Queue in front to 
	 * back order with each element appended with a newline character. If the 
	 * Queue is empty, it simply returns an empty string.
	 * @return String representation of all items in Queue.
	 */
	@Override
	public String toString() {

		String temp = new String();

		for ( int i = frontIndex; i < rearIndex; i++) {
			temp = (temp + (items[i].toString() + "\n"));
			if (i == items.length) {
				i = -1;
			}
		}

		return temp;
	}

}
