interface ResourceConsumer {

	//abstract method - subtypes will provide implementation
	void apply(int action);

	//default method - subtypes can provide alternate implementation
	default void applyAll(int count) {
		for(int i = 1; i <= count; ++i)
			apply(i);
	}
}

class SomeResource implements ResourceConsumer, AutoCloseable {

	private String name;

	static { //static initializer is invoked once when this class is used for the first time
		System.out.println("SomeResource class initialized.");
	}

	public SomeResource(String id) {
		name = id;
		System.out.printf("%s resource acquired%n", name);
	}	

	public void apply(int action) {
		if(name != null)
			System.out.printf("action %d performed on %s resource%n", action, name);
	}

	public void close() {
		System.out.printf("releasing %s resource%n", name);
		name = null;
	}
}


class InterfaceTest2 {

	private static void run(String limit) {
		/*
		var c = new SomeResource("third");
		try{
			c.applyAll(Integer.parseInt(limit));
		}finally{
			c.close();
		}
		*/
		try(var c = new SomeResource("third")){
			c.applyAll(Integer.parseInt(limit));
		}
	}

	public static void main(String[] args) {
		var a = new SomeResource("first");
		a.apply(1);
		var b = new SomeResource("second");
		b.apply(2);
		a.close();
		b.close();
		try{
			run(args[0]);
		}catch(Exception e){}
	}
}

