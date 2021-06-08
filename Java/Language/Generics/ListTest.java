import java.util.*;

class ListTest {

	public static void main(String[] args) {
		var store = //new ArrayList<Interval>();
			    new LinkedList<Interval>();
		store.add(new Interval(5, 31));
		store.add(new Interval(3, 42));
		store.add(new Interval(7, 23));
		store.add(new Interval(6, 14));
		store.add(new Interval(4, 25));
		store.add(new Interval(4, 91));
		for(var i : store)
			System.out.println(i);
		System.out.printf("Third Interval = %s%n", store.get(2));
	}
}

