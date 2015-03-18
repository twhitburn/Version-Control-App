
public class SimpleQueue<E> implements QueueADT<E>  {

	E items[];
	int numItems;
	int frontIndex;
	int rearIndex; //First unused element
	private static final int INITSIZE = 10;

	@SuppressWarnings("unchecked")
	public SimpleQueue() {
		items = (E[])(new Object[INITSIZE]);
		numItems = 0;
		frontIndex = 0;
		rearIndex = 0;
	}

	public boolean isEmpty() {

		if (numItems <= 0) return true;
		return false;
	}

	public E dequeue() throws EmptyQueueException {

		if (numItems == 0) {
			throw new EmptyQueueException();
		}
		E temp = items[frontIndex];
		frontIndex++;
		numItems--;
		//need second thought here
		if (numItems == 0) {
			frontIndex = -1;
			rearIndex = 0;
		}
		return temp;
	}

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

	public E peek() throws EmptyQueueException {
		return items[frontIndex];
	}

	public int size() {
		return numItems;
	}

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
