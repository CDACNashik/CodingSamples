class MethodTest1 {

	//variadic method (has variable number of arguments)
	private static double average(double first, double second, double... other) {
		double total = first + second;
		for(double value : other)
			total += value;
		return total / (2 + other.length);

	}

	public static void main(String[] args) {
		System.out.printf("Average of two values = %f%n", average(23.4, 32.7));
		System.out.printf("Average of three values = %f%n", average(23.4, 32.7, 19.8));
		System.out.printf("Average of five values = %f%n", average(23.4, 32.7, 19.8, 36.3, 22.6));
	}

}


