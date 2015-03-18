
public class Test {

	public static void main(String[] args) {

		SimpleStack<Integer> stack = new SimpleStack<Integer>();
		
		if (stack.isEmpty()) System.out.println("Empty Stack.");
		System.out.println("There are " + stack.numItems + " items." );
		for (int i = 0; i < 16; i++ ) {
			stack.push(i);
			try {
				System.out.println(stack.peek());
			} catch (EmptyStackException e) {
				System.out.println("Empty!");
			}
		}
		System.out.println("Put integers 0-15 in.");
		System.out.println("There are " + stack.numItems + " items." );
		System.out.println("toString call:");
		System.out.print(stack.toString());
		System.out.println("Taking out items...");
		try {
			for(int i = 0; i < 20; i++) {
				stack.pop();
			}
		} catch (EmptyStackException e) {
			System.out.println("Empty!");
		}
		finally {
			System.out.println("Took all out");
			System.out.println("There are " + stack.numItems + " items. \n \n");
		}
		
		
		
		
		
		
		
		
SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
		
		if (queue.isEmpty()) System.out.println("Empty Queue.");
		System.out.println("There are " + queue.numItems + " items." );
		for (int i = 0; i < 16; i++ ) {
			queue.enqueue(i);
		}
		System.out.println("Put integers 0-15 in.");
		System.out.println("There are " + queue.numItems + " items." );
		System.out.println("toString call:");
		System.out.print(queue.toString());
		System.out.println("Taking out items...");
		try {
			for(int i = 0; i < 20; i++) {
				queue.dequeue();
			}
		} catch (EmptyQueueException e) {
			System.out.println("Empty!");
		}
		finally {
			System.out.println("Took all out");
			System.out.println("There are " + queue.numItems + " items.");
		}
	}

}
