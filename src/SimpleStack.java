
public class SimpleStack<E> implements StackADT<E> {

	private E items[];
	int numItems;
	private static final int INITSIZE = 10;

	public SimpleStack() {
		items = (E[])(new Object[INITSIZE]);
		numItems = 0;
	}

	public boolean isEmpty() {
		if (numItems <= 0) return true;
		return false;
	}

	public E peek() throws EmptyStackException {
		return items[numItems-1];
	}

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

	public void push(E item) {
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

	public int size() {
		return numItems;
	}

	@Override
	public String toString() {
		String temp = new String();

		for ( int i = numItems-1; i >= 0; i--) {
			temp = (temp + (items[i].toString() + "\n"));
		}

		return temp;

	}

}
