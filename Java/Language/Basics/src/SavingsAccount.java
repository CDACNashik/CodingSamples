package banking;

final class SavingsAccount extends Account implements Profitable {

	//non-reassignable field
	final static double MIN_BAL = 5000;

	SavingsAccount() {
		balance = MIN_BAL;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if(balance - amount < MIN_BAL)
			throw new InsufficientFundsException();
		balance -= amount;
	}

	public double interest(int months) {
		double rate = balance < 4 * MIN_BAL ? MIN_RATE : 5;
		return balance * rate * months / 1200;
	}
}

