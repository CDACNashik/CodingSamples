import java.util.*;

class MapTest {

	public static void main(String[] args) {
		var store = //new HashMap<String, Interval>();
			    new TreeMap<String, Interval>();
		store.put("Monday", new Interval(5, 31));
		store.put("Tuesday", new Interval(3, 42));
		store.put("Wednesday", new Interval(7, 23));
		store.put("Thursday", new Interval(6, 14));
		store.put("Friday", new Interval(4, 25));
		store.put("Monday", new Interval(2, 51));
		for(var i : store.entrySet())
			System.out.printf("%-16s%s%n", i.getKey(), i.getValue());
		Scanner input = new Scanner(System.in);
		System.out.print("Key: ");
		String key = input.next();
		Interval val = store.get(key);
		if(val != null)
			System.out.printf("Value = %s%n", val);
		else
			System.out.println("No such key!");
		
	}
}

