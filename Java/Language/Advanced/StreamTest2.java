import java.util.ArrayList;

//record type - it is a class which produces immutable value objects (whose state cannot be modified after initialization).
//Java (16 onwards) compiler automatically generates the class for a record type which contains final fields,
//constructor for initializing their values, methods for getting their values and overrides for
//hashCode, equals and toString() methods.
record Seller(String name, int sold, int rating) implements Comparable<Seller> {
	
	public int compareTo(Seller that) {
		return this.name.compareTo(that.name);
	}
}

class StreamTest2 {

	public static void main(String[] args) {
		int min = args.length > 0 ? Integer.parseInt(args[0]) : 0;
		var store = new ArrayList<Seller>();
		store.add(new Seller("Newton", 3000, 2));
		store.add(new Seller("Pascal", 5000, 4));
		store.add(new Seller("Maxwell", 6000, 5));
		store.add(new Seller("Euler", 9000, 4));
		store.add(new Seller("Plank", 2000, 3));
		store.add(new Seller("Bohr", 7000, 1));
		store.stream()
			.filter(s -> s.sold() >= min)
			.sorted()
			.map(s -> s.name() + "\t" + s.sold() + "\t" + "*".repeat(s.rating()))
			.forEach(System.out::println);
	}
}

