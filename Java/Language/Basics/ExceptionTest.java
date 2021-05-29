enum RiskLevel {
	NONE, LOW, HIGH;
}

class Investment {

	private double amount;
	private short years;
	private RiskLevel risk;

	public Investment(double p, short n) {
		if(p < 10000)
			throw new IllegalArgumentException("Insufficient amount");
		amount = p;
		years = n;
		risk = RiskLevel.NONE;
	}

	public void allowRisk(boolean yes) { 
		risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
	}

	public void adjustRisk(RiskLevel level) {
		risk = level;
	}

	public double income() {
		float rate;
		switch(risk) {
			case LOW:
				rate = 7.5f;
				break;
			case HIGH:
				rate = 8.5f;
				break;
			default:
				rate = 6.0f;
		}
		return  amount * Math.pow(1 + rate / 100, years) - amount;
	}
}

class ExceptionTest {

	public static void main(String[] args) {
		try {
			double i = Double.parseDouble(args[0]);
			short y = Short.parseShort(args[1]);
			Investment inv = new Investment(i, y);
			System.out.printf("Income in Silver scheme = %.2f%n", inv.income());
			inv.allowRisk(true);
			System.out.printf("Income in Gold scheme = %.2f%n", inv.income());
			inv.adjustRisk(RiskLevel.HIGH);
			System.out.printf("Income in Platinum scheme = %.2f%n", inv.income());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("USAGE: java ExceptionTest amount-value period-value");
		} catch(Exception e) {
			System.out.printf("ERROR: %s%n", e.getMessage());
		}

	}
}

