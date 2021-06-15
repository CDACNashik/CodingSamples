class ThreadTest1 {
	
	//private static String client;
	private static ThreadLocal<String> client = new ThreadLocal<>();

	private static void handleJob(int id) {
		/*
		System.out.printf("Accepted job<%d> for client<%s>%n", id, client);
		Worker.doWork(id);
		System.out.printf("Finished job<%d> for client<%s>%n", id, client);
		*/
		System.out.printf("Accepted job<%d> for client<%s>%n", id, client.get());
		Worker.doWork(id);
		System.out.printf("Finished job<%d> for client<%s>%n", id, client.get());
	}

	public static void main(String[] args) throws Exception {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 50;
		var child = new Thread(() -> {
			//client = "Jack";
			client.set("Jack");
			handleJob(n);
		});
		child.setDaemon(n > 80); //JVM does not wait for a background thread (whose daemon property is true) to exit
		child.start();
		//client = "Jill";
		client.set("Jill");
		handleJob(60);
	}
}

