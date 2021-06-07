class SimpleStack<V> {

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
}



class GenClassTest {

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		//a.push(2021);
		SimpleStack<Double> b = new SimpleStack<>();
		b.push(5.71);
		b.push(7.42);
		b.push(6.53);
		b.push(4.95);
		SimpleStack<Interval> c = new SimpleStack<>();
		c.push(new Interval(5, 21));
		c.push(new Interval(4, 12));
		c.push(new Interval(7, 43));
		c.push(new Interval(3, 54));
		c.push(new Interval(6, 35));
		while(!a.empty())
			System.out.println(a.pop());
		System.out.println("-----------------------");
		while(!b.empty())
			System.out.println(b.pop());
		System.out.println("-----------------------");
		while(!c.empty())
			System.out.println(c.pop());
	}
}


