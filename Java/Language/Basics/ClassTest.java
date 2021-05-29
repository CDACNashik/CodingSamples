class Investment {

	private double amount;
	private short years;
	private boolean risk;

	//constructor
	public Investment(double p, short n) {
		amount = p;
		years = n;
		risk = false;
	}

	public void allowRisk(boolean yes) { //public static void allowRisk(Investment this, boolean yes)
		risk = yes; // this.risk = yes;
	}

	public double income() {
		float rate = risk ? 7.5f : 6.0f;
		return  amount * Math.pow(1 + rate / 100, years) - amount;
	}
}

class ClassTest {

	public static void main(String[] args) {
		double i = Double.parseDouble(args[0]);
		short y = Short.parseShort(args[1]);
		Investment inv = new Investment(i, y);
		System.out.printf("Income in Silver scheme = %.2f%n", inv.income());
		inv.allowRisk(true); //Investment.allowRisk(inv, true);
		System.out.printf("Income in Gold scheme = %.2f%n", inv.income());

	}
}

