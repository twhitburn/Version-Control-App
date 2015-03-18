
public class SimpleQueue<E> implements QueueADT<E>  {

	E items[];
	int numItems;
	int frontIndex;
	int rearIndex;
	private static final int INITSIZE = 10;

	public SimpleQueue() {
		
	}
	
	public boolean isEmpty() {
		if (numItems <= 0) return true;
		return false;
	}

	public E dequeue() throws EmptyQueueException {
		// TODO
		return null;
	}

	public void enqueue(E item) {
		// TODO

	}

	public E peek() throws EmptyQueueException {
		// TODO
		return null;
	}

	public int size() {
		return numItems;
	}
	
	@Override
	public String toString() {
		return null;
	}

}
