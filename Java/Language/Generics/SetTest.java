import java.util.*;

class SetTest {

	//inner nested(static) member class
	static class IntervalComparison implements Comparator<Interval> {
		public int compare(Interval x, Interval y) {
			return x.seconds() - y.seconds();
		}
	}

	public static void main(String[] args) {
		var store = //new HashSet<Interval>();
			    //new TreeSet<Interval>();
			    new TreeSet<Interval>(new IntervalComparison());
		store.add(new Interval(5, 31));
		store.add(new Interval(3, 42));
		store.add(new Interval(7, 23));
		store.add(new Interval(6, 14));
		store.add(new Interval(4, 25));
		store.add(new Interval(4, 91));
		for(var i : store)
			System.out.println(i);
	}
}

