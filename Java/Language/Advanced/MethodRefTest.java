//functional interface - an interface containing exactly one abstract method 
//which supports implicit conversion from a reference to a method compatiable 
//(matching return and parameter types) with its abstract method
interface InterestRate {
	float forPeriod(int years);
}

class Investment {

	private double amount;
	private int duration;

	public Investment(double amount, int duration) {
		this.amount = amount;
		this.duration = duration;
	}

	public double income(InterestRate rate) {
		float r = rate.forPeriod(duration);
		double cash = amount * Math.pow(1 + r / 100, duration);
		return cash - amount;
	}

}


class MethodRefTest {

	private static float goldScheme(int y) {
		return 8 + 0.1f * y;
	}

	private float silverScheme(int y) {
		return y < 3 ? 6 : 7;
	}

	public static void main(String[] args) {
		var input = new java.util.Scanner(System.in);
		System.out.print("Amount and Duration: ");
		double a = input.nextDouble();
		int d = input.nextInt();
		var inv = new Investment(a, d);
		System.out.printf("Income in Gold Scheme: %.2f%n", inv.income(MethodRefTest::goldScheme)); //passing static method reference
		System.out.printf("Income in Silver Scheme: %.2f%n", inv.income(new MethodRefTest()::silverScheme)); //passing instance (non-static) method reference
	}
}

