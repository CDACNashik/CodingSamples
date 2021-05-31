package payroll;

public class SalesPerson extends Employee {

	private double sales;

	public SalesPerson(int h, float r, double s) {
		super(h, r); // calling superclass (Employee) constuctor
		sales = s;
	}

	public double getSales() { return sales; }

	//overriding income method of superclass
	public double income() {
		double amount = super.income(); //calling income of Employee
		if(sales >=10000)
			amount += 0.05 * sales;
		return amount;
	}
}

