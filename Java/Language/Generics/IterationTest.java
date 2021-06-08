import java.util.Iterator;

class SimpleStack<V> implements Iterable<V> {

	Node top;

	//inner member class
	class Node {

		V value;
		Node below;

		Node(V val) {
			value = val;
			below = top;
		}
	}

	public void push(V val) {
		top = new Node(val);
	}

	public V pop() {
		V val = top.value;
		top = top.below;
		return val;
	}

	public boolean empty() {
		return top == null;
	}

	public Iterator<V> iterator() {
		//int hit = 0; //any local variable of this method referenced from its inner class is effectively final
		//creating a new instance of an inner local anonymous class (closure) which implements Iterator<V>
		return new Iterator<V>() {

			Node current = top;

			public boolean hasNext() {
				//int n = hit; // a final copy of hit variable of outer method
				return current != null;
			}

			public V next() {
				V val = current.value;
				current = current.below;
				return val;
			}
		};
	}
}



class IterationTest {

	public static void main(String[] args) {
		String[] a = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		for(String s : a)
			System.out.println(s);
		System.out.println("-----------------");
		SimpleStack<Interval> b = new SimpleStack<>();
		b.push(new Interval(5, 21));
		b.push(new Interval(4, 12));
		b.push(new Interval(7, 43));
		b.push(new Interval(3, 54));
		b.push(new Interval(6, 35));
		for(Interval i : b)
			System.out.println(i);
		//for(Interval i : b)
		//	System.out.println(i);
	}
}


