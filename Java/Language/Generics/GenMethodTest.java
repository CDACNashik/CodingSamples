class GenMethodTest {

	//type-safe recurring code pattern with type-argument T
	public static<T> T select(int count, T first, T second) {
		if((count % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		String ss = select(n, "Monday", "Friday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = select(n, 5.76, 4.32);
		System.out.printf("Selected double = %s%n", sd);
		if(n > 50){
			//Interval si = select(n, new Interval(3, 20), "2:30");
			Interval si = select(n, new Interval(3, 20), new Interval(2, 30));
			System.out.printf("Selected Interval = %s%n", si);
		}

	}
}

