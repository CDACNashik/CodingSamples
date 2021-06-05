class AutoBoxTest {

	/*
	public static String select(int count, String first, String second) {
		if((count % 2) == 1)
			return first;
		return second;
	}

	public static double select(int count, double first, double second) {
		if((count % 2) == 1)
			return first;
		return second;
	}
	*/

	//recurring code pattern which works with different refrence types
	public static Object select(int count, Object first, Object second) {
		if((count % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) {
		/*
		double v = 9.75;
		Double w = v; //Double.valueOf(v);
		double x = w; //w.doubleValue();
		Object y = x; //Double.valueOf(x);
		double z = (double)y; // ((Double)y).doubleValue()
		*/
		int n = Integer.parseInt(args[0]);
		//String ss = select(n, "Monday", "Friday");
		String ss = (String)select(n, "Monday", "Friday");
		System.out.printf("Selected String = %s%n", ss);
		//double sd = select(n, 5.76, 4.32);
		double sd = (double)select(n, 5.76, 4.32); //automatic boxing for arguments and unboxing for result
		System.out.printf("Selected double = %s%n", sd);
		if(n > 50){
			Interval si = (Interval)select(n, new Interval(3, 20), "2:30");
			System.out.printf("Selected Interval = %s%n", si);
		}

	}
}

