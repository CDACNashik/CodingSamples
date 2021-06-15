class JointAccount {

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		Worker.doWork(amount / 500);
		balance += amount;
	}

	public boolean withdraw(int amount) {
		boolean success = false;
		synchronized(this){
			if(balance >= amount){
				Worker.doWork(amount / 500);
				balance -= amount;
				success = true;
			}
		}
		return success;
	}
}


class ThreadTest2 {

	public static void main(String[] args) throws Exception {
		var acc = new JointAccount();
		acc.deposit(5000);
		System.out.println("Joint account opened for Jack and Jill");
		System.out.printf("Initial Balance = %d%n", acc.getBalance());
		var child = new Thread(() -> {
			System.out.println("Jack is withdrawing 3000 from joint-account...");
			if(acc.withdraw(3000) == false)
				System.out.println("Jack's withdraw operation failed!");
		});
		child.start();
		System.out.println("Jill is withdrawing 4000 from joint-account...");
		if(acc.withdraw(4000) == false)
			System.out.println("Jill's withdraw operation failed!");
		child.join(); // wait for child thread to exit
		System.out.printf("Final Balance = %d%n", acc.getBalance());
	}
}


