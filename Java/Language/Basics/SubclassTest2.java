import payroll.Employee; //now compiler will expand Employee to payroll.Employee
import payroll.SalesPerson;

class SubclassTest2 {

	private static double averageIncome(Employee[] group) {
		double total = 0;
		for(Employee member : group){
			total += member.income();
		}
		return total / group.length;
	}

	private static double totalSales(Employee[] group) {
		double total = 0;
		for(Employee member : group){
			if(member instanceof SalesPerson){
				SalesPerson sp = (SalesPerson) member; //explicit conversion (using cast operator) from superclass to subclass
				total += sp.getSales();
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Employee[] department = new Employee[5];
		department[0] = new Employee(186, 52);
		department[1] = new Employee(175, 95);
		department[2] = new SalesPerson(190, 55, 65000); //implicit conversion from subclass(rhs) to superclass(lhs) required by LSP
		department[3] = new Employee(200, 150);
		department[4] = new SalesPerson(165, 45, 35000);
		System.out.printf("Average income = %.2f%n", averageIncome(department));
		System.out.printf("Total sales = %.2f%n", totalSales(department));
	}
}

